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
@Table(name = "URL_TRANSACTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UrlTransactions.findAll", query = "SELECT u FROM UrlTransactions u"),
    @NamedQuery(name = "UrlTransactions.findByUtrCode", query = "SELECT u FROM UrlTransactions u WHERE u.utrCode = :utrCode"),
    @NamedQuery(name = "UrlTransactions.findByUtrReqDatetime", query = "SELECT u FROM UrlTransactions u WHERE u.utrReqDatetime = :utrReqDatetime"),
    @NamedQuery(name = "UrlTransactions.findByUtrSrvCode", query = "SELECT u FROM UrlTransactions u WHERE u.utrSrvCode = :utrSrvCode"),
    @NamedQuery(name = "UrlTransactions.findByUtrSsrvCode", query = "SELECT u FROM UrlTransactions u WHERE u.utrSsrvCode = :utrSsrvCode"),
    @NamedQuery(name = "UrlTransactions.findByUtrReqId", query = "SELECT u FROM UrlTransactions u WHERE u.utrReqId = :utrReqId"),
    @NamedQuery(name = "UrlTransactions.findByUtrSender", query = "SELECT u FROM UrlTransactions u WHERE u.utrSender = :utrSender"),
    @NamedQuery(name = "UrlTransactions.findByUtrOsId", query = "SELECT u FROM UrlTransactions u WHERE u.utrOsId = :utrOsId"),
    @NamedQuery(name = "UrlTransactions.findByUtrSourceIp", query = "SELECT u FROM UrlTransactions u WHERE u.utrSourceIp = :utrSourceIp"),
    @NamedQuery(name = "UrlTransactions.findByUtrSenderOperator", query = "SELECT u FROM UrlTransactions u WHERE u.utrSenderOperator = :utrSenderOperator"),
    @NamedQuery(name = "UrlTransactions.findByUtrValidtodownload", query = "SELECT u FROM UrlTransactions u WHERE u.utrValidtodownload = :utrValidtodownload"),
    @NamedQuery(name = "UrlTransactions.findByUtrSessionId", query = "SELECT u FROM UrlTransactions u WHERE u.utrSessionId = :utrSessionId"),
    @NamedQuery(name = "UrlTransactions.findByUtrStatus", query = "SELECT u FROM UrlTransactions u WHERE u.utrStatus = :utrStatus"),
    @NamedQuery(name = "UrlTransactions.findByUtrMinId", query = "SELECT u FROM UrlTransactions u WHERE u.utrMinId = :utrMinId"),
    @NamedQuery(name = "UrlTransactions.findByUtrLink", query = "SELECT u FROM UrlTransactions u WHERE u.utrLink = :utrLink"),
    @NamedQuery(name = "UrlTransactions.findByUserAgent", query = "SELECT u FROM UrlTransactions u WHERE u.userAgent = :userAgent")})
public class UrlTransactions implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UTR_CODE")
    private BigDecimal utrCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UTR_REQ_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date utrReqDatetime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "UTR_SRV_CODE")
    private String utrSrvCode;
    @Size(max = 30)
    @Column(name = "UTR_SSRV_CODE")
    private String utrSsrvCode;
    @Size(max = 300)
    @Column(name = "UTR_REQ_ID")
    private String utrReqId;
    @Size(max = 20)
    @Column(name = "UTR_SENDER")
    private String utrSender;
    @Size(max = 20)
    @Column(name = "UTR_OS_ID")
    private String utrOsId;
    @Size(max = 20)
    @Column(name = "UTR_SOURCE_IP")
    private String utrSourceIp;
    @Size(max = 30)
    @Column(name = "UTR_SENDER_OPERATOR")
    private String utrSenderOperator;
    @Size(max = 1)
    @Column(name = "UTR_VALIDTODOWNLOAD")
    private String utrValidtodownload;
    @Size(max = 50)
    @Column(name = "UTR_SESSION_ID")
    private String utrSessionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "UTR_STATUS")
    private String utrStatus;
    @Column(name = "UTR_MIN_ID")
    private Long utrMinId;
    @Size(max = 300)
    @Column(name = "UTR_LINK")
    private String utrLink;
    @Size(max = 500)
    @Column(name = "USER_AGENT")
    private String userAgent;

    public UrlTransactions() {
    }

    public UrlTransactions(BigDecimal utrCode) {
        this.utrCode = utrCode;
    }

    public UrlTransactions(BigDecimal utrCode, Date utrReqDatetime, String utrSrvCode, String utrStatus) {
        this.utrCode = utrCode;
        this.utrReqDatetime = utrReqDatetime;
        this.utrSrvCode = utrSrvCode;
        this.utrStatus = utrStatus;
    }

    public BigDecimal getUtrCode() {
        return utrCode;
    }

    public void setUtrCode(BigDecimal utrCode) {
        this.utrCode = utrCode;
    }

    public Date getUtrReqDatetime() {
        return utrReqDatetime;
    }

    public void setUtrReqDatetime(Date utrReqDatetime) {
        this.utrReqDatetime = utrReqDatetime;
    }

    public String getUtrSrvCode() {
        return utrSrvCode;
    }

    public void setUtrSrvCode(String utrSrvCode) {
        this.utrSrvCode = utrSrvCode;
    }

    public String getUtrSsrvCode() {
        return utrSsrvCode;
    }

    public void setUtrSsrvCode(String utrSsrvCode) {
        this.utrSsrvCode = utrSsrvCode;
    }

    public String getUtrReqId() {
        return utrReqId;
    }

    public void setUtrReqId(String utrReqId) {
        this.utrReqId = utrReqId;
    }

    public String getUtrSender() {
        return utrSender;
    }

    public void setUtrSender(String utrSender) {
        this.utrSender = utrSender;
    }

    public String getUtrOsId() {
        return utrOsId;
    }

    public void setUtrOsId(String utrOsId) {
        this.utrOsId = utrOsId;
    }

    public String getUtrSourceIp() {
        return utrSourceIp;
    }

    public void setUtrSourceIp(String utrSourceIp) {
        this.utrSourceIp = utrSourceIp;
    }

    public String getUtrSenderOperator() {
        return utrSenderOperator;
    }

    public void setUtrSenderOperator(String utrSenderOperator) {
        this.utrSenderOperator = utrSenderOperator;
    }

    public String getUtrValidtodownload() {
        return utrValidtodownload;
    }

    public void setUtrValidtodownload(String utrValidtodownload) {
        this.utrValidtodownload = utrValidtodownload;
    }

    public String getUtrSessionId() {
        return utrSessionId;
    }

    public void setUtrSessionId(String utrSessionId) {
        this.utrSessionId = utrSessionId;
    }

    public String getUtrStatus() {
        return utrStatus;
    }

    public void setUtrStatus(String utrStatus) {
        this.utrStatus = utrStatus;
    }

    public Long getUtrMinId() {
        return utrMinId;
    }

    public void setUtrMinId(Long utrMinId) {
        this.utrMinId = utrMinId;
    }

    public String getUtrLink() {
        return utrLink;
    }

    public void setUtrLink(String utrLink) {
        this.utrLink = utrLink;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (utrCode != null ? utrCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UrlTransactions)) {
            return false;
        }
        UrlTransactions other = (UrlTransactions) object;
        if ((this.utrCode == null && other.utrCode != null) || (this.utrCode != null && !this.utrCode.equals(other.utrCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UrlTransactions[ utrCode=" + utrCode + " ]";
    }
    
}
