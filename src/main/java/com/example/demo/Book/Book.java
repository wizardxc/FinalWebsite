package com.example.demo.Book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "managebook")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Book {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bid")
    private int bid;
    @Column
    private String bname;
    @Column
    private String author;
    @Column
    private String press;
    @Column
    private String remark;
    @Column
    private float price;
    @Column
    private String type;
    @Column
    private int num;


    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Book() {

    }

    public Book(int bid,String bname, String author, String press, String remark, float price, String type, int num) {
        this.bid=bid;
        this.bname = bname;
        this.author = author;
        this.press = press;
        this.remark = remark;
        this.price = price;
        this.type = type;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", remark='" + remark + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", num=" + num +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
