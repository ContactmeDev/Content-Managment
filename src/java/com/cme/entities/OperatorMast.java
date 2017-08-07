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
@Table(name = "OPERATOR_MAST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperatorMast.findAll", query = "SELECT o FROM OperatorMast o"),
    @NamedQuery(name = "OperatorMast.findByOprCode", query = "SELECT o FROM OperatorMast o WHERE o.oprCode = :oprCode"),
    @NamedQuery(name = "OperatorMast.findByOprName", query = "SELECT o FROM OperatorMast o WHERE o.oprName = :oprName"),
    @NamedQuery(name = "OperatorMast.findByOprNameAr", query = "SELECT o FROM OperatorMast o WHERE o.oprNameAr = :oprNameAr"),
    @NamedQuery(name = "OperatorMast.findByOprShortName", query = "SELECT o FROM OperatorMast o WHERE o.oprShortName = :oprShortName")})
public class OperatorMast implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "OPR_CODE")
    private String oprCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "OPR_NAME")
    private String oprName;
    @Size(max = 100)
    @Column(name = "OPR_NAME_AR")
    private String oprNameAr;
    @Size(max = 10)
    @Column(name = "OPR_SHORT_NAME")
    private String oprShortName;
    @OneToMany(mappedBy = "tranOperator")
    private Collection<ShlTransaction> shlTransactionCollection;
    @OneToMany(mappedBy = "tranOperator")
    private Collection<TrjTransaction> trjTransactionCollection;

    public OperatorMast() {
    }

    public OperatorMast(String oprCode) {
        this.oprCode = oprCode;
    }

    public OperatorMast(String oprCode, String oprName) {
        this.oprCode = oprCode;
        this.oprName = oprName;
    }

    public String getOprCode() {
        return oprCode;
    }

    public void setOprCode(String oprCode) {
        this.oprCode = oprCode;
    }

    public String getOprName() {
        return oprName;
    }

    public void setOprName(String oprName) {
        this.oprName = oprName;
    }

    public String getOprNameAr() {
        return oprNameAr;
    }

    public void setOprNameAr(String oprNameAr) {
        this.oprNameAr = oprNameAr;
    }

    public String getOprShortName() {
        return oprShortName;
    }

    public void setOprShortName(String oprShortName) {
        this.oprShortName = oprShortName;
    }

    @XmlTransient
    public Collection<ShlTransaction> getShlTransactionCollection() {
        return shlTransactionCollection;
    }

    public void setShlTransactionCollection(Collection<ShlTransaction> shlTransactionCollection) {
        this.shlTransactionCollection = shlTransactionCollection;
    }

    @XmlTransient
    public Collection<TrjTransaction> getTrjTransactionCollection() {
        return trjTransactionCollection;
    }

    public void setTrjTransactionCollection(Collection<TrjTransaction> trjTransactionCollection) {
        this.trjTransactionCollection = trjTransactionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oprCode != null ? oprCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperatorMast)) {
            return false;
        }
        OperatorMast other = (OperatorMast) object;
        if ((this.oprCode == null && other.oprCode != null) || (this.oprCode != null && !this.oprCode.equals(other.oprCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OperatorMast[ oprCode=" + oprCode + " ]";
    }
    
}
