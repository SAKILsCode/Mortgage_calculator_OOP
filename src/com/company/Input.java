package com.company;

import java.util.Scanner;

public class Input {
    public static Scanner input = new Scanner(System.in);
    public static double getInput(String prompt){
        return input.nextDouble();
    }
    public static double getInput(String prompt, double min, double max){
        double value;
        while (true) {
            System.out.print(prompt);
            value = input.nextDouble();
            if(value >= min && value <= max)
                break;
            System.out.println("Please enter a number between " + min + "    and " + max + ".");
        };
        return value;
    }
}
