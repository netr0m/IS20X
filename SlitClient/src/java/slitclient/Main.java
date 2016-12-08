/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;



import DataModule.ModuleDataModule;
import Framework.Managers.ModuleManager;
import Server.ModuleSessionBeanRemote;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Svenn
 */
public class Main {

  
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ModuleManager moduleManager = new ModuleManager();
        
        ModuleDataModule module = moduleManager.getModule(1);
        
        System.out.println(module.getId());
        System.out.println(module.getModuleDescription());
        System.out.println(module.getModuleName());
        System.out.println(module.getModuleSummary());
        
        List<ModuleDataModule> modules = moduleManager.getModules();
        
        for(ModuleDataModule singleModule: modules){
           System.out.println(singleModule.getId());
           System.out.println(singleModule.getModuleDescription());
          
        }
        
        ModuleDataModule dataModule = new ModuleDataModule("Module 5", "This is a module", "You are suppose to write some java");
        
        moduleManager.storeModule(dataModule);
        
        System.out.println();
        
        ModuleDataModule moduleByName = moduleManager.getModuleByName("Module 3");
        
        System.out.println(moduleByName.getModuleName());
    }
    
}
