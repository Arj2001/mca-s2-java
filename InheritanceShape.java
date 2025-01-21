class Shape{
    private String color;
    Shape(String color){
        this.color = color;
    }
    String getColor(){
        return color;
    }
}
class Circle extends Shape{

    private double radius;
    Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }
    double calculateArea(){
        return 3.14*radius*radius;
    }
}
class Rectangle extends Shape{

    private double length;
    private double width;
    Rectangle(String color, double length, double width){
        super(color);
        this.length = length;
        this.width = width;
    }
    double calculateArea(){
        return length * width;
    }

}
public class InheritanceShape {
    public static void main(String[] args) {
        Circle c = new Circle("Red", 9);
        System.out.println("Circle color: "+ c.getColor()+ " with area: "+c.calculateArea());

        Rectangle r = new Rectangle("Yellow", 5, 8);
        System.out.println("Rectangle color: "+ r.getColor()+ " with area: "+r.calculateArea());
    }
}
