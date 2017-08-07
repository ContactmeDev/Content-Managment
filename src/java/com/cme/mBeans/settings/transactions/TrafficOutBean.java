/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.mBeans.settings.transactions;

import com.cme.entities.MessageOut;
import com.cme.facade.settings.MessageOutFacade;
import com.cme.mBeans.common.CommonObjects;
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
import com.cme.mBeans.common.ReadResourceBundle;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.primefaces.model.chart.PieChartModel;
import org.richfaces.component.SortOrder;

/**
 *
 * @author admin
 */
@ManagedBean(name = "trafficOut")
@ViewScoped
public class TrafficOutBean {

    @EJB
    private MessageOutFacade outSession;
    private MessageOut outRecord;
    private List<MessageOut> detailOutRecord;
    private List<OutListRecord> outList;
    private SortOrder moutIdOrder = SortOrder.unsorted;
    private SortOrder moutSrvOrder = SortOrder.unsorted;
    private SortOrder moutSsrvOrder = SortOrder.unsorted;
    private SortOrder moutLanOrder = SortOrder.unsorted;
    private SortOrder moutStatusOrder = SortOrder.unsorted;
    private SortOrder moutSmsIdOrder = SortOrder.unsorted;
    private SortOrder moutDelivDateOrder = SortOrder.unsorted;
    private SortOrder moutSendDateOrder = SortOrder.unsorted;
    private SortOrder moutReceiveDateOrder = SortOrder.unsorted;
    
    @ManagedProperty(value="#{CommonObjects.rowCount}")
//    private  int rowCount;
    private CommonObjects rowCount;
    
     @NotNull
    @Column(name = "MOUT_ID")
    private Long moutId;
    @Size(max = 30)
    @Column(name = "MOUT_SMS_ID")
    private String moutSmsId;
    @Size(max = 20)
    @Column(name = "MOUT_SENDER")
    private String moutSender;
    @Size(max = 20)
    @Column(name = "MOUT_RECEIVER")
    private String moutReceiver;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOUT_RECEIVE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moutReceiveDatetime;
    @Column(name = "MOUT_SEND_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moutSendDatetime;
    @Size(max = 2000)
    @Column(name = "MOUT_MSG")
    private String moutMsg;
    @Size(max = 10)
    @Column(name = "MOUT_LAN_CODE")
    private String moutLanCode;
    @Column(name = "MOUT_NUMB_PAGE")
    private Short moutNumbPage;
    @Size(max = 10)
    @Column(name = "MOUT_STATUS")
    private String moutStatus;
    @Size(max = 10)
    @Column(name = "MOUT_DELIVERED")
    private String moutDelivered;
    @Column(name = "MOUT_DELIV_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moutDelivDate;
    @Column(name = "MOUT_NUMB_RETRY")
    private Short moutNumbRetry;
    @Column(name = "MOUT_RETRY_LAST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moutRetryLast;
    @Size(max = 30)
    @Column(name = "MOUT_SRV_CODE")
    private String moutSrvCode;
    @Size(max = 30)
    @Column(name = "MOUT_SSRV_CODE")
    private String moutSsrvCode;
    @Column(name = "MOUT_SRV_REF")
    private Long moutSrvRef;
    @Column(name = "MOUT_SWK_ID")
    private Long moutSwkId;
    @Column(name = "MOUT_MIN_ID")
    private Long moutMinId;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX01")
    private String moutFlex01;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX02")
    private String moutFlex02;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX03")
    private String moutFlex03;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX04")
    private String moutFlex04;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX05")
    private String moutFlex05;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX06")
    private String moutFlex06;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX07")
    private String moutFlex07;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX08")
    private String moutFlex08;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX09")
    private String moutFlex09;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX10")
    private String moutFlex10;
    @Column(name = "MOUT_NO_SUBMITTED")
    private BigInteger moutNoSubmitted;
    @Column(name = "MOUT_NO_DELIVRD")
    private BigInteger moutNoDelivrd;
    @Column(name = "MOUT_SUBMITTED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moutSubmittedDate;
    @Column(name = "MOUT_DONE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moutDoneDate;
    @Size(max = 20)
    @Column(name = "MOUT_FINAL_STATUS")
    private String moutFinalStatus;
    private String idFilter;
    private String smsIdFilter;
    private String senderFilter;
    private Date sendFilter;
    private String receiverFilter;
    private Date receiveFilter;
    private String statusFilter;
    private String deliveredFilter;
    private Date delivFilter;
    private String retryFilter;
    private String srvFilter;
    private String ssrvFilter;
    private String inIdFilter;
    private String swkIdFilter;
    
   

    private ReadResourceBundle customMsg;
    private CommonObjects.State currentState = CommonObjects.State.NONE;
    private String viewMessage;
    private String deleteMessage;
    private String editMessage;
     private PieChartModel pieModel1;
     
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     @PostConstruct
    public void init() {
        createPieModels();
    }
     
      private void createPieModels() {
        createPieModel1();
       
    }
      
      private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("Pending", outSession.getPendingMessages());
        pieModel1.set("Error", outSession.getErrorMessages());
        pieModel1.set("Not Send", outSession.getNotSendMessages());
        pieModel1.set("TimeOut", outSession.getToutMessages());
        pieModel1.set("Send", outSession.getSendMessages());
        
         
        pieModel1.setTitle("Messages Status");
        pieModel1.setLegendPosition("w");
    }
     
    public TrafficOutBean() {
        
         outSession = new MessageOutFacade();
        customMsg = new ReadResourceBundle();
        viewMessage = customMsg.getCustomMessage("msgs", "m_AlertNothing");
        deleteMessage = customMsg.getCustomMessage("msgs", "m_Alert_DeleteFlag");
        editMessage = customMsg.getCustomMessage("msgs", "m_Alert_SaveChanges");
//        commonObj = new CommonObjects();
//        rowCount = commonObj.ROW_COUNT;
    }
//    public List <MessageOut> getMsgStatus(){
//        MessageOut mout = null ;
//        mout.setMoutDelivered(outSession.getPendingMessages());
//        
//    }
    
    
    public Long getPendinCount()
    {
       Long count = outSession.getPendingMessages();
       return count;
    }
    
    public Long getNotSendCount()
    {
       Long count = outSession.getNotSendMessages();
       return count;
    }
    
    
    public Long getErrorCount()
    {
       Long count = outSession.getErrorMessages();
       return count;
    }
    
    
    public Long getSendCount()
    {
       Long count = outSession.getSendMessages();
       return count;
    }
    
    
    public Long getToutCount()
    {
       Long count = outSession.getToutMessages();
       return count;
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

    //setters and getters for filters

    public String getSwkIdFilter() {
        return swkIdFilter;
    }

    public void setSwkIdFilter(String swkIdFilter) {
        this.swkIdFilter = swkIdFilter;
    }
    
    
    public String getInIdFilter() {
        return inIdFilter;
    }

    public void setInIdFilter(String inIdFilter) {
        this.inIdFilter = inIdFilter;
    }
    
    

    public String getIdFilter() {
        return idFilter;
    }

    public void setIdFilter(String idFilter) {
        this.idFilter = idFilter;
    }

    public String getSmsIdFilter() {
        return smsIdFilter;
    }

    public void setSmsIdFilter(String smsIdFilter) {
        this.smsIdFilter = smsIdFilter;
    }

    public String getSenderFilter() {
        return senderFilter;
    }

    public void setSenderFilter(String senderFilter) {
        this.senderFilter = senderFilter;
    }

    public Date getSendFilter() {
        return sendFilter;
    }

    public void setSendFilter(Date sendFilter) {
        this.sendFilter = sendFilter;
    }

    public Date getReceiveFilter() {
        return receiveFilter;
    }

    public void setReceiveFilter(Date receiveFilter) {
        this.receiveFilter = receiveFilter;
    }

    public Date getDelivFilter() {
        return delivFilter;
    }

    public void setDelivFilter(Date delivFilter) {
        this.delivFilter = delivFilter;
    }

    

    public String getReceiverFilter() {
        return receiverFilter;
    }

    public void setReceiverFilter(String receiverFilter) {
        this.receiverFilter = receiverFilter;
    }

    

    public String getStatusFilter() {
        return statusFilter;
    }

    public void setStatusFilter(String statusFilter) {
        this.statusFilter = statusFilter;
    }

    public String getDeliveredFilter() {
        return deliveredFilter;
    }

    public void setDeliveredFilter(String deliveredFilter) {
        this.deliveredFilter = deliveredFilter;
    }

   

    public String getRetryFilter() {
        return retryFilter;
    }

    public void setRetryFilter(String retryFilter) {
        this.retryFilter = retryFilter;
    }

    public String getSrvFilter() {
        return srvFilter;
    }

    public void setSrvFilter(String srvFilter) {
        this.srvFilter = srvFilter;
    }

    public String getSsrvFilter() {
        return ssrvFilter;
    }

    public void setSsrvFilter(String ssrvFilter) {
        this.ssrvFilter = ssrvFilter;
    }
    
    
    
    
    //Setter and getters for sorting 

    public List<MessageOut> getDetailOutRecord() {
        return detailOutRecord;
    }

    public void setDetailOutRecord(List<MessageOut> detailOutRecord) {
        this.detailOutRecord = detailOutRecord;
    }

    public SortOrder getMoutIdOrder() {
        return moutIdOrder;
    }

    public void setMoutIdOrder(SortOrder moutIdOrder) {
        this.moutIdOrder = moutIdOrder;
    }

    public SortOrder getMoutSrvOrder() {
        return moutSrvOrder;
    }

    public void setMoutSrvOrder(SortOrder moutSrvOrder) {
        this.moutSrvOrder = moutSrvOrder;
    }

    public SortOrder getMoutSsrvOrder() {
        return moutSsrvOrder;
    }

    public void setMoutSsrvOrder(SortOrder moutSsrvOrder) {
        this.moutSsrvOrder = moutSsrvOrder;
    }

    public SortOrder getMoutLanOrder() {
        return moutLanOrder;
    }

    public void setMoutLanOrder(SortOrder moutLanOrder) {
        this.moutLanOrder = moutLanOrder;
    }

    public SortOrder getMoutStatusOrder() {
        return moutStatusOrder;
    }

    public void setMoutStatusOrder(SortOrder moutStatusOrder) {
        this.moutStatusOrder = moutStatusOrder;
    }

    public SortOrder getMoutSmsIdOrder() {
        return moutSmsIdOrder;
    }

    public void setMoutSmsIdOrder(SortOrder moutSmsIdOrder) {
        this.moutSmsIdOrder = moutSmsIdOrder;
    }

    public SortOrder getMoutDelivDateOrder() {
        return moutDelivDateOrder;
    }

    public void setMoutDelivDateOrder(SortOrder moutDelivDateOrder) {
        this.moutDelivDateOrder = moutDelivDateOrder;
    }

  

    public SortOrder getMoutSendDateOrder() {
        return moutSendDateOrder;
    }

    public void setMoutSendDateOrder(SortOrder moutSendDateOrder) {
        this.moutSendDateOrder = moutSendDateOrder;
    }

    public SortOrder getMoutReceiveDateOrder() {
        return moutReceiveDateOrder;
    }

    public void setMoutReceiveDateOrder(SortOrder moutReceiveDateOrder) {
        this.moutReceiveDateOrder = moutReceiveDateOrder;
    }
    
    
    
    //Setters And Getters for variables 

    public Long getMoutId() {
        return moutId;
    }

    public void setMoutId(Long moutId) {
        this.moutId = moutId;
    }

    public String getMoutSmsId() {
        return moutSmsId;
    }

    public void setMoutSmsId(String moutSmsId) {
        this.moutSmsId = moutSmsId;
    }

    public String getMoutSender() {
        return moutSender;
    }

    public void setMoutSender(String moutSender) {
        this.moutSender = moutSender;
    }

    public String getMoutReceiver() {
        return moutReceiver;
    }

    public void setMoutReceiver(String moutReceiver) {
        this.moutReceiver = moutReceiver;
    }

    public Date getMoutReceiveDatetime() {
        return moutReceiveDatetime;
    }

    public void setMoutReceiveDatetime(Date moutReceiveDatetime) {
        this.moutReceiveDatetime = moutReceiveDatetime;
    }

    public Date getMoutSendDatetime() {
        return moutSendDatetime;
    }

    public void setMoutSendDatetime(Date moutSendDatetime) {
        this.moutSendDatetime = moutSendDatetime;
    }

    public String getMoutMsg() {
        return moutMsg;
    }

    public void setMoutMsg(String moutMsg) {
        this.moutMsg = moutMsg;
    }

    public String getMoutLanCode() {
        return moutLanCode;
    }

    public void setMoutLanCode(String moutLanCode) {
        this.moutLanCode = moutLanCode;
    }

    public Short getMoutNumbPage() {
        return moutNumbPage;
    }

    public void setMoutNumbPage(Short moutNumbPage) {
        this.moutNumbPage = moutNumbPage;
    }

    public String getMoutStatus() {
        return moutStatus;
    }

    public void setMoutStatus(String moutStatus) {
        this.moutStatus = moutStatus;
    }

    public String getMoutDelivered() {
        return moutDelivered;
    }

    public void setMoutDelivered(String moutDelivered) {
        this.moutDelivered = moutDelivered;
    }

    public Date getMoutDelivDate() {
        return moutDelivDate;
    }

    public void setMoutDelivDate(Date moutDelivDate) {
        this.moutDelivDate = moutDelivDate;
    }

    public Short getMoutNumbRetry() {
        return moutNumbRetry;
    }

    public void setMoutNumbRetry(Short moutNumbRetry) {
        this.moutNumbRetry = moutNumbRetry;
    }

    public Date getMoutRetryLast() {
        return moutRetryLast;
    }

    public void setMoutRetryLast(Date moutRetryLast) {
        this.moutRetryLast = moutRetryLast;
    }

    public String getMoutSrvCode() {
        return moutSrvCode;
    }

    public void setMoutSrvCode(String moutSrvCode) {
        this.moutSrvCode = moutSrvCode;
    }

    public String getMoutSsrvCode() {
        return moutSsrvCode;
    }

    public void setMoutSsrvCode(String moutSsrvCode) {
        this.moutSsrvCode = moutSsrvCode;
    }

    public Long getMoutSrvRef() {
        return moutSrvRef;
    }

    public void setMoutSrvRef(Long moutSrvRef) {
        this.moutSrvRef = moutSrvRef;
    }

    public Long getMoutSwkId() {
        return moutSwkId;
    }

    public void setMoutSwkId(Long moutSwkId) {
        this.moutSwkId = moutSwkId;
    }

    public Long getMoutMinId() {
        return moutMinId;
    }

    public void setMoutMinId(Long moutMinId) {
        this.moutMinId = moutMinId;
    }

    public String getMoutFlex01() {
        return moutFlex01;
    }

    public void setMoutFlex01(String moutFlex01) {
        this.moutFlex01 = moutFlex01;
    }

    public String getMoutFlex02() {
        return moutFlex02;
    }

    public void setMoutFlex02(String moutFlex02) {
        this.moutFlex02 = moutFlex02;
    }

    public String getMoutFlex03() {
        return moutFlex03;
    }

    public void setMoutFlex03(String moutFlex03) {
        this.moutFlex03 = moutFlex03;
    }

    public String getMoutFlex04() {
        return moutFlex04;
    }

    public void setMoutFlex04(String moutFlex04) {
        this.moutFlex04 = moutFlex04;
    }

    public String getMoutFlex05() {
        return moutFlex05;
    }

    public void setMoutFlex05(String moutFlex05) {
        this.moutFlex05 = moutFlex05;
    }

    public String getMoutFlex06() {
        return moutFlex06;
    }

    public void setMoutFlex06(String moutFlex06) {
        this.moutFlex06 = moutFlex06;
    }

    public String getMoutFlex07() {
        return moutFlex07;
    }

    public void setMoutFlex07(String moutFlex07) {
        this.moutFlex07 = moutFlex07;
    }

    public String getMoutFlex08() {
        return moutFlex08;
    }

    public void setMoutFlex08(String moutFlex08) {
        this.moutFlex08 = moutFlex08;
    }

    public String getMoutFlex09() {
        return moutFlex09;
    }

    public void setMoutFlex09(String moutFlex09) {
        this.moutFlex09 = moutFlex09;
    }

    public String getMoutFlex10() {
        return moutFlex10;
    }

    public void setMoutFlex10(String moutFlex10) {
        this.moutFlex10 = moutFlex10;
    }

    public BigInteger getMoutNoSubmitted() {
        return moutNoSubmitted;
    }

    public void setMoutNoSubmitted(BigInteger moutNoSubmitted) {
        this.moutNoSubmitted = moutNoSubmitted;
    }

    public BigInteger getMoutNoDelivrd() {
        return moutNoDelivrd;
    }

    public void setMoutNoDelivrd(BigInteger moutNoDelivrd) {
        this.moutNoDelivrd = moutNoDelivrd;
    }

    public Date getMoutSubmittedDate() {
        return moutSubmittedDate;
    }

    public void setMoutSubmittedDate(Date moutSubmittedDate) {
        this.moutSubmittedDate = moutSubmittedDate;
    }

    public Date getMoutDoneDate() {
        return moutDoneDate;
    }

    public void setMoutDoneDate(Date moutDoneDate) {
        this.moutDoneDate = moutDoneDate;
    }

    public String getMoutFinalStatus() {
        return moutFinalStatus;
    }

    public void setMoutFinalStatus(String moutFinalStatus) {
        this.moutFinalStatus = moutFinalStatus;
    }
    
    
      
    //Sorting action 
    
       
     public void sortByMouCode(){
        
        moutSmsIdOrder = SortOrder.unsorted;
        moutDelivDateOrder = SortOrder.unsorted;
        moutSendDateOrder = SortOrder.unsorted;
        moutReceiveDateOrder = SortOrder.unsorted;
        moutStatusOrder = SortOrder.unsorted;
        moutLanOrder = SortOrder.unsorted;
        moutSrvOrder = SortOrder.unsorted;
        moutSsrvOrder = SortOrder.unsorted;

                        
        if(moutIdOrder.equals(SortOrder.ascending)){
            setMoutIdOrder(SortOrder.descending); 
        }
        else
        {
            setMoutIdOrder(SortOrder.ascending); 
        }
    }
     
       public void sortByMouSmsId(){
        
        moutIdOrder = SortOrder.unsorted;
        moutDelivDateOrder = SortOrder.unsorted;
        moutSendDateOrder = SortOrder.unsorted;
        moutReceiveDateOrder = SortOrder.unsorted;
        moutStatusOrder = SortOrder.unsorted;
        moutLanOrder = SortOrder.unsorted;
        moutSrvOrder = SortOrder.unsorted;
        moutSsrvOrder = SortOrder.unsorted;

                        
        if(moutSmsIdOrder.equals(SortOrder.ascending)){
            setMoutSmsIdOrder(SortOrder.descending); 
        }
        else
        {
            setMoutSmsIdOrder(SortOrder.ascending); 
        }
    }
         public void sortByMouDeliDate(){
        
        moutSmsIdOrder = SortOrder.unsorted;
        moutIdOrder = SortOrder.unsorted;
        moutSendDateOrder = SortOrder.unsorted;
        moutReceiveDateOrder = SortOrder.unsorted;
        moutStatusOrder = SortOrder.unsorted;
        moutLanOrder = SortOrder.unsorted;
        moutSrvOrder = SortOrder.unsorted;
        moutSsrvOrder = SortOrder.unsorted;

                        
        if(moutDelivDateOrder.equals(SortOrder.ascending)){
            setMoutDelivDateOrder(SortOrder.descending); 
        }
        else
        {
            setMoutDelivDateOrder(SortOrder.ascending); 
        }
    }
           public void sortByMouLan(){
        
        moutSmsIdOrder = SortOrder.unsorted;
        moutDelivDateOrder = SortOrder.unsorted;
        moutSendDateOrder = SortOrder.unsorted;
        moutReceiveDateOrder = SortOrder.unsorted;
        moutStatusOrder = SortOrder.unsorted;
        moutIdOrder = SortOrder.unsorted;
        moutSrvOrder = SortOrder.unsorted;
        moutSsrvOrder = SortOrder.unsorted;

                        
        if(moutLanOrder.equals(SortOrder.ascending)){
            setMoutLanOrder(SortOrder.descending); 
        }
        else
        {
            setMoutLanOrder(SortOrder.ascending); 
        }
    }
             public void sortByMouSendDate(){
        
        moutSmsIdOrder = SortOrder.unsorted;
        moutDelivDateOrder = SortOrder.unsorted;
        moutIdOrder = SortOrder.unsorted;
        moutReceiveDateOrder = SortOrder.unsorted;
        moutStatusOrder = SortOrder.unsorted;
        moutLanOrder = SortOrder.unsorted;
        moutSrvOrder = SortOrder.unsorted;
        moutSsrvOrder = SortOrder.unsorted;

                        
        if(moutSendDateOrder.equals(SortOrder.ascending)){
            setMoutSendDateOrder(SortOrder.descending); 
        }
        else
        {
            setMoutSendDateOrder(SortOrder.ascending); 
        }
    }
               public void sortByMoutSrvCode(){
        
        moutSmsIdOrder = SortOrder.unsorted;
        moutDelivDateOrder = SortOrder.unsorted;
        moutSendDateOrder = SortOrder.unsorted;
        moutReceiveDateOrder = SortOrder.unsorted;
        moutStatusOrder = SortOrder.unsorted;
        moutLanOrder = SortOrder.unsorted;
        moutIdOrder = SortOrder.unsorted;
        moutSsrvOrder = SortOrder.unsorted;

                        
        if(moutSrvOrder.equals(SortOrder.ascending)){
            setMoutSrvOrder(SortOrder.descending); 
        }
        else
        {
            setMoutSrvOrder(SortOrder.ascending); 
        }
    }
                 public void sortByMoutSsrv(){
        
        moutSmsIdOrder = SortOrder.unsorted;
        moutDelivDateOrder = SortOrder.unsorted;
        moutSendDateOrder = SortOrder.unsorted;
        moutReceiveDateOrder = SortOrder.unsorted;
        moutStatusOrder = SortOrder.unsorted;
        moutLanOrder = SortOrder.unsorted;
        moutSrvOrder = SortOrder.unsorted;
        moutIdOrder = SortOrder.unsorted;

                        
        if(moutSsrvOrder.equals(SortOrder.ascending)){
            setMoutSsrvOrder(SortOrder.descending); 
        }
        else
        {
            setMoutSsrvOrder(SortOrder.ascending); 
        }
    }
                 
                   public void sortByMoutStaus(){
        
        moutSmsIdOrder = SortOrder.unsorted;
        moutDelivDateOrder = SortOrder.unsorted;
        moutSendDateOrder = SortOrder.unsorted;
        moutReceiveDateOrder = SortOrder.unsorted;
        moutSsrvOrder = SortOrder.unsorted;
        moutLanOrder = SortOrder.unsorted;
        moutSrvOrder = SortOrder.unsorted;
        moutIdOrder = SortOrder.unsorted;

                        
        if(moutStatusOrder.equals(SortOrder.ascending)){
            setMoutStatusOrder(SortOrder.descending); 
        }
        else
        {
            setMoutStatusOrder(SortOrder.ascending); 
        }
    }
         public void sortByMoutReceiveDate(){
        
        moutSmsIdOrder = SortOrder.unsorted;
        moutDelivDateOrder = SortOrder.unsorted;
        moutSendDateOrder = SortOrder.unsorted;
        moutSsrvOrder = SortOrder.unsorted;
        moutStatusOrder = SortOrder.unsorted;
        moutLanOrder = SortOrder.unsorted;
        moutSrvOrder = SortOrder.unsorted;
        moutIdOrder = SortOrder.unsorted;

                        
        if(moutReceiveDateOrder.equals(SortOrder.ascending)){
            setMoutReceiveDateOrder(SortOrder.descending); 
        }
        else
        {
            setMoutReceiveDateOrder(SortOrder.ascending); 
        }
    }
              
    
     //actiion
    
//    private void setAttrValues(){
//        
//        if(this.isStateAdd()){
//           // this.moutId = 0;
//            //this.moutDelivDate = "";
//            this.moutDelivered = "";
//           // this.moutDoneDate = "";
//            this.moutFinalStatus = "";
//            this.moutFlex01 = "";
//            this.moutFlex02 = "";
//            this.moutFlex03 = "";
//            this.moutFlex04 = "";
//            this.moutFlex05 = "";
//            this.moutFlex06 = "";
//            this.moutFlex07 = "";
//            this.moutFlex08 = "";
//            this.moutFlex09 = "";
//            this.moutFlex10 = "";
//            this.moutLanCode = "";
//           // this.moutMinId = 0;
//            this.moutMsg = "";
//            //this.moutNoDelivrd = "";
//           // this.moutNoSubmitted = "";
//           // this.moutNumbPage = "";
//            //this.moutNumbRetry = "";
//            //this.moutReceiveDatetime = "";
//            //this.moutReceiver = "";
//            //this.moutRetryLast = "";
//            //this.moutSendDatetime = "";
//            this.moutSender = "";
//            this.moutSmsId = "";
//            this.moutSrvCode = "";
//            this.moutSsrvCode = "";
//            this.moutStatus = "";
//            //this.moutSubmittedDate = "";
//            //this.moutSwkId ;
//           
//            
//
//            
//        }
//        else
//        {
//            
//            
//             this.moutId = outRecord.getMoutId();
//            this.moutDelivDate = outRecord.getMoutDelivDate();
//            this.moutDelivered =outRecord.getMoutDelivered();
//           this.moutDoneDate = outRecord.getMoutDoneDate();
//            this.moutFinalStatus = outRecord.getMoutFinalStatus();
//            this.moutFlex01 = outRecord.getMoutFlex01();
//            this.moutFlex02 = outRecord.getMoutFlex02();
//            this.moutFlex03 = outRecord.getMoutFlex03();
//            this.moutFlex04 = outRecord.getMoutFlex04();
//            this.moutFlex05 = outRecord.getMoutFlex05();
//            this.moutFlex06 = outRecord.getMoutFlex06();
//            this.moutFlex07 = outRecord.getMoutFlex07();
//            this.moutFlex08 =outRecord.getMoutFlex08();
//            this.moutFlex09 = outRecord.getMoutFlex09();
//            this.moutFlex10 = outRecord.getMoutFlex10();
//            this.moutLanCode = outRecord.getMoutLanCode();
//            this.moutMinId = outRecord.getMoutMinId();
//            this.moutMsg = outRecord.getMoutMsg();
//            this.moutNoDelivrd = outRecord.getMoutNoDelivrd();
//            this.moutNoSubmitted = outRecord.getMoutNoSubmitted();
//            this.moutNumbPage = outRecord.getMoutNumbPage();
//            this.moutNumbRetry = outRecord.getMoutNumbRetry();
//            this.moutReceiveDatetime = outRecord.getMoutReceiveDatetime();
//            this.moutReceiver = outRecord.getMoutReceiver();
//            this.moutRetryLast = outRecord.getMoutRetryLast();
//            this.moutSendDatetime = outRecord.getMoutSendDatetime();
//            this.moutSender =outRecord.getMoutSender();
//            this.moutSmsId = outRecord.getMoutSmsId();
//            this.moutSrvCode = outRecord.getMoutSrvCode();
//            this.moutSsrvCode = outRecord.getMoutSsrvCode();
//            this.moutStatus = outRecord.getMoutStatus();
//            this.moutSubmittedDate = outRecord.getMoutSubmittedDate();
//            this.moutSwkId =outRecord.getMoutSwkId();
//            
//            
//            }
//
//        
//    }
//      public String viewRecord(MessageOut rec){
//        setCurrentState(CommonObjects.State.VIEW);
//        outRecord = rec;
//        
//        setAttrValues();
//      
//        detailOutRecord = new ArrayList<MessageOut>();
//        detailOutRecord.add(outRecord);
//        return "";
//    }
     
      
        //List Message In
    
    public List<OutListRecord> getOutList() {
        outList = new ArrayList<OutListRecord>();
        List<MessageOut> list = outSession.getMessageOutList(CommonObjects.ROW_COUNT);
        for(MessageOut record:list)
            outList.add(new OutListRecord(record));
                
        return outList;
    }


    public void setOutList(List<OutListRecord> inList) {
        this.outList = inList;
    }
    
    
    
    public int getMessageOutCount(){
        return outSession.count();
    }
                 
    /**
     * * Getter & Setter
     * @return
     */
   

    public void setCurrentState(CommonObjects.State state) {
        currentState = state;
    }
    
    public CommonObjects.State getCurrentState(){
        return currentState;
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
    
    
    
    public String getListStateImage(){
        return tableStateImage.get(currentState.name());
    }
    
    public String getRecordStateImage(){
        return recordStateImage.get(currentState.name());
    }
    
     public static class OutListRecord implements Serializable{
        private MessageOut trafficOut;
        private boolean selected;
        

        public OutListRecord(){
            selected = false;
        }
        
        public OutListRecord(MessageOut out){
            trafficOut = out;
            selected = false;
        }

        public MessageOut getTrafficOut() {
            return trafficOut;
        }

        public void setTrafficOut(MessageOut trafficOut) {
            this.trafficOut = trafficOut;
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
