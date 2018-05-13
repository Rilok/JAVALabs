import static org.junit.Assert.*;
import org.junit.*;

public class SortingTest {
    private Sorting test;

    @Before
    public void setUp(){
        Integer[] testingArray = { 8, 1, 11, -5 };
        test = new Sorting(testingArray);
    }

    @Test
    public void SortAscendingShouldWork() {
        Integer[] expected = {-5, 1, 8, 11 };
        test.SortArray("R");
        assertArrayEquals(expected, test.getTable());
    }

    @Test
    public void SortDescendingShouldWork() {
        Integer[] expected = { 11, 8, 1, -5 };
        test.SortArray("M");
        assertArrayEquals(expected, test.getTable());
    }

    @Test
    public void TableLengthIsZero(){
        Integer[] temp = {};
        test = new Sorting(temp);
        try{
            test.SortArray("M");
        }catch (NullPointerException e){
            assertTrue(true);
        }
    }

    @Test
    public void TableIsNull(){
        test = new Sorting(null);
        try{
            test.SortArray("R");
        }catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }

    @Test
    public void IsTableSortedDesc(){
        test.SortArray("M");
        assertTrue(test.isSorted("M"));
    }

    @Test
    public void IsTableSortedAsc(){
        test.SortArray("R");
        assertTrue(test.isSorted("R"));
    }

    @Test
    public void PrintSortedArrayAsc(){
        test.SortArray("R");
        test.showArray();
    }

    @Test
    public void PrintSortedArrayDesc(){
        test.SortArray("M");
        test.showArray();
    }

    @After
    public void tearDown(){
        test = null;
    }
}
