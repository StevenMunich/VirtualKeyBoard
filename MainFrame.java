
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Timer
import java.util.Timer;
import java.util.TimerTask;
import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.BufferCapabilities.FlipContents;
import java.awt.Button;
import java.awt.Component;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.FocusTraversalPolicy;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.Window;
//Mouse
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
//GUI
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.constant.Constable;
import java.nio.CharBuffer;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.io.File;
import java.io.FileReader;

import javax.swing.JToggleButton;
import javax.swing.SortingFocusTraversalPolicy;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JOptionPane;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent; //Message Box
import javax.swing.JFileChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.MouseAdapter;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.SwingConstants; //Save File Dialog Box



public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	

	public static void main(String[] args){		
				
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					System.out.println("started");			
					
	}//end of main

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		//------------------------------Window Setup-------------------------
		JTextArea CMD = new JTextArea(); 
		CMD.setBackground(Color.WHITE);
		CMD.setVisible(true);
		getContentPane().setLayout(null);
		setTitle("Virtual Keyboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 640); //500 is height of window
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		CMD.setEditable(false);
		CMD.setBounds(10, 11, 727, 188);
		contentPane.add(CMD);

		//Button Location parameters
		int x = 10;
		int y = 210;
		int width = 50;
		int height = 40;
		
		int ColumnCounter = 1; //In loop Counter
		final int MAX = 12;
		
		int i;
		for ( i = 33 ; i < 127; i++) { //original 65 to 90 for just a-z
			
			JButton btn1 = new JButton(Character.toString(i));
			btn1.setBounds(x, y, width, height); //65 to 90 add 43 to X and 37 to Y
			contentPane.add(btn1);
			btn1.setVisible(true);
			
			btn1.addActionListener(new ActionListener() { //Register Event for Each Object
				@Override
				public void actionPerformed(ActionEvent e) {
					CMD.append(btn1.getText());	//Append The TextBox
				}
			});
			//continue For Loop	
			x += 55;			
			if(ColumnCounter > MAX) {
				y += 45;//next row
				x = 10; //reset X
				ColumnCounter = 0;
			}//end If 
			ColumnCounter++;	
		}
		//end For Loop
		
		
//-----------------Aggregated Event Listener Registration--------------------------------------------
		
		JButton btnClearAllButton = new JButton("DELETE EVERY COMMAND");
		btnClearAllButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClearAllButton.setForeground(new Color(255, 0, 0));
		btnClearAllButton.setBounds(x, y, 225, 40);
		contentPane.add(btnClearAllButton); 
		
		x+=240; //SHIFT X Position for next button
		
		JButton btnDeleteCMDButton = new JButton("<--Same Thing, Aggregated Events");
		btnDeleteCMDButton.setBounds(x, y, 314, 40);
		contentPane.add(btnDeleteCMDButton);

		List<JButton> buttons = new ArrayList();
		
		buttons.add(btnDeleteCMDButton);
		buttons.add(btnClearAllButton);
		
		for(JButton jButton : buttons) {
			jButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					//System.out.println("Hello from " + this.toString());
					CMD.setText("");
					
				}
			});
		}
		
	}
} //End of Class

//USER ERROR CODES:
// 103 - Error File Write
// 603 - Error File Read - First char is an invalid command.


//IF you do not generate Buttons like in this program and lay them out in designer they will load slowly
//FIX:
//this.pack(); //shrink window
//this.setMinimumSize(new Dimension(609, 500)); //reset minimum size
//this.pack(); //shrink again









//-------------SCRAP CODE-----------------
//			MainFrame secondary = new MainFrame(); //used to create another window
		//	secondary.setVisible(true);
//			secondary.rdbtnGAY.setEnabled(true); //doesn't work

/* COMPONENTS:
 * 		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(476, 77, 121, 23);
		contentPane.add(tglbtnNewToggleButton);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("pass");
		passwordField.setBounds(337, 169, 109, 20);
		contentPane.add(passwordField);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("add\r\nsyb\r\nmker");
		menuBar.setBounds(265, 314, 101, 22);
		contentPane.add(menuBar);
		
		
---------------INSIDE FRAME CONSTRUCTOR--------------------
		
			//DELETE SINGLE COMMAND - MUST BE FIXED
		btnDeleteCMDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StringBuilder s = new StringBuilder(CMD.getText());
				
				//CMD.setRows(4);
				//System.out.println(CMD.getSelectedText() + "Start Index: " + CMD.getSelectionStart() + "End index:" + CMD.getSelectionEnd());			
				s.replace(CMD.getSelectionStart(), CMD.getSelectionEnd(), "");
				
				//CMD.setText("ASSHOLE"); //this works and can be used as an exploit. Validate & surround Crown with Try-Catch
				CMD.setText(s.toString());
			}
		});
		
		//DELETE EVERY COMMAND
		btnClearAllButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {							
			int dialogButton = JOptionPane.YES_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null,"Do you want to delete everything?","Delete", dialogButton);		
						
			if(dialogResult == JOptionPane.YES_OPTION)			
				CMD.setText("");
		} });
		

 * 
 * 
 */
 