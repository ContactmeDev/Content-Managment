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
@Table(name = "SHL_TRANS_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShlTransDetail.findAll", query = "SELECT s FROM ShlTransDetail s"),
    @NamedQuery(name = "ShlTransDetail.findByTradId", query = "SELECT s FROM ShlTransDetail s WHERE s.tradId = :tradId"),
    @NamedQuery(name = "ShlTransDetail.findByTradTranId", query = "SELECT s FROM ShlTransDetail s WHERE s.tradTranId = :tradTranId"),
    @NamedQuery(name = "ShlTransDetail.findByTradShlId", query = "SELECT s FROM ShlTransDetail s WHERE s.tradShlId = :tradShlId"),
    @NamedQuery(name = "ShlTransDetail.findByTradShdCode", query = "SELECT s FROM ShlTransDetail s WHERE s.tradShdCode = :tradShdCode"),
    @NamedQuery(name = "ShlTransDetail.findByTradMemNumber", query = "SELECT s FROM ShlTransDetail s WHERE s.tradMemNumber = :tradMemNumber"),
    @NamedQuery(name = "ShlTransDetail.findByTradType", query = "SELECT s FROM ShlTransDetail s WHERE s.tradType = :tradType"),
    @NamedQuery(name = "ShlTransDetail.findByTradStatus", query = "SELECT s FROM ShlTransDetail s WHERE s.tradStatus = :tradStatus"),
    @NamedQuery(name = "ShlTransDetail.findByTradSentDatetime", query = "SELECT s FROM ShlTransDetail s WHERE s.tradSentDatetime = :tradSentDatetime"),
    @NamedQuery(name = "ShlTransDetail.findByTradReqDatetime", query = "SELECT s FROM ShlTransDetail s WHERE s.tradReqDatetime = :tradReqDatetime"),
    @NamedQuery(name = "ShlTransDetail.findByTradMemType", query = "SELECT s FROM ShlTransDetail s WHERE s.tradMemType = :tradMemType"),
    @NamedQuery(name = "ShlTransDetail.findByTradText", query = "SELECT s FROM ShlTransDetail s WHERE s.tradText = :tradText"),
    @NamedQuery(name = "ShlTransDetail.findByTradSrcAddr", query = "SELECT s FROM ShlTransDetail s WHERE s.tradSrcAddr = :tradSrcAddr")})
public class ShlTransDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRAD_ID")
    private BigDecimal tradId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRAD_TRAN_ID")
    private BigInteger tradTranId;
    @Size(max = 10)
    @Column(name = "TRAD_SHL_ID")
    private String tradShlId;
    @Size(max = 20)
    @Column(name = "TRAD_SHD_CODE")
    private String tradShdCode;
    @Size(max = 10)
    @Column(name = "TRAD_MEM_NUMBER")
    private String tradMemNumber;
    @Size(max = 10)
    @Column(name = "TRAD_TYPE")
    private String tradType;
    @Size(max = 1)
    @Column(name = "TRAD_STATUS")
    private String tradStatus;
    @Column(name = "TRAD_SENT_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tradSentDatetime;
    @Column(name = "TRAD_REQ_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tradReqDatetime;
    @Size(max = 10)
    @Column(name = "TRAD_MEM_TYPE")
    private String tradMemType;
    @Size(max = 2000)
    @Column(name = "TRAD_TEXT")
    private String tradText;
    @Size(max = 30)
    @Column(name = "TRAD_SRC_ADDR")
    private String tradSrcAddr;

    public ShlTransDetail() {
    }

    public ShlTransDetail(BigDecimal tradId) {
        this.tradId = tradId;
    }

    public ShlTransDetail(BigDecimal tradId, BigInteger tradTranId) {
        this.tradId = tradId;
        this.tradTranId = tradTranId;
    }

    public BigDecimal getTradId() {
        return tradId;
    }

    public void setTradId(BigDecimal tradId) {
        this.tradId = tradId;
    }

    public BigInteger getTradTranId() {
        return tradTranId;
    }

    public void setTradTranId(BigInteger tradTranId) {
        this.tradTranId = tradTranId;
    }

    public String getTradShlId() {
        return tradShlId;
    }

    public void setTradShlId(String tradShlId) {
        this.tradShlId = tradShlId;
    }

    public String getTradShdCode() {
        return tradShdCode;
    }

    public void setTradShdCode(String tradShdCode) {
        this.tradShdCode = tradShdCode;
    }

    public String getTradMemNumber() {
        return tradMemNumber;
    }

    public void setTradMemNumber(String tradMemNumber) {
        this.tradMemNumber = tradMemNumber;
    }

    public String getTradType() {
        return tradType;
    }

    public void setTradType(String tradType) {
        this.tradType = tradType;
    }

    public String getTradStatus() {
        return tradStatus;
    }

    public void setTradStatus(String tradStatus) {
        this.tradStatus = tradStatus;
    }

    public Date getTradSentDatetime() {
        return tradSentDatetime;
    }

    public void setTradSentDatetime(Date tradSentDatetime) {
        this.tradSentDatetime = tradSentDatetime;
    }

    public Date getTradReqDatetime() {
        return tradReqDatetime;
    }

    public void setTradReqDatetime(Date tradReqDatetime) {
        this.tradReqDatetime = tradReqDatetime;
    }

    public String getTradMemType() {
        return tradMemType;
    }

    public void setTradMemType(String tradMemType) {
        this.tradMemType = tradMemType;
    }

    public String getTradText() {
        return tradText;
    }

    public void setTradText(String tradText) {
        this.tradText = tradText;
    }

    public String getTradSrcAddr() {
        return tradSrcAddr;
    }

    public void setTradSrcAddr(String tradSrcAddr) {
        this.tradSrcAddr = tradSrcAddr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tradId != null ? tradId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShlTransDetail)) {
            return false;
        }
        ShlTransDetail other = (ShlTransDetail) object;
        if ((this.tradId == null && other.tradId != null) || (this.tradId != null && !this.tradId.equals(other.tradId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ShlTransDetail[ tradId=" + tradId + " ]";
    }
    
}
