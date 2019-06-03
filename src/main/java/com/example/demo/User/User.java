package com.example.demo.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid")
    private int uid;
    @Column
    private String uname;
    @Column
    private String usex;
    @Column
    private String uaddress;
    @Column
    private String udate;
    @Column
    private String uiphone;
    @Column
    private String uemail;

    public User(){}

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public String getUdate() {
        return udate;
    }

    public void setUdate(String udate) {
        this.udate = udate;
    }

    public String getUiphone() {
        return uiphone;
    }

    public void setUiphone(String uiphone) {
        this.uiphone = uiphone;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public User(int uid,String uname, String usex, String uaddress, String udate, String uiphone, String uemail) {
        this.uid=uid;
        this.uname = uname;
        this.usex = usex;
        this.uaddress = uaddress;
        this.udate = udate;
        this.uiphone = uiphone;
        this.uemail = uemail;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", usex='" + usex + '\'' +
                ", uaddress='" + uaddress + '\'' +
                ", udate='" + udate + '\'' +
                ", uiphone='" + uiphone + '\'' +
                ", uemail='" + uemail + '\'' +
                '}';
    }
}
