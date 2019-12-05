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

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HW8MandelbrotSet {

    public static void main(String[] args) {
        //test the image writer method, disabled now
        /*
        Random r = new Random();
        //generate an image of 256 by 256 random pixel numbers from 0 to 255
        int[][] img = new int[255][255];
        for (int i = 0; i < 255; i++) {
            for (int j = 0; j < 255; j++) {
                img[i][j] = r.nextInt(255);
            }
        }
        try {
            ImageWrite(img, "random_image.png");
        } catch (IOException e) {
            System.out.println("Improper file path.");
        }
        */


        //this tests the mandelbrot object to see if the complex number inputted is a set
        try (Scanner kb = new Scanner(System.in)) {

            /*
            PROCESS RUNDOWN:
            1) Linearlly interpolate the complex numbers into coordinates
            2) compute the number of iterations using the mandelbrot object inSet method
            3) output the array into an image and store it
             */

            //ask the user for the size of the image

            System.out.println("image width: ");
            int w = kb.nextInt();
            System.out.println("image height: ");
            int h = kb.nextInt();
            if (w <= 0 || h <= 0) {
                throw new ArithmeticException("Value must be a natural number.");
            }else {
                //create the array with the size of the image that is specified
                int[][] img = new int[w][h];

            //input and set the two complex numbers
            System.out.println("=Linear Interpolation with Two Complex Numbers=");
            System.out.println("First Complex Number: ");
            System.out.println("Input real part: ");
            double real = kb.nextDouble();
            System.out.println("Input imaginary part: ");
            double imag = kb.nextDouble();
            ComplexNumber c1 = new ComplexNumber(real, imag);
            System.out.println("First Complex Number is: " + c1);

            System.out.println("Second Complex Number: ");
            System.out.println("Input real part: ");
            real = kb.nextDouble();
            System.out.println("Input imaginary part: ");
            imag = kb.nextDouble();
            ComplexNumber c2 = new ComplexNumber(real, imag);
            System.out.println("Second Complex Number is: " + c2);
            System.out.println(Mandelbrot.inSet(c1));
            System.out.println(Mandelbrot.inSet(c2));

            //linear interpolation to map two complex numbers


                for(int i = 0; i < w; i++) {
                    for(int j = 0; j < h; j++) {
                        img[i][j] = Mandelbrot.inSet(c1);
                    }
                }

            }

        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

    public static void ImageWrite(int[][] img, String filename) throws IOException
    {
        try {
            BufferedImage bi = new BufferedImage(img[0].length, img.length, BufferedImage.TYPE_INT_RGB);

            // -- prepare output image
            for (int i = 0; i < bi.getHeight(); ++i) {
                for (int j = 0; j < bi.getWidth(); ++j) {
                    int pixel =	(img[i][j] << 16) | (img[i][j] << 8) | (img[i][j]);
//	    			int pixel =	((int)(Math.random() * 255) << 16) | (img[i][j] << 8) | (img[i][j]);
                    bi.setRGB(j, i, pixel);
                }
            }

            // -- write output image
            File outputfile = new File(filename);
            ImageIO.write(bi, "png", outputfile);
        }
        catch (IOException e) {
            throw e;
        }

    }

}
