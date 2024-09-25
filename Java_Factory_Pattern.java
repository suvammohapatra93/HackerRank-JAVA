
// HackerRank: Java Factory Pattern:

import java.util.*;
import java.security.*;

interface Food {
    public String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String order) {
        // Factory logic to return the correct food object
        if (order.equalsIgnoreCase("pizza")) {
            return new Pizza();
        } else if (order.equalsIgnoreCase("cake")) {
            return new Cake();
        }
        return null; // In case of invalid order
    } // End of getFood method
} // End of factory class

public class Java_Factory_Pattern {
    public static void main(String args[]) {
        Do_Not_Terminate.forbidExit(); // To prevent system exit

        try {
            Scanner sc = new Scanner(System.in);
            // Creating the factory
            FoodFactory foodFactory = new FoodFactory();

            // Factory instantiates an object
            Food food = foodFactory.getFood(sc.nextLine());

            // Output the class of the object returned and the type of food
            System.out.println("The factory returned " + food.getClass().getName());
            System.out.println(food.getType());
            sc.close();
        } catch (Do_Not_Terminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }
}

@SuppressWarnings("removal")
class Do_Not_Terminate {

    public static class ExitTrappedException extends SecurityException {
        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}
