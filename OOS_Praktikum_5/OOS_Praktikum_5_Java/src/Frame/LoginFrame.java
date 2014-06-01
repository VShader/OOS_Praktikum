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
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Benutzer.Benutzer;
import Controller.Client;

import com.sun.glass.events.KeyEvent;
import com.sun.javafx.font.Disposer;

/**
 * @author Tobias Weitz
 *
 */
public class LoginFrame extends JApplet	{
	/**
	 * 
	 */
	public void init()	{
		//setTitle("LoginFrame");
		setSize(new Dimension(400, 350));
		
		// Create Elements
		JLabel jLabel_Management = new JLabel("Login Benutzerverwaltung");
		JLabel jLabel_UserID = new JLabel("User-ID");
		jTextField_UserID = new JTextField();
		JLabel jLabel_Password = new JLabel("Passwort");
		jPasswordField_Password = new JPasswordField();
		JLabel jLabel_IP = new JLabel("IP:");
		jTextField_IP = new JTextField();
		jCheckBox_NewLogin = new JCheckBox("Neu-Anmeldung?");
		jButton_Run = new JButton("Ausführen");
		
		// Set Positions
		jLabel_Management.setBounds(67,10,289,28);
		jLabel_Management.setFont(new java.awt.Font("Serif",1,20));
		jLabel_UserID.setBounds(17,60,289,28);
		jTextField_UserID.setBounds(77,60,189,28);
		jLabel_Password.setBounds(17,90,289,28);
		jPasswordField_Password.setBounds(77,90,189,28);
		jLabel_IP.setBounds(107,150,20,28);
		jTextField_IP.setBounds(127,150,189,28);
		jCheckBox_NewLogin.setBounds(87,200,289,28);
		jButton_Run.setBounds(87,250,100,30);
		
		// Add ActionListner
		jCheckBox_NewLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				neuAnmeldung=jCheckBox_NewLogin.isSelected();
				System.out.println(neuAnmeldung);
			}
		});
		jButton_Run.addActionListener(new ActionListener()	{
				public void actionPerformed(ActionEvent e)	{
					try	{
						address = InetAddress.getByName(jTextField_IP.getText());
						controller.setAddress(address);
					} catch(UnknownHostException exception)	{
						controller.unknwonHost(exception);
						return;
					}
					if(neuAnmeldung == true)	{
						controller.neuAnmeldungRemote();
					} else	{
						controller.benutzerLoginRemote(new Benutzer(jTextField_UserID.getText(), 
								jPasswordField_Password.getPassword()));
					}
				}
			});
		
		jTextField_UserID.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				jTextField_UserID.setFont(textFont);
			}
		});
	
		// Add Elements
		getContentPane().setLayout(null);
		getContentPane().add(jLabel_Management);
		getContentPane().add(jLabel_UserID);
		getContentPane().add(jTextField_UserID);
		getContentPane().add(jLabel_Password);
		getContentPane().add(jPasswordField_Password);
		getContentPane().add(jLabel_IP);
		getContentPane().add(jTextField_IP);
		getContentPane().add(jCheckBox_NewLogin);
		getContentPane().add(jButton_Run);
		getContentPane().setVisible(true);
		
		controller = new Client(this);
	}
//	public LoginFrame(Client controller)	{
//		this.controller = controller;
//	}
//	public LoginFrame(Client controller, String errorMessage)	{
//		this(controller);
//		textFont = jTextField_UserID.getFont();
//		jTextField_UserID.setFont(new java.awt.Font("Serif",1,15));
//		jTextField_UserID.setText(errorMessage);
//		
//		jTextField_UserID.addKeyListener(new KeyAdapter() {
//			public void keyTyped(KeyEvent arg0) {
//				jTextField_UserID.setFont(textFont);
//			}
//		});
//	}
	
	public void error(String errorMessage)	{
		textFont = jTextField_UserID.getFont();
		jTextField_UserID.setFont(new java.awt.Font("Serif",1,15));
		jTextField_UserID.setText(errorMessage);
	}

	
	private JTextField jTextField_UserID;
	private JPasswordField jPasswordField_Password;
	private JTextField jTextField_IP;
	private JCheckBox jCheckBox_NewLogin;
	private JButton jButton_Run;
	private boolean neuAnmeldung = false;
	private InetAddress address;
	private Client controller;
	private java.awt.Font textFont;

}
