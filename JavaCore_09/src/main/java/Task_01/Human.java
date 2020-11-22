package Task_01;

public class Human {
    protected String name;
    public Human() {
        name = "";
    }
    public Human(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void printInfo() {
        System.out.printf("Этот человек с именем %s\n", this.name);
    }
}
