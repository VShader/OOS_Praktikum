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


public class Server {
	public Server(boolean initDB)	{
		db = new BenutzerVerwaltungAdmin("remoteDB.s", initDB );
		orb = new ServerOrb(this);
	}
	
	
	
	public void initDB()	{
		db.dbInitialisieren("remoteDB.s");
	}
	
	
	public void neuerBenutzer(Benutzer newUser) throws BenutzerSchonVorhandenException	{
		db.benutzerEintragen(newUser);
	}
	public boolean benutzerLogin(Benutzer user)	{
		return db.benutzerOK(user);
	}
	
	
	public void printDB()	{
		System.out.println(db.toString());
	}
	public void run()	{
		orb.run();
	}
	
			
	
	public static void main(String[] args)	{
		Server server;
		
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
			server = new Server(true);
		} else	{
			server = new Server(false);
		}
		server.printDB();
		server.run();
	}
	
	
	
	private BenutzerVerwaltungAdmin db;
	private ServerOrb orb;
}
