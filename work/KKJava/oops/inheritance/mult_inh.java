package oops.inheritance;

public class mult_inh {
    public static void main(String[] args) {
        child ch1 = new child();
    }
}

class grandparent {
    int a = 10;

    grandparent() {
        System.out.println("In grandparent");
    }

    grandparent(int a) {
        this.a = a;
    }

}

class parent extends grandparent {
    int b = 20;

    parent() {
        System.out.println("In Parent");
        System.out.println(super.a);// can access grandparent
    }

    parent(int b, int a) {
        super(a);
        this.b = b;
    }
}

class child extends parent {
    int c = 30;

    child() {
        System.out.println("In Child");
        System.out.println(super.a);
        System.out.println(super.b); // can access both parent,grandparent
    }

    child(int a, int b, int c) {
        super(b, a);
        this.c = c;

        // accepting args for superclasses too
    }

}