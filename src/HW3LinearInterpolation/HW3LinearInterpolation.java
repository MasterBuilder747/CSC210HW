//Homework 3: Linear Interpolation
//Author: Joseph Audras
//Professor: Dr. Reinhart
//Date due: 9-30-19
//Class: CSC210-1

package HW3LinearInterpolation;

import java.util.*;

public class HW3LinearInterpolation {

    public static void main(String[] args) {

        //Linear Interpolation is essentially:
        // y = mx + b
        //or: y = ((y2 - y1) / (x2 - x1)) * (x - x1) + y1
        //where x and y are the current position
        //and 1 to 2 is the range

        //Seed for random number
        //Vars
        int seed = 0;

        //Object vars
        Scanner kb = new Scanner (System.in);

        //User input
        try {
            System.out.println("=Linear Interpolation Calculator=");
            System.out.println("Enter a value for a seed: ");
            seed = kb.nextInt();



        }catch (Exception e) {
            System.out.println("The computation could not be completed due to an improper input.");
        }

        //Generate 4 random doubles between 0.0 and 100.0
        //x1, x2, y1, y2
        //checking/swapping to: x2 > x1, y2 > y1
        Random r = new Random (seed);
        //i for input var
        double ix1 = 100 * (r.nextDouble());
        double ix2 = 100 * (r.nextDouble());
        double iy1 = 100 * (r.nextDouble());
        double iy2 = 100 * (r.nextDouble());

        double x1, x2, y1, y2;

        if (ix1 > ix2) {
            x1 = ix2;
            x2 = ix1;
        }else{
            x1 = ix1;
            x2 = ix2;
        }

        if (iy1 > iy2) {
            y1 = iy2;
            y2 = iy1;
        }else{
            y1 = iy1;
            y2 = iy2;
        }

        //plug in these numbers into this formula to solve for x:
        //𝑥 = (𝑥1 + s) * (𝑥2 − 𝑥1)
        //where s is a random constant between 0.0 and 1.0
        double s = r.nextDouble();

        double x = (x1 + s) * (x2 - x1);

        //do the same for solving for y, with the same const s:
        //y = (y1 + s) * (y2 − y1)
        double y = (y1 + s) * (y2 - y1);

        //output the values x, y, x1, x2, y1, y2
        System.out.println(" ");
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
        System.out.println("y1 = " + y1);
        System.out.println("y2 = " + y2);
        System.out.println("x = " + x);
        System.out.println("y = " + y);

    }

}
