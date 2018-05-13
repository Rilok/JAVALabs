import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NWWTest {

	NWD nwd;
	NWW nww;
	
	@Before
	public void setUp() throws Exception {
		nwd = new NWD();
		nww = new NWW();
		
	}

	@After
	public void tearDown() throws Exception {
		nwd = null;
		nww = null;
	}

	@Test
	public void NwwCheck(){
		assertEquals(54, nww.nww(18, 27));
	}
	
	public void CheckFirst(){
		assertEquals(119, nww.nww(7, 17));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Nww_FirstZero(){
		nww.nww(0, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Nww_SecondZero(){
		nww.nww(5, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Nww_FirstNegative(){
		nww.nww(3, -2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Nww_SecondNegative(){
		nww.nww(-3, 2);
	}

}
