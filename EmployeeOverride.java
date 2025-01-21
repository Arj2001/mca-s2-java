class Employee{

    void displayDetails(){
        System.out.println("Name, Mobile Number, Project Name, Project Details");
    }
}
class Manager extends Employee{

    void displayDetails(){
        super.displayDetails();
        System.out.println("Manages, Work hours");
    }
}
public class EmployeeOverride {
    
    public static void main(String[] args) {
        Employee e = new Employee();
        System.out.println("Employeer");
        e.displayDetails();

        System.out.println("Manager");
        Manager m = new Manager();
        m.displayDetails();
    }
}
