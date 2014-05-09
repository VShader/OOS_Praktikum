package Test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Benutzer.Benutzer;
import Benutzer.BenutzerNichtVorhandenException;
import Benutzer.BenutzerSchonVorhandenException;
import Benutzer.BenutzerVerwaltungAdmin;


public class BenutzerVerwaltungAdminTest {
	public BenutzerVerwaltungAdminTest() {
		testAdmin = new BenutzerVerwaltungAdmin();
	}
	
	@Before
	public void Init()	{
		testAdmin.dbInitialisieren();
	}
	
	
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testBenutzerEintragen()	{
		try {
			testAdmin.benutzerEintragen(new Benutzer("Testuser", new char[] {'t','e'}));
		} catch (BenutzerSchonVorhandenException e) {
			fail("User alway in DB");
		}
		try {
			testAdmin.benutzerEintragen(new Benutzer("Testuser", new char[] {'t','e'}));
		} catch (BenutzerSchonVorhandenException e) {
			
		}
	}
	
	@Test
	public void testBenutzerOK()	{
		Benutzer ben1 = new Benutzer("Testuser1", new char[] {'t','e'});
		Benutzer ben2 = new Benutzer("Testuser2", new char[] {'t','e'});
		try {
			testAdmin.benutzerEintragen(ben1);
		} catch (BenutzerSchonVorhandenException e) {
			fail("User alway in DB");
		}
		assertTrue(testAdmin.benutzerOK(ben1));
		assertFalse(testAdmin.benutzerOK(ben2));
	}
	
	@Test
	public void testBenutzerLoeschen() {
		Benutzer ben1 = new Benutzer("Testuser1", new char[] {'t','e'});
		Benutzer ben2 = new Benutzer("Testuser2", new char[] {'t','e'});
		try {
			testAdmin.benutzerEintragen(ben1);
			testAdmin.benutzerLoeschen(ben1);
		} catch (BenutzerSchonVorhandenException e) {
			fail("User always in DB");
		} catch (BenutzerNichtVorhandenException e)	{
			fail("User not in DB");
		}
		try {
			testAdmin.benutzerLoeschen(ben1);
			fail("User didn't throw exception");
		} catch (BenutzerNichtVorhandenException e)	{
			
		}
		assertEquals(false, testAdmin.benutzerOK(ben1));
	}
	
	
	
	private BenutzerVerwaltungAdmin testAdmin;
}
