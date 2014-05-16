package Frame;
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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Tobias Weitz
 *
 */
public class AnwendungsFrame extends JFrame{
	
	/**
	 * 
	 */
	public AnwendungsFrame()	{
		setTitle("AnwendungsFrame");
		setSize(new Dimension(400, 300));
		jLabel_go = new JLabel("Sie können jetzt loslegen!");
		jLabel_go.setBounds(67,60,289,28);
		jLabel_go.setFont(new java.awt.Font("Serif",1,20));
		jButton_quit = new JButton("Abbrechen?");
		jButton_quit.setBounds(87,140,189,128);
		jButton_quit.addActionListener(new ActionListener()	{
				public void actionPerformed(ActionEvent e)	{
					System.out.println("Abbrechen!");
					dispose();
				}
			});
		
		
		setLayout(null);
		add(jLabel_go);
		add(jButton_quit);
		setVisible(true);
	}
	
	private JLabel jLabel_go;
	private JButton jButton_quit;
}
