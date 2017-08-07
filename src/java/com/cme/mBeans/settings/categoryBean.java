/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.mBeans.settings;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.cme.entities.ServiceCategory;
import com.cme.facade.settings.ServiceCategoryFacade;
import com.cme.mBeans.common.CommonObjects;
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
import com.cme.mBeans.common.LocalChanger;
import com.cme.mBeans.common.ReadResourceBundle;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.Basic;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.richfaces.component.SortOrder;
/**
 *
 * @author admin
 */
@Named(value = "category")
@ViewScoped
public class categoryBean implements Serializable {

     @EJB
    private ServiceCategoryFacade catSession;
    private ServiceCategory catRecord;
    private List<ServiceCategory> detailRecord;
    private  List<CatListRecord> categoriesList;
    private ReadResourceBundle customMsg;

    @Id
    @Basic(optional = false)
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min = 1, max = 10,message="{com.cme.m_Val_fieldSize}")
    private String scatCode;
    @Basic(optional = false)
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min = 1, max = 20,message="{com.cme.m_Val_fieldSize}")
    private String scatNameEn;
    @Size(max = 20,message="{com.cme.m_Val_fieldSize}")
    private String scatNameAr;
    @Size(max = 100,message="{com.cme.m_Val_fieldSize}")
    private String scatDesc;
    @Size(max = 10,message="{com.cme.m_Val_fieldSize}")
    private String scatPriority;
    @Size(max = 1,message="{com.cme.m_Val_fieldSize}")
    private String scatStatus;
    
    
    private CommonObjects.State currentState = CommonObjects.State.NONE;
    private String viewMessage;
    private String deleteMessage;
    private String editMessage;    
    private SortOrder scatCodeOrder = SortOrder.unsorted;
    private SortOrder scatNameOrder = SortOrder.unsorted;
    private SortOrder scatNameArOrder = SortOrder.unsorted;
    private SortOrder scatStatusOrder = SortOrder.unsorted;
    @ManagedProperty(value="#{localChanger}")
    LocalChanger localChanger;

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

    
    

    public List<ServiceCategory> getDetailRecord() {
        return detailRecord;
    }

    public void setDetailRecord(List<ServiceCategory> detailRecord) {
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

    public String getScatCode() {
        return scatCode;
    }

    public void setScatCode(String scatCode) {
        this.scatCode = scatCode;
    }

    public String getScatNameEn() {
        return scatNameEn;
    }

    public void setScatNameEn(String scatNameEn) {
        this.scatNameEn = scatNameEn;
    }

    public String getScatNameAr() {
        return scatNameAr;
    }

    public void setScatNameAr(String scatNameAr) {
        this.scatNameAr = scatNameAr;
    }

    public String getScatDesc() {
        return scatDesc;
    }

    public void setScatDesc(String scatDesc) {
        this.scatDesc = scatDesc;
    }

    public String getScatPriority() {
        return scatPriority;
    }

    public void setScatPriority(String scatPriority) {
        this.scatPriority = scatPriority;
    }

    public String getScatStatus() {
        return scatStatus;
    }

    public void setScatStatus(String scatStatus) {
        this.scatStatus = scatStatus;
    }

    public SortOrder getScatCodeOrder() {
        return scatCodeOrder;
    }

    public void setScatCodeOrder(SortOrder scatCodeOrder) {
        this.scatCodeOrder = scatCodeOrder;
    }

    public SortOrder getScatNameOrder() {
        return scatNameOrder;
    }

    public void setScatNameOrder(SortOrder scatNameOrder) {
        this.scatNameOrder = scatNameOrder;
    }

    public SortOrder getScatNameArOrder() {
        return scatNameArOrder;
    }

    public void setScatNameArOrder(SortOrder scatNameArOrder) {
        this.scatNameArOrder = scatNameArOrder;
    }

    public SortOrder getScatStatusOrder() {
        return scatStatusOrder;
    }

    public void setScatStatusOrder(SortOrder scatStatusOrder) {
        this.scatStatusOrder = scatStatusOrder;
    }
    
    
    
   
    public categoryBean() {
        catSession = new ServiceCategoryFacade();
        customMsg = new ReadResourceBundle();
        viewMessage = customMsg.getCustomMessage("msgs", "m_AlertNothing");
        deleteMessage = customMsg.getCustomMessage("msgs", "m_Alert_DeleteFlag");
        editMessage = customMsg.getCustomMessage("msgs", "m_Alert_SaveChanges");
    }
    
    
    public List<CatListRecord> getCategoriesList() {
        categoriesList = new ArrayList<CatListRecord>();
        List<ServiceCategory> list = catSession.getCatList();
        for(ServiceCategory record:list)
            categoriesList.add(new CatListRecord(record));
                
        return categoriesList;
    }
    //For Category Name Dropdown List
    public String getCategoryName(){
        String categoryName = "";
        ServiceCategory result = catSession.getCategoryName(catRecord.getScatCode());
        if(localChanger.getDirection().equals("LTR"))
            categoryName = result.getScatNameEn();
        else
            categoryName = result.getScatNameAr();
        return categoryName;
    }


    public void setCategoriesList(List<CatListRecord> categoriesList) {
        this.categoriesList = categoriesList;
    }
    
        public void sortByScatCode(){
        
        scatNameOrder = SortOrder.unsorted;
        scatNameArOrder = SortOrder.unsorted;
        scatStatusOrder = SortOrder.unsorted;
        if(scatCodeOrder.equals(SortOrder.ascending)){
            setScatCodeOrder(SortOrder.descending); 
        }
        else
        {
            setScatCodeOrder(SortOrder.ascending); 
        }
    }
        
            public void sortByScatName(){
        
        scatCodeOrder = SortOrder.unsorted;
        scatNameArOrder = SortOrder.unsorted;
        scatStatusOrder = SortOrder.unsorted;
        if(scatNameOrder.equals(SortOrder.ascending)){
            setScatNameOrder(SortOrder.descending); 
        }
        else
        {
            setScatNameOrder(SortOrder.ascending); 
        }
    }
            
                public void sortByNameAr(){
        
        scatCodeOrder = SortOrder.unsorted;
        scatNameOrder = SortOrder.unsorted;
        scatStatusOrder = SortOrder.unsorted;
        if(scatNameArOrder.equals(SortOrder.ascending)){
            setScatNameArOrder(SortOrder.descending); 
        }
        else
        {
            setScatNameArOrder(SortOrder.ascending); 
        }
    }
                
                    public void sortByScatStatus(){
        
        scatCodeOrder = SortOrder.unsorted;
        scatNameArOrder = SortOrder.unsorted;
        scatNameOrder = SortOrder.unsorted;
        if(scatStatusOrder.equals(SortOrder.ascending)){
            setScatStatusOrder(SortOrder.descending); 
        }
        else
        {
            setScatStatusOrder(SortOrder.ascending); 
        }
    }
                    
    public int getCategoryCount(){
        return catSession.count();
    }
    
    private void setAttrValues(){
        if(this.isStateAdd()){
            this.scatCode   = "";
            this.scatNameEn = "";
            this.scatNameAr = "";
            this.scatPriority = "NORMAL";
            this.scatStatus = "A";
            this.scatDesc = "";   
        }
        else
        {
            this.scatCode   = catRecord.getScatCode();
            this.scatNameEn = catRecord.getScatNameEn();
            this.scatNameAr = catRecord.getScatNameAr();
            this.scatDesc = catRecord.getScatDesc();
            this.scatStatus = catRecord.getScatStatus();
            this.scatPriority = catRecord.getScatPriority();
        }

        
    }
    
    public String addRecord(){
        setCurrentState(CommonObjects.State.ADD);
        setAttrValues();
        ServiceCategory rec = new ServiceCategory();
        detailRecord = new ArrayList<ServiceCategory>();
        
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(rec);
        
        return "";
    }
    
    public String editRecord(ServiceCategory rec){
        setCurrentState(CommonObjects.State.EDIT);
        catRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServiceCategory>();
        detailRecord.add(catRecord);
        return "";
    }
    
    public String viewRecord(ServiceCategory rec){
        setCurrentState(CommonObjects.State.VIEW);
        catRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServiceCategory>();
        detailRecord.add(catRecord);
        return "";
    }
    
    public String deleteRecord(ServiceCategory rec){
        setCurrentState(CommonObjects.State.DELETE);
        catRecord = rec;
        setAttrValues();
        catRecord.setScatStatus("D");
      
        detailRecord = new ArrayList<ServiceCategory>();
        detailRecord.add(catRecord);
        return "";
    }
    
    
    public String saveRecord(){
        catRecord = new ServiceCategory();
        catRecord.setScatCode(scatCode);
        catRecord.setScatNameEn(scatNameEn);
        catRecord.setScatNameAr(scatNameAr);
        catRecord.setScatDesc(scatDesc);
        catRecord.setScatStatus(scatStatus);
        catRecord.setScatPriority(scatPriority);
        
        
              
        if(currentState.equals(CommonObjects.State.ADD)){
            if(isRecordValid()){
                catSession.create(catRecord);
                CatListRecord listRecord = new CatListRecord(catRecord);
                categoriesList.add(listRecord);  
                stateRefresh();
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage("formRecord:catCode", new FacesMessage(customMsg.getCustomMessage("msgs", "m_Alert_DupRecord")));
            }
            
        }
        else{
            catSession.edit(catRecord);
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
        for(ServiceCategory iterate: catSession.getCatList()){
            if(scatCode.equals(iterate.getScatCode())){
                valid = false;
                break;
            }
        }
        return valid;
    }
    
    public String stateRefresh(){
        setCurrentState(CommonObjects.State.NONE);
        
        catRecord = null;
              
        detailRecord = new ArrayList<ServiceCategory>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(catRecord);
        
        getCategoriesList();
        
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
    
    
    

    public static class CatListRecord implements Serializable{

        private ServiceCategory category;
        private boolean selected;
        
        public CatListRecord(){
            selected = false;
        }
           
        public CatListRecord(ServiceCategory cat){
            category = cat;
            selected = false;
        }

        public ServiceCategory getCategory() {
            return category;
        }

        public void setCategory(ServiceCategory category) {
            this.category = category;
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
