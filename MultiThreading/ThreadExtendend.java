package MultiThreading;

public class ThreadExtendend extends Thread {

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Inside thread i="+i);
        }
    }

    public static void main(String[] args) {
        new ThreadExtendend().start();
    }
}
