package com.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_Details")
public class User {
    
    // Define the id field with @Id annotation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This will automatically generate the primary key value
    @Column(name = "userId")
    private int id;
    
    @Column(name = "first_name")
    private String fName;
    
    @Column(name = "last_name")
    private String lName;
    
    @Column(name = "userName")
    private String uName;
    
    @Column(name = "password")
    private String pswd;
    
    // Getter and setter methods
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

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    // User constructor
    public User() {
    	
    }
    public User(String fName, String lName, String uName, String pswd) {
        super();
        this.fName = fName;
        this.lName = lName;
        this.uName = uName;
        this.pswd = pswd;
    }

    // toString method
    @Override
    public String toString() {
        return "User [id=" + id + ", fName=" + fName + ", lName=" + lName + ", uName=" + uName + ", pswd=" + pswd + "]";
    }
}
