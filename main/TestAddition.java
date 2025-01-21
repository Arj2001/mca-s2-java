package main;

// import java.util.Scanner;
import mathoperations.Addition;
import mathoperations.Subtraction;
import mathoperations.Multiplication;

public class TestAddition {

    public static void main(String[] args) {
        
        // Scanner scan = new Scanner(System.in);
        // int a = scan.nextInt();
        // int b = scan.nextInt();
        // Addition addition = ;
        System.out.println(new Addition().add(3, 4));
        System.out.println(new Subtraction().subtract(10,5));
        System.out.println(new Multiplication().mult(4,6));

    }
}