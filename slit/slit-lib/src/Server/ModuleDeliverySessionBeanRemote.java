/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Data.ModuleDeliveryDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Morten
 */
@Remote
public interface ModuleDeliverySessionBeanRemote {
    
    List<ModuleDeliveryDataModel> getModuleDeliveries();
    
    List<ModuleDeliveryDataModel> getWaitingModuleDeliveries();
    
    List<ModuleDeliveryDataModel> getAllModuleDeliveries();
    
    boolean storeModuleDelivery(ModuleDeliveryDataModel moduleDelivery); 
}
