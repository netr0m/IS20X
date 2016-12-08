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
    
    public UserType(int userrole, String username) {
        this.userrole = userrole;
        this.username = username;
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
}
