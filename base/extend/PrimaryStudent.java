package extend;

public class PrimaryStudent extends Student {
    public int grade = 1;

    public PrimaryStudent(String name, int age) {
        super(name, age, 0);
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
