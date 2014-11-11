package pak;

import java.util.Random;

public class Casir {
    private int timeToFree = 0;
    Random generatorMinut = new Random();

    private int randomBetween(int from, int to) {
        return generatorMinut.nextInt(from) + to;
    }

    /**
     * Функция оплаты комунальных услуг
     */
    public void comunalca() {
        timeToFree = randomBetween(3, 6);
    }

    /**
     * Функция обмена валют
     */
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
        timeToFree = timeToFree - 1;

    }

    public boolean areYouFree() {
        return timeToFree == 0;

    }

}
