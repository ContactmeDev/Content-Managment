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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SUBSERVICE_MAST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubserviceMast.findAll", query = "SELECT s FROM SubserviceMast s"),
    @NamedQuery(name = "SubserviceMast.findBySsrvCode", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvCode = :ssrvCode"),
    @NamedQuery(name = "SubserviceMast.findBySsrvNameEn", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvNameEn = :ssrvNameEn"),
    @NamedQuery(name = "SubserviceMast.findBySsrvNameAr", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvNameAr = :ssrvNameAr"),
    @NamedQuery(name = "SubserviceMast.findBySsrvSubscriptionNeed", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvSubscriptionNeed = :ssrvSubscriptionNeed"),
    @NamedQuery(name = "SubserviceMast.findBySsrvSubscriptionCodeEn", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvSubscriptionCodeEn = :ssrvSubscriptionCodeEn"),
    @NamedQuery(name = "SubserviceMast.findBySsrvSubscriptionCodeAr", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvSubscriptionCodeAr = :ssrvSubscriptionCodeAr"),
    @NamedQuery(name = "SubserviceMast.findBySsrvUnsubscribeCodeEn", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvUnsubscribeCodeEn = :ssrvUnsubscribeCodeEn"),
    @NamedQuery(name = "SubserviceMast.findBySsrvUnsubscribeCodeAr", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvUnsubscribeCodeAr = :ssrvUnsubscribeCodeAr"),
    @NamedQuery(name = "SubserviceMast.findBySsrvSubService", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvSubService = :ssrvSubService"),
    @NamedQuery(name = "SubserviceMast.findBySsrvSenderId", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvSenderId = :ssrvSenderId"),
    @NamedQuery(name = "SubserviceMast.findBySsrvSenderIdDyn", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvSenderIdDyn = :ssrvSenderIdDyn"),
    @NamedQuery(name = "SubserviceMast.findBySsrvTariff", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvTariff = :ssrvTariff"),
    @NamedQuery(name = "SubserviceMast.findBySsrvNumbPageTariff", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvNumbPageTariff = :ssrvNumbPageTariff"),
    @NamedQuery(name = "SubserviceMast.findBySsrvOngoSubscriber", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvOngoSubscriber = :ssrvOngoSubscriber"),
    @NamedQuery(name = "SubserviceMast.findBySsrvOngoFrom", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvOngoFrom = :ssrvOngoFrom"),
    @NamedQuery(name = "SubserviceMast.findBySsrvCheckpoint", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvCheckpoint = :ssrvCheckpoint"),
    @NamedQuery(name = "SubserviceMast.findBySsrvStartDate", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvStartDate = :ssrvStartDate"),
    @NamedQuery(name = "SubserviceMast.findBySsrvStatus", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvStatus = :ssrvStatus"),
    @NamedQuery(name = "SubserviceMast.findBySrvAddUid", query = "SELECT s FROM SubserviceMast s WHERE s.srvAddUid = :srvAddUid"),
    @NamedQuery(name = "SubserviceMast.findBySsrvAddDate", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvAddDate = :ssrvAddDate"),
    @NamedQuery(name = "SubserviceMast.findBySsrvUpdUid", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvUpdUid = :ssrvUpdUid"),
    @NamedQuery(name = "SubserviceMast.findBySsrvUpdDate", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvUpdDate = :ssrvUpdDate"),
    @NamedQuery(name = "SubserviceMast.findBySsrvOsBased", query = "SELECT s FROM SubserviceMast s WHERE s.ssrvOsBased = :ssrvOsBased")})
public class SubserviceMast implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SSRV_CODE")
    private String ssrvCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "SSRV_NAME_EN")
    private String ssrvNameEn;
    @Size(max = 300)
    @Column(name = "SSRV_NAME_AR")
    private String ssrvNameAr;
    @Size(max = 1)
    @Column(name = "SSRV_SUBSCRIPTION_NEED")
    private String ssrvSubscriptionNeed;
    @Size(max = 30)
    @Column(name = "SSRV_SUBSCRIPTION_CODE_EN")
    private String ssrvSubscriptionCodeEn;
    @Size(max = 30)
    @Column(name = "SSRV_SUBSCRIPTION_CODE_AR")
    private String ssrvSubscriptionCodeAr;
    @Size(max = 30)
    @Column(name = "SSRV_UNSUBSCRIBE_CODE_EN")
    private String ssrvUnsubscribeCodeEn;
    @Size(max = 30)
    @Column(name = "SSRV_UNSUBSCRIBE_CODE_AR")
    private String ssrvUnsubscribeCodeAr;
    @Size(max = 1)
    @Column(name = "SSRV_SUB_SERVICE")
    private String ssrvSubService;
    @Size(max = 30)
    @Column(name = "SSRV_SENDER_ID")
    private String ssrvSenderId;
    @Size(max = 1)
    @Column(name = "SSRV_SENDER_ID_DYN")
    private String ssrvSenderIdDyn;
    @Column(name = "SSRV_TARIFF")
    private Long ssrvTariff;
    @Column(name = "SSRV_NUMB_PAGE_TARIFF")
    private Short ssrvNumbPageTariff;
    @Size(max = 1)
    @Column(name = "SSRV_ONGO_SUBSCRIBER")
    private String ssrvOngoSubscriber;
    @Size(max = 30)
    @Column(name = "SSRV_ONGO_FROM")
    private String ssrvOngoFrom;
    @Size(max = 30)
    @Column(name = "SSRV_CHECKPOINT")
    private String ssrvCheckpoint;
    @Column(name = "SSRV_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssrvStartDate;
    @Size(max = 1)
    @Column(name = "SSRV_STATUS")
    private String ssrvStatus;
    @Size(max = 30)
    @Column(name = "SRV_ADD_UID")
    private String srvAddUid;
    @Column(name = "SSRV_ADD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssrvAddDate;
    @Size(max = 30)
    @Column(name = "SSRV_UPD_UID")
    private String ssrvUpdUid;
    @Column(name = "SSRV_UPD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ssrvUpdDate;
    @Size(max = 1)
    @Column(name = "SSRV_OS_BASED")
    private String ssrvOsBased;
    @JoinColumn(name = "SSRV_SRT_CODE", referencedColumnName = "SRT_CODE")
    @ManyToOne(optional = false)
    private ServiceType ssrvSrtCode;
    @JoinColumn(name = "SSRV_SRV_CODE", referencedColumnName = "SRV_CODE")
    @ManyToOne(optional = false)
    private ServiceMast ssrvSrvCode;
    @JoinColumn(name = "SSRV_SCAT_CODE", referencedColumnName = "SCAT_CODE")
    @ManyToOne
    private ServiceCategory ssrvScatCode;
    @JoinColumn(name = "SSRV_LAN_CODE", referencedColumnName = "LAN_CODE")
    @ManyToOne
    private LanguageMast ssrvLanCode;
    @JoinColumn(name = "SSRV_CURR_CODE", referencedColumnName = "CURR_CODE")
    @ManyToOne
    private CurrencyMast ssrvCurrCode;
    @OneToMany(mappedBy = "sttSsrvCode")
    private Collection<ServiceTimetable> serviceTimetableCollection;
    @OneToMany(mappedBy = "subdSsrvCode")
    private Collection<SubscriberDetails> subscriberDetailsCollection;
//    @OneToMany(mappedBy = "srsSsrvCode")
//    private Collection<ServiceSummary> serviceSummaryCollection;
    @OneToMany(mappedBy = "swkSsrvCode")
    private Collection<ServiceWorkshop> serviceWorkshopCollection;

    public SubserviceMast() {
    }

    public SubserviceMast(String ssrvCode) {
        this.ssrvCode = ssrvCode;
    }

    public SubserviceMast(String ssrvCode, String ssrvNameEn) {
        this.ssrvCode = ssrvCode;
        this.ssrvNameEn = ssrvNameEn;
    }

    public String getSsrvCode() {
        return ssrvCode;
    }

    public void setSsrvCode(String ssrvCode) {
        this.ssrvCode = ssrvCode;
    }

    public String getSsrvNameEn() {
        return ssrvNameEn;
    }

    public void setSsrvNameEn(String ssrvNameEn) {
        this.ssrvNameEn = ssrvNameEn;
    }

    public String getSsrvNameAr() {
        return ssrvNameAr;
    }

    public void setSsrvNameAr(String ssrvNameAr) {
        this.ssrvNameAr = ssrvNameAr;
    }

    public String getSsrvSubscriptionNeed() {
        return ssrvSubscriptionNeed;
    }

    public void setSsrvSubscriptionNeed(String ssrvSubscriptionNeed) {
        this.ssrvSubscriptionNeed = ssrvSubscriptionNeed;
    }

    public String getSsrvSubscriptionCodeEn() {
        return ssrvSubscriptionCodeEn;
    }

    public void setSsrvSubscriptionCodeEn(String ssrvSubscriptionCodeEn) {
        this.ssrvSubscriptionCodeEn = ssrvSubscriptionCodeEn;
    }

    public String getSsrvSubscriptionCodeAr() {
        return ssrvSubscriptionCodeAr;
    }

    public void setSsrvSubscriptionCodeAr(String ssrvSubscriptionCodeAr) {
        this.ssrvSubscriptionCodeAr = ssrvSubscriptionCodeAr;
    }

    public String getSsrvUnsubscribeCodeEn() {
        return ssrvUnsubscribeCodeEn;
    }

    public void setSsrvUnsubscribeCodeEn(String ssrvUnsubscribeCodeEn) {
        this.ssrvUnsubscribeCodeEn = ssrvUnsubscribeCodeEn;
    }

    public String getSsrvUnsubscribeCodeAr() {
        return ssrvUnsubscribeCodeAr;
    }

    public void setSsrvUnsubscribeCodeAr(String ssrvUnsubscribeCodeAr) {
        this.ssrvUnsubscribeCodeAr = ssrvUnsubscribeCodeAr;
    }

    public String getSsrvSubService() {
        return ssrvSubService;
    }

    public void setSsrvSubService(String ssrvSubService) {
        this.ssrvSubService = ssrvSubService;
    }

    public String getSsrvSenderId() {
        return ssrvSenderId;
    }

    public void setSsrvSenderId(String ssrvSenderId) {
        this.ssrvSenderId = ssrvSenderId;
    }

    public String getSsrvSenderIdDyn() {
        return ssrvSenderIdDyn;
    }

    public void setSsrvSenderIdDyn(String ssrvSenderIdDyn) {
        this.ssrvSenderIdDyn = ssrvSenderIdDyn;
    }

    public Long getSsrvTariff() {
        return ssrvTariff;
    }

    public void setSsrvTariff(Long ssrvTariff) {
        this.ssrvTariff = ssrvTariff;
    }

    public Short getSsrvNumbPageTariff() {
        return ssrvNumbPageTariff;
    }

    public void setSsrvNumbPageTariff(Short ssrvNumbPageTariff) {
        this.ssrvNumbPageTariff = ssrvNumbPageTariff;
    }

    public String getSsrvOngoSubscriber() {
        return ssrvOngoSubscriber;
    }

    public void setSsrvOngoSubscriber(String ssrvOngoSubscriber) {
        this.ssrvOngoSubscriber = ssrvOngoSubscriber;
    }

    public String getSsrvOngoFrom() {
        return ssrvOngoFrom;
    }

    public void setSsrvOngoFrom(String ssrvOngoFrom) {
        this.ssrvOngoFrom = ssrvOngoFrom;
    }

    public String getSsrvCheckpoint() {
        return ssrvCheckpoint;
    }

    public void setSsrvCheckpoint(String ssrvCheckpoint) {
        this.ssrvCheckpoint = ssrvCheckpoint;
    }

    public Date getSsrvStartDate() {
        return ssrvStartDate;
    }

    public void setSsrvStartDate(Date ssrvStartDate) {
        this.ssrvStartDate = ssrvStartDate;
    }

    public String getSsrvStatus() {
        return ssrvStatus;
    }

    public void setSsrvStatus(String ssrvStatus) {
        this.ssrvStatus = ssrvStatus;
    }

    public String getSrvAddUid() {
        return srvAddUid;
    }

    public void setSrvAddUid(String srvAddUid) {
        this.srvAddUid = srvAddUid;
    }

    public Date getSsrvAddDate() {
        return ssrvAddDate;
    }

    public void setSsrvAddDate(Date ssrvAddDate) {
        this.ssrvAddDate = ssrvAddDate;
    }

    public String getSsrvUpdUid() {
        return ssrvUpdUid;
    }

    public void setSsrvUpdUid(String ssrvUpdUid) {
        this.ssrvUpdUid = ssrvUpdUid;
    }

    public Date getSsrvUpdDate() {
        return ssrvUpdDate;
    }

    public void setSsrvUpdDate(Date ssrvUpdDate) {
        this.ssrvUpdDate = ssrvUpdDate;
    }

    public String getSsrvOsBased() {
        return ssrvOsBased;
    }

    public void setSsrvOsBased(String ssrvOsBased) {
        this.ssrvOsBased = ssrvOsBased;
    }

    public ServiceType getSsrvSrtCode() {
        return ssrvSrtCode;
    }

    public void setSsrvSrtCode(ServiceType ssrvSrtCode) {
        this.ssrvSrtCode = ssrvSrtCode;
    }

    public ServiceMast getSsrvSrvCode() {
        return ssrvSrvCode;
    }

    public void setSsrvSrvCode(ServiceMast ssrvSrvCode) {
        this.ssrvSrvCode = ssrvSrvCode;
    }

    public ServiceCategory getSsrvScatCode() {
        return ssrvScatCode;
    }

    public void setSsrvScatCode(ServiceCategory ssrvScatCode) {
        this.ssrvScatCode = ssrvScatCode;
    }

    public LanguageMast getSsrvLanCode() {
        return ssrvLanCode;
    }

    public void setSsrvLanCode(LanguageMast ssrvLanCode) {
        this.ssrvLanCode = ssrvLanCode;
    }

    public CurrencyMast getSsrvCurrCode() {
        return ssrvCurrCode;
    }

    public void setSsrvCurrCode(CurrencyMast ssrvCurrCode) {
        this.ssrvCurrCode = ssrvCurrCode;
    }

    @XmlTransient
    public Collection<ServiceTimetable> getServiceTimetableCollection() {
        return serviceTimetableCollection;
    }

    public void setServiceTimetableCollection(Collection<ServiceTimetable> serviceTimetableCollection) {
        this.serviceTimetableCollection = serviceTimetableCollection;
    }

    @XmlTransient
    public Collection<SubscriberDetails> getSubscriberDetailsCollection() {
        return subscriberDetailsCollection;
    }

    public void setSubscriberDetailsCollection(Collection<SubscriberDetails> subscriberDetailsCollection) {
        this.subscriberDetailsCollection = subscriberDetailsCollection;
    }

//    @XmlTransient
//    public Collection<ServiceSummary> getServiceSummaryCollection() {
//        return serviceSummaryCollection;
//    }
//
//    public void setServiceSummaryCollection(Collection<ServiceSummary> serviceSummaryCollection) {
//        this.serviceSummaryCollection = serviceSummaryCollection;
//    }

    @XmlTransient
    public Collection<ServiceWorkshop> getServiceWorkshopCollection() {
        return serviceWorkshopCollection;
    }

    public void setServiceWorkshopCollection(Collection<ServiceWorkshop> serviceWorkshopCollection) {
        this.serviceWorkshopCollection = serviceWorkshopCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssrvCode != null ? ssrvCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubserviceMast)) {
            return false;
        }
        SubserviceMast other = (SubserviceMast) object;
        if ((this.ssrvCode == null && other.ssrvCode != null) || (this.ssrvCode != null && !this.ssrvCode.equals(other.ssrvCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SubserviceMast[ ssrvCode=" + ssrvCode + " ]";
    }
    
}
