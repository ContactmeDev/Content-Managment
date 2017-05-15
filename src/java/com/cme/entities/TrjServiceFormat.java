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
@Table(name = "TRJ_SERVICE_FORMAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrjServiceFormat.findAll", query = "SELECT t FROM TrjServiceFormat t"),
    @NamedQuery(name = "TrjServiceFormat.findByFormCode", query = "SELECT t FROM TrjServiceFormat t WHERE t.formCode = :formCode"),
    @NamedQuery(name = "TrjServiceFormat.findByFormReqRes", query = "SELECT t FROM TrjServiceFormat t WHERE t.formReqRes = :formReqRes"),
    @NamedQuery(name = "TrjServiceFormat.findByFormName", query = "SELECT t FROM TrjServiceFormat t WHERE t.formName = :formName"),
    @NamedQuery(name = "TrjServiceFormat.findByFormDesc", query = "SELECT t FROM TrjServiceFormat t WHERE t.formDesc = :formDesc"),
    @NamedQuery(name = "TrjServiceFormat.findByFormTextEn", query = "SELECT t FROM TrjServiceFormat t WHERE t.formTextEn = :formTextEn"),
    @NamedQuery(name = "TrjServiceFormat.findByFormTextAr", query = "SELECT t FROM TrjServiceFormat t WHERE t.formTextAr = :formTextAr"),
    @NamedQuery(name = "TrjServiceFormat.findByFormAddUid", query = "SELECT t FROM TrjServiceFormat t WHERE t.formAddUid = :formAddUid"),
    @NamedQuery(name = "TrjServiceFormat.findByFormAddDate", query = "SELECT t FROM TrjServiceFormat t WHERE t.formAddDate = :formAddDate"),
    @NamedQuery(name = "TrjServiceFormat.findByFormModUid", query = "SELECT t FROM TrjServiceFormat t WHERE t.formModUid = :formModUid"),
    @NamedQuery(name = "TrjServiceFormat.findByFormModDate", query = "SELECT t FROM TrjServiceFormat t WHERE t.formModDate = :formModDate"),
    @NamedQuery(name = "TrjServiceFormat.findByFormStatus", query = "SELECT t FROM TrjServiceFormat t WHERE t.formStatus = :formStatus")})
public class TrjServiceFormat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FORM_CODE")
    private String formCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FORM_REQ_RES")
    private String formReqRes;
    @Size(max = 150)
    @Column(name = "FORM_NAME")
    private String formName;
    @Size(max = 250)
    @Column(name = "FORM_DESC")
    private String formDesc;
    @Size(max = 1000)
    @Column(name = "FORM_TEXT_EN")
    private String formTextEn;
    @Size(max = 1000)
    @Column(name = "FORM_TEXT_AR")
    private String formTextAr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FORM_ADD_UID")
    private String formAddUid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FORM_ADD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date formAddDate;
    @Size(max = 30)
    @Column(name = "FORM_MOD_UID")
    private String formModUid;
    @Column(name = "FORM_MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date formModDate;
    @Size(max = 1)
    @Column(name = "FORM_STATUS")
    private String formStatus;

    public TrjServiceFormat() {
    }

    public TrjServiceFormat(String formCode) {
        this.formCode = formCode;
    }

    public TrjServiceFormat(String formCode, String formReqRes, String formAddUid, Date formAddDate) {
        this.formCode = formCode;
        this.formReqRes = formReqRes;
        this.formAddUid = formAddUid;
        this.formAddDate = formAddDate;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getFormReqRes() {
        return formReqRes;
    }

    public void setFormReqRes(String formReqRes) {
        this.formReqRes = formReqRes;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormDesc() {
        return formDesc;
    }

    public void setFormDesc(String formDesc) {
        this.formDesc = formDesc;
    }

    public String getFormTextEn() {
        return formTextEn;
    }

    public void setFormTextEn(String formTextEn) {
        this.formTextEn = formTextEn;
    }

    public String getFormTextAr() {
        return formTextAr;
    }

    public void setFormTextAr(String formTextAr) {
        this.formTextAr = formTextAr;
    }

    public String getFormAddUid() {
        return formAddUid;
    }

    public void setFormAddUid(String formAddUid) {
        this.formAddUid = formAddUid;
    }

    public Date getFormAddDate() {
        return formAddDate;
    }

    public void setFormAddDate(Date formAddDate) {
        this.formAddDate = formAddDate;
    }

    public String getFormModUid() {
        return formModUid;
    }

    public void setFormModUid(String formModUid) {
        this.formModUid = formModUid;
    }

    public Date getFormModDate() {
        return formModDate;
    }

    public void setFormModDate(Date formModDate) {
        this.formModDate = formModDate;
    }

    public String getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(String formStatus) {
        this.formStatus = formStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formCode != null ? formCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrjServiceFormat)) {
            return false;
        }
        TrjServiceFormat other = (TrjServiceFormat) object;
        if ((this.formCode == null && other.formCode != null) || (this.formCode != null && !this.formCode.equals(other.formCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TrjServiceFormat[ formCode=" + formCode + " ]";
    }
    
}
