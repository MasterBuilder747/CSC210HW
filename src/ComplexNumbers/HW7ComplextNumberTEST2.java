package ComplexNumbers;

import java.util.Scanner;

public class HW7ComplextNumberTEST2 {

    //DO NOT TURN THIS FILE IN! IT IS ONLY FOR TESTING!!!
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        /*

        ComplexNumber empty = new ComplexNumber();
        System.out.println(empty.toString());

        //add the first complex number
        System.out.println("Enter the real number: ");
        double a = kb.nextDouble();
        System.out.println("Enter the imaginary number: ");
        double b = kb.nextDouble();
        ComplexNumber test = new ComplexNumber(a, b);

        //add a second complex number
        System.out.println("Enter the real number: ");
        a = kb.nextDouble();
        System.out.println("Enter the imaginary number: ");
        b = kb.nextDouble();
        ComplexNumber test2 = new ComplexNumber(a, b);
        System.out.println(test2.toString());
        */

        ComplexNumber num1 = new ComplexNumber(1, 2);
        ComplexNumber num2 = new ComplexNumber(3, 4);

        System.out.println(num1.add(num2));
        System.out.println(num1.sub(num2));
        System.out.println(num1.mult(num2));
        //System.out.println(num1.div(num2));

        ComplexNumber result = new ComplexNumber();
        try {
            num1 = new ComplexNumber();
            result = num1.div(num2);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println(result);

        System.out.println(num1.mag());
        System.out.println(num1.conj());
        System.out.println(num1.sqrt());
        System.out.println(num1.equals(num2));

        num2.setReal(1);
        num2.setImag(2);
        System.out.println(num1.equals(num2));

        System.out.println(num1.getReal() + " " + num1.getImag());



    }


}
