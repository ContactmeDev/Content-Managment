/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.facade.settings;

import com.cme.entities.OperatorMast;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class OperatorMastFacade extends AbstractFacade<OperatorMast> {

    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperatorMastFacade() {
        super(OperatorMast.class);
    }
    
      public List<OperatorMast> getOprList(){
        return em.createNamedQuery("OperatorMast.findAll").getResultList();
    }
    
//        public List<OperatorMast> getDDOperatorList( String opr){
//        return em.createNamedQuery("OperatorMast.findAll").setParameter("oprCode", opr).getResultList();
//    }
   
    
}
