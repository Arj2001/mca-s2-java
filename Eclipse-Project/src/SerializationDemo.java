import java.io.*;

public class SerializationDemo {
    
    public static void main(String[] args) {
        Employee emp = new Employee("Doe", 20, 7000.0, 25);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
            out.writeObject(emp);
            emp.display();
            System.out.println("Employee object has been serialized");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
