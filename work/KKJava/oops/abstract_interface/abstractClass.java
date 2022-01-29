package oops.abstract_interface;

public class abstractClass {
    public static void main(String[] args) {

        parent.staticMethod();

        child2 ch2 = new child2();
        ch2.career("doctor");
    }
}

abstract class parent {
    abstract void career(String name);
    // abstract classes cannot be instantiated

    void normal() {
        System.out.println("abstract classes can have normal methods");
    }

    static void staticMethod() {
        System.out.println("Static method inside abstarct class");
    }

    // No abstract constructors nor abstract static methods are allowed
}

class child2 extends parent {
    void career(String name) {
        System.out.println(name);

        System.out.println("calling parent class(super())");
        super.normal();
    }
}

class child1 extends parent {
    void career(String name) {
        name = "engineer";
    }
}
