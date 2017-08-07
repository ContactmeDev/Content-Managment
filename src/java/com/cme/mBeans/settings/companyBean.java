/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans.settings;

import com.cme.facade.settings.CompanyProfileFacade;
import com.cme.entities.CompanyProfile;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.persistence.Query;

/**
 *
 * @author mustafaahmed
 */
@ManagedBean(name = "company")
@RequestScoped
public class companyBean {
    
    private CompanyProfile profile;
    @EJB
    private CompanyProfileFacade profileFacade;

    /**
     * Creates a new instance of companyBean
     */
    public companyBean() {
        profile = new CompanyProfile();
        profileFacade = new CompanyProfileFacade();
        
    }
    
    public List<CompanyProfile> getAll()throws SQLException{
        List<CompanyProfile> result = profileFacade.findAll();
        return result;
    }
    
    public String getCompName(String comCode){
        return profileFacade.getCompanyName(comCode);
    }
    
    public DataModel<CompanyProfile> getAllDataModel(){
        return profileFacade.getDataModelTable();
    } 
    
}
