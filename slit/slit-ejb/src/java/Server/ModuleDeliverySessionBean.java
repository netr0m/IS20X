/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Morten
 */
@Stateless
public class ModuleDeliverySessionBean implements ModuleDeliverySessionBeanRemote {

    @PersistenceContext(unitName = "slit-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    
}
