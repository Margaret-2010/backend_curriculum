public class ExceptionDemo {
    public static void main(String[] args){
        // Test 1: a valid age (no exception expected)
        try{
            checkAge(20);
            System.out.println("Age 20 is valid. ");
        } catch (InvalidAgeException e){
            System.out.println("Caught exception: " + e.getMessage());
        }

        //Test 2 : an invalid age (exception expected)
        try{
            checkAge(-5);
            System.out.println("Age -5 is valid. ");
        } catch (InvalidAgeException e){
            System.out.println("Caught exception: " + e.getMessage());
        }

        //Test 3: try with resources example
        try(AutoCloseableResource resource = new AutoCloseableResource()){
            resource.use();
        } catch(Exception e){
            System.out.println("Caught exception: " + e.getMessage());
        }
    }


    // Method that throws our custom checked exception when age is invalid
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age must be between 0 and 120, but got: " + age);
        }
    }
}

class AutoCloseableResource implements AutoCloseable {

    public void use() {
        System.out.println("Using the resource...");
    }

    @Override
    public void close() {
        System.out.println("Resource closed automatically.");
    }
}

