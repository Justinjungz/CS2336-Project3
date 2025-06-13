/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Menu;

import LinkedInventoryManagement.Common.ScannerFactory;
import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Security.User;

/**
 * AddCommand
 */
public class AddProductCommand extends Command
{
    //TODO: add necessary fields to this class
    public AddProductCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
    	//Gets the products, id, name, cost, quantity, margin, and creates a new product and runs the catalog's AddUpdateProduct method
    	ProductCatalog catalog = getCatalog();
    	int productId;
    	String productName;
    	double productCost;
    	int productQuantity;
    	int productMargin;
    	System.out.println("Add Product Command");
    	System.out.print("Enter the product's id: ");
    	productId = ScannerFactory.GetScannerInstance().nextInt();
    	
    	System.out.print("Enter the product's name: ");
    	productName = ScannerFactory.GetScannerInstance().next();
    	
    	System.out.print("Enter the product's cost: ");
    	productCost = ScannerFactory.GetScannerInstance().nextDouble();
    	
    	System.out.print("Enter the product's quantity: ");
    	productQuantity = ScannerFactory.GetScannerInstance().nextInt();
    	
    	System.out.print("Enter the product's margin: ");
    	productMargin = ScannerFactory.GetScannerInstance().nextInt();
    	Product p = new Product(productId,productName,productCost,productQuantity,productMargin);
    	catalog.AddUpdateProduct(p);
    }
}