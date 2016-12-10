/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;

/**
 *
 * @author Morten
 */
public class UsersDataModel implements Serializable{
    private int userID; 
    private String fName; 
    private String lName;
    private String username;
    private String password;
    private String email;
    private int userrole;
    
    public UsersDataModel(String fName, String lName, String username, String password, String email, int userrole) {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userrole = userrole;
    }
    
    public UsersDataModel() {
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public int getUserrole() {
        return userrole;
    }
    
    public void setUserrole(int role) {
        this.userrole = role;
    }
}
