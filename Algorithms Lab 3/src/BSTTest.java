import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  Ciarán Coady
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  
  
  
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting node that isnt in the tree",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
     }
     
     
     @Test
     public void testHeight() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals("testing height of an empty tree", -1,  bst.height());
    	 bst.put(7, 7);   //        _7_
    	 assertEquals("testing tree of height one", 0,  bst.height());
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         assertEquals("testing a tree of height 4", 4,  bst.height());
         
         bst = new BST<Integer, Integer>();
         bst.put(7, 7);
         bst.put(8, 8);
         assertEquals("tree with one right node", 1,  bst.height());
         bst = new BST<Integer, Integer>();
         bst.put(7, 7);
         bst.put(6, 6);
         assertEquals("tree with one left node", 1,  bst.height());
         bst.put(8, 8);
         assertEquals("tree with one left and one right node", 1,  bst.height());
         bst = new BST<Integer, Integer>();
         bst.put(7, 7);
         bst.put(6, 6);
         bst.put(5, 5);
         bst.put(4, 4);
         bst.put(3, 3);
         bst.put(2, 2);
         assertEquals("left leaning tree", 5,  bst.height());
         bst = new BST<Integer, Integer>();
         bst.put(2, 2);
         bst.put(3, 3);
         bst.put(4, 4);
         bst.put(5, 5);
         bst.put(6, 6);
         assertEquals("right leaning tree", 4,  bst.height());
     }
     
     @Test
     public void testMedian() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals("testing median of an empty tree", null,  bst.median());
    	 bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         assertEquals("testing a tree of height 4","4" ,  bst.median().toString());
         
         bst = new BST<Integer, Integer>();
         bst.put(7, 7);
         bst.put(8, 8);
         assertEquals("tree with one right node","7" ,  bst.median().toString());
         bst = new BST<Integer, Integer>();
         bst.put(7, 7);
         bst.put(6, 6);
         assertEquals("tree with one left node","6" ,  bst.median().toString());
         bst.put(8, 8);
         assertEquals("tree with one left and one right node","7" ,  bst.median().toString());
         bst = new BST<Integer, Integer>();
         bst.put(7, 7);
         bst.put(6, 6);
         bst.put(5, 5);
         bst.put(4, 4);
         bst.put(3, 3);
         bst.put(2, 2);
         assertEquals("left leaning tree","4" ,  bst.median().toString());
         bst = new BST<Integer, Integer>();
         bst.put(2, 2);
         bst.put(3, 3);
         bst.put(4, 4);
         bst.put(5, 5);
         bst.put(6, 6);
         assertEquals("right leaning tree","4" ,  bst.median().toString());
     }
     
     @Test
     public void testContains() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals("testing on an empty tree", false,  bst.contains(3));
    	 bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         assertEquals("testing a tree of height 4", true,  bst.contains(3));
         assertEquals("testing a tree of height 4 for non-existing element", false,  bst.contains(20));
         
         bst = new BST<Integer, Integer>();
         bst.put(7, 7);
         bst.put(8, 8);
         assertEquals("tree with one right node", true,  bst.contains(7));
         assertEquals("tree with one right node", true,  bst.contains(8));
         bst = new BST<Integer, Integer>();
         bst.put(7, 7);
         bst.put(6, 6);
         assertEquals("tree with one left node", true,  bst.contains(7));
         assertEquals("tree with one left node", true,  bst.contains(6));
         bst.put(8, 8);
         assertEquals("tree with one left and one right node", true,  bst.contains(6));
         bst = new BST<Integer, Integer>();
         bst.put(7, 7);
         bst.put(6, 6);
         bst.put(5, 5);
         bst.put(4, 4);
         bst.put(3, 3);
         bst.put(2, 2);
         assertEquals("left leaning tree", true,  bst.contains(6));
         bst = new BST<Integer, Integer>();
         bst.put(2, 2);
         bst.put(3, 3);
         bst.put(4, 4);
         bst.put(5, 5);
         bst.put(6, 6);
         assertEquals("right leaning tree", true,  bst.contains(6));
     }
     
     @Test
     public void testGet() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals("testing on an empty tree", null,  bst.get(3));
    	 bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         assertEquals("testing on a tree of height 4", "3",  bst.get(3).toString());
         assertEquals("testing on a tree of height 4", "7",  bst.get(7).toString());
         assertEquals("testing on a tree of height 4", "8",  bst.get(8).toString());
         assertEquals("testing on a tree of height 4", "1",  bst.get(1).toString());
         assertEquals("testing on a tree of height 4", "2",  bst.get(2).toString());
         assertEquals("testing on a tree of height 4", "6",  bst.get(6).toString());
         assertEquals("testing on a tree of height 4", "4",  bst.get(4).toString());
         assertEquals("testing on a tree of height 4", "5",  bst.get(5).toString());
     }
     
     @Test
     public void testPut() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 //putting a value that is already in the tree
    	 bst.put(7, 7);    
    	 bst.put(7, 7); 
    	 
     }
     
}

