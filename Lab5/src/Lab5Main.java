/**
 * Ariana Tran
 * CPSC 340
 * I pledge
 */

import java.util.ArrayDeque;
import java.util.Stack;
import java.util.Scanner;

/**
 * This class represents the main that will run the program.
 */
public class Lab5Main {
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
