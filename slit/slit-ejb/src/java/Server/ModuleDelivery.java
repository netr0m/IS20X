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
    private String username;
    private String moduleName;
    private String uploadDate;
    private String moduleDelivery;
    private String moduleFile;
    
    public ModuleDelivery(String username, String moduleName, String uploadDate, String moduleDelivery, String moduleFile) {
        this.username = username;
        this.moduleName = moduleName;
        this.uploadDate = uploadDate;
        this.moduleDelivery = moduleDelivery;
        this.moduleFile = moduleFile;
    }
    
    public ModuleDelivery(String username, String moduleName, String uploadDate, String moduleDelivery) {
        this.username = username;
        this.moduleName = moduleName;
        this.uploadDate = uploadDate;
        this.moduleDelivery = moduleDelivery;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getModuleName() {
        return moduleName;
    }
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
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
