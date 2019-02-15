// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2019
 */

 class SortComparison {
	 
	 /*This method swaps to doubles in an array of doubles at indexes
	 element1 and element2
	 */
	 private static void swap(double a[], int element1, int element2) {
		 double temp = a[element1];
		 a[element1] = a[element2];
		 a[element2] = temp;
	 }

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
		for (int i = 1; a != null && i < a.length; i++) {
			boolean done = false;
			for (int j = i; j > 0 && !done;  j--) {
				if (a[j] < a[j - 1]) {
					swap(a, j, j-1);
				}
				else
					done = true;
			}
		}
		return a;

    }//end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
	
    	if(a != null) {
    		quickSortRecursive(a, 0, a.length-1);
    	}
    	return a;
    }
    
    private static void quickSortRecursive(double a[], int low, int high) {
    	if(high<=low) {
    		return;
    	}
    	int pivotPos = partition(a, low, high);
    	quickSortRecursive(a, low, pivotPos-1);
    	quickSortRecursive(a, pivotPos+1, high);
    }
    
    private static int partition(double a[], int pivotPos, int high) {
    	/*
    	int i = pivotPos;
    	int j = high + 1 ;
    	boolean swapped = false;
    	while(!swapped) {
    		while(a[i]<a[pivotPos] && i<a.length) {
        		i++;
        	}
        	while(a[j]>a[pivotPos] && j>=0) {
        		j--;
        	}
        	if(i>j) {
        		swap(a, pivotPos, j);
        		swapped = true;
        	}
        	else {
        		swap(a, i, j);
        		swapped = true;
        	}
    	}
    	return j;
    	*/
    	int i = pivotPos;
    	int j = high+1;
    	while(true) {
    		while(a[++i] < a[pivotPos]) {
    			if(i == high) break;
    		}
    		while(a[--j] > a[pivotPos]) {
    			if(j== pivotPos) break;
    		}
    		if(i >= j) break;
    		swap(a, i, j);
    	}
    	swap(a, pivotPos, j);
    	return j;
    }//end quicksort

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {

    	if(a != null) {
    		double aux[] = new double[a.length];
    		mergeSortIterative(a, aux);
    	}
    	return a;
    }
    
    private static void mergeSortIterative(double a[], double aux[]) {
    	//Divide the array into sub arrays of size starting at 1
    	for(int subSize = 1; subSize < a.length; subSize*=2) {
    		//increment through sub arrays 2 at a time
    		for(int low = 0; low < a.length-subSize; low+= 2*subSize) {
    			//take to adjacent sub arrays and merge them
    			//high is calculated in case the sub array divisions 
    			//would cause the incrementation to go off the end of the array
    			merge(a, aux, low, low+subSize-1, Math.min(low+(2*subSize)-1, a.length-1));
    		}
    	}
    }//end mergesortIterative
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	if(a != null) {
    		double aux[] = new double[a.length];
    		mergeSortRecursive(a, aux, 0, a.length-1);
    	}
    	return a;
   }
    
    private static void mergeSortRecursive(double a[], double aux[], int low, int high) {
    	//gotten to size of 1 or zero break out
    	if(high <= low) 
    		return;
    	//where to split the array
    	int mid = low + (high-low)/2;
    	//sort left half
    	mergeSortRecursive(a, aux, low, mid);
    	//sort right half
    	mergeSortRecursive(a, aux, mid+1, high);
    	//merge results
    	merge(a, aux, low, mid, high);
    }//end mergeSortRecursive
    
    private static void merge(double a[], double aux[], int low, int mid, int high) {
    	//copy the original array into the auxiliary array
    	for(int i = low; i <= high; i++) {
    		aux[i] = a[i];
    	}
    	//merge the array back into original in correct order
    	int i = low;
    	int j = mid + 1;
    	for(int k = low; k <= high; k++) {
    		//if left sub array has all been copied
    		if(i > mid)
    			a[k] = aux[j++];
    		//if right sub array has all been copied
    		else if(j > high)
    			a[k] = aux[i++];
    		//check which element is smaller and 
    		//copy it into the original array
    		else if(aux[j] < aux[i])
    			a[k] = aux[j++];
    		else
    			a[k] = aux[i++];
    	}
    }
    	
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
		for (int i = 0; a != null && i < a.length - 1; i++) {
			int minUnsorted = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minUnsorted])
					minUnsorted = j;
			}
			swap(a, minUnsorted, i);
		}
    	return a;
    }//end selectionsort

 }//end class

