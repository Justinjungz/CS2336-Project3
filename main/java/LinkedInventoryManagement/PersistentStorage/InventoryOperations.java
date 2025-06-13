/*
 * Justin Jung
 * jxj180046u
 */
package LinkedInventoryManagement.PersistentStorage;
import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Common.*;
import java.io.*;
import java.util.*;
/**
 * InventoryOperations: This class should contain all the Inventory.dat file read, write 
 * and update operations. 
 */
public class InventoryOperations {
	final static String FILE_NAME = "Inventory.dat";
	public static void updateInventory(InventoryLinkedList<Product> productList)
	{
        StringBuilder sb = new StringBuilder();
        try
        {
	        File itemFile = new File("Inventory.dat");
	        for(int i = 0; i < productList.GetLength(); i++)
	        {
	        	Product p = productList.GetElement(i);
	        	sb.append(p.getId() + ", " + p.getName() + ", " + p.getCost() + ", " + p.getQuantity() + ", " + p.getMargin()+"\n");
	        }

    	    PrintWriter pw = new PrintWriter(itemFile);
    	    pw.close();
    	    
		    BufferedWriter writer = new BufferedWriter(new FileWriter(itemFile, true));
		    writer.append(sb.toString());
		    writer.close();
        }
        catch(Exception e)
        {
        	
        }
	}
	public static void readInventory(InventoryLinkedList<Product> productList)
	{
		System.out.println("Loading Invetory");
		try
		{
			File userFile = new File(FILE_NAME);
			Scanner readFile = new Scanner(userFile);
	    	while (readFile.hasNextLine())
	    	{
	    		String stringInfo = readFile.nextLine();
	    		String itemInfo[] = stringInfo.split(", ");
	    		int id = Integer.parseInt(itemInfo[0]);
	    		String name = itemInfo[1];
	    		double cost = Double.parseDouble(itemInfo[2]);
	    		int quantity = Integer.parseInt(itemInfo[3]);
	    		int marign = Integer.parseInt(itemInfo[4]);
	    		Product p = new Product(id,name,cost,quantity,marign);
	    		productList.Insert(productList.GetLength(), p);
	    	}
		}
		catch(Exception e)
		{
			
		}
	}

}