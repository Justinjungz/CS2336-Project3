/*
* Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.PersistentStorage;
import LinkedInventoryManagement.Security.*;
import java.io.*;
import java.util.*;
/**
 * UsersOperations: This class should contain all the Users.dat file read, write 
 * and update operations.
 */
public class UsersOperations {
	final static String FILE_NAME = "User.dat";
	public static boolean writeUser(User newUser)
	{
    	try
    	{
    		FileWriter writer = new FileWriter(FILE_NAME,true);
    		writer.write(newUser.getFirstName() +", " + newUser.getLastName() + ", " + newUser.getUsername() +", " + newUser.getPassword() + ", " + newUser.getManager()+"\n");
    		writer.close();
    	}
	    catch(Exception e)
	    {
	    	
	    }
    	return true;
	}
	
	public static boolean deleteUser(String username)
	{
		boolean success = false;
		String toFind = "";
		try
		{
			File userFile = new File(FILE_NAME);
			Scanner readFile = new Scanner(userFile);
	    	while (readFile.hasNextLine())
	    	{
	    		String stringInfo = readFile.nextLine();
	    		String userInfo[] = stringInfo.split(", ");
	    		if(username.equalsIgnoreCase(userInfo[2]))
	    		{
	    			toFind = stringInfo;
	    		}
	    	}
	    	readFile.close();
		}
	    catch(Exception e)
	    {
	    	
	    }
		try
		{
			File userFile = new File(FILE_NAME);
		    StringBuilder sb = new StringBuilder();
		    try (Scanner scnr = new Scanner(userFile)) {
		        String currentLine;
		        while(scnr.hasNext()){
		            currentLine = scnr.nextLine();
		            if(currentLine.equals(toFind)){
		                continue; //skips lineToRemove
		            }
		            sb.append(currentLine).append("\n");
		        }
		    }

		    PrintWriter pw = new PrintWriter(userFile);
		    pw.close();

		    BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true));
		    writer.append(sb.toString());
		    writer.close();
		}
		catch(Exception e)
		{
			
		}
	    return success;
	}
	
	public static User verifyUser(String username, String password)
	{
		File userFile = new File(FILE_NAME);
		User authenticatedUser = null;
		try
		{
			@SuppressWarnings("resource")
			Scanner readFile = new Scanner(userFile);
	    	while (readFile.hasNextLine())
	    	{
	    		String stringInfo = readFile.nextLine();
	    		String userInfo[] = stringInfo.split(", ");
	    		boolean isManager = Boolean.valueOf(userInfo[4]);
	    		if(username.equals(userInfo[2]) && password.equals(userInfo[3]))
	    		{
        			authenticatedUser = new User(username, password, isManager);
        			authenticatedUser.setFirstName(userInfo[0]);
        			authenticatedUser.setLastName(userInfo[1]);
	    			return authenticatedUser;
	    		}
	    	}
	    	
	    	readFile.close();
		}
		catch(Exception e)
		{

		}
		return authenticatedUser;
	}
    //TODO: Add methods to read, write and update Users.dat
    //open file
    //get data
    //close file
    //return data to caller.
}