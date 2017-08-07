/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.mBeans.settings;

import com.cme.entities.ServicesVersionDetail;
import com.cme.facade.settings.ServicesVersionDetailFacade;
import com.cme.mBeans.common.CommonObjects;
import com.cme.mBeans.common.CommonObjects.State;
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
import com.cme.mBeans.common.ReadResourceBundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.richfaces.component.SortOrder;

/**
 *
 * @author admin
 */
@Named(value = "versionsDetail")
@ViewScoped
public class versionsDetailBean implements Serializable {
 @EJB
   
    private ServicesVersionDetailFacade verDSession;
    private ServicesVersionDetail verDRecord;
    private List<ServicesVersionDetail> detailsRecord;
   
    private List<VersionsListRecordDetail> versionsDetailList;
    
     @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String vedId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String vedVerId;
    private Integer vedSlno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String vedOsId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date vedCreated;
    @Temporal(TemporalType.TIMESTAMP)
    private Date vedReleased;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    private String vedStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date vedStatusDate;
    @Size(max = 350)
    private String vedFlex01;
    @Size(max = 350)
    private String vedFlex02;
      @Size(max = 350)
    private String vedFlex03;
    
    private CommonObjects.State currentState = CommonObjects.State.NONE;
    private State currentDetailState = State.NONE;


     //private CommonObjects.State currentState = CommonObjects.State.NONE;
    private String viewMessage;
    private String deleteMessage;
    private String editMessage;
    private ReadResourceBundle customMsg;
    private SortOrder vedIDOrder = SortOrder.unsorted;
    private SortOrder vedVerOrder = SortOrder.unsorted;
    private SortOrder statusOrder = SortOrder.unsorted;
    private SortOrder sequenceOrder = SortOrder.unsorted;

    
    
     public State getCurrentDetailState() {
        return currentDetailState;
    }

    public void setCurrentDetailState(State currentDetailState) {
        this.currentDetailState = currentDetailState;
    }
    public SortOrder getVedIDOrder() {
        return vedIDOrder;
    }

    public void setVedIDOrder(SortOrder vedIDOrder) {
        this.vedIDOrder = vedIDOrder;
    }

    public SortOrder getVedVerOrder() {
        return vedVerOrder;
    }

    public void setVedVerOrder(SortOrder vedVerOrder) {
        this.vedVerOrder = vedVerOrder;
    }

    public SortOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(SortOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    public SortOrder getSequenceOrder() {
        return sequenceOrder;
    }

    public void setSequenceOrder(SortOrder sequenceOrder) {
        this.sequenceOrder = sequenceOrder;
    }



    
     public int getDetailsCount(){
        return verDSession.count();
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
    
    
    public List<ServicesVersionDetail> getDetailsRecord() {
        return detailsRecord;
    }

    public void setDetailsRecord(List<ServicesVersionDetail> detailsRecord) {
        this.detailsRecord = detailsRecord;
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

    
    public String getVedId() {
        return vedId;
    }

    public void setVedId(String vedId) {
        this.vedId = vedId;
    }

    public Integer getVedSlno() {
        return vedSlno;
    }

    public void setVedSlno(Integer vedSlno) {
        this.vedSlno = vedSlno;
    }

    public String getVedOsId() {
        return vedOsId;
    }

    public void setVedOsId(String vedOsId) {
        this.vedOsId = vedOsId;
    }

    public Date getVedCreated() {
        return vedCreated;
    }

    public void setVedCreated(Date vedCreated) {
        this.vedCreated = vedCreated;
    }

    public Date getVedReleased() {
        return vedReleased;
    }

    public void setVedReleased(Date vedReleased) {
        this.vedReleased = vedReleased;
    }

    public String getVedStatus() {
        return vedStatus;
    }

    public void setVedStatus(String vedStatus) {
        this.vedStatus = vedStatus;
    }

    public Date getVedStatusDate() {
        return vedStatusDate;
    }

    public void setVedStatusDate(Date vedStatusDate) {
        this.vedStatusDate = vedStatusDate;
    }

    public String getVedFlex01() {
        return vedFlex01;
    }

    public String getVedFlex02() {
        return vedFlex02;
    }

    public void setVedFlex02(String vedFlex02) {
        this.vedFlex02 = vedFlex02;
    }

    public String getVedFlex03() {
        return vedFlex03;
    }

    public void setVedFlex03(String vedFlex03) {
        this.vedFlex03 = vedFlex03;
    }
    

    public void setVedFlex01(String vedFlex01) {
        this.vedFlex01 = vedFlex01;
    }

    public String getVedVerId() {
        return vedVerId;
    }

    public void setVedVerId(String vedVerId) {
        this.vedVerId = vedVerId;
    }
    
    
    

    
    public versionsDetailBean() {
       verDSession = new ServicesVersionDetailFacade();
        
    }
    
    
     public List<VersionsListRecordDetail> getVersionsDetailList() {
        versionsDetailList = new ArrayList<VersionsListRecordDetail>();
        List<ServicesVersionDetail> list = verDSession.getSelectedRow(vedVerId);
        for(ServicesVersionDetail record:list)
            versionsDetailList.add(new VersionsListRecordDetail(record));
                
        return versionsDetailList;
    }


    public void setVersionsDetailList(List<VersionsListRecordDetail> versionsDetailList) {
        this.versionsDetailList = versionsDetailList;
    }
//      public List<ServicesVersionDetail> getSelectedRow(){
//        return verDSession.getSelectedRow(vedId);
//    }
    
      
        //Action
    public String viewDetails(String verId){
        setVedVerId(verId);
        this.currentState = State.VIEW;
        setCurrentDetailState(State.NONE);

        return "";
    }
   
    
      private void setAttrValues(){
        if(this.isStateAdd()){
           
            this.vedFlex01 = "";
       //     this.vedCreated = new Date();
            this.vedId = "";
            this.vedOsId = "";
            this.vedSlno = 0;
            this.vedStatus = "ACTIVE";
       //     this.vedStatusDate = new Date();
       //     this.vedReleased = new Date();
            this.vedVerId = "";
            this.vedFlex02 = "";
            this.vedFlex03 = "";




        }
        else
        {
         
            this.vedCreated = verDRecord.getVedCreated();
            this.vedFlex01 = verDRecord.getVedFlex01();
            this.vedId = verDRecord.getVedId();
            this.vedOsId = verDRecord.getVedOsId();
            this.vedReleased = verDRecord.getVedReleased();
            this.vedSlno = verDRecord.getVedSlno();
            this.vedStatus = verDRecord.getVedStatus();
            this.vedStatusDate = verDRecord.getVedStatusDate();
            this.vedVerId = verDRecord.getVedVerId();
            this.vedFlex02 = verDRecord.getVedFlex01();
            this.vedFlex03 = verDRecord.getVedFlex01();

          
        }

        
    }
      
      public String addRecord(){
        setCurrentState(CommonObjects.State.ADD);
        setCurrentDetailState(State.ADD);

        setAttrValues();
        ServicesVersionDetail rec = new ServicesVersionDetail();
        detailsRecord = new ArrayList<ServicesVersionDetail>();
        
        if (!detailsRecord.isEmpty())
            detailsRecord.clear();
        detailsRecord.add(rec);
        
        return "";
    }
      
           
    public String editRecord(ServicesVersionDetail rec){
        setCurrentState(CommonObjects.State.EDIT);
        setCurrentDetailState(State.EDIT);

        verDRecord = rec;
        
        setAttrValues();
      
        detailsRecord = new ArrayList<ServicesVersionDetail>();
        detailsRecord.add(verDRecord);
        return "";
    }
    
    public String viewRecord(ServicesVersionDetail rec){
        setCurrentState(CommonObjects.State.VIEW);
                setCurrentDetailState(State.VIEW);

        verDRecord = rec;
        
        setAttrValues();
      
        detailsRecord = new ArrayList<ServicesVersionDetail>();
        detailsRecord.add(verDRecord);
        return "";
    }
    
    
    
    public String deleteRecord(ServicesVersionDetail rec){
        setCurrentState(CommonObjects.State.DELETE);
        setCurrentDetailState(State.DELETE);

        verDRecord = rec;
        setAttrValues();
        verDRecord.setVedStatus("D");
      
        detailsRecord = new ArrayList<ServicesVersionDetail>();
        detailsRecord.add(verDRecord);
        return "";
    }
    
    
    public String saveRecord(){
        verDRecord = new ServicesVersionDetail();
        verDRecord.setVedId(vedId);
        verDRecord.setVedCreated(vedCreated);
        verDRecord.setVedReleased(vedReleased);
        verDRecord.setVedStatus(vedStatus);
        verDRecord.setVedStatusDate(vedStatusDate);
        verDRecord.setVedFlex01(vedFlex01);
        verDRecord.setVedVerId(vedVerId);
        verDRecord.setVedSlno(vedSlno);
        verDRecord.setVedOsId(vedOsId);
        verDRecord.setVedFlex01(vedFlex02);
        verDRecord.setVedFlex01(vedFlex03);

        
       
               if(currentState.equals(CommonObjects.State.ADD)){
            if(isRecordValid()){
                verDSession.create(verDRecord);
                VersionsListRecordDetail listRecord = new VersionsListRecordDetail(verDRecord);
                versionsDetailList.add(listRecord);  
                stateRefresh();
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage("formRecord:vedCode", new FacesMessage(customMsg.getCustomMessage("msgs", "m_Alert_DupRecord")));
            }
            
        }
        else{
            verDSession.edit(verDRecord);
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
        for(ServicesVersionDetail iterate: verDSession.getDetailList()){
            if(vedId.equals(iterate.getVedId())){
                valid = false;
                break;
            }
        }
        return valid;
    }
    
    
    
    public String stateRefresh(){
        setCurrentState(CommonObjects.State.NONE);
        
        verDRecord = null;
              
        detailsRecord = new ArrayList<ServicesVersionDetail>();
        if (!detailsRecord.isEmpty())
            detailsRecord.clear();
        detailsRecord.add(verDRecord);
        
        getVersionsDetailList();
        
        return "";
    }
    
     public String stateDetailRefresh(){
        setCurrentDetailState(State.NONE);
        
        verDRecord = null;
              
        detailsRecord = new ArrayList<ServicesVersionDetail>();
        if (!detailsRecord.isEmpty())
            detailsRecord.clear();
        detailsRecord.add(verDRecord);
        
         getVersionsDetailList();
        
        return "";
    }
     public void sortByVedId(){
        
        statusOrder = SortOrder.unsorted;
        vedVerOrder = SortOrder.unsorted;
        sequenceOrder = SortOrder.unsorted;
        if(vedIDOrder.equals(SortOrder.ascending)){
            setVedIDOrder(SortOrder.descending); 
        }
        else
        {
            setVedIDOrder(SortOrder.ascending); 
        }
    }
      public void sortByStatus(){
        
        vedIDOrder = SortOrder.unsorted;
        vedVerOrder = SortOrder.unsorted;
        sequenceOrder = SortOrder.unsorted;
        if(statusOrder.equals(SortOrder.ascending)){
            setStatusOrder(SortOrder.descending); 
        }
        else
        {
            setStatusOrder(SortOrder.ascending); 
        }
    }
       public void sortByVedVer(){
        
        vedIDOrder = SortOrder.unsorted;
        statusOrder = SortOrder.unsorted;
        sequenceOrder = SortOrder.unsorted;
        if(vedVerOrder.equals(SortOrder.ascending)){
            setVedVerOrder(SortOrder.descending); 
        }
        else
        {
            setVedVerOrder(SortOrder.ascending); 
        }
    }
        public void sortBySequence(){
        
        vedIDOrder = SortOrder.unsorted;
        vedVerOrder = SortOrder.unsorted;
        statusOrder = SortOrder.unsorted;
        if(sequenceOrder.equals(SortOrder.ascending)){
            setSequenceOrder(SortOrder.descending); 
        }
        else
        {
            setSequenceOrder(SortOrder.ascending); 
        }
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
    
    
    

    public static class VersionsListRecordDetail {
     private boolean selected;
        private ServicesVersionDetail versionsDetail;
        
        public VersionsListRecordDetail(ServicesVersionDetail det) {
            versionsDetail = det;
            selected = false;
            
          
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public ServicesVersionDetail getVersionsDetail() {
            return versionsDetail;
        }

        public void setVersionsDetail(ServicesVersionDetail versionsDetail) {
            this.versionsDetail = versionsDetail;
        }

        
        public void rowSelected(){
            this.selected = true;
        }
    }
    
    
    
}
