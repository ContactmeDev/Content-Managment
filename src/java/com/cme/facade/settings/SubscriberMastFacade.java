/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade.settings;

import com.cme.entities.SubscriberMast;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hp
 */
@Stateless
public class SubscriberMastFacade extends AbstractFacade<SubscriberMast> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubscriberMastFacade() {
        super(SubscriberMast.class);
    }
    
}
