package Test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import Benutzer.Benutzer;

public class BenutzerTest {

	@Test
	public void testEquals() {
		Benutzer testUser1 = new Benutzer("test" , new char[]{'t'});
		Benutzer testUser2 = new Benutzer("test" , new char[]{'t'});
		assertEquals(true, testUser1.equals(testUser2));
//		fail("Not yet implemented");
	}

}
