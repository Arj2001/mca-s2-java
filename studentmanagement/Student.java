package studentmanagement;

public class Student {
    String name;
    int rollNumber;
    String grade;
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "{ name = " + name + ", rollNumber = " + rollNumber + ", grade = " + grade + " }";
    }
    
}
