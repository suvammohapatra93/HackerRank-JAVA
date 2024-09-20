
// HACKERRANK:JAVA EXCEPTION HANDLING:


import java.util.*;
public class Java_Exception_Handling{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(x / y);
        } catch (ArithmeticException e) {
            System.out.println("java.lang.ArithmeticException: / by zero");
        } catch (InputMismatchException e) {
            System.out.println("java.util.InputMismatchException");
        }

        sc.close();
    }
}

//! Time Complexity = O(1)
//! Space Complexity = O(1)