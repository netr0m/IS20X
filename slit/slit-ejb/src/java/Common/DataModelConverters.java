/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Data.ModuleDataModel;
import Data.ModuleDeliveryDataModel;
import Data.UsersDataModel;
import database.Module;
import database.Moduledelivery;
import database.Users;
import java.util.Date;

/**
 *
 * @author mortea15
 */
public class DataModelConverters {
    
    public static UsersDataModel convertUserEntityToDataModel(Users user) 
    {
        UsersDataModel userDataModel = new UsersDataModel(); 
        
        userDataModel.setFName(user.getFName());
        userDataModel.setLName(user.getLName());
        userDataModel.setMail(user.getEmail());
        userDataModel.setPassword(user.getPassword());
        userDataModel.setUserID(user.getUserID());
        userDataModel.setUsername(user.getUsername());
        userDataModel.setUserrole(user.getUserrole());
        
        return userDataModel; 
    }
    
    public static Users convertUserDataModelToEntity(UsersDataModel usersDataModel)
    {
        Users userEntity = new Users(); 
        
        userEntity.setUserID(usersDataModel.getUserID());
        userEntity.setFName(usersDataModel.getFName());
        userEntity.setLName(usersDataModel.getLName());
        userEntity.setEmail(usersDataModel.getEmail());
        userEntity.setPassword(usersDataModel.getPassword());
        userEntity.setUsername(usersDataModel.getUsername());
        userEntity.setUserrole(usersDataModel.getUserrole());
        
        return userEntity; 
    }
    
    public static Module convertModuleDataModelToEntity(ModuleDataModel moduleDataModel)
    {
        Module entityModule = new Module();
        
        entityModule.setModuleID(moduleDataModel.getID());
        entityModule.setModuleName(moduleDataModel.getModuleName());
        if (moduleDataModel.getModuleDescription() != null) {
                entityModule.setModuleDescription(moduleDataModel.getModuleDescription());
        }
        if (moduleDataModel.getModuleSummary() != null) {
                entityModule.setModuleSummary(moduleDataModel.getModuleSummary());
        }
        
        return entityModule; 
    }
    
    public static Moduledelivery convertModuleDeliveryToEntity(ModuleDeliveryDataModel moduleDelivery) {
        try 
        {
            Moduledelivery moduledeliveryEntity = new Moduledelivery();
       
            moduledeliveryEntity.setUserID(DataModelConverters.convertUserDataModelToEntity(moduleDelivery.getUser()));
            moduledeliveryEntity.setModuleID(DataModelConverters.convertModuleDataModelToEntity(moduleDelivery.getModule()));
            moduledeliveryEntity.setModuleDelivery(moduleDelivery.getModuleDelivery());
            moduledeliveryEntity.setModuleFile(moduleDelivery.getModuleFile());
            moduledeliveryEntity.setModuleStatus(0);
            moduledeliveryEntity.setUploadDate(new Date());
            
            return moduledeliveryEntity;
            
        }catch(Exception e) 
        {
            e.printStackTrace();
        }
        
        return null; 
    }
    
    /**
     * Convert Entity moduleDelivery to a ModuleDeliveryDataModel
     * @param moduleDelivery
     * @return moduleDeliveryDataModel
     */
    public static ModuleDataModel convertModuleEntityToDataModel(Module module)
    {
        ModuleDataModel moduleDataModel = new ModuleDataModel();
        
        moduleDataModel.setID(module.getModuleID());
        moduleDataModel.setModuleName(module.getModuleName());
        if (module.getModuleDescription() != null) {
            moduleDataModel.setModuleDescription(module.getModuleDescription());
        }
        if (module.getModuleSummary() != null) {
            moduleDataModel.setModuleSummary(module.getModuleSummary());
        }

        return moduleDataModel; 
    }
    
    public static ModuleDeliveryDataModel convertModuleDeliveryEntityToDataModel(Moduledelivery delivery)
    {
        ModuleDeliveryDataModel moduleDeliveryDataModel = new ModuleDeliveryDataModel(); 
        
        moduleDeliveryDataModel.setModule(DataModelConverters.convertModuleEntityToDataModel(delivery.getModuleID()));
        moduleDeliveryDataModel.setModuleStatus(delivery.getModuleStatus());
        moduleDeliveryDataModel.setUploadDate(delivery.getUploadDate());
        moduleDeliveryDataModel.setUser(DataModelConverters.convertUserEntityToDataModel(delivery.getUserID()));
        if (delivery.getModuleAssesmentComment() != null) {
            moduleDeliveryDataModel.setModuleAssesmentComment(delivery.getModuleAssesmentComment());
        }
        if (delivery.getModuleDelivery() != null) {
            moduleDeliveryDataModel.setModuleDelivery(delivery.getModuleDelivery());
        }
        if (delivery.getModuleFile() != null) {
            moduleDeliveryDataModel.setModuleFile(delivery.getModuleFile());
        }
        
        return moduleDeliveryDataModel; 
    }
    
    
    
}
