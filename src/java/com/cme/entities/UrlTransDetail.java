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
@Table(name = "URL_TRANS_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UrlTransDetail.findAll", query = "SELECT u FROM UrlTransDetail u"),
    @NamedQuery(name = "UrlTransDetail.findByUtdCode", query = "SELECT u FROM UrlTransDetail u WHERE u.utdCode = :utdCode"),
    @NamedQuery(name = "UrlTransDetail.findByUtdUtrCode", query = "SELECT u FROM UrlTransDetail u WHERE u.utdUtrCode = :utdUtrCode"),
    @NamedQuery(name = "UrlTransDetail.findByUtdTranType", query = "SELECT u FROM UrlTransDetail u WHERE u.utdTranType = :utdTranType"),
    @NamedQuery(name = "UrlTransDetail.findByUtdSurCode", query = "SELECT u FROM UrlTransDetail u WHERE u.utdSurCode = :utdSurCode"),
    @NamedQuery(name = "UrlTransDetail.findByUtdSender", query = "SELECT u FROM UrlTransDetail u WHERE u.utdSender = :utdSender"),
    @NamedQuery(name = "UrlTransDetail.findByUtdReqId", query = "SELECT u FROM UrlTransDetail u WHERE u.utdReqId = :utdReqId"),
    @NamedQuery(name = "UrlTransDetail.findByUtdReqDatetime", query = "SELECT u FROM UrlTransDetail u WHERE u.utdReqDatetime = :utdReqDatetime"),
    @NamedQuery(name = "UrlTransDetail.findByUtdResDatetime", query = "SELECT u FROM UrlTransDetail u WHERE u.utdResDatetime = :utdResDatetime"),
    @NamedQuery(name = "UrlTransDetail.findByUtdTextTosend", query = "SELECT u FROM UrlTransDetail u WHERE u.utdTextTosend = :utdTextTosend"),
    @NamedQuery(name = "UrlTransDetail.findByUtdSendStatus", query = "SELECT u FROM UrlTransDetail u WHERE u.utdSendStatus = :utdSendStatus"),
    @NamedQuery(name = "UrlTransDetail.findByUtdMinId", query = "SELECT u FROM UrlTransDetail u WHERE u.utdMinId = :utdMinId"),
    @NamedQuery(name = "UrlTransDetail.findByUtdSrvCode", query = "SELECT u FROM UrlTransDetail u WHERE u.utdSrvCode = :utdSrvCode"),
    @NamedQuery(name = "UrlTransDetail.findByUtdSsrvCode", query = "SELECT u FROM UrlTransDetail u WHERE u.utdSsrvCode = :utdSsrvCode")})
public class UrlTransDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UTD_CODE")
    private BigDecimal utdCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UTD_UTR_CODE")
    private BigInteger utdUtrCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "UTD_TRAN_TYPE")
    private String utdTranType;
    @Size(max = 30)
    @Column(name = "UTD_SUR_CODE")
    private String utdSurCode;
    @Size(max = 20)
    @Column(name = "UTD_SENDER")
    private String utdSender;
    @Size(max = 300)
    @Column(name = "UTD_REQ_ID")
    private String utdReqId;
    @Column(name = "UTD_REQ_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date utdReqDatetime;
    @Column(name = "UTD_RES_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date utdResDatetime;
    @Size(max = 1000)
    @Column(name = "UTD_TEXT_TOSEND")
    private String utdTextTosend;
    @Size(max = 1)
    @Column(name = "UTD_SEND_STATUS")
    private String utdSendStatus;
    @Column(name = "UTD_MIN_ID")
    private Long utdMinId;
    @Size(max = 30)
    @Column(name = "UTD_SRV_CODE")
    private String utdSrvCode;
    @Size(max = 30)
    @Column(name = "UTD_SSRV_CODE")
    private String utdSsrvCode;

    public UrlTransDetail() {
    }

    public UrlTransDetail(BigDecimal utdCode) {
        this.utdCode = utdCode;
    }

    public UrlTransDetail(BigDecimal utdCode, BigInteger utdUtrCode, String utdTranType) {
        this.utdCode = utdCode;
        this.utdUtrCode = utdUtrCode;
        this.utdTranType = utdTranType;
    }

    public BigDecimal getUtdCode() {
        return utdCode;
    }

    public void setUtdCode(BigDecimal utdCode) {
        this.utdCode = utdCode;
    }

    public BigInteger getUtdUtrCode() {
        return utdUtrCode;
    }

    public void setUtdUtrCode(BigInteger utdUtrCode) {
        this.utdUtrCode = utdUtrCode;
    }

    public String getUtdTranType() {
        return utdTranType;
    }

    public void setUtdTranType(String utdTranType) {
        this.utdTranType = utdTranType;
    }

    public String getUtdSurCode() {
        return utdSurCode;
    }

    public void setUtdSurCode(String utdSurCode) {
        this.utdSurCode = utdSurCode;
    }

    public String getUtdSender() {
        return utdSender;
    }

    public void setUtdSender(String utdSender) {
        this.utdSender = utdSender;
    }

    public String getUtdReqId() {
        return utdReqId;
    }

    public void setUtdReqId(String utdReqId) {
        this.utdReqId = utdReqId;
    }

    public Date getUtdReqDatetime() {
        return utdReqDatetime;
    }

    public void setUtdReqDatetime(Date utdReqDatetime) {
        this.utdReqDatetime = utdReqDatetime;
    }

    public Date getUtdResDatetime() {
        return utdResDatetime;
    }

    public void setUtdResDatetime(Date utdResDatetime) {
        this.utdResDatetime = utdResDatetime;
    }

    public String getUtdTextTosend() {
        return utdTextTosend;
    }

    public void setUtdTextTosend(String utdTextTosend) {
        this.utdTextTosend = utdTextTosend;
    }

    public String getUtdSendStatus() {
        return utdSendStatus;
    }

    public void setUtdSendStatus(String utdSendStatus) {
        this.utdSendStatus = utdSendStatus;
    }

    public Long getUtdMinId() {
        return utdMinId;
    }

    public void setUtdMinId(Long utdMinId) {
        this.utdMinId = utdMinId;
    }

    public String getUtdSrvCode() {
        return utdSrvCode;
    }

    public void setUtdSrvCode(String utdSrvCode) {
        this.utdSrvCode = utdSrvCode;
    }

    public String getUtdSsrvCode() {
        return utdSsrvCode;
    }

    public void setUtdSsrvCode(String utdSsrvCode) {
        this.utdSsrvCode = utdSsrvCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (utdCode != null ? utdCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UrlTransDetail)) {
            return false;
        }
        UrlTransDetail other = (UrlTransDetail) object;
        if ((this.utdCode == null && other.utdCode != null) || (this.utdCode != null && !this.utdCode.equals(other.utdCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UrlTransDetail[ utdCode=" + utdCode + " ]";
    }
    
}
