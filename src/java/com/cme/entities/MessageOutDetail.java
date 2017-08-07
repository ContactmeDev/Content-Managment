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
@Table(name = "MESSAGE_OUT_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MessageOutDetail.findAll", query = "SELECT m FROM MessageOutDetail m"),
    @NamedQuery(name = "MessageOutDetail.findByDoutId", query = "SELECT m FROM MessageOutDetail m WHERE m.doutId = :doutId"),
    @NamedQuery(name = "MessageOutDetail.findByDoutMoutId", query = "SELECT m FROM MessageOutDetail m WHERE m.doutMoutId = :doutMoutId"),
    @NamedQuery(name = "MessageOutDetail.findByDoutSmsId", query = "SELECT m FROM MessageOutDetail m WHERE m.doutSmsId = :doutSmsId"),
    @NamedQuery(name = "MessageOutDetail.findByDoutSendDatetime", query = "SELECT m FROM MessageOutDetail m WHERE m.doutSendDatetime = :doutSendDatetime"),
    @NamedQuery(name = "MessageOutDetail.findByDoutMsg", query = "SELECT m FROM MessageOutDetail m WHERE m.doutMsg = :doutMsg"),
    @NamedQuery(name = "MessageOutDetail.findByDoutNumbPage", query = "SELECT m FROM MessageOutDetail m WHERE m.doutNumbPage = :doutNumbPage"),
    @NamedQuery(name = "MessageOutDetail.findByDoutStatus", query = "SELECT m FROM MessageOutDetail m WHERE m.doutStatus = :doutStatus"),
    @NamedQuery(name = "MessageOutDetail.findByDoutDelivered", query = "SELECT m FROM MessageOutDetail m WHERE m.doutDelivered = :doutDelivered"),
    @NamedQuery(name = "MessageOutDetail.findByDoutDelivDate", query = "SELECT m FROM MessageOutDetail m WHERE m.doutDelivDate = :doutDelivDate"),
    @NamedQuery(name = "MessageOutDetail.findByDoutNumbRetry", query = "SELECT m FROM MessageOutDetail m WHERE m.doutNumbRetry = :doutNumbRetry"),
    @NamedQuery(name = "MessageOutDetail.findByDoutRetryLast", query = "SELECT m FROM MessageOutDetail m WHERE m.doutRetryLast = :doutRetryLast"),
    @NamedQuery(name = "MessageOutDetail.findByDoutSubmittedDate", query = "SELECT m FROM MessageOutDetail m WHERE m.doutSubmittedDate = :doutSubmittedDate"),
    @NamedQuery(name = "MessageOutDetail.findByDoutDoneDate", query = "SELECT m FROM MessageOutDetail m WHERE m.doutDoneDate = :doutDoneDate"),
    @NamedQuery(name = "MessageOutDetail.findByDoutFinalStatus", query = "SELECT m FROM MessageOutDetail m WHERE m.doutFinalStatus = :doutFinalStatus"),
    @NamedQuery(name = "MessageOutDetail.findByDoutRespDet", query = "SELECT m FROM MessageOutDetail m WHERE m.doutRespDet = :doutRespDet"),
    @NamedQuery(name = "MessageOutDetail.findByDoutTotalPage", query = "SELECT m FROM MessageOutDetail m WHERE m.doutTotalPage = :doutTotalPage")})
public class MessageOutDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOUT_ID")
    private Long doutId;
    @Column(name = "DOUT_MOUT_ID")
    private Long doutMoutId;
    @Size(max = 30)
    @Column(name = "DOUT_SMS_ID")
    private String doutSmsId;
    @Column(name = "DOUT_SEND_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doutSendDatetime;
    @Size(max = 2000)
    @Column(name = "DOUT_MSG")
    private String doutMsg;
    @Column(name = "DOUT_NUMB_PAGE")
    private Short doutNumbPage;
    @Size(max = 10)
    @Column(name = "DOUT_STATUS")
    private String doutStatus;
    @Size(max = 10)
    @Column(name = "DOUT_DELIVERED")
    private String doutDelivered;
    @Column(name = "DOUT_DELIV_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doutDelivDate;
    @Column(name = "DOUT_NUMB_RETRY")
    private Short doutNumbRetry;
    @Column(name = "DOUT_RETRY_LAST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doutRetryLast;
    @Column(name = "DOUT_SUBMITTED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doutSubmittedDate;
    @Column(name = "DOUT_DONE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doutDoneDate;
    @Size(max = 20)
    @Column(name = "DOUT_FINAL_STATUS")
    private String doutFinalStatus;
    @Size(max = 250)
    @Column(name = "DOUT_RESP_DET")
    private String doutRespDet;
    @Column(name = "DOUT_TOTAL_PAGE")
    private Short doutTotalPage;

    public MessageOutDetail() {
    }

    public MessageOutDetail(Long doutId) {
        this.doutId = doutId;
    }

    public Long getDoutId() {
        return doutId;
    }

    public void setDoutId(Long doutId) {
        this.doutId = doutId;
    }

    public Long getDoutMoutId() {
        return doutMoutId;
    }

    public void setDoutMoutId(Long doutMoutId) {
        this.doutMoutId = doutMoutId;
    }

    public String getDoutSmsId() {
        return doutSmsId;
    }

    public void setDoutSmsId(String doutSmsId) {
        this.doutSmsId = doutSmsId;
    }

    public Date getDoutSendDatetime() {
        return doutSendDatetime;
    }

    public void setDoutSendDatetime(Date doutSendDatetime) {
        this.doutSendDatetime = doutSendDatetime;
    }

    public String getDoutMsg() {
        return doutMsg;
    }

    public void setDoutMsg(String doutMsg) {
        this.doutMsg = doutMsg;
    }

    public Short getDoutNumbPage() {
        return doutNumbPage;
    }

    public void setDoutNumbPage(Short doutNumbPage) {
        this.doutNumbPage = doutNumbPage;
    }

    public String getDoutStatus() {
        return doutStatus;
    }

    public void setDoutStatus(String doutStatus) {
        this.doutStatus = doutStatus;
    }

    public String getDoutDelivered() {
        return doutDelivered;
    }

    public void setDoutDelivered(String doutDelivered) {
        this.doutDelivered = doutDelivered;
    }

    public Date getDoutDelivDate() {
        return doutDelivDate;
    }

    public void setDoutDelivDate(Date doutDelivDate) {
        this.doutDelivDate = doutDelivDate;
    }

    public Short getDoutNumbRetry() {
        return doutNumbRetry;
    }

    public void setDoutNumbRetry(Short doutNumbRetry) {
        this.doutNumbRetry = doutNumbRetry;
    }

    public Date getDoutRetryLast() {
        return doutRetryLast;
    }

    public void setDoutRetryLast(Date doutRetryLast) {
        this.doutRetryLast = doutRetryLast;
    }

    public Date getDoutSubmittedDate() {
        return doutSubmittedDate;
    }

    public void setDoutSubmittedDate(Date doutSubmittedDate) {
        this.doutSubmittedDate = doutSubmittedDate;
    }

    public Date getDoutDoneDate() {
        return doutDoneDate;
    }

    public void setDoutDoneDate(Date doutDoneDate) {
        this.doutDoneDate = doutDoneDate;
    }

    public String getDoutFinalStatus() {
        return doutFinalStatus;
    }

    public void setDoutFinalStatus(String doutFinalStatus) {
        this.doutFinalStatus = doutFinalStatus;
    }

    public String getDoutRespDet() {
        return doutRespDet;
    }

    public void setDoutRespDet(String doutRespDet) {
        this.doutRespDet = doutRespDet;
    }

    public Short getDoutTotalPage() {
        return doutTotalPage;
    }

    public void setDoutTotalPage(Short doutTotalPage) {
        this.doutTotalPage = doutTotalPage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doutId != null ? doutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageOutDetail)) {
            return false;
        }
        MessageOutDetail other = (MessageOutDetail) object;
        if ((this.doutId == null && other.doutId != null) || (this.doutId != null && !this.doutId.equals(other.doutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MessageOutDetail[ doutId=" + doutId + " ]";
    }
    
}
