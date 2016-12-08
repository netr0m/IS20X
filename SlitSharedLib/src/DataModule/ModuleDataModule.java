/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModule;

/**
 *
 * @author Svenn
 */
public class ModuleDataModule implements java.io.Serializable{
    
    private int id;
    
    private String moduleName; 
    
    private String moduleSummary; 
    
    private String moduleDescription;
    
    public ModuleDataModule(String moduleName, String moduleSummary, String moduleDescription){
        
        this.moduleName = moduleName;
        this.moduleSummary = moduleSummary;
        this.moduleDescription = moduleDescription;
    }

    public ModuleDataModule(){
        
    }
            
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
