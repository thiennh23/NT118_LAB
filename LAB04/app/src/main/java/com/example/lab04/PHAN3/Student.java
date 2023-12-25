package com.example.lab04.PHAN3;

public class Student {
    private int Id;
    private String Name;
    private String Email;
    private  String PhoneNumber;

    public Student(String name, String email, String phoneNumber) {
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
    }

    public Student(int id, String name, String email, String phoneNumber) {
        Id = id;
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
    }

    public void update(String name, String email, String phoneNumber) {
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
    }

    String getName(){return Name;}
    String getPhoneNumber(){return PhoneNumber;}
    String getEmail(){return Email;}
    int getId(){return Id;}
}
