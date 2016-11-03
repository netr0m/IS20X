/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userdetails;

import javax.ejb.Stateful;
import database.User;
import auth.LoginAuthenticator;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Morten
 */
@Stateful
public class LoginAuthenticatorBean implements LoginAuthenticator {
    
    @PersistenceContext
    EntityManager eManager;
    private User user;
    
    /** Validate if username and password match
     * @param username Username to check for
     * @param password Password to check for
     * @return Returns true if a match is found, otherwise false.
    */
    @Override
    public boolean authenticate(String username, String password) {
        // Make a query to the server
        List<User> user = eManager.createQuery(""
                + "SELECT u FROM User u WHERE u.username = :username")
                .setParameter("username", username)
                .getResultList();
        try {
            // See if values match
            if (user.get(0).getPassword().equals(password) && user.get(0).getIsAdmin() == 1) {
                this.user = user.get(0);
                System.out.println(user + "successfully validated");
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public void createTestUser() {
        try
        {
            User testUser = new User();
            testUser.setUsername("admin1");
            testUser.setPassword("admin1");
            testUser.setIsAdmin(1);
            
            eManager.persist(testUser);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}