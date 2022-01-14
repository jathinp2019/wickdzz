package oops.packages;

import static oops.packages.p1.message;
import oops.packages.*;

public class p2 {
    public static void main(String[] args) {
        message(); // this is static
        p3.message();
    }
}
