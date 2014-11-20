package pak;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class CasirTest {

    public static void assertBetween(int actual, int from, int to) {
        if (actual < from)
            throw new AssertionError("Значение " + actual + " меньше чем " + from);
        if (actual > to)
            throw new AssertionError("Значение " + actual + " больше чем " + to);
    }

    @Test
    public void testComunalca() throws Exception {
        Casir casir = new Casir();


        int count = 0;
        for (int j = 0; j < 1000; j++) {
            casir.comunalca();
            count = 0;
            while (!casir.areYouFree()) {
                count++;
                casir.timeTik();
            }
            assertBetween(count, 3, 6);
        }


    }

    @Test
    public void testChangeCash() throws Exception {

    }

    @Test
    public void testAddCash() throws Exception {

    }

    @Test
    public void testPerevod() throws Exception {

    }

    @Test
    public void testAreYouFree() throws Exception {

    }
}