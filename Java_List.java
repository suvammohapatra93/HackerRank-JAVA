


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Java_List {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        
        // Read the initial number of elements in the list
        int n = sc.nextInt();
        
        // Initialize the list and populate it with elements
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        // Read the number of operations
        int q = sc.nextInt();
        
        // Loop through the operations
        for (int i = 0; i < q; i++) {
            String operation = sc.next();
            
            if (operation.equals("Insert")) {
                // Insert operation
                int index = sc.nextInt();
                int value = sc.nextInt();
                list.add(index, value);
            } else if (operation.equals("Delete")) {
                // Delete operation
                int index = sc.nextInt();
                list.remove(index);
            }
        }
        
        // Print the final state of the list
        for (int num : list) {
            System.out.print(num + " ");
        }
        
        // Close the scanner
        sc.close();
    }
}

// Time Complexity = O(q)
// Space Complexity = O(n)