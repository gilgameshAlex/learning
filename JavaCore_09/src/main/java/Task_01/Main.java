package Task_01;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Петька", "ПМИК");
        student.printInfo();
        Teacher teacher = new Teacher("Георгий", "Математика");
        teacher.printInfo();
    }
}
