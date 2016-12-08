package Server;

import DataModule.UsersDataModel;
import Database.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dahl
 */
@Stateless
public class UsersModuleSession implements UsersModuleSessionRemote {

    @PersistenceContext(unitName = "SlitServer-ejbPU")
    private EntityManager em;

    /**
     * Get user from id. 
     * @param id
     * @return UsersDataModel
     */
    @Override
    public UsersDataModel getUserFromId(int id) {
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
        
        userDataModule.setId(user.getId());
        userDataModule.setPassword(user.getPassword());
        userDataModule.setFirstName(user.getFirstName());
        userDataModule.setLastName(user.getLastName());
        userDataModule.setMail(user.getMail());
        
        return userDataModule; 
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public UsersDataModel loginUser(String mail, String password) {
        UsersDataModel retModule = new UsersDataModel(); 
        
        try 
        {
            Query query = em.createNamedQuery("Users.login", Users.class);
            
            query.setParameter("mail", mail);
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
}