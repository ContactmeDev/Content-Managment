/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans.settings;

import com.cme.entities.LanguageMast;
import com.cme.facade.settings.LanguageMastFacade;
import com.cme.mBeans.common.CommonObjects.State;
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.DataModel;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.richfaces.component.UIPanel;
import com.cme.mBeans.common.ReadResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.richfaces.component.SortOrder;


/**
 *
 * @author mustafaahmed
 */
@ManagedBean(name="language")
@ViewScoped
public class languageBean implements Serializable{
    @EJB
    private LanguageMastFacade langSession;
    private LanguageMast langRecord;
    private List<LanguageMast> detailRecord;
    private List<LanguageListRecord> languagesList;
    private ReadResourceBundle customMsg;
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min=1,max=10,message="{com.cme.m_Val_fieldSize}")
    private String lanCode;
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(max=100,message="{com.cme.m_Val_fieldSize}")
    private String lanNameEN;
    
    @Size(max=100,message="{com.cme.m_Val_fieldSize}")
    private String lanNameAR;
    
    @Max(999)
    private short lanCharPerPage;
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(max=1,message="{com.cme.m_Val_fieldSize}")
    private String lanStatus;
    
    private String lanDataCode;
    
    
    private State currentState = State.NONE;
    private String viewMessage;
    private String deleteMessage;
    private String editMessage;
    
    /*
    * We are going to allow user to sort language Code, Name (Eng, Arabic) and Status
    * the following parameters are used to set sorting
    */

    private SortOrder lanCodeOrder = SortOrder.unsorted;
    private SortOrder lanNameEnOrder = SortOrder.unsorted;
    private SortOrder lanNameArOrder = SortOrder.unsorted;
    private SortOrder lanStatusOrder = SortOrder.unsorted;

    /**
     * Creates a new instance of languageBean
     */
    public languageBean() {
        langSession = new LanguageMastFacade();
        customMsg = new ReadResourceBundle();
        viewMessage = customMsg.getCustomMessage("msgs", "m_AlertNothing");
        deleteMessage = customMsg.getCustomMessage("msgs", "m_Alert_DeleteFlag");
        editMessage = customMsg.getCustomMessage("msgs", "m_Alert_SaveChanges");
    }
    
    /**
     * * Getter & Setter
     * @return 
     */
    
    public void setCurrentState(State state){
        currentState = state;
    }
    
    public State getCurrentState(){
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

    public String getLanCode() {
        return lanCode;
    }

    public void setLanCode(String lanCode) {
        this.lanCode = lanCode;
    }

    public String getLanNameEN() {
        return lanNameEN;
    }

    public void setLanNameEN(String lanNameEN) {
        
        this.lanNameEN = lanNameEN;
    }

    public String getLanNameAR() {
        return lanNameAR;
    }

    public void setLanNameAR(String lanNameAR) {
        this.lanNameAR = lanNameAR;
    }

    public short getLanCharPerPage() {
        return lanCharPerPage;
    }

    public void setLanCharPerPage(short lanCharPerPage) {
        this.lanCharPerPage = lanCharPerPage;
    }

    public String getLanStatus() {
        return lanStatus;
    }

    public void setLanStatus(String lanStatus) {
        this.lanStatus = lanStatus;
    }
    
    public String getLanDataCode() {
        return lanDataCode;
    }

    public void setLanDataCode(String lanDataCode) {
        this.lanDataCode = lanDataCode;
    }
    
    public SortOrder getLanCodeOrder() {
    return lanCodeOrder;
    }

    public void setLanCodeOrder(SortOrder lanCodeOrder) {
        this.lanCodeOrder = lanCodeOrder;
    }

    public SortOrder getLanNameEnOrder() {
        return lanNameEnOrder;
    }

    public void setLanNameEnOrder(SortOrder lanNameEnOrder) {
        this.lanNameEnOrder = lanNameEnOrder;
    }

    public SortOrder getLanNameArOrder() {
        return lanNameArOrder;
    }

    public void setLanNameArOrder(SortOrder lanNameArOrder) {
        this.lanNameArOrder = lanNameArOrder;
    }

    public SortOrder getLanStatusOrder() {
        return lanStatusOrder;
    }

    public void setLanStatusOrder(SortOrder lanStatusOrder) {
        this.lanStatusOrder = lanStatusOrder;
    }

           

    
    
    

//List of LanguageMast & Select
    
    public List<LanguageListRecord> getLanguagesList() {
        languagesList = new ArrayList<LanguageListRecord>();
        List<LanguageMast> list = langSession.getLangList();
        for(LanguageMast record:list)
            languagesList.add(new LanguageListRecord(record));
                
        return languagesList;
    }


    public void setLanguagesList(List<LanguageListRecord> languagesList) {
        this.languagesList = languagesList;
    }
    
    
    
    public int getLanguagesCount(){
        return langSession.count();
    }
    
    public List<LanguageMast> getRecordDetail(){
        return detailRecord;
    }
    
     // Sorting & Order methods

    public void sortByLanguageCode(){
        
        lanNameEnOrder = SortOrder.unsorted;
        lanNameArOrder = SortOrder.unsorted;
        lanStatusOrder = SortOrder.unsorted;
        if(lanCodeOrder.equals(SortOrder.ascending)){
            setLanCodeOrder(SortOrder.descending); 
        }
        else
        {
            setLanCodeOrder(SortOrder.ascending); 
        }
    }

    public void sortByLanguageNameEn(){

        lanCodeOrder = SortOrder.unsorted;
        lanNameArOrder = SortOrder.unsorted;
        lanStatusOrder = SortOrder.unsorted;
        if(lanNameEnOrder.equals(SortOrder.ascending)){
            setLanNameEnOrder(SortOrder.descending);
        }
        else
        {
            setLanNameEnOrder(SortOrder.ascending);
        }
    }

    public void sortByLanguageNameAr(){

        lanNameEnOrder = SortOrder.unsorted;
        lanCodeOrder = SortOrder.unsorted;
        lanStatusOrder = SortOrder.unsorted;
        if(lanNameArOrder.equals(SortOrder.ascending)){
            setLanNameArOrder(SortOrder.descending);
        }
        else
        {
            setLanNameArOrder(SortOrder.ascending);
        }
    }

    public void sortByLanguageStatus(){

        lanNameEnOrder = SortOrder.unsorted;
        lanNameArOrder = SortOrder.unsorted;
        lanCodeOrder = SortOrder.unsorted;
        
        if(lanStatusOrder.equals(SortOrder.ascending)){
            setLanStatusOrder(SortOrder.descending);
        }
        else
        {
            setLanStatusOrder(SortOrder.ascending);
        }
    }
    
    //Action
    
    private void setAttrValues(){
        
        if(this.isStateAdd()){
            this.lanCode   = "";
            this.lanNameEN = "";
            this.lanNameAR = "";
            this.lanCharPerPage = 0;
            this.lanStatus = "A";
            this.lanDataCode = "";   
        }
        else
        {
            this.lanCode   = langRecord.getLanCode();
            this.lanNameEN = langRecord.getLanNameEn();
            this.lanNameAR = langRecord.getLanNameAr();
            this.lanCharPerPage = langRecord.getLanChrPerPage();
            this.lanStatus = langRecord.getLanStatus();
            this.lanDataCode = langRecord.getLanDatacode();
        }

        
    }
    
    public String addRecord(){
        
        setCurrentState(State.ADD);
        setAttrValues();
        LanguageMast rec = new LanguageMast();
        detailRecord = new ArrayList<LanguageMast>();
        
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(rec);
        
        return "";
    }
    
    public String editRecord(LanguageMast rec){
        setCurrentState(State.EDIT);
        langRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<LanguageMast>();
        detailRecord.add(langRecord);
        return "";
    }
    
    public String viewRecord(LanguageMast rec){
        setCurrentState(State.VIEW);
        langRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<LanguageMast>();
        detailRecord.add(langRecord);
        return "";
    }
    
    public String deleteRecord(LanguageMast rec){
        setCurrentState(State.DELETE);
        langRecord = rec;
        setAttrValues();
        langRecord.setLanStatus("D");
        this.lanStatus = "D";
      
        detailRecord = new ArrayList<LanguageMast>();
        detailRecord.add(rec);
        return "";
    }
    
    
    public String saveRecord(){
        
        langRecord = new LanguageMast();
        langRecord.setLanCode(lanCode);
        langRecord.setLanNameEn(lanNameEN);
        langRecord.setLanNameAr(lanNameAR);
        langRecord.setLanChrPerPage(lanCharPerPage);
        langRecord.setLanStatus(lanStatus);
        langRecord.setLanDatacode(lanDataCode);
        
        
        if(currentState.equals(State.ADD)){
            if(isRecordValid()){
                langSession.create(langRecord);
                LanguageListRecord listRecord = new LanguageListRecord(langRecord);
                languagesList.add(listRecord);  
                stateRefresh();
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage("formRecord:languageCode", new FacesMessage(customMsg.getCustomMessage("msgs", "m_Alert_DupRecord")));
            }
            
        }
        else{
            langSession.edit(langRecord);
            stateRefresh();
        }
        
        
        return "";

    }
    
    public String stateRefresh(){
        setCurrentState(State.NONE);
        
        langRecord = null;
              
        detailRecord = new ArrayList<LanguageMast>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(langRecord);
        
        getLanguagesList();
        
        return "";
    }
    
    public boolean isRecordValid(){
        boolean valid = true;
//        LanguageMast test = new LanguageMast();
//        test.setLanCode(lanCode);
//        if(languagesList.contains(test))
//            valid = false;
        for(LanguageMast iterate: langSession.getLangList()){
            if(lanCode.equals(iterate.getLanCode())){
                valid = false;
                break;
            }
        }
        return valid;
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
    
    public static class LanguageListRecord implements Serializable{
        private LanguageMast language;
        private boolean selected;
        

        public LanguageListRecord(){
            selected = false;
        }
        
        public LanguageListRecord(LanguageMast lang){
            language = lang;
            selected = false;
        }

        public LanguageMast getLanguage() {
            return language;
        }

        public void setLanguage(LanguageMast language) {
            this.language = language;
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
