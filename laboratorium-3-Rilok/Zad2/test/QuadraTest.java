import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import org.junit.Before;
import org.junit.Test;

public class QuadraTest {

	private QuadraticFunction quad;
	static BufferedReader rdr;
	String line;
	String val;
	
	@Before
	public void setUp() throws Exception{
		rdr = new BufferedReader(new FileReader("test/test.txt"));
	}
	
	@Test
	public void testFromFile() throws Exception{
		while ((line = rdr.readLine()) != null){
			
			StringTokenizer st = new StringTokenizer(line);
			if (line.startsWith("#") || !st.hasMoreTokens()){
				continue;
			}
			
			//int ExX1 = Integer.valueOf(st.nextToken()).intValue();
			//int ExX2 = Integer.valueOf(st.nextToken()).intValue();
			
			System.out.println(st.countTokens());
			
			int[] arguments = new int[3];
			for (int i = 0; i < 3; i++){
				arguments[i] = Integer.parseInt(st.nextToken());
			}
			
			quad = QuadraticFunction.of(arguments[0], arguments[1], arguments[2]);
			
			assertEquals(1, quad.getX1(), 0);
		}
	}
	
}
