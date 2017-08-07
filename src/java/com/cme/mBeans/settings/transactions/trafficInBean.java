/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.mBeans.settings.transactions;

import com.cme.entities.MessageIn;
import com.cme.facade.settings.MessageInFacade;
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
import javax.faces.bean.ManagedBean;
import java.util.Collection;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.AjaxBehaviorEvent;

import javax.faces.view.ViewScoped;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.richfaces.component.AbstractExtendedDataTable;
import org.richfaces.component.SortOrder;

/**
 *
 * @author admin
 */
@ManagedBean(name = "trafficIn")
@ViewScoped
public class trafficInBean {
    
    @EJB
    private MessageInFacade inSession;
    private MessageIn inRecord;
    private List<MessageIn> detailInRecord;
   
    private List<InListRecord> inList;
    @ManagedProperty(value="#{CommonObjects}")
  //  private  int rowCount;
    private CommonObjects rowCount;
    private String nameFilter;
    private String stateFilterValue="";
    private String senderFilter;
    private String senderFilterValue="";  
    private String receiverFilter;
    private String receiverFilterValue="";
    private String sendFilter;
    private String sendFilterValue="";
    private Date receiveFilter;
    private String receiveFilterValue="";
     private String srvFilter;
    private String srvFilterValue="";
     private String ssrvFilter;
    private String ssrvFilterValue="";
     private String statusFilter;
    private String statusFilterValue="";

    @NotNull
    @Column(name = "MIN_ID")
    private Long minId;
    @Size(max = 30)
    @Column(name = "MIN_SMS_ID")
    private String minSmsId;
    @Size(max = 20)
    @Column(name = "MIN_SENDER")
    private String minSender;
    @Size(max = 20)
    @Column(name = "MIN_RECEIVER")
    private String minReceiver;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MIN_RECEIVE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date minReceiveDatetime;
    @Column(name = "MIN_SEND_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date minSendDatetime;
    @Size(max = 2000)
    @Column(name = "MIN_MSG")
    private String minMsg;
    @Size(max = 10)
    @Column(name = "MIN_LAN_CODE")
    private String minLanCode;
    @Column(name = "MIN_NUMB_PAGE")
    private Short minNumbPage;
    @Size(max = 10)
    @Column(name = "MIN_STATUS")
    private String minStatus;
    @Size(max = 30)
    @Column(name = "MIN_SRV_CODE")
    private String minSrvCode;
    @Size(max = 30)
    @Column(name = "MIN_SSRV_CODE")
    private String minSsrvCode;
    @Column(name = "MIN_SRV_REF")
    private Long minSrvRef;
    @Size(max = 250)
    @Column(name = "MIN_FLEX01")
    private String minFlex01;
    @Size(max = 250)
    @Column(name = "MIN_FLEX02")
    private String minFlex02;
    @Size(max = 250)
    @Column(name = "MIN_FLEX03")
    private String minFlex03;
    @Size(max = 250)
    @Column(name = "MIN_FLEX04")
    private String minFlex04;
    @Size(max = 250)
    @Column(name = "MIN_FLEX05")
    private String minFlex05;
    @Size(max = 250)
    @Column(name = "MIN_FLEX06")
    private String minFlex06;
    @Size(max = 250)
    @Column(name = "MIN_FLEX07")
    private String minFlex07;
    @Size(max = 250)
    @Column(name = "MIN_FLEX08")
    private String minFlex08;
    @Size(max = 250)
    @Column(name = "MIN_FLEX09")
    private String minFlex09;
    @Size(max = 250)
    @Column(name = "MIN_FLEX10")
    private String minFlex10;
    private ReadResourceBundle customMsg;
    private CommonObjects.State currentState = CommonObjects.State.NONE;
  
    private SortOrder minIdOrder = SortOrder.unsorted;
    private SortOrder minSmsIdOrder = SortOrder.unsorted;
    private SortOrder minSenderOrder = SortOrder.unsorted;
    private SortOrder minRecieverOrder = SortOrder.unsorted;
    private SortOrder minReceiveDateOrder = SortOrder.unsorted;
    private SortOrder minSendDateOrder = SortOrder.unsorted;
    private SortOrder minMsgOrder = SortOrder.unsorted;
    private SortOrder minLanCodeOrder = SortOrder.unsorted;
    private SortOrder minNumPageOrder = SortOrder.unsorted;
    private SortOrder minSrvCodeOrder = SortOrder.unsorted;
    private SortOrder minSrvRefOrder = SortOrder.unsorted;
    private SortOrder minSsrvCodeOrder = SortOrder.unsorted;
    private SortOrder minStatusOrder = SortOrder.unsorted;



    public trafficInBean() {
        inSession = new MessageInFacade();
        customMsg = new ReadResourceBundle();
       // commonObj = new CommonObjects();
       // rowCount = commonObj.ROW_COUNT;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    
    
    //filters Setters and getters

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

    public String getSenderFilter() {
        return senderFilter;
    }

    public void setSenderFilter(String senderFilter) {
        this.senderFilter = senderFilter;
    }

    public String getSenderFilterValue() {
        return senderFilterValue;
    }

    public void setSenderFilterValue(String senderFilterValue) {
        this.senderFilterValue = senderFilterValue;
    }

    public String getReceiverFilter() {
        return receiverFilter;
    }

    public void setReceiverFilter(String receiverFilter) {
        this.receiverFilter = receiverFilter;
    }

    public String getReceiverFilterValue() {
        return receiverFilterValue;
    }

    public void setReceiverFilterValue(String receiverFilterValue) {
        this.receiverFilterValue = receiverFilterValue;
    }

    public String getSendFilter() {
        return sendFilter;
    }

    public void setSendFilter(String sendFilter) {
        this.sendFilter = sendFilter;
    }

    public String getSendFilterValue() {
        return sendFilterValue;
    }

    public void setSendFilterValue(String sendFilterValue) {
        this.sendFilterValue = sendFilterValue;
    }

    public Date getReceiveFilter() {
        return receiveFilter;
    }

    public void setReceiveFilter(Date receiveFilter) {
        this.receiveFilter = receiveFilter;
    }

 

    public String getReceiveFilterValue() {
        return receiveFilterValue;
    }

    public void setReceiveFilterValue(String receiveFilterValue) {
        this.receiveFilterValue = receiveFilterValue;
    }

    public String getSrvFilter() {
        return srvFilter;
    }

    public void setSrvFilter(String srvFilter) {
        this.srvFilter = srvFilter;
    }

    public String getSrvFilterValue() {
        return srvFilterValue;
    }

    public void setSrvFilterValue(String srvFilterValue) {
        this.srvFilterValue = srvFilterValue;
    }

    public String getSsrvFilter() {
        return ssrvFilter;
    }

    public void setSsrvFilter(String ssrvFilter) {
        this.ssrvFilter = ssrvFilter;
    }

    public String getSsrvFilterValue() {
        return ssrvFilterValue;
    }

    public void setSsrvFilterValue(String ssrvFilterValue) {
        this.ssrvFilterValue = ssrvFilterValue;
    }

    public String getStatusFilter() {
        return statusFilter;
    }

    public void setStatusFilter(String statusFilter) {
        this.statusFilter = statusFilter;
    }

    public String getStatusFilterValue() {
        return statusFilterValue;
    }

    public void setStatusFilterValue(String statusFilterValue) {
        this.statusFilterValue = statusFilterValue;
    }

  
    
    
    //sorting Action
     public void sortByMinCode(){
        
        minSmsIdOrder = SortOrder.unsorted;
        minMsgOrder = SortOrder.unsorted;
        minStatusOrder = SortOrder.unsorted;
        minSenderOrder = SortOrder.unsorted;
        minReceiveDateOrder = SortOrder.unsorted;
        minSendDateOrder = SortOrder.unsorted;
        minLanCodeOrder = SortOrder.unsorted;
        minNumPageOrder = SortOrder.unsorted;
        minSrvCodeOrder = SortOrder.unsorted;
        minSsrvCodeOrder = SortOrder.unsorted;
        minSrvRefOrder = SortOrder.unsorted;
        minRecieverOrder = SortOrder.unsorted;

                        
        if(minIdOrder.equals(SortOrder.ascending)){
            setMinIdOrder(SortOrder.descending); 
        }
        else
        {
            setMinIdOrder(SortOrder.ascending); 
        }
    }
      public void sortBySmsIdCode(){
        
        minIdOrder = SortOrder.unsorted;
        minMsgOrder = SortOrder.unsorted;
        minStatusOrder = SortOrder.unsorted;
        minSenderOrder = SortOrder.unsorted;
        minReceiveDateOrder = SortOrder.unsorted;
        minSendDateOrder = SortOrder.unsorted;
        minLanCodeOrder = SortOrder.unsorted;
        minNumPageOrder = SortOrder.unsorted;
        minSrvCodeOrder = SortOrder.unsorted;
        minSsrvCodeOrder = SortOrder.unsorted;
        minSrvRefOrder = SortOrder.unsorted;
        minRecieverOrder = SortOrder.unsorted;

                        
        if(minSmsIdOrder.equals(SortOrder.ascending)){
            setMinSmsIdOrder(SortOrder.descending); 
        }
        else
        {
            setMinSmsIdOrder(SortOrder.ascending); 
        }
    }
       public void sortByMinMsg(){
        
        minSmsIdOrder = SortOrder.unsorted;
        minIdOrder = SortOrder.unsorted;
        minStatusOrder = SortOrder.unsorted;
        minSenderOrder = SortOrder.unsorted;
        minReceiveDateOrder = SortOrder.unsorted;
        minSendDateOrder = SortOrder.unsorted;
        minLanCodeOrder = SortOrder.unsorted;
        minNumPageOrder = SortOrder.unsorted;
        minSrvCodeOrder = SortOrder.unsorted;
        minSsrvCodeOrder = SortOrder.unsorted;
        minSrvRefOrder = SortOrder.unsorted;
        minRecieverOrder = SortOrder.unsorted;

                        
        if(minMsgOrder.equals(SortOrder.ascending)){
            setMinMsgOrder(SortOrder.descending); 
        }
        else
        {
            setMinMsgOrder(SortOrder.ascending); 
        }
    }
        public void sortByMinStatus(){
        
        minSmsIdOrder = SortOrder.unsorted;
        minMsgOrder = SortOrder.unsorted;
        minStatusOrder = SortOrder.unsorted;
        minSenderOrder = SortOrder.unsorted;
        minReceiveDateOrder = SortOrder.unsorted;
        minSendDateOrder = SortOrder.unsorted;
        minLanCodeOrder = SortOrder.unsorted;
        minNumPageOrder = SortOrder.unsorted;
        minSrvCodeOrder = SortOrder.unsorted;
        minSsrvCodeOrder = SortOrder.unsorted;
        minSrvRefOrder = SortOrder.unsorted;
        minRecieverOrder = SortOrder.unsorted;

                        
        if(minStatusOrder.equals(SortOrder.ascending)){
            setMinStatusOrder(SortOrder.descending); 
        }
        else
        {
            setMinStatusOrder(SortOrder.ascending); 
        }
    }
         public void sortByMinSender(){
        
        minSmsIdOrder = SortOrder.unsorted;
        minMsgOrder = SortOrder.unsorted;
        minStatusOrder = SortOrder.unsorted;
        minSenderOrder = SortOrder.unsorted;
        minReceiveDateOrder = SortOrder.unsorted;
        minSendDateOrder = SortOrder.unsorted;
        minLanCodeOrder = SortOrder.unsorted;
        minNumPageOrder = SortOrder.unsorted;
        minSrvCodeOrder = SortOrder.unsorted;
        minSsrvCodeOrder = SortOrder.unsorted;
        minSrvRefOrder = SortOrder.unsorted;
        minRecieverOrder = SortOrder.unsorted;

                        
        if(minSenderOrder.equals(SortOrder.ascending)){
            setMinSenderOrder(SortOrder.descending); 
        }
        else
        {
            setMinSenderOrder(SortOrder.ascending); 
        }
    }
          public void sortByMinReceiveDate(){
        
        minSmsIdOrder = SortOrder.unsorted;
        minMsgOrder = SortOrder.unsorted;
        minStatusOrder = SortOrder.unsorted;
        minSenderOrder = SortOrder.unsorted;
        minIdOrder = SortOrder.unsorted;
        minSendDateOrder = SortOrder.unsorted;
        minLanCodeOrder = SortOrder.unsorted;
        minNumPageOrder = SortOrder.unsorted;
        minSrvCodeOrder = SortOrder.unsorted;
        minSsrvCodeOrder = SortOrder.unsorted;
        minSrvRefOrder = SortOrder.unsorted;
        minRecieverOrder = SortOrder.unsorted;

                        
        if(minReceiveDateOrder.equals(SortOrder.ascending)){
            setMinReceiveDateOrder(SortOrder.descending); 
        }
        else
        {
            setMinReceiveDateOrder(SortOrder.ascending); 
        }
    }
           public void sortBySendDate(){
        
        minSmsIdOrder = SortOrder.unsorted;
        minMsgOrder = SortOrder.unsorted;
        minStatusOrder = SortOrder.unsorted;
        minSenderOrder = SortOrder.unsorted;
        minReceiveDateOrder = SortOrder.unsorted;
        minSendDateOrder = SortOrder.unsorted;
        minLanCodeOrder = SortOrder.unsorted;
        minNumPageOrder = SortOrder.unsorted;
        minSrvCodeOrder = SortOrder.unsorted;
        minSsrvCodeOrder = SortOrder.unsorted;
        minSrvRefOrder = SortOrder.unsorted;
        minRecieverOrder = SortOrder.unsorted;

                        
        if(minSendDateOrder.equals(SortOrder.ascending)){
            setMinSendDateOrder(SortOrder.descending); 
        }
        else
        {
            setMinSendDateOrder(SortOrder.ascending); 
        }
    }
            public void sortByMinLanCode(){
        
        minSmsIdOrder = SortOrder.unsorted;
        minMsgOrder = SortOrder.unsorted;
        minStatusOrder = SortOrder.unsorted;
        minSenderOrder = SortOrder.unsorted;
        minReceiveDateOrder = SortOrder.unsorted;
        minSendDateOrder = SortOrder.unsorted;
        minIdOrder = SortOrder.unsorted;
        minNumPageOrder = SortOrder.unsorted;
        minSrvCodeOrder = SortOrder.unsorted;
        minSsrvCodeOrder = SortOrder.unsorted;
        minSrvRefOrder = SortOrder.unsorted;
        minRecieverOrder = SortOrder.unsorted;

                        
        if(minLanCodeOrder.equals(SortOrder.ascending)){
            setMinLanCodeOrder(SortOrder.descending); 
        }
        else
        {
            setMinLanCodeOrder(SortOrder.ascending); 
        }
    }
             public void sortByNumPage(){
        
        minSmsIdOrder = SortOrder.unsorted;
        minMsgOrder = SortOrder.unsorted;
        minStatusOrder = SortOrder.unsorted;
        minSenderOrder = SortOrder.unsorted;
        minReceiveDateOrder = SortOrder.unsorted;
        minSendDateOrder = SortOrder.unsorted;
        minLanCodeOrder = SortOrder.unsorted;
        minIdOrder = SortOrder.unsorted;
        minSrvCodeOrder = SortOrder.unsorted;
        minSsrvCodeOrder = SortOrder.unsorted;
        minSrvRefOrder = SortOrder.unsorted;
        minRecieverOrder = SortOrder.unsorted;

                        
        if(minNumPageOrder.equals(SortOrder.ascending)){
            setMinNumPageOrder(SortOrder.descending); 
        }
        else
        {
            setMinNumPageOrder(SortOrder.ascending); 
        }
    }
              public void sortByMinSrvCode(){
        
        minSmsIdOrder = SortOrder.unsorted;
        minMsgOrder = SortOrder.unsorted;
        minStatusOrder = SortOrder.unsorted;
        minSenderOrder = SortOrder.unsorted;
        minReceiveDateOrder = SortOrder.unsorted;
        minSendDateOrder = SortOrder.unsorted;
        minLanCodeOrder = SortOrder.unsorted;
        minNumPageOrder = SortOrder.unsorted;
        minIdOrder = SortOrder.unsorted;
        minSsrvCodeOrder = SortOrder.unsorted;
        minSrvRefOrder = SortOrder.unsorted;
        minRecieverOrder = SortOrder.unsorted;

                        
        if(minSrvCodeOrder.equals(SortOrder.ascending)){
            setMinSrvCodeOrder(SortOrder.descending); 
        }
        else
        {
            setMinSrvCodeOrder(SortOrder.ascending); 
        }
    }
               public void sortByMinSsrvCode(){
        
        minSmsIdOrder = SortOrder.unsorted;
        minMsgOrder = SortOrder.unsorted;
        minStatusOrder = SortOrder.unsorted;
        minSenderOrder = SortOrder.unsorted;
        minReceiveDateOrder = SortOrder.unsorted;
        minSendDateOrder = SortOrder.unsorted;
        minLanCodeOrder = SortOrder.unsorted;
        minNumPageOrder = SortOrder.unsorted;
        minSrvCodeOrder = SortOrder.unsorted;
        minIdOrder = SortOrder.unsorted;
        minSrvRefOrder = SortOrder.unsorted;
        minRecieverOrder = SortOrder.unsorted;

                        
        if(minSsrvCodeOrder.equals(SortOrder.ascending)){
            setMinSsrvCodeOrder(SortOrder.descending); 
        }
        else
        {
            setMinSsrvCodeOrder(SortOrder.ascending); 
        }
    }
                public void sortByMinSrvRef(){
        
        minSmsIdOrder = SortOrder.unsorted;
        minMsgOrder = SortOrder.unsorted;
        minStatusOrder = SortOrder.unsorted;
        minSenderOrder = SortOrder.unsorted;
        minReceiveDateOrder = SortOrder.unsorted;
        minSendDateOrder = SortOrder.unsorted;
        minLanCodeOrder = SortOrder.unsorted;
        minNumPageOrder = SortOrder.unsorted;
        minSrvCodeOrder = SortOrder.unsorted;
        minSsrvCodeOrder = SortOrder.unsorted;
        minIdOrder = SortOrder.unsorted;
        minRecieverOrder = SortOrder.unsorted;

                        
        if(minSrvRefOrder.equals(SortOrder.ascending)){
            setMinSrvRefOrder(SortOrder.descending); 
        }
        else
        {
            setMinSrvRefOrder(SortOrder.ascending); 
        }
    }
         public void sortByMinReciever(){
        
        minSmsIdOrder = SortOrder.unsorted;
        minMsgOrder = SortOrder.unsorted;
        minStatusOrder = SortOrder.unsorted;
        minSenderOrder = SortOrder.unsorted;
        minReceiveDateOrder = SortOrder.unsorted;
        minSendDateOrder = SortOrder.unsorted;
        minLanCodeOrder = SortOrder.unsorted;
        minNumPageOrder = SortOrder.unsorted;
        minSrvCodeOrder = SortOrder.unsorted;
        minSsrvCodeOrder = SortOrder.unsorted;
        minSrvRefOrder = SortOrder.unsorted;
        minIdOrder = SortOrder.unsorted;

                        
        if(minRecieverOrder.equals(SortOrder.ascending)){
            setMinRecieverOrder(SortOrder.descending); 
        }
        else
        {
            setMinRecieverOrder(SortOrder.ascending); 
        }
    }

    public CommonObjects getRowCount() {
        return rowCount;
    }

    public void setRowCount(CommonObjects rowCount) {
        this.rowCount = rowCount;
    }

//    public int getRowCount() {
//        return rowCount;
//    }
//
//    public void setRowCount(int rowCount) {
//        this.rowCount = rowCount;
//    }

        //setters and getters for ordering 

    public SortOrder getMinIdOrder() {
        return minIdOrder;
    }

    public void setMinIdOrder(SortOrder minIdOrder) {
        this.minIdOrder = minIdOrder;
    }

    public SortOrder getMinSmsIdOrder() {
        return minSmsIdOrder;
    }

    public void setMinSmsIdOrder(SortOrder minSmsIdOrder) {
        this.minSmsIdOrder = minSmsIdOrder;
    }

    public SortOrder getMinSenderOrder() {
        return minSenderOrder;
    }

    public void setMinSenderOrder(SortOrder minSenderOrder) {
        this.minSenderOrder = minSenderOrder;
    }

    public SortOrder getMinRecieverOrder() {
        return minRecieverOrder;
    }

    public void setMinRecieverOrder(SortOrder minRecieverOrder) {
        this.minRecieverOrder = minRecieverOrder;
    }

    public SortOrder getMinReceiveDateOrder() {
        return minReceiveDateOrder;
    }

    public void setMinReceiveDateOrder(SortOrder minReceiveDateOrder) {
        this.minReceiveDateOrder = minReceiveDateOrder;
    }

    public SortOrder getMinSendDateOrder() {
        return minSendDateOrder;
    }

    public void setMinSendDateOrder(SortOrder minSendDateOrder) {
        this.minSendDateOrder = minSendDateOrder;
    }

    public SortOrder getMinMsgOrder() {
        return minMsgOrder;
    }

    public void setMinMsgOrder(SortOrder minMsgOrder) {
        this.minMsgOrder = minMsgOrder;
    }

    public SortOrder getMinLanCodeOrder() {
        return minLanCodeOrder;
    }

    public void setMinLanCodeOrder(SortOrder minLanCodeOrder) {
        this.minLanCodeOrder = minLanCodeOrder;
    }

    public SortOrder getMinNumPageOrder() {
        return minNumPageOrder;
    }

    public void setMinNumPageOrder(SortOrder minNumPageOrder) {
        this.minNumPageOrder = minNumPageOrder;
    }

    public SortOrder getMinSrvCodeOrder() {
        return minSrvCodeOrder;
    }

    public void setMinSrvCodeOrder(SortOrder minSrvCodeOrder) {
        this.minSrvCodeOrder = minSrvCodeOrder;
    }

    public SortOrder getMinSrvRefOrder() {
        return minSrvRefOrder;
    }

    public void setMinSrvRefOrder(SortOrder minSrvRefOrder) {
        this.minSrvRefOrder = minSrvRefOrder;
    }

    public SortOrder getMinSsrvCodeOrder() {
        return minSsrvCodeOrder;
    }

    public void setMinSsrvCodeOrder(SortOrder minSsrvCodeOrder) {
        this.minSsrvCodeOrder = minSsrvCodeOrder;
    }

    public SortOrder getMinStatusOrder() {
        return minStatusOrder;
    }

    public void setMinStatusOrder(SortOrder minStatusOrder) {
        this.minStatusOrder = minStatusOrder;
    }

    
//      public boolean filterMinSmsId(Object current) {
//                MessageIn messageIn = (MessageIn)current;
//                if (stateFilterValue.length()==0) {
//                    return true;
//                }
//                if (messageIn.getMinSmsId().startsWith(stateFilterValue)) {
//                        return true;
//                }
//                else{
//                return false;
//            }
//     }
//      
//           
//        public boolean filterMinSender(Object current) {
//                MessageIn messageIn = (MessageIn)current;
//                if (senderFilterValue.length()==0) {
//                    return true;
//                }
//                if (messageIn.getMinSender().startsWith(senderFilterValue)) {
//                        return true;
//                }
//                else{
//                return false;
//            }
//     }
//        
//         public boolean filterMinReceiver(Object current) {
//                MessageIn messageIn = (MessageIn)current;
//                if (receiverFilterValue.length()==0) {
//                    return true;
//                }
//                if (messageIn.getMinReceiver().startsWith(receiverFilterValue)) {
//                        return true;
//                }
//                else{
//                return false;
//            }
//     }
//         
          public boolean filterReceiveDate(Object current) {
                MessageIn messageIn = (MessageIn)current;
                if (receiveFilterValue.length()==0) {
                    return true;
                }
                if (messageIn.getMinReceiveDatetime().equals(receiveFilterValue)) {
                        return true;
                }
                else{
                return false;
            }
     }
//           public boolean filterSendDate(Object current) {
//                MessageIn messageIn = (MessageIn)current;
//                if (sendFilterValue.length()==0) {
//                    return true;
//                }
//                if (messageIn.getMinSendDatetime().equals(sendFilterValue)) {
//                        return true;
//                }
//                else{
//                return false;
//            }
//     }
//           
//            public boolean filterStatus(Object current) {
//                MessageIn messageIn = (MessageIn)current;
//                if (statusFilterValue.length()==0) {
//                    return true;
//                }
//                if (messageIn.getMinStatus().startsWith(statusFilterValue)) {
//                        return true;
//                }
//                else{
//                return false;
//            }
//     }
//            
//             public boolean filterSrvCode(Object current) {
//                MessageIn messageIn = (MessageIn)current;
//                if (srvFilterValue.length()==0) {
//                    return true;
//                }
//                if (messageIn.getMinSrvCode().startsWith(srvFilterValue)) {
//                        return true;
//                }
//                else{
//                return false;
//            }
//     }
//             
//              public boolean filterSubSrvCode(Object current) {
//                MessageIn messageIn = (MessageIn)current;
//                if (ssrvFilterValue.length()==0) {
//                    return true;
//                }
//                if (messageIn.getMinSsrvCode().startsWith(ssrvFilterValue)) {
//                        return true;
//                }
//                else{
//                return false;
//            }
//     }

                 
//   //actiion
//    
//    private void setAttrValues(){
//        
//        if(this.isStateAdd()){
//          //  this.minId   =0;
//            this.minSmsId = "";
//            this.minSrvCode = "";
//            this.minSsrvCode = "";
//            this.minStatus = "";
//            this.minLanCode = "";
//            this.minNumbPage = 0;
//           // this.minSrvRef =0;
//            this.minReceiver = "";
//           // this.minReceiveDatetime ="";
//            this.minSender = "";
//            this.minMsg = "";
//
//            
//        }
//        else
//        {
//            this.minSendDatetime   = inRecord.getMinSendDatetime();
//            this.minReceiveDatetime = inRecord.getMinReceiveDatetime();
//            this.minMsg = inRecord.getMinMsg();
//            this.minNumbPage = inRecord.getMinNumbPage();
//            this.minStatus = inRecord.getMinStatus();
//            this.minId = inRecord.getMinId();
//            this.minSmsId = inRecord.getMinSmsId();
//            this.minSender = inRecord.getMinSender();
//            this.minReceiver = inRecord.getMinReceiver();
//            this.minSrvCode = inRecord.getMinSrvCode();
//            this.minSsrvCode = inRecord.getMinSsrvCode();
//            this.minLanCode = inRecord.getMinLanCode();
//            this.minSrvRef = inRecord.getMinSrvRef();
//        }
//
//        
//    }
          
  
    
    
    
    public String getListStateImage(){
        return tableStateImage.get(currentState.name());
    }
    
    public String getRecordStateImage(){
        return recordStateImage.get(currentState.name());
    }
    
    
    //Setters And Getters Of variables 

    public Long getMinId() {
        return minId;
    }

    public void setMinId(Long minId) {
        this.minId = minId;
    }

    public String getMinSmsId() {
        return minSmsId;
    }

    public void setMinSmsId(String minSmsId) {
        this.minSmsId = minSmsId;
    }

    public String getMinSender() {
        return minSender;
    }

    public void setMinSender(String minSender) {
        this.minSender = minSender;
    }

    public String getMinReceiver() {
        return minReceiver;
    }

    public void setMinReceiver(String minReceiver) {
        this.minReceiver = minReceiver;
    }

    public Date getMinReceiveDatetime() {
        return minReceiveDatetime;
    }

    public void setMinReceiveDatetime(Date minReceiveDatetime) {
        this.minReceiveDatetime = minReceiveDatetime;
    }

    public Date getMinSendDatetime() {
        return minSendDatetime;
    }

    public void setMinSendDatetime(Date minSendDatetime) {
        this.minSendDatetime = minSendDatetime;
    }

    public String getMinMsg() {
        return minMsg;
    }

    public void setMinMsg(String minMsg) {
        this.minMsg = minMsg;
    }

    public String getMinLanCode() {
        return minLanCode;
    }

    public void setMinLanCode(String minLanCode) {
        this.minLanCode = minLanCode;
    }

    public Short getMinNumbPage() {
        return minNumbPage;
    }

    public void setMinNumbPage(Short minNumbPage) {
        this.minNumbPage = minNumbPage;
    }

    public String getMinStatus() {
        return minStatus;
    }

    public void setMinStatus(String minStatus) {
        this.minStatus = minStatus;
    }

    public String getMinSrvCode() {
        return minSrvCode;
    }

    public void setMinSrvCode(String minSrvCode) {
        this.minSrvCode = minSrvCode;
    }

    public String getMinSsrvCode() {
        return minSsrvCode;
    }

    public void setMinSsrvCode(String minSsrvCode) {
        this.minSsrvCode = minSsrvCode;
    }

    public Long getMinSrvRef() {
        return minSrvRef;
    }

    public void setMinSrvRef(Long minSrvRef) {
        this.minSrvRef = minSrvRef;
    }

    public String getMinFlex01() {
        return minFlex01;
    }

    public void setMinFlex01(String minFlex01) {
        this.minFlex01 = minFlex01;
    }

    public String getMinFlex02() {
        return minFlex02;
    }

    public void setMinFlex02(String minFlex02) {
        this.minFlex02 = minFlex02;
    }

    public String getMinFlex03() {
        return minFlex03;
    }

    public void setMinFlex03(String minFlex03) {
        this.minFlex03 = minFlex03;
    }

    public String getMinFlex04() {
        return minFlex04;
    }

    public void setMinFlex04(String minFlex04) {
        this.minFlex04 = minFlex04;
    }

    public String getMinFlex05() {
        return minFlex05;
    }

    public void setMinFlex05(String minFlex05) {
        this.minFlex05 = minFlex05;
    }

    public String getMinFlex06() {
        return minFlex06;
    }

    public void setMinFlex06(String minFlex06) {
        this.minFlex06 = minFlex06;
    }

    public String getMinFlex07() {
        return minFlex07;
    }

    public void setMinFlex07(String minFlex07) {
        this.minFlex07 = minFlex07;
    }

    public String getMinFlex08() {
        return minFlex08;
    }

    public void setMinFlex08(String minFlex08) {
        this.minFlex08 = minFlex08;
    }

    public String getMinFlex09() {
        return minFlex09;
    }

    public void setMinFlex09(String minFlex09) {
        this.minFlex09 = minFlex09;
    }

    public String getMinFlex10() {
        return minFlex10;
    }

    public void setMinFlex10(String minFlex10) {
        this.minFlex10 = minFlex10;
    }

    public ReadResourceBundle getCustomMsg() {
        return customMsg;
    }

    public void setCustomMsg(ReadResourceBundle customMsg) {
        this.customMsg = customMsg;
    }
    
    
    //List Message In
    
    public List<InListRecord> getInList() {
        inList = new ArrayList<InListRecord>();
        List<MessageIn> list = inSession.getMessageInList(CommonObjects.ROW_COUNT);
        for(MessageIn record:list)
            inList.add(new InListRecord(record));
                
        return inList;
    }


    public void setInList(List<InListRecord> inList) {
        this.inList = inList;
    }
    
    //for popup window
    
    private List<InListRecord> selectionItems = new ArrayList<InListRecord>();
    private Collection<Object> selection;
     
    public void selectionListener(AjaxBehaviorEvent event) {
        AbstractExtendedDataTable dataTable = (AbstractExtendedDataTable) event.getComponent();
        Object originalKey = dataTable.getRowKey();
        selectionItems.clear();
        for (Object selectionKey : selection) {
            dataTable.setRowKey(selectionKey);
            if (dataTable.isRowAvailable()) {
                selectionItems.add((InListRecord) dataTable.getRowData());
            }
        }
        dataTable.setRowKey(originalKey);
    }
     
      public InListRecord getSelectionItem() {
        if (selectionItems == null || selectionItems.isEmpty()) {
            return null;
        }
        return selectionItems.get(0);
    }

    public List<InListRecord> getSelectionItems() {
        return selectionItems;
    }

    public void setSelectionItems(List<InListRecord> selectionItems) {
        this.selectionItems = selectionItems;
    }

    public Collection<Object> getSelection() {
        return selection;
    }

    public void setSelection(Collection<Object> selection) {
        this.selection = selection;
    }

 

    
     
     
 
   
    
    
    
    public int getMessageInCount(){
        return inSession.count();
    }
    
      // State getter
        public List<MessageIn> stateRefresh(){
        
        
        return inSession.getMessageInList(CommonObjects.ROW_COUNT);
    }
        
    public boolean isStateNone(){
        if(currentState.equals(CommonObjects.State.NONE) )
            return true;
        else
            return false;
    }
    

    
 
    
    
    
        public static class InListRecord implements Serializable{
        private MessageIn trafficIn;
        private boolean selected;
        

        public InListRecord(){
            selected = false;
        }
        
        public InListRecord(MessageIn in){
            trafficIn = in;
            selected = false;
        }

        public MessageIn getTrafficIn() {
            return trafficIn;
        }

        public void setTrafficIn(MessageIn trafficIn) {
            this.trafficIn = trafficIn;
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
