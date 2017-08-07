/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.mBeans.settings;
import com.cme.mBeans.common.CommonObjects.State;
import com.cme.entities.OperatorMast;
import com.cme.facade.settings.OperatorMastFacade;
import com.cme.mBeans.common.CommonObjects;
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
import com.cme.mBeans.common.ReadResourceBundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.persistence.Basic;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.richfaces.component.SortOrder;

/**
 *
 * @author admin
 */
@Named(value = "operators")
@ViewScoped
public class operatorsBean implements Serializable{
     @EJB
    private OperatorMastFacade oprSession;
    private OperatorMast oprRecord;
    private List<OperatorMast> detailRecord;
    private  List<OprListRecord> operatorsList;
    private ReadResourceBundle customMsg;

    
    private String viewMessage;
    private String deleteMessage;
    private String editMessage;
    
    private SortOrder oprCodeOrder = SortOrder.unsorted;
    private SortOrder oprNameOrder = SortOrder.unsorted;
    private SortOrder oprNameArOrder = SortOrder.unsorted;
    private SortOrder oprShortOrder = SortOrder.unsorted;

    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min = 1, max = 10)
    private String oprCode;
    @Basic(optional = false)
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min = 1, max = 100,message="{com.cme.m_Val_fieldSize}")
    private String oprName;
    @Size(max = 100,message="{com.cme.m_Val_fieldSize}")
    private String oprNameAr;
    @Size(max = 10,message="{com.cme.m_Val_fieldSize}")
    private String oprShortName;


    
    
    //Setters And Getters
  
    private CommonObjects.State currentState = CommonObjects.State.NONE;

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

    
    public List<OperatorMast> getDetailRecord() {
        return detailRecord;
    }

    public void setDetailRecord(List<OperatorMast> detailRecord) {
        this.detailRecord = detailRecord;
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
    

    public String getOprCode() {
        return oprCode;
    }

    public void setOprCode(String oprCode) {
        this.oprCode = oprCode;
    }

    public String getOprName() {
        return oprName;
    }

    public void setOprName(String oprName) {
        this.oprName = oprName;
    }

    public String getOprNameAr() {
        return oprNameAr;
    }

    public void setOprNameAr(String oprNameAr) {
        this.oprNameAr = oprNameAr;
    }

    public String getOprShortName() {
        return oprShortName;
    }

    public void setOprShortName(String oprShortName) {
        this.oprShortName = oprShortName;
    }

    public SortOrder getOprCodeOrder() {
        return oprCodeOrder;
    }

    public void setOprCodeOrder(SortOrder oprCodeOrder) {
        this.oprCodeOrder = oprCodeOrder;
    }

    public SortOrder getOprNameOrder() {
        return oprNameOrder;
    }

    public void setOprNameOrder(SortOrder oprNameOrder) {
        this.oprNameOrder = oprNameOrder;
    }

    public SortOrder getOprNameArOrder() {
        return oprNameArOrder;
    }

    public void setOprNameArOrder(SortOrder oprNameArOrder) {
        this.oprNameArOrder = oprNameArOrder;
    }

    public SortOrder getOprShortOrder() {
        return oprShortOrder;
    }

    public void setOprShortOrder(SortOrder oprShortOrder) {
        this.oprShortOrder = oprShortOrder;
    }
    
    
    public int getOperatorsCount(){
        return oprSession.count();
    }
    
    public operatorsBean() {
        oprSession = new OperatorMastFacade();
        customMsg = new ReadResourceBundle();
        viewMessage = customMsg.getCustomMessage("msgs", "m_AlertNothing");
        deleteMessage = customMsg.getCustomMessage("msgs", "m_Alert_DeleteFlag");
        editMessage = customMsg.getCustomMessage("msgs", "m_Alert_SaveChanges");
        
    }
    
     public List<OprListRecord> getOperatorsList() {
        operatorsList = new ArrayList<OprListRecord>();
        List<OperatorMast> list = oprSession.getOprList();
        for(OperatorMast record:list)
            operatorsList.add(new OprListRecord(record));
                
        return operatorsList;
    }


    public void setOperatorsList(List<OprListRecord> operatorsList) {
        this.operatorsList = operatorsList;
    }
    
    
    
    public void sortByOprCode(){
        
        oprNameOrder = SortOrder.unsorted;
        oprNameArOrder = SortOrder.unsorted;
        oprShortOrder = SortOrder.unsorted;
        if(oprCodeOrder.equals(SortOrder.ascending)){
            setOprCodeOrder(SortOrder.descending); 
        }
        else
        {
            setOprCodeOrder(SortOrder.ascending); 
        }
    }
    
       
      public void sortByOprName(){
        
        oprCodeOrder = SortOrder.unsorted;
        oprNameArOrder = SortOrder.unsorted;
        oprShortOrder = SortOrder.unsorted;
        if(oprNameOrder.equals(SortOrder.ascending)){
            setOprNameOrder(SortOrder.descending); 
        }
        else
        {
            setOprNameOrder(SortOrder.ascending); 
        }
    }
    
      
       public void sortByOprNameAr(){
        
        oprNameOrder = SortOrder.unsorted;
        oprCodeOrder = SortOrder.unsorted;
        oprShortOrder = SortOrder.unsorted;
        if(oprNameArOrder.equals(SortOrder.ascending)){
            setOprNameArOrder(SortOrder.descending); 
        }
        else
        {
            setOprNameArOrder(SortOrder.ascending); 
        }
    }
       
        public void sortByOprShortName(){
        
        oprNameOrder = SortOrder.unsorted;
        oprCodeOrder = SortOrder.unsorted;
        oprNameArOrder = SortOrder.unsorted;
        if(oprShortOrder.equals(SortOrder.ascending)){
            setOprShortOrder(SortOrder.descending); 
        }
        else
        {
            setOprShortOrder(SortOrder.ascending); 
        }
    }
    
    

       private void setAttrValues(){
        if(this.isStateAdd()){
            this.oprCode   = "";
            this.oprName = "";
            this.oprNameAr = "";
            this.oprShortName = "";
              
        }
        else
        {
            this.oprCode   = oprRecord.getOprCode();
            this.oprName = oprRecord.getOprName();
            this.oprNameAr = oprRecord.getOprNameAr();
            this.oprShortName = oprRecord.getOprShortName();
            
        }

        
    }
    
    public String addRecord(){
        setCurrentState(CommonObjects.State.ADD);
        setAttrValues();
        OperatorMast rec = new OperatorMast();
        detailRecord = new ArrayList<OperatorMast>();
        
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(rec);
        
        return "";
    }
    
    public String editRecord(OperatorMast rec){
        setCurrentState(CommonObjects.State.EDIT);
       oprRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<OperatorMast>();
        detailRecord.add(oprRecord);
        return "";
    }
    
    public String viewRecord(OperatorMast rec){
        setCurrentState(CommonObjects.State.VIEW);
        oprRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<OperatorMast>();
        detailRecord.add(oprRecord);
        return "";
    }
    
    public String deleteRecord(OperatorMast rec){
        setCurrentState(CommonObjects.State.DELETE);
        oprRecord = rec;
        setAttrValues();
//        oprRecord.setScatStatus("D");
      
        detailRecord = new ArrayList<OperatorMast>();
        detailRecord.add(oprRecord);
        return "";
    }
    
    
    public String saveRecord(){
        oprRecord = new OperatorMast();
        oprRecord.setOprCode(oprCode);
        oprRecord.setOprName(oprName);
        oprRecord.setOprNameAr(oprNameAr);
        oprRecord.setOprShortName(oprShortName);
       
        
        
              
        if(currentState.equals(CommonObjects.State.ADD)){
            if(isRecordValid()){
                oprSession.create(oprRecord);
                OprListRecord listRecord = new OprListRecord(oprRecord);
                operatorsList.add(listRecord);  
                stateRefresh();
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage("formRecord:oprCode", new FacesMessage(customMsg.getCustomMessage("msgs", "m_Alert_DupRecord")));
            }
            
        }
        else{
            oprSession.edit(oprRecord);
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
        for(OperatorMast iterate: oprSession.getOprList()){
            if(oprCode.equals(iterate.getOprCode())){
                valid = false;
                break;
            }
        }
        return valid;
    }
    
    public String stateRefresh(){
        setCurrentState(CommonObjects.State.NONE);
        
        oprRecord = null;
              
        detailRecord = new ArrayList<OperatorMast>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(oprRecord);
        
        getOperatorsList();
        
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
    
    public static class OprListRecord implements Serializable{

        private OperatorMast operators;
        private boolean selected;
        
        public OprListRecord(){
            selected = false;
        }
           
        public OprListRecord(OperatorMast opr){
            operators = opr;
            selected = false;
        }

        public OperatorMast getOperators() {
            return operators;
        }

        public void setCategory(OperatorMast operators) {
            this.operators = operators;
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
