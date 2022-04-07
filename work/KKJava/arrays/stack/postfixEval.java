// package arrays.stack;

// import java.util.*;

// public class postfixEval {

// public static void main(String args[]) {
// String e = "426*+";
// System.out.print("PostFix Eval: ");
// pfEval(e);
// }

// static boolean opCheck(char ch) {
// if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
// return true;

// return false;
// }

// static void pfEval(String e) {
// Stack<Integer> pf = new Stack<>();
// int n = e.length();

// for (int i = 0; i < n; i++) {
// if (opCheck(e.charAt(i))) {
// int op1 = pf.pop();
// int op2 = pf.pop();

// switch (e.charAt(i)) {
// case '+':
// pf.push(op2 + op1);
// break;

// case '-':
// pf.push(op2 - op1);
// break;

// case '*':
// pf.push(op2 * op1);
// break;

// case '/':
// pf.push(op2 / op1);
// break;

// }

// } else {
// int op = e.charAt(i) - '0';
// pf.push(op);
// }
// }

// System.out.println(pf.pop());
// }

// }
// // }
