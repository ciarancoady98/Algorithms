// -------------------------------------------------------------------------
/**
 *  This class contains only two static methods that search for points on the
 *  same line in three arrays of integers. 
 *
 *  @author  Ciaran Coady
 *  @version 27/09/18 12:21:09
 */
class Collinear
{

   // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
     * A non-horizontal line will have to cross all three of these lines. Thus
     * we are looking for 3 points, each in a1, a2, a3 which lie on the same
     * line.
     *
     * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
     * 
     * x1(y2−y3)+x2(y3−y1)+x3(y1−y2)=0 
     *
     * In our case y1=1, y2=2, y3=3.
     *
     * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)
     *
     * ----------------------------------------------------------
     *
     * 
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of growth: N^3
     *
     *  Explanation: countCollinear contains 3 linear for-loops, each with an order of growth of N.
     *  Putting these together we get N * N * N = N^3 (assuming that all passed 
     *  arrays are of the same length).
     *  Note: All the arrays passed into countCollinear may not be of the same size,
     *  therefore the order of growth will be N * M * P = NMP, where N,M and P are associated 
     *  to the passed arrays a1, a2 and a3
     */
	
	public static int Y1 = 1;
	public static int Y2 = 2;
	public static int Y3 = 3;
	
    static int countCollinear(int[] a1, int[] a2, int[] a3)
    {
    	if(a1 != null && a2 != null && a3 != null) {
    		int count = 0;
        	for(int i = 0; i < a1.length; i++) {
        		for(int j = 0; j < a2.length; j++) {
        			for(int k = 0; k < a3.length; k++) {
        				if(a1[i]*(Y2-Y3)+a2[j]*(Y3-Y1)+a3[k]*(Y1-Y2) == 0) {
    						count++;
    					}
        			}
        		}
        	}
          return count;
    	}
    	else
    	{
    		return 0;
    	}
    	
    }

    // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
     * The performance of this method should be much better than that of the above method.
     *
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: N^2lgN
     *
     *  Explanation: countCollinearFast has two linear for-loops and one binarySearch call,
     *  this results in an order of growth of N * N * lgN = n^2lgN (assuming that all passed 
     *  arrays are of the same length).
     *  Note: All the arrays passed into countCollinearFast may not be of the same size,
     *  therefore the order of growth will be N * M * lgP = NMlgP, where N,M and P are associated 
     *  to the passed arrays a1, a2 and a3
     *
     */
    static int countCollinearFast(int[] a1, int[] a2, int[] a3)
    {
    	if(a1 != null && a2 != null && a3 != null) {
    		sort(a3);
        	int count = 0;
        	for(int i = 0; i < a1.length; i++) {
        		for(int j = 0; j < a2.length; j++) {
        			int desiredResult = (a1[i]*(Y2-Y3)+a2[j]*(Y3-Y1))/-1;
        			if(binarySearch(a3, desiredResult))
        				count++;
        		}
        	}
          return count;
    	}
    	else {
    		return 0;
    	}
    }

    // ----------------------------------------------------------
    /**
     * Sorts an array of integers according to InsertionSort.
     * This method is static, thus it can be called as Collinear.sort(a)
     * @param a: An UNSORTED array of integers. 
     * @return after the method returns, the array must be in ascending sorted order.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: N^2
     *
     *  Explanation: Two linear for-loops.
     *
     */
    static void sort(int[] a)
    {
    	  for ( int j = 1; j<a.length; j++)
          {
            int i = j - 1;
            while(i>=0 && a[i]>a[i+1])
            {
              int temp = a[i];
              a[i] = a[i+1];
              a[i+1] = temp;
              i--;
            }
          }
    }

    // ----------------------------------------------------------
    /**
     * Searches for an integer inside an array of integers.
     * This method is static, thus it can be called as Collinear.binarySearch(a,x)
     * @param a: A array of integers SORTED in ascending order.
     * @param x: An integer.
     * @return true if 'x' is contained in 'a'; false otherwise.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: lgN
     *
     *  Explanation: Contains one while loop and with each iteration of the loop, the size
     *  of the array we are searching is being halved, giving an order of growth of lgN
     *
     */
    static boolean binarySearch(int[] a, int x)
    {
    		int low = 0;
        	int high = a.length-1;
        	while (low <= high) {
        		int middle = low + (high-low)/2;
        		if(x < a[middle]) {
        			high = middle - 1;
        		}
        		else if (x > a[middle]) {
        			low = middle + 1;
        		}
        		else 
        			return true;
        	}
          return false;
    }

}
