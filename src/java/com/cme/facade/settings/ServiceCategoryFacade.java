/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade.settings;

import com.cme.entities.ServiceCategory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
/**
 *
 * @author hp
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
    
    public List<ServiceCategory> getDDList(){
        return em.createNamedQuery("ServiceCategory.findByScatStatus").setParameter("scatStatus", "A").getResultList();
    }
}
