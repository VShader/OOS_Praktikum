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

import Benutzer.*;
import Frame.*;


public class Client {
	public Client(boolean initDB)	{
		lokal = new BenutzerVerwaltungAdmin("lokalDB.s", initDB );
		orb = new ClientOrb(this);
		db =  orb;
		login = new LoginFrame(this);
	}
	
	
	
	public void initDB()	{
		lokal.dbInitialisieren("lokalDB.s");
	}
	
	
	private void neuAnmeldung()	{
		anmeldung = new AnmeldungsFrame(this);
	}
	public void neuAnmeldungLokal()	{
		db = lokal;
		neuAnmeldung();
	}
	public void neuAnmeldungRemote()	{
		db = orb;
		neuAnmeldung();
	}
	
	
	public void neuerBenutzer(Benutzer newUser)	{
		try {
			db.benutzerEintragen(newUser);
		} catch (BenutzerSchonVorhandenException e) {
			anmeldung = new AnmeldungsFrame(this, "User always exist!");
			return;
		}
		login = new LoginFrame(this);
	}

	
	private void benutzerLogin(Benutzer user)	{
		if(db.benutzerOK(user))	{
			app = new AnwendungsFrame();
		} else	{
			login = new LoginFrame(this, "User doesn't exist!");
		}
	}
	public void benutzerLoginLokal(Benutzer user)	{
		db = lokal;
		benutzerLogin(user);
	}
	public void benutzerLoginRemote(Benutzer user)	{
		db = orb;
		benutzerLogin(user);
	}
	
	
	public void printDB()	{
		System.out.println(db.toString());
	}
	
			
	
	public static void main(String[] args)	{
		Client client;
		
		int dbInitialisieren = 0;
		BufferedReader din = new BufferedReader(
				new InputStreamReader(System.in));
				try {
					dbInitialisieren = Integer.parseInt(din.readLine());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		if(dbInitialisieren == 1)	{
			client = new Client(true);
		} else	{
			client = new Client(false);
		}
		client.printDB();
	}
	
	
	
	private BenutzerVerwaltung db;
	private BenutzerVerwaltungAdmin lokal;
	private LoginFrame login;
	private AnmeldungsFrame anmeldung;
	private AnwendungsFrame app;
	private ClientOrb orb;
}
