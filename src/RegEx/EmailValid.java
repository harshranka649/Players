package RegEx;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailValid {

    // Regular expression pattern for validating an email address
    private static final String EMAIL_PATTERN = 
            "^[a-zA-Z0-9_+&*-]+(?:[a-zA-Z0-9_+&*-]*[a-zA-Z0-9])?@([a-zA-Z]+\\.)+(?:com|in|org)$";


    public static void main(String[] args) {
        // Create a scanner object to accept input from the user
        Scanner inputScanner = new Scanner(System.in);

        // Prompt the user to enter an email address
        System.out.println("Please enter an email address to validate:");

        // Read the entered email address
        String userInputEmail = inputScanner.nextLine();

        // Compile the regex pattern
        Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);

        // Create a matcher object to check the input against the pattern
        Matcher emailMatcher = emailPattern.matcher(userInputEmail);

        // Validate the email address using regex
        if (emailMatcher.matches()) {
            System.out.println(userInputEmail + " is a valid email address.");
        } else {
            System.out.println(userInputEmail + " is not a valid email address.");
        }

        // Close the scanner after use to prevent memory leaks
        inputScanner.close();
    }
}
