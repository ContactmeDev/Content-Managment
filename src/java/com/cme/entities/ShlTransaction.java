/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "SHL_TRANSACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShlTransaction.findAll", query = "SELECT s FROM ShlTransaction s"),
    @NamedQuery(name = "ShlTransaction.findByTranId", query = "SELECT s FROM ShlTransaction s WHERE s.tranId = :tranId"),
    @NamedQuery(name = "ShlTransaction.findByTranMembNumber", query = "SELECT s FROM ShlTransaction s WHERE s.tranMembNumber = :tranMembNumber"),
    @NamedQuery(name = "ShlTransaction.findByTranMsgType", query = "SELECT s FROM ShlTransaction s WHERE s.tranMsgType = :tranMsgType"),
    @NamedQuery(name = "ShlTransaction.findByTranMemNumber", query = "SELECT s FROM ShlTransaction s WHERE s.tranMemNumber = :tranMemNumber"),
    @NamedQuery(name = "ShlTransaction.findByTranMemRec", query = "SELECT s FROM ShlTransaction s WHERE s.tranMemRec = :tranMemRec"),
    @NamedQuery(name = "ShlTransaction.findByTranRequestDatetime", query = "SELECT s FROM ShlTransaction s WHERE s.tranRequestDatetime = :tranRequestDatetime"),
    @NamedQuery(name = "ShlTransaction.findByTranResponseDatetime", query = "SELECT s FROM ShlTransaction s WHERE s.tranResponseDatetime = :tranResponseDatetime"),
    @NamedQuery(name = "ShlTransaction.findByTranProcStatus", query = "SELECT s FROM ShlTransaction s WHERE s.tranProcStatus = :tranProcStatus"),
    @NamedQuery(name = "ShlTransaction.findByTranSendComp", query = "SELECT s FROM ShlTransaction s WHERE s.tranSendComp = :tranSendComp"),
    @NamedQuery(name = "ShlTransaction.findByTranText", query = "SELECT s FROM ShlTransaction s WHERE s.tranText = :tranText"),
    @NamedQuery(name = "ShlTransaction.findByTranCnt2sendShlid", query = "SELECT s FROM ShlTransaction s WHERE s.tranCnt2sendShlid = :tranCnt2sendShlid"),
    @NamedQuery(name = "ShlTransaction.findByTranLang", query = "SELECT s FROM ShlTransaction s WHERE s.tranLang = :tranLang"),
    @NamedQuery(name = "ShlTransaction.findByTranMinId", query = "SELECT s FROM ShlTransaction s WHERE s.tranMinId = :tranMinId")})
public class ShlTransaction implements Serializable {
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
    @Column(name = "TRAN_MEMB_NUMBER")
    private String tranMembNumber;
    @Size(max = 10)
    @Column(name = "TRAN_MSG_TYPE")
    private String tranMsgType;
    @Column(name = "TRAN_MEM_NUMBER")
    private Integer tranMemNumber;
    @Column(name = "TRAN_MEM_REC")
    private Integer tranMemRec;
    @Column(name = "TRAN_REQUEST_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tranRequestDatetime;
    @Column(name = "TRAN_RESPONSE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tranResponseDatetime;
    @Size(max = 1)
    @Column(name = "TRAN_PROC_STATUS")
    private String tranProcStatus;
    @Size(max = 1)
    @Column(name = "TRAN_SEND_COMP")
    private String tranSendComp;
    @Size(max = 2000)
    @Column(name = "TRAN_TEXT")
    private String tranText;
    @Column(name = "TRAN_CNT_2SEND_SHLID")
    private BigInteger tranCnt2sendShlid;
    @Size(max = 20)
    @Column(name = "TRAN_LANG")
    private String tranLang;
    @Column(name = "TRAN_MIN_ID")
    private Long tranMinId;
    @JoinColumn(name = "TRAN_SHL_ID", referencedColumnName = "SHL_ID")
    @ManyToOne(optional = false)
    private ShlSholtnaMast tranShlId;
    @JoinColumn(name = "TRAN_SHD_CODE", referencedColumnName = "SHD_CODE")
    @ManyToOne
    private ShlSholtnaDetail tranShdCode;
    @JoinColumn(name = "TRAN_OPERATOR", referencedColumnName = "OPR_CODE")
    @ManyToOne
    private OperatorMast tranOperator;

    public ShlTransaction() {
    }

    public ShlTransaction(BigDecimal tranId) {
        this.tranId = tranId;
    }

    public ShlTransaction(BigDecimal tranId, String tranMembNumber) {
        this.tranId = tranId;
        this.tranMembNumber = tranMembNumber;
    }

    public BigDecimal getTranId() {
        return tranId;
    }

    public void setTranId(BigDecimal tranId) {
        this.tranId = tranId;
    }

    public String getTranMembNumber() {
        return tranMembNumber;
    }

    public void setTranMembNumber(String tranMembNumber) {
        this.tranMembNumber = tranMembNumber;
    }

    public String getTranMsgType() {
        return tranMsgType;
    }

    public void setTranMsgType(String tranMsgType) {
        this.tranMsgType = tranMsgType;
    }

    public Integer getTranMemNumber() {
        return tranMemNumber;
    }

    public void setTranMemNumber(Integer tranMemNumber) {
        this.tranMemNumber = tranMemNumber;
    }

    public Integer getTranMemRec() {
        return tranMemRec;
    }

    public void setTranMemRec(Integer tranMemRec) {
        this.tranMemRec = tranMemRec;
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

    public String getTranProcStatus() {
        return tranProcStatus;
    }

    public void setTranProcStatus(String tranProcStatus) {
        this.tranProcStatus = tranProcStatus;
    }

    public String getTranSendComp() {
        return tranSendComp;
    }

    public void setTranSendComp(String tranSendComp) {
        this.tranSendComp = tranSendComp;
    }

    public String getTranText() {
        return tranText;
    }

    public void setTranText(String tranText) {
        this.tranText = tranText;
    }

    public BigInteger getTranCnt2sendShlid() {
        return tranCnt2sendShlid;
    }

    public void setTranCnt2sendShlid(BigInteger tranCnt2sendShlid) {
        this.tranCnt2sendShlid = tranCnt2sendShlid;
    }

    public String getTranLang() {
        return tranLang;
    }

    public void setTranLang(String tranLang) {
        this.tranLang = tranLang;
    }

    public Long getTranMinId() {
        return tranMinId;
    }

    public void setTranMinId(Long tranMinId) {
        this.tranMinId = tranMinId;
    }

    public ShlSholtnaMast getTranShlId() {
        return tranShlId;
    }

    public void setTranShlId(ShlSholtnaMast tranShlId) {
        this.tranShlId = tranShlId;
    }

    public ShlSholtnaDetail getTranShdCode() {
        return tranShdCode;
    }

    public void setTranShdCode(ShlSholtnaDetail tranShdCode) {
        this.tranShdCode = tranShdCode;
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
        if (!(object instanceof ShlTransaction)) {
            return false;
        }
        ShlTransaction other = (ShlTransaction) object;
        if ((this.tranId == null && other.tranId != null) || (this.tranId != null && !this.tranId.equals(other.tranId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ShlTransaction[ tranId=" + tranId + " ]";
    }
    
}
