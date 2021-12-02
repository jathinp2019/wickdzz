package work.KKJava;

import java.util.*;

public class inputOutput {

    public static void main(String args[]) {
        // output part
        // System.out.print("Not a new line");
        // System.out.println("java ");
        // System.out.println("java ");

        // input part
        Scanner in = new Scanner(System.in);
        System.out.println("Input String: ");
        String st = in.nextLine();
        System.out.println("String: " + st);

        System.out.println("Input int: ");
        int rn = in.nextInt();
        System.out.println("Your number: " + rn);

        System.out.println("float : ");
        float marks = in.nextFloat();
        // look out for floating point error
        System.out.println(marks);

        System.out.println("Sum inp: ");
        int sum = in.nextInt() + in.nextInt();
        System.out.println("Sum = " + sum);

        // Explicit Typecasting
        int num = (int) (50.02f);
        System.out.println("float num: " + num);
        // auto type promotion
        int a = 102;
        int c = 128;
        // try 257: it ll show 257 % 256
        byte b = (byte) (a);
        byte d = (byte) (c);
        System.out.println("byte b: " + b);
        System.out.println("byte d: " + d);
        // @max value of BYTE:256

        // *NOTE:
        // java automatically promotes each variables /literal before operating it

        // $ JAVA FOLLOWS UNICODE...i.e any lang. is compatible with JAVA

    }
}
