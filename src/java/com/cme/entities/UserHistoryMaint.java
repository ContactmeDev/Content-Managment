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
@Table(name = "USER_HISTORY_MAINT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserHistoryMaint.findAll", query = "SELECT u FROM UserHistoryMaint u"),
    @NamedQuery(name = "UserHistoryMaint.findByUsrhCode", query = "SELECT u FROM UserHistoryMaint u WHERE u.usrhCode = :usrhCode"),
    @NamedQuery(name = "UserHistoryMaint.findByUsrhOldPwd", query = "SELECT u FROM UserHistoryMaint u WHERE u.usrhOldPwd = :usrhOldPwd"),
    @NamedQuery(name = "UserHistoryMaint.findByUsrhOldType", query = "SELECT u FROM UserHistoryMaint u WHERE u.usrhOldType = :usrhOldType"),
    @NamedQuery(name = "UserHistoryMaint.findByUsrhNewType", query = "SELECT u FROM UserHistoryMaint u WHERE u.usrhNewType = :usrhNewType"),
    @NamedQuery(name = "UserHistoryMaint.findByUsrhOldStatus", query = "SELECT u FROM UserHistoryMaint u WHERE u.usrhOldStatus = :usrhOldStatus"),
    @NamedQuery(name = "UserHistoryMaint.findByUsrhNewStatus", query = "SELECT u FROM UserHistoryMaint u WHERE u.usrhNewStatus = :usrhNewStatus"),
    @NamedQuery(name = "UserHistoryMaint.findByUsrhModUid", query = "SELECT u FROM UserHistoryMaint u WHERE u.usrhModUid = :usrhModUid"),
    @NamedQuery(name = "UserHistoryMaint.findByUsrhModDate", query = "SELECT u FROM UserHistoryMaint u WHERE u.usrhModDate = :usrhModDate")})
public class UserHistoryMaint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USRH_CODE")
    private Long usrhCode;
    @Size(max = 100)
    @Column(name = "USRH_OLD_PWD")
    private String usrhOldPwd;
    @Size(max = 20)
    @Column(name = "USRH_OLD_TYPE")
    private String usrhOldType;
    @Size(max = 20)
    @Column(name = "USRH_NEW_TYPE")
    private String usrhNewType;
    @Size(max = 1)
    @Column(name = "USRH_OLD_STATUS")
    private String usrhOldStatus;
    @Size(max = 1)
    @Column(name = "USRH_NEW_STATUS")
    private String usrhNewStatus;
    @Size(max = 30)
    @Column(name = "USRH_MOD_UID")
    private String usrhModUid;
    @Column(name = "USRH_MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrhModDate;
    @JoinColumn(name = "USRH_USR_ID", referencedColumnName = "USR_ID")
    @ManyToOne(optional = false)
    private UserMast usrhUsrId;

    public UserHistoryMaint() {
    }

    public UserHistoryMaint(Long usrhCode) {
        this.usrhCode = usrhCode;
    }

    public Long getUsrhCode() {
        return usrhCode;
    }

    public void setUsrhCode(Long usrhCode) {
        this.usrhCode = usrhCode;
    }

    public String getUsrhOldPwd() {
        return usrhOldPwd;
    }

    public void setUsrhOldPwd(String usrhOldPwd) {
        this.usrhOldPwd = usrhOldPwd;
    }

    public String getUsrhOldType() {
        return usrhOldType;
    }

    public void setUsrhOldType(String usrhOldType) {
        this.usrhOldType = usrhOldType;
    }

    public String getUsrhNewType() {
        return usrhNewType;
    }

    public void setUsrhNewType(String usrhNewType) {
        this.usrhNewType = usrhNewType;
    }

    public String getUsrhOldStatus() {
        return usrhOldStatus;
    }

    public void setUsrhOldStatus(String usrhOldStatus) {
        this.usrhOldStatus = usrhOldStatus;
    }

    public String getUsrhNewStatus() {
        return usrhNewStatus;
    }

    public void setUsrhNewStatus(String usrhNewStatus) {
        this.usrhNewStatus = usrhNewStatus;
    }

    public String getUsrhModUid() {
        return usrhModUid;
    }

    public void setUsrhModUid(String usrhModUid) {
        this.usrhModUid = usrhModUid;
    }

    public Date getUsrhModDate() {
        return usrhModDate;
    }

    public void setUsrhModDate(Date usrhModDate) {
        this.usrhModDate = usrhModDate;
    }

    public UserMast getUsrhUsrId() {
        return usrhUsrId;
    }

    public void setUsrhUsrId(UserMast usrhUsrId) {
        this.usrhUsrId = usrhUsrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrhCode != null ? usrhCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHistoryMaint)) {
            return false;
        }
        UserHistoryMaint other = (UserHistoryMaint) object;
        if ((this.usrhCode == null && other.usrhCode != null) || (this.usrhCode != null && !this.usrhCode.equals(other.usrhCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserHistoryMaint[ usrhCode=" + usrhCode + " ]";
    }
    
}
