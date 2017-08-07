/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TRJ_TRANSACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrjTransaction.findAll", query = "SELECT t FROM TrjTransaction t"),
    @NamedQuery(name = "TrjTransaction.findByTranId", query = "SELECT t FROM TrjTransaction t WHERE t.tranId = :tranId"),
    @NamedQuery(name = "TrjTransaction.findByTranCustNumber", query = "SELECT t FROM TrjTransaction t WHERE t.tranCustNumber = :tranCustNumber"),
    @NamedQuery(name = "TrjTransaction.findByTranSenderName", query = "SELECT t FROM TrjTransaction t WHERE t.tranSenderName = :tranSenderName"),
    @NamedQuery(name = "TrjTransaction.findByTranMsgType", query = "SELECT t FROM TrjTransaction t WHERE t.tranMsgType = :tranMsgType"),
    @NamedQuery(name = "TrjTransaction.findByTranMsgFormat", query = "SELECT t FROM TrjTransaction t WHERE t.tranMsgFormat = :tranMsgFormat"),
    @NamedQuery(name = "TrjTransaction.findByTranRequestDatetime", query = "SELECT t FROM TrjTransaction t WHERE t.tranRequestDatetime = :tranRequestDatetime"),
    @NamedQuery(name = "TrjTransaction.findByTranResponseDatetime", query = "SELECT t FROM TrjTransaction t WHERE t.tranResponseDatetime = :tranResponseDatetime"),
    @NamedQuery(name = "TrjTransaction.findByTranTranslComp", query = "SELECT t FROM TrjTransaction t WHERE t.tranTranslComp = :tranTranslComp"),
    @NamedQuery(name = "TrjTransaction.findByTranRespSent", query = "SELECT t FROM TrjTransaction t WHERE t.tranRespSent = :tranRespSent"),
    @NamedQuery(name = "TrjTransaction.findByTranFromText", query = "SELECT t FROM TrjTransaction t WHERE t.tranFromText = :tranFromText"),
    @NamedQuery(name = "TrjTransaction.findByTranToText", query = "SELECT t FROM TrjTransaction t WHERE t.tranToText = :tranToText"),
    @NamedQuery(name = "TrjTransaction.findByTranMinId", query = "SELECT t FROM TrjTransaction t WHERE t.tranMinId = :tranMinId")})
public class TrjTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRAN_ID")
    private BigDecimal tranId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TRAN_CUST_NUMBER")
    private String tranCustNumber;
    @Size(max = 30)
    @Column(name = "TRAN_SENDER_NAME")
    private String tranSenderName;
    @Size(max = 10)
    @Column(name = "TRAN_MSG_TYPE")
    private String tranMsgType;
    @Size(max = 10)
    @Column(name = "TRAN_MSG_FORMAT")
    private String tranMsgFormat;
    @Column(name = "TRAN_REQUEST_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tranRequestDatetime;
    @Column(name = "TRAN_RESPONSE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tranResponseDatetime;
    @Size(max = 1)
    @Column(name = "TRAN_TRANSL_COMP")
    private String tranTranslComp;
    @Size(max = 1)
    @Column(name = "TRAN_RESP_SENT")
    private String tranRespSent;
    @Size(max = 2000)
    @Column(name = "TRAN_FROM_TEXT")
    private String tranFromText;
    @Size(max = 2000)
    @Column(name = "TRAN_TO_TEXT")
    private String tranToText;
    @Column(name = "TRAN_MIN_ID")
    private Long tranMinId;
    @JoinColumn(name = "TRAN_FROM_LANG", referencedColumnName = "LAN_ID")
    @ManyToOne
    private TrjLangMast tranFromLang;
    @JoinColumn(name = "TRAN_TO_LANG", referencedColumnName = "LAN_ID")
    @ManyToOne
    private TrjLangMast tranToLang;
    @JoinColumn(name = "TRAN_OPERATOR", referencedColumnName = "OPR_CODE")
    @ManyToOne
    private OperatorMast tranOperator;

    public TrjTransaction() {
    }

    public TrjTransaction(BigDecimal tranId) {
        this.tranId = tranId;
    }

    public TrjTransaction(BigDecimal tranId, String tranCustNumber) {
        this.tranId = tranId;
        this.tranCustNumber = tranCustNumber;
    }

    public BigDecimal getTranId() {
        return tranId;
    }

    public void setTranId(BigDecimal tranId) {
        this.tranId = tranId;
    }

    public String getTranCustNumber() {
        return tranCustNumber;
    }

    public void setTranCustNumber(String tranCustNumber) {
        this.tranCustNumber = tranCustNumber;
    }

    public String getTranSenderName() {
        return tranSenderName;
    }

    public void setTranSenderName(String tranSenderName) {
        this.tranSenderName = tranSenderName;
    }

    public String getTranMsgType() {
        return tranMsgType;
    }

    public void setTranMsgType(String tranMsgType) {
        this.tranMsgType = tranMsgType;
    }

    public String getTranMsgFormat() {
        return tranMsgFormat;
    }

    public void setTranMsgFormat(String tranMsgFormat) {
        this.tranMsgFormat = tranMsgFormat;
    }

    public Date getTranRequestDatetime() {
        return tranRequestDatetime;
    }

    public void setTranRequestDatetime(Date tranRequestDatetime) {
        this.tranRequestDatetime = tranRequestDatetime;
    }

    public Date getTranResponseDatetime() {
        return tranResponseDatetime;
    }

    public void setTranResponseDatetime(Date tranResponseDatetime) {
        this.tranResponseDatetime = tranResponseDatetime;
    }

    public String getTranTranslComp() {
        return tranTranslComp;
    }

    public void setTranTranslComp(String tranTranslComp) {
        this.tranTranslComp = tranTranslComp;
    }

    public String getTranRespSent() {
        return tranRespSent;
    }

    public void setTranRespSent(String tranRespSent) {
        this.tranRespSent = tranRespSent;
    }

    public String getTranFromText() {
        return tranFromText;
    }

    public void setTranFromText(String tranFromText) {
        this.tranFromText = tranFromText;
    }

    public String getTranToText() {
        return tranToText;
    }

    public void setTranToText(String tranToText) {
        this.tranToText = tranToText;
    }

    public Long getTranMinId() {
        return tranMinId;
    }

    public void setTranMinId(Long tranMinId) {
        this.tranMinId = tranMinId;
    }

    public TrjLangMast getTranFromLang() {
        return tranFromLang;
    }

    public void setTranFromLang(TrjLangMast tranFromLang) {
        this.tranFromLang = tranFromLang;
    }

    public TrjLangMast getTranToLang() {
        return tranToLang;
    }

    public void setTranToLang(TrjLangMast tranToLang) {
        this.tranToLang = tranToLang;
    }

    public OperatorMast getTranOperator() {
        return tranOperator;
    }

    public void setTranOperator(OperatorMast tranOperator) {
        this.tranOperator = tranOperator;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tranId != null ? tranId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrjTransaction)) {
            return false;
        }
        TrjTransaction other = (TrjTransaction) object;
        if ((this.tranId == null && other.tranId != null) || (this.tranId != null && !this.tranId.equals(other.tranId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TrjTransaction[ tranId=" + tranId + " ]";
    }
    
}
