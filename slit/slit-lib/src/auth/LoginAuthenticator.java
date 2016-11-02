/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import javax.ejb.Remote;


/**
 *
 * @author Morten
 */
@Remote
public interface LoginAuthenticator {
    boolean authenticate(String username, String password);
    
    
}
