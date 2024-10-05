
//HACKERRAN -> JAVA MD 5


import java.io.*;
import java.security.*;

public class JavaMD5 {
    public static void main(String[] args) {
        try {
            // Read input string from STDIN
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();

            // Create a MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Calculate the MD5 hash
            byte[] hashBytes = md.digest(input.getBytes());

            // Convert hash bytes to hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            // Print the resulting MD5 hash
            System.out.println(hexString.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)