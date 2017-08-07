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
@Table(name = "MENU_ITEMS_TREE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuItemsTree.findAll", query = "SELECT m FROM MenuItemsTree m "),
    @NamedQuery(name = "MenuItemsTree.findByMitId", query = "SELECT m FROM MenuItemsTree m WHERE m.mitId = :mitId"),
    @NamedQuery(name = "MenuItemsTree.findByMitMitId", query = "SELECT m FROM MenuItemsTree m WHERE m.mitMitId = :mitMitId"),
    @NamedQuery(name = "MenuItemsTree.findByMitSeq", query = "SELECT m FROM MenuItemsTree m WHERE m.mitSeq = :mitSeq"),
    @NamedQuery(name = "MenuItemsTree.findByMitItemNameEn", query = "SELECT m FROM MenuItemsTree m WHERE m.mitItemNameEn = :mitItemNameEn"),
    @NamedQuery(name = "MenuItemsTree.findByMitItemNameAr", query = "SELECT m FROM MenuItemsTree m WHERE m.mitItemNameAr = :mitItemNameAr"),
    @NamedQuery(name = "MenuItemsTree.findByMitItemFile", query = "SELECT m FROM MenuItemsTree m WHERE m.mitItemFile = :mitItemFile"),
    @NamedQuery(name = "MenuItemsTree.findByMitItemTarget", query = "SELECT m FROM MenuItemsTree m WHERE m.mitItemTarget = :mitItemTarget"),
    @NamedQuery(name = "MenuItemsTree.findByMitItemStatus", query = "SELECT m FROM MenuItemsTree m WHERE m.mitItemStatus = :mitItemStatus"),
    @NamedQuery(name = "MenuItemsTree.findByMitParentMenu", query = "SELECT m FROM MenuItemsTree m WHERE m.mitParentMenu = :mitParentMenu"),
    @NamedQuery(name = "MenuItemsTree.findByMitAddDate", query = "SELECT m FROM MenuItemsTree m WHERE m.mitAddDate = :mitAddDate"),
    @NamedQuery(name = "MenuItemsTree.findByMitAddUid", query = "SELECT m FROM MenuItemsTree m WHERE m.mitAddUid = :mitAddUid"),
    @NamedQuery(name = "MenuItemsTree.findByMitModDate", query = "SELECT m FROM MenuItemsTree m WHERE m.mitModDate = :mitModDate"),
    @NamedQuery(name = "MenuItemsTree.findByMitModUid", query = "SELECT m FROM MenuItemsTree m WHERE m.mitModUid = :mitModUid"),
    @NamedQuery(name = "MenuItemsTree.MyMenuEnglish", query ="SELECT  m FROM MenuItemsTree m WHERE m.mitItemStatus = 'A' ")
  })
public class MenuItemsTree implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Size(max = 500)
    @Column(name = "MIT_ITEM_FILE")
    private String mitItemFile;
    @Size(max = 50)
    @Column(name = "MIT_ITEM_TARGET")
    private String mitItemTarget;
    @Size(max = 1)
    @Column(name = "MIT_ITEM_STATUS")
    private String mitItemStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MIT_PARENT_MENU")
    private String mitParentMenu;
    @Column(name = "MIT_ADD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mitAddDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MIT_ADD_UID")
    private String mitAddUid;
    @Column(name = "MIT_MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mitModDate;
    @Size(max = 30)
    @Column(name = "MIT_MOD_UID")
    private String mitModUid;

    public MenuItemsTree() {
    }

    public MenuItemsTree(String mitId) {
        this.mitId = mitId;
    }

    public MenuItemsTree(String mitId, int mitSeq, String mitItemNameEn, String mitItemNameAr, String mitParentMenu, String mitAddUid) {
        this.mitId = mitId;
        this.mitSeq = mitSeq;
        this.mitItemNameEn = mitItemNameEn;
        this.mitItemNameAr = mitItemNameAr;
        this.mitParentMenu = mitParentMenu;
        this.mitAddUid = mitAddUid;
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

    public String getMitItemStatus() {
        return mitItemStatus;
    }

    public void setMitItemStatus(String mitItemStatus) {
        this.mitItemStatus = mitItemStatus;
    }

    public String getMitParentMenu() {
        return mitParentMenu;
    }

    public void setMitParentMenu(String mitParentMenu) {
        this.mitParentMenu = mitParentMenu;
    }

    public Date getMitAddDate() {
        return mitAddDate;
    }

    public void setMitAddDate(Date mitAddDate) {
        this.mitAddDate = mitAddDate;
    }

    public String getMitAddUid() {
        return mitAddUid;
    }

    public void setMitAddUid(String mitAddUid) {
        this.mitAddUid = mitAddUid;
    }

    public Date getMitModDate() {
        return mitModDate;
    }

    public void setMitModDate(Date mitModDate) {
        this.mitModDate = mitModDate;
    }

    public String getMitModUid() {
        return mitModUid;
    }

    public void setMitModUid(String mitModUid) {
        this.mitModUid = mitModUid;
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
        if (!(object instanceof MenuItemsTree)) {
            return false;
        }
        MenuItemsTree other = (MenuItemsTree) object;
        if ((this.mitId == null && other.mitId != null) || (this.mitId != null && !this.mitId.equals(other.mitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MenuItemsTree[ mitId=" + mitId + " ]";
    }
    
}
