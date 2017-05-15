/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade;

import com.cme.entities.UserAccessLog;
import com.cme.entities.UserMast;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author mustafaahmed
 */
@Stateless
public class UserMastFacade extends AbstractFacade<UserMast> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;
    private UserMast usrMast;
    private UserAccessLog access;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserMastFacade() {
        super(UserMast.class);
    }

    public UserMast getUsrMast() {
        return usrMast;
    }

    public void setUsrMast(UserMast usrMast) {
        this.usrMast = usrMast;
    }
    
    
    
    public UserMast loginUpdate(UserMast user){
        user.setUsrLastLogin(new Date());
        return em.merge(user);
    
    }
    
    public int logOut(){
        int logOut = 0;
        
        access.setAclLogoutDate(new Date());
        em.merge(access);
        
        return logOut;
    }
    
    public int loginAuthentication(String username, String userpwd, String userIP, String userHost) {
        int AuthResult = 0;
        
        Query query = em.createNamedQuery("UserMast.findByUsrId").setParameter("usrId", username);
        
        @SuppressWarnings("unchecked")
        List<UserMast> result = query.getResultList();
        
        if (result.size() == 0 )
        {
            // There is no record means the userid is invalid 
            AuthResult = 0;
            
        }
        else
        {
            // The result retrieve the userid data and we need to authenticate the password entered 
            // against password in database
            UserMast user = result.get(0);
            String storedPassword = user.getUsrPwd();
            String usrStatus = user.getUsrStatus();
            
            if (storedPassword.isEmpty())
                storedPassword = "*#$@#";
            if (usrStatus.isEmpty())
                usrStatus = "U";
            
            
            if (usrStatus.equals("N"))
            {
                //This User is not active yet
                AuthResult = -2;
            }
            else if (usrStatus.equals("D"))
            {
                //This User has been deleted
                AuthResult = -3;
            }
            else if (usrStatus.equals("S"))
            {
                //This User has been Suspended
                AuthResult = -4;
            }
            else if (userpwd.equals(storedPassword.trim()) && usrStatus.equals("A"))
            {
                // The Password is correct
                AuthResult = 1;
                loginUpdate(user);
                setUsrMast(user);
                
                //Set the User Access log table
                access = new UserAccessLog();
                access.setAclUsrId(user);
                access.setAclLoginDate(new Date());
                access.setAclHostname(userHost);
                access.setAclIpadd(userIP);
                em.persist(access);
                

                
            }
            
            else
            {
                // The Password is not correct
                AuthResult = -1;
                
            }
            
        }
        return AuthResult;
    }
    
}
