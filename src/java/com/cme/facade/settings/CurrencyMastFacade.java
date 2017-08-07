/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade.settings;

import com.cme.entities.CurrencyMast;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.cme.facade.AbstractFacade;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.Query;

/**
 *
 * @author hp
 */

@Stateless
public class CurrencyMastFacade extends AbstractFacade<CurrencyMast> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;
    private ListDataModel<CurrencyMast> model = new ListDataModel<CurrencyMast>();
  

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CurrencyMastFacade() {
        super(CurrencyMast.class);
    }
    public List<CurrencyMast> getCurrList(){
        return em.createNamedQuery("CurrencyMast.findAll").getResultList();
    }
    
    public DataModel<CurrencyMast> getCurrencyTable(){
        model.setWrappedData(findAll());
        return model;
    }
    

    public String getList(String n){
        CurrencyMast result = (CurrencyMast)em.createNamedQuery("CurrencyMast.findByCurrStatus").setParameter("currStatus", "A").getResultList();
       
        return result.getCurrCode();
        
    }
    
    public List<CurrencyMast> getByStatus(String sts){
        CurrencyMast result = null;
        Query q = em.createNamedQuery("CurrencyMast.findByCurrStatus").setParameter("currStatus", "A");
        List<CurrencyMast> res = q.getResultList();
        return res;
    }
    
    public boolean recordExist(String currCode){
        List<CurrencyMast> result = em.createNamedQuery("CurrencyMast.findByCurrCode").setParameter("currCode", currCode).getResultList();
        if (result.size() > 0)
            return true;
        else
            return false;
    }
     
    public List<CurrencyMast> getDDList(){
        return em.createNamedQuery("CurrencyMast.findByCurrStatus").setParameter("currStatus", "A").getResultList();
    }
}
