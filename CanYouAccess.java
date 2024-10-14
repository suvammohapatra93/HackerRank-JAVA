
//HACKERRANK -> CAN YOU ACCESS ->

import java.util.*;

public class CanYouAccess {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Inner inner = new Inner();

        // Access the Private inner class using the instance of Inner
        Inner.Private obj = inner.new Private();

        // Call the method to check if num is a power of 2
        System.out.println(num + " is " + obj.powerof2(num));

        System.out.println("An instance of class: " + obj.getClass().getCanonicalName() + " has been created");

        sc.close();
    }

    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & (num - 1)) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }
}

// ! Time Complexity = O(1)
// ! Space Complexity = O(1)