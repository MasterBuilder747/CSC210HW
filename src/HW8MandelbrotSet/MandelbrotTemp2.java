//Homework 8: Mandelbrot Set
//Author: Joseph Audras
//Professor: Dr. Reinhart
//Date due: 12-5-19
//Class: CSC210-1

package HW8MandelbrotSet;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MandelbrotTemp2 {

    public static void main(String[] args) {

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

                //allow for input for the coordinates from the user
                //defaults to largest image
                System.out.println("Generate the window to zoom on: ");
                System.out.println("*To generate the full image, use -2, -1; 1, 1 for coordinates*");
                System.out.println("Enter the lower bound coordinates (top left corner): ");
                System.out.println("X1: ");
                double r1 = kb.nextDouble();
                System.out.println("Y1: ");
                double i1 = kb.nextDouble();
                System.out.println("Enter the upper bound coordinates (bottom right corner): ");
                System.out.println("X2: ");
                double r2 = kb.nextDouble();
                System.out.println("Y2: ");
                double i2 = kb.nextDouble();

                ComplexNumber c1 = new ComplexNumber(r1, i1);
                ComplexNumber c2 = new ComplexNumber(r2, i2);

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

                        //linear interpolation done depending on the position
                        double zoom = 1.0;
                        double a1 = 1.0;
                        double real = (j - width/1.0) * zoom / width;
                        double imag = (i - height/1.0) * zoom / width;

                        c = new ComplexNumber(real, imag);
                        img[i][j] = Mandelbrot.inSet(c);
                    }
                }
                ImageWrite(img, "mandelbrot_fractal_zoom.png");

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
