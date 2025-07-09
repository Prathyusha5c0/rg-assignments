public class SingletonExample {

    // Step 1: Create a private static instance of the class
    private static SingletonExample instance;

    // Step 2: Make the constructor private so that no other class can instantiate it
    private SingletonExample() {
        System.out.println("Singleton Instance Created");
    }

    // Step 3: Provide a public static method to get the instance
    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

    public static void main(String[] args) {
        SingletonExample obj1 = SingletonExample.getInstance();
        SingletonExample obj2 = SingletonExample.getInstance();

        obj1.showMessage();

        if (obj1 == obj2) {
            System.out.println("Both obj1 and obj2 refer to the same instance.");
        } else {
            System.out.println("Different instances.");
        }
    }
}
