  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans.settings;

import com.cme.entities.ServiceType;
import com.cme.facade.settings.ServiceTypeFacade;
import com.cme.mBeans.common.CommonObjects.State;
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.richfaces.component.SortOrder;
import com.cme.mBeans.common.ReadResourceBundle;

/**
 *
 * @author hp
 */
@ManagedBean(name="servType")
@ViewScoped
public class servicetypeBean implements Serializable{
    private static final long serialVersionUID = 1L;
    @EJB
    private ServiceTypeFacade servTypeSession;
    private ServiceType servTypeRecord;
    private List<ServiceType> detailRecord;
    private List<ServiceTypeListRecord> serviceTypeList;
     private ReadResourceBundle customMsg;
    private SortOrder codeOrder = SortOrder.unsorted;
    private SortOrder nameOrder = SortOrder.unsorted;
  
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min=1,max=10,message="{com.cme.m_Val_fieldSize}")
    private String srtCode;

    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(max=100,message="{com.cme.m_Val_fieldSize}")
    private String srtNameEN;
    
    @Size(max=100,message="{com.cme.m_Val_fieldSize}")
    private String srtNameAR;

    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(max=1,message="{com.cme.m_Val_fieldSize}")
    private String srtStatus;
    
    @Size(max=30,message="{com.cme.m_Val_fieldSize}")
    private String srtAddUid;
    
    private Date srtAddDate;
    
    @Size(max=30,message="{com.cme.m_Val_fieldSize}")
    private String srtUpdUid;
    
    private Date srtUpdDate;
  
    private State currentState = State.NONE;
    private String viewMessage;
    private String deleteMessage;
    private String editMessage;
    
       
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
    /**
     * Creates a new instance of servicetypeBean  
     */
    
    
    public servicetypeBean() {
        servTypeSession = new ServiceTypeFacade();
        customMsg = new ReadResourceBundle();
        viewMessage = customMsg.getCustomMessage("msgs", "m_AlertNothing");
        deleteMessage = customMsg.getCustomMessage("msgs", "m_Alert_DeleteFlag");
        editMessage = customMsg.getCustomMessage("msgs", "m_Alert_SaveChanges");
    }

    /**
     * * Getter & Setter
     * @return 
     */
    
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

    public String getSrtCode() {
        return srtCode;
    }

    public void setSrtCode(String srtCode) {
        this.srtCode = srtCode;
    }

    public String getSrtNameEN() {
        return srtNameEN;
    }

    public void setSrtNameEN(String srtNameEN) {
        this.srtNameEN = srtNameEN;
    }

    public String getSrtNameAR() {
        return srtNameAR;
    }

    public void setSrtNameAR(String srtNameAR) {
        this.srtNameAR = srtNameAR;
    }

    public String getSrtStatus() {
        return srtStatus;
    }

    public void setSrtStatus(String srtStatus) {
        this.srtStatus = srtStatus;
    }

    public String getSrtAddUid() {
        return srtAddUid;
    }

    public void setSrtAddUid(String srtAddUid) {
        this.srtAddUid = srtAddUid;
    }

    public Date getSrtAddDate() {
        return srtAddDate;
    }

    public void setSrtAddDate(Date srtAddDate) {
        this.srtAddDate = srtAddDate;
    }

    public String getSrtUpdUid() {
        return srtUpdUid;
    }

    public void setSrtUpdUid(String srtUpdUid) {
        this.srtUpdUid = srtUpdUid;
    }

    public Date getSrtUpdDate() {
        return srtUpdDate;
    }

    public void setSrtUpdDate(Date srtUpdDate) {
        this.srtUpdDate = srtUpdDate;
    }
    
   //List of ServiceType & Select
    
    public List<ServiceTypeListRecord> getServiceTypeList() {
        serviceTypeList = new ArrayList<ServiceTypeListRecord>();
        List<ServiceType> list = servTypeSession. getSrviceList();
        for(ServiceType record:list)
            serviceTypeList.add(new ServiceTypeListRecord(record));
                
        return serviceTypeList;
    }


    public void setServiceTypeList(List<ServiceTypeListRecord> serviceTypeList) {
        this.serviceTypeList = serviceTypeList;
    }
    
    
    
    public DataModel<ServiceType> getAllServicesType(){
        return servTypeSession. getServiceTable();
    }
    
    public int getServTypeCount(){
        return servTypeSession.count();
    }
    
    public List<ServiceType> getRecordDetail(){
        return detailRecord;
    }
    
    public void sortByCode() {
       // codeOrder = SortOrder.unsorted;
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
    
    private void setAttrValues(){
        if(this.isStateAdd()){
            this.srtCode   = "";
            this.srtNameEN = "";
            this.srtNameAR = "";
            this.srtStatus = "A";
            this.srtAddUid = ""; 
//            this.srtAddDate = "";   
            this.srtUpdUid = ""; 
//            this.srtUpdDate = ""; 
            
        }
        else
        {
            this.srtCode   = servTypeRecord.getSrtCode();
            this.srtNameEN = servTypeRecord.getSrtName();
            this.srtNameAR = servTypeRecord.getSrtNameAr();
            this.srtStatus = servTypeRecord.getSrtStatus();
            this.srtAddUid = servTypeRecord.getSrtAddUid(); 
            this.srtAddDate = servTypeRecord.getSrtAddDate() ;   
            this.srtUpdUid = servTypeRecord.getSrtUpdUid();   
            this.srtUpdDate  = servTypeRecord.getSrtUpdDate() ;  
        }

        
    }
    public String addRecord(){
        setCurrentState(State.ADD);
        setAttrValues();
        ServiceType rec = new ServiceType();
        detailRecord = new ArrayList<ServiceType>();
        
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(rec);
        
        return "";
    }
    
    public String editRecord(ServiceType rec){
        setCurrentState(State.EDIT);
        servTypeRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServiceType>();
        detailRecord.add(servTypeRecord);
        return "";
    }
    
    public String viewRecord(ServiceType rec){
        setCurrentState(State.VIEW);
        servTypeRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServiceType>();
        detailRecord.add(servTypeRecord);
        return "";
    }
    
    public String deleteRecord(ServiceType rec){
        setCurrentState(State.DELETE);
        servTypeRecord = rec;
        setAttrValues();
        servTypeRecord.setSrtStatus("D");
        srtStatus = "D";
      
        detailRecord = new ArrayList<ServiceType>();
        detailRecord.add(servTypeRecord);
        return "";
    }
    
    
    public String saveRecord(){
    
        servTypeRecord=new ServiceType();
        servTypeRecord.setSrtCode(srtCode);
        servTypeRecord.setSrtName(srtNameEN);
        servTypeRecord.setSrtNameAr(srtNameAR);
        servTypeRecord.setSrtStatus(srtStatus);
        servTypeRecord.setSrtAddUid(srtAddUid);
        srtAddDate = new Date();
        servTypeRecord.setSrtAddDate(srtAddDate);
        servTypeRecord.setSrtUpdUid(srtUpdUid);
        srtUpdDate = new Date();
        servTypeRecord.setSrtUpdDate(srtUpdDate);
        
        
       if(currentState.equals(State.ADD)){
            if(isRecordValid()){
                servTypeSession.create(servTypeRecord);
                ServiceTypeListRecord listRecord = new ServiceTypeListRecord(servTypeRecord);
                serviceTypeList.add(listRecord);  
                stateRefresh();
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage("formRecord:srtCode", new FacesMessage(customMsg.getCustomMessage("msgs", "m_Alert_DupRecord")));
            }
            
        }
        else{
            servTypeSession.edit(servTypeRecord);
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
        for(ServiceType iterate: servTypeSession.getSrviceList()){
            if(srtCode.equals(iterate.getSrtCode())){
                valid = false;
                break;
            }
        }
        return valid;
    }
    
    public String stateRefresh(){
        setCurrentState(State.NONE);
        
        servTypeRecord = null;
              
        detailRecord = new ArrayList<ServiceType>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(servTypeRecord);
        
        getServiceTypeList();
        
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
      public static class ServiceTypeListRecord implements Serializable{
        private ServiceType servType;
        private boolean selected;
        
        public ServiceTypeListRecord(){
            selected = false;
        }
        
        public ServiceTypeListRecord(ServiceType serv){
            servType = serv;
            selected = false;
        }

        public ServiceType getServType() {
            return servType;
        }

        public void setServType(ServiceType servType) {
            this.servType = servType;
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
