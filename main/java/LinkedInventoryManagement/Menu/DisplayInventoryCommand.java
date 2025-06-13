/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Menu;


import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Security.User;

public class DisplayInventoryCommand extends Command{
	
    public DisplayInventoryCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
    	//Displays the inventory
    	System.out.println("Display Invetory Command");
    	ProductCatalog catalog = getCatalog();
    	catalog.PrintInventoryList();
    }
}