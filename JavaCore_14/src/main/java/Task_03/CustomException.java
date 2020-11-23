package Task_03;

public class CustomException extends Exception{
    public CustomException() {
    }

    public CustomException(String message) {
        System.out.println(message);
    }
}
