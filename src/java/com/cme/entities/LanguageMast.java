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
@Table(name = "LANGUAGE_MAST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LanguageMast.findAll", query = "SELECT l FROM LanguageMast l"),
    @NamedQuery(name = "LanguageMast.findByLanCode", query = "SELECT l FROM LanguageMast l WHERE l.lanCode = :lanCode"),
    @NamedQuery(name = "LanguageMast.findByLanNameEn", query = "SELECT l FROM LanguageMast l WHERE l.lanNameEn = :lanNameEn"),
    @NamedQuery(name = "LanguageMast.findByLanNameAr", query = "SELECT l FROM LanguageMast l WHERE l.lanNameAr = :lanNameAr"),
    @NamedQuery(name = "LanguageMast.findByLanChrPerPage", query = "SELECT l FROM LanguageMast l WHERE l.lanChrPerPage = :lanChrPerPage"),
    @NamedQuery(name = "LanguageMast.findByLanStatus", query = "SELECT l FROM LanguageMast l WHERE l.lanStatus = :lanStatus"),
    @NamedQuery(name = "LanguageMast.findByLanDatacode", query = "SELECT l FROM LanguageMast l WHERE l.lanDatacode = :lanDatacode")})
public class LanguageMast implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "LAN_CODE")
    private String lanCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "LAN_NAME_EN")
    private String lanNameEn;
    @Size(max = 100)
    @Column(name = "LAN_NAME_AR")
    private String lanNameAr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LAN_CHR_PER_PAGE")
    private short lanChrPerPage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "LAN_STATUS")
    private String lanStatus;
    @Size(max = 10)
    @Column(name = "LAN_DATACODE")
    private String lanDatacode;
    @OneToMany(mappedBy = "ssrvLanCode")
    private Collection<SubserviceMast> subserviceMastCollection;
    @OneToMany(mappedBy = "srvLanCode")
    private Collection<ServiceMast> serviceMastCollection;

    public LanguageMast() {
    }

    public LanguageMast(String lanCode) {
        this.lanCode = lanCode;
    }

    public LanguageMast(String lanCode, String lanNameEn, short lanChrPerPage, String lanStatus) {
        this.lanCode = lanCode;
        this.lanNameEn = lanNameEn;
        this.lanChrPerPage = lanChrPerPage;
        this.lanStatus = lanStatus;
    }

    public String getLanCode() {
        return lanCode;
    }

    public void setLanCode(String lanCode) {
        this.lanCode = lanCode;
    }

    public String getLanNameEn() {
        return lanNameEn;
    }

    public void setLanNameEn(String lanNameEn) {
        this.lanNameEn = lanNameEn;
    }

    public String getLanNameAr() {
        return lanNameAr;
    }

    public void setLanNameAr(String lanNameAr) {
        this.lanNameAr = lanNameAr;
    }

    public short getLanChrPerPage() {
        return lanChrPerPage;
    }

    public void setLanChrPerPage(short lanChrPerPage) {
        this.lanChrPerPage = lanChrPerPage;
    }

    public String getLanStatus() {
        return lanStatus;
    }

    public void setLanStatus(String lanStatus) {
        this.lanStatus = lanStatus;
    }

    public String getLanDatacode() {
        return lanDatacode;
    }

    public void setLanDatacode(String lanDatacode) {
        this.lanDatacode = lanDatacode;
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
        hash += (lanCode != null ? lanCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LanguageMast)) {
            return false;
        }
        LanguageMast other = (LanguageMast) object;
        if ((this.lanCode == null && other.lanCode != null) || (this.lanCode != null && !this.lanCode.equals(other.lanCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LanguageMast[ lanCode=" + lanCode + " ]";
    }
    
}
