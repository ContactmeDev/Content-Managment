/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.facade.settings;

import com.cme.entities.ServiceWorkshop;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class ServiceWorkshopFacade extends AbstractFacade<ServiceWorkshop> {

    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiceWorkshopFacade() {
        super(ServiceWorkshop.class);
    }
    
    
         public String  getWorkshop()
    {
       return (String) em.createQuery("SELECT s FROM ServiceWorkshop s WHERE s.swkMsg = :swkMsg and s.swkAddDate LIKE CURRENT_DATE").getSingleResult();
       
    }
}
