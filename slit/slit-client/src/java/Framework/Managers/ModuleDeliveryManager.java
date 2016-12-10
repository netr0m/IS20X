/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Managers;

import Data.ModuleDeliveryDataModel;
import Server.ModuleDeliverySessionBeanRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Morten
 */
public class ModuleDeliveryManager {

    private ModuleDeliverySessionBeanRemote lookupModuleDeliverySessionBeanRemote() {
        try {
            Context c = new InitialContext();
            //return (ModuleSessionBeanRemote) c.lookup("java:comp/env/ModuleSessionBean");
            //return (ModuleDeliverySessionBeanRemote) c.lookup("java:global/slit-ejb/ModuleDeliverySessionBean");
            //return (ModuleDeliverySessionBeanRemote) c.lookup("java:global/slit-ejb/ModuleDeliverySessionBean");
            return (ModuleDeliverySessionBeanRemote) c.lookup("java:global/slit-ejb/ModuleDeliverySessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<ModuleDeliveryDataModel> getModuleDeliveries()
    {
        return this.lookupModuleDeliverySessionBeanRemote().getModuleDeliveries(); 
    }
    
    public boolean storeModuleDelivery(ModuleDeliveryDataModel dataModuleDelivery) {
        return this.lookupModuleDeliverySessionBeanRemote().storeModuleDelivery(dataModuleDelivery);
    }
    
}