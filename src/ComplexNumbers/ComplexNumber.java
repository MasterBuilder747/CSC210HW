//Homework 7: Complex Numbers
//Author: Joseph Audras
//Professor: Dr. Reinhart
//Date due: 11-19-19
//Class: CSC210-1

package ComplexNumbers;

public class ComplexNumber {

    //a + bi, a and b are real numbers, i is an indicator of a complex number, where i^2 = -1
    //variables
    private double real; //a
    private double imaginary; //b


    //constructors
    public ComplexNumber() {
        // constructs a complex number 0 + 0i
    }
    public ComplexNumber(double _r, double _i) {
        //constructs a complex number _r + _ii
        this.real = _r;
        this.imaginary = _i;
    }
    public ComplexNumber(ComplexNumber rhs) {
        //constructs a complex number rhs.r + rhs.ii
        this.real = rhs.real;
        this.imaginary = rhs.imaginary;
    }


    //setters
    public void setReal(double r) {
        this.real = r;
    }
    public void setImag(double i) {
        this.imaginary = i;
    }
    //getters
    public double getReal() {
        return this.real;
    }
    public double getImag() {
        return this.imaginary;
    }


    //methods that return a ComplexNumber type
    //arithmetic functions
    public ComplexNumber add(ComplexNumber rhs) {
        //add rhs to this
        //(𝑎 + 𝑏𝑖) + (𝑐 + 𝑑𝑖) = (𝑎 + 𝑐) + (𝑏 + 𝑑)
        double r = this.real + rhs.real;
        double i = this.imaginary + rhs.imaginary;
        return new ComplexNumber(r, i);
    }
    public ComplexNumber sub(ComplexNumber rhs) {
        //subtracts rhs from this
        //(𝑎 + 𝑏𝑖) − (𝑐 + 𝑑𝑖) = (𝑎 − 𝑐) + (𝑏 − 𝑑)𝑖
        double r = this.real - rhs.real;
        double i = this.imaginary - rhs.imaginary;
        return new ComplexNumber(r, i);
    }
    public ComplexNumber mult(ComplexNumber rhs) {
        //multiplies rhs by this
        //(𝑎 + 𝑏𝑖) ∗ (𝑐 + 𝑑𝑖) = (𝑎𝑐 − 𝑏𝑑) + (𝑎𝑑 + 𝑏𝑐)𝑖
        double r = (this.real * rhs.real) - (this.imaginary * rhs.imaginary);
        double i = (this.real * rhs.imaginary) + (this.imaginary * rhs.real);
        return new ComplexNumber(r, i);
    }
    public ComplexNumber div(ComplexNumber rhs) throws IllegalArgumentException {
        //divides this by rhs, throws exception if division by 0 + 0i
        //(𝑎 + 𝑏𝑖)/(𝑐 + 𝑑𝑖) = ((ac + bd)/(c^2 + d^2)) + ((bc - ad)/(c^2 + d^2))i
        double a = this.real;
        double b = this.imaginary;
        double c = rhs.real;
        double d = rhs.imaginary;
        double r = 0;
        double i = 0;

        if (c != 0 && d != 0) {
            r = ((a * c) + (b * d)) / (Math.pow(c, 2) + Math.pow(d, 2));
            i = ((b * c) - (a * d)) / (Math.pow(c, 2) + Math.pow(d, 2));
            return new ComplexNumber(r, i);
        }else{
            throw new IllegalArgumentException("Divide by zero");
        }
    }
    //other operations that return a complex number
    public ComplexNumber conj() {
        //returns the conjugate of this
        // 𝑐𝑜𝑛𝑗(𝑎 + 𝑏𝑖) = 𝑎 − 𝑏𝑖
        double a = this.real;
        double b = this.imaginary * -1;
        return new ComplexNumber(a, b);
    }
    public ComplexNumber sqrt() {
        //returns the square root of this
        double a = this.real;
        double b = this.imaginary;
        if (this.imaginary != 0) {
            //√(𝑎 + 𝑏𝑖) = √((𝑎 + √(𝑎^2 + b^2)) / 2) ± √((−𝑎 + √(𝑎^2 + 𝑏^2)) / 2) * 𝑖
            double step = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
            double r = Math.sqrt((a + step) / 2);
            double i = Math.sqrt(((-1 * a) + step) / 2);
            //plus or minus
            return new ComplexNumber(r, i);
        }else {
            if (this.real >= 0) {
                //√(𝑎 + 𝑏𝑖) = (±√𝑎 + 0𝑖)
                double r = Math.sqrt(this.real);
                double i = 0;
                return new ComplexNumber(a, b);
            }else{
                //√(𝑎 + 𝑏𝑖) = (0 ± √−𝑎𝑖)
                double r = 0;
                double i = Math.sqrt(-1 * this.real);
                return new ComplexNumber(r, i);
            }
        }
    }

    //methods that return a primitive type
    //abs
    public double mag() {
        //returns the magnitude of this (abs)
        //|(𝑎 + 𝑏𝑖)| = √(𝑎^2 + 𝑏^2)
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
    }
    //comparator
    public boolean equals(ComplexNumber rhs) {
        //returns true if this is equal to rhs, false otherwise
        //(𝑎 + 𝑏𝑖) = (𝑐 + 𝑑𝑖) → (𝑎 = 𝑐) & (𝑏 = 𝑑)
        return rhs.real == this.real && rhs.imaginary == this.imaginary;
    }


    @Override
    public String toString() {
        //returns a String formatted as such: 27.3 + 19.7𝑖.
        //Note that if the imaginary part is negative, it should print a – (subtraction) rather than
        //the addition of a negative number. E.g. 27.3 − 19.7𝑖 not 27.3 ± 19.7𝑖.
        if (this.imaginary >= 0) {
            return this.real + " + " + this.imaginary + "i";
        }else{
            return this.real + " - " + Math.abs(this.imaginary) + "i";
        }
    }
}


