/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans.common;

import com.cme.entities.CurrencyMast;
import com.cme.entities.DevicePlatform;
import com.cme.entities.LanguageMast;
import com.cme.entities.ServiceCategory;
import com.cme.entities.ServiceMast;
import com.cme.entities.ServiceType;
import com.cme.entities.SubserviceMast;
import com.cme.entities.ServiceText;
import com.cme.facade.settings.CurrencyMastFacade;
import com.cme.facade.settings.DevicePlatformFacade;
import com.cme.facade.settings.LanguageMastFacade;
import com.cme.facade.settings.ServiceCategoryFacade;
import com.cme.facade.settings.ServiceMastFacade;
import com.cme.facade.settings.ServiceTextFacade;
import com.cme.facade.settings.ServiceTypeFacade;
import com.cme.facade.settings.SubserviceMastFacade;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
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
    
    public static String[] listArabic;
        static{
            listArabic = new String[2];
            listArabic[0] = "نعم";
            listArabic[1] = "لا";
        }

    public static String[] getListArabic() {
        return listArabic;
    }
        
    public static String[] listEnglish;
        static{
            listEnglish = new String[2];
            listEnglish[0] = "Yes";
            listEnglish[1] = "No";
        }    

    public static String[] getListEnglish() {
        return listEnglish;
    }
        
        
        
    private static String[] listFlex;
        static{
            listFlex = new String[24];
            listFlex[0] = "01:00";
            listFlex[1] = "02:00";
            listFlex[2] = "03:00";
            listFlex[3] = "04:00";
            listFlex[4] = "05:00";
            listFlex[5] = "06:00";
            listFlex[6] = "07:00";
            listFlex[7] = "08:00";
            listFlex[8] = "09:00";
            listFlex[9] = "10:00";
            listFlex[10] = "11:00";
            listFlex[11] = "12:00";
            listFlex[12] = "13:00";
            listFlex[13] = "14:00";
            listFlex[14] = "15:00";
            listFlex[15] = "16:00";
            listFlex[16] = "17:00";
            listFlex[17] = "18:00";
            listFlex[18] = "19:00";
            listFlex[19] = "20:00";
            listFlex[20] = "21:00";
            listFlex[21] = "22:00";
            listFlex[22] = "23:00";
            listFlex[23] = "24:00";
           
    }

    public String[] getListFlex(){
            return listFlex;
    }
 

    private State pageState;
    @EJB
    private LanguageMastFacade languageSession;
    @EJB
    private ServiceTypeFacade servTypeSession;
    @EJB
    private ServiceMastFacade servSession;
    @EJB
    private SubserviceMastFacade subservSession;
    @EJB
    private CurrencyMastFacade currSession;
    @EJB
    private ServiceCategoryFacade scatSession;
    @EJB
    private DevicePlatformFacade DeviceSession;
    @EJB
    private ServiceTextFacade srvTextSession;
    
    /**
     * Creates a new instance of CommonObjects
     */
    
    public CommonObjects() {
    }

    public int getLIST_ROW_SIZE() {
        return LIST_ROW_SIZE;
    }

    public void setLIST_ROW_SIZE(int LIST_ROW_SIZE) {
        this.LIST_ROW_SIZE = LIST_ROW_SIZE;
    }

    public State getPageState() {
        return pageState;
    }

    public void setPageState(State pageState) {
        this.pageState = pageState;
    }
    
     
    /*
    * DropDown List
    */
    
    public List<LanguageMast> getDDLanguage(){
        return languageSession.getDDList();
    }
    
    public List<ServiceType> getDDServType(){
        return servTypeSession.getDDList();
    }
    
    public List<SubserviceMast> getDDSubservice(){
        return subservSession.getDDList();
    }
    
    public List<ServiceMast> getDDService(){
        return servSession.getDDList();
    }
    
    public List<CurrencyMast> getDDCurreny(){
        return currSession.getDDList();
    }
    
    public List<ServiceCategory> getDDScategory(){
        return scatSession.getDDList();
    }
    
    public List<DevicePlatform> getDDOS(){
        return DeviceSession.getDDList();
    }
    
    public List<ServiceText> getDDTxt(){
        return srvTextSession.getDDList();
    }
   
    
   
}
