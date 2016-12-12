/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Managers;

import Data.UsersDataModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import Server.UserSessionBeanRemote;

/**
 *
 * @author Morten
 */
public class UserManager {
    
    private UserSessionBeanRemote lookupUsersModuleSessionRemote() {
        try {
            Context c = new InitialContext();
            //return (UsersModelSessionRemote) c.lookup("java:global/slit-ejb/UserModuleSession");
            return (UserSessionBeanRemote) c.lookup("java:global/slit-ejb/UserSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public UsersDataModel getUserFromID(int ID) {
        return this.lookupUsersModuleSessionRemote().getUserFromID(ID);
    }
    
    public UsersDataModel loginUser(String username, String password) {
        return this.lookupUsersModuleSessionRemote().loginUser(username, password);
    }
    
    public List<UsersDataModel> getAllUsers() {
        return this.lookupUsersModuleSessionRemote().getAllUsers();
    }
    
    public boolean storeUser(UsersDataModel userModule) {
        return this.lookupUsersModuleSessionRemote().storeUser(userModule);
    }
}
