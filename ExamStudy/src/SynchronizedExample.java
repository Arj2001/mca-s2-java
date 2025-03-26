public class SynchronizedExample {
    private int count = 0;

    public synchronized void increment() {  
        count++;
    }
    //without synchronization
//    public  void increment() {  
//        count++;
//    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        SynchronizedExample example = new SynchronizedExample();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3= new Thread(task);
        
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + example.getCount());
//        System.out.println("Final count: " + example.getCount());
    }
}