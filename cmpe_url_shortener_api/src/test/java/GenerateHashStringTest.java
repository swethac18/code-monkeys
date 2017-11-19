import static org.junit.Assert.*;

import org.junit.Test;

import cmpe272.GenerateHash;
import junit.framework.Assert;

public class GenerateHashStringTest {
	
	@Test
	public void testHashValue() {
		Assert.assertEquals("d115d54", GenerateHash.getHash("http://myntra.com"));
	}

}
