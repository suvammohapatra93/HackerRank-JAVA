/*JAVA INHERITANCE || */




// Base class
class Arithmetic {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }
}

// Derived class
class Adder extends Arithmetic {
    // Inherits the add method from Arithmetic
}

public class Java_Inheritance_2{
    public static void main(String []args){
        // Create a new Adder object
        Adder a = new Adder();
        
        // Print the name of the superclass on a new line
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());	
        
        // Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
        System.out.print(a.add(10,32) + " " + a.add(10,3) + " " + a.add(10,10) + "\n");
     }
}