/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade.settings;

import com.cme.entities.ServiceMast;
import javax.persistence.Query;
import com.cme.entities.ServiceType;
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
public class ServiceMastFacade extends AbstractFacade<ServiceMast> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;
    private ListDataModel<ServiceMast> model = new ListDataModel<ServiceMast>();


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiceMastFacade() {
        super(ServiceMast.class);
        
    }
    public List<ServiceMast> getServList(){
        return em.createNamedQuery("ServiceMast.findAll").getResultList();
    }
    
    public DataModel<ServiceMast> getServiceTable(){
        model.setWrappedData(findAll());
        return model;
    }
    public List<ServiceMast> getSubservice(String sr){
        
        Query q = em.createNamedQuery("ServiceMast.findBySrvSubService").setParameter("srvSubService", sr);
        List<ServiceMast> result= q.getResultList();
        return result;
    }
    
    public ServiceMast getServName(String srvCode){
        
          ServiceMast result = (ServiceMast)em.createNamedQuery("ServiceMast.findBySrvCode").setParameter("srvCode", srvCode).getSingleResult();
        
        
        return result;
    }
    
    public String getServiceName(String srv, String lang){
        String srvName = "-";
        if(srv != null && !srv.equals(""))
        {
            ServiceMast result = (ServiceMast)em.createNamedQuery("ServiceMast.findBySrvCode").setParameter("srvCode", srv).getSingleResult();
            if(lang.equals("LTR"))
                srvName = result.getSrvNameEn();
            else
                srvName = result.getSrvNameAr();
        }
        
        return srvName;
    }
    
    public boolean recordExist(String srvCode){
        List<ServiceMast> result = em.createNamedQuery("ServiceMast.findBySrvCode").setParameter("srvCode", srvCode).getResultList();
        if (result.size() > 0)
            return true;
        else
            return false;
    } 
//    public List<ServiceMast> getDDList(){
//        return em.createNamedQuery("ServiceMast.findBySrvStatus").setParameter("srvStatus", "A").getResultList();
//    }
    
    public List<ServiceMast> getDDList(){
        ServiceType ssrType = new ServiceType("01");
        Query q = em.createNamedQuery("ServiceMast.SMSServices");
           q.setParameter("srvStatus","A");
           q.setParameter("srvSrtCode", ssrType);
        return q.getResultList();
    }
    
    public String getSender(String srvCode){
        ServiceMast result = (ServiceMast)em.createNamedQuery("ServiceMast.findBySrvCode").setParameter("srvCode", srvCode).getSingleResult();
        
        return result.getSrvSenderId();
    }
    
    public boolean isSubserviceExist(String serviceCode){
        boolean subExist = false;
      
        if(!serviceCode.isEmpty() && serviceCode != null && ! serviceCode.equals("")){
            
            ServiceMast result = (ServiceMast)em.createNamedQuery("ServiceMast.findBySrvCode").setParameter("srvCode", serviceCode).getSingleResult();
            
            if(result.getSrvSubService().equals("Y"))
                subExist = true;
            else
                subExist = false;
        }
        return subExist;
    }
    
    
}
