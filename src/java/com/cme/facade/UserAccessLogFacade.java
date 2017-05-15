/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade;

import com.cme.entities.UserAccessLog;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mustafaahmed
 */
@Stateless
public class UserAccessLogFacade extends AbstractFacade<UserAccessLog> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserAccessLogFacade() {
        super(UserAccessLog.class);
    }
    
    public UserAccessLog accessCreate(UserAccessLog access)
    {
        return access;
    }
    
}
