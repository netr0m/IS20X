/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit;
import javafx.scene.control.PasswordField;

/**
 *
 * @author Anders
 */
public class User {
    String userName;
    String fullName;
    String password;

    


public User (String username, String fullName, String password) { 
    
    this.userName = username;
    this.fullName = fullName;
    this.password = password;


}

/**
 * Return a string that contains all info about a user.
 * @return  all user info
 */
public String printUserInfo() {
    
    return "User name: " + userName + ". Full name = " + fullName + ". Password = " + password + ".";
}

/**
 * @return the username
 */
public String getUsername() {
    
    return userName;
}

/**
 * @return full name of user
 */
public String getFullName() {
    
    return fullName;
}

/**
 * @return password of user 
 */
public String getPassword() {
    return password;
}
}

