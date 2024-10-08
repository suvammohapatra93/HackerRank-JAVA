
import java.io.*;
import java.util.*;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
 public static boolean checker(PerformOperation p, int num) {
  return p.check(num);
 }

   public PerformOperation isOdd() {
        return new PerformOperation() {
            @Override
            public boolean check(int a) {
                return a % 2 != 0; // True if the number is odd
            }
        };
    }

    // Method to check if a number is prime
    public PerformOperation isPrime() {
        return new PerformOperation() {
            @Override
            public boolean check(int a) {
                if (a <= 1) return false;
                for (int i = 2; i <= Math.sqrt(a); i++) {
                    if (a % i == 0) return false; // Not prime if divisible by i
                }
                return true;
            }
        };
    }

    // Method to check if a number is a palindrome
    public PerformOperation isPalindrome() {
        return new PerformOperation() {
            @Override
            public boolean check(int a) {
                String str = Integer.toString(a); // Convert number to string
                int len = str.length();
                for (int i = 0; i < len / 2; i++) {
                    if (str.charAt(i) != str.charAt(len - i - 1)) {
                        return false; // Not palindrome if mismatch
                    }
                }
                return true;
            }
        };
    }
}

public class Java_Lambda_Expression{
 public static void main(String[] args) throws IOException {
  MyMath ob = new MyMath();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int T = Integer.parseInt(br.readLine());
  PerformOperation op;
  boolean ret = false;
  String ans = null;
  while (T--> 0) {
   String s = br.readLine().trim();
   StringTokenizer st = new StringTokenizer(s);
   int ch = Integer.parseInt(st.nextToken());
   int num = Integer.parseInt(st.nextToken());
   if (ch == 1) {
    op = ob.isOdd();
    ret = ob.checker(op, num);
    ans = (ret) ? "ODD" : "EVEN";
   } else if (ch == 2) {
    op = ob.isPrime();
    ret = ob.checker(op, num);
    ans = (ret) ? "PRIME" : "COMPOSITE";
   } else if (ch == 3) {
    op = ob.isPalindrome();
    ret = ob.checker(op, num);
    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

   }
   System.out.println(ans);
  }
 }
}
