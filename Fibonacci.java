import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
* This program calculates the number chosen from input.txt
* in the fibonacci sequence.
*
* @author  Navin Balekomebole.
* @version 1.0
* @since   2023-04-19
*/

public final class Fibonacci {
    /**
    * For style checkers.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private Factorial() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print the messages messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) {
        // In this section, the program will declare a lists.
        final ArrayList<String> inputList = new ArrayList<String>();

        try {
            // Program will select a file to collect input from.
            final File input = new File("Input.txt");
            final Scanner scanInput = new Scanner(input);

            // Choose/create a file to which to save the output.
            final FileWriter output = new FileWriter("output.txt");

            // Here, a loop is used to read each line of input file.
            while (scanInput.hasNextLine()) {
                inputList.add(scanInput.nextLine());
            }

            // Create an array with all elements in the input list.
            final String[] inputArr = new String[inputList.size()];
            for (int location = 0; location < inputArr.length; location++) {
                inputArr[location] = inputList.get(location);
            }

            // Loop to send each line to function.
            for (String numStr : inputArr) {
                try {
                    // In this section of the program, function will be called.
                    final int calculatedNumber =
                        fibonacci(Integer.parseInt(numStr));

                    // Print to console and file.
                    System.out.println(calculatedNumber);
                    output.write(calculatedNumber + "\n");
                } catch (NumberFormatException err) {
                    System.out.println("Error, not a viable input.");
                }
            }

            // Close writer.
            output.close();

        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * This function helps wil the javadoc comment errors.
    *
    * @param num from file
    * @return fibonacci sequence
    */
    public static int fibonacci(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }

}
