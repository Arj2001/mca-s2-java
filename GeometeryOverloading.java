class Geometery{

    double area(int radius){
        return 3.14*radius*radius;
    }
    
    int area(int length, int breadth){
        return length*breadth;
    }

    double area(double base, int height){
        return 0.5*base*height;
    }
}
public class GeometeryOverloading {
    
    public static void main(String[] args) {
        
        Geometery g = new Geometery();
        System.out.println("Area of circle: " + g.area(5));
        System.out.println("Area of rectangle: " +g.area(5,10));
        System.out.println("Area of circle: " +g.area(6.0, 5));
    }

}
