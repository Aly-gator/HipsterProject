package hipster.view;

import java.awt.Color;
import java.net.URL;

import hipster.controller.HipsterController;
import hipster.model.Hipster;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class HipsterPanel extends JPanel
{
	
	
	/**
	 * 
	 *The reference to the HipsterController to maintain a MVC paradigm in the code.
	 */
	private HipsterController baseController;
	
	private JButton addHipsterButton;
	private JButton showRandomButton;
	private JButton showSpecificButton;
	private JButton showSelfButton;
	private JLabel nameLabel;
	private JLabel phraseLabel;
	private JLabel typeLabel;
	private JLabel booksLabel;
	private JComboBox selectedHipsterComboBox;
	private JTextField nameField;
	private JTextField phraseField;
	private JTextField typeField;
	private JTextArea booksArea;
	private PicturePanel picturePanel;
	private URL imageURL;
	private SpringLayout baseLayout;
	private String [] baseArray;
	
	
	
	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;
		
		addHipsterButton = new JButton("Add a Hipster");
		showRandomButton = new JButton("Show a random Hipster");
		showSpecificButton = new JButton("Show a certain Hipster");
		showSelfButton = new JButton("Show the Original Hipster");
		nameField = new JTextField(25);
		phraseField = new JTextField(25);
		typeField = new JTextField(25);
		nameLabel = new JLabel("Hipster's Name:");
		booksLabel = new JLabel("Hipster's Books");
		phraseLabel = new JLabel("Hipster's Phrase");
		typeLabel = new JLabel("Hipster's Type:");
		booksArea = new JTextArea(5, 25);
		baseArray = new String[3]; 
		
		imageURL = getClass().getResource("/hipster/viewe/images/hipster.jpg");
		picturePanel = new PicturePanel(imageURL, 200, 200);
		
		baseLayout = new SpringLayout();
		
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	
		private void setupPanel()
		{
			this.setLayout(baseLayout);
			this.add(addHipsterButton);
			this.add(showRandomButton);
			this.add(showSpecificButton);
			this.add(showSelfButton);
			this.add(nameLabel);
			this.add(phraseLabel);
			this.add(typeLabel);
			this.add(booksLabel);
			this.add(nameField);
			this.add(typeField);
			this.add(phraseField);
			this.add(booksArea);
			this.add(picturePanel);
			this.add(selectedHipsterComboBox);
			
			this.setBackground(new Color(130, 100,50));
			this.setSize(1000, 450);
			booksArea.setWrapStyleWord(true);
			booksArea.setLineWrap(true);
			

			
		}
		
		private void setupListeners()
		{
			
		}
		
		
		private void setupLayout()
		{
			
		}

		/**
		 * Helper method to get contents of the Hipster array and extracting the names of the Hipsters in it.
		 */
		private String[] getNamesForComboBox()
		{
			int realValues = 0;
			for (int count = 0; count < baseController.getClassHipsters().length; count++)
			{
				if (baseController.getClassHipsters()[count] != null)
				{
					realValues++;
				}
			}
		
			String [] tempNames = new String[realValues];
		
			for (int realSize = 0; realSize < realValues; realSize++)
			{
				tempNames[realSize] = baseController.getClassHipsters()[realSize].getName();
			}
			return tempNames;
		}
		
		private void updateHipsterComboBox()
		{
			String[] comboValues = getNamesForComboBox();
			selectedHipsterComboBox.setModel(new DefaultComboBoxModel(comboValues));
		}
		
		private void setupComboBox()
		{
			baseArray[0] = "Me";
			baseArray[1] = "Myself";
			baseArray[2] = "I";
			
			selectedHipsterComboBox = new JComboBox(baseArray);
				
		}
		
		
		private void populateFields(Hipster currentHipster)
		{
			// imageURL = getClass().getResource
			
			nameField.setText(currentHipster.getName());
			typeField.setText(currentHipster.getHipsterType());
			phraseField.setText(currentHipster.getHipsterPhrase());
			for(String temp : currentHipster.getHipsterBooks())
			{
				booksArea.append(temp + ", ");
			}
		}
		
		/**
		 * Sends information to the HipsterController.
		 */
		private void sendHipsterInfoToController()
		{
			String [] books = booksArea.getText().split(" " );
			baseController.addHipster(books, nameField.getText(), typeField.getText(), phraseField.getText());
			JOptionPane.showMessageDialog(this, "Hipster added to the array");
		}

}