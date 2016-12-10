/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Data.ModuleDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Morten
 */
@Remote
public interface ModuleSessionBeanRemote {
    
    String getModuleByID(int ID);
    
    List<ModuleDataModel> getModules();
    
    List<String> getModuleNames();
    
    String getModuleNameFromID(int ID); 
    
    ModuleDataModel getModule(int ID) ;
    
    List<ModuleDataModel> getAllModules(); 
    
    boolean storeModule(ModuleDataModel module); 
    
    ModuleDataModel findModuleByName(String moduleName);
}
