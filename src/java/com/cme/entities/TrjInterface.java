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
@Table(name = "TRJ_INTERFACE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrjInterface.findAll", query = "SELECT t FROM TrjInterface t"),
    @NamedQuery(name = "TrjInterface.findByIntCode", query = "SELECT t FROM TrjInterface t WHERE t.intCode = :intCode"),
    @NamedQuery(name = "TrjInterface.findByIntName", query = "SELECT t FROM TrjInterface t WHERE t.intName = :intName"),
    @NamedQuery(name = "TrjInterface.findByIntStatus", query = "SELECT t FROM TrjInterface t WHERE t.intStatus = :intStatus"),
    @NamedQuery(name = "TrjInterface.findByIntUid", query = "SELECT t FROM TrjInterface t WHERE t.intUid = :intUid"),
    @NamedQuery(name = "TrjInterface.findByIntPid", query = "SELECT t FROM TrjInterface t WHERE t.intPid = :intPid"),
    @NamedQuery(name = "TrjInterface.findByIntActionDate", query = "SELECT t FROM TrjInterface t WHERE t.intActionDate = :intActionDate"),
    @NamedQuery(name = "TrjInterface.findByIntFlex01", query = "SELECT t FROM TrjInterface t WHERE t.intFlex01 = :intFlex01"),
    @NamedQuery(name = "TrjInterface.findByIntFlex02", query = "SELECT t FROM TrjInterface t WHERE t.intFlex02 = :intFlex02"),
    @NamedQuery(name = "TrjInterface.findByIntFlex03", query = "SELECT t FROM TrjInterface t WHERE t.intFlex03 = :intFlex03"),
    @NamedQuery(name = "TrjInterface.findByIntFlex04", query = "SELECT t FROM TrjInterface t WHERE t.intFlex04 = :intFlex04"),
    @NamedQuery(name = "TrjInterface.findByIntFlex05", query = "SELECT t FROM TrjInterface t WHERE t.intFlex05 = :intFlex05"),
    @NamedQuery(name = "TrjInterface.findByIntFlex06", query = "SELECT t FROM TrjInterface t WHERE t.intFlex06 = :intFlex06"),
    @NamedQuery(name = "TrjInterface.findByIntFlex07", query = "SELECT t FROM TrjInterface t WHERE t.intFlex07 = :intFlex07"),
    @NamedQuery(name = "TrjInterface.findByIntFlex08", query = "SELECT t FROM TrjInterface t WHERE t.intFlex08 = :intFlex08"),
    @NamedQuery(name = "TrjInterface.findByIntFlex09", query = "SELECT t FROM TrjInterface t WHERE t.intFlex09 = :intFlex09")})
public class TrjInterface implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "INT_CODE")
    private String intCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "INT_NAME")
    private String intName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "INT_STATUS")
    private String intStatus;
    @Size(max = 30)
    @Column(name = "INT_UID")
    private String intUid;
    @Size(max = 20)
    @Column(name = "INT_PID")
    private String intPid;
    @Column(name = "INT_ACTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date intActionDate;
    @Size(max = 250)
    @Column(name = "INT_FLEX01")
    private String intFlex01;
    @Size(max = 250)
    @Column(name = "INT_FLEX02")
    private String intFlex02;
    @Size(max = 250)
    @Column(name = "INT_FLEX03")
    private String intFlex03;
    @Size(max = 250)
    @Column(name = "INT_FLEX04")
    private String intFlex04;
    @Size(max = 250)
    @Column(name = "INT_FLEX05")
    private String intFlex05;
    @Size(max = 250)
    @Column(name = "INT_FLEX06")
    private String intFlex06;
    @Size(max = 250)
    @Column(name = "INT_FLEX07")
    private String intFlex07;
    @Size(max = 250)
    @Column(name = "INT_FLEX08")
    private String intFlex08;
    @Size(max = 250)
    @Column(name = "INT_FLEX09")
    private String intFlex09;

    public TrjInterface() {
    }

    public TrjInterface(String intCode) {
        this.intCode = intCode;
    }

    public TrjInterface(String intCode, String intName, String intStatus) {
        this.intCode = intCode;
        this.intName = intName;
        this.intStatus = intStatus;
    }

    public String getIntCode() {
        return intCode;
    }

    public void setIntCode(String intCode) {
        this.intCode = intCode;
    }

    public String getIntName() {
        return intName;
    }

    public void setIntName(String intName) {
        this.intName = intName;
    }

    public String getIntStatus() {
        return intStatus;
    }

    public void setIntStatus(String intStatus) {
        this.intStatus = intStatus;
    }

    public String getIntUid() {
        return intUid;
    }

    public void setIntUid(String intUid) {
        this.intUid = intUid;
    }

    public String getIntPid() {
        return intPid;
    }

    public void setIntPid(String intPid) {
        this.intPid = intPid;
    }

    public Date getIntActionDate() {
        return intActionDate;
    }

    public void setIntActionDate(Date intActionDate) {
        this.intActionDate = intActionDate;
    }

    public String getIntFlex01() {
        return intFlex01;
    }

    public void setIntFlex01(String intFlex01) {
        this.intFlex01 = intFlex01;
    }

    public String getIntFlex02() {
        return intFlex02;
    }

    public void setIntFlex02(String intFlex02) {
        this.intFlex02 = intFlex02;
    }

    public String getIntFlex03() {
        return intFlex03;
    }

    public void setIntFlex03(String intFlex03) {
        this.intFlex03 = intFlex03;
    }

    public String getIntFlex04() {
        return intFlex04;
    }

    public void setIntFlex04(String intFlex04) {
        this.intFlex04 = intFlex04;
    }

    public String getIntFlex05() {
        return intFlex05;
    }

    public void setIntFlex05(String intFlex05) {
        this.intFlex05 = intFlex05;
    }

    public String getIntFlex06() {
        return intFlex06;
    }

    public void setIntFlex06(String intFlex06) {
        this.intFlex06 = intFlex06;
    }

    public String getIntFlex07() {
        return intFlex07;
    }

    public void setIntFlex07(String intFlex07) {
        this.intFlex07 = intFlex07;
    }

    public String getIntFlex08() {
        return intFlex08;
    }

    public void setIntFlex08(String intFlex08) {
        this.intFlex08 = intFlex08;
    }

    public String getIntFlex09() {
        return intFlex09;
    }

    public void setIntFlex09(String intFlex09) {
        this.intFlex09 = intFlex09;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (intCode != null ? intCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrjInterface)) {
            return false;
        }
        TrjInterface other = (TrjInterface) object;
        if ((this.intCode == null && other.intCode != null) || (this.intCode != null && !this.intCode.equals(other.intCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TrjInterface[ intCode=" + intCode + " ]";
    }
    
}
