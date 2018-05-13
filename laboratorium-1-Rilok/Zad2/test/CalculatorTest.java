import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calc = new Calculator();

	@Test
	public void addCheck(){
		assertEquals(10, calc.add(8, 2));
	}
	
	@Test
	public void subCheck(){
		assertEquals(1, calc.sub(10, 9));
	}
	
	@Test
	public void multiCheck(){
		assertEquals(25, calc.multi(5, 5));
	}
	
	@Test(expected = ArithmeticException.class)
	public void divby0Check(){
		calc.div(3, 0);
	}
	
	@Test
	public void divCheck(){
		assertEquals(3, calc.div(6, 2));
	}
	
	@Test
	public void greaterCheck(){
		assertEquals(true, calc.greater(10, 3));
	}
	
	@Test
	public void lessCheck(){
		assertEquals(true, calc.less(1, 3));
	}
	
	@Test
	public void equalCheck(){
		assertEquals(false, calc.equality(22, 15));
	}

}
