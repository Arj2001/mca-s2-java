package studentmanagement;

import java.util.ArrayList;
import java.util.List;

public class StudentOperations {
    
    List<Student> ls = new ArrayList<>();
    public void add(Student st){
        ls.add(st);
    }
    public void delete(){
        ls.remove(ls.size()-1);
    }
    public void display(){
        System.out.println(ls);
    }
}
