
// HACKERRANK:COVARIANT RETURN TYPES:

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Base class Flower with method to return flower name
class Flower {
    String whatsYourName() {
        return "I have no name";
    }
}

// Subclasses of Flower: Jasmine and Lily
class Jasmine extends Flower {
    @Override
    String whatsYourName() {
        return "Jasmine";
    }
}

class Lily extends Flower {
    @Override
    String whatsYourName() {
        return "Lily";
    }
}

// Base class Region with method to return a Flower
class Region {
    Flower yourNationalFlower() {
        return new Flower();
    }
}

// Subclasses of Region: WestBengal and AndhraPradesh with covariant return type
class WestBengal extends Region {
    @Override
    Jasmine yourNationalFlower() {
        return new Jasmine();
    }
}

class AndhraPradesh extends Region {
    @Override
    Lily yourNationalFlower() {
        return new Lily();
    }
}

public class Covariant_Return_Types {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();
        Region region = null;

        // Determine the region based on input
        switch (s) {
            case "WestBengal":
                region = new WestBengal();
                break;
            case "AndhraPradesh":
                region = new AndhraPradesh();
                break;
        }

        // Get the flower and print its name
        if (region != null) {
            Flower flower = region.yourNationalFlower();
            System.out.println(flower.whatsYourName());
        }
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)