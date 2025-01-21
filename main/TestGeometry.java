package main;

import geometry.*;

public class TestGeometry {
    
    public static void main(String[] args) {
        
        System.out.println("Circle area: "+new Circle().area(6));
        System.out.println("Rectangle area: "+new Rectangle().area(10,35));
    }
}
