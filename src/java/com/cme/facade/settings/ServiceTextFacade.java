/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade.settings;

import com.cme.entities.ServiceText;
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
public class ServiceTextFacade extends AbstractFacade<ServiceText> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;
    private ListDataModel<ServiceText> model = new ListDataModel<ServiceText>();
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiceTextFacade() {
        super(ServiceText.class);
    }
    
    public List<ServiceText> getSrvTxtList(){
        return em.createNamedQuery("ServiceText.findAll").getResultList();
    }
    
    public DataModel<ServiceText> getSrvTextTable(){
        model.setWrappedData(findAll());
        return model;
    }
    

    public String getList(String n){
        ServiceText result = (ServiceText)em.createNamedQuery("ServiceText.findByTxtStatus").setParameter("txtStatus", "A").getResultList();
       
        return result.getTxtCode();
        
    }
    
    public List<ServiceText> getByStatus(String sts){
        ServiceText result = null;
        Query q = em.createNamedQuery("ServiceText.findByTxtStatus").setParameter("txtStatus", "A");
        List<ServiceText> res = q.getResultList();
        return res;
    }
    
    public boolean recordExist(String txtCode){
        List<ServiceText> result = em.createNamedQuery("ServiceText.findByTxtCode").setParameter("txtCode", txtCode).getResultList();
        if (result.size() > 0)
            return true;
        else
            return false;
    }
     
    public List<ServiceText> getDDList(){
        return em.createNamedQuery("ServiceText.findByTxtStatus").setParameter("txtStatus", "A").getResultList();
    }
    
}
