/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package com.cme.mBeans.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
*
* @author mustafaahmed
*/
@ManagedBean
@SessionScoped
public class LocalChanger {
    
   private static final Locale ARABIC = new Locale("ar");
   private static final Locale ENGLISH = new Locale("en");
   private static final Control UTF8CONTROL = new UTF8Control();
   private String direction;
   private Locale locale;

   /**
    * Creates a new instance of LocalChanger
    */
   public LocalChanger() {
       direction = "LTR";
       locale = ENGLISH;
   }
   
   public String arabicAction(){
       FacesContext context = FacesContext.getCurrentInstance();
       context.getViewRoot().setLocale(ARABIC);
       direction = "RTL";
       setLocale(ARABIC);
       return null;
   }
   
   public String englishAction(){
       FacesContext context = FacesContext.getCurrentInstance();
       context.getViewRoot().setLocale(Locale.ENGLISH);
       direction = "LTR";
       setLocale(ENGLISH);
       return null;
   }
   
   public String getDirection()
   {
       return direction;
   }

   public Locale getLocale() {
       return locale;
   }

   public void setLocale(Locale locale) {
       this.locale = locale;
   }
   
   
   
}

class UTF8Control extends Control {
   public ResourceBundle newBundle
       (String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
           throws IllegalAccessException, InstantiationException, IOException
   {
       String bundleName = toBundleName(baseName, locale);
       String resourceName = toResourceName(bundleName, "properties");
       ResourceBundle bundle = null;
       InputStream stream = null;
       if (reload) {
           URL url = loader.getResource(resourceName);
           if (url != null) {
               URLConnection connection = url.openConnection();
               if (connection != null) {
                   connection.setUseCaches(false);
                   stream = connection.getInputStream();
               }
           }
       } else {
           stream = loader.getResourceAsStream(resourceName);
       }
       if (stream != null) {
           try {
               // This line is changed to make it to read properties files as UTF-8.
               bundle = new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));
           } finally {
               stream.close();
           }
       }
       return bundle;
   }
}