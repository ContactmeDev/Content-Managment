/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans.settings;
import com.cme.entities.ServiceMast;
import com.cme.entities.ServiceText;
import com.cme.entities.SubserviceMast;
import com.cme.facade.settings.ServiceMastFacade;
import com.cme.facade.settings.ServiceTextFacade;
import com.cme.facade.settings.SubserviceMastFacade;
import com.cme.mBeans.common.CommonObjects.State;
import static com.cme.mBeans.common.CommonObjects.recordStateImage;
import static com.cme.mBeans.common.CommonObjects.tableStateImage;
import com.cme.mBeans.common.ReadResourceBundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.richfaces.component.SortOrder;

/**
 *
 * @author hp
 */
@ManagedBean(name="srvText")
@ViewScoped
public class serviceTextBean implements Serializable{
@EJB
    private ServiceTextFacade srvTextSession;
    private ServiceText srvTextRecord;
    private List<ServiceText> detailRecord;
    private List<srvTextistRecord> srvTextList;
    private ReadResourceBundle customMsg;
    private SortOrder codeOrder = SortOrder.unsorted;
    private SortOrder nameOrder = SortOrder.unsorted;
    private EntityManager em;
    FacesMessage message = null;
    private int model;
    @EJB
    private ServiceMastFacade srvSession;
    private ServiceMast srvRecord;
    @EJB
    private SubserviceMastFacade ssrvSession;
    private SubserviceMast ssrvRecord;
    
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min=1,max=10,message="{com.cme.m_Val_fieldSize}")
    private String txtCode;
    
    @Size(max=30,message="{com.cme.m_Val_fieldSize}")
    private String txtSrvCode;
    
    @Size(max=30,message="{com.cme.m_Val_fieldSize}")
    private String txtSsrvCode;
    
    @Size(max=2,message="{com.cme.m_Val_fieldSize}")
    private String txtDefault;
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min=1,max=1000,message="{com.cme.m_Val_fieldSize}")
    private String txtTextEn;
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min=1,max=1000,message="{com.cme.m_Val_fieldSize}")
    private String txtTextAr;
    
    @Size(max=3,message="{com.cme.m_Val_fieldSize}")
    private String txtMsgCode;
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    @Size(min=1,max=1,message="{com.cme.m_Val_fieldSize}")
    private String txtStatus;
    
    
    @Size(min=1,max=30,message="{com.cme.m_Val_fieldSize}")
    private String txtAddUid;
    
    @NotNull(message="{com.cme.m_Val_notNull}")
    private Date txtAddDate;
    
    @Size(max=30,message="{com.cme.m_Val_fieldSize}")
    private String txtModUid;
    
    private Date txtModDate;
    
    @Size(max=10,message="{com.cme.m_Val_fieldSize}")
    private String txtAddiLang1;
    
    @Size(max=1000,message="{com.cme.m_Val_fieldSize}")
    private String txtAddiLang1Text;
    
    @Size(max=250,message="{com.cme.m_Val_fieldSize}")
    private String txtFlex01;
    
    @Size(max=250,message="{com.cme.m_Val_fieldSize}")
    private String txtFlex02;
    
    @Size(max=250,message="{com.cme.m_Val_fieldSize}")
    private String txtFlex03;
    
    @Size(max=250,message="{com.cme.m_Val_fieldSize}")
    private String txtFlex04;
    
    @Size(max=250,message="{com.cme.m_Val_fieldSize}")
    private String txtFlex05;
    
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
     * Creates a new instance of serviceTextBean
     */
    
    public serviceTextBean() {
         srvTextSession = new ServiceTextFacade();
         customMsg = new ReadResourceBundle();
         viewMessage = customMsg.getCustomMessage("msgs", "m_AlertNothing");
         deleteMessage = customMsg.getCustomMessage("msgs", "m_Alert_DeleteFlag");
         editMessage = customMsg.getCustomMessage("msgs", "m_Alert_SaveChanges");
    }
    
    /**
     * * Getter & Setter
     * @return 
     */
    public List<ServiceText> getDetailRecord() {
        return detailRecord;
    }

    public void setDetailRecord(List<ServiceText> detailRecord) {
        this.detailRecord = detailRecord;
    }

    


    public ReadResourceBundle getCustomMsg() {
        return customMsg;
    }

    public void setCustomMsg(ReadResourceBundle customMsg) {
        this.customMsg = customMsg;
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

    public String getTxtCode() {
        return txtCode;
    }

    public void setTxtCode(String txtCode) {
        this.txtCode = txtCode;
    }

    public String getTxtSrvCode() {
        return txtSrvCode;
    }

    public void setTxtSrvCode(String txtSrvCode) {
        this.txtSrvCode = txtSrvCode;
    }

    public String getTxtDefault() {
        return txtDefault;
    }

    public void setTxtDefault(String txtDefault) {
        this.txtDefault = txtDefault;
    }

    public String getTxtTextEn() {
        return txtTextEn;
    }

    public void setTxtTextEn(String txtTextEn) {
        this.txtTextEn = txtTextEn;
    }

    public String getTxtTextAr() {
        return txtTextAr;
    }

    public void setTxtTextAr(String txtTextAr) {
        this.txtTextAr = txtTextAr;
    }

    public String getTxtStatus() {
        return txtStatus;
    }

    public void setTxtStatus(String txtStatus) {
        this.txtStatus = txtStatus;
    }

    public String getTxtAddUid() {
        return txtAddUid;
    }

    public void setTxtAddUid(String txtAddUid) {
        this.txtAddUid = txtAddUid;
    }

    public Date getTxtAddDate() {
        return txtAddDate;
    }

    public void setTxtAddDate(Date txtAddDate) {
        this.txtAddDate = txtAddDate;
    }

    public String getTxtModUid() {
        return txtModUid;
    }

    public void setTxtModUid(String txtModUid) {
        this.txtModUid = txtModUid;
    }

    public Date getTxtModDate() {
        return txtModDate;
    }

    public void setTxtModDate(Date txtModDate) {
        this.txtModDate = txtModDate;
    }

    public String getTxtAddiLang1() {
        return txtAddiLang1;
    }

    public void setTxtAddiLang1(String txtAddiLang1) {
        this.txtAddiLang1 = txtAddiLang1;
    }

    public String getTxtAddiLang1Text() {
        return txtAddiLang1Text;
    }

    public void setTxtAddiLang1Text(String txtAddiLang1Text) {
        this.txtAddiLang1Text = txtAddiLang1Text;
    }

    public String getTxtFlex01() {
        return txtFlex01;
    }

    public void setTxtFlex01(String txtFlex01) {
        this.txtFlex01 = txtFlex01;
    }

    public String getTxtFlex03() {
        return txtFlex03;
    }

    public void setTxtFlex03(String txtFlex03) {
        this.txtFlex03 = txtFlex03;
    }

    public String getTxtFlex04() {
        return txtFlex04;
    }

    public void setTxtFlex04(String txtFlex04) {
        this.txtFlex04 = txtFlex04;
    }

    public String getTxtFlex05() {
        return txtFlex05;
    }

    public void setTxtFlex05(String txtFlex05) {
        this.txtFlex05 = txtFlex05;
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

    public String getTxtSsrvCode() {
        return txtSsrvCode;
    }

    public void setTxtSsrvCode(String txtSsrvCode) {
        this.txtSsrvCode = txtSsrvCode;
    }

    public String getTxtMsgCode() {
        return txtMsgCode;
    }

    public void setTxtMsgCode(String txtMsgCode) {
        this.txtMsgCode = txtMsgCode;
    }

    public String getViewMessage() {
        return viewMessage;
    }

    public void setViewMessage(String viewMessage) {
        this.viewMessage = viewMessage;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getTxtFlex02() {
        return txtFlex02;
    }

    public void setTxtFlex02(String txtFlex02) {
        this.txtFlex02 = txtFlex02;
    }

    
    //List of CurrencyMast & Select
    
    public List<srvTextistRecord> getSrvTextList() {
        srvTextList = new ArrayList<srvTextistRecord>();
        List<ServiceText> list = srvTextSession.getSrvTxtList();
         for(ServiceText record:list)
             srvTextList.add(new srvTextistRecord(record));
                
        return srvTextList;
    }

    public void setSrvTextList(List<srvTextistRecord> srvTextList) {
        this.srvTextList = srvTextList;
    }
       

    
    public DataModel<ServiceText> getAllsrvText(){
        return srvTextSession.getSrvTextTable();
    }
    
    public int getSrvTextCount(){
        return srvTextSession.count();
    }
    
    public List<ServiceText> getRecordDetail(){
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
            this.txtCode   = "";
            this.txtSrvCode = "";
            this.txtSsrvCode = "";
            this.txtDefault = "";
            this.txtTextEn = "";
            this.txtTextAr   = "";
            this.txtMsgCode = "";
            this.txtAddUid= "";
//            this.txtAddDate = "";
            this.txtStatus= "A";
            this.txtModUid   = "";
//            this.txtModDate = "";
            this.txtAddiLang1 = "";
            this.txtAddiLang1Text = "";
            this.txtFlex01 = "";
            this.txtFlex02 = "";
            this.txtFlex03 = "";
            this.txtFlex04 = "";
            this.txtFlex05 = "";
             
        }
        else
        {
            this.txtCode   = srvTextRecord.getTxtCode();
            this.txtSrvCode = srvTextRecord.getTxtSrvCode();
            this.txtSsrvCode = srvTextRecord.getTxtSsrvCode();
            this.txtDefault = srvTextRecord.getTxtDefault();
            this.txtTextEn = srvTextRecord.getTxtTextEn();
            this.txtTextAr   = srvTextRecord.getTxtTextAr();
            this.txtMsgCode = srvTextRecord.getTxtMsgCode();
            this.txtAddUid = srvTextRecord.getTxtAddUid();
            this.txtAddDate = srvTextRecord.getTxtAddDate();
            this.txtStatus = srvTextRecord.getTxtStatus();
            this.txtModUid   = srvTextRecord.getTxtModUid();
            this.txtModDate = srvTextRecord.getTxtModDate();
            this.txtAddiLang1 = srvTextRecord.getTxtAddiLang1();
            this.txtAddiLang1Text = srvTextRecord.getTxtAddiLang1Text();
            this.txtFlex01 = srvTextRecord.getTxtFlex01();
            this.txtFlex02   = srvTextRecord.getTxtFlex02();
            this.txtFlex03 = srvTextRecord.getTxtFlex03();
            this.txtFlex04 = srvTextRecord.getTxtFlex04();
            this.txtFlex05 = srvTextRecord.getTxtFlex05();
            
           
        }
    }
    
    public String addRecord(){
        setCurrentState(State.ADD);
        setAttrValues();
        ServiceText rec = new ServiceText();
        detailRecord = new ArrayList<ServiceText>();
        
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(rec);
        
        return "";
    }
    
    public String editRecord(ServiceText rec){
        setCurrentState(State.EDIT);
        srvTextRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServiceText >();
        detailRecord.add(srvTextRecord);
        return "";
    }
      
    public String viewRecord(ServiceText rec){
        setCurrentState(State.VIEW);
        srvTextRecord = rec;
        
        setAttrValues();
      
        detailRecord = new ArrayList<ServiceText>();
        detailRecord.add(srvTextRecord);
        return "";
    }
     
    public String deleteRecord(ServiceText rec){
        setCurrentState(State.DELETE);
        srvTextRecord = rec;
        setAttrValues();
         srvTextRecord.setTxtStatus("D");
         txtStatus = "D";
      
        detailRecord = new ArrayList<ServiceText>();
        detailRecord.add( srvTextRecord);
        return "";
    }
      
    public String saveRecord(){
    
        srvTextRecord = new ServiceText(); 
        srvTextRecord.setTxtCode(txtCode);
        srvTextRecord.setTxtSrvCode(txtSrvCode);
        srvTextRecord.setTxtSsrvCode(txtSsrvCode);
        srvTextRecord.setTxtDefault(txtDefault);
        srvTextRecord.setTxtMsgCode(txtMsgCode); 
        srvTextRecord.setTxtTextEn(txtTextEn);
        srvTextRecord.setTxtTextAr(txtTextAr);
        srvTextRecord.setTxtStatus(txtStatus);
        srvTextRecord.setTxtAddUid(txtAddUid);
       
        srvTextRecord.setTxtAddDate(txtAddDate); 
        srvTextRecord.setTxtModUid(txtModUid);
        
        srvTextRecord.setTxtModDate(txtModDate);
        srvTextRecord.setTxtAddiLang1(txtAddiLang1);
        srvTextRecord.setTxtAddiLang1Text(txtAddiLang1Text);
        srvTextRecord.setTxtFlex01(txtFlex01); 
        srvTextRecord.setTxtFlex02(txtFlex02); 
        srvTextRecord.setTxtFlex03(txtFlex03); 
        srvTextRecord.setTxtFlex04(txtFlex04); 
        srvTextRecord.setTxtFlex05(txtFlex05); 
        
         if(currentState.equals(State.ADD)){
            if(isRecordValid()){
                srvTextSession.create(srvTextRecord);
                srvTextistRecord listRecord = new srvTextistRecord(srvTextRecord);
                srvTextList.add(listRecord);  
                stateRefresh();
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage("formRecord:txtCode", new FacesMessage(customMsg.getCustomMessage("msgs", "m_Alert_DupRecord")));
            }
            
        }
        else{
            srvTextSession.edit(srvTextRecord);
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
        for(ServiceText iterate: srvTextSession.getSrvTxtList()){
            if(txtCode.equals(iterate.getTxtCode())){
                valid = false;
                break;
            }
        }
        return valid;
    }
    
       
            
    public String stateRefresh(){
        setCurrentState(State.NONE);
        
        srvTextRecord = null;
              
        detailRecord = new ArrayList<ServiceText>();
        if (!detailRecord.isEmpty())
            detailRecord.clear();
        detailRecord.add(srvTextRecord);
        
        getSrvTextList();
        
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
    
     public boolean hasSubservice(){
        boolean result = false;
        
        if(! txtSrvCode.equals("") && !txtSrvCode.isEmpty() && txtSrvCode != null)
           result = srvSession.isSubserviceExist(txtSrvCode);
        return result; 
    }
    
    public static class srvTextistRecord implements Serializable{
        private ServiceText srvText;
        private boolean selected;
        
        public srvTextistRecord (){
            selected = false;
        }
        
        public srvTextistRecord (ServiceText srvTxt ){
            srvText = srvTxt;
            selected = false;
        }

        public ServiceText getSrvText() {
            return  srvText;
        }

        public void setSrvText(ServiceText srvText) {
            this. srvText =  srvText;
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

