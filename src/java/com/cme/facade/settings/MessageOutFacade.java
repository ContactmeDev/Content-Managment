/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.facade.settings;

import com.cme.entities.MessageOut;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class MessageOutFacade extends AbstractFacade<MessageOut> {

    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MessageOutFacade() {
        super(MessageOut.class);
    }
    
    public List<MessageOut> getMessageOutList(int rowCnt){
        return em.createNamedQuery("MessageOut.findAll").setMaxResults(rowCnt).getResultList();
    }
//    
//    public String<MessageOut> getPending()
//    {
//        query q = ((MessageOut)em.createNamedQuery("SELECT Count(m) FROM MessageOut WHERE m.moutDelivered = 'PENDING' and m.moutDelivDate = :moutDelivDate")
//        return ;
////    }
//    
//    public Long  getPendingMessages()
//    {
//       Long count= (Long) em.createQuery("select count(m)  from MessageOut m where m.moutDelivered = 'PENDING'").getSingleResult();
//       return count;
//    }
    public Long  getPendingMessages()
    {
       return (Long) em.createQuery("select count(m)  from MessageOut m where m.moutDelivered = 'PENDING' and m.moutReceiveDatetime LIKE CURRENT_DATE").getSingleResult();
       
    }
    
     public Long  getNotSendMessages()
    {
       return (Long) em.createQuery("select count(m)  from MessageOut m where m.moutStatus = 'NOT SEND' and m.moutReceiveDatetime LIKE CURRENT_DATE").getSingleResult();
       
    }
     
     
      public Long  getToutMessages()
    {
       return (Long) em.createQuery("select count(m)  from MessageOut m where m.moutDelivered = 'TOUT' and m.moutReceiveDatetime LIKE CURRENT_DATE").getSingleResult();
       
    }
      
      
       public Long  getSendMessages()
    {
       return (Long) em.createQuery("select count(m)  from MessageOut m where m.moutStatus = 'SEND' and m.moutReceiveDatetime LIKE CURRENT_DATE").getSingleResult();
       
    }
       
        public Long  getErrorMessages()
    {
       return (Long) em.createQuery("select count(m)  from MessageOut m where m.moutStatus = 'ERROR' and m.moutReceiveDatetime LIKE CURRENT_DATE").getSingleResult();
       
    }
}
