/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;

/**
 *
 * @author Morten
 */
public class ModuleDeliveryDataModel implements Serializable {
    
    private int userID; 
    
    private String modulename; 
    
    private String uploadDate;  
    
    private boolean moduleStatus; 
    
    private String moduleDelivery; 
    
    private String moduleFile;
    
    private String moduleAssesmentComment; 
    
    public ModuleDeliveryDataModel(int userID, String modulename, String moduleDelivery, String moduleFile) {
        this.userID = userID;
        
        this.modulename = modulename;
        
        this.moduleDelivery = moduleDelivery;
        
        this.moduleFile = moduleFile;
    }
    
    public ModuleDeliveryDataModel(int userID, String modulename, String moduleDelivery) {
        this.userID = userID;
        this.modulename = modulename;
        this.moduleDelivery = moduleDelivery;
    }
    
    public ModuleDeliveryDataModel() {
        
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public boolean isModuleStatus() {
        return moduleStatus;
    }

    public void setModuleStatus(boolean moduleStatus) {
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
    
    public void setModuleFile(String file) {
        this.moduleFile = moduleFile;
    }

    public String getModuleAssesmentComment() {
        return moduleAssesmentComment;
    }

    public void setModuleAssesmentComment(String moduleAssesmentComment) {
        this.moduleAssesmentComment = moduleAssesmentComment;
    }
    
   
}