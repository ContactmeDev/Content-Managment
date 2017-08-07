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
@Table(name = "SUBSCRIBER_MAST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubscriberMast.findAll", query = "SELECT s FROM SubscriberMast s"),
    @NamedQuery(name = "SubscriberMast.findBySubId", query = "SELECT s FROM SubscriberMast s WHERE s.subId = :subId"),
    @NamedQuery(name = "SubscriberMast.findBySubMobNumb", query = "SELECT s FROM SubscriberMast s WHERE s.subMobNumb = :subMobNumb"),
    @NamedQuery(name = "SubscriberMast.findBySubOprCode", query = "SELECT s FROM SubscriberMast s WHERE s.subOprCode = :subOprCode"),
    @NamedQuery(name = "SubscriberMast.findBySubSubcDate", query = "SELECT s FROM SubscriberMast s WHERE s.subSubcDate = :subSubcDate"),
    @NamedQuery(name = "SubscriberMast.findBySubLastDate", query = "SELECT s FROM SubscriberMast s WHERE s.subLastDate = :subLastDate")})
public class SubscriberMast implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUB_ID")
    private Long subId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SUB_MOB_NUMB")
    private String subMobNumb;
    @Size(max = 10)
    @Column(name = "SUB_OPR_CODE")
    private String subOprCode;
    @Column(name = "SUB_SUBC_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subSubcDate;
    @Column(name = "SUB_LAST_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subLastDate;
    @OneToMany(mappedBy = "subdSubId")
    private Collection<SubscriberDetails> subscriberDetailsCollection;

    public SubscriberMast() {
    }

    public SubscriberMast(Long subId) {
        this.subId = subId;
    }

    public SubscriberMast(Long subId, String subMobNumb) {
        this.subId = subId;
        this.subMobNumb = subMobNumb;
    }

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public String getSubMobNumb() {
        return subMobNumb;
    }

    public void setSubMobNumb(String subMobNumb) {
        this.subMobNumb = subMobNumb;
    }

    public String getSubOprCode() {
        return subOprCode;
    }

    public void setSubOprCode(String subOprCode) {
        this.subOprCode = subOprCode;
    }

    public Date getSubSubcDate() {
        return subSubcDate;
    }

    public void setSubSubcDate(Date subSubcDate) {
        this.subSubcDate = subSubcDate;
    }

    public Date getSubLastDate() {
        return subLastDate;
    }

    public void setSubLastDate(Date subLastDate) {
        this.subLastDate = subLastDate;
    }

    @XmlTransient
    public Collection<SubscriberDetails> getSubscriberDetailsCollection() {
        return subscriberDetailsCollection;
    }

    public void setSubscriberDetailsCollection(Collection<SubscriberDetails> subscriberDetailsCollection) {
        this.subscriberDetailsCollection = subscriberDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subId != null ? subId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubscriberMast)) {
            return false;
        }
        SubscriberMast other = (SubscriberMast) object;
        if ((this.subId == null && other.subId != null) || (this.subId != null && !this.subId.equals(other.subId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SubscriberMast[ subId=" + subId + " ]";
    }
    
}
