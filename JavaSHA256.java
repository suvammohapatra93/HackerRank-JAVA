
//HACKERRANK -> JAVA SHA 256 ->

import java.io.*;
import java.security.*; // Import the security package for MessageDigest

public class JavaSHA256 {
    public static void main(String[] args) throws Exception {
        // Read input string from standard input (stdin)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // Create a MessageDigest instance for SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Compute the hash and get it as a byte array
        byte[] hashBytes = md.digest(input.getBytes());

        // Convert the byte array into a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b)); // Format each byte as a two-digit hex value
        }

        System.out.println(hexString.toString());
    }
}

// ! Time Complexity == O(n)
// ! Space Complexity == O(1)