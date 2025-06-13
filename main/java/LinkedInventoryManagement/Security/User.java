/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Security; 

/**
 * User
 */
public class User 
{
    //TODO: Add necessary fields, constructor and methods. Consider implementing Comparable for this class. 
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private boolean isManager;
    public User(String username, String hashedPassword, boolean isManager)
    {
        this.username = username;
        password = hashedPassword;
        this.isManager = isManager;
        firstName = " ";
        lastName = " ";
    }
    //Sets the first name of the user
    public void setFirstName(String name)
    {
    	firstName = name;
    }
  //Sets the last name of the user
    public void setLastName(String name)
    {
    	lastName = name;
    }
  //Sets the username of the user
    public String getUsername()
    {
    	return username;
    }
  //Gets the first name of the user
    public String getFirstName()
    {
    	return firstName;
    }
  //Gets the last name of the user
    public String getLastName()
    {
    	return lastName;
    }
  //Gets the password of the user
    public String getPassword()
    {
    	return password;
    }
  //Gets whether or not the user is a manager
    public boolean getManager()
    {
    	return isManager;
    }
}