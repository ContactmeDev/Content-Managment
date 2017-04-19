/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade.settings;

import com.cme.entities.LanguageMast;
import com.cme.facade.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mustafaahmed
 */
@Stateless
public class LanguageMastFacade extends AbstractFacade<LanguageMast> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;
    private ListDataModel<LanguageMast> model = new ListDataModel<LanguageMast>();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LanguageMastFacade() {
        super(LanguageMast.class);
    }
    
    public List<LanguageMast> getLangList(){
        return em.createNamedQuery("LanguageMast.findAll").getResultList();
    }
    
    public DataModel<LanguageMast> getLanguageTable(){
        model.setWrappedData(findAll());
        return model;
    }
    
    
}
