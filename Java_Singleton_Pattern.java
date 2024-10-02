
//HACKERRANK -> JAVA SINGLETON PATTERN

public class Java_Singleton_Pattern {
    // Private static variable to hold the single instance of the class
    private static Java_Singleton_Pattern instance;

    // Public String variable
    public String str;

    // Private constructor to prevent instantiation from outside the class
    private Java_Singleton_Pattern() {
    }

    // Static method to provide access to the single instance
    public static Java_Singleton_Pattern getSingleInstance() {
        if (instance == null) {
            instance = new Java_Singleton_Pattern();
        }
        return instance;
    }

    public static void main(String[] args) {
        // Accessing the Java_Singleton_Pattern instance
        Java_Singleton_Pattern singletonInstance = Java_Singleton_Pattern.getSingleInstance();

        // Setting and using the `str` variable
        singletonInstance.str = "Hello, I am a Java_Singleton_Pattern! Let me say hello world to you.";
        System.out.println(singletonInstance.str);

        // Demonstrate that only one instance is used
        Java_Singleton_Pattern anotherInstance = Java_Singleton_Pattern.getSingleInstance();
        System.out.println(anotherInstance.str);
        /*
         * Output ->
         * Hello, I am a Java_Singleton_Pattern! Let me say hello world to you.
         * Hello, I am a Java_Singleton_Pattern! Let me say hello world to you.
         */
    }
}
