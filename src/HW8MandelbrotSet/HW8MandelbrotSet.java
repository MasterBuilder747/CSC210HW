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

        //try (Scanner kb = new Scanner(System.in)) {

            /*
            PROCESS RUNDOWN:
            1) Linearlly interpolate the complex numbers into coordinates
            2) compute the number of iterations using the mandelbrot object inSet method
            3) output the array into an image and store it
             */

            //ask the user for the size of the image
            /*
            System.out.println("image width: ");
            int width = kb.nextInt();
            System.out.println("image height: ");
            int height = kb.nextInt();
            */
            //temporary defaults
            //after testing, stick to square aspect ratio only
            //coordinate system is a 3 by 2, so therefore a 3:2 aspect ratio must be used
            //note that 1:1 can also be used and works fine
            //do not accept any others
            int width = 300;
            int height = 300;

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

                System.out.println("Rendering...");
                x1 = -2;
                y1 = 1;
                x2 = 1;
                y2 = -1;

                //full image
                ComplexNumber gen1;
                for(double i = 0; i < width; i++) {
                    for(double j = 0; j < height; j++) {

                        //linear interpolation done depending on the position
                        //real = 𝑥 = (𝑥1 + s) * (𝑥2 − 𝑥1)
                        //imag = y = (y1 + s) * (y2 − y1)
                        double sx = i/width;
                        double sy = j/width;
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

                //zoom1 on the fractal
                ComplexNumber gen2;
                for(double i = 0; i < width; i++) {
                    for(double j = 0; j < height; j++) {

                        //linear interpolation done depending on the position
                        double sx = i/width;
                        double sy = j/height;
                        double real = lerp(x1, x2, sx);
                        double imag = lerp(y1, y2, sy);

                        gen2 = new ComplexNumber(real, imag); //~1.46 = 1, ~0.37 = 81, 0.35 = 255
                        img[(int)i][(int)j] = Mandelbrot.inSet(gen2);
                    }
                }
                try {
                    ImageWrite(img, "mandelbrot_fractal_zoom1.png");
                } catch (Exception e) {
                    System.out.println("Error in writing to file.");
                } finally {
                    System.out.println("Image 2 rendered.");
                }

                //zoom2 on the fractal
                ComplexNumber gen3;
                for(double i = 0; i < width; i++) {
                    for(double j = 0; j < height; j++) {

                        //linear interpolation done depending on the position
                        double sx = i/width;
                        double sy = j/height;
                        double real = lerp(x1, x2, sx);
                        double imag = lerp(y1, y2, sy);

                        gen3 = new ComplexNumber(real, imag); //~1.46 = 1, ~0.37 = 81, 0.35 = 255
                        img[(int)i][(int)j] = Mandelbrot.inSet(gen3);
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
/*
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }

 */
    }

    public static double lerp(double min, double max, double norm) {
        return (max - min) * norm + min;
    }

    public static double lerp2(int n, double c1, double c2, double p1, double p2) {
        //c = complex number, p = pixel
        return (((c2 - c1)/(p2 - p1)) * (n - p1)) + c1;
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
