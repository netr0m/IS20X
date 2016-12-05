/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Anders
 */
public class UserManagement {
    
    //Lag en arraylist som lagrer ulike brukere.
    ArrayList<User> users;
    private String login;
    @FXML
    private String password;
    @FXML
    private LoginController loginController;



public UserManagement() {
    
  users = new ArrayList<User>();
  login = loginController.getLogin();
  password = loginController.getPassword();
}


public void addUser(String userName, String fullName, String password) {

users.add(new User(userName, fullName, password));
}

public void listAllUsers() {
    for (User user : users) {
        System.out.println(user.printUserInfo());
    }
    
}



/**
 * 
 * @param userName username to be searched for
 * @param password password to be searched for
 * @ return boolean for check of username/password
 */
public boolean checkUser(String userName, String password)  {
    
    int index = 0;
    boolean searching = true;
    boolean match = false;
    while (searching && index < users.size()) {
        String u = users.get(index).getUsername();
        String p = users.get(index).getPassword();
        if (u.equals(userName) && p.equals(password)) {
            //its a match
            match = true;
        }
        else {
            // continue searching
            index++;
        }
}
    return match;
}

}
        

        
        
        
        
        
        
        
        
    