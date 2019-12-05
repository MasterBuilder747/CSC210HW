//Homework 8: Mandelbrot Set
//Author: Joseph Audras
//Professor: Dr. Reinhart
//Date due: 12-5-19
//Class: CSC210-1

/*

-Linear interpolation should be performed using the function you wrote previously, you may copy and paste the code into your Mandelbrot.java class
-Complex arithmetic is performed using your ComplexNumber class, you may copy it into the package for this assignment

Zn+1 = Zn^2 + C
where c is a complex number

does magnitude of Zn tend to infinity?

INPUT: C, complex number (class)
PROCESS: does Zn+1 = Zn^2 + C tend to infinity?
OUTPUT: true/false

*/

package HW8MandelbrotSet;

import java.util.Scanner;

public class HW8MandelbrotSet {

    public static void main(String[] args) {

        //this tests the mandelbrot object to see if the complex number inputted is a set
        try (Scanner s = new Scanner(System.in)) {

            System.out.println("=Linear Interpolation with Two Complex Numbers=");
            System.out.println("First Complex Number: ");
            System.out.println("Input real part: ");
            double r = s.nextDouble();
            System.out.println("Input imaginary part");
            double i = s.nextDouble();
            ComplexNumber c1 = new ComplexNumber(r, i);
            System.out.println("First Complex Number is: " + c1);

            System.out.println("Second Complex Number: ");
            System.out.println("Input real part: ");
            r = s.nextDouble();
            System.out.println("Input imaginary part: ");
            i = s.nextDouble();
            ComplexNumber c2 = new ComplexNumber(r, i);
            System.out.println("Second Complex Number is: " + c2);

            System.out.println(Mandelbrot.inSet(c1)); //can be called without constructing, since it is a static function
            System.out.println(Mandelbrot.inSet(c2));
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }

    }

}
