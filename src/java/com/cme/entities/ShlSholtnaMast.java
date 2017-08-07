/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "SHL_SHOLTNA_MAST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShlSholtnaMast.findAll", query = "SELECT s FROM ShlSholtnaMast s"),
    @NamedQuery(name = "ShlSholtnaMast.findByShlId", query = "SELECT s FROM ShlSholtnaMast s WHERE s.shlId = :shlId"),
    @NamedQuery(name = "ShlSholtnaMast.findByShlName", query = "SELECT s FROM ShlSholtnaMast s WHERE s.shlName = :shlName"),
    @NamedQuery(name = "ShlSholtnaMast.findByShlOwnerNumber", query = "SELECT s FROM ShlSholtnaMast s WHERE s.shlOwnerNumber = :shlOwnerNumber"),
    @NamedQuery(name = "ShlSholtnaMast.findByShlOwnerNickname", query = "SELECT s FROM ShlSholtnaMast s WHERE s.shlOwnerNickname = :shlOwnerNickname"),
    @NamedQuery(name = "ShlSholtnaMast.findByShlMemberCnt", query = "SELECT s FROM ShlSholtnaMast s WHERE s.shlMemberCnt = :shlMemberCnt"),
    @NamedQuery(name = "ShlSholtnaMast.findByShlStatus", query = "SELECT s FROM ShlSholtnaMast s WHERE s.shlStatus = :shlStatus"),
    @NamedQuery(name = "ShlSholtnaMast.findByShlLastSms", query = "SELECT s FROM ShlSholtnaMast s WHERE s.shlLastSms = :shlLastSms"),
    @NamedQuery(name = "ShlSholtnaMast.findByShlSendCnt", query = "SELECT s FROM ShlSholtnaMast s WHERE s.shlSendCnt = :shlSendCnt"),
    @NamedQuery(name = "ShlSholtnaMast.findByShlCreDate", query = "SELECT s FROM ShlSholtnaMast s WHERE s.shlCreDate = :shlCreDate"),
    @NamedQuery(name = "ShlSholtnaMast.findByShlLastMod", query = "SELECT s FROM ShlSholtnaMast s WHERE s.shlLastMod = :shlLastMod"),
    @NamedQuery(name = "ShlSholtnaMast.findByShlDelDate", query = "SELECT s FROM ShlSholtnaMast s WHERE s.shlDelDate = :shlDelDate")})
public class ShlSholtnaMast implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SHL_ID")
    private String shlId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SHL_NAME")
    private String shlName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SHL_OWNER_NUMBER")
    private String shlOwnerNumber;
    @Size(max = 30)
    @Column(name = "SHL_OWNER_NICKNAME")
    private String shlOwnerNickname;
    @Column(name = "SHL_MEMBER_CNT")
    private BigInteger shlMemberCnt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SHL_STATUS")
    private String shlStatus;
    @Column(name = "SHL_LAST_SMS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shlLastSms;
    @Column(name = "SHL_SEND_CNT")
    private BigInteger shlSendCnt;
    @Column(name = "SHL_CRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shlCreDate;
    @Column(name = "SHL_LAST_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shlLastMod;
    @Column(name = "SHL_DEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shlDelDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tranShlId")
    private Collection<ShlTransaction> shlTransactionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shdShlId")
    private Collection<ShlSholtnaDetail> shlSholtnaDetailCollection;

    public ShlSholtnaMast() {
    }

    public ShlSholtnaMast(String shlId) {
        this.shlId = shlId;
    }

    public ShlSholtnaMast(String shlId, String shlName, String shlOwnerNumber, String shlStatus) {
        this.shlId = shlId;
        this.shlName = shlName;
        this.shlOwnerNumber = shlOwnerNumber;
        this.shlStatus = shlStatus;
    }

    public String getShlId() {
        return shlId;
    }

    public void setShlId(String shlId) {
        this.shlId = shlId;
    }

    public String getShlName() {
        return shlName;
    }

    public void setShlName(String shlName) {
        this.shlName = shlName;
    }

    public String getShlOwnerNumber() {
        return shlOwnerNumber;
    }

    public void setShlOwnerNumber(String shlOwnerNumber) {
        this.shlOwnerNumber = shlOwnerNumber;
    }

    public String getShlOwnerNickname() {
        return shlOwnerNickname;
    }

    public void setShlOwnerNickname(String shlOwnerNickname) {
        this.shlOwnerNickname = shlOwnerNickname;
    }

    public BigInteger getShlMemberCnt() {
        return shlMemberCnt;
    }

    public void setShlMemberCnt(BigInteger shlMemberCnt) {
        this.shlMemberCnt = shlMemberCnt;
    }

    public String getShlStatus() {
        return shlStatus;
    }

    public void setShlStatus(String shlStatus) {
        this.shlStatus = shlStatus;
    }

    public Date getShlLastSms() {
        return shlLastSms;
    }

    public void setShlLastSms(Date shlLastSms) {
        this.shlLastSms = shlLastSms;
    }

    public BigInteger getShlSendCnt() {
        return shlSendCnt;
    }

    public void setShlSendCnt(BigInteger shlSendCnt) {
        this.shlSendCnt = shlSendCnt;
    }

    public Date getShlCreDate() {
        return shlCreDate;
    }

    public void setShlCreDate(Date shlCreDate) {
        this.shlCreDate = shlCreDate;
    }

    public Date getShlLastMod() {
        return shlLastMod;
    }

    public void setShlLastMod(Date shlLastMod) {
        this.shlLastMod = shlLastMod;
    }

    public Date getShlDelDate() {
        return shlDelDate;
    }

    public void setShlDelDate(Date shlDelDate) {
        this.shlDelDate = shlDelDate;
    }

    @XmlTransient
    public Collection<ShlTransaction> getShlTransactionCollection() {
        return shlTransactionCollection;
    }

    public void setShlTransactionCollection(Collection<ShlTransaction> shlTransactionCollection) {
        this.shlTransactionCollection = shlTransactionCollection;
    }

    @XmlTransient
    public Collection<ShlSholtnaDetail> getShlSholtnaDetailCollection() {
        return shlSholtnaDetailCollection;
    }

    public void setShlSholtnaDetailCollection(Collection<ShlSholtnaDetail> shlSholtnaDetailCollection) {
        this.shlSholtnaDetailCollection = shlSholtnaDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shlId != null ? shlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShlSholtnaMast)) {
            return false;
        }
        ShlSholtnaMast other = (ShlSholtnaMast) object;
        if ((this.shlId == null && other.shlId != null) || (this.shlId != null && !this.shlId.equals(other.shlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ShlSholtnaMast[ shlId=" + shlId + " ]";
    }
    
}
