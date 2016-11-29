//In this package
package View;
import Model.NewsletterPackage.NewsletterHandler;

//Import what this class use

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUINewsletter extends JFrame
{
	private static final long	serialVersionUID	= 1L;
	private Container contentPane;
	
	private JTextField titleField 	  			 = null;
	private JTextArea contentTextArea 			 = null;
	private JComboBox<String> preferenceComboBox = null;
	private JList<String> addressList 			 = null;
	
	private NewsletterHandler newsletterH 		 = null;

	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			String buttonText = event.getActionCommand();
			
			if(buttonText.equals("Get addresslist"))
			{
				getAddressList();
			}
			else if(buttonText.equals("Send"))
			{
				send();
			}	
		}
	}
	
	/**
	 * Get addressList
	 */
	private void getAddressList()
	{
		Object obj = this.preferenceComboBox.getModel().getSelectedItem();
		String preference = (String) obj;
		
		this.newsletterH.getAddressList(preference);
		this.addressList.setListData(this.newsletterH.getNewsletter().getAddressList());
	}
	
	/**
	 * Send newsletter
	 */
	private void send()
	{
		if(this.titleField.getText().equals("") || this.contentTextArea.getText().equals("")
				|| this.addressList.getModel().getSize() == 0)
		{
			JOptionPane.showMessageDialog(null, "You can't have empty fields", "ERROR",
				    JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			this.newsletterH.setTitle(this.titleField.getText());
			newsletterH.setContent(this.contentTextArea.getText());
			newsletterH.send();
			
			this.addressList.setListData(new String[0]);
			this.contentTextArea.setText("");
			this.titleField.setText("");
			this.preferenceComboBox.setSelectedIndex(0);
			
			JOptionPane.showMessageDialog(null, "Message sent", "INFORMATION",
				    JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Constructor
	 */
	public GUINewsletter(NewsletterHandler newsletterH)
	{
		super();
		initiateInstanceVariables();
		configureFrame();
		buildLeftPanel();
		buildRightPanel();
		
		this.newsletterH = newsletterH;
	}
	
	/**
	 * Configure frame
	 */
	private void configureFrame()
	{
		this.setSize(800, 400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Newsletter");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/**
	 * Initiate instance variables
	 */
	private void initiateInstanceVariables()
	{
		this.contentPane = this.getContentPane();
		this.contentPane.setLayout(new GridLayout(1, 2));
		
		this.titleField = new JTextField();
		this.contentTextArea = new JTextArea();
		this.preferenceComboBox = new JComboBox<String>();
		this.addressList = new JList<String>();
	}
	
	/**
	 * Build left panel with misc components
	 */
	private void buildLeftPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label1 = new JLabel("Title");
		label1.setLocation(25, 15);
		Dimension dim = label1.getPreferredSize();
		label1.setSize(dim);
		
		this.titleField.setLocation(25, 35);
		this.titleField.setSize(150, 25);
		
		JLabel label2 = new JLabel("Content");
		label2.setLocation(25, 95);
		dim = label2.getPreferredSize();
		label2.setSize(dim);
		
		JScrollPane jsp = new JScrollPane (this.contentTextArea);
		jsp.setSize(300, 200);
		jsp.setLocation(25, 120);
		
		panel.add(label1);
		panel.add(this.titleField);
		panel.add(label2);
		panel.add(jsp);
		
		this.contentPane.add(panel);
	}
	
	/**
	 * Build right panel with misc components
	 */
	private void buildRightPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);

		JLabel label1 = new JLabel("Choose preference");
		label1.setLocation(25, 15);
		Dimension dim = label1.getPreferredSize();
		label1.setSize(dim);
		
		String arr[] = new String[]{"Action", "Comedy", "Horror", "Romance", "Thriller", "Adventure", 
				"Sci-fi", "Documentary", "RPG", "Adventure", "Sport", "Strategy", "FPS"};
		
		for(String temp : arr)
		{
			this.preferenceComboBox.addItem(temp);
		}
		
		this.preferenceComboBox.setLocation(25, 40);
		dim = this.preferenceComboBox.getPreferredSize();
		this.preferenceComboBox.setSize(dim);
		
		ButtonListener bListener = new ButtonListener();
		
		JButton button1 = new JButton("Get addresslist");
		button1.addActionListener(bListener);
		button1.setLocation(135, 40);
		dim = button1.getPreferredSize();
		button1.setSize(dim);
		
		JLabel label2 = new JLabel("Address list");
		label2.setLocation(25, 95);
		dim = label2.getPreferredSize();
		label2.setSize(dim);
		
		JScrollPane jsp = new JScrollPane(this.addressList);
		jsp.setSize(300, 140);
		jsp.setLocation(25, 120);
		
		JButton button2 = new JButton("Send");
		button2.addActionListener(bListener);
		button2.setLocation(25, 280);
		dim = button2.getPreferredSize();
		button2.setSize(dim);

		panel.add(label1);
		panel.add(this.preferenceComboBox);
		panel.add(button1);
		panel.add(label2);
		panel.add(jsp);
		panel.add(button2);
		
		this.contentPane.add(panel);
	}

}
