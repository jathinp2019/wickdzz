package oops.inheritance;

public class singletonClass {

    // singleton classes: classes which allow only 1 OBJECT!!

    public static void main(String[] args) {
        singleton o1 = singleton.getInstance();
        singleton o2 = singleton.getInstance();
        singleton o3 = singleton.getInstance();

        // internally only 1 instance is being passed
    }
}

class singleton {
    private singleton() {
        // private prevents it from being accessed from outside
    }

    private static singleton instance;

    public static singleton getInstance() {

        // checks if only 1 object is present
        if (instance == null) {
            instance = new singleton();
        }

        // if there are mroe than 1 instance...then return the already existing instance
        // only rather than making a new one

        return instance;
    }
}