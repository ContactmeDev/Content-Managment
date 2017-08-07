/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans.common;

import com.cme.entities.DevicePlatform;
import com.cme.entities.LanguageMast;
import com.cme.entities.OperatorMast;
import com.cme.entities.ServicesVersion;
import com.cme.facade.settings.DevicePlatformFacade;
import com.cme.facade.settings.LanguageMastFacade;
import com.cme.facade.settings.OperatorMastFacade;
import com.cme.facade.settings.ServicesVersionFacade;
import java.util.ArrayList;
import java.util.Arrays;
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
       public static int ROW_COUNT = 10;


 
       
       
      

    public enum State {NONE,ADD,EDIT,DELETE,VIEW,SAVE,SHOW};
    
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

    public int getRowCount() {
        return ROW_COUNT;
    }

//    public void setRowCount(int rowCount) {
//        CommonObjects.ROW_COUNT = rowCount;
//    }

 

    
   private   ArrayList<Integer> integerList =
		new ArrayList<Integer>(Arrays.asList(
        new Integer("1"),
        new Integer("5"),
        new Integer("7"),
        new Integer("9"),
        new Integer("10"))); 
//   List<Integer> rowList = new ArrayList<Integer>();
//   public List<Integer> getRowSize(){
//       rowList.
//   }

    public ArrayList<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(ArrayList<Integer> integerList) {
        this.integerList = integerList;
    }
   
   
   
//    
      public static int[] rowCounter;
    static{
        rowCounter = new int[7];
        rowCounter[0] = 7;
        rowCounter[1] = 10;
        rowCounter[2] = 15;
        rowCounter[3] = 100;
        rowCounter[4] = 200;
        rowCounter[5] = 500;
        rowCounter[6] = 1000;
       
    }

    public int[] getRowCounter(){
        return rowCounter;
    }
  

    

  

   
    

    


    
//    public String getOsId(String platf){
//        return platSession.getPlatforms(platf);
//    }
    private State pageState;
    @EJB
    private DevicePlatformFacade platSession;
    @EJB
    private ServicesVersionFacade verSession;
    @EJB 
    private LanguageMastFacade languageSession;
    @EJB
    private OperatorMastFacade oprSession;

    
    

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
//     public List<DevicePlatform> getDDLanguage(){
//        return platSession.getDDList();
//    }
     
       public List<DevicePlatform> getDDListName()
    {
return platSession.getListName();
        
    }
       
    public List<ServicesVersion> getDDVersionId()
    {
        return verSession.getversionId();
        
    }
      public List<LanguageMast> getDDLanguage(){
        return languageSession.getDDList();
    }
      
       public List<DevicePlatform> getDDOs(){
        return platSession.getDDOsList();
    }
       
         public List<OperatorMast> getDDOperators(){
        return oprSession.getOprList();
    }
    
             public List<ServicesVersion> getDDVersions(){
        return verSession.getDDVersionsList();
    }
             
//             public List<DevicePlatform> getDDList()
//             {
//                ;
//             }
}
