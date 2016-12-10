/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Data.ModuleDeliveryDataModel;
import database.Moduledelivery;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Morten
 */
@Stateless
public class ModuleDeliverySessionBean implements ModuleDeliverySessionBeanRemote {

    @PersistenceContext(unitName = "slit-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<ModuleDeliveryDataModel> getModuleDeliveries() {
        List<ModuleDeliveryDataModel> dataModuleDeliveries = new ArrayList<ModuleDeliveryDataModel>();
        
        try {
            Query query = em.createNamedQuery("ModuleDelivery.findAll", ModuleDelivery.class);
            
            List<ModuleDelivery> moduleDeliveries = query.getResultList();
            
            for (ModuleDelivery moduleDelivery : moduleDeliveries) {
                dataModuleDeliveries.add(this.convertModuleDelivery(moduleDelivery));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataModuleDeliveries;
    }

    @Override
    public List<ModuleDeliveryDataModel> getAllModuleDeliveries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * Convert Entity moduleDelivery to a ModuleDeliveryDataModel
     * @param moduleDelivery
     * @return moduleDeliveryDataModel
     */
    public ModuleDeliveryDataModel convertModuleDelivery(ModuleDelivery moduleDelivery) {
        ModuleDeliveryDataModel moduleDeliveryDataModel = new ModuleDeliveryDataModel();
        
        moduleDeliveryDataModel.setUserID(moduleDelivery.getUserID());
        moduleDeliveryDataModel.setModuleDelivery(moduleDelivery.getModuleDelivery());
        moduleDeliveryDataModel.setModuleFile(moduleDelivery.getModuleFile());
        
        return moduleDeliveryDataModel;
    }

    private ModuleDelivery convertToModuleDeliveryEntity(ModuleDeliveryDataModel moduleDelivery) {
        ModuleDelivery moduleDeliveryDataModel = new ModuleDelivery();
        
        moduleDeliveryDataModel.setUserID(moduleDelivery.getUserID());
        moduleDeliveryDataModel.setUserID(moduleDelivery.getUserID());
        moduleDeliveryDataModel.setModuleID(moduleDelivery.getModuleID());
        moduleDeliveryDataModel.setModuleDelivery(moduleDelivery.getModuleDelivery());
        moduleDeliveryDataModel.setModuleFile(moduleDelivery.getModuleFile());
        
        return moduleDeliveryDataModel;
    }
    
    @Override
    public boolean storeModuleDelivery(ModuleDeliveryDataModel moduleDelivery) {
        // java.lang.IllegalArgumentException: Object: Server.ModuleDelivery@4400069b is not a known Entity type.
        // Feil objekttype
        ModuleDelivery moduleDeliveryEntity = this.convertToModuleDeliveryEntity(moduleDelivery);
        
        try {
            em.persist(moduleDeliveryEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    
}
