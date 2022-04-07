import java.util.*;

// import arrays.arr;

public class practice {

    public static void main(String[] args) {
        int[] a = { 10, 5, 2, 4 };
        a = mergeSort(a);
        // a = mergeSort(a, 0, a.length);

        System.out.println(Arrays.toString(a));
    }

    // static int[] mergeSort(int[] arr, int p, int q) {

    // if (arr.length == 1)
    // return arr;

    // if (p > q)
    // return arr;
    // // mid = (p + q) / 2;

    // int mid = (p + q) / 2;

    // int[] a1 = mergeSort(arr, p, mid);
    // int[] a2 = mergeSort(arr, mid, q);

    // return merge(a1, a2);
    // // return arr;

    // }
    static int[] mergeSort(int[] arr) {

        if (arr.length == 1)
            return arr;

        int mid = arr.length / 2;

        int[] a1 = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] a2 = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(a1, a2);
        // return arr;

    }

    static int[] merge(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];

        int i = 0, j = 0, k = 0;

        while (i < a1.length && j < a2.length) {

            if (a1[i] > a2[j]) {
                result[k] = a2[j];
                j++;
            } else {
                // if (a1[i] < a2[j]) {
                result[k] = a1[i];
                i++;
            }

            k++;
        }

        while (i < a1.length) {
            result[k] = a1[i];
            // System.out.println(result.length);
            i++;
            k++;
        }

        while (j < a2.length) {
            result[k] = a1[j];
            j++;
            k++;
        }
        // System.out.println(k);

        return result;
    }
}
