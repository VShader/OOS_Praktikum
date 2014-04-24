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

import java.util.HashMap;
import java.io.*;


public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung{

	public BenutzerVerwaltungAdmin()	{
		userMap = new HashMap<String, Benutzer>();
	}
	
	
	public void benutzerEintragen(Benutzer ben) throws BenutzerSchonVorhandenException {
		if(userMap.put(ben.getID(), new Benutzer(ben)) != null)	{
			throw new BenutzerSchonVorhandenException("Error! User "+ben.getID()+" is always in HashMap!");
		}
		else	{
			saveDB();
		}
	}
	public boolean benutzerOK(Benutzer ben) {
		try	{
			return userMap.get(ben.getID()).equals(ben);
		}catch(NullPointerException exception)
		{
			return false;
		}
	}
	public void benutzerLoeschen(Benutzer ben) throws BenutzerNichtVorhandenException	{
		if(userMap.remove(ben.getID())== null)	{
			throw new BenutzerNichtVorhandenException("Error! No User: "+ben.getID()+" found!");
		}
		else	{
			saveDB();
		}
	}
	public void dbInitialisieren()	{
		userMap.clear();
		saveDB();
	}

	
	private HashMap<String, Benutzer> userMap;
	
	private void saveDB()	{
		try	{
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("db.s"));
			os.writeObject(userMap);
			os.close();
		}catch(IOException exception)	{
			exception.printStackTrace();
		}
	}
	private void readDB()	{
		try	{
			ObjectInputStream os = new ObjectInputStream(new FileInputStream("db.s"));
			userMap = (HashMap<String, Benutzer>)os.readObject();
			os.close();
		} catch(IOException exception)	{
			exception.printStackTrace();
		} catch(ClassNotFoundException exception)	{
			exception.printStackTrace();
		}
		
	}
	
	public static void main(String[] str)
	{
		try	{
			BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();
			//admin.dbInitialisieren();
			admin.readDB();
//			admin.benutzerEintragen(new Benutzer("Ente", new char[]{'a','s','d'}));
			System.out.println(admin.benutzerOK(new Benutzer("Ente", new char[]{'a','s','d'})));
			admin.benutzerLoeschen(new Benutzer("Ente", new char[]{'a','s','d'}));
			System.out.println(admin.benutzerOK(new Benutzer("Ente", new char[]{'a','s','d'})));
			
		} catch(BenutzerNichtVorhandenException exception)	{
			exception.printStackTrace();
		}
		
	}
}
