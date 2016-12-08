package Server;

import DataModule.UsersDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Dahl
 */
@Remote
public interface UsersModuleSessionRemote {
    
    UsersDataModel getUserFromId(int id); 
    
    UsersDataModel loginUser(String userName, String password); 
    
    List<UsersDataModel> getAllUsers();
    
}