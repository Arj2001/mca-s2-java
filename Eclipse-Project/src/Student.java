import java.io.Serializable;

public class Student implements Serializable{
    
    String name;
    transient int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
