
class Box{
    int length;
    int breadth;
    int height;
    
    Box(){
        length = 10;
        breadth = 20;
        height = 5;
    }
    int volume(){
        return length * breadth * height;
    }
}
public class DefaultConstructor {

    public static void main(String[] args) {

        Box b1 = new Box();
        System.out.println("Volume of box 1 = "+b1.volume());
        Box b2 = new Box();
        System.out.println("Volume of box 2 = "+b2.volume());
    }

}