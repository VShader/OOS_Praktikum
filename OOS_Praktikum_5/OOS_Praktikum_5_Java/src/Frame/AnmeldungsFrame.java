/*
 * Copyright (c) <2014> <Tobias Weitz>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

package Frame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Benutzer.Benutzer;
import Controller.Client;

/**
 * @author Tobias Weitz
 *
 */
public class AnmeldungsFrame extends JFrame	{
	/**
	 * 
	 */
	public AnmeldungsFrame()	{
		setTitle("LoginFrame");
		setSize(new Dimension(350, 280));
		
		// Create Elements
		JLabel jLabel_Registration = new JLabel("Anmeldung");
		JLabel jLabel_UserID = new JLabel("User-ID");
		jTextField_UserID = new JTextField();
		JLabel jLabel_Password = new JLabel("Passwort");
		jPasswordField_Password = new JPasswordField();
		JLabel jLabel_Repeat = new JLabel("Wiederholung");
		jPasswordField_Repeat = new JPasswordField();
		jButton_Run = new JButton("Ausführen");
		
		// Set Positions
		jLabel_Registration.setBounds(67,10,289,28);
		jLabel_Registration.setFont(new java.awt.Font("Serif",1,20));
		jLabel_UserID.setBounds(17,60,80,28);
		jTextField_UserID.setBounds(100,60,189,28);
		jLabel_Password.setBounds(17,100,80,28);
		jPasswordField_Password.setBounds(100,100,189,28);
		jLabel_Repeat.setBounds(17,140,80,28);
		jPasswordField_Repeat.setBounds(100,140,189,28);
		jButton_Run.setBounds(87,200,100,30);
		
		
		// Initialize Elements
		echoChar = jPasswordField_Password.getEchoChar();
		passwordFont = jPasswordField_Password.getFont();
		
		// Add ActionListner
		jPasswordField_Password.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				jPasswordField_Password.setFont(passwordFont);
				jPasswordField_Password.setEchoChar(echoChar);
			}
		});
		
		jButton_Run.addActionListener(new ActionListener()	{
				public void actionPerformed(ActionEvent e)	{
					char[] tempPW = jPasswordField_Password.getPassword();

					if(tempPW.length == 0)	{
						jPasswordField_Password.setEchoChar((char)0);
						jPasswordField_Password.setFont(new java.awt.Font("Serif",1,15));
						jPasswordField_Password.setText("Geben Sie ein Passwort ein!");
						return;
					}
					if(Arrays.equals(tempPW,
							jPasswordField_Repeat.getPassword()))	{
						controller.neuerBenutzer(new Benutzer(jTextField_UserID.getText(), 
								jPasswordField_Password.getPassword()));
						dispose();
					}
					else	{
						jPasswordField_Password.setEchoChar((char)0);
						jPasswordField_Password.setFont(new java.awt.Font("Serif",1,15));
						jPasswordField_Password.setText("Falsche Wiederholung!");
						jPasswordField_Repeat.setText(null);
					}
				}
			});
	
		// Add Elements
		setLayout(null);
		add(jLabel_Registration);
		add(jLabel_UserID);
		add(jTextField_UserID);
		add(jLabel_Password);
		add(jPasswordField_Password);
		add(jPasswordField_Repeat);
		add(jLabel_Repeat);
		add(jButton_Run);
		setVisible(true);
	}
	public AnmeldungsFrame(Client controller)	{
		this();
		this.controller = controller;
	}
	public AnmeldungsFrame(Client controller, String errorMessage)	{
		this(controller);
		jTextField_UserID.setFont(new java.awt.Font("Serif",1,15));
		jTextField_UserID.setText(errorMessage);
		
		jTextField_UserID.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				jTextField_UserID.setFont(passwordFont);
				
			}
		});
	}

	
	private JTextField jTextField_UserID;
	private JPasswordField jPasswordField_Password;
	private JPasswordField jPasswordField_Repeat;
	private JButton jButton_Run;
	private char echoChar;
	private java.awt.Font passwordFont;
	private Client controller;

}
