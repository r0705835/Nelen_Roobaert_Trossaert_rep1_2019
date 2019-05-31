package model;

import java.util.Random;

class Die {

    static int roll() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
