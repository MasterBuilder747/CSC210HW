package HW4RNG;

import java.util.Random;

public class RandomObj {

    public static void main(String[] args) {

        //this proves that a seeded object does NOT produce the same string of numbers on a different for loop
        Random r = new Random(15);

        for (int i = 0; i < 6; i++) {

            int value = 1 + r.nextInt(6);
            System.out.println("x: " + value);

        }

        //idiot, put this here
        //the starts the seed again at the same point in runtime
        r.setSeed(15);

        for (int j = 0; j < 6; j++) {

            int value2 = 1 + r.nextInt(6);
            System.out.println("y: " + value2);

        }


    }

}
