package Task_03;

import java.util.Random;

public class Teacher extends Person {
    private String subject;

    public Teacher () {
        this.subject = "";
    }
    public Teacher (String firstName, String subject) {
        this.firstName = firstName;
        this.subject = subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
    public void evaluate(Student student)
    {
        Random random = new Random();
        int randVal = random.nextInt(3) + 2;
        System.out.println("Преподаватель " + this.firstName + " оценил студента с именем " + student.getFirstName() +
                " по предмету " + this.subject + " на оценку " + new Estimations(randVal).getEstimationText() + ".");
    }
}

class Estimations {
    private int estimationCode;
    private String estimationText;
    public Estimations (int code) {
        switch (code) {
            case 2:
                this.estimationText = "плохо";
                break;
            case 3:
                this.estimationText = "удовлетворительно";
                break;
            case 4:
                this.estimationText = "хорошо";
                break;
            case 5:
                this.estimationText = "отлично";
                break;
        }
        this.estimationCode = code;
    }
    public String getEstimationText() {
        return this.estimationText;
    }
}