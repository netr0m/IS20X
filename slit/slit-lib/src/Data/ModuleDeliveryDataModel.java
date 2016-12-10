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
    private int moduleID; 
    private String uploadDate; 
    private boolean moduleStatus; 
    private String moduleDelivery; 
    private String moduleFile; 
    private String moduleAssesmentComment; 
    
    public ModuleDeliveryDataModel(int userID, int moduleID, String moduleDelivery, String moduleFile) {
        this.userID = userID;     
        this.moduleID = moduleID;
        this.moduleDelivery = moduleDelivery;     
        this.moduleFile = moduleFile;
    }
    
    public ModuleDeliveryDataModel(int userID, int moduleID, String moduleDelivery) {
        this.userID = userID;
        this.moduleID = moduleID;
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

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
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
    
    public void setModuleFile(String moduleFile) {
        this.moduleFile = moduleFile;
    }

    public String getModuleAssesmentComment() {
        return moduleAssesmentComment;
    }

    public void setModuleAssesmentComment(String moduleAssesmentComment) {
        this.moduleAssesmentComment = moduleAssesmentComment;
    }
    
   
}