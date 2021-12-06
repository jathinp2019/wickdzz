package work.KKJava.functions;

import java.util.*;

public class func {
    static int sum(int a, int b) {
        // static used here because anything defined in a static method should be static
        return a + b;
    }

    static String returnString(String st) {
        return "hi " + st;
    }

    static void change(int[] n) {
        n[0] = 10;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a, b;
        System.out.println("Enter no: ");
        a = in.nextInt();
        b = in.nextInt();
        System.out.println("sum: " + sum(a, b));

        System.out.println(returnString("vaishakh"));

        int[] arr = { 1, 2, 3, 4, 5 };
        change(arr);
        System.out.println(Arrays.toString(arr));
    }
}