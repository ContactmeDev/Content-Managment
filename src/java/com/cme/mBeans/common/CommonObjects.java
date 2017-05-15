/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans.common;

import com.cme.entities.LanguageMast;
import com.cme.facade.settings.LanguageMastFacade;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mustafaahmed
 */
@ManagedBean
@SessionScoped
public class CommonObjects {
    
    public int LIST_ROW_SIZE = 10;
    
    public enum State {NONE,ADD,EDIT,DELETE,VIEW,SAVE};
    
    public static Map<String, String> tableStateImage;
    static{
        tableStateImage = new LinkedHashMap<String,String>();
        tableStateImage.put(State.NONE.name(), "table.png");
        tableStateImage.put(State.ADD.name(), "table_add.png");
        tableStateImage.put(State.EDIT.name(), "table_edit.png");
        tableStateImage.put(State.DELETE.name(), "table_close.png");
        tableStateImage.put(State.VIEW.name(), "table_info.png");
        tableStateImage.put(State.SAVE.name(), "table_save.png");
    }
    
    public static Map<String, String> recordStateImage;
    static{
        recordStateImage = new LinkedHashMap<String,String>();
        recordStateImage.put(State.ADD.name(), "column_add.png");
        recordStateImage.put(State.EDIT.name(), "column_edit.png");
        recordStateImage.put(State.DELETE.name(), "column_close.png");
        recordStateImage.put(State.VIEW.name(), "column_zoom.png");
    }

    private State pageState;
    
    private LanguageMastFacade languageSession;
    

    /**
     * Creates a new instance of CommonObjects
     */
    public CommonObjects() {
    }

    public State getPageState() {
        return pageState;
    }

    public void setPageState(State pageState) {
        this.pageState = pageState;
    }

    public int getLIST_ROW_SIZE() {
        return LIST_ROW_SIZE;
    }
    
    
    /*
    * DropDown List
    */
    
    public List<LanguageMast> getDDLanguage(){
        return languageSession.getDDList();
    }
    
    
    
}
