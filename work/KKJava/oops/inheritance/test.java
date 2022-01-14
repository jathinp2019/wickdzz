package oops.inheritance;

// 1.	A class named “Shape” has data members no_of_sides and methods calculate_area() and find_perimeter(). Two classes namely “Circle” and “Rectangle” are inherited from Shape class. Class Circle has a data member radius and Class Rectangle has data members -width and height.
// Illustrate the following concepts.
// a.	Use of super keyword in constructor.
// b.	Overload the method calculate_area().
// c.	Method overriding

public class test {
    public static void main(String[] args) {
        rectangle r = new rectangle(10, 20, 4);
        circle c = new circle(10, 1);
        c.find_perimeter(10, 1);
    }
}

class shape {
    int no_of_sides;

    void calculate_area(int h, int w, int n) {
        System.out.println("the area of rectangle is: " + h * w);
    };

    void calculate_area(int r, int n) {
        System.out.println("the area of circle is: " + (3.14 * r * r));
    };

    void find_perimeter(int h, int w, int n) {
        System.out.println("the perimeter of rectangle is: " + 2 * (h + w));
    };

    void find_perimeter(int r, int n) {
        System.out.println("the perimeter is: " + (3.14 * 2 * r));
    };
}

class rectangle extends shape {
    int width, height;

    rectangle(int w, int h, int n) {
        super.no_of_sides = n;
        width = w;
        height = h;

        super.calculate_area(height, width, n);
        super.find_perimeter(height, width, n);
    }
}

class circle extends shape {
    int radius;

    circle(int r, int n) {
        super.no_of_sides = n;
        radius = r;
        super.calculate_area(r, n);
        // super.find_perimeter(r, n);
    }

    void find_perimeter(int r, int n) {
        System.out.print("For Circle,the perimeter is: " + 3.14 * 2 * r);
    }
}