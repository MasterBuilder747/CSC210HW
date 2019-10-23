//Homework 4: Random Number Generator Part1
//Author: Joseph Audras
//Professor: Dr. Reinhart
//Date due: 10-10-19
//Class: CSC210-1

package HW4RNG;

import java.util.Random;
import java.util.Scanner;

public class HW4RandomNumberGenerator1 {

    public static void main(String[] args) {

        //create objects, setup
        Random rn = new Random();
        Scanner kb = new Scanner(System.in);

        System.out.println("===Dice Simulator===");

        //decide which system to use
        System.out.println(" ");
        System.out.println("Choose: counting(0), statistics(1)");
        try {

            int choice = kb.nextInt();

            if (choice == 0) {

                //counting
                System.out.println("=Counting=");
                int value, N;
                int x1 = 0;
                int x2 = 0;
                int x3 = 0;
                int x4 = 0;
                int x5 = 0;
                int x6 = 0;

                try {
                    System.out.println("Enter a value for N rolls: ");

                    for (N = kb.nextInt(); N > 0; N--) {
                        //use any seed when counting
                        value = 1 + rn.nextInt(6);

                        //counting vars
                        switch (value) {
                            case 1:
                                x1++;
                                break;
                            case 2:
                                x2++;
                                break;
                            case 3:
                                x3++;
                                break;
                            case 4:
                                x4++;
                                break;
                            case 5:
                                x5++;
                                break;
                            case 6:
                                x6++;
                                break;
                        }
                    }
                    System.out.println("number of 1's: " + x1);
                    System.out.println("number of 2's: " + x2);
                    System.out.println("number of 3's: " + x3);
                    System.out.println("number of 4's: " + x4);
                    System.out.println("number of 5's: " + x5);
                    System.out.println("number of 6's: " + x6);

                } catch (Exception e) {
                    System.out.println("Input is too large or invalid.");
                }

            } else if (choice == 1) {

                //statistics
                System.out.println("=Statistics=");
                int N, value, total = 0;

                try {
                    //sd = sqrt( sum( abs(xi - mean)) ^ 2)/ (N - 1))
                    //mean calculation
                    System.out.println("Enter a number for N rolls: ");
                    int input = kb.nextInt();
                    //allocate array of input size + 1 since it starts at 0
                    int[] sda = new int[(input+1)];

                    for (N = input; N > 0; N--) {
                        value = 1 + rn.nextInt(6);
                        sda[N] = value;
                        total += value;
                    }

                    //since the seed is the same, the same string of numbers will occur
                    //this works for the standard deviation
                    double mean = ((double)total / (double)input);
                    double sdSum = 0.0;
                    for (N = input; N > 0; N--) {
                        sdSum =+ Math.pow((sda[N] - mean), 2);
                    }
                    double sd = Math.sqrt((sdSum / input));
                    System.out.println("The standard deviation of these numbers is: " + sd);

                }catch (Exception e) {
                    System.out.println("Input is too large or invalid.");
                }

            } else {
                System.out.println("Invalid number. Exiting!");
            }

        } catch (Exception e) {
            System.out.println("Invalid number.");
        }

    }

}
