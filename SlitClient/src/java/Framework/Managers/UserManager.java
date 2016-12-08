
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Managers;

import DataModule.UsersDataModel;
import Server.UsersModuleSessionRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Dahl
 */
public class UserManager {

    private UsersModuleSessionRemote lookupUsersModuleSessionRemote() {
        try {
            Context c = new InitialContext();
            //return (UsersModuleSessionRemote) c.lookup("java:comp/env/UsersModuleSession");
            return (UsersModuleSessionRemote) c.lookup("java:global/SlitServer-ejb/UsersModuleSession");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public UsersDataModel getUserFromId(int id) 
    {
        return this.lookupUsersModuleSessionRemote().getUserFromId(id);
    }
    
    public UsersDataModel loginUser(String mail, String password)
    {
        return this.lookupUsersModuleSessionRemote().loginUser(mail, password);
    }
    
    public List<UsersDataModel> getAllUsers() 
    {
        return this.lookupUsersModuleSessionRemote().getAllUsers(); 
    }
   
    
}
