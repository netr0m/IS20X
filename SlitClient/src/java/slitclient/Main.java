/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import Framework.Managers.ModuleManager;
import Server.ModuleSessionBeanRemote;
import javax.ejb.EJB;

/**
 *
 * @author Svenn
 */
public class Main {

    @EJB
    private static ModuleSessionBeanRemote moduleSessionBean;
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModuleManager modulemanager = new ModuleManager();
        
        System.out.println(modulemanager.getModuleNameFromId(1));
    }
    
}
