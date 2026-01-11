import circularlinkedlist.*;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class TestClass {
    Node stringNodeTester;
    Node intNodeTester;
    CircularLinkedList intListTester;
    CircularLinkedList stringListTester;
    public void init(){
        intNodeTester = new Node();
        stringNodeTester = new Node<String>();
        intListTester = new CircularLinkedList();
        stringListTester = new CircularLinkedList<String>();
    }

    // Node Testing
    @Test
    public void testNodeInt_val()
    {
        init();
        intNodeTester.setElement(4);
        assertEquals(4, intNodeTester.getElement());
    }
    @Test
    public void testNodeInt_next()
    {
        init();
        assertEquals(null, intNodeTester.getNext());
    }
    @Test
    public void testNodeInt_empty()
    {
        init();
        assertEquals(null, intNodeTester.getElement());
        assertEquals(null, intNodeTester.getNext());
    }

    @Test
    public void testNodeString_val()
    {
        init();
        stringNodeTester.setElement("4");
        assertEquals("4", stringNodeTester.getElement());
    }
    @Test
    public void testNodeString_next()
    {
        init();
        assertEquals(null, stringNodeTester.getNext());
    }
    @Test
    public void testNodeString_empty()
    {
        init();
        Node node= new Node<String>();
        assertEquals(null, stringNodeTester.getElement());
        assertEquals(null, stringNodeTester.getNext());
    }


    //Circular Linked List tests start from here
    @Test
    public void testListString_getItem()
    {
        init();
        assertEquals(null, stringListTester.getFirst());
        assertEquals(null, stringListTester.getLast());
    }
    @Test
    public void testListString_addFirst()
    {
        init();
        stringListTester.addLast("prius");
        assertEquals("prius", stringListTester.getFirst());
        stringListTester.addFirst("ding");
        assertEquals("ding", stringListTester.getFirst());
    }
    @Test
    public void testListString_addLast()
    {
        init();
        stringListTester.addLast("prius");
        assertEquals("prius", stringListTester.getLast());
        stringListTester.addLast("ding");
        assertEquals("ding", stringListTester.getLast());
    }


    @Test
    public void testListString_getSize()
    {
        init();
        assertEquals(0, stringListTester.getSize());
        stringListTester.addLast("prius");
        assertEquals(1, stringListTester.getSize());
        stringListTester.addLast("ding");
        assertEquals(2, stringListTester.getSize());
        stringListTester.removeFirst();
        assertEquals(1, stringListTester.getSize());
        stringListTester.removeFirst();
        assertEquals(0, stringListTester.getSize());
        stringListTester.removeFirst();
        assertEquals(0, stringListTester.getSize());
    }
    @Test
    public void testListString_removeFirst()
    {
        init();
        assertEquals(null, stringListTester.removeFirst());
        String[] cars = { "prius", "rav4", "subaru", "crv", "pilot"};

        for (String i: cars)
            stringListTester.addLast(i);

        for (String i: cars)
            assertEquals(i ,stringListTester.removeFirst());
    }

    @Test
    public void testListString_isEmpty()
    {
        init();

        assertEquals(true ,stringListTester.isEmpty());
        stringListTester.addLast("i");
        assertEquals(false ,stringListTester.isEmpty());
    }

    @Test
    public void testListString_rotate()
    {
        init();

        String[] cars = { "prius", "rav4", "subaru", "crv", "pilot"};
        for (String i: cars)
            stringListTester.addLast(i);

        String[] cars_rotated = { "rav4", "subaru", "crv", "pilot", "prius"};
        stringListTester.rotate();
        for (String i: cars_rotated){
            assertEquals(i, stringListTester.removeFirst());
        }

    }

    @Test
    public void testListInt_isEmpty()
    {
        init();

        assertEquals(true ,intListTester.isEmpty());
        intListTester.addLast(1);
        assertEquals(false ,intListTester.isEmpty());
    }

    @Test
    public void testIntString_toString()
    {
        init();

        int[] cars = { 1,2,3,4,5 };
        for (int i: cars)
            intListTester.addLast(i);

        assertEquals("[1, 2, 3, 4, 5, 1, 2, 3, 4, 5]", intListTester.toString());

    }
    @Test
    public void testListInt_getItem()
    {
        init();
        assertEquals(null, intListTester.getFirst());
        assertEquals(null, intListTester.getLast());
    }
    @Test
    public void testListInt_addFirst()
    {
        init();
        intListTester.addLast(1);
        assertEquals(1, intListTester.getFirst());
        intListTester.addFirst(2);
        assertEquals(2, intListTester.getFirst());
    }

    public void testListInt_deleteNode()
    {
        init();
        intListTester.addLast(3);
        assertTrue(intListTester.containsValue(3));
        intListTester.deleteNode(3);
        assertFalse(intListTester.containsValue(3));

        intListTester.addFirst(1);
        assertTrue(intListTester.containsValue(1));
        intListTester.deleteNode(1);
        assertFalse(intListTester.containsValue(1));
    }
}
