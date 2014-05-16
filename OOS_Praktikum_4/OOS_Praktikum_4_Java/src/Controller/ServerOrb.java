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
import java.net.ServerSocket;
import java.net.Socket;

import Benutzer.Benutzer;
import Benutzer.BenutzerSchonVorhandenException;

public class ServerOrb	{

	public ServerOrb(Server server) {
		this.server = server;
		try {
			socket = new ServerSocket(1337);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void neuerBenutzer(Benutzer newUser)	{
		try {
			server.neuerBenutzer(newUser);
		} catch (BenutzerSchonVorhandenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean benutzerLogin(Benutzer user)	{
		return server.benutzerLogin(user);
	}
	
	
	public void run()	{
		while(true)	{
			try {
				Thread requestHandler = new Thread(new RequestHandler(socket.accept(), this));
				requestHandler.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	private ServerSocket socket;
	private Server server;
}



class RequestHandler implements Runnable	{
	public RequestHandler(Socket client, ServerOrb orb)	{
		this.client = client;
		this.orb = orb;
	}
	public void run()	{
		
	}
	
	private Socket client;
	private ServerOrb orb;
}
