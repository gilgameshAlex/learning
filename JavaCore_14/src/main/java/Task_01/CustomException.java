package Task_01;

public class CustomException extends Exception{
    public CustomException(String message) {
        System.out.println(message);
    }
}
