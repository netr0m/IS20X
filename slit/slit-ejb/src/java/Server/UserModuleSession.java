/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Data.UsersDataModel;
import database.Module;
import database.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Morten
 */
@Stateless
public class UserModuleSession implements UsersModelSessionRemote {

    @PersistenceContext(unitName = "slit-ejbPU")
    private EntityManager em;

    /**
     * Get user from id. 
     * @param id
     * @return UsersDataModel
     */
    @Override
    public UsersDataModel getUserFromID(int id) {
        Users user = em.find(Users.class, id);
        
        return convertUser(user); 
    }
    
    /**
     * Convert a users entity to a UsersDataModule  
     * @param user
     * @return UsersDataModel
     */
    private UsersDataModel convertUser(Users user)
    {
        UsersDataModel userDataModule = new UsersDataModel(); 
        
        userDataModule.setUserID(user.getUserID());
        userDataModule.setUsername(user.getUsername());
        userDataModule.setPassword(user.getPassword());
        userDataModule.setFirstName(user.getFName());
        userDataModule.setLastName(user.getLName());
        userDataModule.setMail(user.getEmail());
        userDataModule.setIsTeacher(user.getIsTeacher());
        
        return userDataModule; 
    }
    
    @Override
    public UsersDataModel loginUser(String username, String password) {
        UsersDataModel retModule = new UsersDataModel(); 
        
        try 
        {
            System.out.println(username + " " + password);
             
            //Query query = em.createQuery("SELECT u FROM Users u WHERE u.username = :username AND u.password = :password");
           
                    
            Query query = em.createNamedQuery("Users.login", Users.class);
            
            query.setParameter("username", username);
            query.setParameter("password", password); 
           
            Users user = (Users)query.getSingleResult();
            
            retModule = this.convertUser(user);
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        return retModule; 
    }
    
    @Override
    public List<UsersDataModel> getAllUsers() 
    {
         List<UsersDataModel> retModule = new ArrayList<UsersDataModel>(); 
        
        try 
        {
            Query query = em.createNamedQuery("Users.findAll", Users.class);
            
            List<Users> users = query.getResultList(); 
            
            for(Users user : users)
            {
                retModule.add(this.convertUser(user)); 
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        return retModule; 
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
    
}
