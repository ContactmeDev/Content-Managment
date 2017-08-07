/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.facade.settings;

import com.cme.entities.MessageIn;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class MessageInFacade extends AbstractFacade<MessageIn> {

    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MessageInFacade() {
        super(MessageIn.class);
    }
    
    
    public List<MessageIn> getMessageInList(int rowCnt){
       return em.createNamedQuery("MessageIn.findAll").setMaxResults(rowCnt).getResultList();
    }
}
