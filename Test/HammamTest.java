import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.*;


public class HammamTest {
    @Test
    public void add() throws Exception {
        Hammam<Integer> numbers= new Hammam<>();
        numbers.add(5);
        numbers.add(15);
        numbers.add(null);
    }



    @Test(expected = IllegalStateException.class)
    public void getMinForNull() throws Exception {
        Hammam<Integer> numbers= new Hammam<>();
        numbers.add(null);
        numbers.add(null);
        numbers.add(null);
        assertEquals(5 , numbers.getMin() , numbers.getMin());
        System.out.println("the min  = " + numbers.getMin());
    }
    @Test
    public void getMinForEquals() throws Exception {
        Hammam<Integer> numbers = new Hammam<>();
        numbers.add(15);
        numbers.add(15);
        numbers.add(15);
        assertEquals(15 , numbers.getMin() , numbers.getMin());
        System.out.println("the min  is  :" + numbers.getMin());
    }
    @Test
    public void getMinForNegativeNumber() throws Exception{
        Hammam<Integer> numbers  = new Hammam<>();
        numbers.add(-1);
        numbers.add(-1500);
        numbers.add(null);
        numbers.add(1500);
        assertEquals(-1500 , numbers.getMin() , numbers.getMin());
        System.out.println("the min is  :" + numbers.getMin());

    }
    @Test(expected = IllegalStateException.class)
    public void getLastForEmpty() throws Exception {
        Hammam <Integer> numbers  = new Hammam<>();
        numbers.getLast(false);
        System.out.println(numbers.getLast(false));
    }
    @Test
    public void getLastForNull() throws Exception{
        Hammam<Integer> numbers = new Hammam<>();
        numbers.add(null);
        numbers.add(null);
        numbers.add(15);
        numbers.add(null);
        numbers.add(153);
        numbers.getLast(false);

        System.out.println("the last is "  + numbers.getLast(false));
    }



    @Test (expected = IllegalStateException.class)
    public void getFirstForEmpty() throws Exception {
        Hammam<Integer> numbers = new Hammam<>();
        numbers.getFirst(false);
    }
    @Test
    public void getFirstForNull() throws Exception{
        Hammam<Integer> numbers  = new Hammam<>();
        numbers.add(null);
        numbers.add(15);
        numbers.add(null);
        numbers.getFirst(false);
        System.out.println(numbers.getFirst(false));
    }

    @Test
    public void getLess() throws Exception {
        Hammam<Integer> numbers =  new Hammam<>();
        numbers.add(15);
        numbers.add(16);
        numbers.add(-11);
        numbers.add(null);
        numbers.add(13);
        assertArrayEquals(numbers.getLess(13 , false) , numbers.getLess(13 , false));
        System.out.println(Arrays.toString(numbers.getLess(13, false)));
    }



    @Test(expected = NullPointerException.class)
    public void getRecentlyRemovedForEmpty() throws Exception {
        Hammam<Integer> numbers = new Hammam<>();
        numbers.getRecentlyRemoved(0);
    }
    @Test(expected = NullPointerException.class)
    public void getRecentlyRemovedForNegetiveN() throws Exception{
        Hammam<Integer> numbers  = new Hammam<>();
        numbers.add(15);
        numbers.add(16);
        numbers.getFirst(true);
        numbers.getRecentlyRemoved(-1);
    }




}