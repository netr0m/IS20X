/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Morten
 */
@Entity
public class UsersDataModel implements Serializable{
    private int userID; 
    private String fName; 
    private String lName;
    private String username;
    private String password;
    private String email;
    private String userrole;

    public int getID() {
        return userID;
    }

    public void setID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return fName;
    }

    public void setFirstName(String fName) {
        this.fName = fName;
    }

    public String getLastName() {
        return lName;
    }

    public void setLastName(String lName) {
        this.lName = lName;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername() {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setMail(String email) {
        this.email = email;
    }
    
    
}
