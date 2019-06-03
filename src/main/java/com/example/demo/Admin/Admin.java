package com.example.demo.Admin;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Admin")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number")
    private int   number;
    @Column
    private String sex;

    @Column
    private String name;
    @Column
    private String  date;
    @Column
    private String iphone;

    @Column
    private String email;
    public Admin(){

    }
    public Admin(int number , String sex, String name, String date, String iphone, String email) {
        this.number=number;
        this.sex = sex;
        this.name = name;
        this.date = date;
        this.iphone = iphone;

        this.email = email;

    }

    public Admin(String sex, String name, String date, String iphone, String email) {
        this.sex = sex;
        this.name = name;
        this.date = date;
        this.iphone = iphone;

        this.email = email;
    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "number=" + number +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", iphone='" + iphone + '\'' +

                ", email='" + email + '\'' +
                '}';
    }
}
