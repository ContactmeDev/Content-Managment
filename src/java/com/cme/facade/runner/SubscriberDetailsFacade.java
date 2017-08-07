/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade.runner;

import com.cme.entities.SubscriberDetails;
import com.cme.entities.ServiceMast;
import com.cme.entities.SubserviceMast;
import com.cme.facade.settings.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hp
 */
@Stateless
public class SubscriberDetailsFacade extends AbstractFacade<SubscriberDetails> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubscriberDetailsFacade() {
        super(SubscriberDetails.class);
    }
    
    public int getSrvCount(ServiceMast srvCode){

        int count = ((Number)em.createQuery("select count(s) from SubscriberDetails s where s.subdSrvCode =:subdSrvCode ").setParameter("subdSrvCode", srvCode)
            
            .getSingleResult()).intValue();
            System.out.println(count);
            return count;
            
    }
     
       public int getSsrvCount(SubserviceMast ssrvCode){

        int count = ((Number)em.createQuery("select count(s) from SubscriberDetails s where s.subdSsrvCode =:subdSsrvCode ").setParameter("subdSsrvCode", ssrvCode)
            
            .getSingleResult()).intValue();
            System.out.println(count);
            return count;
            
    }
       
       public int numberOfSubscribers(String srvCode, String sSrvCode, boolean sSrvExist){
           int ret = 0;
           SubserviceMast subsrv;
           ServiceMast srv;
           if(sSrvExist){
               srv = new ServiceMast();
               subsrv = new SubserviceMast();
               srv.setSrvCode(srvCode);
               subsrv.setSsrvSrvCode(srv);
               subsrv.setSsrvCode(sSrvCode);
               ret = getSsrvCount(subsrv);
           }
           else
           {
               srv = new ServiceMast();
               srv.setSrvCode(srvCode);
               ret = getSrvCount(srv);

           }
           return ret;
       }
 
   
}        

