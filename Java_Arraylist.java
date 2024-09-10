

import java.util.*;
public class Java_Arraylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of lines
        int n = sc.nextInt();
        
        // Initialize the list to store the lines
        List<List<Integer>> list = new ArrayList<>();
        
        // Read each line
        for (int i = 0; i < n; i++) {
            // Read the number of elements in the current line
            int d = sc.nextInt();
            
            // Initialize the list for this line
            List<Integer> sublist = new ArrayList<>();
            
            // Read d elements and add them to the sublist
            for (int j = 0; j < d; j++) {
                sublist.add(sc.nextInt());
            }
            
            // Add the sublist to the main list
            list.add(sublist);
        }
        
        // Read the number of queries
        int q = sc.nextInt();
        
        // Process each query
        for (int i = 0; i < q; i++) {
            // Read x and y for the current query
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            // Check if the x-1 index is within bounds and if y-1 index is within the bounds of the sublist
            if (x <= list.size() && y <= list.get(x-1).size()) {
                // Print the y-th element in the x-th line
                System.out.println(list.get(x-1).get(y-1));
            } else {
                // Print "ERROR!" if the indices are out of bounds
                System.out.println("ERROR!");
            }
        }
        sc.close();
    }
}

// Time Complexity = O(n + q)
// Space Complexity = O(n)
