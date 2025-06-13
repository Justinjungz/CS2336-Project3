/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Product;

/**
 * This class represent a line in Inventory.dat file
 */
public class Product implements Comparable<Product>
{
    //TODO Add data fields, constructors and methods as needed. Class must implement Comparable to compare two products
	private int id;
	private String name;
	private double cost;
	private int quantity;
	private int margin;
    public Product(int id, String name, double cost, int quantity, int margin)
    {
    	this.id = id;
    	this.name = name;
    	this.cost = cost;
    	this.quantity = quantity;
    	this.margin = margin;
    }
    //Sets the id of the product
    public void setId(int id)
    {
    	this.id = id;
    }
    //Sets the name of the product
    public void setName(String name)
    {
    	this.name = name;
    }
    //Sets the cost of the product
    public void setCost(double cost)
    {
    	this.cost = cost;
    }
    //Sets the quantity of the product
    public void setQuantity(int quantity)
    {
    	this.quantity = quantity;
    }
    //Sets the margin of the product
    public void setMargin(int margin)
    {
    	this.margin = margin;
    }
    //Gets the id of the product
    public int getId()
    {
    	return id;
    }
    //Gets the name of the product
    public String getName()
    {
    	return name;
    }
    //Gets the cost of the product
    public double getCost()
    {
    	return cost;
    }
    //Gets the quantity of the product
    public int getQuantity()
    {
    	return quantity;
    }
    //Gets the margin of the product
    public int getMargin()
    {
    	return margin;
    }
    //Prints all the information of the product
    public String printProduct()
    {
		double retailPrice = (getCost() + (getMargin() * getCost() / 100));
		return getId() + " " + getName() + " $" + getCost() + " " +getQuantity() + " $" + retailPrice;
    }
    @Override
    public int compareTo(Product productToCompare) {
    	return this.getId() - productToCompare.getId();
    }

    
}