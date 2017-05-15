/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "SHL_COUNTER_MAST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShlCounterMast.findAll", query = "SELECT s FROM ShlCounterMast s"),
    @NamedQuery(name = "ShlCounterMast.findByCntCode", query = "SELECT s FROM ShlCounterMast s WHERE s.cntCode = :cntCode"),
    @NamedQuery(name = "ShlCounterMast.findByCntName", query = "SELECT s FROM ShlCounterMast s WHERE s.cntName = :cntName"),
    @NamedQuery(name = "ShlCounterMast.findByCntFormat", query = "SELECT s FROM ShlCounterMast s WHERE s.cntFormat = :cntFormat"),
    @NamedQuery(name = "ShlCounterMast.findByCntNumb", query = "SELECT s FROM ShlCounterMast s WHERE s.cntNumb = :cntNumb"),
    @NamedQuery(name = "ShlCounterMast.findByCntStatus", query = "SELECT s FROM ShlCounterMast s WHERE s.cntStatus = :cntStatus"),
    @NamedQuery(name = "ShlCounterMast.findByCntAddUid", query = "SELECT s FROM ShlCounterMast s WHERE s.cntAddUid = :cntAddUid"),
    @NamedQuery(name = "ShlCounterMast.findByCntAddDate", query = "SELECT s FROM ShlCounterMast s WHERE s.cntAddDate = :cntAddDate"),
    @NamedQuery(name = "ShlCounterMast.findByCnttModUid", query = "SELECT s FROM ShlCounterMast s WHERE s.cnttModUid = :cnttModUid"),
    @NamedQuery(name = "ShlCounterMast.findByCntModDate", query = "SELECT s FROM ShlCounterMast s WHERE s.cntModDate = :cntModDate")})
public class ShlCounterMast implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CNT_CODE")
    private String cntCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CNT_NAME")
    private String cntName;
    @Size(max = 250)
    @Column(name = "CNT_FORMAT")
    private String cntFormat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CNT_NUMB")
    private BigInteger cntNumb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CNT_STATUS")
    private String cntStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CNT_ADD_UID")
    private String cntAddUid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CNT_ADD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cntAddDate;
    @Size(max = 30)
    @Column(name = "CNTT_MOD_UID")
    private String cnttModUid;
    @Column(name = "CNT_MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cntModDate;

    public ShlCounterMast() {
    }

    public ShlCounterMast(String cntCode) {
        this.cntCode = cntCode;
    }

    public ShlCounterMast(String cntCode, String cntName, BigInteger cntNumb, String cntStatus, String cntAddUid, Date cntAddDate) {
        this.cntCode = cntCode;
        this.cntName = cntName;
        this.cntNumb = cntNumb;
        this.cntStatus = cntStatus;
        this.cntAddUid = cntAddUid;
        this.cntAddDate = cntAddDate;
    }

    public String getCntCode() {
        return cntCode;
    }

    public void setCntCode(String cntCode) {
        this.cntCode = cntCode;
    }

    public String getCntName() {
        return cntName;
    }

    public void setCntName(String cntName) {
        this.cntName = cntName;
    }

    public String getCntFormat() {
        return cntFormat;
    }

    public void setCntFormat(String cntFormat) {
        this.cntFormat = cntFormat;
    }

    public BigInteger getCntNumb() {
        return cntNumb;
    }

    public void setCntNumb(BigInteger cntNumb) {
        this.cntNumb = cntNumb;
    }

    public String getCntStatus() {
        return cntStatus;
    }

    public void setCntStatus(String cntStatus) {
        this.cntStatus = cntStatus;
    }

    public String getCntAddUid() {
        return cntAddUid;
    }

    public void setCntAddUid(String cntAddUid) {
        this.cntAddUid = cntAddUid;
    }

    public Date getCntAddDate() {
        return cntAddDate;
    }

    public void setCntAddDate(Date cntAddDate) {
        this.cntAddDate = cntAddDate;
    }

    public String getCnttModUid() {
        return cnttModUid;
    }

    public void setCnttModUid(String cnttModUid) {
        this.cnttModUid = cnttModUid;
    }

    public Date getCntModDate() {
        return cntModDate;
    }

    public void setCntModDate(Date cntModDate) {
        this.cntModDate = cntModDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cntCode != null ? cntCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShlCounterMast)) {
            return false;
        }
        ShlCounterMast other = (ShlCounterMast) object;
        if ((this.cntCode == null && other.cntCode != null) || (this.cntCode != null && !this.cntCode.equals(other.cntCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ShlCounterMast[ cntCode=" + cntCode + " ]";
    }
    
}
