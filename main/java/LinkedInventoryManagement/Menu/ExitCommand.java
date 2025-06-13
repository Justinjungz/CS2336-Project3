/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Menu;
import LinkedInventoryManagement.Common.ScannerFactory;
import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Security.User;
public class ExitCommand extends Command{
	
    public ExitCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
        // TODO Add the code that will execute this command
    	//Exits the program
        System.exit(0);
    }
}