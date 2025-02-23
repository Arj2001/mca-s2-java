import java.io.*;

public class DeserializationDemo {
    
    public static void main(String[] args) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.ser"))) {
            Employee emp = (Employee) in.readObject();
            System.out.println("Employee object has been deserialized");
            emp.display();
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}