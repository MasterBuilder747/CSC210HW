//Homework 1: Temperature converter
//Author: Joseph Audras
//Professor: Dr. Reinhart
//Date due: 9-17-19
//Class: CSC210-1

package HW1Converter;

import java.util.Scanner;

public class HW1CelsiusToFahrenheit {

    public static void main(String[] args) {

        //prompt the user for an input
        System.out.println("=Celsius to Fahrenheit Converter=");
        System.out.print("Enter a value in Celsius: ");

        //input
        Scanner reader = new Scanner (System.in);
        double input = reader.nextDouble();

        //process the input
        //formula for °C to °F: (°C * 9/5) + 32 = °F
        double output = (input * (9.0 / 5)) + 32;

        //output the result
        System.out.println(input + " degrees Celsius is " + output + " degrees Fahrenheit.");
    }

}
