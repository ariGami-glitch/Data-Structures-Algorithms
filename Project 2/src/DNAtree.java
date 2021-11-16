/**
 * Ariana Tran
 * CPSC 340
 * 10/25/2021
 * I pledge
 */

import java.io.*;
import java.util.Scanner;

/**
 * This class represents the main of the program.
 * This program stores DNA sequences and delete them if prompted
 * by the input file. Recursion and a binary tree was used for
 * this project.
 */
public class DNAtree {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream(args[0]);
            Scanner scnr = new Scanner(file);
            Tree DNA = new Tree();

            while(scnr.hasNextLine()) {
                String[] input = getInput(scnr);
                //skip the lines that are null, so all the lines that are empty or have only spaces
                if(input == null) {
                    continue;
                }
                //checking for commands
                //if insert
                if(input[0].equals("insert")) {
                    String seq = input[1];
                    DNA.insert(seq);
                }

                //if remove
                else if(input[0].equals("remove")) {
                    System.out.println("Not to remove. Bye bitch!");
                }

                //if search
                else if(input[0].equals("search")) {
                    System.out.println("What are we searching for?");

                }

                //if print
                else if(input[0].equals("print")) {
                    if(input.length == 1) {
                        DNA.print();
                    }
                    //if print lengths
                    else if(input[1].equals("lengths")) {
                        System.out.println("Now we talking printing lengths");
                    }

                    //if print stats
                    else if(input[1].equals("stats")) {
                        System.out.println("I need print STATS!");
                    }

                }

            }
        }
        catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
    public static String[] getInput(Scanner scnr) {
        String line = scnr.nextLine();
        //if the line is empty return null
        if(line.isEmpty()) {
            return null;
        }
        //split the string
        String[] split = line.split(" ");
        //get rid of unnecessary empty element
        if(split.length == 0) {
            return null;
        }

        int size = split.length;
        //this gets rid of the empty elements after the spaces were removed
        for(int i = 0, j = 0; j < split.length; j++) {
            if (!split[j].isEmpty()) {
                split[i] = split[j];
                i++;
            } else {
                size -= 1;
            }
        }
        //copy over new array
        String[] input = new String[size];

        for(int i = 0; i < size; i++) {
            input[i] = split[i];
        }
        return input;
    }
}
