/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade.settings;

import com.cme.entities.ServiceMast;
import com.cme.entities.SubserviceMast;
import com.cme.facade.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hp
 */
@Stateless
public class SubserviceMastFacade extends AbstractFacade<SubserviceMast> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;
    private ListDataModel<SubserviceMast> model = new ListDataModel<SubserviceMast>();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubserviceMastFacade() {
        super(SubserviceMast.class);
    }
    public DataModel<SubserviceMast> getSubserviceTable(){
        model.setWrappedData(findAll());
        return model;
    }
    
    public List<SubserviceMast> getSubserviceLists(ServiceMast sr){
        
        Query q = em.createNamedQuery("SubserviceMast.findBySsrvSrvCode").setParameter("ssrvSrvCode", sr);
        List<SubserviceMast> result = q.getResultList();
        return result;
    }
    public boolean recordExist(String ssrvCode){
        List<SubserviceMast> result = em.createNamedQuery("SubserviceMast.findBySsrvCode").setParameter("ssrvCode", ssrvCode).getResultList();
        if (result.size() > 0)
            return true;
        else
            return false;
    } 
    
    public List<SubserviceMast> getDDList(){
        return em.createNamedQuery("SubserviceMast.findBySsrvStatus").setParameter("ssrvStatus", "A").getResultList();
    }
    
    public String getSender(String ssrvCode){
        SubserviceMast result = (SubserviceMast)em.createNamedQuery("SubserviceMast.findBySsrvCode").setParameter("ssrvCode", ssrvCode).getSingleResult();
        
        return result.getSsrvSenderId();
    }
    
    public SubserviceMast getSServName(String ssrvCode){
        
        SubserviceMast result = (SubserviceMast)em.createNamedQuery("SubserviceMast.findBySsrvCode").setParameter("ssrvCode", ssrvCode).getSingleResult();
        return result;
    }
    public String getSserviceName(String ssrv, String lang){
        String srvName = "-";
        if(ssrv != null && !ssrv.equals(""))
        {
            SubserviceMast result = (SubserviceMast)em.createNamedQuery("SubserviceMast.findBySsrvCode").setParameter("ssrvCode", ssrv).getSingleResult();
            if(lang.equals("LTR"))
                srvName =  result.getSsrvNameEn();
            else
                srvName =  result.getSsrvNameAr();
        }
        return srvName;
        
    }
}
