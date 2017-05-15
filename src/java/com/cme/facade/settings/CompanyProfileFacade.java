/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade.settings;

import com.cme.entities.CompanyProfile;
import com.cme.facade.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mustafaahmed
 */
@Stateless
public class CompanyProfileFacade extends AbstractFacade<CompanyProfile> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;
    private ListDataModel<CompanyProfile> model = new ListDataModel<CompanyProfile>();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompanyProfileFacade() {
        super(CompanyProfile.class);
    }
    
    public String getCompanyName(String code){
       
        String name = "";
        System.out.println("COOOODEEEEE: "+em.toString());

//        Query query = em.createNamedQuery("CompanyProfile.findByCompCode").setParameter("compCode", code);
        Query query = em.createNamedQuery("CompanyProfile.findAll");
        @SuppressWarnings("unchecked")
        List<CompanyProfile> result = query.getResultList();
        
        if (result.size() == 0 )
        {
            // There is no record means the userid is invalid 
            name = "";
            
        }
        else
        {
            // The result retrieve the userid data and we need to authenticate the password entered 
            // against password in database
            CompanyProfile profile = result.get(0);
            name = profile.getCompName();
        }
        return name;
    }
    
    public DataModel<CompanyProfile> getDataModelTable(){
        model.setWrappedData(findAll());
        return model;
    }

    

}
