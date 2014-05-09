package Benutzer;

/*
 * @author Tobias Weitz
 * @version 1.0
 */
public class BenutzerNichtVorhandenException extends Exception
{
	public BenutzerNichtVorhandenException(String error)	{
		super(error);
	}
}