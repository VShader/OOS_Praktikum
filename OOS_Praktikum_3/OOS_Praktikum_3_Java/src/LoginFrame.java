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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import sun.net.InetAddressCachePolicy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import Benutzer.*;

public class LoginFrame extends JFrame	{
	LoginFrame()	{
		setTitle("LoginFrame");
		setSize(new Dimension(400, 350));
		
		// Create Elements
		JLabel jLabel_Management = new JLabel("Login Benutzerverwaltung");
		JLabel jLabel_UserID = new JLabel("User-ID");
		jTextField_UserID = new JTextField();
		JLabel jLabel_Password = new JLabel("Passwort");
		jPasswordField_Password = new JPasswordField();
		jCheckBox_Remote = new JCheckBox("remote?");
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
		jCheckBox_Remote.setBounds(17,150,89,28);
		jLabel_IP.setBounds(107,150,20,28);
		jTextField_IP.setBounds(127,150,189,28);
		jCheckBox_NewLogin.setBounds(87,200,289,28);
		jButton_Run.setBounds(87,250,100,30);
		
		// Initialize Elements
		jTextField_IP.setEditable(false);
		
		// Add ActionListner
		jCheckBox_Remote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lokal=!jCheckBox_Remote.isSelected();
				jTextField_IP.setEditable(!lokal);
				System.out.println(lokal);
			}
		});
		jCheckBox_NewLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				neuAnmeldung=jCheckBox_NewLogin.isSelected();
				System.out.println(neuAnmeldung);
			}
		});
		jButton_Run.addActionListener(new ActionListener()	{
				public void actionPerformed(ActionEvent e)	{
					if(lokal==false)	{
						try	{
							address = InetAddress.getByName(jTextField_IP.getText());
						} catch(UnknownHostException exception)	{
							exception.printStackTrace();
						}
					}
					Benutzer user = new Benutzer(jTextField_UserID.getText(), 
							jPasswordField_Password.getPassword());
					System.out.println(user.toString());
					dispose();
				}
			});
	
		// Add Elements
		setLayout(null);
		add(jLabel_Management);
		add(jLabel_UserID);
		add(jTextField_UserID);
		add(jLabel_Password);
		add(jPasswordField_Password);
		add(jCheckBox_Remote);
		add(jLabel_IP);
		add(jTextField_IP);
		add(jCheckBox_NewLogin);
		add(jButton_Run);
		setVisible(true);
	}

	
	private JTextField jTextField_UserID;
	private JPasswordField jPasswordField_Password;
	private JTextField jTextField_IP;
	private JCheckBox jCheckBox_Remote;
	private JCheckBox jCheckBox_NewLogin;
	private JButton jButton_Run;
	private boolean lokal = true;
	private boolean neuAnmeldung = false;
	private InetAddress address;

}
