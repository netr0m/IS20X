/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

/**
 *
 * @author mortea15
 */
public class UserType {
    
    public static int userrole;
    public static String username;
    public static int userID;
    
    public UserType(int userrole, String username, int userID) {
        this.userrole = userrole;
        this.username = username;
        this.userID = userID;
    }
    
    public int getUserrole() {
        return userrole;
    }
    
    public void setUserrole(int role) {
        this.userrole = role;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public int getUserID() {
        return userID;
    }
    
    public void setUserID(int userID) {
        this.userID = userID;
    }
}
