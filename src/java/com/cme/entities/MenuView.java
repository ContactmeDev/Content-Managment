/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "MENU_VIEW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuView.findAll", query = "SELECT m FROM MenuView m "),
    @NamedQuery(name = "MenuView.findByMitLevel", query = "SELECT m FROM MenuView m WHERE m.mitLevel = :level"),
    @NamedQuery(name = "MenuView.findByMitItemNameEn", query = "SELECT m FROM MenuView m WHERE m.mitItemNameEn = :mitItemNameEn"),
    @NamedQuery(name = "MenuView.findByMitItemNameAr", query = "SELECT m FROM MenuView m WHERE m.mitItemNameAr = :mitItemNameAr"),
    @NamedQuery(name = "MenuView.findByMitId", query = "SELECT m FROM MenuView m WHERE m.mitId = :mitId"),
    @NamedQuery(name = "MenuView.findByMitMitId", query = "SELECT m FROM MenuView m WHERE m.mitMitId = :mitMitId"),
    @NamedQuery(name = "MenuView.findByMitSeq", query = "SELECT m FROM MenuView m WHERE m.mitSeq = :mitSeq"),
    @NamedQuery(name = "MenuView.findByMitItemFile", query = "SELECT m FROM MenuView m WHERE m.mitItemFile = :mitItemFile"),
    @NamedQuery(name = "MenuView.findByMitItemTarget", query = "SELECT m FROM MenuView m WHERE m.mitItemTarget = :mitItemTarget"),
    @NamedQuery(name = "MenuView.findByMitParentMenu", query = "SELECT m FROM MenuView m WHERE m.mitParentMenu = :mitParentMenu")})
public class MenuView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "MIT_LEVEL")
    private BigInteger mitLevel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "MIT_ITEM_NAME_EN")
    private String mitItemNameEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "MIT_ITEM_NAME_AR")
    private String mitItemNameAr;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MIT_ID")
    private String mitId;
    @Size(max = 30)
    @Column(name = "MIT_MIT_ID")
    private String mitMitId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MIT_SEQ")
    private int mitSeq;
    @Size(max = 500)
    @Column(name = "MIT_ITEM_FILE")
    private String mitItemFile;
    @Size(max = 50)
    @Column(name = "MIT_ITEM_TARGET")
    private String mitItemTarget;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MIT_PARENT_MENU")
    private String mitParentMenu;

    public MenuView() {
    }

    public BigInteger getLevel() {
        return mitLevel;
    }

    public void setLevel(BigInteger level) {
        this.mitLevel = level;
    }

    public String getMitItemNameEn() {
        return mitItemNameEn;
    }

    public void setMitItemNameEn(String mitItemNameEn) {
        this.mitItemNameEn = mitItemNameEn;
    }

    public String getMitItemNameAr() {
        return mitItemNameAr;
    }

    public void setMitItemNameAr(String mitItemNameAr) {
        this.mitItemNameAr = mitItemNameAr;
    }

    public String getMitId() {
        return mitId;
    }

    public void setMitId(String mitId) {
        this.mitId = mitId;
    }

    public String getMitMitId() {
        return mitMitId;
    }

    public void setMitMitId(String mitMitId) {
        this.mitMitId = mitMitId;
    }

    public int getMitSeq() {
        return mitSeq;
    }

    public void setMitSeq(int mitSeq) {
        this.mitSeq = mitSeq;
    }

    public String getMitItemFile() {
        return mitItemFile;
    }

    public void setMitItemFile(String mitItemFile) {
        this.mitItemFile = mitItemFile;
    }

    public String getMitItemTarget() {
        return mitItemTarget;
    }

    public void setMitItemTarget(String mitItemTarget) {
        this.mitItemTarget = mitItemTarget;
    }

    public String getMitParentMenu() {
        return mitParentMenu;
    }

    public void setMitParentMenu(String mitParentMenu) {
        this.mitParentMenu = mitParentMenu;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mitId != null ? mitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuView)) {
            return false;
        }
        MenuView other = (MenuView) object;
        if ((this.mitId == null && other.mitId != null) || (this.mitId != null && !this.mitId.equals(other.mitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MenuView[ mitId=" + mitId + " ]";
    }
    
}
