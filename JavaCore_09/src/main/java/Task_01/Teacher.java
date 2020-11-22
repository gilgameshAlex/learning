package Task_01;

public class Teacher extends Human {
    private String subjectName;

    public Teacher() {
        this.subjectName = "";
    }

    public Teacher(String name, String subjectName) {
        super(name);
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Этот преподаватель с именем %s\n", this.name);
    }
}
