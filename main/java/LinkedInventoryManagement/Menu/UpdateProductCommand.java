/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Menu;

import LinkedInventoryManagement.Common.ScannerFactory;
import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Security.User;

public class UpdateProductCommand extends Command{
	
    public UpdateProductCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
    	//Gets product id, name, cost, quantity, margin, and creates a new product and updates the product
    	ProductCatalog catalog = getCatalog();
    	int productId;
    	String productName;
    	double productCost;
    	int productQuantity;
    	int productMargin;
    	System.out.println("Update Product Command");
    	System.out.print("Enter the product's id: ");
    	productId = ScannerFactory.GetScannerInstance().nextInt();
    	
    	System.out.print("Enter the product's name: ");
    	productName = ScannerFactory.GetScannerInstance().next();
    	
    	System.out.print("Enter the product's cost: ");
    	productCost = ScannerFactory.GetScannerInstance().nextInt();
    	
    	System.out.print("Enter the product's quantity: ");
    	productQuantity = ScannerFactory.GetScannerInstance().nextInt();
    	
    	System.out.print("Enter the product's margin: ");
    	productMargin = ScannerFactory.GetScannerInstance().nextInt();
    	Product p = new Product(productId,productName,productCost,productQuantity,productMargin);
    	catalog.AddUpdateProduct(p);
    }
}
