/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Product;
import LinkedInventoryManagement.Common.*;
import LinkedInventoryManagement.PersistentStorage.InventoryOperations;
/**
 * ProductCatalog
 */
public class ProductCatalog {

	private InventoryLinkedList<Product> productList = new InventoryLinkedList<Product>();
    //TODO Add data fields, constructors and methods as needed. Add a collection to hold Product objects
    public ProductCatalog()
    {
    	InventoryOperations.readInventory(productList);
    }

    //Add or update a product if already exists
    public void AddUpdateProduct(Product product)
    {
    	/* Loops through everything in the product collection, if it finds a product with the same id
    	 * It updates the product otherwise it adds a new product to the list.
    	*/
        boolean found = false;
        for(int i = 0; i < productList.GetLength(); i++)
        {
        	if(productList.GetElement(i).compareTo(product) == 0)
        	{
        		productList.GetElement(i).setName(product.getName());
        		productList.GetElement(i).setCost(product.getCost());
        		productList.GetElement(i).setQuantity(product.getQuantity());
        		productList.GetElement(i).setMargin(product.getMargin());
        		found = true;
        	}
        }
        if(!found)
        {
        	productList.Insert(productList.GetLength(),product);
        }
        InventoryOperations.updateInventory(productList);
    }

    public boolean RemoveProduct(Product product)
    {
        boolean isSuccess = true;
        for(int i = 0; i < productList.GetLength(); i++)
        {
        	if(productList.GetElement(i).compareTo(product) == 0)
        	{
        		productList.Remove(i);
        		break;
        	}
        }
        InventoryOperations.updateInventory(productList);
        return isSuccess;
    }

    public boolean FindProduct(Product product)
    {
        return productList.Contains(product);
    }

    //Print information about a product including retail price (cost + (margin*cost/100))
    public String PrintProductInformation(Product product)
    {
        String productInformation = null;
        //You may print the product details here
        System.out.println("Id Name Cost Quantity Retail\r\n" + 
        		"----------------------------------------------------");
        for(int i = 0; i < productList.GetLength(); i++)
        {
        	if(productList.GetElement(i).compareTo(product) == 0)
        	{
        		System.out.println(productList.GetElement(i).printProduct());
        	}
        }
        return productInformation;
    }

    //Print all product information in the inventory
    public String PrintInventoryList()
    {
        System.out.println("Id Name Cost Quantity Retail\r\n" + 
        		"----------------------------------------------------");
        StringBuilder inventoryInformation = new StringBuilder(); 

        //You may print the inventory details here
        for(int i = 0; i < productList.GetLength(); i++)
        {
        	System.out.println(productList.GetElement(i).printProduct());
        }
        //You may print the inventory details here
        return inventoryInformation.toString(); 
    }
    
    public InventoryLinkedList<Product> getProductList()
    {
    	return productList;
    }
}