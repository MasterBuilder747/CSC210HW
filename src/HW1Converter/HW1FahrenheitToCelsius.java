//Homework 1: Temperature converter
//Author: Joseph Audras
//Professor: Dr. Reinhart
//Date due: 9-17-19
//Class: CSC210-1

package HW1Converter;

import java.util.Scanner;

public class HW1FahrenheitToCelsius {

    public static void main(String[] args) {

        //prompt the user for an input
        System.out.println("=Fahrenheit to Celsius Converter=");
        System.out.print("Enter a value in Celsius: ");

        //input
        Scanner reader = new Scanner (System.in);
        double input = reader.nextDouble();

        //process the input
        //formula for °F to °C: (°F − 32) * (5 / 9) = °C
        double output = (input - 32) * (5.0 / 9);

        //output the result
        System.out.println(input + " degrees Fahrenheit is " + output + " degrees Celsius.");

    }

}
