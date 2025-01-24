package ExceptionHandling;

import java.util.Scanner;

public class NonNumericException {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        try {
            int numeric = Integer.parseInt(in.next());
            System.out.println("Entered value is: "+ numeric);
        } catch (NumberFormatException e) {
            System.out.println("Entered input is invalid");
        }

    }
}
