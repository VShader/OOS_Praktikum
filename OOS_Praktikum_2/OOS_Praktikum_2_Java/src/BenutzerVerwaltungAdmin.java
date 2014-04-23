import java.util.HashMap;


public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung{

	public BenutzerVerwaltungAdmin()	{
		userMap = new HashMap<String, Benutzer>();
	}
	
	
	public void benutzerEintragen(Benutzer ben) throws BenutzerException {
		if(userMap.put(ben.getID(), new Benutzer(ben)) != null)	{
			throw new BenutzerException("Error! User "+ben.getID()+" is always in HashMap!");
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
	}
	
	
	private HashMap<String, Benutzer> userMap;
	
	
	
	public static void main(String[] str)
	{
		try	{
			BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();
			admin.benutzerEintragen(new Benutzer("Ente", new char[]{'a','s','d'}));
			System.out.println(admin.benutzerOK(new Benutzer("Ente", new char[]{'a','s','d'})));
			admin.benutzerLoeschen(new Benutzer("Enter", new char[]{'a','s','d'}));
		} catch(BenutzerException exception)
		{
			exception.printStackTrace();
		}
	}
}
