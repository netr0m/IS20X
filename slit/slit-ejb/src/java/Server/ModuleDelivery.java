/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author mortea15
 */
public class ModuleDelivery {
    private int userID;
    private int moduleID;
    private String uploadDate;
    private String moduleDelivery;
    private String moduleFile;
    
    public ModuleDelivery(int userID, int moduleID, String uploadDate, String moduleDelivery, String moduleFile) {
        this.userID = userID;
        this.moduleID = moduleID;
        this.uploadDate = uploadDate;
        this.moduleDelivery = moduleDelivery;
        this.moduleFile = moduleFile;
    }
    
    public ModuleDelivery(int userID, int moduleID, String uploadDate, String moduleDelivery) {
        this.userID = userID;
        this.moduleID = moduleID;
        this.uploadDate = uploadDate;
        this.moduleDelivery = moduleDelivery;
    }
    
    public ModuleDelivery() {
        
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
}
