//Homework 5: Methods
//Author: Joseph Audras
//Professor: Dr. Reinhart
//Date due: 10-15-19
//Class: CSC210-1

package HW5Methods;

import java.util.Random;
import java.util.Scanner;

public class HW5Methods

{

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.println("===Dice Simulator===");
        System.out.println(" ");

        try {
            //take inputs for stddev function
            int seed = 0;
            System.out.println("Enter a seed for the random generator: ");
            seed = kb.nextInt();

            int N = 0;
            System.out.println("Enter the number of repetitions: ");
            N = kb.nextInt();

            int min = 0;
            System.out.println("Enter the minimum number: ");
            min = kb.nextInt();

            int max = 0;
            System.out.println("Enter the maximum number: ");
            max = kb.nextInt();

            System.out.println("The standard deviation is: " + stddev(seed, N, min, max));

        } catch (Exception e) {
            System.out.println("Invalid Number or cannot be a decimal.");
        }
    }

    public static double stddev(int seed, int N, int min, int max) {
        double rand;
        int reps;
        double mean = mean(seed, N, min, max);
        Random rs = new Random(seed);

        double sdSum = 0.0;
        for (reps = N; reps > 0; reps--) {
            rand = min + (Math.abs(max - min) * rs.nextDouble());
            sdSum = +Math.pow((rand - mean), 2);
        }

        return (Math.sqrt((sdSum / N)));
    }

    public static double mean(int seed, int N, int min, int max) {
        double mean;
        double sum = 0;
        int reps;
        double rand;
        Random rm = new Random(seed);

        for (reps = N; reps > 0; reps--) {
            rand = min + (Math.abs(max - min) * rm.nextDouble());
            sum += rand;
        }

        return (sum / N);
    }

}