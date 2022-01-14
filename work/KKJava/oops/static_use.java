package oops;

public class static_use { // outerclass

    class c3 {

    }

    static class c2 { // innerclass

        String st = " this is c2";
        // NOTE: innerclasses MUST be static whereas outerclass aren't
    }

    public static void main(String[] args) {

        c1 a = new c1();
        c1 b = new c1();
        c1 c = new c1();
        // actually the o/p for evrything should be 2 but it is incrementing accordingly

        // static members can be accessed without even creating an object as it belongs
        // to CLASS and not OBJECT
        c1.fun();
        System.out.println(c1.cn++);
        System.out.println(c1.cn++);
        System.out.println(c1.cn++);

        c2 d = new c2();
        System.out.println(d.st);

        // c3 e=new c3(); // this will show error as the class isnt static
    }

}

class c1 { // outerclass
    static int count;
    static int cn;

    static {
        cn = count + 10; // here count = 0
        System.out.println("this is from static block");

        // NOTE: it only executes once!!(even if multiple objects are created as it
        // belongs to the class and not the object)
    }

    c1() {
        c1.count++;
        System.out.println(c1.count);
    }

    static void fun() {
        System.out.println("this is static fun");
    }
}