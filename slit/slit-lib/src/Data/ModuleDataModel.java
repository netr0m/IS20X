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
public class ModuleDataModel implements Serializable{
    
    private int moduleID;
    
    private String moduleName;
    
    private String moduleSummary;
    
    private String moduleDescription;

    public ModuleDataModel(String moduleName, String moduleSummary, String moduleDescription)
    {
        this.moduleName = moduleName; 
        
        this.moduleSummary = moduleSummary; 
        
        this.moduleDescription = moduleDescription; 
    }
    
    public ModuleDataModel() 
    {
        
    }
    
    public int getID() {
        return moduleID;
    }

    public void setID(int moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleSummary() {
        return moduleSummary;
    }

    public void setModuleSummary(String moduleSummary) {
        this.moduleSummary = moduleSummary;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }
    
    
}