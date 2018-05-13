package com.calcTest.calcAssertJTest;

import static org.assertj.core.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalcTest {

	public Calc calc;
	
	@Before
	public void setUp() throws Exception {
		calc = new Calc();
	}

	@Test
	public void addCheck() {
		assertThat(15.0).isEqualTo(calc.add(6, 9));
	}
	
	@Test
	public void addCheckFalse() {
		assertThat(calc.add(21, 37)).isNotEqualTo(50.0);
	}
	
	@Test
	public void subCheck() {
		assertThat(calc.sub(12, 5)).isEqualTo(7.0);
	}
	
	@Test
	public void subCheckFalse() {
		assertThat(22.0).isNotEqualTo(calc.sub(33, 15));
	}
	
	@Test
	public void multiCheck() {
		assertThat(calc.multi(5, 4)).isEqualTo(20.0);
	}
	
	@Test
	public void multiCheckFalse() {
		assertThat(calc.multi(14, 88)).isNotEqualTo(213.7);
	}
	
	@Test
	public void divCheck() {
		assertThat(calc.div(51, 3)).isEqualTo(17.0);
	}
	
	@Test
	public void divCheckFalse() {
		assertThat(calc.div(33, 11)).isNotEqualTo(4.0);
	}
	
	//CHECK DELTA
	@Test
	public void countingDelta() {
		assertThat(calc.sub(calc.multi(12.1, 12.1), calc.multi(4, calc.multi(5.2, 7.3)))).isCloseTo(-5.43, within(0.01));
	}
	//END DELTA CHECK
	
	@Test
	public void greaterCheckTrue() {
		assertThat(calc.greater(15.6, 13.8)).isTrue();
	}
	
	@Test
	public void greaterCheckFalse() {
		assertThat(calc.greater(18.2, 21.15)).isFalse();
	}
	
	@Test
	public void lessCheckTrue() {
		assertThat(calc.less(22, 51)).isTrue();
	}
	
	@Test
	public void lessCheckFalse() {
		assertThat(calc.less(18.6, 12.3)).isFalse();
	}
	
	@Test
	public void equalityCheckTrue() { 
		assertThat(calc.equality(11, calc.add(5, 6))).isTrue();
	}
	
	@Test
	public void equalityCheckFalse() {
		assertThat(calc.equality(calc.add(5, 2), calc.sub(11, 3))).isFalse();
	}
	
	@After
	public void tearDown() throws Exception {
		calc = null;
	}

	
}
