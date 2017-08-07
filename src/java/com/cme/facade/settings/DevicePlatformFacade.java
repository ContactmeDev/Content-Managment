/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.facade.settings;

import com.cme.entities.DevicePlatform;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
@Stateless
public class DevicePlatformFacade extends AbstractFacade<DevicePlatform> {

    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;
    private ListDataModel<DevicePlatform> model = new ListDataModel<DevicePlatform>();

    
         
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DevicePlatformFacade() {
        super(DevicePlatform.class);
    }
    
     public List<DevicePlatform> getDevicePlatList(int rowCount){
        return em.createNamedQuery("DevicePlatform.findAll").setMaxResults(rowCount).getResultList();
    }
//     
//       public String getPlatforms(String platf){
//        DevicePlatform result = (DevicePlatform)em.createNamedQuery("DevicePlatform.findByOsId").setParameter("osId", platf).getResultList();
//        
//        return result.getOsName();
//    }
     
    
    public DataModel<DevicePlatform> getPlatformTable(){
        model.setWrappedData(findAll());
        return model;
    }
    
    
     
       public List<DevicePlatform> getListName(){
       return em.createNamedQuery("DevicePlatform.findByOsStatus").setParameter("osStatus", "A").getResultList();
        
        
    }
     public boolean recordExist(String osId){
        List<DevicePlatform> result = em.createNamedQuery("DevicePlatform.findByOsId").setParameter("osId", osId).getResultList();
       if (result.size() > 0)
           return true;
       else
           return false;
   }
     
     public List<DevicePlatform> getDDOsList(){
        return em.createNamedQuery("DevicePlatform.findByOsStatus").setParameter("osStatus", "A").getResultList();
    }
     
        public List<DevicePlatform> getRowCounter(){
        Query query = em.createNamedQuery("DevicePlatform.findAll").setMaxResults(5);
        return query.getResultList();
    
}
        
}
