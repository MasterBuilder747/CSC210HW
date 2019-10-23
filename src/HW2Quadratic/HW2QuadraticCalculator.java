//Homework 2: Quadratic Evaluator
//Author: Joseph Audras
//Professor: Dr. Reinhart
//Date due: 9-23-19
//Class: CSC210-1

package HW2Quadratic;

import java.util.Scanner;

public class HW2QuadraticCalculator {

    public static void main(String[] args) {

        //user input
        Scanner reader = new Scanner(System.in);
        System.out.println("=Quadratic Equation Roots Calculator=");
        System.out.println("Enter A, B, & C for the quadratic equation below: ");
        System.out.println("[-B +- sqrt(B ^ 2 - 4AC)] / 2A");

        //3 inputs
        System.out.print("A: ");
        double A = reader.nextDouble();
        System.out.print("B: ");
        double B = reader.nextDouble();
        System.out.print("C: ");
        double C = reader.nextDouble();

        //2 possible outputs
        double output1 = 0;
        double output2 = 0;

        //processing vars
        double disc;
        double root1;
        double root2;
        double cRoot;
        int round1;
        int round2;
        double bround1;
        double bround2;

        //guarantee that B is a negative value
        double neg = (-1 * B);

        //check user inputs before processing
        if (A == 0) {
            if (B == 0) {
                //Abort, the equation is a horizontal line, as it has infinite roots, which cannot be calculated
                System.out.println("This curve has no solutions.");
            } else {
                //This is a linear equation, solve for x-intercept as the root
                //y = mx + b
                //or 0 = bx + c
                //solving for x:
                //x = -(c/b)
                root1 = -1 * (C / B);

                //ensure that -0.0 doesn't occur
                if (root1 == 0) {
                    output1 = 0;
                } else {
                    output1 = root1;
                }

                System.out.println("This is a linear equation with one root at " + output1 + ".");
            }
        } else {
            //start processing if conditions are met
            //solve for the discriminant for testing
            disc = Math.pow(B, 2);
            disc -= (4 * A * C);

            if (disc > 0) {
                //two roots
                //evaluate the entire formula
                root1 = Math.sqrt(disc);
                output1 = (neg + root1) / (2 * A);
                output2 = (neg - root1) / (2 * A);
                System.out.println(output1 + " " + output2);

            } else if (disc == 0) {
                //one root
                //only evaluate what is left of the formula
                output1 = neg / (2 * A);

                System.out.println("There is one root of " + output1 + ".");

            } else {
                //two complex roots: x + yi
                //separate formula to separate complex and real numbers:
                //factor out sqrt(-1) when evaluating root and put i
                cRoot = ((Math.sqrt(Math.abs(disc))) / (2 * A));
                output1 = neg / (2 * A);

                System.out.println("There are two complex roots of " + output1 + " + " + cRoot + "i and " + output1 + " - " + cRoot + "i.");

            }
        }
    }
}