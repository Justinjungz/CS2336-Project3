 /*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Menu;

import java.util.*;

import LinkedInventoryManagement.Common.ScannerFactory;
import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Security.User;

public class DisplayProductCommand extends Command{
	
    public DisplayProductCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
        // TODO Add the code that will execute this command
    	//Gets the product name and displays it.
    	boolean repeat = true;
    	int index = 0;

    	String name;
    	System.out.print("Enter product name: ");
    	ScannerFactory.GetScannerInstance().nextLine();
    	name = ScannerFactory.GetScannerInstance().nextLine();
    	ProductCatalog catalog = getCatalog();
    	Product p = null;
    	for(int i = 0; i < catalog.getProductList().GetLength(); i++)
    	{
    		if(catalog.getProductList().GetElement(i).getName().equalsIgnoreCase(name))
    		{
    			p = catalog.getProductList().GetElement(i);
    			index = i;
    		}
    	}
    	catalog.PrintProductInformation(p);
    	//Loops thru allowing the user to keep looping thru the linked list to get other products
    	System.out.print("Type â€œNextâ€� or â€œPreviousâ€� to display next/previous product, press enter to return: ");
    	do
    	{
    		String choice = ScannerFactory.GetScannerInstance().nextLine();
    		if(choice.equalsIgnoreCase("next"))
    		{
    			index++;
    		}
    		else
    		if(choice.equalsIgnoreCase("previous"))
    		{
    			index--;
    		}
    		else
    		{
    			repeat = false;
    		}
    		if(index >= catalog.getProductList().GetLength() || index < 0)
    		{
    			System.out.println("End of products list...");
    			repeat = false;
    			return;
    		}
    		p = catalog.getProductList().GetElement(index);
    		catalog.PrintProductInformation(p);
    	}
    	while(repeat);
    	
    }
}
