package com.example.demo.Book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "booktypenum ")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class BookType_Num {

    @Column(name = "value")
    public int value;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public String name;

    public BookType_Num() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
