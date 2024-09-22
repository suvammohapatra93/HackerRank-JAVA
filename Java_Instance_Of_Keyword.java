
// HACKERRANK:JAVA INSTANCE OF KEYWORD :-

import java.util.*;

class Student {
}

class Rockstar {
}

class Hacker {
}

public class Java_Instance_Of_Keyword {

   static String count(ArrayList<Object> mylist) { // Specify ArrayList with Object type
      int a = 0, b = 0, c = 0;
      for (int i = 0; i < mylist.size(); i++) {
         Object element = mylist.get(i);
         if (element instanceof Student)
            a++;
         if (element instanceof Rockstar)
            b++;
         if (element instanceof Hacker)
            c++;
      }
      return a + " " + b + " " + c;
   }

   public static void main(String[] args) {
      ArrayList<Object> mylist = new ArrayList<>(); // Use ArrayList<Object>
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      for (int i = 0; i < t; i++) {
         String s = sc.next();
         if (s.equals("Student"))
            mylist.add(new Student());
         if (s.equals("Rockstar"))
            mylist.add(new Rockstar());
         if (s.equals("Hacker"))
            mylist.add(new Hacker());
      }
      System.out.println(count(mylist));
   }
}

// ! Time Complexity = O(t+n)
// ! Space Complexity = O(n)
