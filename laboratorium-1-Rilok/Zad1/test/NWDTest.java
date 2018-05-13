import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NWDTest {

	NWD nwd;
	
	@Before
	public void setUp() throws Exception {
		nwd = new NWD();
	}

	@After
	public void tearDown() throws Exception {
		nwd = null;
	}
	
	@Test(expected = NullPointerException.class)
	public void CheckDoubleNull(){
		Integer zero = null;
		int result = nwd.nwd(zero, zero);
		assertEquals(null, result);
	}
	
	@Test
	public void CheckFirstZero(){
		assertEquals(9, nwd.nwd(0, 9));
	}
	
	@Test
	public void CheckSecondZero(){
		assertEquals(9, nwd.nwd(9, 0));
	}
	
	@Test
	public void NWDCheck(){
		assertEquals(1,nwd.nwd(17, 3));
	}

	public void CheckFirst(){
		assertEquals(1, nwd.nwd(7, 17));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Nwd_FirstNegative(){
		nwd.nwd(3, -2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Nwd_SecondNegative(){
		nwd.nwd(-3, 2);
	}
}
