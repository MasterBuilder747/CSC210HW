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
            System.out.println("=Fractal Generator=");
            System.out.println("Input the resolution, higher than 4000 is too large: ");
            System.out.println("image width: ");
            int width = kb.nextInt();
            System.out.println("image height: ");
            int height = kb.nextInt();

            ComplexNumber c1 = new ComplexNumber(-2, 1);
            ComplexNumber c2 = new ComplexNumber(1, -1);
            double x1 = c1.getReal();
            double y1 = c1.getImag();
            double x2 = c2.getReal();
            double y2 = c2.getImag();

            if (width <= 0 || height <= 0) {
                throw new ArithmeticException("Value must be a natural number.");
            }else {
                //create the array with the size of the image that is specified
                int[][] img = new int[height][width]; //[i][j]

                //full image
                ComplexNumber gen1;
                for(double i = 0; i < width; i++) {
                    for(double j = 0; j < height; j++) {

                        double x = -0.5;
                        double y = 0;
                        double R = 1.5;
                        x1 = x - R;
                        y1 = y + R;
                        x2 = x + R;
                        y2 = y - R;
                        double sx = i/width;
                        double sy = j/height;
                        double real = lerp(x1, x2, sx);
                        double imag = lerp(y1, y2, sy);

                        gen1 = new ComplexNumber(real, imag); //~1.46 = 1, ~0.37 = 81, 0.35 = 255
                        img[(int)j][(int)i] = Mandelbrot.inSet(gen1);
                    }
                }
                try {
                    ImageWrite(img, "mandelbrot_fractal.png");
                } catch (Exception e) {
                    System.out.println("Error in writing to file.");
                } finally {
                    System.out.println("Image 1 rendered.");
                }

                //zoom factor variables
                double x = 0; //the x position of the centerpoint fo the window
                double y = 0; //the y position of the centerpoint fo the window
                double R = 0; //the radius of the window out from the position (must be natural)

                //zoom1 on the fractal
                System.out.println("Zoomed fractals: ");
                System.out.println("Enter the center point x: ");
                x = kb.nextDouble();
                System.out.println("Enter the center point y: ");
                y = kb.nextDouble();
                System.out.println("Enter the radius of the window, cannot be 0 or less: ");
                R = kb.nextDouble();
                if (R <= 0) {
                    throw new ArithmeticException("Wrong input for radius of window on zoom");
                }
                /*
                //swirl: number 2 on website
                x = -0.7453;
                y = 0.1127;
                R = 0.00065;
                */
                ComplexNumber gen2;
                for(double i = 0; i < width; i++) {
                    for(double j = 0; j < height; j++) {

                        x1 = x - R;
                        y1 = y + R;
                        x2 = x + R;
                        y2 = y - R;
                        double sx = i/width;
                        double sy = j/height;
                        double real = lerp(x1, x2, sx);
                        double imag = lerp(y1, y2, sy);

                        gen1 = new ComplexNumber(real, imag); //~1.46 = 1, ~0.37 = 81, 0.35 = 255
                        img[(int)j][(int)i] = Mandelbrot.inSet(gen1);
                    }
                }
                try {
                    ImageWrite(img, "mandelbrot_fractal_zoom1.png");
                } catch (Exception e) {
                    System.out.println("Error in writing to file.");
                } finally {
                    System.out.println("Image 2 rendered.");
                }

                //zoom2
                System.out.println("Zoomed fractal 2: ");
                System.out.println("Enter the center point x: ");
                x = kb.nextDouble();
                System.out.println("Enter the center point y: ");
                y = kb.nextDouble();
                System.out.println("Enter the radius of the window, cannot be 0 or less: ");
                R = kb.nextDouble();
                if (R <= 0) {
                    throw new ArithmeticException("Wrong input for radius of window on zoom");
                }
                /*
                //cool microbe: number 8 on website
                x = -0.748;
                y = 0.1;
                R = 0.0014;
                */

                //zoom2 on the fractal
                ComplexNumber gen3;
                for(double i = 0; i < width; i++) {
                    for(double j = 0; j < height; j++) {

                        x1 = x - R;
                        y1 = y + R;
                        x2 = x + R;
                        y2 = y - R;
                        double sx = i/width;
                        double sy = j/height;
                        double real = lerp(x1, x2, sx);
                        double imag = lerp(y1, y2, sy);

                        gen1 = new ComplexNumber(real, imag); //~1.46 = 1, ~0.37 = 81, 0.35 = 255
                        img[(int)j][(int)i] = Mandelbrot.inSet(gen1);
                    }
                }
                try {
                    ImageWrite(img, "mandelbrot_fractal_zoom2.png");
                } catch (Exception e) {
                    System.out.println("Error in writing to file.");
                } finally {
                    System.out.println("Image 3 rendered.");
                }
            }

        } catch (Exception e) {
            System.out.println("Invalid input.");
        }

    }

    public static double lerp(double min, double max, double norm) {
        return (max - min) * norm + min;
    }

    public static double lerp2(int num, double c1, double c2, double p1, double p2) {
        // [x0, x1], [y1, y2]
        //map: 0-width/height to 2.5-2.5i
        //num = starting x value
        return (((c2 - c1)/(p2 - p1)) * (num - p1)) + c1;
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
