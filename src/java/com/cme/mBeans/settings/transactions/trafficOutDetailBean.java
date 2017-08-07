/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.mBeans.settings.transactions;

import com.cme.entities.MessageInDetail;
import com.cme.entities.MessageOutDetail;
import com.cme.facade.settings.MessageOutDetailFacade;
import com.cme.mBeans.common.CommonObjects;
import com.cme.mBeans.common.CommonObjects.State;
import com.cme.mBeans.common.ReadResourceBundle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author admin
 */
@ManagedBean(name = "trafficOutDetail")
@ViewScoped
public class trafficOutDetailBean {

     @EJB
    private MessageOutDetailFacade outDSession;
    private MessageOutDetail outDRecord;
    private List<MessageOutDetail> detailsOutRecord;
       private List<OutListRecordDetail> outDetailList;
    @NotNull
    @Column(name = "DOUT_ID")
    private Long doutId;
    @Column(name = "DOUT_MOUT_ID")
    private Long doutMoutId;
    @Size(max = 30)
    @Column(name = "DOUT_SMS_ID")
    private String doutSmsId;
    @Column(name = "DOUT_SEND_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doutSendDatetime;
    @Size(max = 2000)
    @Column(name = "DOUT_MSG")
    private String doutMsg;
    @Column(name = "DOUT_NUMB_PAGE")
    private Short doutNumbPage;
    @Size(max = 10)
    @Column(name = "DOUT_STATUS")
    private String doutStatus;
    @Size(max = 10)
    @Column(name = "DOUT_DELIVERED")
    private String doutDelivered;
    @Column(name = "DOUT_DELIV_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doutDelivDate;
    @Column(name = "DOUT_NUMB_RETRY")
    private Short doutNumbRetry;
    @Column(name = "DOUT_RETRY_LAST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doutRetryLast;
    @Column(name = "DOUT_SUBMITTED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doutSubmittedDate;
    @Column(name = "DOUT_DONE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doutDoneDate;
    @Size(max = 20)
    @Column(name = "DOUT_FINAL_STATUS")
    private String doutFinalStatus;
    @Size(max = 250)
    @Column(name = "DOUT_RESP_DET")
    private String doutRespDet;
    @Column(name = "DOUT_TOTAL_PAGE")
    private Short doutTotalPage;
    
    //setters and getters for variables 

    public Long getDoutId() {
        return doutId;
    }

    public void setDoutId(Long doutId) {
        this.doutId = doutId;
    }

    public Long getDoutMoutId() {
        return doutMoutId;
    }

    public void setDoutMoutId(Long doutMoutId) {
        this.doutMoutId = doutMoutId;
    }

    public String getDoutSmsId() {
        return doutSmsId;
    }

    public void setDoutSmsId(String doutSmsId) {
        this.doutSmsId = doutSmsId;
    }

    public Date getDoutSendDatetime() {
        return doutSendDatetime;
    }

    public void setDoutSendDatetime(Date doutSendDatetime) {
        this.doutSendDatetime = doutSendDatetime;
    }

    public String getDoutMsg() {
        return doutMsg;
    }

    public void setDoutMsg(String doutMsg) {
        this.doutMsg = doutMsg;
    }

    public Short getDoutNumbPage() {
        return doutNumbPage;
    }

    public void setDoutNumbPage(Short doutNumbPage) {
        this.doutNumbPage = doutNumbPage;
    }

    public String getDoutStatus() {
        return doutStatus;
    }

    public void setDoutStatus(String doutStatus) {
        this.doutStatus = doutStatus;
    }

    public String getDoutDelivered() {
        return doutDelivered;
    }

    public void setDoutDelivered(String doutDelivered) {
        this.doutDelivered = doutDelivered;
    }

    public Date getDoutDelivDate() {
        return doutDelivDate;
    }

    public void setDoutDelivDate(Date doutDelivDate) {
        this.doutDelivDate = doutDelivDate;
    }

    public Short getDoutNumbRetry() {
        return doutNumbRetry;
    }

    public void setDoutNumbRetry(Short doutNumbRetry) {
        this.doutNumbRetry = doutNumbRetry;
    }

    public Date getDoutRetryLast() {
        return doutRetryLast;
    }

    public void setDoutRetryLast(Date doutRetryLast) {
        this.doutRetryLast = doutRetryLast;
    }

    public Date getDoutSubmittedDate() {
        return doutSubmittedDate;
    }

    public void setDoutSubmittedDate(Date doutSubmittedDate) {
        this.doutSubmittedDate = doutSubmittedDate;
    }

    public Date getDoutDoneDate() {
        return doutDoneDate;
    }

    public void setDoutDoneDate(Date doutDoneDate) {
        this.doutDoneDate = doutDoneDate;
    }

    public String getDoutFinalStatus() {
        return doutFinalStatus;
    }

    public void setDoutFinalStatus(String doutFinalStatus) {
        this.doutFinalStatus = doutFinalStatus;
    }

    public String getDoutRespDet() {
        return doutRespDet;
    }

    public void setDoutRespDet(String doutRespDet) {
        this.doutRespDet = doutRespDet;
    }

    public Short getDoutTotalPage() {
        return doutTotalPage;
    }

    public void setDoutTotalPage(Short doutTotalPage) {
        this.doutTotalPage = doutTotalPage;
    }
    
     public State getCurrentDetailState() {
        return currentDetailState;
    }

    public void setCurrentDetailState(State currentDetailState) {
        this.currentDetailState = currentDetailState;
    }
    
    public int getOutDetailsCount(){
        return outDSession.count();
    }
   
    
    
    private CommonObjects.State currentState = CommonObjects.State.NONE;
    private CommonObjects.State currentDetailState = CommonObjects.State.NONE;
   
    private ReadResourceBundle customMsg;

    public List<OutListRecordDetail> getOutDetailList() {
        return outDetailList;
    }

    public void setInDetailList(List<OutListRecordDetail> outDetailList) {
        this.outDetailList = outDetailList;
    }
     
    
    
    public trafficOutDetailBean() {
      //  outDSession = new MessagenInDetailFacade();
              
        
    }
    
    
       
     
      public List<OutListRecordDetail> getMessageOutDetailList() {
        outDetailList = new ArrayList<OutListRecordDetail>();
        List<MessageOutDetail> list = outDSession.getOutDetailList();
        for(MessageOutDetail record:list)
            outDetailList.add(new OutListRecordDetail(record));
                
        return outDetailList;
    }


    public void setMessageOutDetailList(List<OutListRecordDetail> outDetailList) {
        this.outDetailList = outDetailList;
    }
     
     
           //Action
    public String viewDetails(Long moutId){
        setDoutMoutId(moutId);
        this.currentState = CommonObjects.State.VIEW;
        setCurrentDetailState(CommonObjects.State.NONE);

        return "";
    }
    
    
     public String stateDetailRefresh(){
        setCurrentDetailState(State.NONE);
        
        outDRecord = null;
              
        detailsOutRecord = new ArrayList<MessageOutDetail>();
        if (!detailsOutRecord.isEmpty())
            detailsOutRecord.clear();
        detailsOutRecord.add(outDRecord);
        
         getOutDetailList();
        
        return "";
    }
    
     public boolean isDetailStateDelete(){
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
    
    
    

    public static class OutListRecordDetail {
     private boolean selected;
        private MessageOutDetail outDetail;
        
        public OutListRecordDetail(MessageOutDetail trafficOutDetail) {
            outDetail = trafficOutDetail;
            selected = false;
            
          
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public MessageOutDetail getOutDetail() {
            return outDetail;
        }

        public void setOutDetail(MessageOutDetail outDetail) {
            this.outDetail = outDetail;
        }

   
        

        
        public void rowSelected(){
            this.selected = true;
        }
    }
}
