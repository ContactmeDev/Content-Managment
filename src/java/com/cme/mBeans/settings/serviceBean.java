/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans.settings;

import com.cme.entities.CurrencyMast;
import com.cme.entities.LanguageMast;
import com.cme.entities.ServiceMast;
import com.cme.entities.ServiceType;
import com.cme.entities.ServiceCategory;
import com.cme.facade.settings.ServiceMastFacade;
import com.cme.mBeans.common.CommonObjects.State;
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
import com.cme.mBeans.common.LocalChanger;
import com.cme.mBeans.common.ReadResourceBundle;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.faces.model.SelectItem;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.richfaces.component.SortOrder;


/**
 *
 * @author hp
 */

@ManagedBean(name="service")
@ViewScoped
public class serviceBean implements Serializable {
    @EJB
    private ServiceMastFacade servSession;
    private ServiceMast servRecord;
    private List<ServiceMast> detailRecord;
    private List<ServiceListRecord> servicesList;
    private SortOrder codeOrder = SortOrder.unsorted;
    private SortOrder nameOrder = SortOrder.unsorted;
    private String subSrvRadio;
    private String subescribeRadio;
    public ServiceMast serviceEntity = new ServiceMast();
    private int Flex1List;
    public int Flex6List;
    public int Flex7List;
    public static SelectItem[] list;
    private ReadResourceBundle customMsg;
    
    @ManagedProperty(value="#{subservice}") 
    subServiceBean subservice;
    
    @ManagedProperty(value="#{localChanger}")
    LocalChanger localChanger;
    
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min=1,max=30,message="{com.cme.m_Val_fieldSize}")
    private String srvCode;
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(max=300,message="{com.cme.m_Val_fieldSize}")
    private String srvNameEn;
    
    @Size(max=300,message="{com.cme.m_Val_fieldSize}")
    private String srvNameAR;
    
    @Size(max = 1000,message="{com.cme.m_Val_fieldSize}")
    private String srvDesc;
    
    @Size(max = 1000,message="{com.cme.m_Val_fieldSize}")
    private String srvDescAR;
    
    @Size(max = 100,message="{com.cme.m_Val_fieldSize}")
    private String srvShortCode;
    
    private String  srvSrtCode;
    private String  srvScatCode;
    private String  srvLanCode;
    private String  srvCurrCode;
    
    @Size(max = 10,message="{com.cme.m_Val_fieldSize}")
    private String srvPrefName;
    
    @Size(max = 1,message="{com.cme.m_Val_fieldSize}")
    private String srvSubscriptionNeed;
    
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String srvSubscriptionCodeEn;
    
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String srvSubscriptionCodeAr;
    
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String srvUnsubscribeCodeEn;
    
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String srvUnsubscribeCodeAr;
     
    @Size(max = 1,message="{com.cme.m_Val_fieldSize}")
    private String srvSubService;
      
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String srvSenderId;
     
    @Size(max = 1,message="{com.cme.m_Val_fieldSize}")
    private String srvSenderIdDyn;
    
    private BigDecimal srvTariff; 
    private Short srvNumbPageTariff;
 
   
    @Size(max = 1,message="{com.cme.m_Val_fieldSize}")
    private String srvOngoSubscriber;
    
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String srvOngoFrom;
     
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String srvCheckpoint;
      
    private Date srvStartDate;
       
    @Size(max = 1,message="{com.cme.m_Val_fieldSize}")
    private String srvStatus;
       
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String srvAddUid;
    
    private Date srvAddDate;
        
    @Size(max = 30,message="{com.cme.m_Val_fieldSize}")
    private String srvUpdUid;
    
    private Date srvUpdDate;
         
    @Size(max = 250,message="{com.cme.m_Val_fieldSize}")
    private String srvFlex01;
   
    @Size(max = 250,message="{com.cme.m_Val_fieldSize}")
    private String srvFlex02;
   
    @Size(max = 250,message="{com.cme.m_Val_fieldSize}")
    private String srvFlex03;
   
    @Size(max = 250,message="{com.cme.m_Val_fieldSize}")
    private String srvFlex04;
   
    @Size(max = 250,message="{com.cme.m_Val_fieldSize}")
    private String srvFlex05;
   
    @Size(max = 250,message="{com.cme.m_Val_fieldSize}")
    private String srvFlex06;
   
    @Size(max = 250,message="{com.cme.m_Val_fieldSize}")
    private String srvFlex07;
   
    @Size(max = 250,message="{com.cme.m_Val_fieldSize}")
    private String srvFlex08;
   
    @Size(max = 250,message="{com.cme.m_Val_fieldSize}")
    private String srvFlex09;
   
    @Size(max = 250,message="{com.cme.m_Val_fieldSize}")
    private String srvFlex10;
   
    private BigInteger srvMaxSendRetry;
    
    
    
    private State currentState = State.NONE;
    private String viewMessage;
    private String deleteMessage;
    private String editMessage;
    
    
    
   

/**
 * Creates a new instance of serviceBean
*/
    public serviceBean() {
        servSession = new ServiceMastFacade();
        customMsg = new ReadResourceBundle();
        viewMessage = customMsg.getCustomMessage("msgs", "m_AlertNothing");
        deleteMessage = customMsg.getCustomMessage("msgs", "m_Alert_DeleteFlag");
        editMessage = customMsg.getCustomMessage("msgs", "m_Alert_SaveChanges");
    }
    
/**
 * * Getter & Setter
*    @return
*/
     public void setCurrentState(State state){
        currentState = state;
    }
    
    public State getCurrentState(){
        return currentState;
    }
    
    public String getListStateImage(){
        return tableStateImage.get(currentState.name());
    }
    
    public String getRecordStateImage(){
        return recordStateImage.get(currentState.name());
    }

    public List<ServiceMast> getDetailRecord() {
        return detailRecord;
    }

    public void setDetailRecord(List<ServiceMast> detailRecord) {
        this.detailRecord = detailRecord;
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

    public String getSrvLanCode() {
        return srvLanCode;
    }

    public void setSrvLanCode(String srvLanCode) {
        this.srvLanCode = srvLanCode;
    }

    public String getSrvCurrCode() {
        return srvCurrCode;
    }

    public void setSrvCurrCode(String srvCurrCode) {
        this.srvCurrCode = srvCurrCode;
    }

    public Date getSrvStartDate() {
        return srvStartDate;
    }

    public void setSrvStartDate(Date srvStartDate) {
        this.srvStartDate = srvStartDate;
    }

    public String getSrvAddUid() {
        return srvAddUid;
    }

    public void setSrvAddUid(String srvAddUid) {
        this.srvAddUid = srvAddUid;
    }

    public String getSrvFlex02() {
        return srvFlex02;
    }

    public void setSrvFlex02(String srvFlex02) {
        this.srvFlex02 = srvFlex02;
    }
    
    
    public int getFlex6List() {
        return Flex6List;
    }

    public void setFlex6List(int Flex6List) {
        this.Flex6List = Flex6List;
    }

    public int getFlex7List() {
        return Flex7List;
    }

    public void setFlex7List(int Flex7List) {
        this.Flex7List = Flex7List;
    }

    public int getFlex1List() {
        return Flex1List;
    }

    public void setFlex1List(int Flex1List) {
        this.Flex1List = Flex1List;
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

    
    public String getSrvSrtCode() {
        return srvSrtCode;
    }

    public void setSrvSrtCode(String srvSrtCode) {
        this.srvSrtCode = srvSrtCode;
    }


    public String getSrvDesc() {
        return srvDesc;
    }

    public void setSrvDesc(String srvDesc) {
        this.srvDesc = srvDesc;
    }

    public String getSrvDescAR() {
        return srvDescAR;
    }

    public void setSrvDescAR(String srvDescAR) {
        this.srvDescAR = srvDescAR;
    }

    public String getSrvCode() {
        return srvCode;
    }

    public void setSrvCode(String srvCode) {
        this.srvCode = srvCode;
    }

    public String getSrvNameEn() {
        return srvNameEn;
    }

    public void setSrvNameEn(String srvNameEn) {
        this.srvNameEn = srvNameEn;
    }

    public String getSrvNameAR() {
        return srvNameAR;
    }

    public void setSrvNameAR(String srvNameAR) {
        this.srvNameAR = srvNameAR;
    }

    public String getSrvShortCode() {
        return srvShortCode;
    }

    public void setSrvShortCode(String srvShortCode) {
        this.srvShortCode = srvShortCode;
    }

    public String getSrvPrefName() {
        return srvPrefName;
    }

    public void setSrvPrefName(String srvPrefName) {
        this.srvPrefName = srvPrefName;
    }

    public String getSrvSubscriptionNeed() {
        return srvSubscriptionNeed;
    }

    public void setSrvSubscriptionNeed(String srvSubscriptionNeed) {
        this.srvSubscriptionNeed = srvSubscriptionNeed;
    }

    public String getSrvSubscriptionCodeEn() {
        return srvSubscriptionCodeEn;
    }

    public void setSrvSubscriptionCodeEn(String srvSubscriptionCodeEn) {
        this.srvSubscriptionCodeEn = srvSubscriptionCodeEn;
    }

    public String getSrvSubscriptionCodeAr() {
        return srvSubscriptionCodeAr;
    }

    public void setSrvSubscriptionCodeAr(String srvSubscriptionCodeAr) {
        this.srvSubscriptionCodeAr = srvSubscriptionCodeAr;
    }

    public String getSrvUnsubscribeCodeEn() {
        return srvUnsubscribeCodeEn;
    }

    public void setSrvUnsubscribeCodeEn(String srvUnsubscribeCodeEn) {
        this.srvUnsubscribeCodeEn = srvUnsubscribeCodeEn;
    }

    public String getSrvUnsubscribeCodeAr() {
        return srvUnsubscribeCodeAr;
    }

    public void setSrvUnsubscribeCodeAr(String srvUnsubscribeCodeAr) {
        this.srvUnsubscribeCodeAr = srvUnsubscribeCodeAr;
    }

    public String getSrvSubService() {
        return srvSubService;
    }

    public void setSrvSubService(String srvSubService) {
        this.srvSubService = srvSubService;
    }

    public String getSrvSenderId() {
        return srvSenderId;
    }

    public void setSrvSenderId(String srvSenderId) {
        this.srvSenderId = srvSenderId;
    }

    public String getSrvSenderIdDyn() {
        return srvSenderIdDyn;
    }

    public void setSrvSenderIdDyn(String srvSenderIdDyn) {
        this.srvSenderIdDyn = srvSenderIdDyn;
    }

    public BigDecimal getSrvTariff() {
        return srvTariff;
    }

    public void setSrvTariff(BigDecimal srvTariff) {
        this.srvTariff = srvTariff;
    }

    public Short getSrvNumbPageTariff() {
        return srvNumbPageTariff;
    }

    public void setSrvNumbPageTariff(Short srvNumbPageTariff) {
        this.srvNumbPageTariff = srvNumbPageTariff;
    }

    public String getSrvOngoSubscriber() {
        return srvOngoSubscriber;
    }

    public void setSrvOngoSubscriber(String srvOngoSubscriber) {
        this.srvOngoSubscriber = srvOngoSubscriber;
    }

    public String getSrvOngoFrom() {
        return srvOngoFrom;
    }

    public void setSrvOngoFrom(String srvOngoFrom) {
        this.srvOngoFrom = srvOngoFrom;
    }

    public String getSrvCheckpoint() {
        return srvCheckpoint;
    }

    public void setSrvCheckpoint(String srvCheckpoint) {
        this.srvCheckpoint = srvCheckpoint;
    }

    public String getSrvStatus() {
        return srvStatus;
    }

    public void setSrvStatus(String srvStatus) {
        this.srvStatus = srvStatus;
    }

    public Date getSrvAddDate() {
        return srvAddDate;
    }

    public void setSrvAddDate(Date srvAddDate) {
        this.srvAddDate = srvAddDate;
    }

    public String getSrvUpdUid() {
        return srvUpdUid;
    }

    public void setSrvUpdUid(String srvUpdUid) {
        this.srvUpdUid = srvUpdUid;
    }

    public Date getSrvUpdDate() {
        return srvUpdDate;
    }
    

    public void setSrvUpdDate(Date srvUpdDate) {
        this.srvUpdDate = srvUpdDate;
    }

    public String getSrvScatCode() {
        return srvScatCode;
    }

    public void setSrvScatCode(String srvScatCode) {
        this.srvScatCode = srvScatCode;
    }
    

    public String getSrvFlex01() {
        return srvFlex01;
    }

    public void setSrvFlex01(String srvFlex01) {
        this.srvFlex01 = srvFlex01;
    }

    public String getSrvFlex03() {
        return srvFlex03;
    }

    public void setSrvFlex03(String srvFlex03) {
        this.srvFlex03 = srvFlex03;
    }

    public String getSrvFlex04() {
        return srvFlex04;
    }

    public void setSrvFlex04(String srvFlex04) {
        this.srvFlex04 = srvFlex04;
    }

    public String getSrvFlex05() {
        return srvFlex05;
    }

    public void setSrvFlex05(String srvFlex05) {
        this.srvFlex05 = srvFlex05;
    }

    public String getSrvFlex06() {
        return srvFlex06;
    }

    public void setSrvFlex06(String srvFlex06) {
        this.srvFlex06 = srvFlex06;
    }

    public String getSrvFlex07() {
        return srvFlex07;
    }

    public void setSrvFlex07(String srvFlex07) {
        this.srvFlex07 = srvFlex07;
    }

    public String getSrvFlex08() {
        return srvFlex08;
    }

    public void setSrvFlex08(String srvFlex08) {
        this.srvFlex08 = srvFlex08;
    }
    
    public String getSrvFlex09() {
        return srvFlex09;
    }

    public void setSrvFlex09(String srvFlex09) {
        this.srvFlex09 = srvFlex09;
    }

    public String getSrvFlex10() {
        return srvFlex10;
    }

    public void setSrvFlex10(String srvFlex10) {
        this.srvFlex10 = srvFlex10;
    }

    public BigInteger getSrvMaxSendRetry() {
        return srvMaxSendRetry;
    }

    public void setSrvMaxSendRetry(BigInteger srvMaxSendRetry) {
        this.srvMaxSendRetry = srvMaxSendRetry;
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

  
    public subServiceBean getSubservice() {
        return subservice;
    }

    public void setSubservice(subServiceBean subservice) {
        this.subservice = subservice;
    }

    public LocalChanger getLocalChanger() {
        return localChanger;
    }

    public void setLocalChanger(LocalChanger localChanger) {
        this.localChanger = localChanger;
    }
    
    

    public ServiceMast getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(ServiceMast serviceEntity) {
        this.serviceEntity = serviceEntity;
    }
    
   

//List of ServiceMast & Select
    
    public List<ServiceListRecord> getServicesList(){
        
        servicesList= new ArrayList<ServiceListRecord>();
        List<ServiceMast> list = servSession.getServList();
      
        for(ServiceMast record:list)
            servicesList.add(new ServiceListRecord(record));
                
        return servicesList;
    }


    public void setServicesList(List<ServiceListRecord> servicesList) {
        this.servicesList = servicesList;
    }
    
    
    
    public DataModel<ServiceMast> getAllServices(){
        return servSession.getServiceTable();
    }
    
    public int getServiceCount(){
        return servSession.count();
    }
   
    public List<ServiceMast> getRecordDetail(){
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
    
    public String getServiceName(){
        String serviceName = "";
        ServiceMast result = servSession.getServName(servRecord.getSrvCode());
        if(localChanger.getDirection().equals("LTR"))
            serviceName = result.getSrvNameEn();
        else
            serviceName = result.getSrvNameAr();
        return serviceName;
    }

//Action


    
    public String assignService2SubService(String srvCode){
        setCurrentState(State.NONE);
        
        servRecord = new ServiceMast();
        servRecord.setSrvCode(srvCode);
        subservice.setSsrvSrvCode(servRecord);
        subservice.setCurrentState(State.VIEW);
        subservice.setCurrentDetailState(State.NONE);
        return "";
    }
    
    private void setAttrValues(){
        if(this.isStateAdd()){
            this.srvCode   = "";
            this.srvNameEn = "";
            this.srvNameAR = "";
            this.srvShortCode = "";
            this.srvStatus="A";
            this.srvPrefName = "";
            this.srvSubscriptionNeed   = "";
            this.srvSubscriptionCodeEn = "";
            this.srvSubscriptionCodeAr = "";
            this.srvUnsubscribeCodeEn = "";
            this.srvUnsubscribeCodeAr   = "";
            this.srvSubService = "";
            this.srvSenderId = "";
            this.srvSenderIdDyn = "";
//          this.srvTariff   = "";
//          this.srvNumbPageTariff = "";
            this.srvOngoSubscriber = "";
            this.srvOngoFrom = "";
            this.srvCheckpoint   = "";
//          this.srvStartDate = "";
            this.srvAddUid = "";
//          this.srvAddDate = "";
            this.srvUpdUid = "";
//          this.srvUpdDate = "";
            this.srvFlex01 = "";
            this.srvFlex02 = "";
            this.srvFlex03 = "";
            this.srvFlex04 = "";
            this.srvFlex05 = "";
            this.srvFlex06 = "";
            this.srvFlex07 = "";
            this.srvFlex08 = "";
            this.srvFlex09 = "";
            this.srvFlex10 = "";
//           this.srvMaxSendRetry = "";
            this.srvDesc = "";
            this.srvDescAR = "";
            this.srvSrtCode = "";
            this.srvLanCode = "";
            this.srvCurrCode = "";
            this.srvScatCode = "";
         
        }
        
        else
            
        {
            this.srvCode   = servRecord.getSrvCode();
            this.srvNameEn = servRecord.getSrvNameEn();
            this.srvNameAR = servRecord.getSrvNameAr();
            this.srvShortCode = servRecord.getSrvShortCode();
            this.srvStatus = servRecord.getSrvStatus();
            this.srvPrefName = servRecord.getSrvPrefName();
            this.srvSubscriptionNeed   = servRecord.getSrvSubscriptionNeed();
            this.srvSubscriptionCodeEn = servRecord.getSrvSubscriptionCodeEn();
            this.srvSubscriptionCodeAr = servRecord.getSrvUnsubscribeCodeAr();
            this.srvUnsubscribeCodeEn = servRecord.getSrvUnsubscribeCodeEn();
            this.srvUnsubscribeCodeAr = servRecord.getSrvUnsubscribeCodeAr();
            this.srvSubService = servRecord.getSrvSubService();
            this.srvSenderId   = servRecord.getSrvSenderId();
            this.srvSenderIdDyn = servRecord.getSrvSenderIdDyn();
            this.srvTariff = servRecord.getSrvTariff();
            this.srvNumbPageTariff = servRecord.getSrvNumbPageTariff();
            this.srvOngoSubscriber = servRecord.getSrvOngoSubscriber();
            this.srvOngoFrom = servRecord.getSrvOngoFrom();
            this.srvCheckpoint   = servRecord.getSrvCheckpoint();
            this.srvStartDate = servRecord.getSrvStartDate();
            this.srvAddUid = servRecord.getSrvAddUid();
            this.srvAddDate = servRecord.getSrvAddDate();
            this.srvUpdUid = servRecord.getSrvUpdUid();
            this.srvUpdDate = servRecord.getSrvUpdDate();
            this.srvFlex01 = servRecord.getSrvFlex01();
            this.srvFlex02 = servRecord.getSrvFlex02();
            this.srvFlex03 = servRecord.getSrvFlex03();
            this.srvFlex04 = servRecord.getSrvFlex04();
            this.srvFlex05 = servRecord.getSrvFlex05();
            this.srvFlex06 = servRecord.getSrvFlex06();
            this.srvFlex07 = servRecord.getSrvFlex07();
            this.srvFlex08 = servRecord.getSrvFlex08();
            this.srvFlex09 = servRecord.getSrvFlex09();
            this.srvFlex10 = servRecord.getSrvFlex10();
            this.srvMaxSendRetry = servRecord.getSrvMaxSendRetry();
            this.srvDesc = servRecord.getSrvDesc();
            this.srvDescAR = servRecord.getSrvDescAR();
            
            this.srvSrtCode = servRecord.getSrvSrtCode().getSrtCode();
//            
//            this.srvLanCode = servRecord.getSrvLanCode().getLanCode();
//            
//            this.srvCurrCode = servRecord.getSrvCurrCode().getCurrCode();
//            
//            this.srvScatCode = servRecord.getSrvScatCode().getScatCode();
          
        }

        
    }
    
     public String addRecord(){
        setCurrentState(State.ADD);
        subservice.setCurrentState(State.NONE);
        subservice.setCurrentDetailState(State.NONE);
        
        setAttrValues();
         ServiceMast   rec = new ServiceMast();
        detailRecord = new ArrayList<ServiceMast>();
        
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(rec);
        
        return "";
    }
    
    public String editRecord(ServiceMast rec){
        setCurrentState(State.EDIT);
        subservice.setCurrentState(State.NONE);
        subservice.setCurrentDetailState(State.NONE);
        
        servRecord = rec;
      
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServiceMast>();
        detailRecord.add(servRecord);
        return "";
    }
    
    public String viewRecord(ServiceMast rec){
        setCurrentState(State.VIEW);
        subservice.setCurrentState(State.NONE);
        subservice.setCurrentDetailState(State.NONE);
        
        servRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServiceMast>();
        detailRecord.add(servRecord);
        return "";
    }
    
    public String deleteRecord(ServiceMast rec){
        setCurrentState(State.DELETE);
        subservice.setCurrentState(State.NONE);
        subservice.setCurrentDetailState(State.NONE);
        
        servRecord = rec;
        setAttrValues();
        servRecord.setSrvStatus("D");
        srvStatus = "D";
      
        detailRecord = new ArrayList<ServiceMast>();
        detailRecord.add(servRecord);
        return "";
    }
    
    
    public String saveRecord(){
    
        servRecord=new ServiceMast();
        servRecord.setSrvCode(srvCode);
        servRecord.setSrvNameEn(srvNameEn);
        servRecord.setSrvShortCode(srvShortCode);
        servRecord.setSrvStatus(srvStatus);
        servRecord.setSrvPrefName(srvPrefName);
        servRecord.setSrvSubscriptionNeed(srvSubscriptionNeed);
        servRecord.setSrvSubscriptionCodeEn(srvSubscriptionCodeEn);
        servRecord.setSrvSubscriptionCodeAr(srvSubscriptionCodeAr);
        servRecord.setSrvUnsubscribeCodeEn(srvUnsubscribeCodeEn);
        servRecord.setSrvUnsubscribeCodeAr(srvUnsubscribeCodeAr);
        servRecord.setSrvSubService(srvSubService);
        servRecord.setSrvSenderId(srvSenderId);
        servRecord.setSrvSenderIdDyn(srvSenderIdDyn);
        servRecord.setSrvTariff(srvTariff);
        servRecord.setSrvNumbPageTariff(srvNumbPageTariff);
        servRecord.setSrvOngoSubscriber(srvOngoSubscriber);
        servRecord.setSrvOngoFrom(srvOngoFrom);
        servRecord.setSrvCheckpoint(srvCheckpoint);
        servRecord.setSrvStartDate(srvStartDate);
        servRecord.setSrvAddUid(srvAddUid);
        servRecord.setSrvAddDate(srvAddDate);
        servRecord.setSrvUpdUid(srvUpdUid);
        servRecord.setSrvUpdDate(srvUpdDate);
        servRecord.setSrvFlex01(srvFlex01);
        servRecord.setSrvFlex02(srvFlex02);
        servRecord.setSrvFlex03(srvFlex03);
        servRecord.setSrvFlex04(srvFlex04);
        servRecord.setSrvFlex05(srvFlex05);
        servRecord.setSrvFlex06(srvFlex06);
        servRecord.setSrvFlex07(srvFlex07);
        servRecord.setSrvFlex08(srvFlex08);
        servRecord.setSrvFlex09(srvFlex09);
        servRecord.setSrvFlex10(srvFlex10);
        ServiceType srtEntity = new ServiceType();
        srtEntity.setSrtCode(srvSrtCode);
        servRecord.setSrvSrtCode(srtEntity);
        CurrencyMast currEntity = new CurrencyMast();
        currEntity.setCurrCode(srvCurrCode);
        servRecord.setSrvCurrCode(currEntity);
        LanguageMast lanEntity = new LanguageMast();
        lanEntity.setLanCode(srvLanCode);
        servRecord.setSrvLanCode(lanEntity);
        ServiceCategory scatEntity = new ServiceCategory();
        scatEntity.setScatCode(srvScatCode);
        servRecord.setSrvScatCode(scatEntity);
        servRecord.setSrvMaxSendRetry(srvMaxSendRetry);
        servRecord.setSrvDesc(srvDesc);
        servRecord.setSrvDescAR(srvDescAR);
      
        
        
       if(currentState.equals(State.ADD)){
            if(isRecordValid()){
                servSession.create(servRecord);
                ServiceListRecord listRecord = new ServiceListRecord(servRecord);
                servicesList.add(listRecord);  
                stateRefresh();
            }
            else
            {
                 FacesContext.getCurrentInstance().addMessage("formRecord:srvCode", new FacesMessage(customMsg.getCustomMessage("msgs", "m_Alert_DupRecord")));
            }
            
        }
        else{
            servSession.edit(servRecord);
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
        for(ServiceMast iterate: servSession.getServList()){
            if(srvCode.equals(iterate.getSrvCode())){
                valid = false;
                break;
            }
        }
        return valid;
    }
    
    
    
    public String stateRefresh(){
        setCurrentState(State.NONE);
        
        servRecord = null;
              
        detailRecord = new ArrayList<ServiceMast>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(servRecord);
        
        getServicesList();
        
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

    public static class ServiceListRecord implements Serializable{
        private ServiceMast service;
        private boolean selected;
        
        public ServiceListRecord(){
            selected = false;
        }
        
        public ServiceListRecord(ServiceMast serv){
            service = serv;
            selected = false;
        }

        public ServiceMast getService() {
            return service;
        }

        public void setService(ServiceMast service) {
            this.service = service;
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
    
    public List<ServiceMast> getInfo(){
        return servSession.getSubservice(srvSubService);
    }
  
}
