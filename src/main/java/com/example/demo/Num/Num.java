package com.example.demo.Num;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "num")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Num {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "adminnum")
    private int adminnum;
    @Column
    private int booknum;
    @Column
    private int usernum;
    public Num() {
    }

    public int getAdminnum() {
        return adminnum;
    }

    public void setAdminnum(int adminnum) {
        this.adminnum = adminnum;
    }

    @Override
    public String toString() {
        return "Num{" +
                "adminnum='" + adminnum + '\'' +
                ", booknum='" + booknum + '\'' +
                '}';
    }

    public int getUsernum() {
        return usernum;
    }

    public void setUsernum(int usernum) {
        this.usernum = usernum;
    }

    public int getBooknum() {
        return booknum;
    }

    public void setBooknum(int booknum) {
        this.booknum = booknum;
    }
}
