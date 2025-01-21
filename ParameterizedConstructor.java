class Box1{
    int length;
    int breadth;
    int height;
    
    Box1(int length, int breadth, int height){
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }
    int volume(){
        return length * breadth * height;
    }
}
public class ParameterizedConstructor {

    public static void main(String[] args) {

        Box1 b1 = new Box1(2, 10, 4);
        System.out.println("Volume of box 1 = "+b1.volume());
        Box1 b2 = new Box1(4, 6, 9);
        System.out.println("Volume of box 2 = "+b2.volume());
    }

}