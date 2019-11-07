package HW6ArraysMethods;

import java.util.Random;
import java.util.Scanner;

public class HW6ArraysMethods {

    public static void main(String[] args) {

        //notes
        //standard method: srt((sum(xi^2)/N) - (sum(xi)/N))^2)
        //Welford: 𝜇2,𝑛 = 𝜇2,𝑛−1 + (𝑥𝑛 − 𝑥̅𝑛)(𝑥𝑛 − 𝑥̅𝑛−1)
        //

        //take user inputs for number generation
        Scanner kb = new Scanner(System.in);
        long seed = 0;
        try {
            System.out.println("Enter the seed: ");
            seed = kb.nextLong();
        }catch(Exception e) {
            System.out.println("Invalid range or data type.");
        }
        Random r = new Random(seed);
        int N = 0;
        try {
            System.out.println("Enter the number of values: ");
            N = kb.nextInt();
        }catch(Exception e) {
            System.out.println("Invalid range or data type.");
        }
        float min = 0;
        try {
            System.out.println("Enter the minimum value: ");
            min = kb.nextFloat();
        }catch(Exception e) {
            System.out.println("Invalid range or data type.");
        }
        float max = 0;
        try {
            System.out.println("Enter the maximum value: ");
            max = kb.nextFloat();
        }catch(Exception e) {
            System.out.println("Invalid range or data type.");
        }

        //generate random numbers and store it in an array
        double[] a = new double[N];

        


        //linear interpolation:
        // y - y1 = ((y2 - y1) / (x2 - x1)) * (x - x1)

        //output the result using both std methods
        System.out.println("Standard deviation using standard method: " + stdS(a));
        System.out.println("Standard deviation using Welford method: " + stdW(a));
    }

    public static double stdS(double a[]) {
        double std = 0;



        return std;
    }

    public static double stdW(double a[]) {
        double std = 0;


        int i = 0;
        int mean = 0;
        int M2 = 0;
        /*
        for () {

        }
        */


        /*
        i = 0
        mean = 0
        M2 = 0
        for all N samples x in the data set
        i = i + 1
        delta = x – mean
        mean = mean + (delta / i)
        M2 = M2 + delta * (x – mean)
        stddev = sqrt(M2 / (i – 1))
         */

        return std;
    }

}
