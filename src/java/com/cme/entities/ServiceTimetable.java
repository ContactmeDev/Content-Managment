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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SERVICE_TIMETABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceTimetable.findAll", query = "SELECT s FROM ServiceTimetable s"),
    @NamedQuery(name = "ServiceTimetable.findBySttCode", query = "SELECT s FROM ServiceTimetable s WHERE s.sttCode = :sttCode"),
    @NamedQuery(name = "ServiceTimetable.findBySttScheduled", query = "SELECT s FROM ServiceTimetable s WHERE s.sttScheduled = :sttScheduled"),
    @NamedQuery(name = "ServiceTimetable.findBySttNumbPerWeek", query = "SELECT s FROM ServiceTimetable s WHERE s.sttNumbPerWeek = :sttNumbPerWeek"),
    @NamedQuery(name = "ServiceTimetable.findBySttSunday", query = "SELECT s FROM ServiceTimetable s WHERE s.sttSunday = :sttSunday"),
    @NamedQuery(name = "ServiceTimetable.findBySttSundayTime", query = "SELECT s FROM ServiceTimetable s WHERE s.sttSundayTime = :sttSundayTime"),
    @NamedQuery(name = "ServiceTimetable.findBySttMonday", query = "SELECT s FROM ServiceTimetable s WHERE s.sttMonday = :sttMonday"),
    @NamedQuery(name = "ServiceTimetable.findBySttMondayTime", query = "SELECT s FROM ServiceTimetable s WHERE s.sttMondayTime = :sttMondayTime"),
    @NamedQuery(name = "ServiceTimetable.findBySttTuesday", query = "SELECT s FROM ServiceTimetable s WHERE s.sttTuesday = :sttTuesday"),
    @NamedQuery(name = "ServiceTimetable.findBySttTuesdayTime", query = "SELECT s FROM ServiceTimetable s WHERE s.sttTuesdayTime = :sttTuesdayTime"),
    @NamedQuery(name = "ServiceTimetable.findBySttWednesday", query = "SELECT s FROM ServiceTimetable s WHERE s.sttWednesday = :sttWednesday"),
    @NamedQuery(name = "ServiceTimetable.findBySttWednesdayTime", query = "SELECT s FROM ServiceTimetable s WHERE s.sttWednesdayTime = :sttWednesdayTime"),
    @NamedQuery(name = "ServiceTimetable.findBySstThursday", query = "SELECT s FROM ServiceTimetable s WHERE s.sstThursday = :sstThursday"),
    @NamedQuery(name = "ServiceTimetable.findBySttThursdayTime", query = "SELECT s FROM ServiceTimetable s WHERE s.sttThursdayTime = :sttThursdayTime"),
    @NamedQuery(name = "ServiceTimetable.findBySttFriday", query = "SELECT s FROM ServiceTimetable s WHERE s.sttFriday = :sttFriday"),
    @NamedQuery(name = "ServiceTimetable.findBySttFridayTime", query = "SELECT s FROM ServiceTimetable s WHERE s.sttFridayTime = :sttFridayTime"),
    @NamedQuery(name = "ServiceTimetable.findBySttSaturday", query = "SELECT s FROM ServiceTimetable s WHERE s.sttSaturday = :sttSaturday"),
    @NamedQuery(name = "ServiceTimetable.findBySttSaturdayTime", query = "SELECT s FROM ServiceTimetable s WHERE s.sttSaturdayTime = :sttSaturdayTime"),
    @NamedQuery(name = "ServiceTimetable.findBySstStatus", query = "SELECT s FROM ServiceTimetable s WHERE s.sstStatus = :sstStatus")})
public class ServiceTimetable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "STT_CODE")
    private String sttCode;
    @Size(max = 1)
    @Column(name = "STT_SCHEDULED")
    private String sttScheduled;
    @Column(name = "STT_NUMB_PER_WEEK")
    private Long sttNumbPerWeek;
    @Size(max = 1)
    @Column(name = "STT_SUNDAY")
    private String sttSunday;
    @Size(max = 10)
    @Column(name = "STT_SUNDAY_TIME")
    private String sttSundayTime;
    @Size(max = 1)
    @Column(name = "STT_MONDAY")
    private String sttMonday;
    @Size(max = 10)
    @Column(name = "STT_MONDAY_TIME")
    private String sttMondayTime;
    @Size(max = 1)
    @Column(name = "STT_TUESDAY")
    private String sttTuesday;
    @Size(max = 10)
    @Column(name = "STT_TUESDAY_TIME")
    private String sttTuesdayTime;
    @Size(max = 1)
    @Column(name = "STT_WEDNESDAY")
    private String sttWednesday;
    @Size(max = 10)
    @Column(name = "STT_WEDNESDAY_TIME")
    private String sttWednesdayTime;
    @Size(max = 1)
    @Column(name = "SST_THURSDAY")
    private String sstThursday;
    @Size(max = 10)
    @Column(name = "STT_THURSDAY_TIME")
    private String sttThursdayTime;
    @Size(max = 1)
    @Column(name = "STT_FRIDAY")
    private String sttFriday;
    @Size(max = 10)
    @Column(name = "STT_FRIDAY_TIME")
    private String sttFridayTime;
    @Size(max = 1)
    @Column(name = "STT_SATURDAY")
    private String sttSaturday;
    @Size(max = 10)
    @Column(name = "STT_SATURDAY_TIME")
    private String sttSaturdayTime;
    @Size(max = 1)
    @Column(name = "SST_STATUS")
    private String sstStatus;
    @JoinColumn(name = "STT_SSRV_CODE", referencedColumnName = "SSRV_CODE")
    @ManyToOne
    private SubserviceMast sttSsrvCode;
    @JoinColumn(name = "STT_SRV_CODE", referencedColumnName = "SRV_CODE")
    @ManyToOne
    private ServiceMast sttSrvCode;

    public ServiceTimetable() {
    }

    public ServiceTimetable(String sttCode) {
        this.sttCode = sttCode;
    }

    public String getSttCode() {
        return sttCode;
    }

    public void setSttCode(String sttCode) {
        this.sttCode = sttCode;
    }

    public String getSttScheduled() {
        return sttScheduled;
    }

    public void setSttScheduled(String sttScheduled) {
        this.sttScheduled = sttScheduled;
    }

    public Long getSttNumbPerWeek() {
        return sttNumbPerWeek;
    }

    public void setSttNumbPerWeek(Long sttNumbPerWeek) {
        this.sttNumbPerWeek = sttNumbPerWeek;
    }

    public String getSttSunday() {
        return sttSunday;
    }

    public void setSttSunday(String sttSunday) {
        this.sttSunday = sttSunday;
    }

    public String getSttSundayTime() {
        return sttSundayTime;
    }

    public void setSttSundayTime(String sttSundayTime) {
        this.sttSundayTime = sttSundayTime;
    }

    public String getSttMonday() {
        return sttMonday;
    }

    public void setSttMonday(String sttMonday) {
        this.sttMonday = sttMonday;
    }

    public String getSttMondayTime() {
        return sttMondayTime;
    }

    public void setSttMondayTime(String sttMondayTime) {
        this.sttMondayTime = sttMondayTime;
    }

    public String getSttTuesday() {
        return sttTuesday;
    }

    public void setSttTuesday(String sttTuesday) {
        this.sttTuesday = sttTuesday;
    }

    public String getSttTuesdayTime() {
        return sttTuesdayTime;
    }

    public void setSttTuesdayTime(String sttTuesdayTime) {
        this.sttTuesdayTime = sttTuesdayTime;
    }

    public String getSttWednesday() {
        return sttWednesday;
    }

    public void setSttWednesday(String sttWednesday) {
        this.sttWednesday = sttWednesday;
    }

    public String getSttWednesdayTime() {
        return sttWednesdayTime;
    }

    public void setSttWednesdayTime(String sttWednesdayTime) {
        this.sttWednesdayTime = sttWednesdayTime;
    }

    public String getSstThursday() {
        return sstThursday;
    }

    public void setSstThursday(String sstThursday) {
        this.sstThursday = sstThursday;
    }

    public String getSttThursdayTime() {
        return sttThursdayTime;
    }

    public void setSttThursdayTime(String sttThursdayTime) {
        this.sttThursdayTime = sttThursdayTime;
    }

    public String getSttFriday() {
        return sttFriday;
    }

    public void setSttFriday(String sttFriday) {
        this.sttFriday = sttFriday;
    }

    public String getSttFridayTime() {
        return sttFridayTime;
    }

    public void setSttFridayTime(String sttFridayTime) {
        this.sttFridayTime = sttFridayTime;
    }

    public String getSttSaturday() {
        return sttSaturday;
    }

    public void setSttSaturday(String sttSaturday) {
        this.sttSaturday = sttSaturday;
    }

    public String getSttSaturdayTime() {
        return sttSaturdayTime;
    }

    public void setSttSaturdayTime(String sttSaturdayTime) {
        this.sttSaturdayTime = sttSaturdayTime;
    }

    public String getSstStatus() {
        return sstStatus;
    }

    public void setSstStatus(String sstStatus) {
        this.sstStatus = sstStatus;
    }

    public SubserviceMast getSttSsrvCode() {
        return sttSsrvCode;
    }

    public void setSttSsrvCode(SubserviceMast sttSsrvCode) {
        this.sttSsrvCode = sttSsrvCode;
    }

    public ServiceMast getSttSrvCode() {
        return sttSrvCode;
    }

    public void setSttSrvCode(ServiceMast sttSrvCode) {
        this.sttSrvCode = sttSrvCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sttCode != null ? sttCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceTimetable)) {
            return false;
        }
        ServiceTimetable other = (ServiceTimetable) object;
        if ((this.sttCode == null && other.sttCode != null) || (this.sttCode != null && !this.sttCode.equals(other.sttCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceTimetable[ sttCode=" + sttCode + " ]";
    }
    
}
