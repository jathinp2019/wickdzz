package arrays;

import java.util.*;

public class arrayList {

    public static void main(String[] args) {
        // @ArrayList : arrays without any specified size...java takes care of the size

        Scanner in = new Scanner(System.in);
        // syntax
        // ArrayList<datatype> var_name = new ArrayList<>();

        ArrayList<Integer> intlist = new ArrayList<>(10);
        intlist.add(40);
        intlist.add(50);
        intlist.add(60);
        intlist.add(70);
        // ... maybe a 100times

        System.out.println("ArrayList intlist: " + intlist);
        System.out.println(intlist.contains(60));

        intlist.set(0, 99); // set at 'index' , this 'item' (index,item)
        System.out.println("Updated intlist: " + intlist);

        intlist.remove(1); // remove at 'index'
        System.out.println("Updated intlist: " + intlist);

        System.out.println(intlist.indexOf(70));

        System.out.println(intlist.get(1)); // get item at 'index'

        for (int i = 0; i < 2; i++) {
            System.out.println(intlist.get(i));
            // list[index] isn't applicable here
        }

        System.out.println("Multi-dim ArrayList: ");
        // multidimensional ArrayList

        // declaring array
        ArrayList<ArrayList<Integer>> mult_list = new ArrayList<>(10);
        // here only initialization was done in terms of rows

        // initializing array (as it is multi-dim)
        for (int i = 0; i < 3; i++) {
            mult_list.add(new ArrayList<>());
            // initializing wrt rows in terms of columns
            // @remember the memory-management of arrays
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mult_list.get(i).add(in.nextInt());
            }
        }

        System.out.println(mult_list);
    }
}
