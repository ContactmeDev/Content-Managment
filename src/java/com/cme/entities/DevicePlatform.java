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
@Table(name = "DEVICE_PLATFORM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DevicePlatform.findAll", query = "SELECT d FROM DevicePlatform d"),
    @NamedQuery(name = "DevicePlatform.findByOsId", query = "SELECT d FROM DevicePlatform d WHERE d.osId = :osId"),
    @NamedQuery(name = "DevicePlatform.findByOsName", query = "SELECT d FROM DevicePlatform d WHERE d.osName = :osName"),
    @NamedQuery(name = "DevicePlatform.findByOsVersion", query = "SELECT d FROM DevicePlatform d WHERE d.osVersion = :osVersion"),
    @NamedQuery(name = "DevicePlatform.findByOsStatus", query = "SELECT d FROM DevicePlatform d WHERE d.osStatus = :osStatus")})
public class DevicePlatform implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "OS_ID")
    private String osId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "OS_NAME")
    private String osName;
    @Size(max = 20)
    @Column(name = "OS_VERSION")
    private String osVersion;
    @Size(max = 10)
    @Column(name = "OS_STATUS")
    private String osStatus;

    public DevicePlatform() {
    }

    public DevicePlatform(String osId) {
        this.osId = osId;
    }

    public DevicePlatform(String osId, String osName) {
        this.osId = osId;
        this.osName = osName;
    }

    public String getOsId() {
        return osId;
    }

    public void setOsId(String osId) {
        this.osId = osId;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsStatus() {
        return osStatus;
    }

    public void setOsStatus(String osStatus) {
        this.osStatus = osStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (osId != null ? osId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DevicePlatform)) {
            return false;
        }
        DevicePlatform other = (DevicePlatform) object;
        if ((this.osId == null && other.osId != null) || (this.osId != null && !this.osId.equals(other.osId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DevicePlatform[ osId=" + osId + " ]";
    }
    
}
