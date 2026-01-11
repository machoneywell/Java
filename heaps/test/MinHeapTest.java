import heaps.*;

import org.junit.Test;

import static org.junit.Assert.*;


public class MinHeapTest {

    Integer[] numbers = {3,1,7,11,2,15,8,4,1,5,21,13};
    Integer[] orderedNumbers = {1,1,7,2,3,13,8,11,4,5,21,15,};
    Integer[] sortedNumbers = {1,1,2,3,4,5,7,8,11,13,15,21};

    String[] str = {"C", "D", "A", "F", "A", "Z", "M"};
    String[] sortedStr = {"A", "A", "C", "D", "F", "M", "Z"};
    String[] orderedStr = {"A", "A", "C", "F", "D", "Z", "M"};


    MinHeap<Integer> minHeapInt;
    MinHeap<String> minHeapStr;

    public void init() {
        minHeapInt = new MinHeap<>();
        minHeapStr = new MinHeap<>();
    }

    /**  ------------------------------  Tests for Ints ---------------------------           **/

    @Test
    public void test_add_int() {
        init();
        // Testing for size after adding elements
        for (int i=0; i< numbers.length; i++)
            minHeapInt.add(numbers[i]);
        // Testing for the correct order of elements in the minHeapInt
        for (int i=0; i<numbers.length; i++)
            assertEquals(minHeapInt.getIndexVal(i), orderedNumbers[i]);

    }

    @Test
    public void test_poll_int(){
        init();
        // Check if the elements are added in correct order
        for (int i=0; i< numbers.length; i++)
            minHeapInt.add(numbers[i]);

        for (int i=0; i<numbers.length; i++)
            assertEquals(sortedNumbers[i], minHeapInt.poll());
    }


    @Test
    public void test_peek_int(){
        init();

        for (int i=0; i< numbers.length; i++)
            minHeapInt.add(numbers[i]);

        assertEquals(orderedNumbers[0], minHeapInt.peek());
    }

    @Test
    public void test_isEmpty_int(){
        init();

        assertEquals(true, minHeapInt.isEmpty());
        for (int i=0; i< numbers.length; i++)
            minHeapInt.add(numbers[i]);

        assertEquals(false, minHeapInt.isEmpty());

        for (int i=0; i<numbers.length; i++)
            minHeapInt.poll();
        assertEquals(true, minHeapInt.isEmpty());
    }

    @Test
    public void test_getSize_int(){
        init();

        assertEquals(0, minHeapInt.getSize());
        for (int i=0; i< numbers.length; i++)
            minHeapInt.add(numbers[i]);
        assertEquals(numbers.length, minHeapInt.getSize());

        for (int i=0; i<numbers.length; i++)
            minHeapInt.poll();
        assertEquals(0, minHeapInt.getSize());
    }


    /**  ------------------------------  Tests for Strings ---------------------------           **/
    @Test
    public void test_add_str() {
        init();
        // Testing for size after adding elements
        for (int i=0; i< str.length; i++)
            minHeapStr.add(str[i]);
        // Testing for the correct order of elements in the minHeapInt
        for (int i=0; i<str.length; i++)
            assertEquals(minHeapStr.getIndexVal(i), orderedStr[i]);
    }

    @Test
    public void test_poll_str(){
        init();
        // Check if the elements are added in correct order
        for (int i=0; i< str.length; i++)
            minHeapStr.add(str[i]);

        for (int i=0; i<str.length; i++)
            assertEquals(sortedStr[i], minHeapStr.poll());
    }


    @Test
    public void test_peek_str(){
        init();

        for (int i=0; i<str.length; i++)
            minHeapStr.add(str[i]);

        assertEquals(orderedStr[0], minHeapStr.peek());
    }



    @Test
    public void test_isEmpty_str(){
        init();

        assertEquals(true, minHeapStr.isEmpty());
        for (int i=0; i< str.length; i++)
            minHeapStr.add(str[i]);

        assertEquals(false, minHeapStr.isEmpty());

        for (int i=0; i<str.length; i++)
            minHeapStr.poll();
        assertEquals(true, minHeapStr.isEmpty());
    }

    @Test
    public void test_getSize_str(){
        init();

        assertEquals(0, minHeapStr.getSize());
        for (int i=0; i< str.length; i++)
            minHeapStr.add(str[i]);
        assertEquals(str.length, minHeapStr.getSize());

        for (int i=0; i<str.length; i++)
            minHeapStr.poll();
        assertEquals(0, minHeapStr.getSize());
    }
}
