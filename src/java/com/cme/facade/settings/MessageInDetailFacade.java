/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.facade.settings;

import com.cme.entities.MessageInDetail;
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
public class MessageInDetailFacade extends AbstractFacade<MessageInDetail> {

    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MessageInDetailFacade() {
        super(MessageInDetail.class);
    }
    
     public List<MessageInDetail> getInDetailList(){
        return em.createNamedQuery("MessageInDetail.findAll").getResultList();
    }
     
     
       public List<MessageInDetail> getSelectedRow(String id){
        MessageInDetail result = null;
        Query q = em.createNamedQuery("MessageInDetail.findByDinSmsId").setParameter("dinSmsId", id);
        List<MessageInDetail> res = q.getResultList();
        return res;
    }
    
}
