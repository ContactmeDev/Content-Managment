package com.cme.mBeans.runner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.cme.entities.ServiceMast;
import com.cme.entities.SubscriberDetails;
import com.cme.entities.SubserviceMast;
import com.cme.facade.settings.ServiceMastFacade;
import com.cme.facade.runner.SubscriberDetailsFacade;
import com.cme.facade.settings.SubserviceMastFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author hp
 */
@ManagedBean(name="subd")
@ViewScoped
public class SubscriberDetailsBean implements Serializable{
    
@EJB
private SubserviceMastFacade ssrvSession;
private SubserviceMast ssrvRecord;
 
@EJB
private ServiceMastFacade srvSession;
private ServiceMast srvRecord;
 
@EJB
private SubscriberDetailsFacade subdSession;
private SubscriberDetails subdRecord;
 
private ServiceMast subdSrvCode;

private SubserviceMast subdSsrvCode;


    /**
     * Creates a new instance of SubscriberDetailsBean
     */
    public SubscriberDetailsBean() {
        subdSrvCode = new ServiceMast();
        subdSsrvCode = new SubserviceMast();
        
    }
 
    /**
     * * Getter & Setter
     * @return
     */
    public ServiceMast getSubdSrvCode() {
        return subdSrvCode;
    }

    public void setSubdSrvCode(ServiceMast subdSrvCode) {
        this.subdSrvCode = subdSrvCode;
    }

    public SubserviceMast getSubdSsrvCode() {
        return subdSsrvCode;
    }

    public void setSubdSsrvCode(SubserviceMast subdSsrvCode) {
        this.subdSsrvCode = subdSsrvCode;
    }

    
//   Actions
 
    public int getCount(String srvCode, String ssrvCode){
        int res = 0; 
 
        if(!srvCode.equals("")){
            if(srvSession.isSubserviceExist(srvCode))
                if (!ssrvCode.equals(""))
                    res = subdSession.getSrvCount(subdSrvCode);
            
            else
            
                res =  subdSession.getSsrvCount(subdSsrvCode);
               
        }
        return res;
    }  
    
}
