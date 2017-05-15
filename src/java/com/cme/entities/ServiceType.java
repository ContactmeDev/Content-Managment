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
@Table(name = "SERVICE_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceType.findAll", query = "SELECT s FROM ServiceType s"),
    @NamedQuery(name = "ServiceType.findBySrtCode", query = "SELECT s FROM ServiceType s WHERE s.srtCode = :srtCode"),
    @NamedQuery(name = "ServiceType.findBySrtName", query = "SELECT s FROM ServiceType s WHERE s.srtName = :srtName"),
    @NamedQuery(name = "ServiceType.findBySrtNameAr", query = "SELECT s FROM ServiceType s WHERE s.srtNameAr = :srtNameAr"),
    @NamedQuery(name = "ServiceType.findBySrtStatus", query = "SELECT s FROM ServiceType s WHERE s.srtStatus = :srtStatus"),
    @NamedQuery(name = "ServiceType.findBySrtAddUid", query = "SELECT s FROM ServiceType s WHERE s.srtAddUid = :srtAddUid"),
    @NamedQuery(name = "ServiceType.findBySrtAddDate", query = "SELECT s FROM ServiceType s WHERE s.srtAddDate = :srtAddDate"),
    @NamedQuery(name = "ServiceType.findBySrtUpdUid", query = "SELECT s FROM ServiceType s WHERE s.srtUpdUid = :srtUpdUid"),
    @NamedQuery(name = "ServiceType.findBySrtUpdDate", query = "SELECT s FROM ServiceType s WHERE s.srtUpdDate = :srtUpdDate")})
public class ServiceType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SRT_CODE")
    private String srtCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SRT_NAME")
    private String srtName;
    @Size(max = 100)
    @Column(name = "SRT_NAME_AR")
    private String srtNameAr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SRT_STATUS")
    private String srtStatus;
    @Size(max = 30)
    @Column(name = "SRT_ADD_UID")
    private String srtAddUid;
    @Column(name = "SRT_ADD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date srtAddDate;
    @Size(max = 30)
    @Column(name = "SRT_UPD_UID")
    private String srtUpdUid;
    @Column(name = "SRT_UPD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date srtUpdDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ssrvSrtCode")
    private Collection<SubserviceMast> subserviceMastCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "srvSrtCode")
    private Collection<ServiceMast> serviceMastCollection;

    public ServiceType() {
    }

    public ServiceType(String srtCode) {
        this.srtCode = srtCode;
    }

    public ServiceType(String srtCode, String srtName, String srtStatus) {
        this.srtCode = srtCode;
        this.srtName = srtName;
        this.srtStatus = srtStatus;
    }

    public String getSrtCode() {
        return srtCode;
    }

    public void setSrtCode(String srtCode) {
        this.srtCode = srtCode;
    }

    public String getSrtName() {
        return srtName;
    }

    public void setSrtName(String srtName) {
        this.srtName = srtName;
    }

    public String getSrtNameAr() {
        return srtNameAr;
    }

    public void setSrtNameAr(String srtNameAr) {
        this.srtNameAr = srtNameAr;
    }

    public String getSrtStatus() {
        return srtStatus;
    }

    public void setSrtStatus(String srtStatus) {
        this.srtStatus = srtStatus;
    }

    public String getSrtAddUid() {
        return srtAddUid;
    }

    public void setSrtAddUid(String srtAddUid) {
        this.srtAddUid = srtAddUid;
    }

    public Date getSrtAddDate() {
        return srtAddDate;
    }

    public void setSrtAddDate(Date srtAddDate) {
        this.srtAddDate = srtAddDate;
    }

    public String getSrtUpdUid() {
        return srtUpdUid;
    }

    public void setSrtUpdUid(String srtUpdUid) {
        this.srtUpdUid = srtUpdUid;
    }

    public Date getSrtUpdDate() {
        return srtUpdDate;
    }

    public void setSrtUpdDate(Date srtUpdDate) {
        this.srtUpdDate = srtUpdDate;
    }

    @XmlTransient
    public Collection<SubserviceMast> getSubserviceMastCollection() {
        return subserviceMastCollection;
    }

    public void setSubserviceMastCollection(Collection<SubserviceMast> subserviceMastCollection) {
        this.subserviceMastCollection = subserviceMastCollection;
    }

    @XmlTransient
    public Collection<ServiceMast> getServiceMastCollection() {
        return serviceMastCollection;
    }

    public void setServiceMastCollection(Collection<ServiceMast> serviceMastCollection) {
        this.serviceMastCollection = serviceMastCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (srtCode != null ? srtCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceType)) {
            return false;
        }
        ServiceType other = (ServiceType) object;
        if ((this.srtCode == null && other.srtCode != null) || (this.srtCode != null && !this.srtCode.equals(other.srtCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceType[ srtCode=" + srtCode + " ]";
    }
    
}
