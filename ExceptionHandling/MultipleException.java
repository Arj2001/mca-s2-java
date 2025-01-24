package ExceptionHandling;

import java.util.Scanner;

public class MultipleException {
    
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            if(str.isEmpty()){
                str = null;
            }
            System.out.println("Enterd string length"+str.length());
            int val = Integer.parseInt(str);
            int arr[] = {1, 2, 3, 4, 5};
            System.out.println(arr[val]/val);
        }catch (ArithmeticException e) {
            System.out.println("Divide by zero is not possible");
        }catch (NullPointerException e){
            System.out.println("Null pointer exception");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array index out of bound");
        }
    }
}
