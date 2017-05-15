/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mustafaahmed
 */
@Entity
@Table(name = "SERVICE_TEXT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceText.findAll", query = "SELECT s FROM ServiceText s"),
    @NamedQuery(name = "ServiceText.findByTxtCode", query = "SELECT s FROM ServiceText s WHERE s.txtCode = :txtCode"),
    @NamedQuery(name = "ServiceText.findByTxtSrvCode", query = "SELECT s FROM ServiceText s WHERE s.txtSrvCode = :txtSrvCode"),
    @NamedQuery(name = "ServiceText.findByTxtSsrvCode", query = "SELECT s FROM ServiceText s WHERE s.txtSsrvCode = :txtSsrvCode"),
    @NamedQuery(name = "ServiceText.findByTxtDefault", query = "SELECT s FROM ServiceText s WHERE s.txtDefault = :txtDefault"),
    @NamedQuery(name = "ServiceText.findByTxtTextEn", query = "SELECT s FROM ServiceText s WHERE s.txtTextEn = :txtTextEn"),
    @NamedQuery(name = "ServiceText.findByTxtTextAr", query = "SELECT s FROM ServiceText s WHERE s.txtTextAr = :txtTextAr"),
    @NamedQuery(name = "ServiceText.findByTxtMsgCode", query = "SELECT s FROM ServiceText s WHERE s.txtMsgCode = :txtMsgCode"),
    @NamedQuery(name = "ServiceText.findByTxtStatus", query = "SELECT s FROM ServiceText s WHERE s.txtStatus = :txtStatus"),
    @NamedQuery(name = "ServiceText.findByTxtAddUid", query = "SELECT s FROM ServiceText s WHERE s.txtAddUid = :txtAddUid"),
    @NamedQuery(name = "ServiceText.findByTxtAddDate", query = "SELECT s FROM ServiceText s WHERE s.txtAddDate = :txtAddDate"),
    @NamedQuery(name = "ServiceText.findByTxtModUid", query = "SELECT s FROM ServiceText s WHERE s.txtModUid = :txtModUid"),
    @NamedQuery(name = "ServiceText.findByTxtModDate", query = "SELECT s FROM ServiceText s WHERE s.txtModDate = :txtModDate"),
    @NamedQuery(name = "ServiceText.findByTxtAddiLang1", query = "SELECT s FROM ServiceText s WHERE s.txtAddiLang1 = :txtAddiLang1"),
    @NamedQuery(name = "ServiceText.findByTxtAddiLang1Text", query = "SELECT s FROM ServiceText s WHERE s.txtAddiLang1Text = :txtAddiLang1Text"),
    @NamedQuery(name = "ServiceText.findByTxtFlex01", query = "SELECT s FROM ServiceText s WHERE s.txtFlex01 = :txtFlex01"),
    @NamedQuery(name = "ServiceText.findByTxtFlex02", query = "SELECT s FROM ServiceText s WHERE s.txtFlex02 = :txtFlex02"),
    @NamedQuery(name = "ServiceText.findByTxtFlex03", query = "SELECT s FROM ServiceText s WHERE s.txtFlex03 = :txtFlex03"),
    @NamedQuery(name = "ServiceText.findByTxtFlex04", query = "SELECT s FROM ServiceText s WHERE s.txtFlex04 = :txtFlex04"),
    @NamedQuery(name = "ServiceText.findByTxtFlex05", query = "SELECT s FROM ServiceText s WHERE s.txtFlex05 = :txtFlex05")})
public class ServiceText implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TXT_CODE")
    private String txtCode;
    @Size(max = 30)
    @Column(name = "TXT_SRV_CODE")
    private String txtSrvCode;
    @Size(max = 30)
    @Column(name = "TXT_SSRV_CODE")
    private String txtSsrvCode;
    @Size(max = 2)
    @Column(name = "TXT_DEFAULT")
    private String txtDefault;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "TXT_TEXT_EN")
    private String txtTextEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "TXT_TEXT_AR")
    private String txtTextAr;
    @Size(max = 3)
    @Column(name = "TXT_MSG_CODE")
    private String txtMsgCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TXT_STATUS")
    private String txtStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TXT_ADD_UID")
    private String txtAddUid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TXT_ADD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date txtAddDate;
    @Size(max = 30)
    @Column(name = "TXT_MOD_UID")
    private String txtModUid;
    @Column(name = "TXT_MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date txtModDate;
    @Size(max = 10)
    @Column(name = "TXT_ADDI_LANG1")
    private String txtAddiLang1;
    @Size(max = 1000)
    @Column(name = "TXT_ADDI_LANG1_TEXT")
    private String txtAddiLang1Text;
    @Size(max = 250)
    @Column(name = "TXT_FLEX01")
    private String txtFlex01;
    @Size(max = 250)
    @Column(name = "TXT_FLEX02")
    private String txtFlex02;
    @Size(max = 250)
    @Column(name = "TXT_FLEX03")
    private String txtFlex03;
    @Size(max = 250)
    @Column(name = "TXT_FLEX04")
    private String txtFlex04;
    @Size(max = 250)
    @Column(name = "TXT_FLEX05")
    private String txtFlex05;

    public ServiceText() {
    }

    public ServiceText(String txtCode) {
        this.txtCode = txtCode;
    }

    public ServiceText(String txtCode, String txtTextEn, String txtTextAr, String txtStatus, String txtAddUid, Date txtAddDate) {
        this.txtCode = txtCode;
        this.txtTextEn = txtTextEn;
        this.txtTextAr = txtTextAr;
        this.txtStatus = txtStatus;
        this.txtAddUid = txtAddUid;
        this.txtAddDate = txtAddDate;
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

    public String getTxtSsrvCode() {
        return txtSsrvCode;
    }

    public void setTxtSsrvCode(String txtSsrvCode) {
        this.txtSsrvCode = txtSsrvCode;
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

    public String getTxtMsgCode() {
        return txtMsgCode;
    }

    public void setTxtMsgCode(String txtMsgCode) {
        this.txtMsgCode = txtMsgCode;
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

    public String getTxtFlex02() {
        return txtFlex02;
    }

    public void setTxtFlex02(String txtFlex02) {
        this.txtFlex02 = txtFlex02;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (txtCode != null ? txtCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceText)) {
            return false;
        }
        ServiceText other = (ServiceText) object;
        if ((this.txtCode == null && other.txtCode != null) || (this.txtCode != null && !this.txtCode.equals(other.txtCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceText[ txtCode=" + txtCode + " ]";
    }
    
}
