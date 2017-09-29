package com.company;
import jdk.nashorn.api.tree.WhileLoopTree;
import java.util.Random;
import java.util.Scanner;


public class Main {

    //Here is the main function
    public static void main(String[] args) {
        /*
        echo(args);
        recho(args);*/
        DicotomicResearch(args);
    }

    //Here is the echo function
    public static void echo(String[] args) {
        int l = args.length; // the length of the arguments

        System.out.print(args[0]); // we print here the first argument the we iterate to print the rest
                                   //of the arguments with a unique space between them
        for (int i = 1; i < l; ++i) {
            System.out.print(" " + args[i]);
        }

        System.out.println("");
    }

    //Here is the recho function
    public static void recho(String[] args) {
        int l = args.length; // the length of the arguments

        System.out.print(args[l-1]); // print the last argument and iterate to print the rest of the arguments
        //with a unique space between them
        for (int i = l - 2; i >= 0; --i) {
            System.out.print(" " + args[i]);
        }

        System.out.println("");

    }

    //Here is the DicotomicResearch function
    public static void DicotomicResearch(String[] args){

        //Generate a random integer between 1 and 100
        Random rand = new Random();
        int a = 100; // a is the maximum value the random generated integer could take
        int b = 1;  // b is the minimum value the random generated integer  could take
        int  n = b + rand.nextInt(a); // secret generated integer

        //Use Scanner to ask me to enter a number
        Scanner numberInput = new Scanner (System.in );
        System.out.println("Please enter a number between 1 and 100 : ");

        //Check if the scanner's next token is an int
       while(!numberInput.hasNextInt()){
            System.out.println("Your input does not match the criteria, please enter a number between 1 and 100");
            numberInput.next();
        }

        int testNumber = numberInput.nextInt(); //Take the scanner as an int
        //Do a loop trying to find the secret number while this latter is different from the scanner
        while(testNumber != n){
            if(testNumber > n){
                System.out.println("Your number is bigger than the secret number ! try a smaller number !");
                // Don't forget to check if the scanner's next token is an int
                while(!numberInput.hasNextInt()){
                    System.out.println("Your input does not match the criteria, please enter a number between 1 and 100");
                    numberInput.next();
                }
                //Update the scanner
                testNumber = numberInput.nextInt();
            }
            else if (testNumber < n){
                System.out.println("Your number is smaller than the secret number ! try a bigger number !");
                // Don't forget to check if the scanner's next token is an int
                while(!numberInput.hasNextInt()){
                    System.out.println("Your input does not match the criteria, please enter a number between 1 and 100");
                    numberInput.next();
                }
                // Update the scanner
                testNumber = numberInput.nextInt();
            }
        }

        //We print a congratulation message if the user find the secret number
        System.out.println("congratulations !! The secret number is exactly : " + Integer.toString(n));
    }
}