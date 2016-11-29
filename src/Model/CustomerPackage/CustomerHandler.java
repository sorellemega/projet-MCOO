//In this package
package Model.CustomerPackage;

import java.io.Serializable;
import java.util.Vector;

import Model.ItemPackage.Item;

//Import what this class use

public class CustomerHandler implements Serializable
{	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private Vector<Customer> customers;
	static int customerId;
	
	/**
	 * Constructor
	 */
	public CustomerHandler()
	{
		this.customers = new Vector<Customer>();
		this.customerId = 0;
	}
	
	/**
	 * Get Id
	 * @return		Id
	 */
	public int getId()
	{
		return this.customerId;
	}

	/**
	 * Set Id
	 * @param id			Id to be set
	 */
	public void setId(int id)
	{
		this.customerId = id;
	}
	
	/**
	 * Add customer to system
	 * @param name			Name of customer
	 * @param ssn			SSN of customer
	 * @param address		Address of customer
	 * @param preference	Prefernce of customer
	 * @return				True or false pending on success
	 */
	public boolean addCustomer(String name, String ssn, String address, String preference)
	{
		this.customers.add(new Customer(name, ssn, address, preference));
		return true;
	}
	
	/**
	 * Edit customer in system
	 * @param id			ID of customer
	 * @param name			Name of customer
	 * @param ssn			SSN of customer
	 * @param rentedItems	Items currently rented by Customer
	 * @param address		Address of customer
	 * @param preference	Prefernce of customer
	 * @return				True or false pending on success
	 */
	public boolean editCustomer(int id, String name, String ssn, Vector<Item> rentedItems, String address, String preference)
	{
		this.customers.elementAt(id).changeInfo(name, ssn, rentedItems, address, preference);
		
		return true; 
	}
	
	/**
	 * Remove customer from system
	 * @param id			ID of customer
	 * @return				True or false pending on success
	 */
	public boolean removeCustomer(int id)
	{
		this.customers.remove(id);
		
		return true;
	}
	
	/**
	 * Get customer
	 * @param id			ID of customer
	 * @return				Customer
	 */
	public Customer getCustomer(String name)
	{
		Customer temp = null;
		for(int i = 0; i < this.customers.size(); i++)
		{
			if(this.customers.get(i).getName().equals(name))
			{
				temp = this.customers.get(i);
			}
		}
		return temp;
	}
	public boolean check(String testName)
	{
		boolean free = true;
		
		for(int i = 0; i < this.customers.size(); i++)
		{
			if(this.customers.get(i).getName().equals(testName))
			{
				free = false;
			}
		}
		return free;
	}
	
	/**
	 * Set item to Customer
	 * @param id			ID of customer
	 * @param item			Item to rented to customer
	 * @return				True or false pending success
	 */
	public boolean setItemToCustomer(int id, Item item)
	{
		this.customers.elementAt(id).addItem(item);
		
		return true;
	}
	
	/**
	 * Get customer with specific preference
	 * @param preference	Preference of customers
	 * @return				Vector with addresses
	 */
	public Vector<String> getCustomersWithPreferences(String preference)
	{
		Vector<String> addressList = new Vector<String>();
		
		for(Customer temp : this.customers)
		{
			if(temp.getPreference().equals(preference))
			{
				addressList.add(temp.getName() + ", " + temp.getAddress());
			}
		}
		
		return addressList;
	}
	
	/**
	 * Get list of customers
	 * @return				Vector of customers
	 */
	public Vector<Customer> getListOfCustomers()
	{
		return this.customers;
	}
	
	/**
	 * Load from database
	 * @param Customers
	 */
	public void LoadedFromDb(Vector<Customer> Customers)
	{
		this.customers = Customers;
	}
}
