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
import com.cme.mBeans.common.ReadResourceBundle;

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
    

    public String getLanCode() {
        return lanCode;
    }

    public void setLanCode(String lanCode) {
        System.out.println("Setting: "+lanCode);
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
    
    
    
    public DataModel<LanguageMast> getAllLanguages(){
        return langSession.getLanguageTable();
    }
    
    public int getLanguagesCount(){
        return langSession.count();
    }
    
    public List<LanguageMast> getRecordDetail(){
        return detailRecord;
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
        lanStatus = "D";
      
        detailRecord = new ArrayList<LanguageMast>();
        detailRecord.add(langRecord);
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
