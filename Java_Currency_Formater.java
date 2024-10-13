
//HACKERRANK:JAVA CURRENCY FORMATTER:

import java.util.*;
import java.text.*;
import java.util.Locale;

public class Java_Currency_Formater {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Formatting for US
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        String us = usFormat.format(payment);

        // Formatting for India (India uses the en_IN locale which isn't directly
        // available in Java 8, so we create it)
        Locale indiaLocale = new Locale("en", "IN");
        NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(indiaLocale);
        String india = indiaFormat.format(payment);

        // Formatting for China
        NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = chinaFormat.format(payment);

        // Formatting for France
        NumberFormat franceFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = franceFormat.format(payment);

        // Output the formatted currencies
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}

// ! Time Complexity = O(1)
// ! Space Complexity = O(1)