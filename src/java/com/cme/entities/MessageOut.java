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
@Table(name = "MESSAGE_OUT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MessageOut.findAll", query = "SELECT m FROM MessageOut m"),
    @NamedQuery(name = "MessageOut.findByMoutId", query = "SELECT m FROM MessageOut m WHERE m.moutId = :moutId"),
    @NamedQuery(name = "MessageOut.findByMoutSmsId", query = "SELECT m FROM MessageOut m WHERE m.moutSmsId = :moutSmsId"),
    @NamedQuery(name = "MessageOut.findByMoutSender", query = "SELECT m FROM MessageOut m WHERE m.moutSender = :moutSender"),
    @NamedQuery(name = "MessageOut.findByMoutReceiver", query = "SELECT m FROM MessageOut m WHERE m.moutReceiver = :moutReceiver"),
    @NamedQuery(name = "MessageOut.findByMoutReceiveDatetime", query = "SELECT m FROM MessageOut m WHERE m.moutReceiveDatetime = :moutReceiveDatetime"),
    @NamedQuery(name = "MessageOut.findByMoutSendDatetime", query = "SELECT m FROM MessageOut m WHERE m.moutSendDatetime = :moutSendDatetime"),
    @NamedQuery(name = "MessageOut.findByMoutMsg", query = "SELECT m FROM MessageOut m WHERE m.moutMsg = :moutMsg"),
    @NamedQuery(name = "MessageOut.findByMoutLanCode", query = "SELECT m FROM MessageOut m WHERE m.moutLanCode = :moutLanCode"),
    @NamedQuery(name = "MessageOut.findByMoutNumbPage", query = "SELECT m FROM MessageOut m WHERE m.moutNumbPage = :moutNumbPage"),
    @NamedQuery(name = "MessageOut.findByMoutStatus", query = "SELECT m FROM MessageOut m WHERE m.moutStatus = :moutStatus"),
    @NamedQuery(name = "MessageOut.findByMoutDelivered", query = "SELECT m FROM MessageOut m WHERE m.moutDelivered = :moutDelivered"),
    @NamedQuery(name = "MessageOut.findByMoutDelivDate", query = "SELECT m FROM MessageOut m WHERE m.moutDelivDate = :moutDelivDate"),
    @NamedQuery(name = "MessageOut.findByMoutNumbRetry", query = "SELECT m FROM MessageOut m WHERE m.moutNumbRetry = :moutNumbRetry"),
    @NamedQuery(name = "MessageOut.findByMoutRetryLast", query = "SELECT m FROM MessageOut m WHERE m.moutRetryLast = :moutRetryLast"),
    @NamedQuery(name = "MessageOut.findByMoutSrvCode", query = "SELECT m FROM MessageOut m WHERE m.moutSrvCode = :moutSrvCode"),
    @NamedQuery(name = "MessageOut.findByMoutSsrvCode", query = "SELECT m FROM MessageOut m WHERE m.moutSsrvCode = :moutSsrvCode"),
    @NamedQuery(name = "MessageOut.findByMoutSrvRef", query = "SELECT m FROM MessageOut m WHERE m.moutSrvRef = :moutSrvRef"),
    @NamedQuery(name = "MessageOut.findByMoutSwkId", query = "SELECT m FROM MessageOut m WHERE m.moutSwkId = :moutSwkId"),
    @NamedQuery(name = "MessageOut.findByMoutMinId", query = "SELECT m FROM MessageOut m WHERE m.moutMinId = :moutMinId"),
    @NamedQuery(name = "MessageOut.findByMoutFlex01", query = "SELECT m FROM MessageOut m WHERE m.moutFlex01 = :moutFlex01"),
    @NamedQuery(name = "MessageOut.findByMoutFlex02", query = "SELECT m FROM MessageOut m WHERE m.moutFlex02 = :moutFlex02"),
    @NamedQuery(name = "MessageOut.findByMoutFlex03", query = "SELECT m FROM MessageOut m WHERE m.moutFlex03 = :moutFlex03"),
    @NamedQuery(name = "MessageOut.findByMoutFlex04", query = "SELECT m FROM MessageOut m WHERE m.moutFlex04 = :moutFlex04"),
    @NamedQuery(name = "MessageOut.findByMoutFlex05", query = "SELECT m FROM MessageOut m WHERE m.moutFlex05 = :moutFlex05"),
    @NamedQuery(name = "MessageOut.findByMoutFlex06", query = "SELECT m FROM MessageOut m WHERE m.moutFlex06 = :moutFlex06"),
    @NamedQuery(name = "MessageOut.findByMoutFlex07", query = "SELECT m FROM MessageOut m WHERE m.moutFlex07 = :moutFlex07"),
    @NamedQuery(name = "MessageOut.findByMoutFlex08", query = "SELECT m FROM MessageOut m WHERE m.moutFlex08 = :moutFlex08"),
    @NamedQuery(name = "MessageOut.findByMoutFlex09", query = "SELECT m FROM MessageOut m WHERE m.moutFlex09 = :moutFlex09"),
    @NamedQuery(name = "MessageOut.findByMoutFlex10", query = "SELECT m FROM MessageOut m WHERE m.moutFlex10 = :moutFlex10"),
    @NamedQuery(name = "MessageOut.findByMoutNoSubmitted", query = "SELECT m FROM MessageOut m WHERE m.moutNoSubmitted = :moutNoSubmitted"),
    @NamedQuery(name = "MessageOut.findByMoutNoDelivrd", query = "SELECT m FROM MessageOut m WHERE m.moutNoDelivrd = :moutNoDelivrd"),
    @NamedQuery(name = "MessageOut.findByMoutSubmittedDate", query = "SELECT m FROM MessageOut m WHERE m.moutSubmittedDate = :moutSubmittedDate"),
    @NamedQuery(name = "MessageOut.findByMoutDoneDate", query = "SELECT m FROM MessageOut m WHERE m.moutDoneDate = :moutDoneDate"),
    @NamedQuery(name = "MessageOut.findByMoutFinalStatus", query = "SELECT m FROM MessageOut m WHERE m.moutFinalStatus = :moutFinalStatus")})
public class MessageOut implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOUT_ID")
    private Long moutId;
    @Size(max = 30)
    @Column(name = "MOUT_SMS_ID")
    private String moutSmsId;
    @Size(max = 20)
    @Column(name = "MOUT_SENDER")
    private String moutSender;
    @Size(max = 20)
    @Column(name = "MOUT_RECEIVER")
    private String moutReceiver;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOUT_RECEIVE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moutReceiveDatetime;
    @Column(name = "MOUT_SEND_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moutSendDatetime;
    @Size(max = 2000)
    @Column(name = "MOUT_MSG")
    private String moutMsg;
    @Size(max = 10)
    @Column(name = "MOUT_LAN_CODE")
    private String moutLanCode;
    @Column(name = "MOUT_NUMB_PAGE")
    private Short moutNumbPage;
    @Size(max = 10)
    @Column(name = "MOUT_STATUS")
    private String moutStatus;
    @Size(max = 10)
    @Column(name = "MOUT_DELIVERED")
    private String moutDelivered;
    @Column(name = "MOUT_DELIV_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moutDelivDate;
    @Column(name = "MOUT_NUMB_RETRY")
    private Short moutNumbRetry;
    @Column(name = "MOUT_RETRY_LAST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moutRetryLast;
    @Size(max = 30)
    @Column(name = "MOUT_SRV_CODE")
    private String moutSrvCode;
    @Size(max = 30)
    @Column(name = "MOUT_SSRV_CODE")
    private String moutSsrvCode;
    @Column(name = "MOUT_SRV_REF")
    private Long moutSrvRef;
    @Column(name = "MOUT_SWK_ID")
    private Long moutSwkId;
    @Column(name = "MOUT_MIN_ID")
    private Long moutMinId;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX01")
    private String moutFlex01;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX02")
    private String moutFlex02;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX03")
    private String moutFlex03;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX04")
    private String moutFlex04;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX05")
    private String moutFlex05;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX06")
    private String moutFlex06;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX07")
    private String moutFlex07;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX08")
    private String moutFlex08;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX09")
    private String moutFlex09;
    @Size(max = 250)
    @Column(name = "MOUT_FLEX10")
    private String moutFlex10;
    @Column(name = "MOUT_NO_SUBMITTED")
    private BigInteger moutNoSubmitted;
    @Column(name = "MOUT_NO_DELIVRD")
    private BigInteger moutNoDelivrd;
    @Column(name = "MOUT_SUBMITTED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moutSubmittedDate;
    @Column(name = "MOUT_DONE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moutDoneDate;
    @Size(max = 20)
    @Column(name = "MOUT_FINAL_STATUS")
    private String moutFinalStatus;

    public MessageOut() {
    }

    public MessageOut(Long moutId) {
        this.moutId = moutId;
    }

    public MessageOut(Long moutId, Date moutReceiveDatetime) {
        this.moutId = moutId;
        this.moutReceiveDatetime = moutReceiveDatetime;
    }

    public Long getMoutId() {
        return moutId;
    }

    public void setMoutId(Long moutId) {
        this.moutId = moutId;
    }

    public String getMoutSmsId() {
        return moutSmsId;
    }

    public void setMoutSmsId(String moutSmsId) {
        this.moutSmsId = moutSmsId;
    }

    public String getMoutSender() {
        return moutSender;
    }

    public void setMoutSender(String moutSender) {
        this.moutSender = moutSender;
    }

    public String getMoutReceiver() {
        return moutReceiver;
    }

    public void setMoutReceiver(String moutReceiver) {
        this.moutReceiver = moutReceiver;
    }

    public Date getMoutReceiveDatetime() {
        return moutReceiveDatetime;
    }

    public void setMoutReceiveDatetime(Date moutReceiveDatetime) {
        this.moutReceiveDatetime = moutReceiveDatetime;
    }

    public Date getMoutSendDatetime() {
        return moutSendDatetime;
    }

    public void setMoutSendDatetime(Date moutSendDatetime) {
        this.moutSendDatetime = moutSendDatetime;
    }

    public String getMoutMsg() {
        return moutMsg;
    }

    public void setMoutMsg(String moutMsg) {
        this.moutMsg = moutMsg;
    }

    public String getMoutLanCode() {
        return moutLanCode;
    }

    public void setMoutLanCode(String moutLanCode) {
        this.moutLanCode = moutLanCode;
    }

    public Short getMoutNumbPage() {
        return moutNumbPage;
    }

    public void setMoutNumbPage(Short moutNumbPage) {
        this.moutNumbPage = moutNumbPage;
    }

    public String getMoutStatus() {
        return moutStatus;
    }

    public void setMoutStatus(String moutStatus) {
        this.moutStatus = moutStatus;
    }

    public String getMoutDelivered() {
        return moutDelivered;
    }

    public void setMoutDelivered(String moutDelivered) {
        this.moutDelivered = moutDelivered;
    }

    public Date getMoutDelivDate() {
        return moutDelivDate;
    }

    public void setMoutDelivDate(Date moutDelivDate) {
        this.moutDelivDate = moutDelivDate;
    }

    public Short getMoutNumbRetry() {
        return moutNumbRetry;
    }

    public void setMoutNumbRetry(Short moutNumbRetry) {
        this.moutNumbRetry = moutNumbRetry;
    }

    public Date getMoutRetryLast() {
        return moutRetryLast;
    }

    public void setMoutRetryLast(Date moutRetryLast) {
        this.moutRetryLast = moutRetryLast;
    }

    public String getMoutSrvCode() {
        return moutSrvCode;
    }

    public void setMoutSrvCode(String moutSrvCode) {
        this.moutSrvCode = moutSrvCode;
    }

    public String getMoutSsrvCode() {
        return moutSsrvCode;
    }

    public void setMoutSsrvCode(String moutSsrvCode) {
        this.moutSsrvCode = moutSsrvCode;
    }

    public Long getMoutSrvRef() {
        return moutSrvRef;
    }

    public void setMoutSrvRef(Long moutSrvRef) {
        this.moutSrvRef = moutSrvRef;
    }

    public Long getMoutSwkId() {
        return moutSwkId;
    }

    public void setMoutSwkId(Long moutSwkId) {
        this.moutSwkId = moutSwkId;
    }

    public Long getMoutMinId() {
        return moutMinId;
    }

    public void setMoutMinId(Long moutMinId) {
        this.moutMinId = moutMinId;
    }

    public String getMoutFlex01() {
        return moutFlex01;
    }

    public void setMoutFlex01(String moutFlex01) {
        this.moutFlex01 = moutFlex01;
    }

    public String getMoutFlex02() {
        return moutFlex02;
    }

    public void setMoutFlex02(String moutFlex02) {
        this.moutFlex02 = moutFlex02;
    }

    public String getMoutFlex03() {
        return moutFlex03;
    }

    public void setMoutFlex03(String moutFlex03) {
        this.moutFlex03 = moutFlex03;
    }

    public String getMoutFlex04() {
        return moutFlex04;
    }

    public void setMoutFlex04(String moutFlex04) {
        this.moutFlex04 = moutFlex04;
    }

    public String getMoutFlex05() {
        return moutFlex05;
    }

    public void setMoutFlex05(String moutFlex05) {
        this.moutFlex05 = moutFlex05;
    }

    public String getMoutFlex06() {
        return moutFlex06;
    }

    public void setMoutFlex06(String moutFlex06) {
        this.moutFlex06 = moutFlex06;
    }

    public String getMoutFlex07() {
        return moutFlex07;
    }

    public void setMoutFlex07(String moutFlex07) {
        this.moutFlex07 = moutFlex07;
    }

    public String getMoutFlex08() {
        return moutFlex08;
    }

    public void setMoutFlex08(String moutFlex08) {
        this.moutFlex08 = moutFlex08;
    }

    public String getMoutFlex09() {
        return moutFlex09;
    }

    public void setMoutFlex09(String moutFlex09) {
        this.moutFlex09 = moutFlex09;
    }

    public String getMoutFlex10() {
        return moutFlex10;
    }

    public void setMoutFlex10(String moutFlex10) {
        this.moutFlex10 = moutFlex10;
    }

    public BigInteger getMoutNoSubmitted() {
        return moutNoSubmitted;
    }

    public void setMoutNoSubmitted(BigInteger moutNoSubmitted) {
        this.moutNoSubmitted = moutNoSubmitted;
    }

    public BigInteger getMoutNoDelivrd() {
        return moutNoDelivrd;
    }

    public void setMoutNoDelivrd(BigInteger moutNoDelivrd) {
        this.moutNoDelivrd = moutNoDelivrd;
    }

    public Date getMoutSubmittedDate() {
        return moutSubmittedDate;
    }

    public void setMoutSubmittedDate(Date moutSubmittedDate) {
        this.moutSubmittedDate = moutSubmittedDate;
    }

    public Date getMoutDoneDate() {
        return moutDoneDate;
    }

    public void setMoutDoneDate(Date moutDoneDate) {
        this.moutDoneDate = moutDoneDate;
    }

    public String getMoutFinalStatus() {
        return moutFinalStatus;
    }

    public void setMoutFinalStatus(String moutFinalStatus) {
        this.moutFinalStatus = moutFinalStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moutId != null ? moutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageOut)) {
            return false;
        }
        MessageOut other = (MessageOut) object;
        if ((this.moutId == null && other.moutId != null) || (this.moutId != null && !this.moutId.equals(other.moutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MessageOut[ moutId=" + moutId + " ]";
    }
    
}
