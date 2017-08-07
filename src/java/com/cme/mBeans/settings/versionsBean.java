/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.mBeans.settings;

import com.cme.entities.ServicesVersion;
import com.cme.entities.ServicesVersionDetail;
import com.cme.facade.settings.ServicesVersionFacade;
import com.cme.mBeans.common.CommonObjects;
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
import com.cme.mBeans.common.ReadResourceBundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.Basic;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.richfaces.component.SortOrder;


/**
 *
 * @author admin
 */
@Named(value = "versions")
@ViewScoped
public class versionsBean implements Serializable {
   @EJB
//       private static final String PERSISTENCE_UNIT_NAME = "ServicesVersion";
//       private static EntityManagerFactory factory;
    private ServicesVersionFacade verSession;
    private ServicesVersion verRecord;
    private List<ServicesVersion> detailRecord;
    private List<VersionsListRecord> versionsList;
    private SortOrder versionsOrder = SortOrder.unsorted;
    private SortOrder numbersOrder = SortOrder.unsorted;
    private SortOrder createdOrder = SortOrder.unsorted;
    private SortOrder releasedOrder = SortOrder.unsorted;
    private SortOrder statusDateOrder = SortOrder.unsorted;
    @ManagedProperty(value="#{versionsDetail}") 
    versionsDetailBean versionsDetail;

    private EntityManager em;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String verId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String verSrvCode;
    @Size(max = 30)
    private String verSsrvCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String verType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String verNumb;
    @Basic(optional = false)
    @NotNull
    private int verSeq;
    @Temporal(TemporalType.TIMESTAMP)
    private Date verCreated;
    @Temporal(TemporalType.TIMESTAMP)
    private Date verReleased;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    private String verStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date verStatusDate;
    //private CommonObjects.State currentState = CommonObjects.State.NONE;
    private String viewMessage;
    private String deleteMessage;
    private String editMessage;
    private ReadResourceBundle customMsg;

    
    private CommonObjects.State currentState = CommonObjects.State.NONE;

    public versionsDetailBean getVersionsDetail() {
        return versionsDetail;
    }

    public void setVersionsDetail(versionsDetailBean versionsDetail) {
        this.versionsDetail = versionsDetail;
    }

   
    
    
    
     public int getVersionsCount(){
        return verSession.count();
    }
    public List<ServicesVersion> getDetailRecord() {
        return detailRecord;
    }

    public void setDetailRecord(List<ServicesVersion> detailRecord) {
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

    public SortOrder getVersionsOrder() {
        return versionsOrder;
    }

    public void setVersionsOrder(SortOrder versionsOrder) {
        this.versionsOrder = versionsOrder;
    }

    public SortOrder getNumbersOrder() {
        return numbersOrder;
    }

    public void setNumbersOrder(SortOrder numbersOrder) {
        this.numbersOrder = numbersOrder;
    }

    public SortOrder getCreatedOrder() {
        return createdOrder;
    }

    public void setCreatedOrder(SortOrder createdOrder) {
        this.createdOrder = createdOrder;
    }

    public SortOrder getReleasedOrder() {
        return releasedOrder;
    }

    public void setReleasedOrder(SortOrder releasedOrder) {
        this.releasedOrder = releasedOrder;
    }

    public SortOrder getStatusDateOrder() {
        return statusDateOrder;
    }

    public void setStatusDateOrder(SortOrder statusDateOrder) {
        this.statusDateOrder = statusDateOrder;
    }

    
    
    
    
    
    public String getVerId() {
        return verId;
    }

    public void setVerId(String verId) {
        this.verId = verId;
    }

    public String getVerSrvCode() {
        return verSrvCode;
    }

    public void setVerSrvCode(String verSrvCode) {
        this.verSrvCode = verSrvCode;
    }

    public String getVerSsrvCode() {
        return verSsrvCode;
    }

    public void setVerSsrvCode(String verSsrvCode) {
        this.verSsrvCode = verSsrvCode;
    }

    public String getVerType() {
        return verType;
    }

    public void setVerType(String verType) {
        this.verType = verType;
    }

    public String getVerNumb() {
        return verNumb;
    }

    public void setVerNumb(String verNumb) {
        this.verNumb = verNumb;
    }

    public int getVerSeq() {
        return verSeq;
    }

    public void setVerSeq(int verSeq) {
        this.verSeq = verSeq;
    }

    public Date getVerCreated() {
        return verCreated;
    }

    public void setVerCreated(Date verCreated) {
        this.verCreated = verCreated;
    }

    public Date getVerReleased() {
        return verReleased;
    }

    public void setVerReleased(Date verReleased) {
        this.verReleased = verReleased;
    }

    public String getVerStatus() {
        return verStatus;
    }

    public void setVerStatus(String verStatus) {
        this.verStatus = verStatus;
    }

    public Date getVerStatusDate() {
        return verStatusDate;
    }

    public void setVerStatusDate(Date verStatusDate) {
        this.verStatusDate = verStatusDate;
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

    

    
    public versionsBean() {
        verSession = new ServicesVersionFacade();
        customMsg = new ReadResourceBundle();
        viewMessage = customMsg.getCustomMessage("msgs", "m_AlertNothing");
        deleteMessage = customMsg.getCustomMessage("msgs", "m_Alert_DeleteFlag");
        editMessage = customMsg.getCustomMessage("msgs", "m_Alert_SaveChanges");
       
    }
    
    public void sortByVersions() {
        numbersOrder = SortOrder.unsorted;
        statusDateOrder = SortOrder.unsorted;
        releasedOrder = SortOrder.unsorted;
        createdOrder = SortOrder.unsorted;
        if (versionsOrder.equals(SortOrder.ascending)) {
            setVersionsOrder(SortOrder.descending);
        } else {
            setVersionsOrder(SortOrder.ascending);
        }
    }
    
     public void sortByCreated() {
        numbersOrder = SortOrder.unsorted;
        releasedOrder = SortOrder.unsorted;
        statusDateOrder = SortOrder.unsorted;
        versionsOrder = SortOrder.unsorted;
        

        
        if (createdOrder.equals(SortOrder.ascending)) {
            setCreatedOrder(SortOrder.descending);
        } else {
            setCreatedOrder(SortOrder.ascending);
        }
    }
     
      public void sortByReleased() {
        numbersOrder = SortOrder.unsorted;
        createdOrder = SortOrder.unsorted;
        versionsOrder = SortOrder.unsorted;
        statusDateOrder = SortOrder.unsorted;


        if (releasedOrder.equals(SortOrder.ascending)) {
            setReleasedOrder(SortOrder.descending);
        } else {
            setReleasedOrder(SortOrder.ascending);
        }
    }
      
       public void sortByStatus() {
        numbersOrder = SortOrder.unsorted;
        releasedOrder = SortOrder.unsorted;
        createdOrder = SortOrder.unsorted;
        versionsOrder = SortOrder.unsorted;
        if (statusDateOrder.equals(SortOrder.ascending)) {
            setStatusDateOrder(SortOrder.descending);
        } else {
            setStatusDateOrder(SortOrder.ascending);
        }
    }
    
     public void sortByNumbers() {
        versionsOrder = SortOrder.unsorted;
        releasedOrder = SortOrder.unsorted;
        createdOrder = SortOrder.unsorted;
        versionsOrder = SortOrder.unsorted;
        if (numbersOrder.equals(SortOrder.ascending)) {
            setNumbersOrder(SortOrder.descending);
        } else {
            setNumbersOrder(SortOrder.ascending);
        }
    }
    
    
     public List<VersionsListRecord> getVersionsList() {
        versionsList = new ArrayList<VersionsListRecord>();
        List<ServicesVersion> list = verSession.getCatList();
        for(ServicesVersion record:list)
            versionsList.add(new VersionsListRecord(record));
                
        return versionsList;
    }


    public void setVersionsList(List<VersionsListRecord> versionsList) {
        this.versionsList = versionsList;
    }
      
    
//     public String getServiceVersions(String verd){
//        return verSession.getServiceVersions(verd);
//    }
//    
    
      private void setAttrValues(){
        if(this.isStateAdd()){
           
            this.verId   = "";
            this.verNumb = "";
         //   this.verCreated = new Date();
          //  this.verReleased = new Date();
            this.verSeq =0;
            this.verSrvCode = "";
            this.verSsrvCode = "";
            this.verStatus = "A";
         //   this.verStatusDate = new Date();
          
           



        }
        else
        {
            this.verId   = verRecord.getVerId();
            this.verNumb = verRecord.getVerNumb();
            this.verCreated = verRecord.getVerCreated();
            this.verReleased = verRecord.getVerReleased();
            this.verSeq = verRecord.getVerSeq();
            this.verSrvCode = verRecord.getVerSrvCode();
            this.verSsrvCode = verRecord.getVerSsrvCode();
            this.verStatus = verRecord.getVerStatus();
            this.verStatusDate = verRecord.getVerStatusDate();
            
        }

        
    }
      
      public String addRecord(){
        setCurrentState(CommonObjects.State.ADD);
         versionsDetail.setCurrentState(CommonObjects.State.NONE);
        versionsDetail.setCurrentDetailState(CommonObjects.State.NONE);
        setAttrValues();
        ServicesVersion rec = new ServicesVersion();
        detailRecord = new ArrayList<ServicesVersion>();
        
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(rec);
        
        return "";
    }
      
      
    public String editRecord(ServicesVersion rec){
        setCurrentState(CommonObjects.State.EDIT);
        versionsDetail.setCurrentState(CommonObjects.State.NONE);
        versionsDetail.setCurrentDetailState(CommonObjects.State.NONE);
        verRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServicesVersion>();
        detailRecord.add(verRecord);
        return "";
    }
    
    public String viewRecord(ServicesVersion rec){
        setCurrentState(CommonObjects.State.VIEW);
        verRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServicesVersion>();
        detailRecord.add(verRecord);
        return "";
    }
    
    public String deleteRecord(ServicesVersion rec){
        setCurrentState(CommonObjects.State.DELETE);
        versionsDetail.setCurrentState(CommonObjects.State.NONE);
        versionsDetail.setCurrentDetailState(CommonObjects.State.NONE);
        verRecord = rec;
        setAttrValues();
        verRecord.setVerStatus("D");
      
        detailRecord = new ArrayList<ServicesVersion>();
        detailRecord.add(verRecord);
        return "";
    }
    
    
    public String saveRecord(){
//        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//            EntityManager em = factory.createEntityManager();
//        Query q = em.createNamedQuery("ServicesVersion.findByVerId").setParameter("verId", verId);
//
//            try{
//               ServicesVersion user = (ServicesVersion) q.getSingleResult();
//             if (verId.equalsIgnoreCase(user.getVerId())) {
//                FacesContext.getCurrentInstance().getMessages(verId);
//              
//            
//             } else{
           
      
        verRecord = new ServicesVersion();
        verRecord.setVerId(verId);
        verRecord.setVerNumb(verNumb);
        verRecord.setVerCreated(verCreated);
        verRecord.setVerReleased(verReleased);
        verRecord.setVerStatus(verStatus);
        verRecord.setVerStatusDate(verStatusDate);
        verRecord.setVerType(verType);
        verRecord.setVerSrvCode(verSrvCode);
        verRecord.setVerSsrvCode(verSsrvCode);
        verRecord.setVerSeq(verSeq);

        
        
               if(currentState.equals(CommonObjects.State.ADD)){
            if(isRecordValid()){
                verSession.create(verRecord);
                VersionsListRecord listRecord = new VersionsListRecord(verRecord);
                versionsList.add(listRecord);  
                stateRefresh();
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage("formRecord:verCode", new FacesMessage(customMsg.getCustomMessage("msgs", "m_Alert_DupRecord")));
            }
            
        }
        else{
            verSession.edit(verRecord);
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
        for(ServicesVersion iterate: verSession.getCatList()){
            if(verId.equals(iterate.getVerId())){
                valid = false;
                break;
            }
        }
        return valid;
    }
    
    public String stateRefresh(){
        setCurrentState(CommonObjects.State.NONE);
        
        verRecord = null;
              
        detailRecord = new ArrayList<ServicesVersion>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(verRecord);
        
        getVersionsList();
        
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
    
    
    

    public static class VersionsListRecord implements Serializable{

        private ServicesVersion versions;
   
     private boolean selected;
        private ServicesVersionDetail dVersions;
        

        public ServicesVersionDetail getdVersions() {
            return dVersions;
        }

        public void setdVersions(ServicesVersionDetail dVersions) {
            this.dVersions = dVersions;
        }
        
        public VersionsListRecord(){
            selected = false;
        }
           
        public VersionsListRecord(ServicesVersion ver ){
            versions = ver;
            selected = false;
            
        }

        public ServicesVersion getVersions() {
            return versions;
        }

        public void setVersions(ServicesVersion versions) {
            this.versions = versions;
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
