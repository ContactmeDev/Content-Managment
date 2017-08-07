/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.facade;


import com.cme.entities.MenuView;
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
public class MenuViewFacade extends AbstractFacade<MenuView> {
    @PersistenceContext(unitName = "ContentManagerPU")
    private EntityManager em;
    private List<MenuView> result = null;
     String myQuery = "MenuView.findAll";

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuViewFacade() {
        super(MenuView.class);
        
    }
    
    public List<MenuView> getMenus(String userId, String Language)
    {
        
       
        System.out.println("JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ "+userId+" "+Language);
        Query query = em.createNamedQuery(myQuery);
        
        result = query.getResultList();
        

       System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOO "+result.size());
        

        return result;
    }
    
}
