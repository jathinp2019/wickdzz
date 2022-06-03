// package arrays.stack;

// import java.util.*;

// class Stack {

// int top;
// int max = 10;
// int[] a = new int[max];

// boolean isEmpty() {
// return (top < 0);
// }

// Stack() {
// top = -1;
// }

// boolean push(Scanner sc) {
// if (top == max - 1) {
// System.out.println("Overflow");
// return false;
// } else {
// System.out.println("Value");
// int val = sc.nextInt();
// top++;
// a[top] = val;
// System.out.println("Pushed");
// return true;
// }
// }

// boolean pop() {
// if (top == -1) {
// System.out.println("Underflow");
// return false;
// } else {
// top--;
// System.out.println("Popped ");
// return true;
// }
// }

// void display() {
// System.out.println("Stack elements: ");
// for (int i = top; i >= 0; i--) {
// System.out.println(a[i]);
// }
// }
// }

// public class stackArray {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);

// int ch = 0;
// Stack s = new Stack();

// while (ch != 4) {
// System.out.println("\nChoose: \n");
// System.out.println("\t1.Push\t2.Pop\t3.Show\t4.Exit");
// System.out.println(" Enter your choice ");
// ch = sc.nextInt();
// switch (ch) {
// case 1: {
// s.push(sc);
// break;
// }
// case 2: {
// s.pop();
// break;
// }
// case 3: {
// s.display();
// break;
// }
// case 4: {
// System.out.println("Exiting");
// System.exit(0);
// break;
// }
// default: {
// System.out.println("Please Enter valid choice ");
// }
// }
// }
// }
// }
