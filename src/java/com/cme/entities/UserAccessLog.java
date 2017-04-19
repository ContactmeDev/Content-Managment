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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "USER_ACCESS_LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAccessLog.findAll", query = "SELECT u FROM UserAccessLog u"),
    @NamedQuery(name = "UserAccessLog.findByAclId", query = "SELECT u FROM UserAccessLog u WHERE u.aclId = :aclId"),
    @NamedQuery(name = "UserAccessLog.findByAclLoginDate", query = "SELECT u FROM UserAccessLog u WHERE u.aclLoginDate = :aclLoginDate"),
    @NamedQuery(name = "UserAccessLog.findByAclLogoutDate", query = "SELECT u FROM UserAccessLog u WHERE u.aclLogoutDate = :aclLogoutDate"),
    @NamedQuery(name = "UserAccessLog.findByAclIpadd", query = "SELECT u FROM UserAccessLog u WHERE u.aclIpadd = :aclIpadd"),
    @NamedQuery(name = "UserAccessLog.findByAclHostname", query = "SELECT u FROM UserAccessLog u WHERE u.aclHostname = :aclHostname")})
public class UserAccessLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="SEQ_ACL_ID",allocationSize=1)
    @Column(name = "ACL_ID")
    private Long aclId;
    
    
    @Column(name = "ACL_LOGIN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aclLoginDate;
    
    
    @Column(name = "ACL_LOGOUT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aclLogoutDate;
    
    
    @Size(max = 20)
    @Column(name = "ACL_IPADD")
    private String aclIpadd;
    
    @Size(max = 500)
    @Column(name = "ACL_HOSTNAME")
    private String aclHostname;
    
    @JoinColumn(name = "ACL_USR_ID", referencedColumnName = "USR_ID")
    @ManyToOne(optional = false)
    private UserMast aclUsrId;

    public UserAccessLog() {
    }

    public UserAccessLog(Long aclId) {
        this.aclId = aclId;
    }

    public Long getAclId() {
        return aclId;
    }

    public void setAclId(Long aclId) {
        this.aclId = aclId;
    }

    public Date getAclLoginDate() {
        return aclLoginDate;
    }

    public void setAclLoginDate(Date aclLoginDate) {
        this.aclLoginDate = aclLoginDate;
    }

    public Date getAclLogoutDate() {
        return aclLogoutDate;
    }

    public void setAclLogoutDate(Date aclLogoutDate) {
        this.aclLogoutDate = aclLogoutDate;
    }

    public String getAclIpadd() {
        return aclIpadd;
    }

    public void setAclIpadd(String aclIpadd) {
        this.aclIpadd = aclIpadd;
    }

    public String getAclHostname() {
        return aclHostname;
    }

    public void setAclHostname(String aclHostname) {
        this.aclHostname = aclHostname;
    }

    public UserMast getAclUsrId() {
        return aclUsrId;
    }

    public void setAclUsrId(UserMast aclUsrId) {
        this.aclUsrId = aclUsrId;
    }
    
    public void setAccessData()
    {
        
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aclId != null ? aclId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAccessLog)) {
            return false;
        }
        UserAccessLog other = (UserAccessLog) object;
        if ((this.aclId == null && other.aclId != null) || (this.aclId != null && !this.aclId.equals(other.aclId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserAccessLog[ aclId=" + aclId + " ]";
    }
    
}
