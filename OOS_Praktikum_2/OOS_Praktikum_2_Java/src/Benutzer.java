
public class Benutzer {

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
