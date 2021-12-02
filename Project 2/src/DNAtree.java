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
                    //System.out.println("Not to remove. Bye bitch!");
                    DNA.remove(input[1]);
                }

                //if search
                else if(input[0].equals("search")) {
                    if(input[1].contains("$")) {
                        DNA.searchExact(input[1].substring(0, input[1].length() - 1));
                    }
                    else {
                        DNA.search(input[1]);
                    }

                }

                //if print
                else if(input[0].equals("print")) {
                    if(input.length == 1) {
                        DNA.print("regular");
                    }
                    else if(input[1].equals("lengths")) {
                        DNA.print("lengths");
                    }

                    //if print stats
                    else if(input[1].equals("stats")) {
                        DNA.print("stats");
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
        //get rid of the tabs
        line = line.replaceAll("\t", " ");
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
            input[i] = split[i].trim();
        }
        return input;
    }
}
