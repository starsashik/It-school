package com.company;

import java.util.Scanner;

public class Conditionals {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String st = in.nextLine();
        int c = -1;
        String[] array = st.split(",");
        String first = Character.toString(array[0].charAt(0));
        if (first.equals("I")){
            if (array[0].contains("had") || array[0].contains("'d") || array[1].contains("would")) {
                if (array[1].contains("would have")) {
                    c = 3;
                } else if (!(array[1].contains("would have")) && (array[1].contains("would") || array[1].contains("'d"))) {
                    c = 2;
                }
                printConditional(c);
            }
            else if (array[1].contains("will") || array[1].contains("'ll"))
                c = 1;
            else
                c = 0;
            printConditional(c);
        } else if (first.equals("H")) {
            c = 4;
            printConditional(c);
        }
        }

    public static void printConditional(int g) {
        if (g < 0) {
            System.out.println("It is impossible to determine!");
            System.exit(0);
        }
        String[] array = {"0", "I", "II", "III", "inverted"};
        System.out.println("Conditional type: " + "" + array[g]);
    }
}