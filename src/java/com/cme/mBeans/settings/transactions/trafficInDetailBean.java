/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.mBeans.settings.transactions;

import com.cme.entities.MessageInDetail;
import com.cme.facade.settings.MessageInDetailFacade;
import com.cme.mBeans.common.CommonObjects;
import com.cme.mBeans.common.CommonObjects.State;
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
import com.cme.mBeans.common.ReadResourceBundle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
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
@ManagedBean(name = "trafficInDetail")
@ViewScoped
public class trafficInDetailBean {
    @EJB
    private MessageInDetailFacade inDSession;
    private MessageInDetail inDRecord;
    private List<MessageInDetail> detailsInRecord;
   
    private List<InListRecordDetail> inDetailList;
    @NotNull
    @Column(name = "DIN_ID")
    private BigDecimal dinId;
    @Size(max = 30)
    @Column(name = "DIN_SMS_ID")
    private String dinSmsId;
    @Column(name = "DIN_UDH_LENGH")
    private Long dinUdhLengh;
    @Column(name = "DIN_INF_ELEM_ID")
    private Integer dinInfElemId;
    @Column(name = "DIN_INF_ELEM_LEN")
    private Integer dinInfElemLen;
    @Column(name = "DIN_SAR_MAX_NUMB")
    private Short dinSarMaxNumb;
    @Column(name = "DIN_SAR_SEQ_NUMB")
    private Short dinSarSeqNumb;
    @Size(max = 20)
    @Column(name = "DIN_SENDER")
    private String dinSender;
    @Size(max = 20)
    @Column(name = "DIN_RECEIVER")
    private String dinReceiver;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIN_RECEIVE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dinReceiveDatetime;
    @Size(max = 2000)
    @Column(name = "DIN_MSG")
    private String dinMsg;
    @Size(max = 10)
    @Column(name = "DIN_LAN_CODE")
    private String dinLanCode;
    @Size(max = 10)
    @Column(name = "DIN_STATUS")
    private String dinStatus;
    @Size(max = 30)
    @Column(name = "DIN_SRV_CODE")
    private String dinSrvCode;
    @Size(max = 30)
    @Column(name = "DIN_SSRV_CODE")
    private String dinSsrvCode;

    
    
    private CommonObjects.State currentState = CommonObjects.State.NONE;
    private CommonObjects.State currentDetailState = CommonObjects.State.NONE;
    private String viewMessage;
    private String deleteMessage;
    private String editMessage;
    private ReadResourceBundle customMsg;

    public List<InListRecordDetail> getInDetailList() {
        return inDetailList;
    }

    public void setInDetailList(List<InListRecordDetail> inDetailList) {
        this.inDetailList = inDetailList;
    }
    
    
    
    
     public State getCurrentDetailState() {
        return currentDetailState;
    }

    public void setCurrentDetailState(State currentDetailState) {
        this.currentDetailState = currentDetailState;
    }
    
     public int getInDetailsCount(){
        return inDSession.count();
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

    public List<MessageInDetail> getDetailsInRecord() {
        return detailsInRecord;
    }

    public void setDetailsInRecord(List<MessageInDetail> detailsInRecord) {
        this.detailsInRecord = detailsInRecord;
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
    public BigDecimal getDinId() {
        return dinId;
    }

    public void setDinId(BigDecimal dinId) {
        this.dinId = dinId;
    }

    public String getDinSmsId() {
        return dinSmsId;
    }

    public void setDinSmsId(String dinSmsId) {
        this.dinSmsId = dinSmsId;
    }

    public Long getDinUdhLengh() {
        return dinUdhLengh;
    }

    public void setDinUdhLengh(Long dinUdhLengh) {
        this.dinUdhLengh = dinUdhLengh;
    }

    public Integer getDinInfElemId() {
        return dinInfElemId;
    }

    public void setDinInfElemId(Integer dinInfElemId) {
        this.dinInfElemId = dinInfElemId;
    }

    public Integer getDinInfElemLen() {
        return dinInfElemLen;
    }

    public void setDinInfElemLen(Integer dinInfElemLen) {
        this.dinInfElemLen = dinInfElemLen;
    }

    public Short getDinSarMaxNumb() {
        return dinSarMaxNumb;
    }

    public void setDinSarMaxNumb(Short dinSarMaxNumb) {
        this.dinSarMaxNumb = dinSarMaxNumb;
    }

    public Short getDinSarSeqNumb() {
        return dinSarSeqNumb;
    }

    public void setDinSarSeqNumb(Short dinSarSeqNumb) {
        this.dinSarSeqNumb = dinSarSeqNumb;
    }

    public String getDinSender() {
        return dinSender;
    }

    public void setDinSender(String dinSender) {
        this.dinSender = dinSender;
    }

    public String getDinReceiver() {
        return dinReceiver;
    }

    public void setDinReceiver(String dinReceiver) {
        this.dinReceiver = dinReceiver;
    }

    public Date getDinReceiveDatetime() {
        return dinReceiveDatetime;
    }

    public void setDinReceiveDatetime(Date dinReceiveDatetime) {
        this.dinReceiveDatetime = dinReceiveDatetime;
    }

    public String getDinMsg() {
        return dinMsg;
    }

    public void setDinMsg(String dinMsg) {
        this.dinMsg = dinMsg;
    }

    public String getDinLanCode() {
        return dinLanCode;
    }

    public void setDinLanCode(String dinLanCode) {
        this.dinLanCode = dinLanCode;
    }

    public String getDinStatus() {
        return dinStatus;
    }

    public void setDinStatus(String dinStatus) {
        this.dinStatus = dinStatus;
    }

    public String getDinSrvCode() {
        return dinSrvCode;
    }

    public void setDinSrvCode(String dinSrvCode) {
        this.dinSrvCode = dinSrvCode;
    }

    public String getDinSsrvCode() {
        return dinSsrvCode;
    }

    public void setDinSsrvCode(String dinSsrvCode) {
        this.dinSsrvCode = dinSsrvCode;
    }

    
    
    public trafficInDetailBean() {
        inDSession = new MessageInDetailFacade();
        viewMessage = customMsg.getCustomMessage("msgs", "m_AlertNothing");
        deleteMessage = customMsg.getCustomMessage("msgs", "m_Alert_DeleteFlag");
        editMessage = customMsg.getCustomMessage("msgs", "m_Alert_SaveChanges");

    }
    
    public List<InListRecordDetail> getMessageInDetailList() {
        inDetailList = new ArrayList<InListRecordDetail>();
        List<MessageInDetail> list = inDSession.getSelectedRow(dinSmsId);
        for(MessageInDetail record:list)
            inDetailList.add(new InListRecordDetail(record));
                
        return inDetailList;
    }


    public void setMessageInDetailList(List<InListRecordDetail> inDetailList) {
        this.inDetailList = inDetailList;
    }
    
    
        //Action
    public String viewDetails(String minSmsId){
        setDinSmsId(minSmsId);
        this.currentState = CommonObjects.State.VIEW;
        setCurrentDetailState(CommonObjects.State.NONE);

        return "";
    }
    
     
    
    private void setAttrValues(){
        if(this.isStateAdd()){
           
        //    this.dinId = "";
       //     this.vedCreated = new Date();
            this.dinInfElemId = 0;
            this.dinInfElemLen = 0;
            this.dinLanCode = "";
            this.dinMsg = "";
       //     this.vedStatusDate = new Date();
       //     this.vedReleased = new Date();
           // this.dinReceiveDatetime = "";
            this.dinReceiver = "";
            this.dinSarMaxNumb =0;
            this.dinSarSeqNumb = 0;
            this.dinSender = "";
            this.dinSmsId = "";
            this.dinSrvCode = "";
            this.dinSsrvCode = "";
           // this.dinUdhLengh = 0;
            this.dinStatus = "";


            




        }
        else
        {
         
            this.dinId = inDRecord.getDinId();
            this.dinInfElemId = inDRecord.getDinInfElemId();
            this.dinInfElemLen = inDRecord.getDinInfElemLen();
            this.dinLanCode = inDRecord.getDinLanCode();
            this.dinMsg = inDRecord.getDinMsg();
            this.dinReceiveDatetime = inDRecord.getDinReceiveDatetime();
            this.dinReceiver = inDRecord.getDinReceiver();
            this.dinSarMaxNumb = inDRecord.getDinSarMaxNumb();
            this.dinSarSeqNumb = inDRecord.getDinSarSeqNumb();
            this.dinSender = inDRecord.getDinSender();
            this.dinSmsId = inDRecord.getDinSmsId();
            this.dinSrvCode = inDRecord.getDinSrvCode();
            this.dinSsrvCode = inDRecord.getDinSsrvCode();
            this.dinStatus = inDRecord.getDinStatus();
            this.dinUdhLengh = inDRecord.getDinUdhLengh();


          
        }

        
    }
    
    
    public String stateRefresh(){
        setCurrentState(CommonObjects.State.NONE);
        
        inDRecord = null;
              
        detailsInRecord = new ArrayList<MessageInDetail>();
        if (!detailsInRecord.isEmpty())
            detailsInRecord.clear();
        detailsInRecord.add(inDRecord);
        
        getInDetailList();
        
        return "";
    }
    
     public String stateDetailRefresh(){
        setCurrentDetailState(State.NONE);
        
        inDRecord = null;
              
        detailsInRecord = new ArrayList<MessageInDetail>();
        if (!detailsInRecord.isEmpty())
            detailsInRecord.clear();
        detailsInRecord.add(inDRecord);
        
         getInDetailList();
        
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
    
    
    

    public static class InListRecordDetail {
     private boolean selected;
        private MessageInDetail inDetail;
        
        public InListRecordDetail(MessageInDetail trafficInDetail) {
            inDetail = trafficInDetail;
            selected = false;
            
          
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public MessageInDetail getInDetail() {
            return inDetail;
        }

        public void setInDetail(MessageInDetail inDetail) {
            this.inDetail = inDetail;
        }
 
        

        
        public void rowSelected(){
            this.selected = true;
        }
    }
    
    
    
    
    
    
}
