/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement;

import LinkedInventoryManagement.Menu.*;
import LinkedInventoryManagement.PersistentStorage.MenuListOperations;
import LinkedInventoryManagement.Common.*;
import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Security.*;

/**
 * Hello world!
 */
public class Main 
{
    public static void main( String[] args )
    {
    	//Start of the program
    	boolean exit = false;
    	User user = null;
    	//Gets users input, username, password and tries to verify the user
    	do
    	{
    		String input1;
    		String input2;
    		String input3;
    		System.out.print("Enter username: ");
    		input1 = ScannerFactory.GetScannerInstance().nextLine();
    		System.out.print("Enter password: ");
    		input2 = ScannerFactory.GetScannerInstance().nextLine();
    		user = SecurityOperations.AuthenticateUser(input1, input2);
    		if(user == null)
    		{
    			System.out.print("Invalid username or password!\nPress enter to continue or \"Exit\" to exit: " );
    			input3 = ScannerFactory.GetScannerInstance().nextLine();
        		if(input3.equalsIgnoreCase("Exit"))
        		{
        			System.exit(0);
        		}
    		}
    	}while(user == null);
    	//Shows the menu
    	System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName() +"!");
    	ProductCatalog  productCatalog = new ProductCatalog();
    	MenuList menuList = new MenuList("Inventory Management System Menu");
    	MenuListOperations.loadMenu(user, productCatalog, menuList);
    	menuList.StartMenu(user);
    }
}
