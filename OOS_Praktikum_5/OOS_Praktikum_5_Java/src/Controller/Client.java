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

package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JApplet;

import Benutzer.*;
import Frame.*;


public class Client extends JApplet{
	public Client(LoginFrame login)	{
		orb = new ClientOrb(this);
		db =  orb;
		this.login = login;
	}
	
	
	
	
	
	private void neuAnmeldung()	{
		login.stop();
		anmeldung = new AnmeldungsFrame(this);
	}
	public void neuAnmeldungRemote()	{
		neuAnmeldung();
	}
	
	
	public void neuerBenutzer(Benutzer newUser)	{
		try {
			db.benutzerEintragen(newUser);
		} catch (BenutzerSchonVorhandenException e) {
			anmeldung = new AnmeldungsFrame(this, "User always exist!");
			return;
		}
		login.setVisible(true);
		//login = new LoginFrame(this);
	}

	
	private void benutzerLogin(Benutzer user)	{
		if(db.benutzerOK(user))	{
			app = new AnwendungsFrame();
		} else	{
			login.error("User doesn't exist!");
		}
	}
	public void benutzerLoginRemote(Benutzer user)	{
		benutzerLogin(user);
	}
	public void setAddress(InetAddress address)	{
		orb.setAddress(address);
	}
	public void unknwonHost(UnknownHostException exception)	{
		//login = new LoginFrame(this, "Host doesn't exist!")
		login.error("Host doesn't exist!");
		login.setVisible(true);
	}
	
	
	public void printDB()	{
		System.out.println(db.toString());
	}
	
	
	private BenutzerVerwaltung db;
	private LoginFrame login;
	private AnmeldungsFrame anmeldung;
	private AnwendungsFrame app;
	private ClientOrb orb;
}
