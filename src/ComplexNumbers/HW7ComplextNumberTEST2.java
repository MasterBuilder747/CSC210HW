package ComplexNumbers;

import java.util.Scanner;

public class HW7ComplextNumberTEST2 {

    //DO NOT TURN THIS FILE IN! IT IS ONLY FOR TESTING!!!
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

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

        System.out.println();
    }


}
