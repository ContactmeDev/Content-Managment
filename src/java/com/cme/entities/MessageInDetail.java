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
@Table(name = "MESSAGE_IN_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MessageInDetail.findAll", query = "SELECT m FROM MessageInDetail m"),
    @NamedQuery(name = "MessageInDetail.findByDinId", query = "SELECT m FROM MessageInDetail m WHERE m.dinId = :dinId"),
    @NamedQuery(name = "MessageInDetail.findByDinSmsId", query = "SELECT m FROM MessageInDetail m WHERE m.dinSmsId = :dinSmsId"),
    @NamedQuery(name = "MessageInDetail.findByDinUdhLengh", query = "SELECT m FROM MessageInDetail m WHERE m.dinUdhLengh = :dinUdhLengh"),
    @NamedQuery(name = "MessageInDetail.findByDinInfElemId", query = "SELECT m FROM MessageInDetail m WHERE m.dinInfElemId = :dinInfElemId"),
    @NamedQuery(name = "MessageInDetail.findByDinInfElemLen", query = "SELECT m FROM MessageInDetail m WHERE m.dinInfElemLen = :dinInfElemLen"),
    @NamedQuery(name = "MessageInDetail.findByDinSarMaxNumb", query = "SELECT m FROM MessageInDetail m WHERE m.dinSarMaxNumb = :dinSarMaxNumb"),
    @NamedQuery(name = "MessageInDetail.findByDinSarSeqNumb", query = "SELECT m FROM MessageInDetail m WHERE m.dinSarSeqNumb = :dinSarSeqNumb"),
    @NamedQuery(name = "MessageInDetail.findByDinSender", query = "SELECT m FROM MessageInDetail m WHERE m.dinSender = :dinSender"),
    @NamedQuery(name = "MessageInDetail.findByDinReceiver", query = "SELECT m FROM MessageInDetail m WHERE m.dinReceiver = :dinReceiver"),
    @NamedQuery(name = "MessageInDetail.findByDinReceiveDatetime", query = "SELECT m FROM MessageInDetail m WHERE m.dinReceiveDatetime = :dinReceiveDatetime"),
    @NamedQuery(name = "MessageInDetail.findByDinMsg", query = "SELECT m FROM MessageInDetail m WHERE m.dinMsg = :dinMsg"),
    @NamedQuery(name = "MessageInDetail.findByDinLanCode", query = "SELECT m FROM MessageInDetail m WHERE m.dinLanCode = :dinLanCode"),
    @NamedQuery(name = "MessageInDetail.findByDinStatus", query = "SELECT m FROM MessageInDetail m WHERE m.dinStatus = :dinStatus"),
    @NamedQuery(name = "MessageInDetail.findByDinSrvCode", query = "SELECT m FROM MessageInDetail m WHERE m.dinSrvCode = :dinSrvCode"),
    @NamedQuery(name = "MessageInDetail.findByDinSsrvCode", query = "SELECT m FROM MessageInDetail m WHERE m.dinSsrvCode = :dinSsrvCode")})
public class MessageInDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIN_ID")
    private BigDecimal dinId;
    @Size(max = 30)
    @Column(name = "DIN_SMS_ID")
    private String dinSmsId;
    @Column(name = "DIN_UDH_LENGH")
    private Long dinUdhLengh;
    @Column(name = "DIN_INF_ELEM_ID")
    private Integer dinInfElemId;
    @Column(name = "DIN_INF_ELEM_LEN")
    private Integer dinInfElemLen;
    @Column(name = "DIN_SAR_MAX_NUMB")
    private Short dinSarMaxNumb;
    @Column(name = "DIN_SAR_SEQ_NUMB")
    private Short dinSarSeqNumb;
    @Size(max = 20)
    @Column(name = "DIN_SENDER")
    private String dinSender;
    @Size(max = 20)
    @Column(name = "DIN_RECEIVER")
    private String dinReceiver;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIN_RECEIVE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dinReceiveDatetime;
    @Size(max = 2000)
    @Column(name = "DIN_MSG")
    private String dinMsg;
    @Size(max = 10)
    @Column(name = "DIN_LAN_CODE")
    private String dinLanCode;
    @Size(max = 10)
    @Column(name = "DIN_STATUS")
    private String dinStatus;
    @Size(max = 30)
    @Column(name = "DIN_SRV_CODE")
    private String dinSrvCode;
    @Size(max = 30)
    @Column(name = "DIN_SSRV_CODE")
    private String dinSsrvCode;

    public MessageInDetail() {
    }

    public MessageInDetail(BigDecimal dinId) {
        this.dinId = dinId;
    }

    public MessageInDetail(BigDecimal dinId, Date dinReceiveDatetime) {
        this.dinId = dinId;
        this.dinReceiveDatetime = dinReceiveDatetime;
    }

    public BigDecimal getDinId() {
        return dinId;
    }

    public void setDinId(BigDecimal dinId) {
        this.dinId = dinId;
    }

    public String getDinSmsId() {
        return dinSmsId;
    }

    public void setDinSmsId(String dinSmsId) {
        this.dinSmsId = dinSmsId;
    }

    public Long getDinUdhLengh() {
        return dinUdhLengh;
    }

    public void setDinUdhLengh(Long dinUdhLengh) {
        this.dinUdhLengh = dinUdhLengh;
    }

    public Integer getDinInfElemId() {
        return dinInfElemId;
    }

    public void setDinInfElemId(Integer dinInfElemId) {
        this.dinInfElemId = dinInfElemId;
    }

    public Integer getDinInfElemLen() {
        return dinInfElemLen;
    }

    public void setDinInfElemLen(Integer dinInfElemLen) {
        this.dinInfElemLen = dinInfElemLen;
    }

    public Short getDinSarMaxNumb() {
        return dinSarMaxNumb;
    }

    public void setDinSarMaxNumb(Short dinSarMaxNumb) {
        this.dinSarMaxNumb = dinSarMaxNumb;
    }

    public Short getDinSarSeqNumb() {
        return dinSarSeqNumb;
    }

    public void setDinSarSeqNumb(Short dinSarSeqNumb) {
        this.dinSarSeqNumb = dinSarSeqNumb;
    }

    public String getDinSender() {
        return dinSender;
    }

    public void setDinSender(String dinSender) {
        this.dinSender = dinSender;
    }

    public String getDinReceiver() {
        return dinReceiver;
    }

    public void setDinReceiver(String dinReceiver) {
        this.dinReceiver = dinReceiver;
    }

    public Date getDinReceiveDatetime() {
        return dinReceiveDatetime;
    }

    public void setDinReceiveDatetime(Date dinReceiveDatetime) {
        this.dinReceiveDatetime = dinReceiveDatetime;
    }

    public String getDinMsg() {
        return dinMsg;
    }

    public void setDinMsg(String dinMsg) {
        this.dinMsg = dinMsg;
    }

    public String getDinLanCode() {
        return dinLanCode;
    }

    public void setDinLanCode(String dinLanCode) {
        this.dinLanCode = dinLanCode;
    }

    public String getDinStatus() {
        return dinStatus;
    }

    public void setDinStatus(String dinStatus) {
        this.dinStatus = dinStatus;
    }

    public String getDinSrvCode() {
        return dinSrvCode;
    }

    public void setDinSrvCode(String dinSrvCode) {
        this.dinSrvCode = dinSrvCode;
    }

    public String getDinSsrvCode() {
        return dinSsrvCode;
    }

    public void setDinSsrvCode(String dinSsrvCode) {
        this.dinSsrvCode = dinSsrvCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dinId != null ? dinId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageInDetail)) {
            return false;
        }
        MessageInDetail other = (MessageInDetail) object;
        if ((this.dinId == null && other.dinId != null) || (this.dinId != null && !this.dinId.equals(other.dinId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MessageInDetail[ dinId=" + dinId + " ]";
    }
    
}
