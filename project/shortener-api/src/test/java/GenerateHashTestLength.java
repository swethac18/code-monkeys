import static org.junit.Assert.*;

import org.junit.Test;

import cmpe272.GenerateHash;
import junit.framework.Assert;

public class GenerateHashTestLength {

	@Test
	public void testHashLength() {
		Assert.assertEquals(7, GenerateHash.getHash("www.google.com").length());
	}
	
	
	
}
