/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mustafaahmed
 */
@Entity
@Table(name = "SERVICE_CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceCategory.findAll", query = "SELECT s FROM ServiceCategory s"),
    @NamedQuery(name = "ServiceCategory.findByScatCode", query = "SELECT s FROM ServiceCategory s WHERE s.scatCode = :scatCode"),
    @NamedQuery(name = "ServiceCategory.findByScatNameEn", query = "SELECT s FROM ServiceCategory s WHERE s.scatNameEn = :scatNameEn"),
    @NamedQuery(name = "ServiceCategory.findByScatNameAr", query = "SELECT s FROM ServiceCategory s WHERE s.scatNameAr = :scatNameAr"),
    @NamedQuery(name = "ServiceCategory.findByScatDesc", query = "SELECT s FROM ServiceCategory s WHERE s.scatDesc = :scatDesc"),
    @NamedQuery(name = "ServiceCategory.findByScatPriority", query = "SELECT s FROM ServiceCategory s WHERE s.scatPriority = :scatPriority"),
    @NamedQuery(name = "ServiceCategory.findByScatStatus", query = "SELECT s FROM ServiceCategory s WHERE s.scatStatus = :scatStatus")})
public class ServiceCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SCAT_CODE")
    private String scatCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SCAT_NAME_EN")
    private String scatNameEn;
    @Size(max = 20)
    @Column(name = "SCAT_NAME_AR")
    private String scatNameAr;
    @Size(max = 100)
    @Column(name = "SCAT_DESC")
    private String scatDesc;
    @Size(max = 10)
    @Column(name = "SCAT_PRIORITY")
    private String scatPriority;
    @Size(max = 1)
    @Column(name = "SCAT_STATUS")
    private String scatStatus;
    @OneToMany(mappedBy = "ssrvScatCode")
    private Collection<SubserviceMast> subserviceMastCollection;
    @OneToMany(mappedBy = "srvScatCode")
    private Collection<ServiceMast> serviceMastCollection;

    public ServiceCategory() {
    }

    public ServiceCategory(String scatCode) {
        this.scatCode = scatCode;
    }

    public ServiceCategory(String scatCode, String scatNameEn) {
        this.scatCode = scatCode;
        this.scatNameEn = scatNameEn;
    }

    public String getScatCode() {
        return scatCode;
    }

    public void setScatCode(String scatCode) {
        this.scatCode = scatCode;
    }

    public String getScatNameEn() {
        return scatNameEn;
    }

    public void setScatNameEn(String scatNameEn) {
        this.scatNameEn = scatNameEn;
    }

    public String getScatNameAr() {
        return scatNameAr;
    }

    public void setScatNameAr(String scatNameAr) {
        this.scatNameAr = scatNameAr;
    }

    public String getScatDesc() {
        return scatDesc;
    }

    public void setScatDesc(String scatDesc) {
        this.scatDesc = scatDesc;
    }

    public String getScatPriority() {
        return scatPriority;
    }

    public void setScatPriority(String scatPriority) {
        this.scatPriority = scatPriority;
    }

    public String getScatStatus() {
        return scatStatus;
    }

    public void setScatStatus(String scatStatus) {
        this.scatStatus = scatStatus;
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
        hash += (scatCode != null ? scatCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceCategory)) {
            return false;
        }
        ServiceCategory other = (ServiceCategory) object;
        if ((this.scatCode == null && other.scatCode != null) || (this.scatCode != null && !this.scatCode.equals(other.scatCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceCategory[ scatCode=" + scatCode + " ]";
    }
    
}
