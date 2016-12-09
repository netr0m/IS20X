/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Data.UsersDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Morten
 */
@Remote
public interface UsersModelSessionRemote {
    
    UsersDataModel getUserFromID(int ID);
    
    UsersDataModel loginUser(String username, String password);
    
    List<UsersDataModel> getAllUsers();
    
    void updatePassword(UsersDataModel obj, String password);
    
    boolean storeUser(UsersDataModel user);
}
