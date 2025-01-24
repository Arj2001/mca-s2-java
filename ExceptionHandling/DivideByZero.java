package ExceptionHandling;

import java.util.Scanner;

public class DivideByZero {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the dividend and divisor");
        int a = in.nextInt();
        int b = in.nextInt();
        try {
            int val = a/b;
            System.out.println("The quotient is "+ val);
        } catch (ArithmeticException ae) {
            System.out.println("Divide by zero is not possible");
        }
    }
}
