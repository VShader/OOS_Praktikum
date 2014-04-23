import java.util.HashMap;
import java.io.*;


public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung{

	public BenutzerVerwaltungAdmin()	{
		userMap = new HashMap<String, Benutzer>();
	}
	
	
	public void benutzerEintragen(Benutzer ben) throws BenutzerException {
		if(userMap.put(ben.getID(), new Benutzer(ben)) != null)	{
			throw new BenutzerException("Error! User "+ben.getID()+" is always in HashMap!");
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
	public void benutzerLoeschen(Benutzer ben) throws BenutzerException	{
		if(userMap.remove(ben.getID())== null)	{
			throw new BenutzerException("Error! No User: "+ben.getID()+" found!");
		}
		else	{
			saveDB();
		}
	}
	public void dbInitialisieren()	{
		saveDB();
	}

	
	private HashMap<String, Benutzer> userMap;
	
	private void saveDB()	{
		try	{
			FileOutputStream fs = new FileOutputStream("db.s");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(userMap);
			os.close();
		}catch(IOException exception)	{
			exception.printStackTrace();
		}
	}
	private void readDB()	{
		try	{
			FileInputStream is = new FileInputStream("db.s");
			ObjectInputStream os = new ObjectInputStream(is);
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
			
		} catch(BenutzerException exception)	{
			exception.printStackTrace();
		}
		
	}
}
