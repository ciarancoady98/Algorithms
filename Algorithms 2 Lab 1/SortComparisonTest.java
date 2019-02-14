import static org.junit.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

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
    	size1Array = unsorted;
    	assertEquals("Checking an empty array insertion sort", Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(size1Array)));
    	size1Array = unsorted;
    	assertEquals("Checking an empty array merge sort recursive", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortRecursive(size1Array)));
    	size1Array = unsorted;
    	assertEquals("Checking an empty array merge sort iterative", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortIterative(size1Array)));
    	size1Array = unsorted;
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
    	size2Array = unsorted;
    	assertEquals("Checking an empty array insertion sort", Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(size2Array)));
    	size2Array = unsorted;
    	assertEquals("Checking an empty array merge sort recursive", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortRecursive(size2Array)));
    	size2Array = unsorted;
    	assertEquals("Checking an empty array merge sort iterative", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortIterative(size2Array)));
    	size2Array = unsorted;
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
    	size10Array = unsorted;
    	assertEquals("Checking an empty array insertion sort", Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(size10Array)));
    	size10Array = unsorted;
    	assertEquals("Checking an empty array merge sort recursive", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortRecursive(size10Array)));
    	size10Array = unsorted;
    	assertEquals("Checking an empty array merge sort iterative", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortIterative(size10Array)));
    	size10Array = unsorted;
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
    	sortedTest = unsorted;
    	assertEquals("Checking an empty array insertion sort", Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(sortedTest)));
    	sortedTest = unsorted;
    	assertEquals("Checking an empty array merge sort recursive", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortRecursive(sortedTest)));
    	sortedTest = unsorted;
    	assertEquals("Checking an empty array merge sort iterative", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortIterative(sortedTest)));
    	sortedTest = unsorted;
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
    	sameTest = unsorted;
    	assertEquals("Checking an empty array insertion sort", Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(sameTest)));
    	sameTest = unsorted;
    	assertEquals("Checking an empty array merge sort recursive", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortRecursive(sameTest)));
    	sameTest = unsorted;
    	assertEquals("Checking an empty array merge sort iterative", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortIterative(sameTest)));
    	sameTest = unsorted;
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
    	reverseTest = unsorted;
    	assertEquals("Checking an empty array insertion sort", Arrays.toString(sorted), Arrays.toString(SortComparison.insertionSort(reverseTest)));
    	reverseTest = unsorted;
    	assertEquals("Checking an empty array merge sort recursive", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortRecursive(reverseTest)));
    	reverseTest = unsorted;
    	assertEquals("Checking an empty array merge sort iterative", Arrays.toString(sorted), Arrays.toString(SortComparison.mergeSortIterative(reverseTest)));
    	reverseTest = unsorted;
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
        				+ "-Stats for file " + j);
        		
        		double[] tempArray = numbersArray.clone();
        		timeBefore = System.currentTimeMillis();
        		sort.insertionSort(tempArray);
        		timeAfter = System.currentTimeMillis();
        		System.out.println("Insertion Sort: " + (timeAfter-timeBefore));
        		
        		tempArray = numbersArray.clone();
        		timeBefore = System.currentTimeMillis();
        		sort.mergeSortIterative(tempArray);
        		timeAfter = System.currentTimeMillis();
        		System.out.println("Merge Sort Iterative: " + (timeAfter-timeBefore));
        		
        		tempArray = numbersArray.clone();
        		timeBefore = System.currentTimeMillis();
        		sort.mergeSortRecursive(tempArray);
        		timeAfter = System.currentTimeMillis();
        		System.out.println("Merge Sort Recursive: " + (timeAfter-timeBefore));
        		
        		tempArray = numbersArray.clone();
        		timeBefore = System.currentTimeMillis();
        		sort.selectionSort(tempArray);
        		timeAfter = System.currentTimeMillis();
        		System.out.println("Selection Sort: " + (timeAfter-timeBefore));
        		
        	}catch(Exception e) {System.out.println(e);}
    		
    	}
    }

}

