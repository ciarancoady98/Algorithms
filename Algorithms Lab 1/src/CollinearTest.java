import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author  Ciaran Coady
 *  @version 27/09/18 12:21:26
 */
@RunWith(JUnit4.class)
public class CollinearTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new Collinear();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the two methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
        int expectedResult = 0;

        assertEquals("countCollinear failed with 3 empty arrays",       expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
        assertEquals("countCollinearFast failed with 3 empty arrays", expectedResult, Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleFalse()
    {
        int[] a3 = { 15 };
        int[] a2 = { 5 };
        int[] a1 = { 10 };

        int expectedResult = 0;

        assertEquals("countCollinear({10}, {5}, {15})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleTrue()
    {
        int[] a3 = { 15, 5 };       int[] a2 = { 5 };       int[] a1 = { 10, 15, 5 };

        int expectedResult = 1;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",     expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }


  
    
    // ----------------------------------------------------------
    /**
     * Checking all arrays that are null
     */
    @Test
    public void testAllNull()
    {
        int[] a3 = null;
        int[] a2 = null;
        int[] a1 = null;

        int expectedResult = 0;

        assertEquals("countCollinear({})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({}", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }
    
    // ----------------------------------------------------------
    /**
     * Checking when A3 is null
     */
    @Test
    public void testA3Null()
    {
        int[] a3 = null;
        int[] a2 = {1};
        int[] a1 = {1};

        int expectedResult = 0;

        assertEquals("countCollinear({})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({}", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }
    
 // ----------------------------------------------------------
    /**
     * Checking when A2 is null
     */
    @Test
    public void testA2Null()
    {
        int[] a3 = {1};
        int[] a2 = null;
        int[] a1 = {1};

        int expectedResult = 0;

        assertEquals("countCollinear({})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({}", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }
    
 // ----------------------------------------------------------
    /**
     * Checking when A1 is null
     */
    @Test
    public void testA1Null()
    {
        int[] a3 = {1};
        int[] a2 = {1};
        int[] a1 = null;

        int expectedResult = 0;

        assertEquals("countCollinear({})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({}", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }
    
 // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testRandomArray()
    {
        int[] a3 = { 15, 5, 10, 11, 14};       int[] a2 = { 5 };       int[] a1 = { 10, 15, 5, 6, 7, 88, 2, 4, 9};

        int expectedResult = 1;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",     expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }

}

