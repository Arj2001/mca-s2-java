package MultiThreading;

public class ThreadRunnable implements Runnable{
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Inside thread i="+i);
        }
    }

    public static void main(String[] args) {
        
        Thread th = new Thread(new ThreadRunnable());
        th.start();

    }
    
}
