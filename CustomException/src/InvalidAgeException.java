public class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message); // passes the message up to the built in Exception class
    }
}