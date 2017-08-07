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
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
import com.cme.mBeans.common.ReadResourceBundle;
import com.cme.facade.runner.ServiceWorkshopFacade;
import com.cme.facade.runner.SubscriberDetailsFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.richfaces.component.SortOrder;

/**
 *
 * @author hp
 */
@ManagedBean(name="workshop")
@ViewScoped
public class workShopBean implements Serializable {
    @EJB
    private ServiceWorkshopFacade wkShopSession;
    private ServiceWorkshop wkShopRecord;
    private List<ServiceWorkshop> detailRecord;
    private List<workshopListRecord> workshopsList;
    private ReadResourceBundle customMsg;
    private SortOrder codeOrder = SortOrder.unsorted;
    
    @EJB
    private ServiceMastFacade srvSession;
    private ServiceMast srvRecord;
    @EJB
    private SubserviceMastFacade ssrvSession;
    private SubserviceMast ssrvRecord;
    @EJB
    private SubscriberDetailsFacade subdSession;
    
    @ManagedProperty(value="#{subd}") 
    SubscriberDetailsBean subd;  
   
    
//    @NotNull(message="{com.cme.m_Val_notNull}")  
    private Long swkId;
    
    private String swkSsrvCode = "";
    
    private String swkSrvCode = "";
    
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
    
    private Short swkNumbPage;
    
    private int swkNubSub;
    
    private String swkSenderId;
    
    @Size(max = 1)
    private String swkExecuted;
    
  
    
    
    private State currentState = State.ADD;
    private String editMessage;
    private String viewMessage;
    private String deleteMessage;
    private String alertMessage;
    
    public String getListStateImage(){
        return tableStateImage.get(currentState.name());
    }
    
    public String getRecordStateImage(){
        return recordStateImage.get(currentState.name());
    }

/**
 * Creates a new instance of workShopBean
*/
    
    public workShopBean() {
        
        wkShopSession = new ServiceWorkshopFacade();
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

    public String getEditMessage() {
        return editMessage;
    }

    public void setEditMessage(String editMessage) {
        this.editMessage = editMessage;
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

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }
    
    public SubscriberDetailsBean getSubd() {
        return subd;
    }

    public void setSubd(SubscriberDetailsBean subd) {
        this.subd = subd;
    }

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

    public String getSwkAddUid() {
        return swkAddUid;
    }

    public void setSwkAddUid(String swkAddUid) {
        this.swkAddUid = swkAddUid;
    }

    public Short getSwkNumbPage() {
        return swkNumbPage;
    }

    public void setSwkNumbPage(Short swkNumbPage) {
        this.swkNumbPage = swkNumbPage;
    }
    
    

    public String getSwkSrvCode() {
        return swkSrvCode;
    }

    public void setSwkSrvCode(String swkSrvCode) {
       
        this.swkSrvCode = swkSrvCode;
    }

    public String getSwkExecuted() {
        return swkExecuted;
    }

    public void setSwkExecuted(String swkExecuted) {
        this.swkExecuted = swkExecuted;
    }

    public SortOrder getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(SortOrder codeOrder) {
        this.codeOrder = codeOrder;
    }

    

    public SubserviceMast getSsrvRecord() {
        return ssrvRecord;
    }

    public void setSsrvRecord(SubserviceMast ssrvRecord) {
        this.ssrvRecord = ssrvRecord;
    }
    
    

    public String getSwkLanCode() {
        return swkLanCode;
    }

    public void setSwkLanCode(String swkLanCode) {
        this.swkLanCode = swkLanCode;
        System.out.println("setting swkLanCode: "+swkLanCode);
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

    public int getSwkNubSub() {
        return swkNubSub;
    }

    public void setSwkNubSub(int swkNubSub) {
        this.swkNubSub = swkNubSub;
    }

    public String getSwkSenderId() {
        return swkSenderId;
    }

    public void setSwkSenderId(String swkSenderId) {
        this.swkSenderId = swkSenderId;
    }
    
    

    public ReadResourceBundle getCustomMsg() {
        return customMsg;
    }
    
    
//List of ServiceWorkshop & Select
    
    public List<workshopListRecord> getWorkshopsList() {
        workshopsList = new ArrayList<workshopListRecord>();
        List<ServiceWorkshop> list = wkShopSession.getSwkList();
         for(ServiceWorkshop record:list)
            workshopsList.add(new workshopListRecord(record));
                
        return workshopsList;
    }

    public void setWorkshopsList(List<workshopListRecord> workshopsList) {
        this.workshopsList = workshopsList;
    }
//    
//    public long getID(){
//        return wkShopSession.getSwkID(swkMsg,this.swkSrvCode,this.swkSsrvCode);
//    }
    
    public int getSwkCount(){
        return wkShopSession.count();
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
    
    
  
  

    public String getSenderID(String srvCode, String sSrvCode){
        String res = ""; 
        if(!srvCode.isEmpty() && srvCode != "" && srvCode !=  null){
            if(srvSession.isSubserviceExist(srvCode) && ! sSrvCode.isEmpty())
                res =  ssrvSession.getSender(sSrvCode);
            else
                res = srvSession.getSender(srvCode);
        }
        return res;
    }
    
    public int getActiveSubscriber(String srvCode, String sSrvCode){
      int res = 0; 
        if(!srvCode.isEmpty() && srvCode != "" && srvCode !=  null){
            if(srvSession.isSubserviceExist(srvCode) && ! sSrvCode.isEmpty())
                res =  subdSession.numberOfSubscribers(srvCode, sSrvCode, true);
            else
                res = subdSession.numberOfSubscribers(srvCode, sSrvCode, false);
        }
        return res;  
    }
   
    public String assignServ2Sserv(String srvCode){
        
        
        srvRecord = new ServiceMast();
        srvRecord.setSrvCode(srvCode);
        subd.setSubdSrvCode(srvRecord);
        swkNubSub = getActiveSubscriber(swkSrvCode, swkSsrvCode);
        swkSenderId = getSenderID(swkSrvCode,swkSsrvCode);
 
        return "";
    }

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
            this.swkSenderId = "";
            this.swkNubSub = 0;
//            this.swkAddUid="";
//            this.swkNumbPage = "";
            this.swkExecuted = "";
            
             
        }
        else
        {
       
            this.swkId = wkShopRecord.getSwkId();
            this.swkLanCode = wkShopRecord.getSwkLanCode();
            this.swkMsg = wkShopRecord.getSwkMsg();
            this.swkStatus = wkShopRecord.getSwkStatus();
            this.swkScheduled = wkShopRecord.getSwkScheduled();
            this.swkExecDate = wkShopRecord.getSwkExecDate();
            this.swkSsrvCode = wkShopRecord.getSwkSsrvCode().getSsrvCode();
            this.swkSrvCode = wkShopRecord.getSwkSrvCode().getSrvCode();
            this.swkAddUid = wkShopRecord.getSwkAddUid();
            this.swkNumbPage = wkShopRecord.getSwkNumbPage();
            this.swkExecuted = wkShopRecord.getSwkExecuted();
        }
 }
    

    
    public String getSrviceName(String srv, String lang){
        return srvSession.getServiceName(srv,lang);
    }
    
    public String getSsrviceName(String ssrv, String lang){
        return ssrvSession.getSserviceName(ssrv,lang);
    }
        
   
    public String sendSubmit(){
        if(!this.isStateSave())
        {
            this.setCurrentState(State.SAVE);
            wkShopRecord=new ServiceWorkshop();

   //        this.swkId = wkShopSession.getWorkshopId();

            wkShopRecord.setSwkId(swkId);
            wkShopRecord.setSwkLanCode(swkLanCode);
            wkShopRecord.setSwkMsg(swkMsg);
            wkShopRecord.setSwkExecuted("N");
            
            
            wkShopRecord.setSwkScheduled(swkScheduled);
            if(swkScheduled.equals("SEND_NOW"))
            {
                swkExecDate = new Date();
                wkShopRecord.setSwkStatus("A");
            }
            else
            {
                wkShopRecord.setSwkStatus("N");
            }
            wkShopRecord.setSwkExecDate(swkExecDate);

            wkShopRecord.setSwkAddUid(swkAddUid);

            ServiceMast srvEntity = new ServiceMast();
            srvEntity.setSrvCode(swkSrvCode);
            wkShopRecord.setSwkSrvCode(srvEntity);

            SubserviceMast SsrvEntity = new SubserviceMast();
            SsrvEntity.setSsrvCode(swkSsrvCode);
            SsrvEntity.setSsrvSrvCode(srvRecord);
            wkShopRecord.setSwkSsrvCode(SsrvEntity);
            
            if(!wkShopSession.isContentExist(swkMsg, srvEntity,SsrvEntity))
            {
                wkShopSession.create(wkShopRecord);
                this.setSwkId(wkShopSession.getSwkID(swkMsg,srvEntity,SsrvEntity));
                this.alertMessage = customMsg.getCustomMessage("msgs", "m_Alert_WrkShpUpdtSuccesful").concat(this.getSwkId().toString());
                
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage("formRecord:contentText", new FacesMessage(customMsg.getCustomMessage("msgs", "m_Alert_DupContent")));
                this.alertMessage = customMsg.getCustomMessage("msgs", "m_Alert_WrkShopUpdtFailed");
            }

            
            
            
        }
        
        
        
        return "";
//        return wkShopSession.getSwkID(swkMsg);
    }
    
    
    public String editRecord(ServiceWorkshop rec){
        setCurrentState(State.EDIT);
        wkShopRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServiceWorkshop >();
        detailRecord.add(wkShopRecord);
        return "";
    }
   
    
     public String saveChanges(){
         
        for(workshopListRecord swk: workshopsList){
            System.out.println("swk.workshop.getSwkStatus().equals(\"N\"): "+swk.workshop.getSwkStatus());
            if (!swk.workshop.getSwkStatus().equals("N")){

                   wkShopSession.edit(swk.getWorkshop());
            }
        }
        return "index";
    }
    
    public String saveRecord(){
        
        wkShopRecord.setSwkId(swkId);
        wkShopRecord.setSwkLanCode(swkLanCode);
        wkShopRecord.setSwkMsg(swkMsg);
        wkShopRecord.setSwkStatus(swkStatus);
        wkShopRecord.setSwkScheduled(swkScheduled);
        wkShopRecord.setSwkExecDate(swkExecDate);
        wkShopRecord.setSwkAddUid(swkAddUid);
        
        ServiceMast srvEntity = new ServiceMast();
        srvEntity.setSrvCode(swkSrvCode);
        wkShopRecord.setSwkSrvCode(srvEntity);
        
        SubserviceMast SsrvEntity = new SubserviceMast();
        SsrvEntity.setSsrvCode(swkSsrvCode);
        SsrvEntity.setSsrvSrvCode(srvRecord);
        wkShopRecord.setSwkSsrvCode(SsrvEntity);
        
        
            wkShopSession.edit(wkShopRecord);
       
            stateRefresh();
    
      return"" ; 
    }

    
    public String stateRefresh(){
        setCurrentState(State.NONE);
        
        wkShopRecord = null;
              
        detailRecord = new ArrayList<ServiceWorkshop>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(wkShopRecord);
        
       getWorkshopsList();
        
        return "";
    }
    
    public String refresh(){
        setCurrentState(State.ADD);
        setAttrValues();
        wkShopRecord = null;
              
        detailRecord = new ArrayList<ServiceWorkshop>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(wkShopRecord);
        
        return "";
    }
   
    
    public boolean hasSubservice(){
        boolean result = false;
        
        if(! swkSrvCode.equals("") && !swkSrvCode.isEmpty() && swkSrvCode != null)
           result = srvSession.isSubserviceExist(swkSrvCode);
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
    
    
    public static class workshopListRecord implements Serializable{
        private ServiceWorkshop workshop;
        private boolean selected;
        
        public workshopListRecord (){
            selected = false;
        }
        
        public workshopListRecord (ServiceWorkshop swk ){
            workshop = swk;
            selected = false;
        }

        public ServiceWorkshop getWorkshop() {
            return workshop;
        }

        public void setWorkshop(ServiceWorkshop workshop) {
            this.workshop = workshop;
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
