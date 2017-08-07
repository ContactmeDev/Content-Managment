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
@Table(name = "CURRENCY_MAST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CurrencyMast.findAll", query = "SELECT c FROM CurrencyMast c"),
    @NamedQuery(name = "CurrencyMast.findByCurrCode", query = "SELECT c FROM CurrencyMast c WHERE c.currCode = :currCode"),
    @NamedQuery(name = "CurrencyMast.findByCurrName", query = "SELECT c FROM CurrencyMast c WHERE c.currName = :currName"),
    @NamedQuery(name = "CurrencyMast.findByCurrNameAr", query = "SELECT c FROM CurrencyMast c WHERE c.currNameAr = :currNameAr"),
    @NamedQuery(name = "CurrencyMast.findByCurrSymbol", query = "SELECT c FROM CurrencyMast c WHERE c.currSymbol = :currSymbol"),
    @NamedQuery(name = "CurrencyMast.findByCurrStatus", query = "SELECT c FROM CurrencyMast c WHERE c.currStatus = :currStatus")})
public class CurrencyMast implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CURR_CODE")
    private String currCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CURR_NAME")
    private String currName;
    @Size(max = 50)
    @Column(name = "CURR_NAME_AR")
    private String currNameAr;
    @Size(max = 10)
    @Column(name = "CURR_SYMBOL")
    private String currSymbol;
    @Size(max = 1)
    @Column(name = "CURR_STATUS")
    private String currStatus;
    @OneToMany(mappedBy = "ssrvCurrCode")
    private Collection<SubserviceMast> subserviceMastCollection;
    @OneToMany(mappedBy = "srvCurrCode")
    private Collection<ServiceMast> serviceMastCollection;

    public CurrencyMast() {
    }

    public CurrencyMast(String currCode) {
        this.currCode = currCode;
    }

    public CurrencyMast(String currCode, String currName) {
        this.currCode = currCode;
        this.currName = currName;
    }

    public String getCurrCode() {
        return currCode;
    }

    public void setCurrCode(String currCode) {
        this.currCode = currCode;
    }

    public String getCurrName() {
        return currName;
    }

    public void setCurrName(String currName) {
        this.currName = currName;
    }

    public String getCurrNameAr() {
        return currNameAr;
    }

    public void setCurrNameAr(String currNameAr) {
        this.currNameAr = currNameAr;
    }

    public String getCurrSymbol() {
        return currSymbol;
    }

    public void setCurrSymbol(String currSymbol) {
        this.currSymbol = currSymbol;
    }

    public String getCurrStatus() {
        return currStatus;
    }

    public void setCurrStatus(String currStatus) {
        this.currStatus = currStatus;
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
        hash += (currCode != null ? currCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurrencyMast)) {
            return false;
        }
        CurrencyMast other = (CurrencyMast) object;
        if ((this.currCode == null && other.currCode != null) || (this.currCode != null && !this.currCode.equals(other.currCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CurrencyMast[ currCode=" + currCode + " ]";
    }
    
}
