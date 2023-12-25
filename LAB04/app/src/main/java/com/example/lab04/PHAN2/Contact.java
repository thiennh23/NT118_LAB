package com.example.lab04.PHAN2;

import java.util.Random;

public class Contact {
    private static int sub_id = 0;
    private int id;
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
//        Random random = new Random();
//        int randomNumber = random.nextInt(1000000);
        this.id = sub_id;
        sub_id = sub_id + 1;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public Contact(int id, String name, String phoneNumber)
    {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    int getID(){return this.id;}
    String getName(){return this.name;}
    String getPhoneNumber(){return this.phoneNumber;}

    void setPhoneNumber(String mew_phoneNumber)
    {
        this.phoneNumber = mew_phoneNumber;
    }

    public String toString()
    {
        return "Id: " + this.id + " ,Name: " + this.name + ", Phone: " + this.phoneNumber;
    }
}