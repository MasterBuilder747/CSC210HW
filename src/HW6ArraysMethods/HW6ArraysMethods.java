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
        if (min > max) {
            float x = max;
            max = min;
            min = x;
        }

        //generate random numbers and store it in an array
        double[] a = new double[N];
        for (int i = 0; i < a.length; i++) {
            //this is linear interpolation
            double rand = min + (Math.abs(max - min) * r.nextDouble());
            a[i] = rand;
            System.out.println(a[i]);
        }

        //output the result using both std methods
        System.out.println("Standard deviation using Standard method: " + stdS(a));
        System.out.println("Standard deviation using  Welford method: " + stdW(a));
    }

    public static double stdS(double[] a) {
        double sum1 = 0;
        double sum2 = 0;
        int N = a.length;

        for (double v : a) {
            sum1 =+ Math.pow(v, 2);
        }
        sum1 = sum1 / N;

        for (double v : a) {
            sum2 =+ v;
        }
        sum2 = sum2 / N;
        sum2 = Math.pow(sum2, 2);

        return Math.sqrt(sum1 - sum2);
    }

    public static double stdW(double a[]) {
        double mean = 0;
        double mean2 = 0;
        double delta;
        double N = a.length;
        int j = 0;

        for (double v : a) {
            j = j + 1;
            delta = v - mean;
            mean = mean + (delta / j); //change to N
            mean2 = mean2 + delta * (v - mean);
        }
        return Math.sqrt(mean2 / (N - 1));
    }

}
