class InnerThreadEx {

    int value =10;
}
public class ThreadEx extends InnerThreadEx implements Runnable{
    public static void main(String[] args) {
        
        System.out.println("This code is outside of the thread");
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new ThreadEx());
            t.start();
        }
    }
    public void run() {
        System.out.println("This code is running in a thread");
        for (int i = 0; i < 100; i++) {
            System.out.println("Inside "+ i);
        }
    }
      
}
