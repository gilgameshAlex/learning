package Task_01;

public class Student extends Human{
    private String groupName;

    public Student() {
        this.groupName = "";
    }
    public Student(String name, String groupName) {
        super(name);
        this.groupName = groupName;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Этот студент с именем %s\n", this.name);
    }
}
