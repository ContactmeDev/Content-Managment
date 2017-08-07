/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans.settings;

import com.cme.entities.CurrencyMast;
import com.cme.facade.settings.CurrencyMastFacade;
import com.cme.mBeans.common.CommonObjects.State;
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.richfaces.component.SortOrder;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.persistence.EntityManager;
import com.cme.mBeans.common.ReadResourceBundle;


/**
 *
 * @author hp
 */

@ManagedBean(name="currency")
@ViewScoped
public class currencyBean   implements Serializable{
@EJB
    private CurrencyMastFacade currSession;
    private CurrencyMast currRecord;
    private List<CurrencyMast> detailRecord;
    private List<CurrencyListRecord> currenciesList;
    private ReadResourceBundle customMsg;
    private SortOrder codeOrder = SortOrder.unsorted;
    private SortOrder nameOrder = SortOrder.unsorted;
    private EntityManager em;
    FacesMessage message = null;
    private int model;
   
   

    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min=1,max=10,message="{com.cme.m_Val_fieldSize}")
    private String currCode;
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(max=50,message="{com.cme.m_Val_fieldSize}")
    private String currNameEN;
    
    @Size(max=50,message="{com.cme.m_Val_fieldSize}")
    private String currNameAR;
    
    private String currsymbol;
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(max=1,message="{com.cme.m_Val_fieldSize}")
    private String currStatus;
    
    private State currentState = State.NONE;

    private String viewMessage;
    private String deleteMessage;
    private String editMessage;

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
     
    public String getListStateImage(){
        return tableStateImage.get(currentState.name());
    }
    
    public String getRecordStateImage(){
        return recordStateImage.get(currentState.name());
    }
    
    
/**
* Creates a new instance of currencyBean
*/
    
    
    public currencyBean() {
         currSession = new CurrencyMastFacade();
         customMsg = new ReadResourceBundle();
         viewMessage = customMsg.getCustomMessage("msgs", "m_AlertNothing");
         deleteMessage = customMsg.getCustomMessage("msgs", "m_Alert_DeleteFlag");
         editMessage = customMsg.getCustomMessage("msgs", "m_Alert_SaveChanges");
    }

 
    /**
     * * Getter & Setter
     * @return 
     */
    
    public String getDeleteMessage() {
        return deleteMessage;
    }

    public void setDeleteMessage(String deleteMessage) {
        this.deleteMessage = deleteMessage;
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

    public String getEditMessage() {
        return editMessage;
    }

    public void setEditMessage(String editMessage) {
        this.editMessage = editMessage;
    }

    public CurrencyMastFacade getCurrSession() {
        return currSession;
    }

    public void setCurrSession(CurrencyMastFacade currSession) {
        this.currSession = currSession;
    }
    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
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
  
    public String getCurrCode() {
        return currCode;
    }

    public void setCurrCode(String currCode) {
        this.currCode = currCode;
    }

    public String getCurrNameEN() {
        return currNameEN;
    }

    public void setCurrNameEN(String currNameEN) {
        this.currNameEN = currNameEN;
    }

    public String getCurrNameAR() {
        return currNameAR;
    }

    public void setCurrNameAR(String currNameAR) {
        this.currNameAR = currNameAR;
    }

    public String getCurrsymbol() {
        return currsymbol;
    }

    public void setCurrsymbol(String currsymbol) {
        this.currsymbol = currsymbol;
    }

    public String getCurrStatus() {
        return currStatus;
    }

    public void setCurrStatus(String currStatus) {
        this.currStatus = currStatus;
    }
    
//List of CurrencyMast & Select
    
    public List<CurrencyListRecord> getCurrenciesList() {
        currenciesList = new ArrayList<CurrencyListRecord>();
        List<CurrencyMast> list = currSession.getCurrList();
         for(CurrencyMast record:list)
             currenciesList.add(new CurrencyListRecord(record));
                
        return currenciesList;
    }

    public void setCurrenciesList(List<CurrencyListRecord> currenciesList) {
        this.currenciesList = currenciesList;
    }
       

    
    public DataModel<CurrencyMast> getAllCurrencies(){
        return currSession.getCurrencyTable();
    }
    
    public int getCurrencyCount(){
        return currSession.count();
    }
    
    public List<CurrencyMast> getRecordDetail(){
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
      


//the Actions
    
    private void setAttrValues(){
        if(this.isStateAdd()){
            this.currCode   = "";
            this.currNameEN = "";
            this.currNameAR = "";
            this.currsymbol = "";
            this.currStatus = "A";
             
        }
        else
        {
            this.currCode   = currRecord.getCurrCode();
            this.currNameEN = currRecord.getCurrName();
            this.currNameAR = currRecord.getCurrNameAr();
            this.currsymbol = currRecord.getCurrSymbol();
            this.currStatus = currRecord.getCurrStatus();
           
        }

        
    }
     
    public String addRecord(){
        setCurrentState(State.ADD);
        setAttrValues();
        CurrencyMast rec = new CurrencyMast();
        detailRecord = new ArrayList<CurrencyMast>();
        
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(rec);
        
        return "";
    }
    
    public String editRecord(CurrencyMast rec){
        setCurrentState(State.EDIT);
        currRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<CurrencyMast >();
        detailRecord.add(currRecord);
        return "";
    }
      
    public String viewRecord(CurrencyMast rec){
        setCurrentState(State.VIEW);
        currRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<CurrencyMast>();
        detailRecord.add(currRecord);
        return "";
    }
     
    public String deleteRecord(CurrencyMast rec){
        setCurrentState(State.DELETE);
        currRecord = rec;
        setAttrValues();
         currRecord.setCurrStatus("D");
         currStatus = "D";
      
        detailRecord = new ArrayList<CurrencyMast>();
        detailRecord.add( currRecord);
        return "";
    }
      
    public String saveRecord(){
    
        currRecord = new CurrencyMast(); 
        currRecord.setCurrName(currNameEN);
        currRecord.setCurrNameAr(currNameAR);
        currRecord.setCurrSymbol(currsymbol);
        currRecord.setCurrStatus(currStatus);
        currRecord.setCurrCode(currCode); 
        
         if(currentState.equals(State.ADD)){
            if(isRecordValid()){
                currSession.create(currRecord);
                CurrencyListRecord listRecord = new CurrencyListRecord(currRecord);
                currenciesList.add(listRecord);  
                stateRefresh();
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage("formRecord:currCode", new FacesMessage(customMsg.getCustomMessage("msgs", "m_Alert_DupRecord")));
            }
            
        }
        else{
            currSession.edit(currRecord);
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
        for(CurrencyMast iterate: currSession.getCurrList()){
            if(currCode.equals(iterate.getCurrCode())){
                valid = false;
                break;
            }
        }
        return valid;
    }
    
       
            
    public String stateRefresh(){
        setCurrentState(State.NONE);
        
        currRecord = null;
              
        detailRecord = new ArrayList<CurrencyMast>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(currRecord);
        
        getCurrenciesList();
        
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
    
    public static class CurrencyListRecord implements Serializable{
        private CurrencyMast currency;
        private boolean selected;
        
        public CurrencyListRecord (){
            selected = false;
        }
        
        public CurrencyListRecord (CurrencyMast curr){
            currency = curr;
            selected = false;
        }

        public CurrencyMast getCurrency() {
            return  currency;
        }

        public void setCurrency(CurrencyMast currency) {
            this. currency =  currency;
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
