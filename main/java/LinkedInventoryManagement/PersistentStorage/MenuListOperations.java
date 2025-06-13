/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.PersistentStorage;
import java.io.*;
import java.util.*;
import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Menu.*;
import LinkedInventoryManagement.Security.*;
/**
 * MenuListOperations: This class should contain all the MenuList.dat file read, write 
 * and update operations.
 */
public class MenuListOperations {

    //TODO Add methods to read, write and update MenuList.dat
	final static String FILE_NAME = "MenuList.dat";
    public static void loadMenu(User user, ProductCatalog productCatalog, MenuList menuList)
    {
    	File userFile = new File(FILE_NAME);
    	int optionNumber = 1;
		try
		{
			Scanner readFile = new Scanner(userFile);
	    	while (readFile.hasNextLine())
	    	{
        		String stringInfo = readFile.nextLine();
        		String userInfo[] = stringInfo.split(", ");
        		boolean restricted = Boolean.valueOf(userInfo[1]);
        		Command dynamicCommand = Command.CreateCommandDynamically(productCatalog, user, userInfo[2]); 
        		MenuItem menuItem = new MenuItem(dynamicCommand, optionNumber, userInfo[0], restricted);
        		menuList.AddMenuItem(menuItem);
        		optionNumber++;
	    	}
	    	readFile.close();
	    	Command dynamicCommand = Command.CreateCommandDynamically(productCatalog, user, "ExitCommand");
	    	MenuItem menuItem = new MenuItem(dynamicCommand, optionNumber, "Exit", false);
	    	menuList.AddMenuItem(menuItem);
		}
	    catch(Exception e)
	    {
	    	
	    }
    }
}