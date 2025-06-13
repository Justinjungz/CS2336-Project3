/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Menu;
import LinkedInventoryManagement.Common.ScannerFactory;
import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Security.SecurityOperations;
import LinkedInventoryManagement.Security.User;
/**
 * AddCommand
 */
public class ChangePasswordCommand extends Command
{
    //TODO: add necessary fields to this class

    public ChangePasswordCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
    	//Gets username, password, new password, checks whether the passwords matches the one on file and changes the password.
    	String username;
    	String password;
    	String newPassword;
    	System.out.println("Changing user's password Command");
    	System.out.print("Enter the User's username: ");
    	username = ScannerFactory.GetScannerInstance().next();
    	System.out.print("Enter the User's current password: ");
    	password = ScannerFactory.GetScannerInstance().next();;
    	System.out.print("Enter the User's new password: ");
    	newPassword = ScannerFactory.GetScannerInstance().next();
    	SecurityOperations.ChangePassword(username, password, newPassword);
    }
}