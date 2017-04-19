/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade;

import com.cme.entities.MenuItemsTree;
import com.cme.entities.UserMast;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mustafaahmed
 */
@Stateless
public class MenuItemsTreeFacade extends AbstractFacade<MenuItemsTree> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;
    private UserMast usrMast;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuItemsTreeFacade() {
        super(MenuItemsTree.class);
    }
    
    public List<MenuItemsTree> getMenus(String userId, String Language)
    {
        List<MenuItemsTree> result = null;
        String myQuery = "MenuItemsTree.MyMenuEnglish";
        
        
        
//        if (Language.equals("LTR"))
//            myQuery = "MenuItemsTree.MyMenuEnglish";
//        else if(Language.equals("RTL"))
//            myQuery = "MenuItemsTree.MyMenuArabic";
        
        Query query = em.createNamedQuery(myQuery);
        
        result = query.getResultList();
        
//        if (result.size() > 0 )
//        {
//        
//        }
        return result;
    }
    
}
