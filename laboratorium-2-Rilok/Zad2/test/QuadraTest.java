import static org.junit.Assert.*;

import org.junit.Test;

public class QuadraTest {
	private QuadraticFunction quad;
	
	@Test
	public void QuadCheckOneZeroPoint(){
		int a = 2;
		int b = -4;
		int c = 2;
		quad = QuadraticFunction.of(a, b, c);
		assertEquals(1, quad.getX1(), 0);
	}
	
	@Test
	public void QuadCheckTheSameZeroPoint(){
		int a = 2;
		int b = -4;
		int c = 2;
		quad = QuadraticFunction.of(a, b, c);
		assertEquals(quad.getX2(), quad.getX1(), 0);
	}

	@Test 
	public void QuadCheckTwoZeroPoints_part1(){
		quad = QuadraticFunction.of(0, 0, -2);
		assertEquals(1, quad.getX1(), 0);
	}
	
	@Test
	public void QuadCheckTwoZeroPoints_part2(){
		int a = 1;
		int b = 5;
		int c = 4;
		quad = QuadraticFunction.of(a, b, c);
		assertEquals(-1, quad.getX2(), 0);
	}
}
