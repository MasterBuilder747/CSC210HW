package HW8MandelbrotSet;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
