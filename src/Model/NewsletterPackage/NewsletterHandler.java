//In this package
package Model.NewsletterPackage;

import java.io.IOException;
import java.io.PrintWriter;

import Model.CustomerPackage.CustomerHandler;

//Import what this class use
public class NewsletterHandler
{	
	private Newsletter newsletter = null;
	private CustomerHandler customerH = null;
	
	/**
	 * Constructor
	 */
	public NewsletterHandler(CustomerHandler ch)
	{
		super();
		this.newsletter = new Newsletter();
		this.customerH = ch;
	}
	
	/**
	 * Constructor
	 * @param title		Title of newsletter
	 * @param content	Content of newsletter
	 */
	public NewsletterHandler(String title, String content)
	{
		super();
		this.newsletter = new Newsletter(title, content);
	}
	
	/**
	 * Get newsletter
	 * @return			Newsletter
	 */
	public Newsletter getNewsletter()
	{
		return this.newsletter;
	}
	
	/**
	 * Set title of newsletter
	 * @param title		Title of newsletter
	 */
	public void setTitle(String title)
	{
		this.newsletter.setTitle(title);
	}
	
	/**
	 * Set content of newsletter
	 * @param content	Content of newsletter
	 */
	public void setContent(String content)
	{
		this.newsletter.setContent(content);
	}
	
	/**
	 * Get addresslist of customers
	 * @param preference	Preference of customers
	 */
	public void getAddressList(String preference)
	{
		this.newsletter.setAddressList(this.customerH.getCustomersWithPreferences(preference));
	}
	
	/**
	 * Send newsletter
	 */
	public void send()
	{
		int size = this.newsletter.getAddressList().size();
		
		try
		{
			for(int i = 0; i < size; i++)
			{
				String temp = this.newsletter.getAddressList().elementAt(i);
				PrintWriter out = new PrintWriter(this.newsletter.getTitle() + "#" + i + ".txt");
				
				out.println(temp + "\r\n");
				out.println(this.newsletter.getTitle() + "\r\n");
				out.println(this.newsletter.getContent());
				
				out.close();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
