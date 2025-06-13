/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Security;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import LinkedInventoryManagement.PersistentStorage.UsersOperations;

import java.io.FileWriter;

/**
 * InventoryManagementSecurity
 */
public class SecurityOperations 
{
    //TODO Add data fields, constructors and methods as needed. Consider implementing Comparable for the User class.
    public static User AuthenticateUser(String username, String password)
    {
        User authenticatedUser = null;

        if((username.compareToIgnoreCase("admin") == 0) && 
           (GetPasswordHash(password).compareToIgnoreCase("58c536ed8facc2c2a293a18a48e3e120") == 0))
        {
            authenticatedUser = new User(username, GetPasswordHash(password), true); 
        }
        else
        {
        	password = GetPasswordHash(password);
        	authenticatedUser = UsersOperations.verifyUser(username, password);
            //TODO get the password hash using GetPasswordHash() method then try to find the user in Users.dat file
            //TODO set the authenticatedUser object if successfully authenticated
        }

        return authenticatedUser; //Change the return value based on authentication result
    }

    public static void AddNewUser(User newUser)
    {
        //TODO hash password and save username and hashed password to Users.dat
    	UsersOperations.writeUser(newUser);
    }
    
    public static void RemoveUser(String userName)
    {
    	UsersOperations.deleteUser(userName);
    }

    public static void ChangePassword(String username, 
                                      String currentPassword, 
                                      String newPassword)
    {
        //TODO change the password only if current password match what is on records
    	final String FILE_NAME = "User.dat";
		try
		{
			StringBuilder sb = new StringBuilder();
			String passHashed = GetPasswordHash(currentPassword);
			String newPassHashed = GetPasswordHash(newPassword);
			File userFile = new File(FILE_NAME);
			@SuppressWarnings("resource")
			Scanner readFile = new Scanner(userFile);
	    	while (readFile.hasNextLine())
	    	{
        		String stringInfo = readFile.nextLine();
        		String userInfo[] = stringInfo.split(", ");
        		if(username.equalsIgnoreCase(userInfo[2]))
        		{
        			if(passHashed.equals(userInfo[3]))
        			{
        				sb.append(userInfo[0] +", " + userInfo[1] +", " + userInfo[2] +", "+ newPassHashed +", "+ userInfo[4] +"\n");
        			}
        			else
        			{
        				System.out.println("Error the password on file does not match the password entered.");
        				return;
        			}
        		}
        		else
        		{
        			sb.append(stringInfo).append("\n");
        		}
	    	}
	    	readFile.close();
    	    PrintWriter pw = new PrintWriter(userFile);
    	    pw.close();

    	    BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true));
    	    writer.append(sb.toString());
    	    writer.close();
    	    readFile.close();
		}
	    catch(Exception e)
	    {
	    	
	    }
        return;
    }

    public static String GetPasswordHash(String password) 
    {        
        String generatedPassword = null;
        
        try 
        {
            byte[] salt = new byte[] {12, -12, 65, 61, 
                                      2, -6, -90, 12, 
                                      4, -7, -87, 2, 
                                      34, -102, 3, 115};

            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Add password bytes to digest
            md.update(salt);
            // Get the hash's bytes
            byte[] bytes = md.digest(password.getBytes());
            // This bytes[] has bytes in decimal format;
            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        } 

        return generatedPassword;
    }
}