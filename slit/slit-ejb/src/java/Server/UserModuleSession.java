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
        userDataModule.setUserrole(user.getUserrole());
        
        return userDataModule; 
    }
    
    @Override
    public UsersDataModel loginUser(String username, String password) {
        UsersDataModel retModule = new UsersDataModel(); 
        
        try 
        { 
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
            Query query = em.createNamedQuery("Users.findByIsStudent", Users.class);
            
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
    
    @Override
    public void updatePassword(UsersDataModel obj, String password) {
        Users user = em.find(Users.class, obj.getUserID());
        System.out.println(user.getUsername());
        user.setPassword(password);
        em.merge(user);
    }
    
}