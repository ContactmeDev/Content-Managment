/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "SERVICE_MAST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceMast.findAll", query = "SELECT s FROM ServiceMast s"),
    @NamedQuery(name = "ServiceMast.findBySrvCode", query = "SELECT s FROM ServiceMast s WHERE s.srvCode = :srvCode"),
    @NamedQuery(name = "ServiceMast.findBySrvNameEn", query = "SELECT s FROM ServiceMast s WHERE s.srvNameEn = :srvNameEn"),
    @NamedQuery(name = "ServiceMast.findBySrvNameAr", query = "SELECT s FROM ServiceMast s WHERE s.srvNameAr = :srvNameAr"),
    @NamedQuery(name = "ServiceMast.findBySrvShortCode", query = "SELECT s FROM ServiceMast s WHERE s.srvShortCode = :srvShortCode"),
    @NamedQuery(name = "ServiceMast.findBySrvPrefName", query = "SELECT s FROM ServiceMast s WHERE s.srvPrefName = :srvPrefName"),
    @NamedQuery(name = "ServiceMast.findBySrvSubscriptionNeed", query = "SELECT s FROM ServiceMast s WHERE s.srvSubscriptionNeed = :srvSubscriptionNeed"),
    @NamedQuery(name = "ServiceMast.findBySrvSubscriptionCodeEn", query = "SELECT s FROM ServiceMast s WHERE s.srvSubscriptionCodeEn = :srvSubscriptionCodeEn"),
    @NamedQuery(name = "ServiceMast.findBySrvSubscriptionCodeAr", query = "SELECT s FROM ServiceMast s WHERE s.srvSubscriptionCodeAr = :srvSubscriptionCodeAr"),
    @NamedQuery(name = "ServiceMast.findBySrvUnsubscribeCodeEn", query = "SELECT s FROM ServiceMast s WHERE s.srvUnsubscribeCodeEn = :srvUnsubscribeCodeEn"),
    @NamedQuery(name = "ServiceMast.findBySrvUnsubscribeCodeAr", query = "SELECT s FROM ServiceMast s WHERE s.srvUnsubscribeCodeAr = :srvUnsubscribeCodeAr"),
    @NamedQuery(name = "ServiceMast.findBySrvSubService", query = "SELECT s FROM ServiceMast s WHERE s.srvSubService = :srvSubService"),
    @NamedQuery(name = "ServiceMast.findBySrvSenderId", query = "SELECT s FROM ServiceMast s WHERE s.srvSenderId = :srvSenderId"),
    @NamedQuery(name = "ServiceMast.findBySrvSenderIdDyn", query = "SELECT s FROM ServiceMast s WHERE s.srvSenderIdDyn = :srvSenderIdDyn"),
    @NamedQuery(name = "ServiceMast.findBySrvTariff", query = "SELECT s FROM ServiceMast s WHERE s.srvTariff = :srvTariff"),
    @NamedQuery(name = "ServiceMast.findBySrvNumbPageTariff", query = "SELECT s FROM ServiceMast s WHERE s.srvNumbPageTariff = :srvNumbPageTariff"),
    @NamedQuery(name = "ServiceMast.findBySrvOngoSubscriber", query = "SELECT s FROM ServiceMast s WHERE s.srvOngoSubscriber = :srvOngoSubscriber"),
    @NamedQuery(name = "ServiceMast.findBySrvOngoFrom", query = "SELECT s FROM ServiceMast s WHERE s.srvOngoFrom = :srvOngoFrom"),
    @NamedQuery(name = "ServiceMast.findBySrvCheckpoint", query = "SELECT s FROM ServiceMast s WHERE s.srvCheckpoint = :srvCheckpoint"),
    @NamedQuery(name = "ServiceMast.findBySrvStartDate", query = "SELECT s FROM ServiceMast s WHERE s.srvStartDate = :srvStartDate"),
    @NamedQuery(name = "ServiceMast.findBySrvStatus", query = "SELECT s FROM ServiceMast s WHERE s.srvStatus = :srvStatus"),
    @NamedQuery(name = "ServiceMast.findBySrvAddUid", query = "SELECT s FROM ServiceMast s WHERE s.srvAddUid = :srvAddUid"),
    @NamedQuery(name = "ServiceMast.findBySrvAddDate", query = "SELECT s FROM ServiceMast s WHERE s.srvAddDate = :srvAddDate"),
    @NamedQuery(name = "ServiceMast.findBySrvUpdUid", query = "SELECT s FROM ServiceMast s WHERE s.srvUpdUid = :srvUpdUid"),
    @NamedQuery(name = "ServiceMast.findBySrvUpdDate", query = "SELECT s FROM ServiceMast s WHERE s.srvUpdDate = :srvUpdDate"),
    @NamedQuery(name = "ServiceMast.findBySrvFlex01", query = "SELECT s FROM ServiceMast s WHERE s.srvFlex01 = :srvFlex01"),
    @NamedQuery(name = "ServiceMast.findBySrvFlex02", query = "SELECT s FROM ServiceMast s WHERE s.srvFlex02 = :srvFlex02"),
    @NamedQuery(name = "ServiceMast.findBySrvFlex03", query = "SELECT s FROM ServiceMast s WHERE s.srvFlex03 = :srvFlex03"),
    @NamedQuery(name = "ServiceMast.findBySrvFlex04", query = "SELECT s FROM ServiceMast s WHERE s.srvFlex04 = :srvFlex04"),
    @NamedQuery(name = "ServiceMast.findBySrvFlex05", query = "SELECT s FROM ServiceMast s WHERE s.srvFlex05 = :srvFlex05"),
    @NamedQuery(name = "ServiceMast.findBySrvFlex06", query = "SELECT s FROM ServiceMast s WHERE s.srvFlex06 = :srvFlex06"),
    @NamedQuery(name = "ServiceMast.findBySrvFlex07", query = "SELECT s FROM ServiceMast s WHERE s.srvFlex07 = :srvFlex07"),
    @NamedQuery(name = "ServiceMast.findBySrvFlex08", query = "SELECT s FROM ServiceMast s WHERE s.srvFlex08 = :srvFlex08"),
    @NamedQuery(name = "ServiceMast.findBySrvFlex09", query = "SELECT s FROM ServiceMast s WHERE s.srvFlex09 = :srvFlex09"),
    @NamedQuery(name = "ServiceMast.findBySrvFlex10", query = "SELECT s FROM ServiceMast s WHERE s.srvFlex10 = :srvFlex10"),
    @NamedQuery(name = "ServiceMast.findBySrvSubService", query = "SELECT s FROM ServiceMast s WHERE s.srvSubService = :srvSubService"),
    @NamedQuery(name = "ServiceMast.SMSServices", query = "SELECT s FROM ServiceMast s WHERE s.srvStatus = :srvStatus AND s.srvSrtCode = :srvSrtCode "),
    @NamedQuery(name = "ServiceMast.findBySrvMaxSendRetry", query = "SELECT s FROM ServiceMast s WHERE s.srvMaxSendRetry = :srvMaxSendRetry")})
public class ServiceMast implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SRV_CODE")
    private String srvCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "SRV_NAME_EN")
    private String srvNameEn;
    @Size(max = 300)
    @Column(name = "SRV_NAME_AR")
    private String srvNameAr;
    @Size(max = 100)
    @Column(name = "SRV_SHORT_CODE")
    private String srvShortCode;
    @Size(max = 10)
    @Column(name = "SRV_PREF_NAME")
    private String srvPrefName;
    @Size(max = 1)
    @Column(name = "SRV_SUBSCRIPTION_NEED")
    private String srvSubscriptionNeed;
    @Size(max = 30)
    @Column(name = "SRV_SUBSCRIPTION_CODE_EN")
    private String srvSubscriptionCodeEn;
    @Size(max = 30)
    @Column(name = "SRV_SUBSCRIPTION_CODE_AR")
    private String srvSubscriptionCodeAr;
    @Size(max = 30)
    @Column(name = "SRV_UNSUBSCRIBE_CODE_EN")
    private String srvUnsubscribeCodeEn;
    @Size(max = 30)
    @Column(name = "SRV_UNSUBSCRIBE_CODE_AR")
    private String srvUnsubscribeCodeAr;
    @Size(max = 1)
    @Column(name = "SRV_SUB_SERVICE")
    private String srvSubService;
    @Size(max = 30)
    @Column(name = "SRV_SENDER_ID")
    private String srvSenderId;
    @Size(max = 1)
    @Column(name = "SRV_SENDER_ID_DYN")
    private String srvSenderIdDyn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SRV_TARIFF")
    private BigDecimal srvTariff;
    @Column(name = "SRV_NUMB_PAGE_TARIFF")
    private Short srvNumbPageTariff;
    @Size(max = 1)
    @Column(name = "SRV_ONGO_SUBSCRIBER")
    private String srvOngoSubscriber;
    @Size(max = 30)
    @Column(name = "SRV_ONGO_FROM")
    private String srvOngoFrom;
    @Size(max = 30)
    @Column(name = "SRV_CHECKPOINT")
    private String srvCheckpoint;
    @Column(name = "SRV_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date srvStartDate;
    @Size(max = 1)
    @Column(name = "SRV_STATUS")
    private String srvStatus;
    @Size(max = 30)
    @Column(name = "SRV_ADD_UID")
    private String srvAddUid;
    @Column(name = "SRV_ADD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date srvAddDate;
    @Size(max = 30)
    @Column(name = "SRV_UPD_UID")
    private String srvUpdUid;
    @Column(name = "SRV_UPD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date srvUpdDate;
    @Size(max = 250)
    @Column(name = "SRV_FLEX01")
    private String srvFlex01;
    @Size(max = 250)
    @Column(name = "SRV_FLEX02")
    private String srvFlex02;
    @Size(max = 250)
    @Column(name = "SRV_FLEX03")
    private String srvFlex03;
    @Size(max = 250)
    @Column(name = "SRV_FLEX04")
    private String srvFlex04;
    @Size(max = 250)
    @Column(name = "SRV_FLEX05")
    private String srvFlex05;
    @Size(max = 250)
    @Column(name = "SRV_FLEX06")
    private String srvFlex06;
    @Size(max = 250)
    @Column(name = "SRV_FLEX07")
    private String srvFlex07;
    @Size(max = 250)
    @Column(name = "SRV_FLEX08")
    private String srvFlex08;
    @Size(max = 250)
    @Column(name = "SRV_FLEX09")
    private String srvFlex09;
    @Size(max = 250)
    @Column(name = "SRV_FLEX10")
    private String srvFlex10;
    @Column(name = "SRV_MAX_SEND_RETRY")
    private BigInteger srvMaxSendRetry;
    @Size(max = 1000)
    @Column(name = "SRV_DESC")
    private String srvDesc;
    @Size(max = 1000)
    @Column(name = "SRV_DESC_AR")
    private String srvDescAR;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ssrvSrvCode"  ,targetEntity=SubserviceMast.class)
    private Collection<SubserviceMast> subserviceMastCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sttSrvCode" ,targetEntity=ServiceTimetable.class)
    private Collection<ServiceTimetable> serviceTimetableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subdSrvCode" ,targetEntity=SubscriberDetails.class)
    private Collection<SubscriberDetails> subscriberDetailsCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "srsSrvCode")
//    private Collection<ServiceSummary> serviceSummaryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usvSrvCode" ,targetEntity=UserServiceLink.class)
    private Collection<UserServiceLink> userServiceLinkCollection;
    @JoinColumn(name = "SRV_SRT_CODE", referencedColumnName = "SRT_CODE")
    @ManyToOne(optional = false)
    private ServiceType srvSrtCode;
    @JoinColumn(name = "SRV_SCAT_CODE", referencedColumnName = "SCAT_CODE")
    @ManyToOne
    private ServiceCategory srvScatCode;
    @JoinColumn(name = "SRV_LAN_CODE", referencedColumnName = "LAN_CODE")
    @ManyToOne
    private LanguageMast srvLanCode;
    @JoinColumn(name = "SRV_CURR_CODE", referencedColumnName = "CURR_CODE")
    @ManyToOne
    private CurrencyMast srvCurrCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "srcSrvCode" ,targetEntity=ServiceConn.class)
    private Collection<ServiceConn> serviceConnCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "swkSrvCode" ,targetEntity=ServiceWorkshop.class)
    private Collection<ServiceWorkshop> serviceWorkshopCollection;

    public ServiceMast() {
    }
    

    public ServiceMast(String srvCode) {
        this.srvCode = srvCode;
    }

    public ServiceMast(String srvCode, String srvNameEn) {
        this.srvCode = srvCode;
        this.srvNameEn = srvNameEn;
    }

    public String getSrvDesc() {
        return srvDesc;
    }

    public void setSrvDesc(String srvDesc) {
        this.srvDesc = srvDesc;
    }

    public String getSrvDescAR() {
        return srvDescAR;
    }

    public void setSrvDescAR(String srvDescAR) {
        this.srvDescAR = srvDescAR;
    }
    

    public String getSrvCode() {
        return srvCode;
    }

    public void setSrvCode(String srvCode) {
        this.srvCode = srvCode;
    }

    public String getSrvNameEn() {
        return srvNameEn;
    }

    public void setSrvNameEn(String srvNameEn) {
        this.srvNameEn = srvNameEn;
    }

    public String getSrvNameAr() {
        return srvNameAr;
    }

    public void setSrvNameAr(String srvNameAr) {
        this.srvNameAr = srvNameAr;
    }

    public String getSrvShortCode() {
        return srvShortCode;
    }

    public void setSrvShortCode(String srvShortCode) {
        this.srvShortCode = srvShortCode;
    }

    public String getSrvPrefName() {
        return srvPrefName;
    }

    public void setSrvPrefName(String srvPrefName) {
        this.srvPrefName = srvPrefName;
    }

    public String getSrvSubscriptionNeed() {
        return srvSubscriptionNeed;
    }

    public void setSrvSubscriptionNeed(String srvSubscriptionNeed) {
        this.srvSubscriptionNeed = srvSubscriptionNeed;
    }

    public String getSrvSubscriptionCodeEn() {
        return srvSubscriptionCodeEn;
    }

    public void setSrvSubscriptionCodeEn(String srvSubscriptionCodeEn) {
        this.srvSubscriptionCodeEn = srvSubscriptionCodeEn;
    }

    public String getSrvSubscriptionCodeAr() {
        return srvSubscriptionCodeAr;
    }

    public void setSrvSubscriptionCodeAr(String srvSubscriptionCodeAr) {
        this.srvSubscriptionCodeAr = srvSubscriptionCodeAr;
    }

    public String getSrvUnsubscribeCodeEn() {
        return srvUnsubscribeCodeEn;
    }

    public void setSrvUnsubscribeCodeEn(String srvUnsubscribeCodeEn) {
        this.srvUnsubscribeCodeEn = srvUnsubscribeCodeEn;
    }

    public String getSrvUnsubscribeCodeAr() {
        return srvUnsubscribeCodeAr;
    }

    public void setSrvUnsubscribeCodeAr(String srvUnsubscribeCodeAr) {
        this.srvUnsubscribeCodeAr = srvUnsubscribeCodeAr;
    }

    public String getSrvSubService() {
        return srvSubService;
    }

    public void setSrvSubService(String srvSubService) {
        this.srvSubService = srvSubService;
    }

    public String getSrvSenderId() {
        return srvSenderId;
    }

    public void setSrvSenderId(String srvSenderId) {
        this.srvSenderId = srvSenderId;
    }

    public String getSrvSenderIdDyn() {
        return srvSenderIdDyn;
    }

    public void setSrvSenderIdDyn(String srvSenderIdDyn) {
        this.srvSenderIdDyn = srvSenderIdDyn;
    }

    public BigDecimal getSrvTariff() {
        return srvTariff;
    }

    public void setSrvTariff(BigDecimal srvTariff) {
        this.srvTariff = srvTariff;
    }

    public Short getSrvNumbPageTariff() {
        return srvNumbPageTariff;
    }

    public void setSrvNumbPageTariff(Short srvNumbPageTariff) {
        this.srvNumbPageTariff = srvNumbPageTariff;
    }

    public String getSrvOngoSubscriber() {
        return srvOngoSubscriber;
    }

    public void setSrvOngoSubscriber(String srvOngoSubscriber) {
        this.srvOngoSubscriber = srvOngoSubscriber;
    }

    public String getSrvOngoFrom() {
        return srvOngoFrom;
    }

    public void setSrvOngoFrom(String srvOngoFrom) {
        this.srvOngoFrom = srvOngoFrom;
    }

    public String getSrvCheckpoint() {
        return srvCheckpoint;
    }

    public void setSrvCheckpoint(String srvCheckpoint) {
        this.srvCheckpoint = srvCheckpoint;
    }

    public Date getSrvStartDate() {
        return srvStartDate;
    }

    public void setSrvStartDate(Date srvStartDate) {
        this.srvStartDate = srvStartDate;
    }

    public String getSrvStatus() {
        return srvStatus;
    }

    public void setSrvStatus(String srvStatus) {
        this.srvStatus = srvStatus;
    }

    public String getSrvAddUid() {
        return srvAddUid;
    }

    public void setSrvAddUid(String srvAddUid) {
        this.srvAddUid = srvAddUid;
    }

    public Date getSrvAddDate() {
        return srvAddDate;
    }

    public void setSrvAddDate(Date srvAddDate) {
        this.srvAddDate = srvAddDate;
    }

    public String getSrvUpdUid() {
        return srvUpdUid;
    }

    public void setSrvUpdUid(String srvUpdUid) {
        this.srvUpdUid = srvUpdUid;
    }

    public Date getSrvUpdDate() {
        return srvUpdDate;
    }

    public void setSrvUpdDate(Date srvUpdDate) {
        this.srvUpdDate = srvUpdDate;
    }

    public String getSrvFlex01() {
        return srvFlex01;
    }

    public void setSrvFlex01(String srvFlex01) {
        this.srvFlex01 = srvFlex01;
    }

    public String getSrvFlex02() {
        return srvFlex02;
    }

    public void setSrvFlex02(String srvFlex02) {
        this.srvFlex02 = srvFlex02;
    }

    public String getSrvFlex03() {
        return srvFlex03;
    }

    public void setSrvFlex03(String srvFlex03) {
        this.srvFlex03 = srvFlex03;
    }

    public String getSrvFlex04() {
        return srvFlex04;
    }

    public void setSrvFlex04(String srvFlex04) {
        this.srvFlex04 = srvFlex04;
    }

    public String getSrvFlex05() {
        return srvFlex05;
    }

    public void setSrvFlex05(String srvFlex05) {
        this.srvFlex05 = srvFlex05;
    }

    public String getSrvFlex06() {
        return srvFlex06;
    }

    public void setSrvFlex06(String srvFlex06) {
        this.srvFlex06 = srvFlex06;
    }

    public String getSrvFlex07() {
        return srvFlex07;
    }

    public void setSrvFlex07(String srvFlex07) {
        this.srvFlex07 = srvFlex07;
    }

    public String getSrvFlex08() {
        return srvFlex08;
    }

    public void setSrvFlex08(String srvFlex08) {
        this.srvFlex08 = srvFlex08;
    }

    public String getSrvFlex09() {
        return srvFlex09;
    }

    public void setSrvFlex09(String srvFlex09) {
        this.srvFlex09 = srvFlex09;
    }

    public String getSrvFlex10() {
        return srvFlex10;
    }

    public void setSrvFlex10(String srvFlex10) {
        this.srvFlex10 = srvFlex10;
    }

    public LanguageMast getSrvLanCode() {
        return srvLanCode;
    }

    public void setSrvLanCode(LanguageMast srvLanCode) {
        this.srvLanCode = srvLanCode;
    }
    

    public BigInteger getSrvMaxSendRetry() {
        return srvMaxSendRetry;
    }

    public void setSrvMaxSendRetry(BigInteger srvMaxSendRetry) {
        this.srvMaxSendRetry = srvMaxSendRetry;
    }

    @XmlTransient
    public Collection<SubserviceMast> getSubserviceMastCollection() {
        return subserviceMastCollection;
    }

    public void setSubserviceMastCollection(Collection<SubserviceMast> subserviceMastCollection) {
        this.subserviceMastCollection = subserviceMastCollection;
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
    public Collection<UserServiceLink> getUserServiceLinkCollection() {
        return userServiceLinkCollection;
    }

    public void setUserServiceLinkCollection(Collection<UserServiceLink> userServiceLinkCollection) {
        this.userServiceLinkCollection = userServiceLinkCollection;
    }

    public ServiceType getSrvSrtCode() {
        return srvSrtCode;
    }

    public void setSrvSrtCode(ServiceType srvSrtCode) {
        this.srvSrtCode = srvSrtCode;
    }

    public ServiceCategory getSrvScatCode() {
        return srvScatCode;
    }

    public void setSrvScatCode(ServiceCategory srvScatCode) {
        this.srvScatCode = srvScatCode;
    }

  

    public CurrencyMast getSrvCurrCode() {
        return srvCurrCode;
    }

    public void setSrvCurrCode(CurrencyMast srvCurrCode) {
        this.srvCurrCode = srvCurrCode;
    }

   




   
   

    @XmlTransient
    public Collection<ServiceConn> getServiceConnCollection() {
        return serviceConnCollection;
    }

    public void setServiceConnCollection(Collection<ServiceConn> serviceConnCollection) {
        this.serviceConnCollection = serviceConnCollection;
    }

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
        hash += (srvCode != null ? srvCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceMast)) {
            return false;
        }
        ServiceMast other = (ServiceMast) object;
        if ((this.srvCode == null && other.srvCode != null) || (this.srvCode != null && !this.srvCode.equals(other.srvCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceMast[ srvCode=" + srvCode + " ]";
    }
    
}
