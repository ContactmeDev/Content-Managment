/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade.settings;

import com.cme.entities.LanguageMast;
import com.cme.entities.ServiceType;
import com.cme.facade.AbstractFacade;
import com.cme.mBeans.common.LocalChanger;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author hp
 */
@Stateless
public class ServiceTypeFacade extends AbstractFacade<ServiceType> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;
    private ListDataModel<ServiceType> model = new ListDataModel<ServiceType>();
    @ManagedProperty(value="#{localChanger}") 
    LocalChanger localChanger;
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiceTypeFacade() {
        super(ServiceType.class);
    }
    public List<ServiceType> getSrviceList(){
        return em.createNamedQuery("ServiceType.findAll").getResultList();
    }
    
    public DataModel<ServiceType> getServiceTable(){
        model.setWrappedData(findAll());
        return model;
    }
    public boolean recordExist(String srtCode){
        List<ServiceType> result = em.createNamedQuery("ServiceType.findBySrtCode").setParameter("srtCode", srtCode).getResultList();
        if (result.size() > 0)
            return true;
        else
            return false;
    } 
    
    public List<ServiceType> getDDList(){
        return em.createNamedQuery("ServiceType.findBySrtStatus").setParameter("srtStatus", "A").getResultList();
    }
    
}
