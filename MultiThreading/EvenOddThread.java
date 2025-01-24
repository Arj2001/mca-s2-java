package MultiThreading;
class Even extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i=i+2) {
            System.out.println("even no: "+i);
        }
    }
}
class Odd extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 10; i=i+2) {
            System.out.println("odd no: "+i);
        }
    }
}
public class EvenOddThread {

    public static void main(String[] args) {
        new Even().start();
        new Odd().start();
    }
    
}
