/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Managers;

import DataModule.ModuleDataModule;
import Server.ModuleSessionBeanRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Svenn
 */
public class ModuleManager {

    private ModuleSessionBeanRemote lookupModuleSessionBeanRemote() {
        try {
            Context c = new InitialContext();
                //return (ModuleSessionBeanRemote) c.lookup("java:comp/env/ModuleSessionBean");
            return (ModuleSessionBeanRemote) c.lookup("java:global/SlitServer-ejb/ModuleSessionBean");
            
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    public  String getModuleNameFromId(int id){
        
        return this.lookupModuleSessionBeanRemote().getModuleNameFromId(id);
    }
    
    public ModuleDataModule getModule(int id){
        
        return this.lookupModuleSessionBeanRemote().getModule(1);
    }
    
    public List<ModuleDataModule> getModules(){
        
        return this.lookupModuleSessionBeanRemote().getAllModules();
    }
    
    public boolean storeModule(ModuleDataModule dataModule){
        
        return this.lookupModuleSessionBeanRemote().storeModule(dataModule);
    }
    
    public ModuleDataModule getModuleByName(String moduleName){
        
        return this.lookupModuleSessionBeanRemote().findModuleByName(moduleName);
    }
}
