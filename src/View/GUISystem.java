//In this package
package View;

import Model.SearchHandler;
import Model.RentalHandler;
import Model.CustomerPackage.*;
import Model.NewsletterPackage.*;
import Model.ItemPackage.*;


import Controller.RentalSystem;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUISystem extends JFrame
{
	
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Container contentPane;
   
    //GUIs
    private InscriptionClient InscriptionClient;
    private GUIItem guiItem;
    private GUINewsletter guiNewsLetter;
    private GUIRental guiRental;
    private GUISearch guiSearch;
    
    private RentalSystem MainSystemReference;
    
    public GUISystem(RentalSystem MainSystem)
	{
    	super();
    	this.MainSystemReference = MainSystem;
		initiateInstanceVariables();
		configureFrame();
		buildPanel();
		this.setVisible(true);
	}
    
    public class ButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) // Executes when button pressed
		{
			String buttonText = e.getActionCommand();
			
			if(buttonText.equals("New rental"))
			{
				enterRental();
			}
			else if(buttonText.equals("Customers"))
			{
				enterCustumers();
			}
			else if(buttonText.equals("Items"))
			{
				enterItems();
			}
			else if(buttonText.equals("Search"))
			{
				enterSearch();
			}
			else if(buttonText.equals("Write newsletter"))
			{
				enterNewsletter();
			}
			else if(buttonText.equals("Logout"))
			{
				logout();
			}
		}

	}
    	private void logout() 
	{
    	    JOptionPane.showMessageDialog(null, "Exit the system");
    	    //Save
    	    try {
				this.MainSystemReference.save();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    System.exit(0);
	}

	private void enterNewsletter() 
	{
		NewsletterHandler NewsletterH = this.MainSystemReference.getNewsletterHandler();
		this.guiNewsLetter = new GUINewsletter(NewsletterH);
	    guiNewsLetter.setVisible(true);
	    
	}

	private void enterSearch() 
	{
		SearchHandler SearchH = this.MainSystemReference.getSerchHandler();
		this.guiSearch = new GUISearch(SearchH);
		guiSearch.setVisible(true);
	    
	}

	private void enterItems() 
	{
		ItemHandler ItemH = this.MainSystemReference.getItemHandler();
		this.guiItem = new GUIItem(ItemH);
	    guiItem.setVisible(true);
	    
	}

	private void enterCustumers() 
	{
		CustomerHandler customerH = this.MainSystemReference.getCustomerHandler();
		this.InscriptionClient = new InscriptionClient(customerH);
	    InscriptionClient.setVisible(true);
	    
	}

	private void enterRental() 
	{
		RentalHandler RentalH = this.MainSystemReference.getRentalHandler();
		this.guiRental = new GUIRental(RentalH);
	    guiRental.setVisible(true);
	}
	
	
	private void initiateInstanceVariables()
	{
		this.contentPane = this.getContentPane();
		this.contentPane.setLayout(new GridLayout(1, 2));
	}
	
	private void configureFrame()
	{
		this.setSize(400, 400);
		this.setTitle("Rental System :: Video Rental System 1.0");
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	private void buildPanel()
	{
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Rental System"));
		
		buildButtonPanel(panel);
		
		this.contentPane.add(panel);
	}
	
	private void buildButtonPanel(JPanel thePanel)
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		String[] buttonTxt = {"New rental", "Customers", "Items", "Search", "Write newsletter", "Logout"};
		ButtonListener buttonListener = new ButtonListener();
		
		JButton button = new JButton(buttonTxt[0]);
		Dimension dim = button.getPreferredSize();
		buttonPanel.setSize(50*dim.width + 8, 2 * dim.height + 5);
		buttonPanel.setLocation(20,70);
		
		// Add all buttons to button panel
		for(String str: buttonTxt)
		{
			button = new JButton(str);
			buttonPanel.add(button);
			// connect listener
			button.addActionListener(buttonListener);
		}
		
		thePanel.add(buttonPanel);
		this.contentPane.add(thePanel);
	}
}
