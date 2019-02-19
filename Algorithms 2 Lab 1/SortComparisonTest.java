import static org.junit.Assert.assertEquals;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/*
 * @author Ciaran Coady
 * @version HT 2019
*/

/**
 * 	File Name						Insertion	 MergeIterative	 MergeRecursive		Selection	Quick
	numbers10.txt						0				0				0			0			0
	numbers100.txt						0				0				0			0			0
	numbers1000.txt						7.66			0				0.33		5.33		0.33
	numbers1000Duplicates.txt			2				0				0			1.33		0.33
	numbersNearlyOrdered1000.txt		0				0				0.33		1			0
	numbersReverse1000.txt				1				0				0			0.33		0.66
	numbersSorted1000.txt				0				0				0.33		0.33		0.66
 * 
 */

/**
 * 	a. Which of the sorting algorithms does the order of input have an impact on? Why?
		-Insertion sort. If the input is partially sorted, insertion sort will run very quickly
		as it only has few elements that it needs to shift into the correct position. It doesn't
		have to sort through all the elements which are already sorted. Which could yield a near
		linear runtime of theata(n), where n is the number of elements.
		In the other extreme, if the array is sorted in reverse order, this is the worst case for 
		insertion sort as it must go through every single element shifting it into its correct 
		position, with a worst case runtime of O(n^2).
		-Quick sort. If the input is random, this yields the best performance for quick sort with 
		a runtime of theata(nlog(n)). If the array is already sorted however, this is the worst 
		case for quick sort. if we take the pivot as being the first element in the array, then 
		we must increment through every pivot position and also must scan through all the elements 
		again, when checking if they need to be swapped. This leads to a worst case run time of
		O(n^2).
	b. Which algorithm has the biggest difference between the best and worst performance, based
		on the type of input, for the input of size 1000? Why?
		-Insertion sort has the biggest difference between the best and worst performance.
		-In the best case if the array is ordered or nearly ordered (file - 1000 sorted) 
		theata(n), because it doesn't need to do any sorting and thus carries out less operations.
		-In the worst case if the array is sorted in reverse (file - 1000 reverse order) O(n^2), 
		because if it is sorted in reverse we must go through each element to sort it.
	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
		based on the input size? Please consider only input files with random order for this answer.
		-From my testing Merge sort has the best scalability, as its time to sort didn't change when 
		using the larger files, whereas the it varied for the other algorithms.
		-From my testing insertion sort seems to have the worst scalability, as when the file sizes
		got larger it became the slowest out of all the algorithms. 
	d. Did you observe any difference between iterative and recursive implementations of merge
		sort?
		-I observed that the iterative version ran faster than the Recursive implementation on average.
		-I think this is due to the extra overhead involved with using recursion (e.g. using the stack).
	e. Which algorithm is the fastest for each of the 7 input files?
		-Merge Sort Iterative, as it performed the best consistently throughout my testing, no matter 
		what input file was used.
 */

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
    	SortComparison.mergeSortIterative(emptyTestArray);
    	SortComparison.quickSort(emptyTestArray);
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for arrays of size 1
     */
    @Test
    public void testSize1()
    {
    	double size1Array[] = {1};
    	
    	double sorted[] = {1};
    	double unsorted[] = {1};
    	
    	assertEquals("Checking an empty array selection sort", Arrays.toString(sorted), Arrays.toString(SortComparison.selectionSort(size1Array)));
    	size1Array = unsorted.clone();
    	assertEquals("Checking an empty array insertion sort", Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(size1Array)));
    	size1Array = unsorted.clone();
    	assertEquals("Checking an empty array merge sort recursive", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortRecursive(size1Array)));
    	size1Array = unsorted.clone();
    	assertEquals("Checking an empty array merge sort iterative", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortIterative(size1Array)));
    	size1Array = unsorted.clone();
    	assertEquals("Checking an empty array quick sort", Arrays.toString(sorted), Arrays.toString(SortComparison.quickSort(size1Array)));
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for arrays of size 2
     */
    @Test
    public void testSize2()
    {
    	double size2Array[] = {2, 1};
    	
    	double sorted[] = {1, 2};
    	double unsorted[] = {2, 1};
    	
    	assertEquals("Checking an empty array selection sort", Arrays.toString(sorted), Arrays.toString(SortComparison.selectionSort(size2Array)));
    	size2Array = unsorted.clone();
    	assertEquals("Checking an empty array insertion sort", Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(size2Array)));
    	size2Array = unsorted.clone();
    	assertEquals("Checking an empty array merge sort recursive", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortRecursive(size2Array)));
    	size2Array = unsorted.clone();
    	assertEquals("Checking an empty array merge sort iterative", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortIterative(size2Array)));
    	size2Array = unsorted.clone();
    	assertEquals("Checking an empty array quick sort", Arrays.toString(sorted), Arrays.toString(SortComparison.quickSort(size2Array)));
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for arrays of size 10
     */
    @Test
    public void testSize10()
    {
    	double size10Array[] = {2,4,3,10,7,5,9,1,6,8};
    	
    	double sorted[] = {1,2,3,4,5,6,7,8,9,10};
    	double unsorted[] = {2,4,3,10,7,5,9,1,6,8};
    	
    	assertEquals("Checking an empty array selection sort", Arrays.toString(sorted), Arrays.toString(SortComparison.selectionSort(size10Array)));
    	size10Array = unsorted.clone();
    	assertEquals("Checking an empty array insertion sort", Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(size10Array)));
    	size10Array = unsorted.clone();
    	assertEquals("Checking an empty array merge sort recursive", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortRecursive(size10Array)));
    	size10Array = unsorted.clone();
    	assertEquals("Checking an empty array merge sort iterative", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortIterative(size10Array)));
    	size10Array = unsorted.clone();
    	assertEquals("Checking an empty array quick sort", Arrays.toString(sorted), Arrays.toString(SortComparison.quickSort(size10Array)));
    }
    
 // ----------------------------------------------------------
    /**
     * Check that the methods work for arrays that are already sorted
     */
    @Test
    public void testSorted()
    {
    	double sortedTest[] = {1,2,3,4,5,6,7,8,9,10};
    	
    	double sorted[] = {1,2,3,4,5,6,7,8,9,10};
    	double unsorted[] = {1,2,3,4,5,6,7,8,9,10};
    	
    	assertEquals("Checking an empty array selection sort", Arrays.toString(sorted), Arrays.toString(SortComparison.selectionSort(sortedTest)));
    	sortedTest = unsorted.clone();
    	assertEquals("Checking an empty array insertion sort", Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(sortedTest)));
    	sortedTest = unsorted.clone();
    	assertEquals("Checking an empty array merge sort recursive", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortRecursive(sortedTest)));
    	sortedTest = unsorted.clone();
    	assertEquals("Checking an empty array merge sort iterative", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortIterative(sortedTest)));
    	sortedTest = unsorted.clone();
    	assertEquals("Checking an empty array quick sort", Arrays.toString(sorted), Arrays.toString(SortComparison.quickSort(sortedTest)));
    }
    
 // ----------------------------------------------------------
    /**
     * Check that the methods work for arrays that contain the same number
     */
    @Test
    public void testSame()
    {
    	double sameTest[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    	
    	double sorted[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    	double unsorted[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    	
    	assertEquals("Checking an empty array selection sort", Arrays.toString(sorted), Arrays.toString(SortComparison.selectionSort(sameTest)));
    	sameTest = unsorted.clone();
    	assertEquals("Checking an empty array insertion sort", Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(sameTest)));
    	sameTest = unsorted.clone();
    	assertEquals("Checking an empty array merge sort recursive", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortRecursive(sameTest)));
    	sameTest = unsorted.clone();
    	assertEquals("Checking an empty array merge sort iterative", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortIterative(sameTest)));
    	sameTest = unsorted.clone();
    	assertEquals("Checking an empty array quick sort", Arrays.toString(sorted), Arrays.toString(SortComparison.quickSort(sameTest)));
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for arrays that are sorted in reverse order
     */
    @Test
    public void teset()
    {
    	double reverseTest[] = {10,9,8,7,6,5,4,3,2,1,0};
    	
    	double sorted[] = {0,1,2,3,4,5,6,7,8,9,10};
    	double unsorted[] = {10,9,8,7,6,5,4,3,2,1,0};
    	
    	assertEquals("Checking an empty array selection sort", Arrays.toString(sorted), Arrays.toString(SortComparison.selectionSort(reverseTest)));
    	reverseTest = unsorted.clone();
    	assertEquals("Checking an empty array insertion sort", Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(reverseTest)));
    	reverseTest = unsorted.clone();
    	assertEquals("Checking an empty array merge sort recursive", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortRecursive(reverseTest)));
    	reverseTest = unsorted.clone();
    	assertEquals("Checking an empty array merge sort iterative", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortIterative(reverseTest)));
    	reverseTest = unsorted.clone();
    	assertEquals("Checking an empty array quick sort", Arrays.toString(sorted), Arrays.toString(SortComparison.quickSort(reverseTest)));
    }


    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
    	SortComparison sort = new SortComparison();
    	String[] fileNames = {"/home/ciaran/eclipse-workspace/Algorithms 2 Assignment 1/src/numbers10.txt",
    						"/home/ciaran/eclipse-workspace/Algorithms 2 Assignment 1/src/numbers100.txt",
    						"/home/ciaran/eclipse-workspace/Algorithms 2 Assignment 1/src/numbers1000.txt",
    						"/home/ciaran/eclipse-workspace/Algorithms 2 Assignment 1/src/numbers1000Duplicates.txt",
    						"/home/ciaran/eclipse-workspace/Algorithms 2 Assignment 1/src/numbersNearlyOrdered1000.txt",
    						"/home/ciaran/eclipse-workspace/Algorithms 2 Assignment 1/src/numbersReverse1000.txt",
    						"/home/ciaran/eclipse-workspace/Algorithms 2 Assignment 1/src/numbersSorted1000.txt"};
    	for(int j = 0; j < fileNames.length; j++) {
    		try {
    			FileReader input = new FileReader(fileNames[j]);
        		BufferedReader reader = new BufferedReader(input);
        		ArrayList<Double> numbers = new ArrayList<Double>();
        		String numberString;
        		while( (numberString= reader.readLine()) != null) {
        			numbers.add(Double.valueOf(numberString));
        		}
        		reader.close();
        		input.close();
        		
        		double[] numbersArray = new double[numbers.size()];
        		
        		for(int i = 0; i < numbers.size(); i++) {
        			numbersArray[i] = numbers.get(i);
        		}
        		
        		numbers = null;
        		long timeBefore;
        		long timeAfter;
        		
        		System.out.println("-\n"
        				+ "-\n"
        				+ "-\n"
        				+ "-Stats for file " + fileNames[j].substring(61));
        		
        		double[] tempArray = numbersArray.clone();
        		timeBefore = System.currentTimeMillis();
        		sort.insertionSort(tempArray);
        		timeAfter = System.currentTimeMillis();
        		System.out.println("Insertion Sort: " + (timeAfter-timeBefore) + "ms");
        		
        		tempArray = numbersArray.clone();
        		timeBefore = System.currentTimeMillis();
        		sort.mergeSortIterative(tempArray);
        		timeAfter = System.currentTimeMillis();
        		System.out.println("Merge Sort Iterative: " + (timeAfter-timeBefore) + "ms");
        		
        		tempArray = numbersArray.clone();
        		timeBefore = System.currentTimeMillis();
        		sort.mergeSortRecursive(tempArray);
        		timeAfter = System.currentTimeMillis();
        		System.out.println("Merge Sort Recursive: " + (timeAfter-timeBefore) + "ms");
        		
        		tempArray = numbersArray.clone();
        		timeBefore = System.currentTimeMillis();
        		sort.selectionSort(tempArray);
        		timeAfter = System.currentTimeMillis();
        		System.out.println("Selection Sort: " + (timeAfter-timeBefore) + "ms");
        		
        		tempArray = numbersArray.clone();
        		timeBefore = System.currentTimeMillis();
        		sort.quickSort(tempArray);
        		timeAfter = System.currentTimeMillis();
        		System.out.println("Quick Sort: " + (timeAfter-timeBefore) + "ms");
        		
        	}catch(Exception e) {System.out.println(e);}
    		
    	}
    }

}

