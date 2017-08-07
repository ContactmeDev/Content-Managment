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
@Table(name = "MESSAGE_IN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MessageIn.findAll", query = "SELECT m FROM MessageIn m"),
    @NamedQuery(name = "MessageIn.findByMinId", query = "SELECT m FROM MessageIn m WHERE m.minId = :minId"),
    @NamedQuery(name = "MessageIn.findByMinSmsId", query = "SELECT m FROM MessageIn m WHERE m.minSmsId = :minSmsId"),
    @NamedQuery(name = "MessageIn.findByMinSender", query = "SELECT m FROM MessageIn m WHERE m.minSender = :minSender"),
    @NamedQuery(name = "MessageIn.findByMinReceiver", query = "SELECT m FROM MessageIn m WHERE m.minReceiver = :minReceiver"),
    @NamedQuery(name = "MessageIn.findByMinReceiveDatetime", query = "SELECT m FROM MessageIn m WHERE m.minReceiveDatetime = :minReceiveDatetime"),
    @NamedQuery(name = "MessageIn.findByMinSendDatetime", query = "SELECT m FROM MessageIn m WHERE m.minSendDatetime = :minSendDatetime"),
    @NamedQuery(name = "MessageIn.findByMinMsg", query = "SELECT m FROM MessageIn m WHERE m.minMsg = :minMsg"),
    @NamedQuery(name = "MessageIn.findByMinLanCode", query = "SELECT m FROM MessageIn m WHERE m.minLanCode = :minLanCode"),
    @NamedQuery(name = "MessageIn.findByMinNumbPage", query = "SELECT m FROM MessageIn m WHERE m.minNumbPage = :minNumbPage"),
    @NamedQuery(name = "MessageIn.findByMinStatus", query = "SELECT m FROM MessageIn m WHERE m.minStatus = :minStatus"),
    @NamedQuery(name = "MessageIn.findByMinSrvCode", query = "SELECT m FROM MessageIn m WHERE m.minSrvCode = :minSrvCode"),
    @NamedQuery(name = "MessageIn.findByMinSsrvCode", query = "SELECT m FROM MessageIn m WHERE m.minSsrvCode = :minSsrvCode"),
    @NamedQuery(name = "MessageIn.findByMinSrvRef", query = "SELECT m FROM MessageIn m WHERE m.minSrvRef = :minSrvRef"),
    @NamedQuery(name = "MessageIn.findByMinFlex01", query = "SELECT m FROM MessageIn m WHERE m.minFlex01 = :minFlex01"),
    @NamedQuery(name = "MessageIn.findByMinFlex02", query = "SELECT m FROM MessageIn m WHERE m.minFlex02 = :minFlex02"),
    @NamedQuery(name = "MessageIn.findByMinFlex03", query = "SELECT m FROM MessageIn m WHERE m.minFlex03 = :minFlex03"),
    @NamedQuery(name = "MessageIn.findByMinFlex04", query = "SELECT m FROM MessageIn m WHERE m.minFlex04 = :minFlex04"),
    @NamedQuery(name = "MessageIn.findByMinFlex05", query = "SELECT m FROM MessageIn m WHERE m.minFlex05 = :minFlex05"),
    @NamedQuery(name = "MessageIn.findByMinFlex06", query = "SELECT m FROM MessageIn m WHERE m.minFlex06 = :minFlex06"),
    @NamedQuery(name = "MessageIn.findByMinFlex07", query = "SELECT m FROM MessageIn m WHERE m.minFlex07 = :minFlex07"),
    @NamedQuery(name = "MessageIn.findByMinFlex08", query = "SELECT m FROM MessageIn m WHERE m.minFlex08 = :minFlex08"),
    @NamedQuery(name = "MessageIn.findByMinFlex09", query = "SELECT m FROM MessageIn m WHERE m.minFlex09 = :minFlex09"),
    @NamedQuery(name = "MessageIn.findByMinFlex10", query = "SELECT m FROM MessageIn m WHERE m.minFlex10 = :minFlex10")})
public class MessageIn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MIN_ID")
    private Long minId;
    @Size(max = 30)
    @Column(name = "MIN_SMS_ID")
    private String minSmsId;
    @Size(max = 20)
    @Column(name = "MIN_SENDER")
    private String minSender;
    @Size(max = 20)
    @Column(name = "MIN_RECEIVER")
    private String minReceiver;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MIN_RECEIVE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date minReceiveDatetime;
    @Column(name = "MIN_SEND_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date minSendDatetime;
    @Size(max = 2000)
    @Column(name = "MIN_MSG")
    private String minMsg;
    @Size(max = 10)
    @Column(name = "MIN_LAN_CODE")
    private String minLanCode;
    @Column(name = "MIN_NUMB_PAGE")
    private Short minNumbPage;
    @Size(max = 10)
    @Column(name = "MIN_STATUS")
    private String minStatus;
    @Size(max = 30)
    @Column(name = "MIN_SRV_CODE")
    private String minSrvCode;
    @Size(max = 30)
    @Column(name = "MIN_SSRV_CODE")
    private String minSsrvCode;
    @Column(name = "MIN_SRV_REF")
    private Long minSrvRef;
    @Size(max = 250)
    @Column(name = "MIN_FLEX01")
    private String minFlex01;
    @Size(max = 250)
    @Column(name = "MIN_FLEX02")
    private String minFlex02;
    @Size(max = 250)
    @Column(name = "MIN_FLEX03")
    private String minFlex03;
    @Size(max = 250)
    @Column(name = "MIN_FLEX04")
    private String minFlex04;
    @Size(max = 250)
    @Column(name = "MIN_FLEX05")
    private String minFlex05;
    @Size(max = 250)
    @Column(name = "MIN_FLEX06")
    private String minFlex06;
    @Size(max = 250)
    @Column(name = "MIN_FLEX07")
    private String minFlex07;
    @Size(max = 250)
    @Column(name = "MIN_FLEX08")
    private String minFlex08;
    @Size(max = 250)
    @Column(name = "MIN_FLEX09")
    private String minFlex09;
    @Size(max = 250)
    @Column(name = "MIN_FLEX10")
    private String minFlex10;

    public MessageIn() {
    }

    public MessageIn(Long minId) {
        this.minId = minId;
    }

    public MessageIn(Long minId, Date minReceiveDatetime) {
        this.minId = minId;
        this.minReceiveDatetime = minReceiveDatetime;
    }

    public Long getMinId() {
        return minId;
    }

    public void setMinId(Long minId) {
        this.minId = minId;
    }

    public String getMinSmsId() {
        return minSmsId;
    }

    public void setMinSmsId(String minSmsId) {
        this.minSmsId = minSmsId;
    }

    public String getMinSender() {
        return minSender;
    }

    public void setMinSender(String minSender) {
        this.minSender = minSender;
    }

    public String getMinReceiver() {
        return minReceiver;
    }

    public void setMinReceiver(String minReceiver) {
        this.minReceiver = minReceiver;
    }

    public Date getMinReceiveDatetime() {
        return minReceiveDatetime;
    }

    public void setMinReceiveDatetime(Date minReceiveDatetime) {
        this.minReceiveDatetime = minReceiveDatetime;
    }

    public Date getMinSendDatetime() {
        return minSendDatetime;
    }

    public void setMinSendDatetime(Date minSendDatetime) {
        this.minSendDatetime = minSendDatetime;
    }

    public String getMinMsg() {
        return minMsg;
    }

    public void setMinMsg(String minMsg) {
        this.minMsg = minMsg;
    }

    public String getMinLanCode() {
        return minLanCode;
    }

    public void setMinLanCode(String minLanCode) {
        this.minLanCode = minLanCode;
    }

    public Short getMinNumbPage() {
        return minNumbPage;
    }

    public void setMinNumbPage(Short minNumbPage) {
        this.minNumbPage = minNumbPage;
    }

    public String getMinStatus() {
        return minStatus;
    }

    public void setMinStatus(String minStatus) {
        this.minStatus = minStatus;
    }

    public String getMinSrvCode() {
        return minSrvCode;
    }

    public void setMinSrvCode(String minSrvCode) {
        this.minSrvCode = minSrvCode;
    }

    public String getMinSsrvCode() {
        return minSsrvCode;
    }

    public void setMinSsrvCode(String minSsrvCode) {
        this.minSsrvCode = minSsrvCode;
    }

    public Long getMinSrvRef() {
        return minSrvRef;
    }

    public void setMinSrvRef(Long minSrvRef) {
        this.minSrvRef = minSrvRef;
    }

    public String getMinFlex01() {
        return minFlex01;
    }

    public void setMinFlex01(String minFlex01) {
        this.minFlex01 = minFlex01;
    }

    public String getMinFlex02() {
        return minFlex02;
    }

    public void setMinFlex02(String minFlex02) {
        this.minFlex02 = minFlex02;
    }

    public String getMinFlex03() {
        return minFlex03;
    }

    public void setMinFlex03(String minFlex03) {
        this.minFlex03 = minFlex03;
    }

    public String getMinFlex04() {
        return minFlex04;
    }

    public void setMinFlex04(String minFlex04) {
        this.minFlex04 = minFlex04;
    }

    public String getMinFlex05() {
        return minFlex05;
    }

    public void setMinFlex05(String minFlex05) {
        this.minFlex05 = minFlex05;
    }

    public String getMinFlex06() {
        return minFlex06;
    }

    public void setMinFlex06(String minFlex06) {
        this.minFlex06 = minFlex06;
    }

    public String getMinFlex07() {
        return minFlex07;
    }

    public void setMinFlex07(String minFlex07) {
        this.minFlex07 = minFlex07;
    }

    public String getMinFlex08() {
        return minFlex08;
    }

    public void setMinFlex08(String minFlex08) {
        this.minFlex08 = minFlex08;
    }

    public String getMinFlex09() {
        return minFlex09;
    }

    public void setMinFlex09(String minFlex09) {
        this.minFlex09 = minFlex09;
    }

    public String getMinFlex10() {
        return minFlex10;
    }

    public void setMinFlex10(String minFlex10) {
        this.minFlex10 = minFlex10;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (minId != null ? minId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageIn)) {
            return false;
        }
        MessageIn other = (MessageIn) object;
        if ((this.minId == null && other.minId != null) || (this.minId != null && !this.minId.equals(other.minId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MessageIn[ minId=" + minId + " ]";
    }
    
}
