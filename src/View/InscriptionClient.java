//In this package
package View;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.CustomerPackage.Customer;
import Model.CustomerPackage.CustomerHandler;
import Model.ItemPackage.Item;

//Import what this class use

public class InscriptionClient extends JFrame
{
	public InscriptionClient() {
		initiateInstanceVariables();
		configureFrame();
		buildLeftPanel();
		addListToTheRight();
		updateOutputList();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private CustomerHandler cHandler;
	
	private Container contentPane;
	@SuppressWarnings("rawtypes")
	private JList output;
	private JScrollPane outputScroller;
	private JList<String> rentedItems; 
	
	private JTextField name;
	private JTextField adress;
	private JTextField ssn;
	private JComboBox<String> preferences;
	
	private JButton addC;
	private JButton removeC;
	private JButton editC;
	private JButton infoC;
	private JButton changeC;
	private JButton listAllC;
	
	private String selectedCustomer;
	private String[] preferencesList;
	private JTextField postal;
	
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event) 
		{
			String buttonText = event.getActionCommand();
			selectedCustomer = (String) output.getSelectedValue();
			changeC.setEnabled(false);
			addC.setEnabled(true);
			removeC.setEnabled(true);
			listAllC.setEnabled(true);
			editC.setEnabled(true);
			infoC.setEnabled(true);
						
			if(buttonText.equals("Ajouter un cleint"))
			{
				if(name.getText() != "" && adress.getText() != "" && ssn.getText() != "" && preferences.getSelectedIndex() != 0)
				{
					if(cHandler.check(name.getText()))
					{
						addCustomer();
						updateOutputList ();
						clearFields();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Nom deja pris!! Choisissez un autre");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You must fill in all input!");
				}
			}
			else if(buttonText.equals("Remove customer"))
			{
				if(selectedCustomer == null)
				{
					JOptionPane.showMessageDialog(null, "No customer selected!");
				}
				else
				{
					removeCustomer(selectedCustomer);
					updateOutputList();
					clearFields();
				}
			}
			else if(buttonText.equals("Edit customer"))
			{
				if(selectedCustomer == null)
				{
					JOptionPane.showMessageDialog(null, "No customer selected!");
				}
				else
				{
					editCustomer(selectedCustomer);
				}
			}
			else if(buttonText.equals("Change info"))
			{
				changeCustomer(selectedCustomer);
				//showInfo(selectedCustomer);
				updateOutputList ();
				clearFields();
			}
			else if(buttonText.equals("Show info") )
			{
				if(selectedCustomer == null)
				{
					JOptionPane.showMessageDialog(null, "No customer selected!");
				}
				else
				{
					showInfo(selectedCustomer);
				}
			}
			else if(buttonText.equals("List all"))
			{
				updateOutputList();
				clearFields();
			}
			
		}
	}
	// SHOW INFO
	@SuppressWarnings("unchecked")
	private void showInfo(String selectedCustomer)
	{
		this.output.setEnabled(false);
		this.listAllC.setEnabled(true);
		this.removeC.setEnabled(false);
		this.editC.setEnabled(false);
		this.infoC.setEnabled(false);
		this.changeC.setEnabled(false);
		String[] temp = new String[1];
		Customer tempC = cHandler.getCustomer(selectedCustomer);
		temp[0] = "<HTML>Name: " + tempC.getName() + "<br>Adress: " + tempC.getAddress() + "<br>SSN: " + tempC.getSsn() + "<br>Preference: " + tempC.getPreference();
		output.setListData(temp);
		
		String[] itemsRented = new String[cHandler.getCustomer(selectedCustomer).getRentedItems().size()];
		int counter = 0;
		
		if(cHandler.getCustomer(selectedCustomer).getRentedItems().isEmpty())
		{
			itemsRented = new String[1];
			itemsRented[0] = "No items rented yet";
		}
		else
		{
			for(Item item : cHandler.getCustomer(selectedCustomer).getRentedItems())
			{
				itemsRented[counter] = "<HTML>" + (++counter) + " " + item.getTitle() + "<br>";
			}
			
		}
		this.rentedItems.setListData(itemsRented );
	}
	// CHANGE CUSTOMER
	private void changeCustomer(String customerName)
	{
		Customer tempCust = this.cHandler.getCustomer(customerName);
		
		for(int i = 0; i < this.cHandler.getListOfCustomers().size(); i++)
		{
			if(this.cHandler.getListOfCustomers().get(i).getName().equals(customerName))
			{
				this.cHandler.editCustomer(i, this.name.getText(), this.ssn.getText(), tempCust.getRentedItems(), this.adress.getText(), String.valueOf(this.preferences.getSelectedItem()));
			}
		}
	}
	// EDIT CUSTOMER
	private void editCustomer(String customerName)
	{
		Customer tempCust = this.cHandler.getCustomer(customerName);
		
		this.name.setText(tempCust.getName());
		this.adress.setText(tempCust.getAddress());
		this.ssn.setText(tempCust.getSsn());
		
		for(int i = 0; i < this.preferencesList.length; i++)
		{
			if(tempCust.getPreference().equals(this.preferencesList[i]))
			{
				this.preferences.setSelectedIndex(i);
			}
		}
		
		this.addC.setEnabled(false);
		
		this.listAllC.setEnabled(false);
		this.removeC.setEnabled(false);
		this.editC.setEnabled(false);
		this.infoC.setEnabled(false);
		this.changeC.setEnabled(true);
	}
	// REMOVE CUSTOMER
	private void removeCustomer(String customerName)
	{
		for(int i = 0; i < this.cHandler.getListOfCustomers().size(); i++)
		{
			if(this.cHandler.getListOfCustomers().get(i).getName().equals(customerName))
			{
				this.cHandler.removeCustomer(i);
			}
		}
	}
	// ADD CUSTOMER
	private void addCustomer()
	{
		String newName = this.name.getText();
		String newSsn = this.ssn.getText();
		String newAdress = this.adress.getText();
		String newPreference = (String) this.preferences.getSelectedItem();
		
		this.cHandler.addCustomer(newName, newSsn, newAdress, newPreference);
	}
	// UPDATE THE OUTPUTLIST
	@SuppressWarnings("unchecked")
	private void updateOutputList()
	{
		this.output.setEnabled(true);
		if(this.cHandler.getListOfCustomers().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Empty list!");
		}
		else
		{
			String[] customerNames = new String[cHandler.getListOfCustomers().size()];
			int counter = 0;
			
			for(Customer c : cHandler.getListOfCustomers())
			{
				customerNames[counter] = c.getName();
				counter++;
			}
			
			this.output.setListData(customerNames);
		}
	}
	// CLEAR FIELDS
	private void clearFields()
	{
		this.name.setText("");
		this.adress.setText("");
		this.ssn.setText("");
		this.preferences.setSelectedIndex(0);
		this.rentedItems.removeAll();
	}
	
	// INITIATE INSTANCE VARIABLES
	@SuppressWarnings("rawtypes")
	private void initiateInstanceVariables()
	{	
		this.contentPane = this.getContentPane();
		this.contentPane.setLayout(new GridLayout(1, 2));
		this.adress = new JTextField();
		this.ssn = new JTextField();
		this.adress.setBorder(BorderFactory.createTitledBorder("Adress EMAIL: "));
		this.ssn.setBorder(BorderFactory.createTitledBorder("Numero carte de credit: "));
		
		this.output = new JList();
		this.outputScroller = new JScrollPane(this.output);
		
		this.rentedItems = new JList<String>();
		
		//this.output.setBorder(BorderFactory.createTitledBorder("Output"));
		this.rentedItems.setBorder(BorderFactory.createTitledBorder("Rented items"));
		
		this.addC = new JButton("Add customer");
		this.removeC = new JButton("Remove customer");
		this.editC = new JButton("Edit customer");
		this.infoC = new JButton("Show info");
		this.changeC = new JButton("Change info");
		this.changeC.setEnabled(false);
		this.listAllC = new JButton("List all");
		
		this.preferences = new JComboBox<String>();
		this.preferencesList = new String[]{"Choose preference...", "Action", "Comedy", "Horror", "Romance", "Thriller", "Adventure", "Sci-fi", "Documentary", "RPG", "Adventure", "Sport", "Strategy", "FPS"};
		for(String str : this.preferencesList)
		{
			this.preferences.addItem(str);
		}
		
	}
	// CONFIGURE FRAME
	private void configureFrame()
	{
		this.setSize(600, 600);
		this.setTitle("Customer GUI");
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
	}
	//BUILD LEFT SIDE
	private void buildLeftPanel()
	{
		JPanel leftSide = new JPanel();
		leftSide.setLayout(new GridLayout(2,1));
		leftSide.setBorder(BorderFactory.createTitledBorder("Input"));
		
		JPanel info = new JPanel();
		info.setLayout(new GridLayout(5, 1));
		info.add(this.adress);
		this.name = new JTextField();
		
		this.name.setBorder(BorderFactory.createTitledBorder("Name: "));
		
		info.add(this.name);
		
		postal = new JTextField();
		postal.setBorder(BorderFactory.createTitledBorder("Adresse postale: "));
		info.add(postal);
		info.add(this.ssn);
		info.add(this.preferences);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3,2));
		
		ButtonListener buttonListener = new ButtonListener();
		
		this.addC.addActionListener(buttonListener);
		this.removeC.addActionListener(buttonListener);
		this.editC.addActionListener(buttonListener);
		this.infoC.addActionListener(buttonListener);
		this.changeC.addActionListener(buttonListener);
		this.listAllC.addActionListener(buttonListener);
		
		buttonPanel.add(this.addC);
		buttonPanel.add(this.removeC);
		buttonPanel.add(this.infoC);
		buttonPanel.add(this.listAllC);
		buttonPanel.add(this.editC);
		buttonPanel.add(this.changeC);
		
		info.add(buttonPanel);
		leftSide.add(info);
		leftSide.add(this.rentedItems);
		
		this.contentPane.add(leftSide);
		
	}
	// BUILD RIGHT SIDE
	private void addListToTheRight()
	{
		this.contentPane.add(this.outputScroller);
	}
	// GUI CONSTRUCTOR
	public InscriptionClient(CustomerHandler ch)
	{
		super();
		this.cHandler = ch;
		
	}
	
}
