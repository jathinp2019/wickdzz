package oops.inheritance;

public class inheritance {
    // multiple inheritance is not allowed in java

    public static void main(String[] args) {
        // vehicle v = new vehicle();

        four f1 = new four();
        four f = new four("1ASTYU", 10);

        two t = new two();
        two t1 = new two("FGT678", 8);
    }
}

class vehicle {

    // @ public vehicle()
    // for direct call of constructor without using 'super();''

    vehicle() {
        System.out.println("inside vehicle ");
    }

    String st = "This is a ";
}

class four extends vehicle {
    int years;
    String reg, st = "two wheeler";

    // to call the base constructor on creation of object directly...
    // make the base constructor as 'public base(){}''

    four() {
        super();
        // @ calling base constructor

        System.out.println(super.st + st);
    }

    four(String s, int n) {
        years = n;
        reg = s;
        System.out.println("Years: " + years);
        System.out.println("reg: " + reg);
    }
}

class two extends vehicle {
    int years;
    String reg, st = "four wheeler";

    two() {
        super();
        // @ calling base constructor

        System.out.println(super.st + st);
    }

    two(String s, int n) {
        years = n;
        reg = s;
        System.out.println("Years: " + years);
        System.out.println("reg: " + reg);
    }
}
