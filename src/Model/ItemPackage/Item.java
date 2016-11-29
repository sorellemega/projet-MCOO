package Model.ItemPackage;

import java.io.Serializable;
import java.sql.Date;

public abstract class Item implements Serializable
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private String title;
	private int Id = 0;
	private boolean status;
	private int rentalExpireDate;
	private int priceGroup;
	private int inStock;
	
	
	public Item() 
	{
	    super();
	}
	
	public Item(String title, int priceGroup, int id, int inStock)
	{
		this.title = title;
		this.priceGroup = priceGroup;
		this.inStock = inStock;
		this.Id = id;
	}
	
	public Item(String title, int id, boolean status, int rentalExpireDate, int priceGroup, int instock)
	{
		super();
		this.title = title;
		Id = id;
		this.status = status;
		this.rentalExpireDate = rentalExpireDate;
		this.priceGroup = priceGroup;
		
	}
	
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	public int getId() 
	{
		return Id;
	}
	public void setId(int id)
	{
		Id = id;
	}
	public boolean isStatus()
	{
		return status;
	}
	public void setStatus(boolean status) 
	{
		this.status = status;
	}
	public int getRentalExpireDate() 
	{
		return rentalExpireDate;
	}
	public void setRentalExpireDate(int rentalExpireDate) 
	{
		this.rentalExpireDate = rentalExpireDate;
	}
	public int getPriceGroup() 
	{
		return priceGroup;
	}
	public void setPriceGroup(int priceGroup) 
	{
		this.priceGroup = priceGroup;
	}
	public void setInStock(int nr) 
	{
		this.inStock = nr;
	}
	public int getInStock()
	{
		return this.inStock;
	}
	public boolean getStatus()
	{
		return this.status;
	}
	

}
