package main;

import studentmanagement.Student;
import studentmanagement.StudentOperations;

public class TestStudents {
    
    public static void main(String[] args) {
        
        StudentOperations so = new StudentOperations();
        so.add(new Student("Arjun", 4, "B"));
        so.add(new Student("Robert", 41, "A"));
        so.add(new Student("Alan", 10, "A"));
        so.display();
        so.delete();
        so.display();
    }
}
