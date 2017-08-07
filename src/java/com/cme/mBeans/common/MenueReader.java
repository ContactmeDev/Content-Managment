/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cme.mBeans.common;

import java.awt.MenuItem;
import java.io.File;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.richfaces.event.ItemChangeEvent;
import org.richfaces.component.UIPanelMenuGroup;
import org.richfaces.component.UIPanelMenuItem;


/**
 *
 * @author mustafaahmed
 */
@ManagedBean
@SessionScoped
public class MenueReader implements Serializable{

 
    File file;
    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;
    NodeList nodeLst;
    String path =  ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/resources/");
    String menuFileName = path+"/xml/MENU_VIEW.xml";
    boolean isSelected;
    private String menueCode, menueItemCode, menuTreeName; 
    /** Creates a new instance of XMLReader */
    public MenueReader() {
        try{
            
        isSelected = false;
        menueCode = ""; 
        menueItemCode = "";
        file = new File(menuFileName);
        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        doc = db.parse(file);
        doc.getDocumentElement().normalize();
        }catch(Exception e){
            
            e.printStackTrace();}
    }
    
    /** Creates a new instance of XMLReader */
    public MenueReader(String filename) throws Exception{
        isSelected = false;
        menueCode = ""; 
        menueItemCode = "";
        file = new File(filename);
        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        doc = db.parse(file);
        doc.getDocumentElement().normalize();
    }
    
    public String getXMLValue(String  tagname, String subtagname)
    {
        String returnValue="";
        nodeLst = doc.getElementsByTagName(tagname);

        Node fstNode = nodeLst.item(0);
        
        if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
              Element fstElmnt = (Element) fstNode;
              NodeList fstNmElmntLst = fstElmnt.getElementsByTagName(subtagname);
              Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
              NodeList fstNm = fstNmElmnt.getChildNodes();
              returnValue =  ((Node) fstNm.item(0)).getNodeValue();

        }
        else
        {
            returnValue = "NOT FOUND";
        }
        return returnValue;
    }
    
    public String getMenuTitle(String tag, String lang)
    {
        String title = "...";
        String subTag = "";

        if (lang.equals("LTR"))
            subTag = "MIT_ITEM_NAME_EN";
        else
            subTag = "MIT_ITEM_NAME_AR";
        
        title = this.getXMLValue(tag, subTag);
        
        return title;
    }
    
    public int getMenuLevel(String tag){
        int level = 0;
        String subTag = "MIT_LEVEL";
        
        level = Integer.parseInt(this.getXMLValue(tag, subTag));
        
        return level;
        
    }
    
    public boolean isMenuItemSelected()
    {
        return isSelected;
    }
    
//    public void submit()
//    {System.out.println("submit out");
//        if (menueCode.isEmpty() || menueCode.equals(""))
//        {
//            System.out.println("submit in");
//        }
//    }
    
    public void selectMenuItem(ItemChangeEvent event)
    {
        isSelected = true;
        menueCode = event.getNewItemName();
        
        UIPanelMenuItem selectedMenu = (UIPanelMenuItem)event.getNewItem();
        UIPanelMenuGroup menuGroup = (UIPanelMenuGroup)event.getNewItem().getParent();
        menuTreeName = selectedMenu.getLabel();
        int menuLevel = getMenuLevel(menueCode);
        
        for(int i=1; i <menuLevel; i++){
            menuTreeName = menuGroup.getLabel()+" \\ "+menuTreeName;
            if(!menuGroup.isTopItem())
                menuGroup = (UIPanelMenuGroup)menuGroup.getParent();
        }
        
        
    }
    
    public String getMenuSelected()
    {
        return menueCode;
    }
    
    public String getPage()
    {
        String fileName = "";
        if (menueCode.isEmpty() || menueCode.equals(""))
            fileName = getXMLValue("m4006","MIT_FILE_NAME");
        else
            fileName = getXMLValue(menueCode,"MIT_FILE_NAME");
        
        return fileName;
    }

    public String getMenuTreeName() {
        return menuTreeName;
    }

    public void setMenuTreeName(String menuTreeName) {
        this.menuTreeName = menuTreeName;
    }
    
    
       
}
