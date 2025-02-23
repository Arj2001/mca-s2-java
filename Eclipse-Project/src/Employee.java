import java.io.Serializable;
public class Employee implements Serializable{

    private static final long serialVersionUID = 1L;
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public void display(){
        System.out.println("Name: "+name+" Age: "+age+" Salary: "+salary);
    }
}
