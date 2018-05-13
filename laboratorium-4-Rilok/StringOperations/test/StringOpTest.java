import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringOpTest {

	public StringOperations StrTest;
	
	@Before
	public void setUp() throws Exception {
		StrTest = new StringOperations();
	}
	
	@Test
	public void checkReverse() {
		assertThat(StrTest.reverse("Testowanie"), equalTo("einawotseT"));
	}
	
	@Test
	public void checkConcat() {
		assertThat(StrTest.concat("Testo", "viron"), equalTo("Testoviron"));
	}
	
	@Test
	public void checkConcat_SecondNull() {
		assertThat(StrTest.concat("testo", null), equalTo("testo"));
	}
	
	@Test
	public void checkConcat_FirstNull() {
		assertThat(StrTest.concat(null, "viron"), equalTo(null));
	}
	
	@Test
	public void checkConcat_FirstWithoutCharacter() {
		assertThat(StrTest.concat("", "viron"), equalTo(null));
	}
	
	@Test
	public void checkPalindrome_True() {
		assertThat(StrTest.isPalindrome("kajak"), is(true));
	}
	
	@Test
	public void checkPalindrome_OneCharacter() {
		assertThat(StrTest.isPalindrome("w"), is(true));
	}
	
	@After
	public void tearDown() throws Exception {
		StrTest = null;
	}

}
