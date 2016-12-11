/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Morten
 */
public class ModuleDeliveryDataModel implements Serializable {
    private UsersDataModel user;
    private ModuleDataModel module; 

    private Date uploadDate;
    private int moduleStatus; 
    private String moduleDelivery; 
    private String moduleFile; 
    private String moduleAssesmentComment; 
    
    public ModuleDeliveryDataModel(int userID, int moduleID, String moduleDelivery, String moduleFile) {
        //this.user = user;  
        //this.module = module;
        this.moduleDelivery = moduleDelivery;     
        this.moduleFile = moduleFile;
    }
    
    public ModuleDeliveryDataModel(int userID, int moduleID, String moduleDelivery) {
        //this.userID = userID;  
        //this.moduleID = moduleID;
        this.moduleDelivery = moduleDelivery;
    }
    
    public ModuleDeliveryDataModel() {
        
    }
    
    public UsersDataModel getUser() {
        return user;
    }

    public void setUser(UsersDataModel user) {
        this.user = user;
    }
    
    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int isModuleStatus() {
        return moduleStatus;
    }

    public void setModuleStatus(int moduleStatus) {
        this.moduleStatus = moduleStatus;
    }

    public String getModuleDelivery() {
        return moduleDelivery;
    }

    public void setModuleDelivery(String moduleDelivery) {
        this.moduleDelivery = moduleDelivery;
    }
    
    public String getModuleFile() {
        return moduleFile;
    }
    
    public void setModuleFile(String moduleFile) {
        this.moduleFile = moduleFile;
    }

    public String getModuleAssesmentComment() {
        return moduleAssesmentComment;
    }

    public void setModuleAssesmentComment(String moduleAssesmentComment) {
        this.moduleAssesmentComment = moduleAssesmentComment;
    }
    
    public ModuleDataModel getModule() {
        return module;
    }

    public void setModule(ModuleDataModel module) {
        this.module = module;
    }
    
   
}