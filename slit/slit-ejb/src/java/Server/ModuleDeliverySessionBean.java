/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Common.DataModelConverters;
import Data.ModuleDeliveryDataModel;
import database.Module;
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

    //@EJB
    //private UserModuleSession userModuleSession;

    
    @PersistenceContext(unitName = "slit-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<ModuleDeliveryDataModel> getModuleDeliveries() {
        List<ModuleDeliveryDataModel> dataModuleDeliveries = new ArrayList<ModuleDeliveryDataModel>();
        
        try {
            Query query = em.createNamedQuery("Moduledelivery.findAll", Moduledelivery.class);
            
            List<Moduledelivery> moduleDeliveries = query.getResultList();
            
            for (Moduledelivery moduleDelivery : moduleDeliveries) {
                
                dataModuleDeliveries.add(DataModelConverters.convertModuleDeliveryEntityToDataModel(moduleDelivery));
                //dataModuleDeliveries.add(this.convertModuleDelivery(moduleDelivery));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataModuleDeliveries;
    }
    
    @Override
    public List<ModuleDeliveryDataModel> getWaitingModuleDeliveries() {
        List<ModuleDeliveryDataModel> dataModuleDeliveries = new ArrayList<ModuleDeliveryDataModel>();
        
        try {
            Query query = em.createNamedQuery("Moduledelivery.findByModuleStatus", Moduledelivery.class);
            query.setParameter("moduleStatus", 0);
            
            List<Moduledelivery> moduleDeliveries = query.getResultList();
            
            for (Moduledelivery moduleDelivery : moduleDeliveries) {
                
                dataModuleDeliveries.add(DataModelConverters.convertModuleDeliveryEntityToDataModel(moduleDelivery));
                //dataModuleDeliveries.add(this.convertModuleDelivery(moduleDelivery));
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
    
    public Module getModuleEntityFromId(int id) throws Exception
    {
        return this.em.find(Module.class, id);
    }
    
    @Override
    public boolean storeModuleDelivery(ModuleDeliveryDataModel moduleDelivery) {
        // java.lang.IllegalArgumentException: Object: Server.ModuleDelivery@4400069b is not a known Entity type.
        // Feil objekttype
        Moduledelivery moduleDeliveryEntity = DataModelConverters.convertModuleDeliveryToEntity(moduleDelivery);
        
        try {
            em.persist(moduleDeliveryEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    
}
