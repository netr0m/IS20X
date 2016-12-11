/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Common.DataModelConverters;
import Data.ModuleDataModel;
import database.Module;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author InWhi
 */
@Stateless
public class ModuleSessionBean implements ModuleSessionBeanRemote {

    @PersistenceContext(unitName = "slit-ejbPU")
    private EntityManager em;
    
    /**
     * Get a module name by ID
     * @param ID The ID to look up
     * @return The name of the module that matched
     */
    /**
     * Get a module name by id.
     * @param id
     * @return 
     */
    @Override
    public ModuleDataModel getModuleByID(int id) {
        try {
            Module module = em.find(Module.class, id);
            return DataModelConverters.convertModuleEntityToDataModel(module);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get all the modules in the database. 
     * @return List<ModuleDataModel> 
     */
    @Override
    public List<ModuleDataModel> getModules()
    {
        
        List<ModuleDataModel> dataModules = new ArrayList<ModuleDataModel>(); 

        try 
        {
            Query query = em.createNamedQuery("Module.findAll", Module.class); 
            
            List<Module> modules = query.getResultList();
            
            for(Module module : modules) 
            {
                dataModules.add(DataModelConverters.convertModuleEntityToDataModel(module)); 
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        return dataModules;
    }
    
    /**
     * Get all the modules with only the names. 
     * @return List<String> 
     */
    @Override
    public List<String> getModuleNames()
    {
        List<String> dataModules = new ArrayList<String>(); 
        
        try 
        {
            Query query = em.createNamedQuery("Module.findAll", Module.class);
            
            List<Module> modules = query.getResultList();
            
  
            for(Module module : modules) 
            {
                dataModules.add(module.getModuleName()); 
            }
            
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        
        return dataModules; 
    }
   
    /**
     * Convert a ModuleDataModel to an entity.
     * @param module
     * @return Module
     */
    private Module convertToModuleEntity(ModuleDataModel module) 
    {
        Module moduleEntity = new Module(); 
        
        moduleEntity.setModuleID(module.getID());
        moduleEntity.setModuleDescription(module.getModuleDescription());
        moduleEntity.setModuleName(module.getModuleName());
        moduleEntity.setModuleSummary(module.getModuleSummary());
        
        return moduleEntity; 
    }
    
    /**
     * Get module name from id. 
     * @param id
     * @return String
     */
    @Override
    public String getModuleNameFromID(int ID) 
    {
        Module module = em.find(Module.class, ID);
        
        return module.getModuleName(); 
    }
    
    /**
     * Get module from id. 
     * @param id
     * @return ModuleDataModel
     */
    @Override 
    public ModuleDataModel getModule(int ID) 
    {
        Module module = em.find(Module.class, ID);
        
        return DataModelConverters.convertModuleEntityToDataModel(module); 
    }
    
    /**
     * Get all modules in the database. 
     * @return List<ModuleDataModel>
     */
    @Override
    public List<ModuleDataModel> getAllModules() 
    {
        
        List<ModuleDataModel> moduleList = new ArrayList<ModuleDataModel>();
        
        try 
        {
            Query query = em.createNamedQuery("Module.findAll", Module.class); 
            
            List<Module> modules = query.getResultList();
            
            for(Module module : modules) 
            {
                moduleList.add(DataModelConverters.convertModuleEntityToDataModel(module));
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        
        return moduleList; 
    }

    /**
     * Find
     * @param moduleName
     * @return ModuleDataModel
     */
    @Override 
    public ModuleDataModel findModuleByName(String moduleName)
    {
        ModuleDataModel retModule = new ModuleDataModel(); 
        
        try 
        {
            Query query = em.createNamedQuery("Module.findByModuleName", Module.class);
            
            query.setParameter("moduleName", moduleName);
            
            Module module = (Module)query.getSingleResult();
            
            retModule = DataModelConverters.convertModuleEntityToDataModel(module);
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        return retModule; 
    }
    
    /**
     * Store a module to the database. 
     * @param module
     * @return boolean 
     */
    @Override
    public boolean storeModule(ModuleDataModel module)
    {
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