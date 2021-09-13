/**
 * Ariana Tran
 * CPSC 340
 * I pledge
 */

import java.util.Stack;
import java.util.Scanner;

/**
 * This class represents the main that will run the program.
 * The program checks if the user input of brackets and parentheses are well-formed
 */
public class Lab5Main {
    /**
     * This method check if the user input only contains brackets or parentheses
     * @param s a String that represents part of the user input
     * @return a String if part of the user input is valid
     * @throws Exception if the input is not either a bracket or parenthesis
     */
    public static String checkBrackPar(String s) throws Exception{
        //check if it is a parentheses or brackets
        if(s.equals("(") || s.equals(")") || s.equals("[") || s.equals("]")) {
            return s;
        }

        //if not either parentheses or brackets, throw an exception
        else {
            throw new Exception("Invalid");
        }
    }

    /**
     * This method represents the main
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String input;
        //read in one String from the user
        input = scnr.nextLine();
        //Loop through the characters of the String
        //declare stack
        Stack stack = new Stack();
        String curr;
        int top;
        for(int i = 0; i < input.length(); i++) {
            try {
                //call method to check if part of the input is a parenthesis or bracket, if not throw an exception
                curr = checkBrackPar(input.substring(i, i + 1));
                //if it is the opening, push it to stack
                if(curr.equals("(") || curr.equals("[")) {
                    stack.push(curr);
                }

                //if ending, check if opening is there, if not just push
                //for case of closing parentheses
                else if(curr.equals(")")) {
                    //check if top of stack has opening parentheses, if there is pop it off
                    top = stack.search("(");
                    if(top == 1) {
                        stack.pop();
                    }

                    //if not opening parentheses, then just add to the stack
                    else {
                        stack.push(curr);
                    }
                }

                //for case of closing brackets
                else if(curr.equals("]")) {
                    //check if top of stack has opening brackets, if there is pop it off
                    top = stack.search("[");
                    if(top == 1) {
                        stack.pop();
                    }

                    //if not opening parentheses, then just add to the stack
                    else {
                        stack.push(curr);
                    }
                }
            }

            //exception is caught here and terminates the whole program
            catch(Exception e) {
                System.out.println("Input is invalid, input must contain only brackets and/or parentheses.");
                System.exit(0);
            }
        }

        //call the method to print out whether the input is well-formatted
        printResults(stack, input);
    }

    /**
     * This method prints out whether the string of input is well-formatted
     * @param stack a Stack object generated from the user input
     * @param input a String that represents the user's input
     */
    public static void printResults(Stack stack, String input) {
        //stack is well-formed if stack is empty
        if(stack.empty()) {
            System.out.println(input + " is well-formed.");
        }

        //if the stack is not empty, then it is not well formed
        else {
            System.out.println(input + " is NOT well-formed.");
        }
    }
}