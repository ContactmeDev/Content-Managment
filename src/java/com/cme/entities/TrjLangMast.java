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
@Table(name = "TRJ_LANG_MAST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrjLangMast.findAll", query = "SELECT t FROM TrjLangMast t"),
    @NamedQuery(name = "TrjLangMast.findByLanId", query = "SELECT t FROM TrjLangMast t WHERE t.lanId = :lanId"),
    @NamedQuery(name = "TrjLangMast.findByLanCode", query = "SELECT t FROM TrjLangMast t WHERE t.lanCode = :lanCode"),
    @NamedQuery(name = "TrjLangMast.findByLanNameEn", query = "SELECT t FROM TrjLangMast t WHERE t.lanNameEn = :lanNameEn"),
    @NamedQuery(name = "TrjLangMast.findByLanNameAr", query = "SELECT t FROM TrjLangMast t WHERE t.lanNameAr = :lanNameAr"),
    @NamedQuery(name = "TrjLangMast.findByLanNativeName", query = "SELECT t FROM TrjLangMast t WHERE t.lanNativeName = :lanNativeName"),
    @NamedQuery(name = "TrjLangMast.findByLanListNumb", query = "SELECT t FROM TrjLangMast t WHERE t.lanListNumb = :lanListNumb"),
    @NamedQuery(name = "TrjLangMast.findByLanStatus", query = "SELECT t FROM TrjLangMast t WHERE t.lanStatus = :lanStatus"),
    @NamedQuery(name = "TrjLangMast.findByLanAddUid", query = "SELECT t FROM TrjLangMast t WHERE t.lanAddUid = :lanAddUid"),
    @NamedQuery(name = "TrjLangMast.findByLanAddDate", query = "SELECT t FROM TrjLangMast t WHERE t.lanAddDate = :lanAddDate"),
    @NamedQuery(name = "TrjLangMast.findByLanModUid", query = "SELECT t FROM TrjLangMast t WHERE t.lanModUid = :lanModUid"),
    @NamedQuery(name = "TrjLangMast.findByLanModDate", query = "SELECT t FROM TrjLangMast t WHERE t.lanModDate = :lanModDate")})
public class TrjLangMast implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LAN_ID")
    private String lanId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LAN_CODE")
    private String lanCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LAN_NAME_EN")
    private String lanNameEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LAN_NAME_AR")
    private String lanNameAr;
    @Size(max = 50)
    @Column(name = "LAN_NATIVE_NAME")
    private String lanNativeName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LAN_LIST_NUMB")
    private short lanListNumb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "LAN_STATUS")
    private String lanStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LAN_ADD_UID")
    private String lanAddUid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LAN_ADD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lanAddDate;
    @Size(max = 30)
    @Column(name = "LAN_MOD_UID")
    private String lanModUid;
    @Column(name = "LAN_MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lanModDate;
    @OneToMany(mappedBy = "tranFromLang")
    private Collection<TrjTransaction> trjTransactionCollection;
    @OneToMany(mappedBy = "tranToLang")
    private Collection<TrjTransaction> trjTransactionCollection1;

    public TrjLangMast() {
    }

    public TrjLangMast(String lanId) {
        this.lanId = lanId;
    }

    public TrjLangMast(String lanId, String lanCode, String lanNameEn, String lanNameAr, short lanListNumb, String lanStatus, String lanAddUid, Date lanAddDate) {
        this.lanId = lanId;
        this.lanCode = lanCode;
        this.lanNameEn = lanNameEn;
        this.lanNameAr = lanNameAr;
        this.lanListNumb = lanListNumb;
        this.lanStatus = lanStatus;
        this.lanAddUid = lanAddUid;
        this.lanAddDate = lanAddDate;
    }

    public String getLanId() {
        return lanId;
    }

    public void setLanId(String lanId) {
        this.lanId = lanId;
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

    public String getLanNativeName() {
        return lanNativeName;
    }

    public void setLanNativeName(String lanNativeName) {
        this.lanNativeName = lanNativeName;
    }

    public short getLanListNumb() {
        return lanListNumb;
    }

    public void setLanListNumb(short lanListNumb) {
        this.lanListNumb = lanListNumb;
    }

    public String getLanStatus() {
        return lanStatus;
    }

    public void setLanStatus(String lanStatus) {
        this.lanStatus = lanStatus;
    }

    public String getLanAddUid() {
        return lanAddUid;
    }

    public void setLanAddUid(String lanAddUid) {
        this.lanAddUid = lanAddUid;
    }

    public Date getLanAddDate() {
        return lanAddDate;
    }

    public void setLanAddDate(Date lanAddDate) {
        this.lanAddDate = lanAddDate;
    }

    public String getLanModUid() {
        return lanModUid;
    }

    public void setLanModUid(String lanModUid) {
        this.lanModUid = lanModUid;
    }

    public Date getLanModDate() {
        return lanModDate;
    }

    public void setLanModDate(Date lanModDate) {
        this.lanModDate = lanModDate;
    }

    @XmlTransient
    public Collection<TrjTransaction> getTrjTransactionCollection() {
        return trjTransactionCollection;
    }

    public void setTrjTransactionCollection(Collection<TrjTransaction> trjTransactionCollection) {
        this.trjTransactionCollection = trjTransactionCollection;
    }

    @XmlTransient
    public Collection<TrjTransaction> getTrjTransactionCollection1() {
        return trjTransactionCollection1;
    }

    public void setTrjTransactionCollection1(Collection<TrjTransaction> trjTransactionCollection1) {
        this.trjTransactionCollection1 = trjTransactionCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lanId != null ? lanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrjLangMast)) {
            return false;
        }
        TrjLangMast other = (TrjLangMast) object;
        if ((this.lanId == null && other.lanId != null) || (this.lanId != null && !this.lanId.equals(other.lanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TrjLangMast[ lanId=" + lanId + " ]";
    }
    
}
