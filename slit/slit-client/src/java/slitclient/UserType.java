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
    
    public UserType(int userrole) {
        this.userrole = userrole;
    }
    
    public int getUserrole() {
        return userrole;
    }
    
    public void setUserrole(int role) {
        this.userrole = role;
    }
}
