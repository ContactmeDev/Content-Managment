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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SUBSCRIBER_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubscriberDetails.findAll", query = "SELECT s FROM SubscriberDetails s"),
    @NamedQuery(name = "SubscriberDetails.findBySubdId", query = "SELECT s FROM SubscriberDetails s WHERE s.subdId = :subdId"),
    @NamedQuery(name = "SubscriberDetails.findBySubdSlNo", query = "SELECT s FROM SubscriberDetails s WHERE s.subdSlNo = :subdSlNo"),
    @NamedQuery(name = "SubscriberDetails.findBySubdSubDate", query = "SELECT s FROM SubscriberDetails s WHERE s.subdSubDate = :subdSubDate"),
    @NamedQuery(name = "SubscriberDetails.findBySubdTotalSend", query = "SELECT s FROM SubscriberDetails s WHERE s.subdTotalSend = :subdTotalSend"),
    @NamedQuery(name = "SubscriberDetails.findBySubdLastWorkshop", query = "SELECT s FROM SubscriberDetails s WHERE s.subdLastWorkshop = :subdLastWorkshop"),
    @NamedQuery(name = "SubscriberDetails.findBySubdStatus", query = "SELECT s FROM SubscriberDetails s WHERE s.subdStatus = :subdStatus"),
    @NamedQuery(name = "SubscriberDetails.findBySubdSubBy", query = "SELECT s FROM SubscriberDetails s WHERE s.subdSubBy = :subdSubBy"),
    @NamedQuery(name = "SubscriberDetails.findBySubdUnsubBy", query = "SELECT s FROM SubscriberDetails s WHERE s.subdUnsubBy = :subdUnsubBy"),
    @NamedQuery(name = "SubscriberDetails.findBySubdUnsubDate", query = "SELECT s FROM SubscriberDetails s WHERE s.subdUnsubDate = :subdUnsubDate")})
public class SubscriberDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBD_ID")
    private Long subdId;
    @Column(name = "SUBD_SL_NO")
    private Integer subdSlNo;
    @Column(name = "SUBD_SUB_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subdSubDate;
    @Column(name = "SUBD_TOTAL_SEND")
    private Long subdTotalSend;
    @Column(name = "SUBD_LAST_WORKSHOP")
    private Long subdLastWorkshop;
    @Size(max = 1)
    @Column(name = "SUBD_STATUS")
    private String subdStatus;
    @Size(max = 20)
    @Column(name = "SUBD_SUB_BY")
    private String subdSubBy;
    @Size(max = 20)
    @Column(name = "SUBD_UNSUB_BY")
    private String subdUnsubBy;
    @Column(name = "SUBD_UNSUB_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subdUnsubDate;
    @JoinColumn(name = "SUBD_SSRV_CODE", referencedColumnName = "SSRV_CODE")
    @ManyToOne
    private SubserviceMast subdSsrvCode;
    @JoinColumn(name = "SUBD_SUB_ID", referencedColumnName = "SUB_ID")
    @ManyToOne
    private SubscriberMast subdSubId;
    @JoinColumn(name = "SUBD_SRV_CODE", referencedColumnName = "SRV_CODE")
    @ManyToOne(optional = false)
    private ServiceMast subdSrvCode;

    public SubscriberDetails() {
    }

    public SubscriberDetails(Long subdId) {
        this.subdId = subdId;
    }

    public Long getSubdId() {
        return subdId;
    }

    public void setSubdId(Long subdId) {
        this.subdId = subdId;
    }

    public Integer getSubdSlNo() {
        return subdSlNo;
    }

    public void setSubdSlNo(Integer subdSlNo) {
        this.subdSlNo = subdSlNo;
    }

    public Date getSubdSubDate() {
        return subdSubDate;
    }

    public void setSubdSubDate(Date subdSubDate) {
        this.subdSubDate = subdSubDate;
    }

    public Long getSubdTotalSend() {
        return subdTotalSend;
    }

    public void setSubdTotalSend(Long subdTotalSend) {
        this.subdTotalSend = subdTotalSend;
    }

    public Long getSubdLastWorkshop() {
        return subdLastWorkshop;
    }

    public void setSubdLastWorkshop(Long subdLastWorkshop) {
        this.subdLastWorkshop = subdLastWorkshop;
    }

    public String getSubdStatus() {
        return subdStatus;
    }

    public void setSubdStatus(String subdStatus) {
        this.subdStatus = subdStatus;
    }

    public String getSubdSubBy() {
        return subdSubBy;
    }

    public void setSubdSubBy(String subdSubBy) {
        this.subdSubBy = subdSubBy;
    }

    public String getSubdUnsubBy() {
        return subdUnsubBy;
    }

    public void setSubdUnsubBy(String subdUnsubBy) {
        this.subdUnsubBy = subdUnsubBy;
    }

    public Date getSubdUnsubDate() {
        return subdUnsubDate;
    }

    public void setSubdUnsubDate(Date subdUnsubDate) {
        this.subdUnsubDate = subdUnsubDate;
    }

    public SubserviceMast getSubdSsrvCode() {
        return subdSsrvCode;
    }

    public void setSubdSsrvCode(SubserviceMast subdSsrvCode) {
        this.subdSsrvCode = subdSsrvCode;
    }

    public SubscriberMast getSubdSubId() {
        return subdSubId;
    }

    public void setSubdSubId(SubscriberMast subdSubId) {
        this.subdSubId = subdSubId;
    }

    public ServiceMast getSubdSrvCode() {
        return subdSrvCode;
    }

    public void setSubdSrvCode(ServiceMast subdSrvCode) {
        this.subdSrvCode = subdSrvCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subdId != null ? subdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubscriberDetails)) {
            return false;
        }
        SubscriberDetails other = (SubscriberDetails) object;
        if ((this.subdId == null && other.subdId != null) || (this.subdId != null && !this.subdId.equals(other.subdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SubscriberDetails[ subdId=" + subdId + " ]";
    }
    
}
