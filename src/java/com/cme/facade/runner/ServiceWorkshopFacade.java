/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade.runner;

import com.cme.entities.ServiceWorkshop;
import com.cme.entities.ServiceMast;
import com.cme.entities.SubserviceMast;
import com.cme.facade.settings.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.Query;

/**
 *
 * @author hp
 */

@Stateless
public class ServiceWorkshopFacade extends AbstractFacade<ServiceWorkshop> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;
     private ListDataModel<ServiceWorkshop> model = new ListDataModel<ServiceWorkshop>();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    


    public ServiceWorkshopFacade() {
        super(ServiceWorkshop.class);
    }
    
    
     public List<ServiceWorkshop> getSwkAllList(){
        return em.createNamedQuery("ServiceWorkshop.findAll").getResultList();
    }
    
    public DataModel<ServiceWorkshop> getSwkAllTable(){
        model.setWrappedData(findAll());
        return model;
    }
    
    
    public List<ServiceWorkshop> getSwkList(){
        return em.createNamedQuery("ServiceWorkshop.findBySwkStatus").setParameter("swkStatus", "N").getResultList();
    }
    
   
    public long getSwkID(String  swkMsg, ServiceMast swkSrv, SubserviceMast  swkSsrv){
        Query query = em.createNamedQuery("ServiceWorkshop.findBySwkMsg");
        query.setParameter("swkMsg", swkMsg);
        query.setParameter("swkSrvCode", swkSrv);
        query.setParameter("swkSsrvCode", swkSsrv);
        ServiceWorkshop result = (ServiceWorkshop)query.getSingleResult();
        
        return result.getSwkId();
    }
    
    public boolean isContentExist(String  swkMsg, ServiceMast swkSrv, SubserviceMast  swkSsrv){
       
        Query query = em.createNamedQuery("ServiceWorkshop.findBySwkMsg");
        query.setParameter("swkMsg", swkMsg);
        query.setParameter("swkSrvCode", swkSrv);
        query.setParameter("swkSsrvCode", swkSsrv);
        List result = query.getResultList();
        if(result.size() > 0)
            return true;
        else
            return false;
        
     }
    
    public long getWorkshopId(){
        return Long.parseLong(em.createQuery("select seq_swk_id.nextval from dual").getSingleResult().toString());
        
        
    }


//    public long getWorkshopId(){
//        return Long.parseLong(em.createQuery("CALL TRG_SERVICE_WORKSHOP_BEFR_INSR").getSingleResult().toString());
//        
//      
//    }
    
    
//    public long getWorkshopId(){
//        result Long.parseLong = em.getNamedNativeQuery("callStoreProcedure").getSingleResult().toString();
//       
//        List result = query.getResultList();
//        for(int i=0; i<result.size(); i++){
//	ServiceWorkshop stock = (ServiceWorkshop)result.get(i);
//	
//      
//    
//}
//   return result;
//    }
    
    
    
}
