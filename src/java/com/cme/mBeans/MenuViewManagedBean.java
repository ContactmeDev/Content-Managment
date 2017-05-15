/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans;

import com.cme.facade.MenuViewFacade;
import com.cme.entities.MenuItemsTree;
import com.cme.entities.MenuView;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author mustafaahmed
 */
@ManagedBean
@RequestScoped
public class MenuViewManagedBean {

     // Injects the MessageFacade session bean using the @EJB annotation
    //This to link this managed bean with the session facade
    @EJB
    private MenuViewFacade menuViewFacade;
    private String userId="k";
    private String LangDir="j";
    private List<MenuView> menu;
    /**
     * Creates a new instance of MenuViewManagedBean
     */
    public MenuViewManagedBean() {
        System.out.println("IN SIDE BEEEEAAAAAAAAANS ");
        
        
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLangDir() {
        return LangDir;
    }

    public void setLangDir(String LangDir) {
        this.LangDir = LangDir;
    }

    public List<MenuView> getMenu() {
        return menu = menuViewFacade.getMenus(userId, LangDir) ;
    }
    
    
    
    
    
}
