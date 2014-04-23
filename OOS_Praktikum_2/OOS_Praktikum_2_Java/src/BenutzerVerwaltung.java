
interface BenutzerVerwaltung {
	public void benutzerEintragen(Benutzer ben) throws BenutzerException;
	public boolean benutzerOK(Benutzer ben) throws BenutzerException;
}

class BenutzerException extends Exception
{
	public BenutzerException(String error)	{
		super(error);
	}
}