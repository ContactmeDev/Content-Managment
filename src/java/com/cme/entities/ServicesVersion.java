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
@Table(name = "SERVICES_VERSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicesVersion.findAll", query = "SELECT s FROM ServicesVersion s"),
    @NamedQuery(name = "ServicesVersion.findByVerId", query = "SELECT s FROM ServicesVersion s WHERE s.verId = :verId"),
    @NamedQuery(name = "ServicesVersion.findByVerSrvCode", query = "SELECT s FROM ServicesVersion s WHERE s.verSrvCode = :verSrvCode"),
    @NamedQuery(name = "ServicesVersion.findByVerSsrvCode", query = "SELECT s FROM ServicesVersion s WHERE s.verSsrvCode = :verSsrvCode"),
    @NamedQuery(name = "ServicesVersion.findByVerType", query = "SELECT s FROM ServicesVersion s WHERE s.verType = :verType"),
    @NamedQuery(name = "ServicesVersion.findByVerNumb", query = "SELECT s FROM ServicesVersion s WHERE s.verNumb = :verNumb"),
    @NamedQuery(name = "ServicesVersion.findByVerSeq", query = "SELECT s FROM ServicesVersion s WHERE s.verSeq = :verSeq"),
    @NamedQuery(name = "ServicesVersion.findByVerCreated", query = "SELECT s FROM ServicesVersion s WHERE s.verCreated = :verCreated"),
    @NamedQuery(name = "ServicesVersion.findByVerReleased", query = "SELECT s FROM ServicesVersion s WHERE s.verReleased = :verReleased"),
    @NamedQuery(name = "ServicesVersion.findByVerStatus", query = "SELECT s FROM ServicesVersion s WHERE s.verStatus = :verStatus"),
    @NamedQuery(name = "ServicesVersion.findByVerStatusDate", query = "SELECT s FROM ServicesVersion s WHERE s.verStatusDate = :verStatusDate"),
    @NamedQuery(name = "ServicesVersion.findByVerFlex01", query = "SELECT s FROM ServicesVersion s WHERE s.verFlex01 = :verFlex01"),
    @NamedQuery(name = "ServicesVersion.findByVerFlex02", query = "SELECT s FROM ServicesVersion s WHERE s.verFlex02 = :verFlex02"),
    @NamedQuery(name = "ServicesVersion.findByVerFlex03", query = "SELECT s FROM ServicesVersion s WHERE s.verFlex03 = :verFlex03"),
    @NamedQuery(name = "ServicesVersion.findByVerFlex04", query = "SELECT s FROM ServicesVersion s WHERE s.verFlex04 = :verFlex04"),
    @NamedQuery(name = "ServicesVersion.findByVerFlex05", query = "SELECT s FROM ServicesVersion s WHERE s.verFlex05 = :verFlex05")})
public class ServicesVersion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "VER_ID")
    private String verId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "VER_SRV_CODE")
    private String verSrvCode;
    @Size(max = 30)
    @Column(name = "VER_SSRV_CODE")
    private String verSsrvCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "VER_TYPE")
    private String verType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "VER_NUMB")
    private String verNumb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VER_SEQ")
    private int verSeq;
    @Column(name = "VER_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date verCreated;
    @Column(name = "VER_RELEASED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date verReleased;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "VER_STATUS")
    private String verStatus;
    @Column(name = "VER_STATUS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date verStatusDate;
    @Size(max = 350)
    @Column(name = "VER_FLEX01")
    private String verFlex01;
    @Size(max = 350)
    @Column(name = "VER_FLEX02")
    private String verFlex02;
    @Size(max = 350)
    @Column(name = "VER_FLEX03")
    private String verFlex03;
    @Size(max = 350)
    @Column(name = "VER_FLEX04")
    private String verFlex04;
    @Size(max = 350)
    @Column(name = "VER_FLEX05")
    private String verFlex05;

    public ServicesVersion() {
    }

    public ServicesVersion(String verId) {
        this.verId = verId;
    }

    public ServicesVersion(String verId, String verSrvCode, String verType, String verNumb, int verSeq, String verStatus) {
        this.verId = verId;
        this.verSrvCode = verSrvCode;
        this.verType = verType;
        this.verNumb = verNumb;
        this.verSeq = verSeq;
        this.verStatus = verStatus;
    }

    public String getVerId() {
        return verId;
    }

    public void setVerId(String verId) {
        this.verId = verId;
    }

    public String getVerSrvCode() {
        return verSrvCode;
    }

    public void setVerSrvCode(String verSrvCode) {
        this.verSrvCode = verSrvCode;
    }

    public String getVerSsrvCode() {
        return verSsrvCode;
    }

    public void setVerSsrvCode(String verSsrvCode) {
        this.verSsrvCode = verSsrvCode;
    }

    public String getVerType() {
        return verType;
    }

    public void setVerType(String verType) {
        this.verType = verType;
    }

    public String getVerNumb() {
        return verNumb;
    }

    public void setVerNumb(String verNumb) {
        this.verNumb = verNumb;
    }

    public int getVerSeq() {
        return verSeq;
    }

    public void setVerSeq(int verSeq) {
        this.verSeq = verSeq;
    }

    public Date getVerCreated() {
        return verCreated;
    }

    public void setVerCreated(Date verCreated) {
        this.verCreated = verCreated;
    }

    public Date getVerReleased() {
        return verReleased;
    }

    public void setVerReleased(Date verReleased) {
        this.verReleased = verReleased;
    }

    public String getVerStatus() {
        return verStatus;
    }

    public void setVerStatus(String verStatus) {
        this.verStatus = verStatus;
    }

    public Date getVerStatusDate() {
        return verStatusDate;
    }

    public void setVerStatusDate(Date verStatusDate) {
        this.verStatusDate = verStatusDate;
    }

    public String getVerFlex01() {
        return verFlex01;
    }

    public void setVerFlex01(String verFlex01) {
        this.verFlex01 = verFlex01;
    }

    public String getVerFlex02() {
        return verFlex02;
    }

    public void setVerFlex02(String verFlex02) {
        this.verFlex02 = verFlex02;
    }

    public String getVerFlex03() {
        return verFlex03;
    }

    public void setVerFlex03(String verFlex03) {
        this.verFlex03 = verFlex03;
    }

    public String getVerFlex04() {
        return verFlex04;
    }

    public void setVerFlex04(String verFlex04) {
        this.verFlex04 = verFlex04;
    }

    public String getVerFlex05() {
        return verFlex05;
    }

    public void setVerFlex05(String verFlex05) {
        this.verFlex05 = verFlex05;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (verId != null ? verId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicesVersion)) {
            return false;
        }
        ServicesVersion other = (ServicesVersion) object;
        if ((this.verId == null && other.verId != null) || (this.verId != null && !this.verId.equals(other.verId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServicesVersion[ verId=" + verId + " ]";
    }
    
}
