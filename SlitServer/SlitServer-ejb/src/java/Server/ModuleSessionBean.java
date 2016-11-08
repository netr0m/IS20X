/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Database.Module;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Svenn
 */
@Stateless
public class ModuleSessionBean implements ModuleSessionBeanRemote {

    @PersistenceContext(unitName = "SlitServer-ejbPU")
    private EntityManager em;

    @Override
    public String getModuleName() {
        return "Module 3";
    }
    
    @Override
    public String getModuleNameFromId(int id){
        
        Module module = em.find(Module.class, id);
        
        return module.getModuleName();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
