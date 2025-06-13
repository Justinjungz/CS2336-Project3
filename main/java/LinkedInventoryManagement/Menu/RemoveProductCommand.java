/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Menu;

import LinkedInventoryManagement.Common.ScannerFactory;
import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Security.User;

public class RemoveProductCommand extends Command{
	
    public RemoveProductCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
    	//Removes product from the catalog
    	ProductCatalog catalog = getCatalog();
    	int productId;
    	System.out.println("Delete Product Command");
    	System.out.print("Enter the product's id: ");
    	productId = ScannerFactory.GetScannerInstance().nextInt();
    	Product p = null;
    	for(int i = 0; i < catalog.getProductList().GetLength(); i++)
    	{
    		if(catalog.getProductList().GetElement(i).getId() == productId)
    		{
    			p = catalog.getProductList().GetElement(i);
    		}
    	}
    	catalog.RemoveProduct(p);
    }
}
