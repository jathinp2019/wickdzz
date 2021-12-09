public class inheritance {
    public static void main(String[] args) {
        vehicle v = new vehicle();
        // System.out.println(v.st);
        car c = new car();
        // System.out.println(c.st);
    }
}

public class vehicle {
    String st = "Parent car";
}

public class car extends vehicle {
    String st = "Child car";

    car() {
        System.out.println("in car(): ");
        System.out.println(st); // child var
        System.out.println(super.st); // parent var using 'super'
    }
}