/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModule.ModuleDataModule;
import Database.Module;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Svenn
 */
@Stateless
public class ModuleSessionBean implements ModuleSessionBeanRemote {

    @PersistenceContext(unitName = "SlitServer-ejbPU")
    private EntityManager em;

    @Override
    public String getModuleName() {
        return "Module 3";
    }
    
    @Override
    public String getModuleNameFromId(int id){
        
        Module module = em.find(Module.class, id);
        
        return module.getModuleName();
    }
    
    @Override
    public ModuleDataModule getModule(int id){
        
        Module module = em.find(Module.class, id);
        
        return this.convertModule(module);
    }
    @Override
    public List<ModuleDataModule> getAllModules() {
        
        List<ModuleDataModule> moduleList = new ArrayList<ModuleDataModule>();
        
        try{
            Query query = em.createNamedQuery("Module.findAll", Module.class);
            
            List<Module> modules = query.getResultList();
            
            for(Module module : modules){
                moduleList.add(this.convertModule(module));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return moduleList;
    }

   
    private ModuleDataModule convertModule(Module module){
        
        ModuleDataModule moduleDataModule = new ModuleDataModule();
        
        moduleDataModule.setId(module.getId());
        moduleDataModule.setModuleDescription(module.getModuleDescription());
        moduleDataModule.setModuleName(module.getModuleName());
        moduleDataModule.setModuleSummary(module.getModuleSummary());
        
        return moduleDataModule;
              
    }
    
     private Module convertToModuleEntity(ModuleDataModule module){
        
        Module moduleDataModule = new Module();
        
        moduleDataModule.setId(module.getId());
        moduleDataModule.setModuleDescription(module.getModuleDescription());
        moduleDataModule.setModuleName(module.getModuleName());
        moduleDataModule.setModuleSummary(module.getModuleSummary());
        
        return moduleDataModule;
     }
     
     @Override
     public ModuleDataModule findModuleByName(String moduleName){
         
         ModuleDataModule retModule = new ModuleDataModule();
         
         try{
             Query query = em.createNamedQuery("Module.findByModuleName", Module.class);
             
             query.setParameter("moduleName", moduleName);
             
             Module module = (Module)query.getSingleResult();
             
             retModule = this.convertModule(module);
         }
         catch(Exception e) {
             
             e.printStackTrace();
             
         }
         return retModule;
     }
    
    
    @Override
    public boolean storeModule(ModuleDataModule module){
        
        Module moduleEntity = this.convertToModuleEntity(module);
        
        try
        {
        em.persist(moduleEntity);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
