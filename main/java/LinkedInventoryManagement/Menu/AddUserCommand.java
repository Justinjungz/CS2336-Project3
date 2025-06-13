/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Menu;

import LinkedInventoryManagement.Common.ScannerFactory;
import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Security.SecurityOperations;
import LinkedInventoryManagement.Security.User;

public class AddUserCommand extends Command{
	
    public AddUserCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
        // TODO Add the code that will execute this command
    	//Gets the firstName, lastName, password, isManager, tehn creates a new user and creates a password hash then adds it to the user.dat file
    	String firstName;
    	String lastName;
    	String password;
    	String manager;
    	boolean isManager;

    	System.out.println("Creating new User Command");
    	System.out.print("Enter the User's first name: ");
    	firstName = ScannerFactory.GetScannerInstance().next();
    	System.out.print("Enter the User's last name: ");
    	lastName = ScannerFactory.GetScannerInstance().next();
    	System.out.print("Enter the User's password: ");
    	password = ScannerFactory.GetScannerInstance().next();
    	System.out.print("Is the User a manager T/F : ");
    	manager = ScannerFactory.GetScannerInstance().next().toLowerCase();
    	if(manager.equals("t"))
    	{
    		isManager = true;
    	}
    	else
    	{
    		isManager = false;
    	}
    	String username = firstName.charAt(0) + lastName;
    	username = username.toLowerCase();
    	password = SecurityOperations.GetPasswordHash(password);
    	User user = new User(username,password,isManager);
    	user.setFirstName(firstName);
    	user.setLastName(lastName);
    	SecurityOperations.AddNewUser(user);
    }
}
