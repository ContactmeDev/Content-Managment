/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.facade.settings;

import com.cme.entities.ServicesVersionDetail;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
@Stateless
public class ServicesVersionDetailFacade extends AbstractFacade<ServicesVersionDetail> {

    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicesVersionDetailFacade() {
        super(ServicesVersionDetail.class);
    }
    
      public List<ServicesVersionDetail> getDetailList(){
        return em.createNamedQuery("ServicesVersionDetail.findAll").getResultList();
      
    }
    
      public List<ServicesVersionDetail> getSelectedRow(String ved){
        ServicesVersionDetail result = null;
        Query q = em.createNamedQuery("ServicesVersionDetail.findByVedVerId").setParameter("vedVerId", ved);
        List<ServicesVersionDetail> res = q.getResultList();
        return res;
    }
    
}
