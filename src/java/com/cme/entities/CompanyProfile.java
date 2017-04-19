/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.entities;

import java.io.Serializable;
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
@Table(name = "COMPANY_PROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompanyProfile.findAll", query = "SELECT c FROM CompanyProfile c"),
    @NamedQuery(name = "CompanyProfile.findByCompCode", query = "SELECT c FROM CompanyProfile c WHERE c.compCode = :compCode"),
    @NamedQuery(name = "CompanyProfile.findByCompName", query = "SELECT c FROM CompanyProfile c WHERE c.compName = :compName"),
    @NamedQuery(name = "CompanyProfile.findByCompNameAr", query = "SELECT c FROM CompanyProfile c WHERE c.compNameAr = :compNameAr"),
    @NamedQuery(name = "CompanyProfile.findByCompShortName", query = "SELECT c FROM CompanyProfile c WHERE c.compShortName = :compShortName"),
    @NamedQuery(name = "CompanyProfile.findByCompAddress1", query = "SELECT c FROM CompanyProfile c WHERE c.compAddress1 = :compAddress1"),
    @NamedQuery(name = "CompanyProfile.findByCompAddress2", query = "SELECT c FROM CompanyProfile c WHERE c.compAddress2 = :compAddress2"),
    @NamedQuery(name = "CompanyProfile.findByCompWebsite", query = "SELECT c FROM CompanyProfile c WHERE c.compWebsite = :compWebsite"),
    @NamedQuery(name = "CompanyProfile.findByCompEmail", query = "SELECT c FROM CompanyProfile c WHERE c.compEmail = :compEmail"),
    @NamedQuery(name = "CompanyProfile.findByCompTel1", query = "SELECT c FROM CompanyProfile c WHERE c.compTel1 = :compTel1"),
    @NamedQuery(name = "CompanyProfile.findByCompTel2", query = "SELECT c FROM CompanyProfile c WHERE c.compTel2 = :compTel2"),
    @NamedQuery(name = "CompanyProfile.findByCompMobile", query = "SELECT c FROM CompanyProfile c WHERE c.compMobile = :compMobile"),
    @NamedQuery(name = "CompanyProfile.findByCompFax", query = "SELECT c FROM CompanyProfile c WHERE c.compFax = :compFax"),
    @NamedQuery(name = "CompanyProfile.findByCompStatus", query = "SELECT c FROM CompanyProfile c WHERE c.compStatus = :compStatus")})
public class CompanyProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COMP_CODE")
    private String compCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "COMP_NAME")
    private String compName;
    @Size(max = 300)
    @Column(name = "COMP_NAME_AR")
    private String compNameAr;
    @Size(max = 100)
    @Column(name = "COMP_SHORT_NAME")
    private String compShortName;
    @Size(max = 250)
    @Column(name = "COMP_ADDRESS_1")
    private String compAddress1;
    @Size(max = 250)
    @Column(name = "COMP_ADDRESS_2")
    private String compAddress2;
    @Size(max = 100)
    @Column(name = "COMP_WEBSITE")
    private String compWebsite;
    @Size(max = 100)
    @Column(name = "COMP_EMAIL")
    private String compEmail;
    @Size(max = 20)
    @Column(name = "COMP_TEL1")
    private String compTel1;
    @Size(max = 20)
    @Column(name = "COMP_TEL2")
    private String compTel2;
    @Size(max = 100)
    @Column(name = "COMP_MOBILE")
    private String compMobile;
    @Size(max = 100)
    @Column(name = "COMP_FAX")
    private String compFax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "COMP_STATUS")
    private String compStatus;

    public CompanyProfile() {
    }

    public CompanyProfile(String compCode) {
        this.compCode = compCode;
    }

    public CompanyProfile(String compCode, String compName, String compStatus) {
        this.compCode = compCode;
        this.compName = compName;
        this.compStatus = compStatus;
    }

    public String getCompCode() {
        return compCode;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompNameAr() {
        return compNameAr;
    }

    public void setCompNameAr(String compNameAr) {
        this.compNameAr = compNameAr;
    }

    public String getCompShortName() {
        return compShortName;
    }

    public void setCompShortName(String compShortName) {
        this.compShortName = compShortName;
    }

    public String getCompAddress1() {
        return compAddress1;
    }

    public void setCompAddress1(String compAddress1) {
        this.compAddress1 = compAddress1;
    }

    public String getCompAddress2() {
        return compAddress2;
    }

    public void setCompAddress2(String compAddress2) {
        this.compAddress2 = compAddress2;
    }

    public String getCompWebsite() {
        return compWebsite;
    }

    public void setCompWebsite(String compWebsite) {
        this.compWebsite = compWebsite;
    }

    public String getCompEmail() {
        return compEmail;
    }

    public void setCompEmail(String compEmail) {
        this.compEmail = compEmail;
    }

    public String getCompTel1() {
        return compTel1;
    }

    public void setCompTel1(String compTel1) {
        this.compTel1 = compTel1;
    }

    public String getCompTel2() {
        return compTel2;
    }

    public void setCompTel2(String compTel2) {
        this.compTel2 = compTel2;
    }

    public String getCompMobile() {
        return compMobile;
    }

    public void setCompMobile(String compMobile) {
        this.compMobile = compMobile;
    }

    public String getCompFax() {
        return compFax;
    }

    public void setCompFax(String compFax) {
        this.compFax = compFax;
    }

    public String getCompStatus() {
        return compStatus;
    }

    public void setCompStatus(String compStatus) {
        this.compStatus = compStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compCode != null ? compCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyProfile)) {
            return false;
        }
        CompanyProfile other = (CompanyProfile) object;
        if ((this.compCode == null && other.compCode != null) || (this.compCode != null && !this.compCode.equals(other.compCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CompanyProfile[ compCode=" + compCode + " ]";
    }
    
}
