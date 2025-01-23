package RegEx;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPValidatior {

    // Regular expression pattern for validating IPv4
    private static final String IPV4_PATTERN = 
            "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    public static void main(String[] args) {
        // Create a scanner object to accept input from the user
        Scanner inputScanner = new Scanner(System.in);

        // Prompt the user to enter an IP address
        System.out.println("Please enter an IP address to validate:");

        // Read the entered IP address
        String userInputIP = inputScanner.nextLine();

        // Compile the regex pattern
        Pattern ipPattern = Pattern.compile(IPV4_PATTERN);

        // Create a matcher object to check the input against the pattern
        Matcher ipMatcher = ipPattern.matcher(userInputIP);

        // Validate the IP address using regex
        if (ipMatcher.matches()) {
            System.out.println(userInputIP + " is a valid IP address.");
        } else {
            System.out.println(userInputIP + " is not a valid IP address.");
        }

        // Close the scanner after use to prevent memory leaks
        inputScanner.close();
    }
}
