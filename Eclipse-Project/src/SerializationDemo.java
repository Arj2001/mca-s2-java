import java.io.*;

public class SerializationDemo {
    
    public static void main(String[] args) {
        Employee emp = new Employee("John", 30, 5000.0);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
            out.writeObject(emp);
            System.out.println("Employee object has been serialized");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
