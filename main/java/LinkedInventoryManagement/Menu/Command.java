/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Menu;

import java.lang.reflect.Constructor;

import LinkedInventoryManagement.Product.ProductCatalog;
import LinkedInventoryManagement.Security.User;

/**
 * Command
 */
public abstract class Command 
{
    //TODO: add necessary fields/constructors to this class
	private ProductCatalog catalog;
    public Command(ProductCatalog productCatalog, User loggedOnUser)
    {
    	catalog = productCatalog;
    }

    public static Command CreateCommandDynamically(ProductCatalog productCatalog, User user, String commandClassName)
    {
        Class<?>    concreteCommandClass    = null;
        Command     command                 = null;
        String      packageName             = "LinkedInventoryManagement.Menu"; 

        try 
        {
            concreteCommandClass = Class.forName(packageName + "." + commandClassName);
            Constructor<?> con = concreteCommandClass.getConstructor(ProductCatalog.class, User.class);
            command = (Command)con.newInstance(productCatalog, user);
        } 
        catch (final Exception e) 
        {
            e.printStackTrace();
        }

        return command;
    }

    //An abstract method that must be overriden in subclasses of class Command
    public abstract void Execute(); 
    public ProductCatalog getCatalog()
    {
    	return catalog;
    }
}