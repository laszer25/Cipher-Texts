import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class GuiFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;

	/**This part of the code is where we design out GUI
	 * we utilize Jframes to create the GUI
	 * 
	 */
	
		// Final output string
	String output;
	
		// Text field containing the string that has to be decrypted
	JTextField decryptText;
	
		// Text field containing the string that has to be encrypted
	 JTextField encryptText;
	
	 
	 	// Method that will be called to initiate the GUI
	public void createWindow(){
		
			// Creating a JFrame with title "Cipher-Text"
		JFrame frame =  new JFrame("Cipher-Text");
		
			// Code to terminate the program when the JFrame is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			// Setting a FlowLayout
			// The flow is leading from left to right
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEADING);
			// Set the layout to the JFrame
		frame.setLayout(layout);
		
			// Creating a Label to identify the encrypt text box
			// and giving its dimensions
		JLabel encryptLabel = new JLabel("Encrypt");
		encryptLabel.setPreferredSize(new Dimension(50,50));
		frame.getContentPane().add(encryptLabel);
		
		
			// Creating a text box for encrypted string
			// and giving the dimensions
		encryptText = new JTextField("");
		encryptText.setPreferredSize(new Dimension(300,50));
		encryptText.setName("Encryption");
		frame.getContentPane().add(encryptText);
		
			// Creating a Jbutton so that we can listen when to do the encryption/decryption
		JButton btn = new JButton("<>");
		btn.setPreferredSize(new Dimension(50,50));
		frame.getContentPane().add(btn);
		
		
			// Creating a text box for decrypted string
			// and giving the dimensions and aligning the text to right
		decryptText = new JTextField("");
		decryptText.setPreferredSize(new Dimension(300,50));
		decryptText.setName("Decryption");
		decryptText.setHorizontalAlignment(JTextField.RIGHT);
		frame.getContentPane().add(decryptText);
		
			// creating and giving a label to the decrypt textbox
			// and giving dimensions
		JLabel decryptLabel = new JLabel("Decrypt");
		decryptLabel.setPreferredSize(new Dimension(50,50));
		frame.getContentPane().add(decryptLabel);
		
			// Finilizing and setting the frame visible
		frame.pack();
		frame.setVisible(true);
		
		
			// working on buttons
			// setting up an actionlistener for when the button is pressed
			// setting up the action listener and its default actionperformed method
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent args0){
				
					// if-else clause to see if the textbox is empty and perform the 
					// encrypt and decrypt methods accordingly
					// and in case there is no input the click performs nothing
					// once the out put is given the input is set to empty
					// we take the output string and set it to the appropriate text box
				if(decryptText.getText().isEmpty()== true && encryptText.getText().isEmpty() == false ){
				output = btnPress(true, encryptText.getText());
				decryptText.setText(output);
				encryptText.setText("");
				
				}else if(decryptText.getText().isEmpty() == false && encryptText.getText().isEmpty() == true){
					output = btnPress(false, decryptText.getText());
					encryptText.setText(output);
					decryptText.setText("");
				}
				
			}
		});
		
		
		
			// Adding a focus listener to the textbox so as to clear the other text box 
			// when giving the input
		decryptText.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				encryptText.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
			// Adding a focus listener to the textbox so as to clear the other text box 
			// when giving the input
		encryptText.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				decryptText.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	
	
	
	
	
	public String btnPress(boolean check, String inp){
		// The inputstring may have white spaces in between
		// we remove the whitespaces and store the new string 
		// with the whitespaces removed as the "formattedString"
	String formattedString;
	formattedString = inp.replaceAll("\\s", "");// Removes the whitespaces
	
	
	
	
		// Then we find out the length of the "formattedString" 
		// this will give us the idea of what the size of the matrix should be
	int stringLength = 0;
	stringLength = formattedString.length();
	
	
	
		// Since the matrix has to be a square matrix + additional rows we find
		// the size of the square matrix by taking the square root of the length
	double takeSqrt;
	takeSqrt = Math.sqrt(stringLength);
	
	
	
	
		// The base integer of the square root will give us the number of columns 
		// that have to be taken for the matrix
		// and the number of rows that have to be there for the decryption is 
		// obtained by dividing the length of the input and the number of columns
	int column,row;
	column = (int) takeSqrt;
	row = stringLength/column;
	
	
		// Creating the object for the Solver class to get the encrypted/decrypted string
		// the Solver class contains methods to encrypt and decrypt the input string(formattedString)
	Solver getSolution = new Solver();
	
	
		
		// The check is set to true if the user wants to encrypt and it
		// is set false if the user wants to decrypt the input text
	if(check == false){
		
		System.out.println(getSolution.decrypt(formattedString, column, row));
		return getSolution.decrypt(formattedString, column, row);
	}
	else{
		System.out.println(getSolution.encrypt(formattedString, column, row, stringLength));
		return getSolution.encrypt(formattedString, column, row, stringLength);
	}

		
	}
	
}


