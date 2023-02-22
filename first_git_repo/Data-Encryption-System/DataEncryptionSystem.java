import java.util.Scanner;
public class DataEncryptionSystem{

    // Utility Method n Start

    // Method to check char Uppercase or not
    public static Boolean checkUpperCase(char ch)
	{
		 if (ch >= 'A' && ch <= 'Z')
			return true ; 
		else 
			return false; 
	} 

    // Method to check char Lowercase or not
	public static Boolean checkLowerCase(char ch)
	{
		 if (ch >= 'a' && ch <= 'z')
		 	return true; 
		else 
			return false ; 
	} 
    // Utility Method End

    // Method to encode the data
    public static StringBuilder encodeMessage(String message) {
        // To store the encoded message
        String encMessage = new String();

        for (int i = 0; i < message.length(); i++) {
            // Check for uppercase
            char ch = message.charAt(i);
            if (checkUpperCase(ch)) {
                encMessage += ((char) ('A' + (25 - (ch - 'A'))));
            }
            // Check for lowercase
            else if (checkLowerCase(ch)) {
                encMessage += ((char) ('a' + (25 - (ch - 'a'))));
            } else if (Character.isDigit(ch)) {
                // Converting character to its integer value
                int digit = ch - '0';
                for (int j = 0; j < (digit % 2); j++)
                    encMessage += ((char) digit % 2);
            }
            // For special character
            else {
                int digit = ch - '0';
                // Shifting the special char by (digit/33)
                char newChar = (char) (ch + (digit / 33)); // Dividing by 33 because, no of special char is 33.
                encMessage += newChar;
            }
        }
        // To store the reverse of encoded Message
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(encMessage);

        // Reversing the encMessage for adding more complexity to guess
        StringBuilder encMessageReverse = strBuilder.reverse();

        return encMessageReverse;
    }

    public static void main(String[] args) {
        // Your code goes here
        System.out.println("<====Welcome to the Message Encode System ====>");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your message to encode: ");
        // Taking data input from the user
        String message = sc.nextLine();

        // Invoking the encodeMessage method to encode the message/data
        StringBuilder encodeMsg= encodeMessage(message); 
		System.out.println("Encoded message: "+ encodeMsg);



    }
}