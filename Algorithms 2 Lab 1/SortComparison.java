// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2019
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
		for (int i = 1; i < a.length; i++) {
			boolean done = false;
			for (int j = i; j > 0 && !done;  j--) {
				if (a[j] < a[j - 1]) {
					double temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
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
	
		 //todo: implement the sort
    	return null;
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

		 //todo: implement the sort
    	return null;
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	

    	//todo: implement the sort
    	return null;
   }//end mergeSortRecursive
    
    private void sort(double a[], double aux[], int low, int high) {
    	//gotten to size of 1 or zero break out
    	if(high <= low) 
    		return;
    	//where to split the array
    	int mid = low + (high-low)/2;
    	//sort left half
    	sort(a, aux, low, mid);
    	//sort right half
    	sort(a, aux, mid+1, high);
    	//merge results
    	merge(a, aux, low, mid, high);
    }
    
    private void merge(double a[], double aux[], int low, int mid, int high) {
    	//copy the original array into the auxiliary array
    	for(int i = low; i <= high; i++) {
    		aux[i] = a[i];
    	}
    	//merge the array back into original in correct order
    	
    }
    	
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
		for (int i = 0; i < a.length - 1; i++) {
			int minUnsorted = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minUnsorted])
					minUnsorted = j;
			}
			double temp = a[minUnsorted];
			a[minUnsorted] = a[i];
			a[i] = temp;
		}
    	return a;
    }//end selectionsort

   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    	double[] unsortedArray = {8,3,4,1,44,23,0};
    	double[] sortedArray = selectionSort(unsortedArray);
    	for(int i = 0; i < sortedArray.length; i++) {
    		System.out.println("" + sortedArray[i]);
    	}
    }

 }//end class

