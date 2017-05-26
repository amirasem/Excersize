import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;


public class HammamTest {
    @Test
    public void add() throws Exception {
        Scanner scanner = new Scanner(System.in);
        Hammam<String> customerName = new Hammam<>();
        customerName.add(null);
    }

    @Test
    public void getMin() throws Exception {

    }

    @Test
    public void getLast() throws Exception {

    }

    @Test
    public void getFirst() throws Exception {

    }

    @Test
    public void getLess() throws Exception {

    }

    @Test
    public void getRecentlyRemoved() throws Exception {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hammam<String> customeNames = new Hammam<>();
        customeNames.add(scanner.next());
    }

}