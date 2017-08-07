/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade.settings;

import com.cme.entities.ServicesUrl;
import com.cme.facade.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hp
 */
@Stateless
public class ServicesUrlFacade extends AbstractFacade<ServicesUrl> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;
    private ListDataModel<ServicesUrl> model = new ListDataModel<ServicesUrl>();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicesUrlFacade() {
        super(ServicesUrl.class);
    }
    
     public List<ServicesUrl> getAppsUList(){
        return em.createNamedQuery("ServicesUrl.findAll").getResultList();
    }
    
    public DataModel<ServicesUrl> getAppsUTable(){
        model.setWrappedData(findAll());
        return model;
    }
    
    public boolean recordExist(String surCode){
        List<ServicesUrl> result = em.createNamedQuery("ServicesUrl.findBySurCode").setParameter("lanCode", surCode).getResultList();
        if (result.size() > 0)
            return true;
        else
            return false;
    } 
    
    public List<ServicesUrl> getDDList(){
        return em.createNamedQuery("ServicesUrl.findBySurStatus").setParameter("surStatus", "A").getResultList();
    }
    


    
}
