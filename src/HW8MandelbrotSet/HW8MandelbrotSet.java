package HW8MandelbrotSet;

import java.util.Scanner;

public class HW8MandelbrotSet {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //this tests the mandelbrot object to see if the complex number inputted is a set
        try {
            System.out.println("Real part: ");
            double r = s.nextDouble();
            System.out.println("Imaginary part");
            double i = s.nextDouble();
            ComplexNumber c = new ComplexNumber(r, i);
            System.out.println(Mandelbrot.inSet(c)); //can be called without constructing, since it is a static function
        } catch (Exception e) {
            System.out.println("Invalid input.");
        } finally {
            s.close();
        }
    }

}
