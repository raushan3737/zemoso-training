/*
Data Encryption System: Rahul wants to send encoded messages to his friend Ram.
Develop an algorithm to encode all the digits, special characters, lower and upper case alphabets.
*/

/* 
Approach: 

    1. First taking input string from the user
    2. Calling the encodeMessage method to encode the string
    3. In encodeMessage method: 
        1. initialize a StringBuilder to store the encoded message.
        2.We iterate over each character do the following : 
            If char is alphabetical then, i store in a new string  like: 'a' -> 'z' , 'b' -> 'y' , 'c' -> 'x' for lowercase & 
            for uppercase we do the same i.e. 'A' -> 'Z' , 'B' -> 'Y'  so on.

            If char is digit then, adding digit%2, (digit%2) times in the string 
            If char is special then, first we shift this char by (ascii of char / 33) & then, store in the string i.e. in encodeMessage. 
        
        3. At last, we reverse the encodeMessage StringBuilder to add more complexity in it. 
        4. Return the reverse encodeMessage.

    4. Print the encoded StringBuilder in the main method. 
     
*/

import java.util.Scanner;

public class DataEncryptionSystem {

    // Utility Method Start

    // Method to check char Uppercase or not
    public static Boolean checkUpperCase(char ch) {
        if (ch >= 'A' && ch <= 'Z')
            return true;
        else
            return false;
    }

    // Method to check char Lowercase or not
    public static Boolean checkLowerCase(char ch) {
        if (ch >= 'a' && ch <= 'z')
            return true;
        else
            return false;
    }
    // Utility Method End

    // Method to encode the data

    /*
     * Complexity: Time Complexity: O(N) (Where, N is the length of the input
     * string/message)
     * Space Complexity: O(1) (By just changing the type String to StringBuilder )
     * 
     * 
     */
    public static StringBuilder encodeMessage(StringBuilder message) {
        // To store the encoded message
        StringBuilder encMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            // Check for uppercase
            char ch = message.charAt(i);
            if (checkUpperCase(ch)) {
                encMessage.append(((char) ('A' + (25 - (ch - 'A')))));
            }
            // Check for lowercase
            else if (checkLowerCase(ch)) {
                encMessage.append(((char) ('a' + (25 - (ch - 'a')))));
            } else if (Character.isDigit(ch)) {
                // Converting character to its integer value
                int digit = ch - '0';
                for (int j = 0; j < (digit % 2); j++)
                    encMessage.append(((char) digit % 2));
            }
            // For special character
            else {
                int digit = ch - '0';
                // Shifting the special char by (digit/33)
                char newChar = (char) (ch + (digit / 33)); // Dividing by 33 because, no of special char is 33.
                encMessage.append(newChar);
            }
        }

        // Reversing the encMessage for adding more complexity to guess
        encMessage.reverse();

        return encMessage;
    }

    public static void main(String[] args) {
        // Your code goes here
        System.out.println("<====Welcome to the Message Encode System ====>");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your message to encode: ");
        // Taking data input from the user
        String message = sc.nextLine();
        StringBuilder userMessage = new StringBuilder(message);

        // Invoking the encodeMessage method to encode the message/data
        StringBuilder encodeMsg = encodeMessage(userMessage);
        System.out.println("Encoded message: " + encodeMsg);

    }
}