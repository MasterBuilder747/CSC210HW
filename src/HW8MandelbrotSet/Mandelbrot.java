package HW8MandelbrotSet;

public class Mandelbrot {

    private Mandelbrot () {
        //default private constructor, allows for parameters to be required
    }

    //this can be called without constructing the object
    public static int inSet(ComplexNumber c) {

        //determines if a given complex number is within the Mandelbrot set
        ComplexNumber z = new ComplexNumber(0,0);
        int count = 0;

        //find out how longit takes for the complex number c to tend to infinity
        while (z.mag() < 2.0 && count < 255) {
            //keep running this formula until make amount of color values (255)
            //square z, then add it to c
            z = c.add(z.mult(z));
            count++;
        }

        //outputs the number of iterations of the recurrence is better to return than just true/false
        //note that 255 is infinity in this case as this will later be used to output an image (255 is for colors)
        return count;
    }

}
