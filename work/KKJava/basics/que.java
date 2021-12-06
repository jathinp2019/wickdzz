
package work.KKJava.basics;

import java.util.*;

public class que {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // System.out.println("Number: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        // // biggest number
        // int t = a;
        // if (t < b) {
        // t = b;
        // }
        // if (t < c) {
        // t = c;
        // }
        // System.out.println("biggest :" + t);

        // int s = a;
        // s = (s < b ? s = b : s) < c ? s = c : s;
        // System.out.println("biggest(shortcut) :" + s);

        // // case check
        // System.out.println("Character: ");

        // // System.out.println("for testing: " + in.next().charAt(0));
        // // @trim() used to remove spaces
        // // @charAt() used to het char at index

        // char ch = in.next().trim().charAt(0);

        // if (ch >= 'a' && ch <= 'z') {
        // System.out.println("lowercase");
        // } else if (ch >= 'A' && ch <= 'Z') {
        // System.out.println("uppercase");
        // } else
        // System.out.println("invalid");

        // // fibonnaci
        // System.out.println("Fibonacci: ");
        int sum = 0, i = 0;
        // a = 0;
        // b = 1;
        // int n = in.nextInt();
        // while (sum <= n) {
        // sum = a + b;
        // System.out.println(a);
        // a = b;
        // b = sum;
        // i++;
        // }

        // occurence
        i = 0;
        System.out.println("Occurence-  input:");
        a = in.nextInt();
        System.out.println("No. :");
        b = in.nextInt();

        while (a != 0) {
            // i = b == a % 10 ? i++ : i;
            if (a % 10 == b) {
                i++;
            }

            a = a / 10;
        }
        System.out.println(i);

        // reverse
        i = 0;
        sum = 0;
        System.out.println("Reverse-  input:");
        a = in.nextInt();
        while (a != 0) {
            int r = a % 10;
            sum = sum * 10 + r;
            a = a / 10;
        }
        System.out.println("Reverse-  a: " + sum);

        // .equal
        String st = "abc";
        if (st.equals("abc")) {
            System.out.println(true);
        }
        // this is equivalent to
        // if(st=="abc")

        // @".equals()" is used when 2 var is pointing to some other object of same-name

        // * SWITCH-CASE
        int n = 1;
        switch (n) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
        }

        // enhanced switch
        switch (n) {
            // cleaner code
            case 1 -> System.out.println("1");
            case 2 -> System.out.println("2");
        }
    }
}
