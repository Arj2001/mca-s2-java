import java.io.Serializable;
public class Employee implements Serializable{

    private static final long serialVersionUID = 1L;
    String name;
    int age;
    double salary;
    transient int val;

    public Employee(String name, int age, double salary, int val) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.val = val;
    }
    public void display(){
        System.out.println("Name: "+name+" Age: "+age+" Salary: "+salary+ " Val: " + val);
    }
}
