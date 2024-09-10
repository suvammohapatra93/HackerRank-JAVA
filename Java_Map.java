
import java.util.*;

public class Java_Map {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);

        // Create a HashMap to store name and phone number pairs
        Map<String, Integer> phoneBook = new HashMap<>();

        int n = in.nextInt(); // Read the number of entries
        in.nextLine(); // Consume the newline character

        // Input the names and phone numbers
        for (int i = 0; i < n; i++) {
            String name = in.nextLine(); // Read the name
            int phone = in.nextInt(); // Read the phone number
            in.nextLine(); // Consume the newline character

            // Store the name and phone number in the map
            phoneBook.put(name, phone);
        }

        // Process the queries
        while (in.hasNext()) {
            String s = in.nextLine(); // Read the query (name)

            // Check if the name exists in the phonebook
            if (phoneBook.containsKey(s)) {
                System.out.println(s + "=" + phoneBook.get(s)); // Output name=phoneNumber
            } else {
                System.out.println("Not found"); // Output if the name doesn't exist
            }
        }

        in.close(); // Close the scanner
    }
}
