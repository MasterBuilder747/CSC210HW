package HW8MandelbrotSet;

public class Lerp {

    public static void main(String[] args) {
        System.out.println("y: " + lerp2(0, -2, 1, 1, -1));
        System.out.println(" ");
        //test the x value only
        //norm is the percentage of the position on the axis
        System.out.println(lerp(-2, 1, 0.5));
    }

    public static double lerp(double min, double max, double norm) {
        return (max - min) * norm + min;
    }

    public static double lerp2(int Nx, double x1, double y1, double x2, double y2) {
        //c = complex number, p = pixel
        return (((y2 - y1)/(x2 - x1)) * (Nx - x1)) + y1;
    }

}
