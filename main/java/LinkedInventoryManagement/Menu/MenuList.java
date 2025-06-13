/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Menu;
import LinkedInventoryManagement.Common.*;
import LinkedInventoryManagement.PersistentStorage.MenuListOperations;
import LinkedInventoryManagement.Security.User;

/**
 * MenuList
 */
public class MenuList {
	private InventoryLinkedList<MenuItem> menu = new InventoryLinkedList<MenuItem>();
    public MenuList(String menuHeader)
    {
    	System.out.println(menuHeader);
    }

    public void AddMenuItem(MenuItem menuItem)
    {
    	menu.Insert(menu.GetLength(),menuItem);
    }
    public void showMenu(User user)
    {
    	System.out.println();
    	for(int i = 0; i < menu.GetLength(); i++)
    	{
    		MenuItem m = menu.GetElement(i);
    		if(m.getRestricted() && !user.getManager())	continue;
    		else
    		{
    			System.out.println(m.getOptionNumber() +"- " + m.getDescription());
    		}
    	}
    }
    
    public void StartMenu(User user)
    {
    	int selection;
    	boolean exit = false;
    	showMenu(user);
    	do
    	{
    		System.out.print("Enter your selection: ");
    		selection = ScannerFactory.GetScannerInstance().nextInt();
    		for(int i = 0; i < menu.GetLength(); i++)
    		{
    			MenuItem m = menu.GetElement(i);
        		if(m.getRestricted() && !user.getManager())	continue;
        		else
        		{
        			if(m.getOptionNumber() == selection)
        			{
        				m.getCommand().Execute();
        			}
        		}
    		}
        	showMenu(user);
    	}while(!exit);
    }
}