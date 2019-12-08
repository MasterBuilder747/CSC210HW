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

public class HW8MandelbrotSet {

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

                //full image
                ComplexNumber c1;
                for(int i = 0; i < width; i++) {
                    for(int j = 0; j < height; j++) {

                        //linear interpolation done depending on the position
                        double real = (j - width/2.0) * 4.0 / width;
                        double imag = (i - height/2.0) * 4.0 / width;

                        c1 = new ComplexNumber(real, imag);
                        img[i][j] = Mandelbrot.inSet(c1);
                    }
                }
                ImageWrite(img, "mandelbrot_fractal.png");
                System.out.println("Image 1 rendered.");

                //zoom1 on the fractal
                ComplexNumber c2;
                for(int i = 0; i < width; i++) {
                    for(int j = 0; j < height; j++) {

                        //linear interpolation done depending on the position
                        double zoom = 1.0;
                        double real = (j - width/1.0) * zoom / width;
                        double imag = (i - height/1.0) * zoom / width;

                        c2 = new ComplexNumber(real, imag);
                        img[i][j] = Mandelbrot.inSet(c2);
                    }
                }
                ImageWrite(img, "mandelbrot_fractal_zoom1.png");
                System.out.println("Image 2 rendered.");

                //zoom2 on the fractal
                ComplexNumber c3;
                for(int i = 0; i < width; i++) {
                    for(int j = 0; j < height; j++) {

                        //linear interpolation done depending on the position
                        double zoom = 1.0;
                        double real = (j - width/0.5) * zoom / width;
                        double imag = (i - height/1.5) * zoom / width;

                        c3 = new ComplexNumber(real, imag);
                        img[i][j] = Mandelbrot.inSet(c3);
                    }
                }
                ImageWrite(img, "mandelbrot_fractal_zoom2.png");
                System.out.println("Image 3 rendered.");

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
