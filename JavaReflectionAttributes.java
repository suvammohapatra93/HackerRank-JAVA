
//HackerRank -> Java Reflection Attributes ->+


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class JavaReflectionAttributes {

    public static void main(String[] args) {
        // Correctly referencing the Student class using Student.class
        Class student = Student.class;
        
        // Retrieve all declared methods from the Student class
        Method[] methods = student.getDeclaredMethods();

        // Create a list to store the method names
        ArrayList<String> methodList = new ArrayList<>();
        
        // Add each method's name to the list
        for (Method method : methods) {
            methodList.add(method.getName());
        }
        
        // Sort the method names alphabetically
        Collections.sort(methodList);
        
        // Print each sorted method name
        for (String name : methodList) {
            System.out.println(name);
        }
    }
}
