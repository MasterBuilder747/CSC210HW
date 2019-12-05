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
            System.out.println("Real part: ");
            double r = s.nextDouble();
            System.out.println("Imaginary part");
            double i = s.nextDouble();
            ComplexNumber c = new ComplexNumber(r, i);
            System.out.println(Mandelbrot.inSet(c)); //can be called without constructing, since it is a static function
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

}
