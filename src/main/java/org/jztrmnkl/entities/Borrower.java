package org.jztrmnkl.entities;

public class Borrower {
    private int id;
    private String name;
    private int age;

    public Borrower(){}
    public Borrower(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId(){return id;}

    public String getName() {return name;}
    public int getAge(){return age;}
}
