/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.facade.settings;

import com.cme.entities.ServicesVersion;
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
public class ServicesVersionFacade extends AbstractFacade<ServicesVersion> {

    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicesVersionFacade() {
        super(ServicesVersion.class);
    }
    
    public List<ServicesVersion> getCatList(){
        return em.createNamedQuery("ServicesVersion.findAll").getResultList();
      
    }
    
//     public String getServiceVersions(String verd){
//        ServicesVersion result = (ServicesVersion)em.createNamedQuery("ServicesVersion.dDList").setParameter("verId", verd).getResultList();
//        
//        return result.getVerId();
//    }
     
//   public List<ServicesVersion> getPortalServices(String verd){
//        List<ServicesVersion> result;
//        ServicesVersion verStatus = new ServicesVersion("Y");
//        
//        Query q = em.createNamedQuery("ServicesVersion.dDList");
//        q.setParameter("verId", verd);
//        q.setParameter("ssrvSrtCode", verStatus);
//        return q.getResultList();
//    }
//    
      public List<ServicesVersion> getversionId(){
        List<ServicesVersion> result;
        Query q = em.createNamedQuery("ServicesVersion.findByVerStatus");
//        q.setParameter("verId", id);
        q.setParameter("verStatus", "A");
       
        return q.getResultList();
    }
      
       public List<ServicesVersion> getDDVersionsList(){
        return em.createNamedQuery("ServicesVersion.findByVerStatus").setParameter("verStatus", "A").getResultList();
    }
}
