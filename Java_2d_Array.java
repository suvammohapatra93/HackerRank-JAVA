/* JAVA 2D ARRAY ->
 * 
 */



import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Java_2d_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        // Initialize the maximum hourglass sum with the lowest possible value
        int maxHourglassSum = Integer.MIN_VALUE;

        // Iterate over possible hourglass centers in the 6x6 grid
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                // Calculate the sum of the current hourglass
                int currentHourglassSum = arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j) + arr.get(i - 1).get(j + 1)
                        + // top row
                        arr.get(i).get(j) + // middle element
                        arr.get(i + 1).get(j - 1) + arr.get(i + 1).get(j) + arr.get(i + 1).get(j + 1); // bottom row

                // Update the maximum hourglass sum if the current one is larger
                maxHourglassSum = Math.max(maxHourglassSum, currentHourglassSum);
            }
        }

        // Print the result
        System.out.println(maxHourglassSum);
    }
}

// Time Complexity = O(1)
// Space Complexity = O(1)