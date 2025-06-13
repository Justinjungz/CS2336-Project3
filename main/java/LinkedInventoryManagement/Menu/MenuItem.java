/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Menu;

/**
 * MenuItem
 */
public class MenuItem implements Comparable<MenuItem>
{
    //TODO Add data fields, constructors and methods as needed. Class must implement Comparable to compare two menu items.
	private Command command;
	private int optionNumber;
	private String description;
	private boolean isRestricted;
    public MenuItem(Command command, 
                    int optionNumber, 
                    String description, 
                    Boolean isRestricted)
    {
    	this.command = command;
    	this.optionNumber = optionNumber;
    	this.description = description;
    	this.isRestricted = isRestricted;
    }
    //gets command of menu item
    public Command getCommand()
    {
    	return command;
    }
    //Gets the option number for menu item
    public int getOptionNumber()
    {
    	return optionNumber;
    }
    //Gets the description of menu item
    public String getDescription()
    {
    	return description;
    }
    //Gets whether or not menu item is restricted
    public boolean getRestricted()
    {
    	return isRestricted;
    }
    

    @Override
    public int compareTo(MenuItem menuItemToCompare) {
    	return this.getClass().getName().compareTo(menuItemToCompare.getClass().getName());
        // TODO Auto-generated method stub
    }

}