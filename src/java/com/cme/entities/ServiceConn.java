/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mustafaahmed
 */
@Entity
@Table(name = "SERVICE_CONN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceConn.findAll", query = "SELECT s FROM ServiceConn s"),
    @NamedQuery(name = "ServiceConn.findBySrcCode", query = "SELECT s FROM ServiceConn s WHERE s.srcCode = :srcCode"),
    @NamedQuery(name = "ServiceConn.findBySrcType", query = "SELECT s FROM ServiceConn s WHERE s.srcType = :srcType"),
    @NamedQuery(name = "ServiceConn.findBySrcUserId", query = "SELECT s FROM ServiceConn s WHERE s.srcUserId = :srcUserId"),
    @NamedQuery(name = "ServiceConn.findBySrcUserPwd", query = "SELECT s FROM ServiceConn s WHERE s.srcUserPwd = :srcUserPwd"),
    @NamedQuery(name = "ServiceConn.findBySrcPriIp", query = "SELECT s FROM ServiceConn s WHERE s.srcPriIp = :srcPriIp"),
    @NamedQuery(name = "ServiceConn.findBySrcPriPort", query = "SELECT s FROM ServiceConn s WHERE s.srcPriPort = :srcPriPort"),
    @NamedQuery(name = "ServiceConn.findBySrcSecIp", query = "SELECT s FROM ServiceConn s WHERE s.srcSecIp = :srcSecIp"),
    @NamedQuery(name = "ServiceConn.findBySrcSecPort", query = "SELECT s FROM ServiceConn s WHERE s.srcSecPort = :srcSecPort"),
    @NamedQuery(name = "ServiceConn.findBySrcParmTon", query = "SELECT s FROM ServiceConn s WHERE s.srcParmTon = :srcParmTon"),
    @NamedQuery(name = "ServiceConn.findBySrcParmNpi", query = "SELECT s FROM ServiceConn s WHERE s.srcParmNpi = :srcParmNpi"),
    @NamedQuery(name = "ServiceConn.findBySrcParmSystemType", query = "SELECT s FROM ServiceConn s WHERE s.srcParmSystemType = :srcParmSystemType"),
    @NamedQuery(name = "ServiceConn.findBySrcParmBindType", query = "SELECT s FROM ServiceConn s WHERE s.srcParmBindType = :srcParmBindType"),
    @NamedQuery(name = "ServiceConn.findBySrcParmOrgTon", query = "SELECT s FROM ServiceConn s WHERE s.srcParmOrgTon = :srcParmOrgTon"),
    @NamedQuery(name = "ServiceConn.findBySrcParmOrgNpi", query = "SELECT s FROM ServiceConn s WHERE s.srcParmOrgNpi = :srcParmOrgNpi"),
    @NamedQuery(name = "ServiceConn.findBySrcParmDestTon", query = "SELECT s FROM ServiceConn s WHERE s.srcParmDestTon = :srcParmDestTon"),
    @NamedQuery(name = "ServiceConn.findBySrcParmDestNpi", query = "SELECT s FROM ServiceConn s WHERE s.srcParmDestNpi = :srcParmDestNpi"),
    @NamedQuery(name = "ServiceConn.findBySrcParm1", query = "SELECT s FROM ServiceConn s WHERE s.srcParm1 = :srcParm1"),
    @NamedQuery(name = "ServiceConn.findBySrcParm2", query = "SELECT s FROM ServiceConn s WHERE s.srcParm2 = :srcParm2"),
    @NamedQuery(name = "ServiceConn.findBySrcParm3", query = "SELECT s FROM ServiceConn s WHERE s.srcParm3 = :srcParm3"),
    @NamedQuery(name = "ServiceConn.findBySrcParm4", query = "SELECT s FROM ServiceConn s WHERE s.srcParm4 = :srcParm4"),
    @NamedQuery(name = "ServiceConn.findBySrcParm5", query = "SELECT s FROM ServiceConn s WHERE s.srcParm5 = :srcParm5"),
    @NamedQuery(name = "ServiceConn.findBySrcStatus", query = "SELECT s FROM ServiceConn s WHERE s.srcStatus = :srcStatus")})
public class ServiceConn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SRC_CODE")
    private String srcCode;
    @Size(max = 50)
    @Column(name = "SRC_TYPE")
    private String srcType;
    @Size(max = 100)
    @Column(name = "SRC_USER_ID")
    private String srcUserId;
    @Size(max = 250)
    @Column(name = "SRC_USER_PWD")
    private String srcUserPwd;
    @Size(max = 30)
    @Column(name = "SRC_PRI_IP")
    private String srcPriIp;
    @Column(name = "SRC_PRI_PORT")
    private Integer srcPriPort;
    @Size(max = 30)
    @Column(name = "SRC_SEC_IP")
    private String srcSecIp;
    @Column(name = "SRC_SEC_PORT")
    private Integer srcSecPort;
    @Size(max = 20)
    @Column(name = "SRC_PARM_TON")
    private String srcParmTon;
    @Size(max = 20)
    @Column(name = "SRC_PARM_NPI")
    private String srcParmNpi;
    @Size(max = 20)
    @Column(name = "SRC_PARM_SYSTEM_TYPE")
    private String srcParmSystemType;
    @Size(max = 30)
    @Column(name = "SRC_PARM_BIND_TYPE")
    private String srcParmBindType;
    @Size(max = 20)
    @Column(name = "SRC_PARM_ORG_TON")
    private String srcParmOrgTon;
    @Size(max = 20)
    @Column(name = "SRC_PARM_ORG_NPI")
    private String srcParmOrgNpi;
    @Size(max = 20)
    @Column(name = "SRC_PARM_DEST_TON")
    private String srcParmDestTon;
    @Size(max = 20)
    @Column(name = "SRC_PARM_DEST_NPI")
    private String srcParmDestNpi;
    @Size(max = 100)
    @Column(name = "SRC_PARM_1")
    private String srcParm1;
    @Size(max = 100)
    @Column(name = "SRC_PARM_2")
    private String srcParm2;
    @Size(max = 100)
    @Column(name = "SRC_PARM_3")
    private String srcParm3;
    @Size(max = 100)
    @Column(name = "SRC_PARM_4")
    private String srcParm4;
    @Size(max = 100)
    @Column(name = "SRC_PARM_5")
    private String srcParm5;
    @Size(max = 1)
    @Column(name = "SRC_STATUS")
    private String srcStatus;
    @JoinColumn(name = "SRC_SRV_CODE", referencedColumnName = "SRV_CODE")
    @ManyToOne(optional = false)
    private ServiceMast srcSrvCode;

    public ServiceConn() {
    }

    public ServiceConn(String srcCode) {
        this.srcCode = srcCode;
    }

    public String getSrcCode() {
        return srcCode;
    }

    public void setSrcCode(String srcCode) {
        this.srcCode = srcCode;
    }

    public String getSrcType() {
        return srcType;
    }

    public void setSrcType(String srcType) {
        this.srcType = srcType;
    }

    public String getSrcUserId() {
        return srcUserId;
    }

    public void setSrcUserId(String srcUserId) {
        this.srcUserId = srcUserId;
    }

    public String getSrcUserPwd() {
        return srcUserPwd;
    }

    public void setSrcUserPwd(String srcUserPwd) {
        this.srcUserPwd = srcUserPwd;
    }

    public String getSrcPriIp() {
        return srcPriIp;
    }

    public void setSrcPriIp(String srcPriIp) {
        this.srcPriIp = srcPriIp;
    }

    public Integer getSrcPriPort() {
        return srcPriPort;
    }

    public void setSrcPriPort(Integer srcPriPort) {
        this.srcPriPort = srcPriPort;
    }

    public String getSrcSecIp() {
        return srcSecIp;
    }

    public void setSrcSecIp(String srcSecIp) {
        this.srcSecIp = srcSecIp;
    }

    public Integer getSrcSecPort() {
        return srcSecPort;
    }

    public void setSrcSecPort(Integer srcSecPort) {
        this.srcSecPort = srcSecPort;
    }

    public String getSrcParmTon() {
        return srcParmTon;
    }

    public void setSrcParmTon(String srcParmTon) {
        this.srcParmTon = srcParmTon;
    }

    public String getSrcParmNpi() {
        return srcParmNpi;
    }

    public void setSrcParmNpi(String srcParmNpi) {
        this.srcParmNpi = srcParmNpi;
    }

    public String getSrcParmSystemType() {
        return srcParmSystemType;
    }

    public void setSrcParmSystemType(String srcParmSystemType) {
        this.srcParmSystemType = srcParmSystemType;
    }

    public String getSrcParmBindType() {
        return srcParmBindType;
    }

    public void setSrcParmBindType(String srcParmBindType) {
        this.srcParmBindType = srcParmBindType;
    }

    public String getSrcParmOrgTon() {
        return srcParmOrgTon;
    }

    public void setSrcParmOrgTon(String srcParmOrgTon) {
        this.srcParmOrgTon = srcParmOrgTon;
    }

    public String getSrcParmOrgNpi() {
        return srcParmOrgNpi;
    }

    public void setSrcParmOrgNpi(String srcParmOrgNpi) {
        this.srcParmOrgNpi = srcParmOrgNpi;
    }

    public String getSrcParmDestTon() {
        return srcParmDestTon;
    }

    public void setSrcParmDestTon(String srcParmDestTon) {
        this.srcParmDestTon = srcParmDestTon;
    }

    public String getSrcParmDestNpi() {
        return srcParmDestNpi;
    }

    public void setSrcParmDestNpi(String srcParmDestNpi) {
        this.srcParmDestNpi = srcParmDestNpi;
    }

    public String getSrcParm1() {
        return srcParm1;
    }

    public void setSrcParm1(String srcParm1) {
        this.srcParm1 = srcParm1;
    }

    public String getSrcParm2() {
        return srcParm2;
    }

    public void setSrcParm2(String srcParm2) {
        this.srcParm2 = srcParm2;
    }

    public String getSrcParm3() {
        return srcParm3;
    }

    public void setSrcParm3(String srcParm3) {
        this.srcParm3 = srcParm3;
    }

    public String getSrcParm4() {
        return srcParm4;
    }

    public void setSrcParm4(String srcParm4) {
        this.srcParm4 = srcParm4;
    }

    public String getSrcParm5() {
        return srcParm5;
    }

    public void setSrcParm5(String srcParm5) {
        this.srcParm5 = srcParm5;
    }

    public String getSrcStatus() {
        return srcStatus;
    }

    public void setSrcStatus(String srcStatus) {
        this.srcStatus = srcStatus;
    }

    public ServiceMast getSrcSrvCode() {
        return srcSrvCode;
    }

    public void setSrcSrvCode(ServiceMast srcSrvCode) {
        this.srcSrvCode = srcSrvCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (srcCode != null ? srcCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceConn)) {
            return false;
        }
        ServiceConn other = (ServiceConn) object;
        if ((this.srcCode == null && other.srcCode != null) || (this.srcCode != null && !this.srcCode.equals(other.srcCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceConn[ srcCode=" + srcCode + " ]";
    }
    
}
