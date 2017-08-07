/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans.settings;

import com.cme.entities.ServiceMast;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.cme.entities.ServicesUrl;
import com.cme.facade.settings.ServiceMastFacade;
import com.cme.facade.settings.ServicesUrlFacade;
import com.cme.mBeans.common.CommonObjects.State;
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.richfaces.component.SortOrder;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.persistence.EntityManager;
import com.cme.mBeans.common.ReadResourceBundle;
import java.math.BigDecimal;
/**
 *
 * @author hp
 */
@ManagedBean(name="appsUrl")
@ViewScoped
public class appsUrlBean implements Serializable{
    @EJB
    private ServicesUrlFacade appUSession;
    private ServicesUrl appURecord;
    private List<ServicesUrl> detailRecord;
    private List<appsUrlListRecord> appsUList;
    private ReadResourceBundle customMsg;
    private SortOrder codeOrder = SortOrder.unsorted;
    private SortOrder srvcodeOrder = SortOrder.unsorted;
    private SortOrder ssrvcodeOrder = SortOrder.unsorted;
    @EJB
    private ServiceMastFacade srvSession;
    private ServiceMast srvRecord;
    
    
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min = 1, max = 30,message="{com.cme.m_Val_fieldSize}")
    private String surCode;
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min = 1, max = 30,message="{com.cme.m_Val_fieldSize}")
    private String surSrvCode;
    
    @Size( max = 30,message="{com.cme.m_Val_fieldSize}")
    private String surSsrvCode;
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min = 1, max = 20,message="{com.cme.m_Val_fieldSize}")
    private String surType;
    
    @Size( max = 500,message="{com.cme.m_Val_fieldSize}")
    private String surUrl; 
    
    @Size( max = 1,message="{com.cme.m_Val_fieldSize}")
    private String surAppend;
    
    @Size( max = 500,message="{com.cme.m_Val_fieldSize}")
    private String surFilename;
    
    private BigDecimal surFilesize;
    
    @Size( max = 20,message="{com.cme.m_Val_fieldSize}")
    private String surOsId;
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min = 1, max = 1,message="{com.cme.m_Val_fieldSize}")
    private String surStatus;
    
    
    
    private State currentState = State.NONE;

    private String viewMessage;
    private String deleteMessage;
    private String editMessage;
    
    
    
    public String getListStateImage(){
        return tableStateImage.get(currentState.name());
    }
    
    public String getRecordStateImage(){
        return recordStateImage.get(currentState.name());
    }
    
/**
 * Creates a new instance of appsUrlBean
 */
    
    public appsUrlBean() {
         appUSession = new ServicesUrlFacade();
         customMsg = new ReadResourceBundle();
         viewMessage = customMsg.getCustomMessage("msgs", "m_AlertNothing");
         deleteMessage = customMsg.getCustomMessage("msgs", "m_Alert_DeleteFlag");
         editMessage = customMsg.getCustomMessage("msgs", "m_Alert_SaveChanges");
        
    }
    
/**
* * Getter & Setter
* @return
*/
    
    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
    public List<ServicesUrl> getDetailRecord() {
        return detailRecord;
    }

    public SortOrder getSrvcodeOrder() {
        return srvcodeOrder;
    }

    public void setSrvcodeOrder(SortOrder srvcodeOrder) {
        this.srvcodeOrder = srvcodeOrder;
    }

    public SortOrder getSsrvcodeOrder() {
        return ssrvcodeOrder;
    }

    public void setSsrvcodeOrder(SortOrder ssrvcodeOrder) {
        this.ssrvcodeOrder = ssrvcodeOrder;
    }

    public void setDetailRecord(List<ServicesUrl> detailRecord) {
        this.detailRecord = detailRecord;
    }

    public List<appsUrlListRecord> getAppsUList() {
        return appsUList;
    }

    public void setAppsUList(List<appsUrlListRecord> appsUList) {
        this.appsUList = appsUList;
    }

  
    public ReadResourceBundle getCustomMsg() {
        return customMsg;
    }

    public void setCustomMsg(ReadResourceBundle customMsg) {
        this.customMsg = customMsg;
    }

    public String getSurCode() {
        return surCode;
    }

    public void setSurCode(String surCode) {
        this.surCode = surCode;
    }

    public String getSurSrvCode() {
        return surSrvCode;
    }

    public void setSurSrvCode(String surSrvCode) {
        this.surSrvCode = surSrvCode;
    }

    public String getSurSsrvCode() {
        return surSsrvCode;
    }

    public void setSurSsrvCode(String surSsrvCode) {
        this.surSsrvCode = surSsrvCode;
    }

    public String getSurUrl() {
        return surUrl;
    }

    public void setSurUrl(String surUrl) {
        this.surUrl = surUrl;
    }

    public String getSurAppend() {
        return surAppend;
    }

    public void setSurAppend(String surAppend) {
        this.surAppend = surAppend;
    }

    public String getSurFilename() {
        return surFilename;
    }

    public void setSurFilename(String surFilename) {
        this.surFilename = surFilename;
    }

    public BigDecimal getSurFilesize() {
        return surFilesize;
    }

    public void setSurFilesize(BigDecimal surFilesize) {
        this.surFilesize = surFilesize;
    }

    public String getSurOsId() {
        return surOsId;
    }

    public void setSurOsId(String surOsId) {
        this.surOsId = surOsId;
    }

    public String getSurStatus() {
        return surStatus;
    }

    public void setSurStatus(String surStatus) {
        this.surStatus = surStatus;
    }

    public SortOrder getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(SortOrder codeOrder) {
        this.codeOrder = codeOrder;
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

    public String getSurType() {
        return surType;
    }

    public void setSurType(String surType) {
        this.surType = surType;
    }
    
//List of CurrencyMast & Select

    public List<appsUrlListRecord> getappsUList() {
        appsUList = new ArrayList<appsUrlListRecord>();
        List<ServicesUrl> list = appUSession.getAppsUList();
         for(ServicesUrl record:list)
             appsUList.add(new appsUrlListRecord(record));
                
        return appsUList;
    }

   
       

    
    public DataModel<ServicesUrl> getAllApps(){
        return appUSession.getAppsUTable();
    }
    
    public int getAppsUCount(){
        return appUSession.count();
    }
    
    public List<ServicesUrl> getRecordDetail(){
        return detailRecord;
    }
    
   
    public void sortByCode() {
        codeOrder = SortOrder.unsorted;
        srvcodeOrder = SortOrder.unsorted;
        ssrvcodeOrder = SortOrder.unsorted;
        if (codeOrder.equals(SortOrder.ascending)) {
            setCodeOrder(SortOrder.descending);
        } else {
            setCodeOrder(SortOrder.ascending);
            }
    }
    
    public void sortBySrvCode() {
        codeOrder = SortOrder.unsorted;
        srvcodeOrder = SortOrder.unsorted;
        ssrvcodeOrder = SortOrder.unsorted;
        if (srvcodeOrder.equals(SortOrder.ascending)) {
            setSrvcodeOrder(SortOrder.descending);
        } else {
            setSrvcodeOrder(SortOrder.ascending);
            }
    }
  
    public void sortBySsrvCode() {
        codeOrder = SortOrder.unsorted;
        srvcodeOrder = SortOrder.unsorted;
        ssrvcodeOrder = SortOrder.unsorted;
        if (codeOrder.equals(SortOrder.ascending)) {
            setSsrvcodeOrder(SortOrder.descending);
        } else {
            setSsrvcodeOrder(SortOrder.ascending);
            }
    }


//the Actions
    
    private void setAttrValues(){
        if(this.isStateAdd()){
            this.surCode   = "";
            this.surSrvCode= "";
            this.surSsrvCode= "";
            this.surAppend = "";
            this.surStatus = "A";
            this.surFilename  = "";
//            this.surFilesize= "";
            this.surOsId = "";
            this.surType = "";
            this.surUrl = "";
             
        }
        else
        {
            this.surCode   = appURecord.getSurCode();
            this.surSrvCode = appURecord.getSurSrvCode();
            this.surSsrvCode = appURecord.getSurSsrvCode();
            this.surAppend = appURecord.getSurAppend();
            this.surStatus = appURecord.getSurStatus();
            this.surFilename   = appURecord.getSurFilename();
            this.surFilesize = appURecord.getSurFilesize();
            this.surOsId = appURecord.getSurOsId();
            this.surType = appURecord.getSurType();
            this.surUrl = appURecord.getSurUrl();
           
        }

        
    }
     
    public String addRecord(){
        setCurrentState(State.ADD);
        setAttrValues();
        ServicesUrl rec = new ServicesUrl();
        detailRecord = new ArrayList<ServicesUrl>();
        
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(rec);
        
        return "";
    }
    
    public String editRecord(ServicesUrl rec){
        setCurrentState(State.EDIT);
        appURecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServicesUrl >();
        detailRecord.add(appURecord);
        return "";
    }
      
    public String viewRecord(ServicesUrl rec){
        setCurrentState(State.VIEW);
        appURecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServicesUrl>();
        detailRecord.add(appURecord);
        return "";
    }
     
    public String deleteRecord(ServicesUrl rec){
        setCurrentState(State.DELETE);
        appURecord = rec;
        setAttrValues();
        appURecord.setSurStatus("D");
        surStatus = "D";
      
        detailRecord = new ArrayList<ServicesUrl>();
        detailRecord.add( appURecord);
        return "";
    }
    
     public String saveRecord(){
    
        appURecord = new ServicesUrl(); 
        appURecord.setSurCode(surCode);
        appURecord.setSurSrvCode(surSrvCode);
        appURecord.setSurSsrvCode(surSsrvCode);
        appURecord.setSurStatus(surStatus);
        appURecord.setSurAppend(surAppend);
        appURecord.setSurOsId(surOsId);
        appURecord.setSurFilename(surFilename);
        appURecord.setSurFilesize(surFilesize);
        appURecord.setSurType(surType);
        appURecord.setSurUrl(surUrl);
        
         if(currentState.equals(State.ADD)){
            if(isRecordValid()){
                appUSession.create(appURecord);
                appsUrlListRecord listRecord = new appsUrlListRecord(appURecord);
                appsUList.add(listRecord);  
                stateRefresh();
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage("formRecord:surCode", new FacesMessage(customMsg.getCustomMessage("msgs", "m_Alert_DupRecord")));
            }
            
        }
        else{
            appUSession.edit(appURecord);
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
        for(ServicesUrl iterate: appUSession.getAppsUList()){
            if(surCode.equals(iterate.getSurCode())){
                valid = false;
                break;
            }
        }
        return valid;
    }
    
       
            
    public String stateRefresh(){
        setCurrentState(State.NONE);
        
        appURecord = null;
              
        detailRecord = new ArrayList<ServicesUrl>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(appURecord);
        
        getAppsUList();
        
        return "";
    }
    
     public boolean hasSubservice(){
        boolean result = false;
        
        if(! surSrvCode.equals("") && !surSrvCode.isEmpty() && surSrvCode != null)
           result = srvSession.isSubserviceExist(surSrvCode);
        return result; 
    }
    
// State getter
    
   public boolean isStateDelete(){
        if(currentState.equals(State.DELETE))
            return true;
        else
            return false;
    }
    
    public boolean isStateNone(){
        if(currentState.equals(State.NONE) )
            return true;
        else
            return false;
    }
    
    public boolean isStateView(){
        if(currentState.equals(State.VIEW))
            return true;
        else
            return false;
    }
    
    public boolean isStateAdd(){
        if(currentState.equals(State.ADD))
            return true;
        else
            return false;
    }
    
    public boolean isStateEdit(){
        if(currentState.equals(State.EDIT))
            return true;
        else
            return false;
    }
    
   
    
    public boolean isStateSave(){
        if(currentState.equals(State.SAVE))
            return true;
        else
            return false;
    }
      
    public static class appsUrlListRecord implements Serializable{
        private ServicesUrl appsUrl ;
        private boolean selected;
        
        public appsUrlListRecord (){
            selected = false;
        }
        
        public appsUrlListRecord (ServicesUrl apps){
            appsUrl = apps;
            selected = false;
        }

        public ServicesUrl getAppsUrl() {
            return appsUrl;
        }

        public void setAppsUrl(ServicesUrl appsUrl) {
            this.appsUrl = appsUrl;
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
