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
@Table(name = "USER_SERVICE_LINK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserServiceLink.findAll", query = "SELECT u FROM UserServiceLink u"),
    @NamedQuery(name = "UserServiceLink.findByUsvId", query = "SELECT u FROM UserServiceLink u WHERE u.usvId = :usvId"),
    @NamedQuery(name = "UserServiceLink.findByUsvSsrvCode", query = "SELECT u FROM UserServiceLink u WHERE u.usvSsrvCode = :usvSsrvCode"),
    @NamedQuery(name = "UserServiceLink.findByUsvStatus", query = "SELECT u FROM UserServiceLink u WHERE u.usvStatus = :usvStatus"),
    @NamedQuery(name = "UserServiceLink.findByUsvAddUid", query = "SELECT u FROM UserServiceLink u WHERE u.usvAddUid = :usvAddUid"),
    @NamedQuery(name = "UserServiceLink.findByUsvAddDate", query = "SELECT u FROM UserServiceLink u WHERE u.usvAddDate = :usvAddDate"),
    @NamedQuery(name = "UserServiceLink.findByUsvModUid", query = "SELECT u FROM UserServiceLink u WHERE u.usvModUid = :usvModUid"),
    @NamedQuery(name = "UserServiceLink.findByUsvModDate", query = "SELECT u FROM UserServiceLink u WHERE u.usvModDate = :usvModDate")})
public class UserServiceLink implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USV_ID")
    private Long usvId;
    @Size(max = 30)
    @Column(name = "USV_SSRV_CODE")
    private String usvSsrvCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "USV_STATUS")
    private String usvStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USV_ADD_UID")
    private String usvAddUid;
    @Column(name = "USV_ADD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usvAddDate;
    @Size(max = 30)
    @Column(name = "USV_MOD_UID")
    private String usvModUid;
    @Column(name = "USV_MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usvModDate;
    @JoinColumn(name = "USV_USR_ID", referencedColumnName = "USR_ID")
    @ManyToOne(optional = false)
    private UserMast usvUsrId;
    @JoinColumn(name = "USV_SRV_CODE", referencedColumnName = "SRV_CODE")
    @ManyToOne(optional = false)
    private ServiceMast usvSrvCode;

    public UserServiceLink() {
    }

    public UserServiceLink(Long usvId) {
        this.usvId = usvId;
    }

    public UserServiceLink(Long usvId, String usvStatus, String usvAddUid) {
        this.usvId = usvId;
        this.usvStatus = usvStatus;
        this.usvAddUid = usvAddUid;
    }

    public Long getUsvId() {
        return usvId;
    }

    public void setUsvId(Long usvId) {
        this.usvId = usvId;
    }

    public String getUsvSsrvCode() {
        return usvSsrvCode;
    }

    public void setUsvSsrvCode(String usvSsrvCode) {
        this.usvSsrvCode = usvSsrvCode;
    }

    public String getUsvStatus() {
        return usvStatus;
    }

    public void setUsvStatus(String usvStatus) {
        this.usvStatus = usvStatus;
    }

    public String getUsvAddUid() {
        return usvAddUid;
    }

    public void setUsvAddUid(String usvAddUid) {
        this.usvAddUid = usvAddUid;
    }

    public Date getUsvAddDate() {
        return usvAddDate;
    }

    public void setUsvAddDate(Date usvAddDate) {
        this.usvAddDate = usvAddDate;
    }

    public String getUsvModUid() {
        return usvModUid;
    }

    public void setUsvModUid(String usvModUid) {
        this.usvModUid = usvModUid;
    }

    public Date getUsvModDate() {
        return usvModDate;
    }

    public void setUsvModDate(Date usvModDate) {
        this.usvModDate = usvModDate;
    }

    public UserMast getUsvUsrId() {
        return usvUsrId;
    }

    public void setUsvUsrId(UserMast usvUsrId) {
        this.usvUsrId = usvUsrId;
    }

    public ServiceMast getUsvSrvCode() {
        return usvSrvCode;
    }

    public void setUsvSrvCode(ServiceMast usvSrvCode) {
        this.usvSrvCode = usvSrvCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usvId != null ? usvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserServiceLink)) {
            return false;
        }
        UserServiceLink other = (UserServiceLink) object;
        if ((this.usvId == null && other.usvId != null) || (this.usvId != null && !this.usvId.equals(other.usvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserServiceLink[ usvId=" + usvId + " ]";
    }
    
}
