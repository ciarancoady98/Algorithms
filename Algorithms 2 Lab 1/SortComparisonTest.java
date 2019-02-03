import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double emptyTestArray[] = null;
    	SortComparison.selectionSort(emptyTestArray);
    	SortComparison.insertionSort(emptyTestArray);
    	SortComparison.mergeSortRecursive(emptyTestArray);
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for arrays of size 1
     */
    @Test
    public void testSize1()
    {
    	double size1Array[] = {1};
    	SortComparison.selectionSort(size1Array);
    	SortComparison.insertionSort(size1Array);
    	SortComparison.mergeSortRecursive(size1Array);
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for arrays of size 2
     */
    @Test
    public void testSize2()
    {
    	double size2Array[] = {2};
    	SortComparison.selectionSort(size2Array);
    	SortComparison.insertionSort(size2Array);
    	SortComparison.mergeSortRecursive(size2Array);
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for arrays of size 2
     */
    @Test
    public void testSortedArray()
    {
    	double sortedArray[] = {1,2,3,4,5,6,7,8,9,10};
    	SortComparison.selectionSort(sortedArray);
    	SortComparison.insertionSort(sortedArray);
    	SortComparison.mergeSortRecursive(sortedArray);
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
    	SortComparisonTest test = new SortComparisonTest();
    	test.testEmpty();
    }

}

