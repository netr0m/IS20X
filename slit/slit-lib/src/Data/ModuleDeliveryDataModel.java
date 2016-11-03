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
    
    private String userID; 
    
    private String moduleID; 
    
    private String uploadDate;  
    
    private boolean moduleStatus; 
    
    private String moduleDelivery; 
    
    private String moduleAssesmentComment; 

    public String getUserID() {
        return userID;
    }

    public void setUserId(String userID) {
        this.userID = userID;
    }

    public String getModuleID() {
        return moduleID;
    }

    public void setModuleId(String moduleID) {
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

    public String getModuleAssesmentComment() {
        return moduleAssesmentComment;
    }

    public void setModuleAssesmentComment(String moduleAssesmentComment) {
        this.moduleAssesmentComment = moduleAssesmentComment;
    }
    
   
}