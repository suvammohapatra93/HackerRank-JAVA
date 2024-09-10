
import java.util.*;

public class Java_HashSet {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        HashSet<String> uniquePairs = new HashSet<>();

        for (int i = 0; i < t; i++) {
            // Form a pair as a string and add it to the HashSet
            String pair = pair_left[i] + "," + pair_right[i];
            uniquePairs.add(pair);

            // The size of the set gives the number of unique pairs so far
            System.out.println(uniquePairs.size());
        }
        s.close();
    }
}

// Time Complexity = O(t)
// Space Complexity = O(t)
