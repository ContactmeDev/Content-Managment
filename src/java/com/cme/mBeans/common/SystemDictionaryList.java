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
    
    private static Map<String, String> languageStatus;
    static{
        languageStatus = new LinkedHashMap<String, String>();
        languageStatus.put("A", "Active");
        languageStatus.put("N", "Not Active");
        languageStatus.put("D", "Deleted");
    }
    
     private static Map<String, String> versionStatus;
    static{
        versionStatus = new LinkedHashMap<String, String>();
        versionStatus.put("A", "Active");
        versionStatus.put("N", "Not Active");
        versionStatus.put("D", "Deleted");
    }
    
       private static Map<String, String> osStatus;
    static{
        osStatus = new LinkedHashMap<String, String>();
        osStatus.put("A", "Active");
        osStatus.put("N", "Not Active");
        osStatus.put("D", "Deleted");
    }
       private static Map<String, String> versionDetailStatus;
    static{
        versionDetailStatus = new LinkedHashMap<String, String>();
        versionDetailStatus.put("A", "Active");
        versionDetailStatus.put("N", "Not Active");
        versionDetailStatus.put("D", "Deleted");
    }
     public String getVersionDetailStatus(String key){
        String name = key;
        if(versionDetailStatus.containsKey(key)){
            name = versionDetailStatus.get(key);
        }
        return name;
    }
    
      public String getVersionStatus(String key){
        String name = key;
        if(versionStatus.containsKey(key)){
            name = versionStatus.get(key);
        }
        return name;
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
    
       private static Map<String, String> categoryStatus;
    static{
        categoryStatus = new LinkedHashMap<String, String>();
        categoryStatus.put("A", "Active");
        categoryStatus.put("N", "Not Active");
        categoryStatus.put("D", "Deleted");
    }

       public String getCategoryStatusName(String key){
        String name = key;
        if(categoryStatus.containsKey(key)){
            name = categoryStatus.get(key);
        }
        return name;
    }
       
          private static Map<String, String> categoryPriority;
    static{
        categoryPriority = new LinkedHashMap<String, String>();
        categoryPriority.put("HIGH", "HIGH");
        categoryPriority.put("NORMAL", "NORMAL");
        
    }

     public String getCatPriority(String key){
        String name = key;
        if(categoryPriority.containsKey(key)){
            name = categoryPriority.get(key);
        }
        return name;
    }
    
       
          private static Map<String, String> status;
    static{
        status = new LinkedHashMap<String, String>();
        status.put("N", "Not Active");
        status.put("A", "Active ");
        
    }

     public String getAllStatus(String key){
        String name = key;
        if(status.containsKey(key)){
            name = status.get(key);
        }
        return name;
    }
    
    
    

    /**
     * Creates a new instance of SystemDictionaryList
     */
    public SystemDictionaryList() {
    }
    
}
