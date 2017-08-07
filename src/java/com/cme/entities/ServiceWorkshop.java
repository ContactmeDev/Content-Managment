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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
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
@Table(name = "SERVICE_WORKSHOP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceWorkshop.findAll", query = "SELECT s FROM ServiceWorkshop s"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkId", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkId = :swkId"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkLanCode", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkLanCode = :swkLanCode"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkMsg", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkMsg = :swkMsg AND s.swkSrvCode = :swkSrvCode AND s.swkSsrvCode = :swkSsrvCode"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkNumbPage", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkNumbPage = :swkNumbPage"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkScheduled", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkScheduled = :swkScheduled"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkExecDate", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkExecDate = :swkExecDate"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkCheckpoint", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkCheckpoint = :swkCheckpoint"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkExecuted", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkExecuted = :swkExecuted"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkAddUid", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkAddUid = :swkAddUid"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkAddDate", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkAddDate = :swkAddDate"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkStatus", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkStatus = :swkStatus"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkSmsTotal", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkSmsTotal = :swkSmsTotal"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkPostTotal", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkPostTotal = :swkPostTotal"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkDlvTotal", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkDlvTotal = :swkDlvTotal"),
    @NamedQuery(name = "ServiceWorkshop.findBySwkActuDate", query = "SELECT s FROM ServiceWorkshop s WHERE s.swkActuDate = :swkActuDate")})
public class ServiceWorkshop implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
//    @NotNull
    @Column(name = "SWK_ID")
    private Long swkId;
    @Size(max = 10)
    @Column(name = "SWK_LAN_CODE")
    private String swkLanCode;
    @Size(max = 2000)
    @Column(name = "SWK_MSG")
    private String swkMsg;
    @Column(name = "SWK_NUMB_PAGE")
    private Short swkNumbPage;
    @Size(max = 20)
    @Column(name = "SWK_SCHEDULED")
    private String swkScheduled;
    @Column(name = "SWK_EXEC_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date swkExecDate;
    @Size(max = 30)
    @Column(name = "SWK_CHECKPOINT")
    private String swkCheckpoint;
    @Size(max = 1)
    @Column(name = "SWK_EXECUTED")
    private String swkExecuted;
    @Size(max = 30)
    @Column(name = "SWK_ADD_UID")
    private String swkAddUid;
    @Column(name = "SWK_ADD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date swkAddDate;
    @Size(max = 1)
    @Column(name = "SWK_STATUS")
    private String swkStatus;
    @Column(name = "SWK_SMS_TOTAL")
    private Long swkSmsTotal;
    @Column(name = "SWK_POST_TOTAL")
    private Long swkPostTotal;
    @Column(name = "SWK_DLV_TOTAL")
    private Long swkDlvTotal;
    @Column(name = "SWK_ACTU_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date swkActuDate;
    @JoinColumn(name = "SWK_SSRV_CODE", referencedColumnName = "SSRV_CODE")
    @ManyToOne
    private SubserviceMast swkSsrvCode;
    @JoinColumn(name = "SWK_SRV_CODE", referencedColumnName = "SRV_CODE")
    @ManyToOne
    private ServiceMast swkSrvCode;

    public ServiceWorkshop() {
    }

    public ServiceWorkshop(Long swkId) {
        this.swkId = swkId;
    }

    public Long getSwkId() {
        return swkId;
    }

    public void setSwkId(Long swkId) {
        this.swkId = swkId;
    }

    public String getSwkLanCode() {
        return swkLanCode;
    }

    public void setSwkLanCode(String swkLanCode) {
        this.swkLanCode = swkLanCode;
    }

    public String getSwkMsg() {
        return swkMsg;
    }

    public void setSwkMsg(String swkMsg) {
        this.swkMsg = swkMsg;
    }

    public Short getSwkNumbPage() {
        return swkNumbPage;
    }

    public void setSwkNumbPage(Short swkNumbPage) {
        this.swkNumbPage = swkNumbPage;
    }

    public String getSwkScheduled() {
        return swkScheduled;
    }

    public void setSwkScheduled(String swkScheduled) {
        this.swkScheduled = swkScheduled;
    }

    public Date getSwkExecDate() {
        return swkExecDate;
    }

    public void setSwkExecDate(Date swkExecDate) {
        this.swkExecDate = swkExecDate;
    }

    public String getSwkCheckpoint() {
        return swkCheckpoint;
    }

    public void setSwkCheckpoint(String swkCheckpoint) {
        this.swkCheckpoint = swkCheckpoint;
    }

    public String getSwkExecuted() {
        return swkExecuted;
    }

    public void setSwkExecuted(String swkExecuted) {
        this.swkExecuted = swkExecuted;
    }

    public String getSwkAddUid() {
        return swkAddUid;
    }

    public void setSwkAddUid(String swkAddUid) {
        this.swkAddUid = swkAddUid;
    }

    public Date getSwkAddDate() {
        return swkAddDate;
    }

    public void setSwkAddDate(Date swkAddDate) {
        this.swkAddDate = swkAddDate;
    }

    public String getSwkStatus() {
        return swkStatus;
    }

    public void setSwkStatus(String swkStatus) {
        this.swkStatus = swkStatus;
    }

    public Long getSwkSmsTotal() {
        return swkSmsTotal;
    }

    public void setSwkSmsTotal(Long swkSmsTotal) {
        this.swkSmsTotal = swkSmsTotal;
    }

    public Long getSwkPostTotal() {
        return swkPostTotal;
    }

    public void setSwkPostTotal(Long swkPostTotal) {
        this.swkPostTotal = swkPostTotal;
    }

    public Long getSwkDlvTotal() {
        return swkDlvTotal;
    }

    public void setSwkDlvTotal(Long swkDlvTotal) {
        this.swkDlvTotal = swkDlvTotal;
    }

    public Date getSwkActuDate() {
        return swkActuDate;
    }

    public void setSwkActuDate(Date swkActuDate) {
        this.swkActuDate = swkActuDate;
    }

    public SubserviceMast getSwkSsrvCode() {
        return swkSsrvCode;
    }

    public void setSwkSsrvCode(SubserviceMast swkSsrvCode) {
        this.swkSsrvCode = swkSsrvCode;
    }

    public ServiceMast getSwkSrvCode() {
        return swkSrvCode;
    }

    public void setSwkSrvCode(ServiceMast swkSrvCode) {
        this.swkSrvCode = swkSrvCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (swkId != null ? swkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceWorkshop)) {
            return false;
        }
        ServiceWorkshop other = (ServiceWorkshop) object;
        if ((this.swkId == null && other.swkId != null) || (this.swkId != null && !this.swkId.equals(other.swkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceWorkshop[ swkId=" + swkId + " ]";
    }
    
}
