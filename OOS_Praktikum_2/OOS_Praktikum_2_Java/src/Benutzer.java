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


import java.io.Serializable;


public class Benutzer implements Serializable{

	public Benutzer()	{
		userID="NEW User";
		passWord = new char[1];
	}
	public Benutzer(String userID, char[] passWord)	{
		this.userID=userID;
		this.passWord = passWord.clone();
	}
	public Benutzer(Benutzer ben)	{
		userID=ben.userID;
		passWord=ben.passWord;
	}
	
	public String getID()	{
		return userID;
	}
	
	public boolean equals(Benutzer ben)	{
		return userID.equals(ben.userID) &&
				String.copyValueOf(passWord).equals(String.copyValueOf(ben.passWord));
	}
	public String toString()	{
		return userID.toString()+String.copyValueOf(passWord).toString();
	}
	
//	public void benutzerEintragen(Benutzer ben) {
//		userID=ben.userID;
//		passWord=ben.passWord;
//	}
//	public boolean benutzerOK(Benutzer ben) {return equals(ben);}
//	
	
	private String userID;
	private char[] passWord;
}
