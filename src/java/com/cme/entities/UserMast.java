/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mustafaahmed
 */
@Entity
@Table(name = "USER_MAST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserMast.findAll", query = "SELECT u FROM UserMast u"),
    @NamedQuery(name = "UserMast.findByUsrId", query = "SELECT u FROM UserMast u WHERE u.usrId = :usrId"),
    @NamedQuery(name = "UserMast.findByUsrName", query = "SELECT u FROM UserMast u WHERE u.usrName = :usrName"),
    @NamedQuery(name = "UserMast.findByUsrPwd", query = "SELECT u FROM UserMast u WHERE u.usrPwd = :usrPwd"),
    @NamedQuery(name = "UserMast.findByUsrType", query = "SELECT u FROM UserMast u WHERE u.usrType = :usrType"),
    @NamedQuery(name = "UserMast.findByUsrOpenDate", query = "SELECT u FROM UserMast u WHERE u.usrOpenDate = :usrOpenDate"),
    @NamedQuery(name = "UserMast.findByUsrStatus", query = "SELECT u FROM UserMast u WHERE u.usrStatus = :usrStatus"),
    @NamedQuery(name = "UserMast.findByUsrHomeSyspage", query = "SELECT u FROM UserMast u WHERE u.usrHomeSyspage = :usrHomeSyspage"),
    @NamedQuery(name = "UserMast.findByUsrAddress", query = "SELECT u FROM UserMast u WHERE u.usrAddress = :usrAddress"),
    @NamedQuery(name = "UserMast.findByUsrCompany", query = "SELECT u FROM UserMast u WHERE u.usrCompany = :usrCompany"),
    @NamedQuery(name = "UserMast.findByUsrTel", query = "SELECT u FROM UserMast u WHERE u.usrTel = :usrTel"),
    @NamedQuery(name = "UserMast.findByUsrMobile", query = "SELECT u FROM UserMast u WHERE u.usrMobile = :usrMobile"),
    @NamedQuery(name = "UserMast.findByUsrEmail", query = "SELECT u FROM UserMast u WHERE u.usrEmail = :usrEmail"),
    @NamedQuery(name = "UserMast.findByUsrWebsite", query = "SELECT u FROM UserMast u WHERE u.usrWebsite = :usrWebsite"),
    @NamedQuery(name = "UserMast.findByUsrLastLogin", query = "SELECT u FROM UserMast u WHERE u.usrLastLogin = :usrLastLogin"),
    @NamedQuery(name = "UserMast.findByUsrAddUid", query = "SELECT u FROM UserMast u WHERE u.usrAddUid = :usrAddUid"),
    @NamedQuery(name = "UserMast.findByUsrAddDate", query = "SELECT u FROM UserMast u WHERE u.usrAddDate = :usrAddDate"),
    @NamedQuery(name = "UserMast.findByUsrModUid", query = "SELECT u FROM UserMast u WHERE u.usrModUid = :usrModUid"),
    @NamedQuery(name = "UserMast.findByUsrModDate", query = "SELECT u FROM UserMast u WHERE u.usrModDate = :usrModDate"),
    @NamedQuery(name = "UserMast.updateLogin", query = "UPDATE UserMast u set u.usrLastLogin=sysdate WHERE u.usrId = :usrId")})
public class UserMast implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aclUsrId")
    private Collection<UserAccessLog> userAccessLogCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usvUsrId")
    private Collection<UserServiceLink> userServiceLinkCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrhUsrId")
    private Collection<UserHistoryMaint> userHistoryMaintCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USR_ID")
    private String usrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "USR_NAME")
    private String usrName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USR_PWD")
    private String usrPwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USR_TYPE")
    private String usrType;
    @Column(name = "USR_OPEN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrOpenDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "USR_STATUS")
    private String usrStatus;
    @Size(max = 300)
    @Column(name = "USR_HOME_SYSPAGE")
    private String usrHomeSyspage;
    @Size(max = 300)
    @Column(name = "USR_ADDRESS")
    private String usrAddress;
    @Size(max = 100)
    @Column(name = "USR_COMPANY")
    private String usrCompany;
    @Size(max = 100)
    @Column(name = "USR_TEL")
    private String usrTel;
    @Size(max = 20)
    @Column(name = "USR_MOBILE")
    private String usrMobile;
    @Size(max = 100)
    @Column(name = "USR_EMAIL")
    private String usrEmail;
    @Size(max = 100)
    @Column(name = "USR_WEBSITE")
    private String usrWebsite;
    @Column(name = "USR_LAST_LOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrLastLogin;
    @Size(max = 30)
    @Column(name = "USR_ADD_UID")
    private String usrAddUid;
    @Column(name = "USR_ADD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrAddDate;
    @Size(max = 30)
    @Column(name = "USR_MOD_UID")
    private String usrModUid;
    @Column(name = "USR_MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrModDate;

    public UserMast() {
    }

    public UserMast(String usrId) {
        this.usrId = usrId;
    }

    public UserMast(String usrId, String usrName, String usrPwd, String usrType, String usrStatus) {
        this.usrId = usrId;
        this.usrName = usrName;
        this.usrPwd = usrPwd;
        this.usrType = usrType;
        this.usrStatus = usrStatus;
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrPwd() {
        return usrPwd;
    }

    public void setUsrPwd(String usrPwd) {
        this.usrPwd = usrPwd;
    }

    public String getUsrType() {
        return usrType;
    }

    public void setUsrType(String usrType) {
        this.usrType = usrType;
    }

    public Date getUsrOpenDate() {
        return usrOpenDate;
    }

    public void setUsrOpenDate(Date usrOpenDate) {
        this.usrOpenDate = usrOpenDate;
    }

    public String getUsrStatus() {
        return usrStatus;
    }

    public void setUsrStatus(String usrStatus) {
        this.usrStatus = usrStatus;
    }

    public String getUsrHomeSyspage() {
        return usrHomeSyspage;
    }

    public void setUsrHomeSyspage(String usrHomeSyspage) {
        this.usrHomeSyspage = usrHomeSyspage;
    }

    public String getUsrAddress() {
        return usrAddress;
    }

    public void setUsrAddress(String usrAddress) {
        this.usrAddress = usrAddress;
    }

    public String getUsrCompany() {
        return usrCompany;
    }

    public void setUsrCompany(String usrCompany) {
        this.usrCompany = usrCompany;
    }

    public String getUsrTel() {
        return usrTel;
    }

    public void setUsrTel(String usrTel) {
        this.usrTel = usrTel;
    }

    public String getUsrMobile() {
        return usrMobile;
    }

    public void setUsrMobile(String usrMobile) {
        this.usrMobile = usrMobile;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrWebsite() {
        return usrWebsite;
    }

    public void setUsrWebsite(String usrWebsite) {
        this.usrWebsite = usrWebsite;
    }

    public Date getUsrLastLogin() {
        return usrLastLogin;
    }

    public void setUsrLastLogin(Date usrLastLogin) {
        this.usrLastLogin = usrLastLogin;
    }

    public String getUsrAddUid() {
        return usrAddUid;
    }

    public void setUsrAddUid(String usrAddUid) {
        this.usrAddUid = usrAddUid;
    }

    public Date getUsrAddDate() {
        return usrAddDate;
    }

    public void setUsrAddDate(Date usrAddDate) {
        this.usrAddDate = usrAddDate;
    }

    public String getUsrModUid() {
        return usrModUid;
    }

    public void setUsrModUid(String usrModUid) {
        this.usrModUid = usrModUid;
    }

    public Date getUsrModDate() {
        return usrModDate;
    }

    public void setUsrModDate(Date usrModDate) {
        this.usrModDate = usrModDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserMast)) {
            return false;
        }
        UserMast other = (UserMast) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserMast[ usrId=" + usrId + " ]";
    }

    @XmlTransient
    public Collection<UserAccessLog> getUserAccessLogCollection() {
        return userAccessLogCollection;
    }

    public void setUserAccessLogCollection(Collection<UserAccessLog> userAccessLogCollection) {
        this.userAccessLogCollection = userAccessLogCollection;
    }

    @XmlTransient
    public Collection<UserServiceLink> getUserServiceLinkCollection() {
        return userServiceLinkCollection;
    }

    public void setUserServiceLinkCollection(Collection<UserServiceLink> userServiceLinkCollection) {
        this.userServiceLinkCollection = userServiceLinkCollection;
    }

    @XmlTransient
    public Collection<UserHistoryMaint> getUserHistoryMaintCollection() {
        return userHistoryMaintCollection;
    }

    public void setUserHistoryMaintCollection(Collection<UserHistoryMaint> userHistoryMaintCollection) {
        this.userHistoryMaintCollection = userHistoryMaintCollection;
    }
    
}
