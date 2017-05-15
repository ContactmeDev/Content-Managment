/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.mBeans.common;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;

/**
 *
 * @author mustafaahmed
 */
@Named(value = "readResourceBundle")
@RequestScoped
public class ReadResourceBundle {
    
    private String BundleName;
    private String message;

    /**
     * Creates a new instance of ReadResourceBundle
     */
    public ReadResourceBundle() {
    }

    public String getBundleName() {
        return BundleName;
    }

    public void setBundleName(String BundleName) {
        this.BundleName = BundleName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getCustomMessage(String bundle, String key){
        setBundleName(bundle);
        FacesContext context = FacesContext.getCurrentInstance();
        Application app = context.getApplication();
        Locale locale = context.getViewRoot().getLocale();
        ResourceBundle backendText = app.getResourceBundle(context, getBundleName());
        
        return backendText.getString(key);
    }
    
}
