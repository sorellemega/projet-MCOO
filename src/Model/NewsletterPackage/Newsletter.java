//In this package
package Model.NewsletterPackage;

//Import what this class use
import java.util.Vector;

public class Newsletter
{
	
	private String title				= null;
	private String content				= null;
	private Vector<String> addressList	= null;
	
	/**
	 * Constructor
	 */
	public Newsletter()
	{
		super();
		this.title 	 = new String();
		this.content = new String();
		this.addressList = new Vector<String>();
	}
	
	/**
	 * Constructor
	 * @param title		Title of newsletter
	 * @param content	Content of newsletter
	 */
	public Newsletter(String title, String content)
	{
		super();
		this.title 	 = title;
		this.content = content;
		this.addressList = new Vector<String>();
	}
	
	/**
	 * Set title of newsletter
	 * @param title		Title of newsletter
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/**
	 * Set content of newsletter
	 * @param content	Content of newsletter
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
	
	/**
	 * Get title of newsletter
	 * @return			Title of newsletter
	 */
	public String getTitle()
	{
		return this.title;
	}
	
	/**
	 * Get content of newsletter
	 * @return			Content of newsletter
	 */
	public String getContent()
	{
		return this.content;
	}
	
	/**
	 * Set addresslist to newsletter
	 * @param addrlist	List of addresses
	 */
	public void setAddressList(Vector<String> addrlist)
	{
		this.addressList = addrlist;
	}
	
	/**
	 * Get Addresslist
	 * @return			Addresslist
	 */
	public Vector<String> getAddressList()
	{
		return this.addressList;
	}
}
