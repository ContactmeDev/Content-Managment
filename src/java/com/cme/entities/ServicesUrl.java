/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "SERVICES_URL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicesUrl.findAll", query = "SELECT s FROM ServicesUrl s"),
    @NamedQuery(name = "ServicesUrl.findBySurCode", query = "SELECT s FROM ServicesUrl s WHERE s.surCode = :surCode"),
    @NamedQuery(name = "ServicesUrl.findBySurSrvCode", query = "SELECT s FROM ServicesUrl s WHERE s.surSrvCode = :surSrvCode"),
    @NamedQuery(name = "ServicesUrl.findBySurSsrvCode", query = "SELECT s FROM ServicesUrl s WHERE s.surSsrvCode = :surSsrvCode"),
    @NamedQuery(name = "ServicesUrl.findBySurType", query = "SELECT s FROM ServicesUrl s WHERE s.surType = :surType"),
    @NamedQuery(name = "ServicesUrl.findBySurUrl", query = "SELECT s FROM ServicesUrl s WHERE s.surUrl = :surUrl"),
    @NamedQuery(name = "ServicesUrl.findBySurAppend", query = "SELECT s FROM ServicesUrl s WHERE s.surAppend = :surAppend"),
    @NamedQuery(name = "ServicesUrl.findBySurFilename", query = "SELECT s FROM ServicesUrl s WHERE s.surFilename = :surFilename"),
    @NamedQuery(name = "ServicesUrl.findBySurFilesize", query = "SELECT s FROM ServicesUrl s WHERE s.surFilesize = :surFilesize"),
    @NamedQuery(name = "ServicesUrl.findBySurOsId", query = "SELECT s FROM ServicesUrl s WHERE s.surOsId = :surOsId"),
    @NamedQuery(name = "ServicesUrl.findBySurStatus", query = "SELECT s FROM ServicesUrl s WHERE s.surStatus = :surStatus")})
public class ServicesUrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SUR_CODE")
    private String surCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SUR_SRV_CODE")
    private String surSrvCode;
    @Size(max = 30)
    @Column(name = "SUR_SSRV_CODE")
    private String surSsrvCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SUR_TYPE")
    private String surType;
    @Size(max = 500)
    @Column(name = "SUR_URL")
    private String surUrl;
    @Size(max = 1)
    @Column(name = "SUR_APPEND")
    private String surAppend;
    @Size(max = 500)
    @Column(name = "SUR_FILENAME")
    private String surFilename;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SUR_FILESIZE")
    private BigDecimal surFilesize;
    @Size(max = 20)
    @Column(name = "SUR_OS_ID")
    private String surOsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SUR_STATUS")
    private String surStatus;

    public ServicesUrl() {
    }

    public ServicesUrl(String surCode) {
        this.surCode = surCode;
    }

    public ServicesUrl(String surCode, String surSrvCode, String surType, String surStatus) {
        this.surCode = surCode;
        this.surSrvCode = surSrvCode;
        this.surType = surType;
        this.surStatus = surStatus;
    }

    public String getSurCode() {
        return surCode;
    }

    public void setSurCode(String surCode) {
        this.surCode = surCode;
    }

    public String getSurSrvCode() {
        return surSrvCode;
    }

    public void setSurSrvCode(String surSrvCode) {
        this.surSrvCode = surSrvCode;
    }

    public String getSurSsrvCode() {
        return surSsrvCode;
    }

    public void setSurSsrvCode(String surSsrvCode) {
        this.surSsrvCode = surSsrvCode;
    }

    public String getSurType() {
        return surType;
    }

    public void setSurType(String surType) {
        this.surType = surType;
    }

    public String getSurUrl() {
        return surUrl;
    }

    public void setSurUrl(String surUrl) {
        this.surUrl = surUrl;
    }

    public String getSurAppend() {
        return surAppend;
    }

    public void setSurAppend(String surAppend) {
        this.surAppend = surAppend;
    }

    public String getSurFilename() {
        return surFilename;
    }

    public void setSurFilename(String surFilename) {
        this.surFilename = surFilename;
    }

    public BigDecimal getSurFilesize() {
        return surFilesize;
    }

    public void setSurFilesize(BigDecimal surFilesize) {
        this.surFilesize = surFilesize;
    }

    public String getSurOsId() {
        return surOsId;
    }

    public void setSurOsId(String surOsId) {
        this.surOsId = surOsId;
    }

    public String getSurStatus() {
        return surStatus;
    }

    public void setSurStatus(String surStatus) {
        this.surStatus = surStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (surCode != null ? surCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicesUrl)) {
            return false;
        }
        ServicesUrl other = (ServicesUrl) object;
        if ((this.surCode == null && other.surCode != null) || (this.surCode != null && !this.surCode.equals(other.surCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServicesUrl[ surCode=" + surCode + " ]";
    }
    
}
