package ExceptionHandling;

import java.util.Scanner;

public class NegativeSquareRoot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int val = in.nextInt();
        try {
            if(val<1){
                throw new IllegalArgumentException();
            }
            double sqrt = Math.sqrt(val);
            System.out.println("Square root of "+val+" is " +sqrt);
        } catch (IllegalArgumentException e) {
            System.out.println("Input value cannot be negative");
        }
    }
}
