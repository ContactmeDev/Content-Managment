/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans.common;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mustafaahmed
 */
@ManagedBean(name = "dictionaryList")
@SessionScoped
public class SystemDictionaryList {
    
    private int number= 5;
    
    private static Map<String, String> languageStatus;
    static{
        languageStatus = new LinkedHashMap<String, String>();
        languageStatus.put("A", "Active");
        languageStatus.put("N", "Not Active");
        languageStatus.put("D", "Deleted");
    }
    
      private static Map<String, String> currencyStatus;
    static{
       currencyStatus = new LinkedHashMap<String, String>();
        currencyStatus.put("A", "Active");
        currencyStatus.put("N", "Not Active");
        currencyStatus.put("D", "Deleted");
    }
    
       private static Map<String, String> serviceTypeStatus;
    static{
       serviceTypeStatus = new LinkedHashMap<String, String>();
        serviceTypeStatus.put("A", "Active");
        serviceTypeStatus.put("N", "Not Active");
        serviceTypeStatus.put("D", "Deleted");
    }
    
   
        private static Map<String, String> serviceStatus;
    static{
       serviceStatus = new LinkedHashMap<String, String>();
        serviceStatus.put("A", "Active");
        serviceStatus.put("N", "Not Active");
        serviceStatus.put("D", "Deleted");
    }
    
       private static Map<String, String> subserviceStatus;
    static{
       subserviceStatus = new LinkedHashMap<String, String>();
        subserviceStatus.put("A", "Active");
        subserviceStatus.put("N", "Not Active");
        subserviceStatus.put("D", "Deleted");
    }
    
    private static Map<String, String> AppsUStatus;
    static{
        AppsUStatus = new LinkedHashMap<String, String>();
        AppsUStatus.put("A", "Active");
        AppsUStatus.put("N", "Not Active");
        AppsUStatus.put("D", "Deleted");
    }
    
    private static Map<String, String> ServiceTextStatus;
    static{
        ServiceTextStatus = new LinkedHashMap<String, String>();
        ServiceTextStatus.put("A", "Active");
        ServiceTextStatus.put("N", "Not Active");
        ServiceTextStatus.put("D", "Deleted");
    }
    
    private static Map<String, String> WorkshopStatus;
    static{
        WorkshopStatus = new LinkedHashMap<String, String>();
        WorkshopStatus.put("A", "Approved");
        WorkshopStatus.put("N", "Not Approved");
        WorkshopStatus.put("D", "Deleted");
        
    }
    
    private static Map<String, String> serviceSubIndicator;
    static {
        serviceSubIndicator = new LinkedHashMap<String, String>();
        serviceSubIndicator.put("Y", "Have Sub services");
        serviceSubIndicator.put("N", "Has no sub service");
    }
    
    
    public String getLanguageStatusName(String key){
        String name = key;
        if(languageStatus.containsKey(key)){
            name = languageStatus.get(key);
        }
        return name;
    }
      
    public String getCurrencyStatusName(String key){
        String name = key;
        if(currencyStatus.containsKey(key)){
            name = currencyStatus.get(key);
        }
        return name;
    }
    
     public String getServiceTypeStatusName(String key){
        String name = key;
        if(serviceTypeStatus.containsKey(key)){
            name = serviceTypeStatus.get(key);
        }
        return name;
    }
    
   public String getServiceStatusName(String key){
        String name = key;
        if(serviceStatus.containsKey(key)){
            name = serviceStatus.get(key);
        }
        return name;
    }
   
    public String getSubServiceStatusName(String key){
        String name = key;
        if(subserviceStatus.containsKey(key)){
            name = subserviceStatus.get(key);
        }
        return name;
    }
    
    public String getAppsUStatusName(String key){
        String name = key;
        if(AppsUStatus.containsKey(key)){
            name = AppsUStatus.get(key);
        }
        return name;
    }
    
    public String getWorkshopStatusName(String key){
        String name = key;
        if(WorkshopStatus.containsKey(key)){
            name = WorkshopStatus.get(key);
        }
        return name;
    }
    
    public String getServiceTextName(String key){
        String name = key;
        if(ServiceTextStatus.containsKey(key)){
            name = ServiceTextStatus.get(key);
        }
        return name;
    } 

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    

    /**
     * Creates a new instance of SystemDictionaryList
     */
    public SystemDictionaryList() {
    }
    
}
