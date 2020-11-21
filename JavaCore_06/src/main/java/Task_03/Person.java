package Task_03;

public abstract class Person {
    protected String firstName;

    public Person() {
        firstName = "";
    }
    public Person (String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
