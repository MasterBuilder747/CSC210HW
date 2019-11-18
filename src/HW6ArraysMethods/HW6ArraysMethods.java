//Homework 6: Arrays & Methods
//Author: Joseph Audras
//Professor: Dr. Reinhart
//Date due: 11-7-19
//Class: CSC210-1

package HW6ArraysMethods;

import java.util.Random;
import java.util.Scanner;

public class HW6ArraysMethods {

    public static void main(String[] args) {

        //take user inputs for number generation
        Scanner kb = new Scanner(System.in);
        long seed = 0;
        try {
            System.out.println("Enter the seed: ");
            seed = kb.nextLong();
        } catch (Exception e) {
            System.out.println("Invalid range or data type.");
        }
        Random r = new Random(seed);
        int N = 0;
        try {
            System.out.println("Enter the number of values: ");
            N = kb.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid range or data type.");
        }
        float min = 0;
        try {
            System.out.println("Enter the minimum value: ");
            min = kb.nextFloat();
        } catch (Exception e) {
            System.out.println("Invalid range or data type.");
        }
        float max = 0;
        try {
            System.out.println("Enter the maximum value: ");
            max = kb.nextFloat();
        } catch (Exception e) {
            System.out.println("Invalid range or data type.");
        }

        //handle min and max for linear interpolation
        if (min > max) {
            float x = max;
            max = min;
            min = x;
        }

        //do semantic checking for vars before processing
        if (N == 1 || N == 0) {
            System.out.println("N cannot be 0 or 1.");
        }else if (min == max) {
            System.out.println("min and max must be different values.");
        }else{
            //generate random numbers and store it in an array
            double[] a = new double[N];
            for (int i = 0; i < a.length; i++) {
                //this is linear interpolation
                double rand = min + (Math.abs(max - min) * r.nextDouble());
                a[i] = rand;
            }

            //output the result using both std methods
            System.out.println("Standard deviation using Standard method: " + stdS(a));
            System.out.println("Standard deviation using  Welford method: " + stdW(a));
        }
    }

    public static double stdS(double[] a) {
        double sum1 = 0;
        double sum2 = 0;
        double N = a.length;

        for (double v : a) {
            sum1 = sum1 + Math.pow(v, 2);
        }
        double sumA = sum1 / N;

        for (double v : a) {
            sum2 = sum2 + v;
        }
        double sumB = Math.pow((sum2 / N), 2);
        return Math.sqrt(sumA - sumB);
    }

    public static double stdW(double[] a) {
        double mean = 0;
        double mean2 = 0;
        double delta;
        double N = a.length;
        int j = 0;

        for (int i = 0; i < a.length; ++i) {
            //mean2 = mean2(n-1) + (x - mean)(x - mean(n-1))
            j = j + 1;
            delta = a[i] - mean;
            mean = mean + (delta / j);
            mean2 = mean2 + (delta * (a[i] - mean));
        }
        return Math.sqrt(mean2 / (N - 1));
    }

}
