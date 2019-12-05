//copy over the linear interpolation class from HW3, to implement a class version of it
package HW8MandelbrotSet;

import java.util.Random;

public class LinInt {

    private int seed;

    private double ix1;
    private double ix2;
    private double iy1;
    private double iy2;
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    private LinInt () {
        //no parameter is redundant and does not do anything
    }

    LinInt(double min, double max) {

        this.seed = seed;
        Random r = new Random (seed);

        this.ix1 = 100 * (r.nextDouble());
        this.ix2 = 100 * (r.nextDouble());
        this.iy1 = 100 * (r.nextDouble());
        this.iy2 = 100 * (r.nextDouble());

        if (ix1 > ix2) {
            x1 = ix2;
            x2 = ix1;
        }else{
            x1 = ix1;
            x2 = ix2;
        }

        if (iy1 > iy2) {
            y1 = iy2;
            y2 = iy1;
        }else{
            y1 = iy1;
            y2 = iy2;
        }

        //plug in these numbers into this formula to solve for x:
        //𝑥 = (𝑥1 + s) * (𝑥2 − 𝑥1)
        //where s is a random constant between 0.0 and 1.0
        double s = r.nextDouble();

        double x = (x1 + s) * (x2 - x1);

        //do the same for solving for y, with the same const s:
        //y = (y1 + s) * (y2 − y1)
        double y = (y1 + s) * (y2 - y1);

    }



}
