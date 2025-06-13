/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Menu;
import java.util.*;

import LinkedInventoryManagement.Common.ScannerFactory;
import LinkedInventoryManagement.Security.SecurityOperations;
import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Security.User;
/**
 * DeleteUserCommand
 */
public class DeleteUserCommand extends Command
{
    //TODO: add necessary fields to this class

    public DeleteUserCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
        // TODO Add the code that will execute this command
    	//Gets the username and deletes the user from user.dat
    	String username;
    	System.out.println("Delete User Command");
        System.out.print("Enter the username that you want to delete: ");
        username = ScannerFactory.GetScannerInstance().next();
        System.out.println(username);
        SecurityOperations.RemoveUser(username);
    }
}