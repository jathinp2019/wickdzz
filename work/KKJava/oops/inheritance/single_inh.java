package oops.inheritance;

public class single_inh {
    public static void main(String[] args) {

        child ch1 = new child();
        ch1.fun1();
        // accessing parent func using child

        child ch2 = new child(20, 30); // passing arg for parent class also

        ch2.same();

        // ---------------

        // @ NOTE: The type of reference variable determines the what members can be
        // @ accessed by the reference variable
        parent o = new child();
        System.out.println(o.a); // o can acess parent
        // System.out.println(o.b); // error: o cannot access child

        o.fun(); // static method from parent is called

        // ---------------
    }
}

class parent {
    int a = 10;

    parent() {
        super(); // try going into it
        // when we use 'super' in the parent class itself, it refers to the
        // Object class(which is a superclass for every object we create , i.e. parent
        // class for evry other class by default)

        System.out.println("in Parent ");
    }

    void fun1() {
        System.out.println("Parent func using obj");
    }

    void fun2() {
        System.out.println("Parent func using super");
    }

    parent(int n1) {
        System.out.println("Param. parent :" + n1);
    }

    void same() {
        System.out.println("Same from Parent");
    }

    static void fun() {
        System.out.println("Static method Parent");
    }

}

class child extends parent {
    int b = 15;

    child() {
        System.out.println("in child ");

        System.out.println(super.a);
        super.fun2();
        // accessing parent class using super
    }

    child(int n1, int n2) {
        super(n2); // accepting arg for parent class also

        // Note: No default parameters in JAVA
        // JAVA also supports COPY CONSTRUCTORS

        System.out.println("Param child: " + n1);
    }

    @Override
    void same() {
        System.out.println("Same from Child");
    }

    static void fun() {
        System.out.println("Static method Child");
    }

}