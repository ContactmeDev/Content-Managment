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
    
    

    /**
     * Creates a new instance of SystemDictionaryList
     */
    public SystemDictionaryList() {
    }
    
}
