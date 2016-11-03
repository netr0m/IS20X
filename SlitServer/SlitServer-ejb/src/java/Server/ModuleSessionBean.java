/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import javax.ejb.Stateless;

/**
 *
 * @author Svenn
 */
@Stateless
public class ModuleSessionBean implements ModuleSessionBeanRemote {

    @Override
    public String getModuleName() {
        return "Module 3";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
