/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mustafaahmed
 */
@Entity
@Table(name = "SHL_SHOLTNA_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShlSholtnaDetail.findAll", query = "SELECT s FROM ShlSholtnaDetail s"),
    @NamedQuery(name = "ShlSholtnaDetail.findByShdCode", query = "SELECT s FROM ShlSholtnaDetail s WHERE s.shdCode = :shdCode"),
    @NamedQuery(name = "ShlSholtnaDetail.findByShdSlNo", query = "SELECT s FROM ShlSholtnaDetail s WHERE s.shdSlNo = :shdSlNo"),
    @NamedQuery(name = "ShlSholtnaDetail.findByShdMemType", query = "SELECT s FROM ShlSholtnaDetail s WHERE s.shdMemType = :shdMemType"),
    @NamedQuery(name = "ShlSholtnaDetail.findByShdMemNumber", query = "SELECT s FROM ShlSholtnaDetail s WHERE s.shdMemNumber = :shdMemNumber"),
    @NamedQuery(name = "ShlSholtnaDetail.findByShdMemNickname", query = "SELECT s FROM ShlSholtnaDetail s WHERE s.shdMemNickname = :shdMemNickname"),
    @NamedQuery(name = "ShlSholtnaDetail.findByShdMemAddDate", query = "SELECT s FROM ShlSholtnaDetail s WHERE s.shdMemAddDate = :shdMemAddDate"),
    @NamedQuery(name = "ShlSholtnaDetail.findByShdMemStatus", query = "SELECT s FROM ShlSholtnaDetail s WHERE s.shdMemStatus = :shdMemStatus"),
    @NamedQuery(name = "ShlSholtnaDetail.findByShdConfirmDate", query = "SELECT s FROM ShlSholtnaDetail s WHERE s.shdConfirmDate = :shdConfirmDate"),
    @NamedQuery(name = "ShlSholtnaDetail.findByShdChangeDate", query = "SELECT s FROM ShlSholtnaDetail s WHERE s.shdChangeDate = :shdChangeDate"),
    @NamedQuery(name = "ShlSholtnaDetail.findByShdSendSms", query = "SELECT s FROM ShlSholtnaDetail s WHERE s.shdSendSms = :shdSendSms"),
    @NamedQuery(name = "ShlSholtnaDetail.findByShdRecSms", query = "SELECT s FROM ShlSholtnaDetail s WHERE s.shdRecSms = :shdRecSms"),
    @NamedQuery(name = "ShlSholtnaDetail.findByShdLastSendSms", query = "SELECT s FROM ShlSholtnaDetail s WHERE s.shdLastSendSms = :shdLastSendSms")})
public class ShlSholtnaDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SHD_CODE")
    private BigDecimal shdCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SHD_SL_NO")
    private int shdSlNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SHD_MEM_TYPE")
    private String shdMemType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SHD_MEM_NUMBER")
    private String shdMemNumber;
    @Size(max = 20)
    @Column(name = "SHD_MEM_NICKNAME")
    private String shdMemNickname;
    @Column(name = "SHD_MEM_ADD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shdMemAddDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SHD_MEM_STATUS")
    private String shdMemStatus;
    @Column(name = "SHD_CONFIRM_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shdConfirmDate;
    @Column(name = "SHD_CHANGE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shdChangeDate;
    @Column(name = "SHD_SEND_SMS")
    private BigInteger shdSendSms;
    @Column(name = "SHD_REC_SMS")
    private BigInteger shdRecSms;
    @Column(name = "SHD_LAST_SEND_SMS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shdLastSendSms;
    @OneToMany(mappedBy = "tranShdCode")
    private Collection<ShlTransaction> shlTransactionCollection;
    @JoinColumn(name = "SHD_SHL_ID", referencedColumnName = "SHL_ID")
    @ManyToOne(optional = false)
    private ShlSholtnaMast shdShlId;

    public ShlSholtnaDetail() {
    }

    public ShlSholtnaDetail(BigDecimal shdCode) {
        this.shdCode = shdCode;
    }

    public ShlSholtnaDetail(BigDecimal shdCode, int shdSlNo, String shdMemType, String shdMemNumber, String shdMemStatus) {
        this.shdCode = shdCode;
        this.shdSlNo = shdSlNo;
        this.shdMemType = shdMemType;
        this.shdMemNumber = shdMemNumber;
        this.shdMemStatus = shdMemStatus;
    }

    public BigDecimal getShdCode() {
        return shdCode;
    }

    public void setShdCode(BigDecimal shdCode) {
        this.shdCode = shdCode;
    }

    public int getShdSlNo() {
        return shdSlNo;
    }

    public void setShdSlNo(int shdSlNo) {
        this.shdSlNo = shdSlNo;
    }

    public String getShdMemType() {
        return shdMemType;
    }

    public void setShdMemType(String shdMemType) {
        this.shdMemType = shdMemType;
    }

    public String getShdMemNumber() {
        return shdMemNumber;
    }

    public void setShdMemNumber(String shdMemNumber) {
        this.shdMemNumber = shdMemNumber;
    }

    public String getShdMemNickname() {
        return shdMemNickname;
    }

    public void setShdMemNickname(String shdMemNickname) {
        this.shdMemNickname = shdMemNickname;
    }

    public Date getShdMemAddDate() {
        return shdMemAddDate;
    }

    public void setShdMemAddDate(Date shdMemAddDate) {
        this.shdMemAddDate = shdMemAddDate;
    }

    public String getShdMemStatus() {
        return shdMemStatus;
    }

    public void setShdMemStatus(String shdMemStatus) {
        this.shdMemStatus = shdMemStatus;
    }

    public Date getShdConfirmDate() {
        return shdConfirmDate;
    }

    public void setShdConfirmDate(Date shdConfirmDate) {
        this.shdConfirmDate = shdConfirmDate;
    }

    public Date getShdChangeDate() {
        return shdChangeDate;
    }

    public void setShdChangeDate(Date shdChangeDate) {
        this.shdChangeDate = shdChangeDate;
    }

    public BigInteger getShdSendSms() {
        return shdSendSms;
    }

    public void setShdSendSms(BigInteger shdSendSms) {
        this.shdSendSms = shdSendSms;
    }

    public BigInteger getShdRecSms() {
        return shdRecSms;
    }

    public void setShdRecSms(BigInteger shdRecSms) {
        this.shdRecSms = shdRecSms;
    }

    public Date getShdLastSendSms() {
        return shdLastSendSms;
    }

    public void setShdLastSendSms(Date shdLastSendSms) {
        this.shdLastSendSms = shdLastSendSms;
    }

    @XmlTransient
    public Collection<ShlTransaction> getShlTransactionCollection() {
        return shlTransactionCollection;
    }

    public void setShlTransactionCollection(Collection<ShlTransaction> shlTransactionCollection) {
        this.shlTransactionCollection = shlTransactionCollection;
    }

    public ShlSholtnaMast getShdShlId() {
        return shdShlId;
    }

    public void setShdShlId(ShlSholtnaMast shdShlId) {
        this.shdShlId = shdShlId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shdCode != null ? shdCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShlSholtnaDetail)) {
            return false;
        }
        ShlSholtnaDetail other = (ShlSholtnaDetail) object;
        if ((this.shdCode == null && other.shdCode != null) || (this.shdCode != null && !this.shdCode.equals(other.shdCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ShlSholtnaDetail[ shdCode=" + shdCode + " ]";
    }
    
}
