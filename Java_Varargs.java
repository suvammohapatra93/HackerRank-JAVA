
// HackerRank:JAVA VARARGS:

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

class Add {

    public void add(int... numbers) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for (int num : numbers) {
            sum += num;
            sb.append(num).append("+"); // Append the number and a plus sign
        }

        sb.deleteCharAt(sb.length() - 1); // Remove the last '+' sign
        sb.append("=").append(sum); // Append the result

        System.out.println(sb.toString());
    }
}

public class Java_Varargs {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            int n6 = Integer.parseInt(br.readLine());

            Add ob = new Add();
            ob.add(n1, n2);
            ob.add(n1, n2, n3);
            ob.add(n1, n2, n3, n4, n5);
            ob.add(n1, n2, n3, n4, n5, n6);

            Method[] methods = Add.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;

            for (Method method : methods) {
                if (set.contains(method.getName())) {
                    overload = true;
                    break;
                }
                set.add(method.getName());
            }

            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
