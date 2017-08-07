/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.mBeans.settings.serviceSettings;

import com.cme.entities.DevicePlatform;
import com.cme.facade.settings.DevicePlatformFacade;
import com.cme.mBeans.common.CommonObjects;
import com.cme.mBeans.common.CommonObjects.State;
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
//import static com.cme.mBeans.common.CommonObjects.rowCount;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
import com.cme.mBeans.common.LocalChanger;
import com.cme.mBeans.common.ReadResourceBundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.Basic;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.richfaces.component.SortOrder;

/**
 *
 * @author admin
 */
@Named(value = "platform")
@ViewScoped
public class platformsBean implements Serializable {
    @EJB
    private DevicePlatformFacade platSession;
    private DevicePlatform platRecord;
    private List<DevicePlatform> detailRecord;
    private List<PlatListRecord> platformList;
    ManagedProperty LocalChanger;
    LocalChanger localChanger;
    private ReadResourceBundle customMsg;
    private String nameFilter;
    private String stateFilterValue="";
    private EntityManager em;
    @ManagedProperty(value="#{CommonObjects.rowCount}")
    private  int rowCount;
    private CommonObjects commonObj;
        
  @Id
//    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String osId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String osName;
    @Size(max = 20)
    private String osVersion;
    @Size(max = 10)
    private String osStatus;
    
    private String viewMessage;
    private String deleteMessage;
    private String editMessage;
    
    private SortOrder osIdOrder = SortOrder.unsorted;
    private SortOrder osNameOrder = SortOrder.unsorted;
    private SortOrder osVersionOrder = SortOrder.unsorted;
    private SortOrder osStatusOrder = SortOrder.unsorted;

   
    private CommonObjects.State currentState = CommonObjects.State.NONE;

//

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }


       
    public String getNameFilter() {
        return nameFilter;
    }

    public void setNameFilter(String nameFilter) {
        this.nameFilter = nameFilter;
    }

    

    
    
    public String getStateFilterValue() {
        return stateFilterValue;
    }

    public void setStateFilterValue(String stateFilterValue) {
        this.stateFilterValue = stateFilterValue;
    }

    
    
    public String getViewMessage() {
        return viewMessage;
    }

    public void setViewMessage(String viewMessage) {
        this.viewMessage = viewMessage;
    }

    public String getDeleteMessage() {
        return deleteMessage;
    }

    public void setDeleteMessage(String deleteMessage) {
        this.deleteMessage = deleteMessage;
    }

    public String getEditMessage() {
        return editMessage;
    }

    public void setEditMessage(String editMessage) {
        this.editMessage = editMessage;
    }
    
   
    public void setCurrentState(CommonObjects.State state){
        currentState = state;
    }
    
    public CommonObjects.State getCurrentState(){
        return currentState;
    }
    
    public String getListStateImage(){
        return tableStateImage.get(currentState.name());
    }
    
    public String getRecordStateImage(){
        return recordStateImage.get(currentState.name());
    }

    public platformsBean() {
        platSession = new DevicePlatformFacade();
        customMsg = new ReadResourceBundle();
        viewMessage = customMsg.getCustomMessage("msgs", "m_AlertNothing");
        deleteMessage = customMsg.getCustomMessage("msgs", "m_Alert_DeleteFlag");
        editMessage = customMsg.getCustomMessage("msgs", "m_Alert_SaveChanges");
        commonObj = new CommonObjects();
        rowCount = commonObj.ROW_COUNT;
     
        
    }

    public SortOrder getOsIdOrder() {
        return osIdOrder;
    }

    public void setOsIdOrder(SortOrder osIdOrder) {
        this.osIdOrder = osIdOrder;
    }

    public SortOrder getOsNameOrder() {
        return osNameOrder;
    }

    public void setOsNameOrder(SortOrder osNameOrder) {
        this.osNameOrder = osNameOrder;
    }

    public SortOrder getOsVersionOrder() {
        return osVersionOrder;
    }

    public void setOsVersionOrder(SortOrder osVersionOrder) {
        this.osVersionOrder = osVersionOrder;
    }

    public SortOrder getOsStatusOrder() {
        return osStatusOrder;
    }

    public void setOsStatusOrder(SortOrder osStatusOrder) {
        this.osStatusOrder = osStatusOrder;
    }
    
    

    public String getOsId() {
        return osId;
    }

    public void setOsId(String osId) {
        this.osId = osId;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsStatus() {
        return osStatus;
    }

    public void setOsStatus(String osStatus) {
        this.osStatus = osStatus;
    }
    
     public void sortByOsId(){
        
        osNameOrder = SortOrder.unsorted;
        osVersionOrder = SortOrder.unsorted;
        osStatusOrder = SortOrder.unsorted;
        if(osIdOrder.equals(SortOrder.ascending)){
            setOsIdOrder(SortOrder.descending); 
        }
        else
        {
            setOsIdOrder(SortOrder.ascending); 
        }
    }
     
      public void sortByOsName(){
        
        osIdOrder = SortOrder.unsorted;
        osVersionOrder = SortOrder.unsorted;
        osStatusOrder = SortOrder.unsorted;
        if(osNameOrder.equals(SortOrder.ascending)){
            setOsNameOrder(SortOrder.descending); 
        }
        else
        {
            setOsNameOrder(SortOrder.ascending); 
        }
    }
      
         public void sortByOsVersion(){
        
        osIdOrder = SortOrder.unsorted;
        osNameOrder = SortOrder.unsorted;
        osStatusOrder = SortOrder.unsorted;
        if(osVersionOrder.equals(SortOrder.ascending)){
            setOsVersionOrder(SortOrder.descending); 
        }
        else
        {
            setOsVersionOrder(SortOrder.ascending); 
        }
    }
         
             public void sortByOsStatus(){
        
        osIdOrder = SortOrder.unsorted;
        osNameOrder = SortOrder.unsorted;
        osVersionOrder = SortOrder.unsorted;
        if(osStatusOrder.equals(SortOrder.ascending)){
            setOsStatusOrder(SortOrder.descending); 
        }
        else
        {
            setOsStatusOrder(SortOrder.ascending); 
        }
    }
      
     private String osNameFilter;

    public String getOsNameFilter() {
        return osNameFilter;
    }

    public void setOsNameFilter(String osNameFilter) {
        this.osNameFilter = osNameFilter;
    }
     
    
    
//    
//    private ListDataModel<DevicePlatform> model = new ListDataModel<DevicePlatform>();
//
//     @PostConstruct
//     public void init() {
//        model = new ListDataModel(platformList.equals(5));
//    }       
//       public List<DevicePlatform> getFilterOsName() {
//        return new Filter<DevicePlatform>() {
//            public boolean accept(DevicePlatform t) {
//                String osName = getOsName();
//                if (osName == null || osName.length() == 0 || osName.equals(t.getOsName())) {
//                    return true;
//                }
//                return false;
//            }
        
    
     public boolean filterName(Object current) {
                DevicePlatform devicePlatform = (DevicePlatform)current;
                if (stateFilterValue.length()==0) {
                    return true;
                }
                if (devicePlatform.getOsName().startsWith(stateFilterValue)) {
                        return true;
                }
                else{
                return false;
            }
     }
  
    
    public List<PlatListRecord> getPlatformList() {
        platformList = new ArrayList<PlatListRecord>();
        List<DevicePlatform> list = platSession.getDevicePlatList(this.rowCount);
        for(DevicePlatform record:list)
            platformList.add(new PlatListRecord(record));
                
        return platformList;
    }


    public void setPlatformList(List<PlatListRecord> platformList) {
        this.platformList = platformList;
    }
    
     public List<DevicePlatform> getDetailRecord(){
        return detailRecord;
    }
     
     
       private void setAttrValues(){
        if(this.isStateAdd()){
            this.osId   = "";
            this.osName = "";
            this.osVersion = "";
            this.osStatus ="A";
             
        }
        else
        {
            this.osId   = platRecord.getOsId();
            this.osName = platRecord.getOsName();
            this.osVersion = platRecord.getOsVersion();
            this.osStatus = platRecord.getOsStatus();
          
           
        }

        
    }
    
    public String addRecord(){
        setCurrentState(CommonObjects.State.ADD);
        setAttrValues();
        DevicePlatform rec = new DevicePlatform();
        detailRecord = new ArrayList<DevicePlatform>();
        
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(rec);
        
        return "";
    }
    
    public String editRecord(DevicePlatform rec){
        setCurrentState(CommonObjects.State.EDIT);
        platRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<DevicePlatform>();
        detailRecord.add(platRecord);
        return "";
    }
    
    public String viewRecord(DevicePlatform rec){
        setCurrentState(CommonObjects.State.VIEW);
        platRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<DevicePlatform>();
        detailRecord.add(platRecord);
        return "";
    }
    
    public String deleteRecord(DevicePlatform rec){
        setCurrentState(CommonObjects.State.DELETE);
        platRecord = rec;
        setAttrValues();
        platRecord.setOsStatus("D");
      
        detailRecord = new ArrayList<DevicePlatform>();
        detailRecord.add(platRecord);
        return "";
    }
    
 
    public String saveRecord(){
        platRecord.setOsId(osId);
        platRecord.setOsName(osName);
        platRecord.setOsVersion(osVersion);
        platRecord.setOsStatus(osStatus);
                 if(currentState.equals(State.ADD)){
            if(isRecordValid()){
                platSession.create(platRecord);
                PlatListRecord listRecord = new PlatListRecord(platRecord);
                platformList.add(listRecord);  
                stateRefresh();
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage("formRecord:OsID", new FacesMessage(customMsg.getCustomMessage("msgs", "m_Alert_DupRecord")));
            }
            
        }
        else{
           platSession.edit(platRecord);
            stateRefresh();
        }
        
        
        return "";

    }
    
    
         public boolean isRecordValid(){
        boolean valid = true;
//        LanguageMast test = new LanguageMast();
//        test.setLanCode(lanCode);
//        if(languagesList.contains(test))
//            valid = false;
        for(DevicePlatform iterate: platSession.getDevicePlatList(this.rowCount)){
            if(osId.equals(iterate.getOsId())){
                valid = false;
                break;
            }
        }
        return valid;
    }
    
     public int getPlatformsCount(){
        return platSession.count();
    }
    
    public String stateRefresh(){
        setCurrentState(CommonObjects.State.NONE);
        
        platRecord = null;
              
        detailRecord = new ArrayList<DevicePlatform>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(platRecord);
        
        getPlatformList();
        
        return "";
    }
    
  
    
    // State getter
    
    public boolean isStateDelete(){
        if(currentState.equals(CommonObjects.State.DELETE))
            return true;
        else
            return false;
    }
    
    public boolean isStateNone(){
        if(currentState.equals(CommonObjects.State.NONE) )
            return true;
        else
            return false;
    }
    
    public boolean isStateView(){
        if(currentState.equals(CommonObjects.State.VIEW))
            return true;
        else
            return false;
    }
    
    public boolean isStateAdd(){
        if(currentState.equals(CommonObjects.State.ADD))
            return true;
        else
            return false;
    }
    
    public boolean isStateEdit(){
        if(currentState.equals(CommonObjects.State.EDIT))
            return true;
        else
            return false;
    }
    
    public boolean isStateSave(){
        if(currentState.equals(CommonObjects.State.SAVE))
            return true;
        else
            return false;
    }
     public static class PlatListRecord implements Serializable{
        private DevicePlatform platform;
        private boolean selected;
        
        
        public PlatListRecord(){
            selected = false;
        }
        
        public PlatListRecord(DevicePlatform plat){
            platform = plat;
            selected = false;
        }

        public DevicePlatform getPlatform() {
            return platform;
        }

        public void setPlatform(DevicePlatform platform) {
            this.platform = platform;
        }

        

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
        
        public void rowSelected(){
            this.selected = true;
        }
        
        
     }
     
    
}
