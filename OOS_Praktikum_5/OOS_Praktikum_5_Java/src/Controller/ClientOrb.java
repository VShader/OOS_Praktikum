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

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import Benutzer.*;

public class ClientOrb implements BenutzerVerwaltung	{

	ClientOrb(Client client)	{
		this.client = client;
	}
	
	public void setAddress(InetAddress address)	{
		this.address = address;
	}
	
	
	public void benutzerEintragen(Benutzer ben)
			throws BenutzerSchonVorhandenException {
		try {
			server = new Socket(address, 1337);
			out = new ObjectOutputStream(server.getOutputStream());
			in = new ObjectInputStream(server.getInputStream());
			
			out.writeInt(1);
			out.writeObject(ben);
			switch(in.readInt())	{
				case 0:
					server.close();
					return;

				case 1:
					BenutzerSchonVorhandenException e = (BenutzerSchonVorhandenException)in.readObject();
					server.close();
					throw e;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean benutzerOK(Benutzer ben) {
		// TODO Auto-generated method stub
		try {
			server = new Socket(address, 1337);
			out = new ObjectOutputStream(server.getOutputStream());
			in = new ObjectInputStream(server.getInputStream());
			
			out.writeInt(0);
			out.writeObject(ben);
			out.flush();
			boolean result =  in.readBoolean();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(address.toString());
		return false;
	}
	
	
	

	
	private Client client;
	private InetAddress address;
	private Socket server;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private enum sendType {benutzerEintragen, benutzerOK};
}
