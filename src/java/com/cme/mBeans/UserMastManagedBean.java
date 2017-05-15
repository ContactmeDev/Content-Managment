/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans;

import com.cme.facade.UserMastFacade;
import com.cme.entities.UserMast;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mustafaahmed
 */
@ManagedBean(name = "UserMastManagedBean")
@SessionScoped
public class UserMastManagedBean {
    // Injects the MessageFacade session bean using the @EJB annotation
    //This to link this managed bean with the session facade
    @EJB
    private UserMastFacade userMastFacade;

    // Creates a new field
    private UserMast user;
    private String UserId;
    private String UserPwd;
    private String UserIPAdd;
    private String UserHostName;
    private int login;
    
    /**
     * Creates a new instance of UserMastManagedBean
     */
    public UserMastManagedBean() {
        this.user = new UserMast();
        this.setLogin(0);
        
    }

    public UserMast getUser() {
        return user;
    }

    public void setUser(UserMast user) {
        this.user = user;
    }
    
    
    // Setter & Getter Username & Password
    public void setUserId(String id) {
        this.UserId = id;
    }
    
    public String getUserId() {
        return this.UserId;
    }
    
    public void setUserPwd(String pwd) {
        this.UserPwd = pwd;
    }
    
    public String getUserPwd()
    {
        return this.UserPwd;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getUserIPAdd() {
        return UserIPAdd;
    }

    public void setUserIPAdd(String UserIPAdd) {
        this.UserIPAdd = UserIPAdd;
    }

    public String getUserHostName() {
        return UserHostName;
    }

    public void setUserHostName(String UserHostName) {
        this.UserHostName = UserHostName;
    }
    
    public String doLogout(){
        setLogin(userMastFacade.logOut());
        setUser(null);
        return "sections/logout";
    }
    
    
    public String doLogin() {
        String AuthenticateResult = "";
        
        UserIPAdd    = getClientIDAdd();
        UserHostName = getBrowserName();
    
        int ret = userMastFacade.loginAuthentication(UserId,UserPwd,UserIPAdd,UserHostName);
        setLogin(ret);
        
        if (ret > 0)
        {
            
            AuthenticateResult = "mainhome";
            setUser(userMastFacade.getUsrMast());
        }
        else
        {
            AuthenticateResult = "index";
        }
        return AuthenticateResult;
    }
    
    public void checkLogin(ComponentSystemEvent event) { 
        if (login <= 0) {
           FacesContext context = FacesContext.getCurrentInstance(); 
           ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler)context.getApplication().getNavigationHandler(); 
           handler.performNavigation("/index.xhtml");
        }
    }
    
    public String getClientIDAdd() {
        String userIPAdd = "";
        // Get the request-object.
        HttpServletRequest request = (HttpServletRequest)(FacesContext.getCurrentInstance().getExternalContext().getRequest());

        // Get the header attributes. Use them to retrieve the actual
        // values.
        request.getHeaderNames();

        
        // Get the hostname of the client.
        request.getRemoteHost();
        
        

            userIPAdd = request.getRemoteAddr();

        return userIPAdd;
    }
    
    public String getBrowserName() {
        String userAgent = "";
        // Get the request-object.
        HttpServletRequest request = (HttpServletRequest)(FacesContext.getCurrentInstance().getExternalContext().getRequest());

        // Get the header attributes. Use them to retrieve the actual
        // values.
        request.getHeaderNames();

        
        // Get the hostname of the client.
        
            userAgent = request.getRemoteHost();
        return userAgent;
}
    
     

}
