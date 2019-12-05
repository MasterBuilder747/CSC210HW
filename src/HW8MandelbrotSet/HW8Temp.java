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

public class HW8Temp {

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
            int width = kb.nextInt();
            System.out.println("image height: ");
            int height = kb.nextInt();
            if (width <= 0 || height <= 0) {
                throw new ArithmeticException("Value must be a natural number.");
            }else {
                //create the array with the size of the image that is specified
                int[][] img = new int[width][height];

                //input and set the two complex numbers
                /*
                System.out.println("=Linear Interpolation with Two Complex Numbers=");
                System.out.println("First Complex Number: ");
                System.out.println("Input real part: ");
                double real = kb.nextDouble();
                System.out.println("Input imaginary part: ");
                double imag = kb.nextDouble();
                ComplexNumber c1 = new ComplexNumber(real, imag);
                */
                //System.out.println("First Complex Number is: " + c1);
                /*
                System.out.println("Second Complex Number: ");
                System.out.println("Input real part: ");
                real = kb.nextDouble();
                System.out.println("Input imaginary part: ");
                imag = kb.nextDouble();
                ComplexNumber c2 = new ComplexNumber(real, imag);
                System.out.println("Second Complex Number is: " + c2);
                System.out.println(Mandelbrot.inSet(c1));
                System.out.println(Mandelbrot.inSet(c2));
                */

                ComplexNumber c1 = new ComplexNumber(-2, -1);
                ComplexNumber c2 = new ComplexNumber(1, 1);

                //linear interpolation to map two complex numbers
                Random rn = new Random();
                double x1 = 0;
                double x2 = 0;
                double y1 = 0;
                double y2 = 0;

                if (c1.getReal() > c2.getReal()) {
                    x1 = c2.getReal();
                    x2 = c1.getReal();
                }else{
                    x1 = c1.getReal();
                    x2 = c2.getReal();
                }
                if (c1.getImag() > c2.getImag()) {
                    y1 = c2.getImag();
                    y2 = c1.getImag();
                }else{
                    y1 = c1.getImag();
                    y2 = c2.getImag();
                }

                ComplexNumber c;
                for(int i = 0; i < width; i++) {
                    for(int j = 0; j < height; j++) {

                        //linear interpolation
                        double real = (j - width/2.0) * 4.0 / width;
                        double imag = (i - height/2.0) * 4.0 / width;

                        c = new ComplexNumber(real, imag);
                        img[i][j] = Mandelbrot.inSet(c);
                    }
                }
                ImageWrite(img, "mandelbrot_fractal.png");

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
