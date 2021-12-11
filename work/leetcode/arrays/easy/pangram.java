package arrays.easy;
// A pangram is a sentence where every letter of the English alphabet appears at least once.

//26 letters in english

//https://leetcode.com/problems/check-if-the-sentence-is-pangram/
import java.util.*;

public class pangram {
    public static void main(String[] args) {
        // String sentence = "thequickbrownfoxjumpsoverthelazydog";
        String sentence = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        System.out.println(fun(sentence));
    }

    static boolean fun(String sentence) {

        if (sentence.length() < 26) {

            System.out.println("false");
            return false;

        } else {
            // for (char c = 'a'; c <= 'z'; c++) {

            // System.out.println(c);
            // if (sentence.indexOf(c) < 0) {
            // return false;
            // }
            // }
            // copied 🙂

        }

        return true;
    }
}
