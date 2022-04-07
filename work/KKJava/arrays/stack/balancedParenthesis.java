//CSE20192

package arrays.stack;

import java.util.Stack;

public class balancedParenthesis {

    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();

        String s = "({})";
        for (int i = 0; i < s.length(); i++) {
            if (check(s.charAt(i))) {

                st.push(s.charAt(i));

            } else
                st.pop();
        }

        if (st.isEmpty()) {
            System.out.println("Balanced");
        } else
            System.out.println("Unbalanced");

    }

    static boolean check(char c) {
        if (c == '(' || c == '{' || c == '[') {
            return true;
        } else if (c == ')' || c == '}' || c == ']') {
            return false;
        }
        return false;
    }
}
