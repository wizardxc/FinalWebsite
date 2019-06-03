package com.example.demo.LoginAdmin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "loginadmin")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class LoginAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number")
    private int number;

    @Column
    private String username;
    @Column
    private String password;

    public LoginAdmin() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LoginAdmin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "LoginAdmin{" +
                "number=" + number +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
