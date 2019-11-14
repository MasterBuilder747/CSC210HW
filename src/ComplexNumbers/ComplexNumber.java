package ComplexNumbers;

public class ComplexNumber {

    private double real;
    private double imaginary;

    //constructors
    public ComplexNumber() {
        // constructs a complex number 0 + 0i

    }
    public ComplexNumber(double _r, double _i) {
        //constructs a complex number _r + _ii

    }
    public ComplexNumber(ComplexNumber rhs) {
        //constructs a complex number rhs.r + rhs.ii

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

/*
    //arithmetic functions
    public ComplexNumber add(ComplexNumber rhs) {
        //add rhs to this

    }
    public ComplexNumber sub(ComplexNumber rhs) {
        //subtracts rhs from this

    }
    public ComplexNumber mult(ComplexNumber rhs) {
        //multiplies rhs by this

    }
    public ComplexNumber div(ComplexNumber rhs) throws ArithmeticException {
        //divides this by rhs, throws exception if division by 0 + 0i

    }
    public double mag () {//returns the magnitude of this

    }
    public ComplexNumber conj () {//returns the conjugate of this

    }
    public ComplexNumber sqrt () {//returns the square root of this

    }

    //comparator
    public boolean equals (ComplexNumber rhs) {//returns true if this is equal to rhs, false otherwise

    }
*/

/*
    @Override
    public String toString() {
        //returns a String formatted as such: 27.3 + 19.7𝑖.
        //Note that if the imaginary part is negative, it should print a – (subtraction) rather than
        //the addition of a negative number. E.g. 27.3 − 19.7𝑖 not 27.3 ± 19.7𝑖.


    }
*/


    /*
        printing
        ie 27

       im -13

       27 + -13i
       27 - 13i

       27 - 13i
         */


}


