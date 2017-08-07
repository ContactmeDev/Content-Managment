/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.facade.settings;

import com.cme.entities.ServiceCategory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class ServiceCategoryFacade extends AbstractFacade<ServiceCategory> {

    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiceCategoryFacade() {
        super(ServiceCategory.class);
    }
    public List<ServiceCategory> getCatList(){
        return em.createNamedQuery("ServiceCategory.findAll").getResultList();
    }
    
//      public List<ServiceCategory> getDDCategoryList(){
//        return em.createNamedQuery("ServiceCategory.findByScatStatus").setParameter("scatStatus", "A").getResultList();
//    }
      
       public ServiceCategory getCategoryName(String catCode){
        
          ServiceCategory result = (ServiceCategory)em.createNamedQuery("ServiceCategory.findByScatStatus").setParameter("scatStatus", catCode).getSingleResult();
        
        
        return result;
    }
    
}
