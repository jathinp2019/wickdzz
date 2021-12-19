public class prop {
    public static void main(String[] args) {
        residential_property rp = new residential_property(45 * 60, "city");
        rp.calculate_cost();
        rp.display_cost();
        commercial_property cp = new commercial_property(89 * 45, "twofloor");
        cp.calculate_cost();
        cp.display_cost();
    }
}

class property {
    public int dimension;

    public property(int dimension) {
        this.dimension = dimension;
    }

    public void calculate_cost() {
    }

    public void display_cost() {
    };
}

class residential_property extends property {
    private String type;

    public residential_property(int dimension, String type) {
        super(dimension);
        this.type = type;
    }

    public void calculate_cost() {
        int cost;
        if (type == "city") {
            cost = dimension * 2500;
            System.out.println("property cost:" + cost);
        } else if (type == "town") {
            cost = dimension * 2000;
            System.out.println("property cost:" + cost);
        }

    }

    public void display_cost() {
        System.out.println("Type:" + type);
        System.out.println("dimension:" + dimension);
    }
}

class commercial_property extends property {
    private String no_of_floors;
    private String type;

    public commercial_property(int dimension, String type) {
        super(dimension);
        this.type = type;
    }

    public void calculate_cost() {
        int cost;
        if (type == "twofloor") {
            cost = dimension * 2500;
            System.out.println("property cost:" + cost);
        } else if (type == "fourfloor") {
            cost = dimension * 2000;
            System.out.println("property cost:" + cost);
        }

    }

    public void display_cost() {
        System.out.println("Type:" + type);
        System.out.println("dimension:" + dimension);
    }
}
