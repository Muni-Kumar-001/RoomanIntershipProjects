package com.ecom.facebookBackend;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "UserDetails")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id")
    private int id;

    @Column(name = "firstName")
    private String fName;

    @Column(name = "surName")
    private String surName;

    @Column(name = "Date_of_birth")
    private Date dob;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String pswd;

    // No-argument constructor required by Hibernate
    public User() {}

    public User(String fName, String surName, Date dob, String email, String password) {
        this.fName = fName;
        this.surName = surName;
        this.dob = dob;
        this.email = email;
        this.pswd = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getDate() {
        return dob;
    }

    public void setDate(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return pswd;
    }

    public void setPassword(String pswd) {
        this.pswd = pswd;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", fName=" + fName + ", surName=" + surName + ", date=" + dob + ", email=" + email
                + ", password=" + pswd + "]";
    }
}
