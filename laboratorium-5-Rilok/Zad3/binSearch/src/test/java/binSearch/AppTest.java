package binSearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	App bin;
	
	@BeforeEach
	public void Initialize(){
		bin = new App();
	}
	
	@Test
	public void TestBinary(){
		int arr[] = {2, 3, 10, 15, 35};
		int x = 35;
		int expected = 4;
		int result = bin.binarySearch(arr, x);
		assertEquals(result, expected);
	}
	
	@Test
	public void SearchLeastNumberPosition(){
		int arr[] = {3, 3, 5, 7, 9, 1};
		int x = 3;
		int expected = 0;
		int result = bin.binarySearch(arr, x);
		assertEquals(expected, result);
	}
}
