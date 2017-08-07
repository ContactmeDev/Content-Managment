/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans.settings;

import com.cme.entities.CurrencyMast;
import com.cme.entities.LanguageMast;
import com.cme.entities.ServiceCategory;
import com.cme.entities.ServiceMast;
import com.cme.entities.ServiceType;
import com.cme.entities.SubserviceMast;
import com.cme.facade.settings.SubserviceMastFacade;
import com.cme.mBeans.common.CommonObjects.State;
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
import com.cme.mBeans.common.ReadResourceBundle;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
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
import javax.faces.model.DataModel;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.richfaces.component.SortOrder;



@ManagedBean(name="subservice")
@ViewScoped
public class subServiceBean implements Serializable{
    @EJB
    private SubserviceMastFacade subsrvSession;
    private SubserviceMast subsrvRecord;
    private ServiceMast ssrvSrvCode;
    private List<SubserviceMast> detailRecord;
    private List<SubserviceListRecord> subservicesList;
    private SortOrder codeOrder = SortOrder.unsorted;
    private SortOrder nameOrder = SortOrder.unsorted;
    private String subSrvRadio;
    private String subescribeRadio;
    private ReadResourceBundle customMsg;
    
//    @ManagedProperty(value="#{service}") 
//    serviceBean svrBean;
    
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min=1,max=30,message="{com.cme.m_Val_fieldSize}")
    private String ssrvCode;
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(max=300,message="{com.cme.m_Val_fieldSize}")
    private String ssrvNameEn;
    
    @Size(max=300,message="{com.cme.m_Val_fieldSize}")
    private String ssrvNameAr;
    
    @Size(max = 1000,message="{com.cme.m_Val_fieldSize}")
    private String ssrvDesc;
    
    
    @Size(max = 1000,message="{com.cme.m_Val_fieldSize}")
    private String ssrvDescAR;
    
    
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String ssrvSenderId;
    
    @Size(max = 1,message="{com.cme.m_Val_fieldSize}")
    private String ssrvSenderIdDyn;
    
    private Long ssrvTariff;
    
    private Short ssrvNumbPageTariff;
    
    @Size(max = 1,message="{com.cme.m_Val_fieldSize}")
    private String ssrvOngoSubscriber;
    
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String ssrvOngoFrom;
    
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String ssrvCheckpoint;
    
    @Size(max = 1,message="{com.cme.m_Val_fieldSize}")
    private String ssrvSubscriptionNeed;
    
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String ssrvSubscriptionCodeEn;
    
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String ssrvSubscriptionCodeAr;
    
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String ssrvUnsubscribeCodeEn;
    
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String ssrvUnsubscribeCodeAr;
    
    @Size(max = 1,message="{com.cme.m_Val_fieldSize}")
    private String ssrvSubService;
    
    private Date ssrvStartDate;
    
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String srvAddUid; 
     
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String ssrvUpdUid;
            
    private Date ssrvAddDate;
    
    private Date ssrvUpdDate;
    
    private String ssrvOsBased;
  
    private String ssrvScatCode;
    
    private String ssrvLanCode;

    
    private String ssrvCurrCode;
    
    private String ssrvSrtCode;

    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(max=1,message="{com.cme.m_Val_fieldSize}")
    private String ssrvStatus;
   
     
    private State currentState = State.NONE;
    private State currentDetailState = State.NONE;
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
* Creates a new instance of subServiceBean
*/
    
    
    
    public subServiceBean() {
        subsrvSession = new SubserviceMastFacade();
        ssrvSrvCode = new ServiceMast();
        customMsg = new ReadResourceBundle();
        viewMessage = customMsg.getCustomMessage("msgs", "m_AlertNothing");
        deleteMessage = customMsg.getCustomMessage("msgs", "m_Alert_DeleteFlag");
        editMessage = customMsg.getCustomMessage("msgs", "m_Alert_SaveChanges");
    }

/**
 * * Getter & Setter
 * @return
 */

    public String getSsrvScatCode() {
        return ssrvScatCode;
    }

    public void setSsrvScatCode(String ssrvScatCode) {
        this.ssrvScatCode = ssrvScatCode;
    }

    public String getSsrvSenderIdDyn() {
        return ssrvSenderIdDyn;
    }

    public void setSsrvSenderIdDyn(String ssrvSenderIdDyn) {
        this.ssrvSenderIdDyn = ssrvSenderIdDyn;
    }

    public Long getSsrvTariff() {
        return ssrvTariff;
    }

    public void setSsrvTariff(Long ssrvTariff) {
        this.ssrvTariff = ssrvTariff;
    }

    public Short getSsrvNumbPageTariff() {
        return ssrvNumbPageTariff;
    }

    public void setSsrvNumbPageTariff(Short ssrvNumbPageTariff) {
        this.ssrvNumbPageTariff = ssrvNumbPageTariff;
    }

    public String getSsrvOngoSubscriber() {
        return ssrvOngoSubscriber;
    }

    public void setSsrvOngoSubscriber(String ssrvOngoSubscriber) {
        this.ssrvOngoSubscriber = ssrvOngoSubscriber;
    }

    public String getSsrvOngoFrom() {
        return ssrvOngoFrom;
    }

    public void setSsrvOngoFrom(String ssrvOngoFrom) {
        this.ssrvOngoFrom = ssrvOngoFrom;
    }

    public String getSsrvCheckpoint() {
        return ssrvCheckpoint;
    }

    public void setSsrvCheckpoint(String ssrvCheckpoint) {
        this.ssrvCheckpoint = ssrvCheckpoint;
    }

    public String getSsrvUpdUid() {
        return ssrvUpdUid;
    }

    public void setSsrvUpdUid(String ssrvUpdUid) {
        this.ssrvUpdUid = ssrvUpdUid;
    }

    public Date getSsrvAddDate() {
        return ssrvAddDate;
    }

    public void setSsrvAddDate(Date ssrvAddDate) {
        this.ssrvAddDate = ssrvAddDate;
    }

    public Date getSsrvUpdDate() {
        return ssrvUpdDate;
    }

    public void setSsrvUpdDate(Date ssrvUpdDate) {
        this.ssrvUpdDate = ssrvUpdDate;
    }

    public String getSsrvOsBased() {
        return ssrvOsBased;
    }

    public void setSsrvOsBased(String ssrvOsBased) {
        this.ssrvOsBased = ssrvOsBased;
    }

    public String getSsrvLanCode() {
        return ssrvLanCode;
    }

    public void setSsrvLanCode(String ssrvLanCode) {
        this.ssrvLanCode = ssrvLanCode;
    }

    public String getSsrvCurrCode() {
        return ssrvCurrCode;
    }

    public void setSsrvCurrCode(String ssrvCurrCode) {
        this.ssrvCurrCode = ssrvCurrCode;
    }

    public String getSsrvSrtCode() {
        return ssrvSrtCode;
    }

    public void setSsrvSrtCode(String ssrvSrtCode) {
        this.ssrvSrtCode = ssrvSrtCode;
    }

    public ReadResourceBundle getCustomMsg() {
        return customMsg;
    }

    public void setCustomMsg(ReadResourceBundle customMsg) {
        this.customMsg = customMsg;
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

    public void setCurrentState(State state){
        currentState = state;
    }
    
    public State getCurrentState(){
        return currentState;
    }

    public State getCurrentDetailState() {
        return currentDetailState;
    }

    public void setCurrentDetailState(State currentDetailState) {
        this.currentDetailState = currentDetailState;
    }
    
    public SortOrder getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(SortOrder codeOrder) {
        this.codeOrder = codeOrder;
    }

    public SortOrder getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(SortOrder nameOrder) {
        this.nameOrder = nameOrder;
    }

    public String getSsrvSenderId() {
        return ssrvSenderId;
    }

    public void setSsrvSenderId(String ssrvSenderId) {
        this.ssrvSenderId = ssrvSenderId;
    }

    public String getSsrvSubscriptionNeed() {
        return ssrvSubscriptionNeed;
    }

    public void setSsrvSubscriptionNeed(String ssrvSubscriptionNeed) {
        this.ssrvSubscriptionNeed = ssrvSubscriptionNeed;
    }

    public String getSsrvSubscriptionCodeEn() {
        return ssrvSubscriptionCodeEn;
    }

    public void setSsrvSubscriptionCodeEn(String ssrvSubscriptionCodeEn) {
        this.ssrvSubscriptionCodeEn = ssrvSubscriptionCodeEn;
    }

    public String getSsrvSubscriptionCodeAr() {
        return ssrvSubscriptionCodeAr;
    }

    public void setSsrvSubscriptionCodeAr(String ssrvSubscriptionCodeAr) {
        this.ssrvSubscriptionCodeAr = ssrvSubscriptionCodeAr;
    }

    public String getSsrvUnsubscribeCodeEn() {
        return ssrvUnsubscribeCodeEn;
    }

    public void setSsrvUnsubscribeCodeEn(String ssrvUnsubscribeCodeEn) {
        this.ssrvUnsubscribeCodeEn = ssrvUnsubscribeCodeEn;
    }

    public String getSsrvUnsubscribeCodeAr() {
        return ssrvUnsubscribeCodeAr;
    }

    public void setSsrvUnsubscribeCodeAr(String ssrvUnsubscribeCodeAr) {
        this.ssrvUnsubscribeCodeAr = ssrvUnsubscribeCodeAr;
    }

    public String getSsrvSubService() {
        return ssrvSubService;
    }

    public void setSsrvSubService(String ssrvSubService) {
        this.ssrvSubService = ssrvSubService;
    }

    
    public String getSsrvCode() {
        return ssrvCode;
    }

    public void setSsrvCode(String ssrvCode) {
        this.ssrvCode = ssrvCode;
    }

    public String getSsrvNameEn() {
        return ssrvNameEn;
    }

    public void setSsrvNameEn(String ssrvNameEn) {
        this.ssrvNameEn = ssrvNameEn;
    }

    public String getSsrvNameAr() {
        return ssrvNameAr;
    }

    public void setSsrvNameAr(String ssrvNameAr) {
        this.ssrvNameAr = ssrvNameAr;
    }

    public Date getSsrvStartDate() {
        return ssrvStartDate;
    }

    public void setSsrvStartDate(Date ssrvStartDate) {
        this.ssrvStartDate = ssrvStartDate;
    }

    public String getSrvAddUid() {
        return srvAddUid;
    }

    public void setSrvAddUid(String srvAddUid) {
        this.srvAddUid = srvAddUid;
    }

 
    public String getSsrvStatus() {
        return ssrvStatus;
    }

    public void setSsrvStatus(String ssrvStatus) {
        this.ssrvStatus = ssrvStatus;
    }

    public String getSsrvDesc() {
        return ssrvDesc;
    }

    public void setSsrvDesc(String ssrvDesc) {
        this.ssrvDesc = ssrvDesc;
    }

    public String getSsrvDescAR() {
        return ssrvDescAR;
    }

    public void setSsrvDescAR(String ssrvDescAR) {
        this.ssrvDescAR = ssrvDescAR;
    }

    public String getSubSrvRadio() {
        return subSrvRadio;
    }

    public void setSubSrvRadio(String subSrvRadio) {
        this.subSrvRadio = subSrvRadio;
    }

    public String getSubescribeRadio() {
        return subescribeRadio;
    }

    public void setSubescribeRadio(String subescribeRadio) {
        this.subescribeRadio = subescribeRadio;
    }

    public ServiceMast getSsrvSrvCode() {
        return ssrvSrvCode;
    }

    public void setSsrvSrvCode(ServiceMast ssrvSrvCode) {
        this.ssrvSrvCode = ssrvSrvCode;
    }
    

    

    

//List of SubserviceMast & Select


    public List<SubserviceListRecord> getSubservicesList() {
        setCurrentState(State.VIEW);
        //setCurrentDetailState(State.NONE);
        
        subservicesList = new ArrayList<SubserviceListRecord>();
        List<SubserviceMast> list = subsrvSession.getSubserviceLists(ssrvSrvCode); 
        for(SubserviceMast record:list)
            subservicesList.add(new SubserviceListRecord(record));
                
        return subservicesList;
    }


    public void setSubservicesList(List<SubserviceListRecord> subservicesList) {
        this.subservicesList = subservicesList;
    }
    
    public DataModel<SubserviceMast> getAllSubservices(){
        return subsrvSession.getSubserviceTable();
    }
    
    public int getSubsrvCount(){
        return subsrvSession.count();
    }
    
    public List<SubserviceMast> getRecordDetail(){
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
    
    public void sortByName() {
        codeOrder = SortOrder.unsorted;
        if (nameOrder.equals(SortOrder.ascending)) {
            setNameOrder(SortOrder.descending);
        } else {
            setNameOrder(SortOrder.ascending);
        }
    }
    
//Action
    
    public String retrieveSubServices(String srvCode){
        ssrvSrvCode.setSrvCode(srvCode);
        setSsrvSrvCode(ssrvSrvCode);
        setCurrentState(State.VIEW);
        setCurrentDetailState(State.NONE);
//        svrBean.setCurrentState(State.NONE);
        return "";
    }
    
    private void setAttrValues(){
        if(this.isStateAdd()){
            this.ssrvCode   = "";
            this.ssrvNameEn = "";
            this.ssrvNameAr = "";
            this.ssrvStatus = "A";
            this.srvAddUid = "";  
//          this.ssrvStartDate = "";   
            this.ssrvDesc = "";   
            this.ssrvDescAR = "";  
             this.ssrvSenderId   = "";
            this.ssrvSubService = "";
            this.ssrvSubscriptionNeed = "";
            this.ssrvSubscriptionCodeEn = "";
            this.ssrvSubscriptionCodeAr = "";  
            this.ssrvUnsubscribeCodeEn = "";   
            this.ssrvUnsubscribeCodeAr = ""; 
            
            this.ssrvSenderIdDyn = "";
//            this.ssrvTariff = "";
//            this.ssrvNumbPageTariff = "";  
            this.ssrvOngoFrom = "";   
            this.ssrvOngoSubscriber = ""; 
            this.ssrvOsBased= "";
            this.ssrvCheckpoint = "";
            this.ssrvScatCode= "";  
            this.ssrvLanCode = "";   
            this.ssrvCurrCode = ""; 
            this.ssrvSrtCode = ""; 
            this.srvAddUid= "";  
//            this.ssrvAddDate = "";   
            this.ssrvUpdUid= ""; 
//            this.ssrvUpdDate= ""; 
            
        }
        else
        {
            this.ssrvCode   = subsrvRecord.getSsrvCode();
            this.ssrvNameEn = subsrvRecord.getSsrvNameEn();
            this.ssrvNameAr = subsrvRecord.getSsrvNameAr();
            this.ssrvStatus = subsrvRecord.getSsrvStatus();
            this.ssrvStartDate = subsrvRecord.getSsrvStartDate();
            this.srvAddUid = subsrvRecord.getSrvAddUid();
            this.ssrvDesc = subsrvRecord.getSsrvDesc();
            this.ssrvDescAR = subsrvRecord.getSsrvDescAR();
            this.ssrvSenderId   = subsrvRecord.getSsrvSenderId();
            this.ssrvSenderIdDyn  = subsrvRecord.getSsrvSenderIdDyn();
            this.ssrvOsBased  = subsrvRecord.getSsrvOsBased();
            this.ssrvTariff = subsrvRecord.getSsrvTariff();
            this.ssrvNumbPageTariff = subsrvRecord.getSsrvNumbPageTariff();
            this.ssrvCheckpoint= subsrvRecord.getSsrvCheckpoint();
            this.ssrvOngoFrom = subsrvRecord.getSsrvOngoFrom();
            this.ssrvOngoSubscriber = subsrvRecord.getSsrvOngoSubscriber();
            this.srvAddUid = subsrvRecord.getSrvAddUid();
            this.ssrvAddDate = subsrvRecord.getSsrvAddDate();
            this.ssrvUpdUid   = subsrvRecord.getSsrvUpdUid ();
            this.ssrvUpdDate  = subsrvRecord.getSsrvUpdDate ();
            this.ssrvSubscriptionNeed = subsrvRecord.getSsrvSubscriptionNeed();
            this.ssrvSubscriptionCodeEn = subsrvRecord.getSsrvSubscriptionCodeEn();
            this.ssrvSubscriptionCodeAr = subsrvRecord.getSsrvSubscriptionCodeAr();
            this.ssrvSubService = subsrvRecord.getSsrvSubService();
            this.ssrvUnsubscribeCodeEn = subsrvRecord.getSsrvUnsubscribeCodeEn();
            this.ssrvUnsubscribeCodeAr = subsrvRecord.getSsrvUnsubscribeCodeAr();
            this.ssrvSrvCode = subsrvRecord.getSsrvSrvCode();
            this.ssrvCurrCode = subsrvRecord.getSsrvCurrCode().getCurrCode();
            this.ssrvLanCode   = subsrvRecord.getSsrvLanCode().getLanCode();
            this.ssrvSrtCode  = subsrvRecord.getSsrvSrtCode ().getSrtCode();
            this.ssrvScatCode  = subsrvRecord.getSsrvScatCode ().getScatCode();
        }

        
    }
    
    public String addRecord(){
        setCurrentState(State.ADD);
        setCurrentDetailState(State.ADD);
        setAttrValues();
        SubserviceMast rec = new SubserviceMast();
        detailRecord = new ArrayList<SubserviceMast>();
        
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(rec);
        
        return "";
    }
    
    public String editRecord(SubserviceMast rec){
        setCurrentState(State.EDIT);
        setCurrentDetailState(State.EDIT);
        subsrvRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<SubserviceMast>();
        detailRecord.add(subsrvRecord);
        return "";
    }
    
    public String viewRecord(SubserviceMast rec){
        setCurrentState(State.VIEW);
        setCurrentDetailState(State.VIEW);
        System.out.println("@ VIEW RECORD: "+this.getCurrentDetailState());
        subsrvRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<SubserviceMast>();
        detailRecord.add(subsrvRecord);
        return "";
    }
    
    public String deleteRecord(SubserviceMast rec){
        setCurrentState(State.DELETE);
        setCurrentDetailState(State.DELETE);
        
        subsrvRecord= rec;
        setAttrValues();
        subsrvRecord.setSsrvStatus("D");
        ssrvStatus = "D";
      
        detailRecord = new ArrayList<SubserviceMast>();
        detailRecord.add(subsrvRecord);
        return "";
    }
    
    
    public String saveRecord(){
        
        if(subsrvSession.recordExist(ssrvCode)){
             FacesContext.getCurrentInstance().addMessage("Record:ssrvCode", new FacesMessage(customMsg.getCustomMessage("msgs", "m_Alert_DupRecord")));
        }
        else
        {
        subsrvRecord=new SubserviceMast();
        subsrvRecord.setSsrvCode(ssrvCode);
        subsrvRecord.setSsrvNameEn(ssrvNameEn);
        subsrvRecord.setSsrvNameAr(ssrvNameAr);
        subsrvRecord.setSsrvStatus(ssrvStatus);
        subsrvRecord.setSsrvStartDate(ssrvStartDate);
        subsrvRecord.setSrvAddUid(srvAddUid);
        subsrvRecord.setSsrvDesc(ssrvDesc);
        subsrvRecord.setSsrvDescAR(ssrvDescAR);
        subsrvRecord.setSsrvSenderId(ssrvSenderId);
        subsrvRecord.setSsrvSrvCode(ssrvSrvCode);
        subsrvRecord.setSsrvSubscriptionNeed(ssrvSubscriptionNeed);
        subsrvRecord.setSsrvSubscriptionCodeEn(ssrvSubscriptionCodeEn);
        subsrvRecord.setSsrvSubscriptionCodeAr(ssrvSubscriptionCodeAr);
        subsrvRecord.setSsrvSubService(ssrvSubService);
        subsrvRecord.setSsrvUnsubscribeCodeEn(ssrvUnsubscribeCodeEn);
        subsrvRecord.setSsrvUnsubscribeCodeAr(ssrvUnsubscribeCodeAr);
        subsrvRecord.setSsrvSenderIdDyn(ssrvSenderIdDyn);
        subsrvRecord.setSsrvOsBased(ssrvOsBased);
        subsrvRecord.setSsrvCheckpoint(ssrvCheckpoint);
        subsrvRecord.setSsrvTariff(ssrvTariff);
        subsrvRecord.getSsrvNumbPageTariff();
        subsrvRecord.setSsrvOngoFrom(ssrvOngoFrom);
        subsrvRecord.setSsrvOngoSubscriber(ssrvOngoSubscriber);
        subsrvRecord.setSrvAddUid(srvAddUid);
        subsrvRecord.setSsrvAddDate(ssrvAddDate);
        subsrvRecord.getSsrvUpdUid();
        subsrvRecord.setSsrvUpdDate(ssrvUpdDate);
        ServiceType srtEntity = new ServiceType();
        srtEntity.setSrtCode(ssrvSrtCode);
        subsrvRecord.setSsrvSrtCode(srtEntity);
        CurrencyMast currEntity = new CurrencyMast();
        currEntity.setCurrCode(ssrvCurrCode);
        subsrvRecord.setSsrvCurrCode(currEntity);
        LanguageMast lanEntity = new LanguageMast();
        lanEntity.setLanCode(ssrvLanCode);
        subsrvRecord.setSsrvLanCode(lanEntity);
        ServiceCategory scatEntity = new ServiceCategory();
        scatEntity.setScatCode(ssrvScatCode);
        subsrvRecord.setSsrvScatCode(scatEntity);
        
        
        
        if(currentState.equals(State.ADD)){
            subsrvSession.create(subsrvRecord);
            SubserviceListRecord listRecord = new SubserviceListRecord(subsrvRecord);
            subservicesList.add(listRecord);
        }
        else{
            subsrvSession.edit(subsrvRecord);
        }
        stateRefresh();
        
        }
        
        return "";

    
        
    }
    
    public String stateRefresh(){
        setCurrentState(State.NONE);
        
        subsrvRecord = null;
              
        detailRecord = new ArrayList<SubserviceMast>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(subsrvRecord);
        
        getSubservicesList();
        
        return "";
    }
    
    public String stateDetailRefresh(){
        setCurrentDetailState(State.NONE);
        
        subsrvRecord = null;
              
        detailRecord = new ArrayList<SubserviceMast>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(subsrvRecord);
        
        getSubservicesList();
        
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
    
    public boolean isDetailStateDelete(){
        System.out.println("STATE of DETAILS: "+ this.getCurrentDetailState());
        if(currentDetailState.equals(State.DELETE))
            return true;
        else
            return false;
    }
    
    public boolean isDetailStateNone(){
        if(currentDetailState.equals(State.NONE) )
            return true;
        else
            return false;
    }
    
    public boolean isDetailStateView(){
        if(currentDetailState.equals(State.VIEW))
            return true;
        else
            return false;
    }
    
    public boolean isDetailStateAdd(){
        if(currentDetailState.equals(State.ADD))
            return true;
        else
            return false;
    }
    
    public boolean isDetailStateEdit(){
        if(currentDetailState.equals(State.EDIT))
            return true;
        else
            return false;
    }
    
    public boolean isDetailStateSave(){
        if(currentDetailState.equals(State.SAVE))
            return true;
        else
            return false;
    }
    
    public static class SubserviceListRecord implements Serializable{
        private SubserviceMast subservice;
        private boolean selected;
        
        public SubserviceListRecord(){
            selected = false;
        }
        
        public SubserviceListRecord(SubserviceMast sub){
            subservice = sub;
            selected = false;
        }

        public SubserviceMast getSubservice() {
            return subservice;
        }

        public void setSubservice(SubserviceMast subservice) {
            this.subservice = subservice;
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

    
    
    

