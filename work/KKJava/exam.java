//  Write a program to create a class called Players having Name,Player_individualId, Team_Id and Age as member variables, throw an user-defined exception if the entered age is is below 20 and print not allowed to play. Age should be private member.

import java.util.*;

class exceptionHandle extends Exception {
    exceptionHandle(String str) {
        System.out.println(str);
    }
}

public class exam {
    public static void main(String[] args) {
        testing t = new testing();

        try {
            t.validate();
        } catch (exceptionHandle e) {
            System.out.println("Caught the exception");

            System.out.println("Exception occured: " + e);
        }
    }
}

class testing {
    void validate() throws exceptionHandle {
        Player p = new Player("Vaishakh", 123, 456, 18);
        if (p.getAge() < 20) {
            throw new exceptionHandle("Not allowed");
        } else
            System.out.println("Allowed");
    }
}

class Player {
    private int age;
    public String name;
    public int Player_individualId, team_Id;

    Player(String n, int pid, int tid, int a) {
        name = n;
        Player_individualId = pid;
        team_Id = tid;
        setAge(a);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
