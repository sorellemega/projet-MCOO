//In this package
package Model.CustomerPackage;
import java.io.Serializable;
import java.util.Vector;

//Import what this class use
import Model.ItemPackage.*;

@SuppressWarnings("unused")
public class Customer implements Serializable
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private int id = -1;
	private String name;
	private String ssn;
	private Vector<Item> rentedItems;
	private String address;
	private String preference;
	private int TotalRented;
	
	/**
	 * Constructor
	 */
	public Customer() 
	{
		super();
		this.name = "";
		this.ssn = "";
		this.rentedItems = new Vector<Item>();
		this.address = "";
		this.preference = "";
		this.TotalRented = 0;
	}

	/**
	 * Constructor
	 * @param name			Name of customer
	 * @param ssn			SSN of customer
	 * @param address		Address of customer
	 * @param preference	Preference of customer
	 */
	public Customer(String name, String ssn, String address, String preference) 
	{
		super();
		this.name = name;
		this.ssn = ssn;
		this.rentedItems = new Vector<Item>();
		this.address = address;
		this.preference = preference;
		this.TotalRented = 0;
		this.id = CustomerHandler.customerId++;
	}
	
	/**
	 * Change info of customer
	 * @param name			New name of customer
	 * @param ssn			New SSN of customer
	 * @param rentedItems	New vector of rented items
	 * @param address		New address of customer
	 * @param preference	New preference of customer
	 */
	public void changeInfo(String name, String ssn, Vector<Item> rentedItems, String address, String preference)
	{
		this.name = name;
		this.ssn = ssn;
		this.rentedItems = rentedItems;
		this.address = address;
		this.preference = preference;
	}
	
	/**
	 * Get id of customer
	 * @return		Id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Get name of customer
	 * @return		Name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Get SSN of customer
	 * @return		SSN
	 */
	public String getSsn()
	{
		return ssn;
	}
	
	/**
	 * Get vector of items for customer
	 * @return		RentedItems
	 */
	public Vector<Item> getRentedItems()
	{
		return rentedItems;
	}
	
	/**
	 * Get address of customer
	 * @return		Address
	 */
	public String getAddress()
	{
		return this.address;
	}
	
	/**
	 * Get preference of customer
	 * @return		Preference
	 */
	public String getPreference()
	{
		return this.preference;
	}
	
	/**
	 * Get total rented
	 * @return		Total rented
	 */
	public int getTotalRented()
	{
		return this.TotalRented;
	}
	
	/**
	 * Add item to customer
	 * @param item		Item to rented to customer
	 */
	public void addItem(Item item)
	{
		if(this.TotalRented > 10){
			this.TotalRented = 0;
		}
		else{
			this.TotalRented++;
		}
		this.rentedItems.add(item);
		System.out.println(this.rentedItems.size());
	}

	@Override
	public String toString()
	{
	    return "<html>Name: " + getName()  + "<br>SSN: " + getSsn() + "<br>Address: " 
			+ getAddress() + "<br>Preference: " + getPreference() + "<br>Customer ID: " + getId() + "<br>Total rented: " + getTotalRented() + "<br><br></html>";
	}
	
	
}