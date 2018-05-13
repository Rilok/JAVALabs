import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalcHamTest {

	private Calc calc;
	
	@Before
	public void setUp(){
		calc = new Calc();
	}
	
	@Test
	public void addCheck(){
		assertThat(15.0, equalTo(calc.add(6, 9)));
	}
	
	@Test
	public void subCheckFalse(){
		assertThat(22.0, not(equalTo(calc.sub(12, 5))));
	}
	
	@Test
	public void subCheck(){
		assertThat(calc.sub(12, 5), not(equalTo(12)));
	}
	
	@Test
	public void multiCheck(){
		assertThat(calc.multi(5, 4), equalTo(20.0));
	}
	
	@Test
	public void divCheckFalse(){
		assertThat(calc.div(33, 11), not(equalTo(4)));
	}
	
	@Test
	public void divCheck(){
		assertThat(calc.div(51, 3), equalTo(17.0));
	}
	//DELTA CHECK
	
	@Test
	public void countingDelta(){
		assertThat(calc.sub(calc.multi(12.1, 12.1), calc.multi(4, calc.multi(5.2, 7.3))), closeTo(-5.43, 0.01));
	}
	
	
	//END DELTA CHECK
	
	@Test
	public void greaterCheckTrue(){
		assertTrue(calc.greater(15, 3));
	}
	
	@Test
	public void greaterCheckFalse(){
		assertFalse(calc.greater(13, 20));
	}
	
	@Test
	public void lessCheckTrue(){
		assertTrue(calc.less(22, 51));
	}
	
	@Test
	public void lessCheckFalse(){
		assertFalse(calc.less(18, 9));
	}
	
	@Test
	public void equalityCheckTrue(){
		assertTrue(calc.equality(11, calc.add(5, 6)));
	}
	
	@Test
	public void equalityCheckFalse(){
		assertFalse(calc.equality(calc.add(5, 2), calc.sub(11, 3)));
	}
	
	@After
	public void tearDown(){
		calc = null;
	}

}
