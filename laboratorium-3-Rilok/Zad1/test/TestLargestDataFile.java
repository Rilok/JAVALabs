import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.junit.Before;
import org.junit.Test;

public class TestLargestDataFile {

	static BufferedReader rdr;
	String line;
	String val;
	
	@Before
	public void setUp() throws Exception {
		rdr = new BufferedReader(new FileReader("test/test.txt"));
	}
	
	@Test
	public void testFromFile() throws Exception {
		while((line = rdr.readLine()) != null) {
	
			StringTokenizer st = new StringTokenizer(line);
			if (line.startsWith("#") || !st.hasMoreTokens()) {
				continue;
			}
			
			int expected = Integer.valueOf(st.nextToken()).intValue();
			int counter = Integer.valueOf(st.countTokens()).intValue();
			System.out.print(counter);
			
			int[] arguments = new int[counter];
			for(int i=0; i<counter; i++) {
				arguments[i] = Integer.parseInt(st.nextToken());
			}
			assertEquals(expected, Largest.largest(arguments));
		}
	}

}
