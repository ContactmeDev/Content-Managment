/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans.runner;

import com.cme.entities.ServiceMast;
import com.cme.entities.ServiceWorkshop;
import com.cme.entities.SubserviceMast;
import com.cme.facade.settings.ServiceMastFacade;
import com.cme.facade.settings.SubserviceMastFacade;
import com.cme.mBeans.common.CommonObjects.State;
import com.cme.facade.runner.ServiceWorkshopFacade;
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
import java.util.Date;
import org.richfaces.model.Filter;

/**
 *
 * @author hp
 */
@ManagedBean(name="workShopAll")
@ViewScoped
public class workShopAllBean implements Serializable{
   @EJB 
    private ServiceWorkshopFacade swkAllSession;
    private ServiceWorkshop swkAllRecord;
    private List<ServiceWorkshop> detailRecord;
    private List<workshopListRecord> workshopsList;
    private ReadResourceBundle customMsg;
    private SortOrder codeOrder = SortOrder.unsorted;
    private SortOrder srvOrder = SortOrder.unsorted;
    private SortOrder ssrvOrder = SortOrder.unsorted;
    private EntityManager em;
    FacesMessage message = null;
    private int model;
    private String srvFilter;
    private String ssrvFilter;
    @EJB
    private ServiceMastFacade srvSession;
    private ServiceMast srvRecord;
    @EJB
    private SubserviceMastFacade ssrvSession;
    private SubserviceMast ssrvRecord;
    
    
    @NotNull(message="{com.cme.m_Val_notNull}")  
    private Long swkId;
    
    private String swkSsrvCode ;
    
    private String swkSrvCode ;
    
    @Size(max = 10 ,message="{com.cme.m_Val_fieldSize}")
    private String swkLanCode;
    
    @Size(max = 200 ,message="{com.cme.m_Val_fieldSize}")
    private String swkMsg;
    
    @Size(max = 20 ,message="{com.cme.m_Val_fieldSize}")
    private String swkScheduled;

    private Date swkExecDate;
    
    private String swkStatus;
    
    @Size(max = 30)
    private String swkAddUid;
    
    private Date swkAddDate;
    
    @Size(max = 1)
    private String swkExecuted;
    
    private Long swkSmsTotal;
    
    private Long swkPostTotal;
    
    private Long swkDlvTotal;
    
    private Date swkActuDate;
    
    
    
    
    
    private State currentState = State.NONE;

    private String viewMessage;
    private String deleteMessage;
    private String editMessage;

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
     
    public String getListStateImage(){
        return tableStateImage.get(currentState.name());
    }
    
    public String getRecordStateImage(){
        return recordStateImage.get(currentState.name());
    }

    /**
     * Creates a new instance of workShopAllBean
     */
    public workShopAllBean() {
        swkAllSession = new ServiceWorkshopFacade();
        customMsg = new ReadResourceBundle();
        viewMessage = customMsg.getCustomMessage("msgs", "m_AlertNothing");
        deleteMessage = customMsg.getCustomMessage("msgs", "m_Alert_DeleteFlag");
        editMessage = customMsg.getCustomMessage("msgs", "m_Alert_SaveChanges");
        
        
    }
    
    /**
     * * Getter & Setter
     * @return 
     */
    public Long getSwkId() {
        return swkId;
    }

    public void setSwkId(Long swkId) {
        this.swkId = swkId;
    }

    public String getSwkSsrvCode() {
        return swkSsrvCode;
    }

    public void setSwkSsrvCode(String swkSsrvCode) {
        this.swkSsrvCode = swkSsrvCode;
    }

    public String getSwkSrvCode() {
        return swkSrvCode;
    }

    public void setSwkSrvCode(String swkSrvCode) {
        this.swkSrvCode = swkSrvCode;
    }

    public String getSwkLanCode() {
        return swkLanCode;
    }

    public void setSwkLanCode(String swkLanCode) {
        this.swkLanCode = swkLanCode;
    }

    public String getSwkMsg() {
        return swkMsg;
    }

    public void setSwkMsg(String swkMsg) {
        this.swkMsg = swkMsg;
    }

    public String getSwkScheduled() {
        return swkScheduled;
    }

    public void setSwkScheduled(String swkScheduled) {
        this.swkScheduled = swkScheduled;
    }

    public Date getSwkExecDate() {
        return swkExecDate;
    }

    public void setSwkExecDate(Date swkExecDate) {
        this.swkExecDate = swkExecDate;
    }

    public String getSwkStatus() {
        return swkStatus;
    }

    public void setSwkStatus(String swkStatus) {
        this.swkStatus = swkStatus;
    }

    public String getSwkAddUid() {
        return swkAddUid;
    }

    public void setSwkAddUid(String swkAddUid) {
        this.swkAddUid = swkAddUid;
    }

    public Date getSwkAddDate() {
        return swkAddDate;
    }

    public void setSwkAddDate(Date swkAddDate) {
        this.swkAddDate = swkAddDate;
    }

    public String getSwkExecuted() {
        return swkExecuted;
    }

    public void setSwkExecuted(String swkExecuted) {
        this.swkExecuted = swkExecuted;
    }

    public Long getSwkSmsTotal() {
        return swkSmsTotal;
    }

    public void setSwkSmsTotal(Long swkSmsTotal) {
        this.swkSmsTotal = swkSmsTotal;
    }

    public Long getSwkPostTotal() {
        return swkPostTotal;
    }

    public void setSwkPostTotal(Long swkPostTotal) {
        this.swkPostTotal = swkPostTotal;
    }

    public Long getSwkDlvTotal() {
        return swkDlvTotal;
    }

    public void setSwkDlvTotal(Long swkDlvTotal) {
        this.swkDlvTotal = swkDlvTotal;
    }

    public Date getSwkActuDate() {
        return swkActuDate;
    }

    public void setSwkActuDate(Date swkActuDate) {
        this.swkActuDate = swkActuDate;
    }

    public SortOrder getSrvOrder() {
        return srvOrder;
    }

    public void setSrvOrder(SortOrder srvOrder) {
        this.srvOrder = srvOrder;
    }

    public SortOrder getSsrvOrder() {
        return ssrvOrder;
    }

    public void setSsrvOrder(SortOrder ssrvOrder) {
        this.ssrvOrder = ssrvOrder;
    }

    public String getSrvFilter() {
        return srvFilter;
    }

    public void setSrvFilter(String srvFilter) {
        this.srvFilter = srvFilter;
    }

    
    
    public List<ServiceWorkshop> getDetailRecord() {
        return detailRecord;
    }

    public void setDetailRecord(List<ServiceWorkshop> detailRecord) {
        this.detailRecord = detailRecord;
    }



  

    public ReadResourceBundle getCustomMsg() {
        return customMsg;
    }

    public void setCustomMsg(ReadResourceBundle customMsg) {
        this.customMsg = customMsg;
    }

    public SortOrder getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(SortOrder codeOrder) {
        this.codeOrder = codeOrder;
    }

   

    public FacesMessage getMessage() {
        return message;
    }

    public void setMessage(FacesMessage message) {
        this.message = message;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
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

    public String getSsrvFilter() {
        return ssrvFilter;
    }

    public void setSsrvFilter(String ssrvFilter) {
        this.ssrvFilter = ssrvFilter;
    }
    

    //List of CurrencyMast & Select
    
    public List<workshopListRecord> getWorkshopsList() {
        workshopsList = new ArrayList<workshopListRecord>();
        List<ServiceWorkshop> list = swkAllSession.getSwkAllList();
         for(ServiceWorkshop record:list)
             workshopsList.add(new workshopListRecord(record));
                
        return workshopsList;
    }

    public void setWorkshopsList(List<workshopListRecord> workshopsList) {
        this.workshopsList = workshopsList;
    }

    
       

    
    public DataModel<ServiceWorkshop> getAllCurrencies(){
        return swkAllSession.getSwkAllTable();
    }
    
    public int getWorkShopCount(){
        return swkAllSession.count();
    }
    
    public List<ServiceWorkshop> getRecordDetail(){
        return detailRecord;
    }
    
   
    public void sortByCode() {
        codeOrder = SortOrder.unsorted;
        if (codeOrder.equals(SortOrder.ascending)) {
            setCodeOrder(SortOrder.descending);
        } else {
            setCodeOrder(SortOrder.ascending);
            }
    }
    
    
       
         
    public void sortBySrv() {
        codeOrder = SortOrder.unsorted;
        ssrvOrder = SortOrder.unsorted;
        if (srvOrder.equals(SortOrder.ascending)) {
            setSrvOrder(SortOrder.descending);
        } else {
            setSrvOrder(SortOrder.ascending);
            }
    }
      
    public void sortBySsrv() {
        codeOrder = SortOrder.unsorted;
        srvOrder = SortOrder.unsorted;
        if (ssrvOrder.equals(SortOrder.ascending)) {
            setSsrvOrder(SortOrder.descending);
        } else {
            setSsrvOrder(SortOrder.ascending);
            }
    }
    
    public String getSrviceName(String srv, String lang){
        return srvSession.getServiceName(srv,lang);
    }
    
    public String getSsrviceName(String ssrv, String lang){
        return ssrvSession.getSserviceName(ssrv,lang);
    }
       
    
    //the Actions
    
    private void setAttrValues(){
        if(this.isStateAdd()){
            this.swkId   = null;
            this.swkLanCode = "";
            this.swkMsg = "";
            this.swkScheduled = "";
            this.swkStatus = "N";
            this.swkSsrvCode = "";
            this.swkExecDate = null;
            this.swkSrvCode = "";
            this.swkAddUid="";
            this.swkExecuted = "";
//            this.swkAddDate = "";
//            this.swkActuDate= "";
//            this.swkDlvTotal = "";
//            this.swkPostTotal= "";
//            this.swkSmsTotal = "";
       }
    
        else
        {
            
       
            this.swkId = swkAllRecord.getSwkId();
            this.swkLanCode = swkAllRecord.getSwkLanCode();
            this.swkMsg = swkAllRecord.getSwkMsg();
            this.swkStatus = swkAllRecord.getSwkStatus();
            this.swkScheduled = swkAllRecord.getSwkScheduled();
            this.swkExecDate = swkAllRecord.getSwkExecDate();
            this.swkSsrvCode = swkAllRecord.getSwkSsrvCode().getSsrvCode();
            this.swkSrvCode = swkAllRecord.getSwkSrvCode().getSrvCode();
            this.swkAddUid = swkAllRecord.getSwkAddUid();
            this.swkExecuted = swkAllRecord.getSwkExecuted();
            this.swkAddDate = swkAllRecord.getSwkExecDate();
            this.swkActuDate = swkAllRecord.getSwkActuDate();
            this.swkDlvTotal = swkAllRecord.getSwkDlvTotal();
            this.swkPostTotal = swkAllRecord.getSwkPostTotal();
            this.swkSmsTotal = swkAllRecord.getSwkSmsTotal();
        }
}

     
    public String addRecord(){
        setCurrentState(State.ADD);
        setAttrValues();
        ServiceWorkshop rec = new ServiceWorkshop();
        detailRecord = new ArrayList<ServiceWorkshop>();
        
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(rec);
        
        return "";
    }
    
    public String editRecord(ServiceWorkshop rec){
        setCurrentState(State.EDIT);
        swkAllRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServiceWorkshop >();
        detailRecord.add(swkAllRecord);
        return "";
    }
      
    public String viewRecord(ServiceWorkshop rec){
        setCurrentState(State.VIEW);
        swkAllRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServiceWorkshop>();
        detailRecord.add(swkAllRecord);
        return "";
    }
     
    public String deleteRecord(ServiceWorkshop rec){
        setCurrentState(State.DELETE);
        swkAllRecord = rec;
        setAttrValues();
         swkAllRecord.setSwkStatus("D");
         swkStatus = "D";
      
        detailRecord = new ArrayList<ServiceWorkshop>();
        detailRecord.add( swkAllRecord);
        return "";
    }
      
    public String saveRecord(){
    
        swkAllRecord = new ServiceWorkshop(); 
        swkAllRecord.setSwkId(swkId);
        swkAllRecord.setSwkLanCode(swkLanCode);
        swkAllRecord.setSwkMsg(swkMsg);
        swkAllRecord.setSwkStatus(swkStatus);
        swkAllRecord.setSwkScheduled(swkScheduled);
        swkAllRecord.setSwkExecDate(swkExecDate);
        swkAllRecord.setSwkAddUid(swkAddUid);
        swkAllRecord.setSwkAddDate(swkAddDate);
        swkAllRecord.setSwkPostTotal(swkPostTotal);
        swkAllRecord.setSwkSmsTotal(swkSmsTotal);
        swkAllRecord.setSwkDlvTotal(swkDlvTotal);
        swkAllRecord.setSwkActuDate(swkActuDate);
        
        ServiceMast srvEntity = new ServiceMast();
        srvEntity.setSrvCode(swkSrvCode);
        swkAllRecord.setSwkSrvCode(srvEntity);
        
        SubserviceMast SsrvEntity = new SubserviceMast();
        SsrvEntity.setSsrvCode(swkSsrvCode);
        swkAllRecord.setSwkSsrvCode(SsrvEntity);  
        
         if(currentState.equals(State.ADD)){
            if(isRecordValid()){
                swkAllSession.create(swkAllRecord);
                workshopListRecord listRecord = new workshopListRecord(swkAllRecord);
                workshopsList.add(listRecord);  
                stateRefresh();
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage("formRecord:swkId", new FacesMessage(customMsg.getCustomMessage("msgs", "m_Alert_DupRecord")));
            }
            
        }
        else{
            swkAllSession.edit(swkAllRecord);
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
        for(ServiceWorkshop iterate: swkAllSession.getSwkAllList()){
            if(swkId.equals(iterate.getSwkId())){
                valid = false;
                break;
            }
        }
        return valid;
    }
    
       
            
    public String stateRefresh(){
        setCurrentState(State.NONE);
        
        swkAllRecord = null;
              
        detailRecord = new ArrayList<ServiceWorkshop>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(swkAllRecord);
        
        getWorkshopsList();
        
        return "";
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
    
    public static class workshopListRecord implements Serializable{
        private ServiceWorkshop workShopAll;
        private boolean selected;
        
        public workshopListRecord (){
            selected = false;
        }
        
        public workshopListRecord (ServiceWorkshop swk){
            workShopAll = swk;
            selected = false;
        }

        public ServiceWorkshop getWorkShopAll() {
            return workShopAll;
        }

        public void setWorkShopAll(ServiceWorkshop workShopAll) {
            this.workShopAll = workShopAll;
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

    
    

