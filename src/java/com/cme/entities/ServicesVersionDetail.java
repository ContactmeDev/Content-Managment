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
@Table(name = "SERVICES_VERSION_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicesVersionDetail.findAll", query = "SELECT s FROM ServicesVersionDetail s"),
    @NamedQuery(name = "ServicesVersionDetail.findByVedId", query = "SELECT s FROM ServicesVersionDetail s WHERE s.vedId = :vedId"),
    @NamedQuery(name = "ServicesVersionDetail.findByVedVerId", query = "SELECT s FROM ServicesVersionDetail s WHERE s.vedVerId = :vedVerId"),
    @NamedQuery(name = "ServicesVersionDetail.findByVedSlno", query = "SELECT s FROM ServicesVersionDetail s WHERE s.vedSlno = :vedSlno"),
    @NamedQuery(name = "ServicesVersionDetail.findByVedOsId", query = "SELECT s FROM ServicesVersionDetail s WHERE s.vedOsId = :vedOsId"),
    @NamedQuery(name = "ServicesVersionDetail.findByVedCreated", query = "SELECT s FROM ServicesVersionDetail s WHERE s.vedCreated = :vedCreated"),
    @NamedQuery(name = "ServicesVersionDetail.findByVedReleased", query = "SELECT s FROM ServicesVersionDetail s WHERE s.vedReleased = :vedReleased"),
    @NamedQuery(name = "ServicesVersionDetail.findByVedStatus", query = "SELECT s FROM ServicesVersionDetail s WHERE s.vedStatus = :vedStatus"),
    @NamedQuery(name = "ServicesVersionDetail.findByVedStatusDate", query = "SELECT s FROM ServicesVersionDetail s WHERE s.vedStatusDate = :vedStatusDate"),
    @NamedQuery(name = "ServicesVersionDetail.findByVedFlex01", query = "SELECT s FROM ServicesVersionDetail s WHERE s.vedFlex01 = :vedFlex01")})
public class ServicesVersionDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "VED_ID")
    private String vedId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "VED_VER_ID")
    private String vedVerId;
    @Column(name = "VED_SLNO")
    private Integer vedSlno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "VED_OS_ID")
    private String vedOsId;
    @Column(name = "VED_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vedCreated;
    @Column(name = "VED_RELEASED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vedReleased;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "VED_STATUS")
    private String vedStatus;
    @Column(name = "VED_STATUS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vedStatusDate;
    @Size(max = 350)
    @Column(name = "VED_FLEX01")
    private String vedFlex01;

    public ServicesVersionDetail() {
    }

    public ServicesVersionDetail(String vedId) {
        this.vedId = vedId;
    }

    public ServicesVersionDetail(String vedId, String vedVerId, String vedOsId, String vedStatus) {
        this.vedId = vedId;
        this.vedVerId = vedVerId;
        this.vedOsId = vedOsId;
        this.vedStatus = vedStatus;
    }

    public String getVedId() {
        return vedId;
    }

    public void setVedId(String vedId) {
        this.vedId = vedId;
    }

    public String getVedVerId() {
        return vedVerId;
    }

    public void setVedVerId(String vedVerId) {
        this.vedVerId = vedVerId;
    }

    public Integer getVedSlno() {
        return vedSlno;
    }

    public void setVedSlno(Integer vedSlno) {
        this.vedSlno = vedSlno;
    }

    public String getVedOsId() {
        return vedOsId;
    }

    public void setVedOsId(String vedOsId) {
        this.vedOsId = vedOsId;
    }

    public Date getVedCreated() {
        return vedCreated;
    }

    public void setVedCreated(Date vedCreated) {
        this.vedCreated = vedCreated;
    }

    public Date getVedReleased() {
        return vedReleased;
    }

    public void setVedReleased(Date vedReleased) {
        this.vedReleased = vedReleased;
    }

    public String getVedStatus() {
        return vedStatus;
    }

    public void setVedStatus(String vedStatus) {
        this.vedStatus = vedStatus;
    }

    public Date getVedStatusDate() {
        return vedStatusDate;
    }

    public void setVedStatusDate(Date vedStatusDate) {
        this.vedStatusDate = vedStatusDate;
    }

    public String getVedFlex01() {
        return vedFlex01;
    }

    public void setVedFlex01(String vedFlex01) {
        this.vedFlex01 = vedFlex01;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vedId != null ? vedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicesVersionDetail)) {
            return false;
        }
        ServicesVersionDetail other = (ServicesVersionDetail) object;
        if ((this.vedId == null && other.vedId != null) || (this.vedId != null && !this.vedId.equals(other.vedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServicesVersionDetail[ vedId=" + vedId + " ]";
    }
    
}
