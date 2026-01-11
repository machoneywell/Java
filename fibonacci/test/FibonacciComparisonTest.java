import fibonacci.FibonacciComparison;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class FibonacciComparisonTest {
    FibonacciComparison tester;
    public void init(){
        tester = new FibonacciComparison();
    }

    @Test
    public void outputFile()
    {
        try {
            File output = new File("output.txt");
            Scanner myReader = new Scanner(output);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.out.println("File Not Found");
            assertEquals("output.txt", "not found");
        }
    }

    // Testing for Iterative fib
    @Test
    public void testFibLinear_1() {
        assertEquals(0, tester.fibLinear(0));
        assertEquals(5, tester.fibLinear(5));
        assertEquals(8, tester.fibLinear(6));
        assertEquals(0, tester.fibLinear(-1));
        assertEquals(34, tester.fibLinear(9));
    }

    // Testing for Recursive fib
    @Test
    public void testFibRecursive_2(){
        assertEquals(5 , tester.fibRecursive(5));
        assertEquals(8 , tester.fibRecursive(6));
        assertEquals(0, tester.fibRecursive(0));
        assertEquals(34 , tester.fibRecursive(9));
        assertEquals(0, tester.fibRecursive(-1));
        assertEquals(0, tester.fibRecursive(-3));
    }

    // Both fibs are equal
    @Test
    public void testFibRecursive_3(){
        assertEquals(tester.fibLinear(9), tester.fibRecursive(9));
        assertEquals(tester.fibLinear(0), tester.fibRecursive(-1));
        assertEquals(tester.fibLinear(5), tester.fibRecursive(5));
    }

    // Testing that recursive method takes longer time than linear method
    @Test
    public void testFibRecursive_4(){
        // Time for Linear function
        long tItr, tRec = 0;
        long start = System.nanoTime();
        for (int i=0; i<10; i++){
            tester.fibLinear(15);
        }
        long end = System.nanoTime();
        tItr = end - start;

        // Time for Recursive function
        start = System.nanoTime();
        for (int i=0; i<10; i++){
            tester.fibRecursive(15);
        }
        end = System.nanoTime();
        tRec = end - start;

        assertTrue(tRec > tItr);
    }
}

