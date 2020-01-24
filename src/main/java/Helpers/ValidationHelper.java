package Helpers;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class ValidationHelper {

    public static void validateEmails(String email) {

        boolean isEmailTrue = ValidationHelper.isValidEmailAddress(email);

        if (isEmailTrue == false) {
            System.err.println("Email " + email + " is in wrong format.");

        } else {
            System.out.println("Email " + email + " is in correct format.");
        }
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}



