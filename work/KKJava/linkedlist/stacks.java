package linkedlist;

// import java.util.Stack;

// public class stacks {
//     public static void main(String[] args) {

//         System.out.println("Stacks: ");
//         stack_ll s = new stack_ll();
//         s.push(4);
//         s.push(5);
//         s.push(6);
//         s.push(7);
//         s.push(8);

//         // s.peek();

//         s.pop();
//         s.pop();
//         s.pop();

//         // s.peek();

//         Stack<Integer> st = new Stack<>();
//         st.push(20);
//         st.push(30);
//         st.push(10);
//         st.push(50);

//         System.out.println(st);
//         st.pop();
//         st.pop();
//         st.pop();

//         System.out.println(st);
//     }
// }

import java.util.*;

class node {

    int data;
    node next;

    public node(int data) {

        this.data = data;

        this.next = null;

    }
}

class stack {

    node head;

    public stack() {

        this.head = null;

    }

    public void push(int data) {

        node newNode = new node(data);

        newNode.next = this.head;

        this.head = newNode;

    }

    public int pop() {

        if (this.head == null) {

            System.out.println("stack is empty");

            return 0;

        }

        int data = this.head.data;

        this.head = this.head.next;

        return data;

    }

    public int peek() {

        if (this.head == null) {

            System.out.println("stack is empty");

        }

        return this.head.data;

    }

    public boolean isEmpty() {

        return this.head == null;

    }
}
