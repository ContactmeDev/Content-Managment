/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans;

import com.cme.facade.MenuItemsTreeFacade;
import com.cme.entities.MenuItemsTree;
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
public class MenuItemsTreeManagedBean {
// Injects the MessageFacade session bean using the @EJB annotation
    //This to link this managed bean with the session facade
    @EJB
    private MenuItemsTreeFacade menuItemsTreeFacade;
    /**
     * Creates a new instance of MenuItemsTreeManagedBean
     */
    public MenuItemsTreeManagedBean() {
    }
    
    public List<MenuItemsTree> getMenuofSite(String usrID, String intLang)
    {
        return menuItemsTreeFacade.getMenus(usrID, intLang);
    }
    
}