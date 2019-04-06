package com.example.bkrc.mobilprog1;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String surname;
    int birthDay;
    int birthmonth;
    int birthyear;
    int age;
    String email;
    String id;
    String phonenumber;
    String photouri;

    public User(String name, String surname, int birthDay, int birthmonth, int birthyear, String email, String id, String phonenumber) {
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
        this.birthmonth = birthmonth;
        this.birthyear = birthyear;
        this.email = email;
        this.id = id;
        this.phonenumber = phonenumber;
        calculateAge();
    }

    public void calculateAge(){
        setAge(2019-birthyear);
    }

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthmonth() {
        return birthmonth;
    }

    public void setBirthmonth(int birthmonth) {
        this.birthmonth = birthmonth;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhotouri() {
        return photouri;
    }

    public void setPhotouri(String photouri) {
        this.photouri = photouri;
    }


}