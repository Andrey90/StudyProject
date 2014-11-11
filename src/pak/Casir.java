package pak;

import java.util.Random;

/**
 * Created by SuperStar on 06.11.2014.
 */
public class Casir {
    private int timeToFree = 0;
    Random generatorMinut = new Random();

    private int randomBetween(int from, int to) {
        return generatorMinut.nextInt(from) + to;
    }

    public void comunalca() {
        timeToFree = randomBetween(3, 6);
    }

    public void changeCash() {
        timeToFree = randomBetween(3, 5);

    }

    public void addCash() {
        timeToFree = randomBetween(10, 15);

    }

    public void perevod() {
        timeToFree = randomBetween(10, 20);

    }

    public void timeTik() {

    }

    public boolean areYouFree() {
        return timeToFree == 0;

    }

}
