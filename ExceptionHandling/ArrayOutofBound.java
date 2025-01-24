package ExceptionHandling;

public class ArrayOutofBound {
    
    public static void main(String[] args) {
        
        int arr[] = { 1, 2, 3, 4, 5};
        try {
            for (int i = 0; i < 6; i++) {
                System.out.println(arr[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot access out of index elements");
        }
    }
}
