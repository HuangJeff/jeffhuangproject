/**
 * 
 */
package com.nurse.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author test
 * 處理XML File
 */
public class ReadXmlFiles {
	
	/**
	 * 
	 */
	public ReadXmlFiles() {
		
	}
	
	/**
	 * 載入XML資訊
	 */
	public void preLoadXmlData() throws Exception {
		String xmlFileStr = "D:\\My Personal Workspace\\jeffhuangproject\\myWorkspace\\proj02\\NurseFormClient\\data\\xml\\NISEV001.xml";
		xmlFileStr = "data\\xml\\NISEV004.xml";
		xmlFileStr = "data\\xml\\";
		File xmlFile = new File(xmlFileStr);
		System.out.println("xmlFile.exists()==>" + xmlFile.exists());
		System.out.println("xmlFile.isDirectory()==>" + xmlFile.isDirectory());
		File tmpFile = null;
		if(xmlFile.isDirectory()) {
			//String[] sa = xmlFile.list(); //檔名Array
			//System.out.println("xmlFile.list()==>" + sa);
			for(File f : xmlFile.listFiles()) {
				if(f.getName().equals("NISEV001-1.xml")) { //先測一支檔案
					tmpFile = f;
					break;
				}
			}
		}
		System.out.println("FileName==>" + tmpFile.getName());
		
		Document document = this.getDocumentFromFile(tmpFile);
		
		Element docSingle = this.getElementFromType(
				document.getRootElement(), "single");
		
		ArrayList iay = this.getAllItemData(docSingle, new ArrayList(), "root");
		System.out.println("iay::" + iay);
		
		for(int i=0;i<iay.size();i++) {
			//資料
            String item_id = 	(String)((HashMap)iay.get(i)).get("id");
            String item_name = 	(String)((HashMap)iay.get(i)).get("title");
            String item_type = 	(String)((HashMap)iay.get(i)).get("type");
            String item_lov = 	(String)((HashMap)iay.get(i)).get("lov");
            String item_color = (String)((HashMap)iay.get(i)).get("color");
            String item_font = 	(String)((HashMap)iay.get(i)).get("font");
            String item_fs = 	(String)((HashMap)iay.get(i)).get("font_size");
            String item_obid = 	(String)((HashMap)iay.get(i)).get("obid");
            String ntype = 		(String)((HashMap)iay.get(i)).get("ntype");
            //控制
            String item_menu = 	(String)((HashMap)iay.get(i)).get("menu");
            
            
		}
	}
	
	/**
	 * Reads a Document from the given File
	 * @param f : XML File
	 * @return org.dom4j.Document
	 */
	public Document getDocumentFromFile(File f) {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(f);
			//System.out.println("XMLEncoding::" + document.getXMLEncoding());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return document;
	}
	
	/**
     * 透過 type 取得相對應的節點資訊
     * @param rootElement : xml element
     * @param type : 判斷式
     * @return Element
     * @throws Exception
     */
    public Element getElementFromType(Element rootElement
                                     ,String type) throws Exception {
        //開新的「根」節點
        Element newMenuNode = DocumentHelper.createElement("Menu");
        //「根」節點屬性
        newMenuNode.addAttribute("id", rootElement.attribute("id").getValue());
        newMenuNode.addAttribute("title", "root");
        newMenuNode.addAttribute("desc", "root");
        newMenuNode.addAttribute("type", "String");
        newMenuNode.addAttribute("lov", "");
        newMenuNode.addAttribute("font", "新細明體");
        newMenuNode.addAttribute("font_size", "14");
        newMenuNode.addAttribute("color", "black");
        newMenuNode.addAttribute("height", "30");
        newMenuNode.addAttribute("obid", "root");
        newMenuNode.addAttribute("ntype", "B");
        
        Element coincide = null;
        
        Iterator itRoot = rootElement.elementIterator();
        while(itRoot.hasNext()) {
            Element child = (Element)itRoot.next();
            
            if(child.attributeValue("obid").equals(type)) {
                coincide = this.getElementWithMenuId(rootElement, child.attributeValue("id"));
            }
        }
        
        if(coincide != null) {
            Iterator it = coincide.elementIterator();
            while(it.hasNext()){
                Element child = (Element)it.next();
                
                newMenuNode.add((Element)child.clone());
            }
        }
        return newMenuNode;
    }
	
    /**
     * 透過[節點id(menuId)]取得其Element
     * @param rootElement
     * @param menuId
     * @return
     * @throws Exception
     */
    public Element getElementWithMenuId(Element rootElement,
    		String menuId) throws Exception {
        Iterator it = rootElement.elementIterator();
        //只做第一層 不遞迴
        while(it.hasNext()) {
            Element child = (Element)it.next();
            String childId = child.attribute("id").getValue();
            String childTitle = child.attribute("title").getValue();
            
            if(childId.equals(menuId)){
                return child;
            }
        }
        return null;
    }
    
    /**
     * 解析XML(rootElement)上所有的Tag，穿入HashMap並放入list中
     * @param rootElement : UI上XML結構
     * @param list : 解析後每個Tag的資訊
     * @param menuName
     * @return list
     * @throws Exception
     */
    public ArrayList getAllItemData(Element rootElement,
    		ArrayList list,
    		String menuName) throws Exception {
//    	MigoUtilMethod.printString("In XmlToData.getAllItemData() rootElement.asXML()=\n" +
//    			rootElement.asXML());
        
        Iterator it = rootElement.elementIterator();
        while(it.hasNext()) {
            Element child = (Element)it.next();
            String childName = child.getName();	//取得 Tag Name
            //只讓合法的Tag Name通過
            if("Menu".equals(childName) || "Item".equals(childName)) {
//            	MigoUtilMethod.printString("-------------------------------");
//            	MigoUtilMethod.printString(" obid= "+child.attribute("obid").getValue());
//            	MigoUtilMethod.printString(" title= "+child.attribute("title").getValue());
//            	MigoUtilMethod.printString(" = "+child.attribute("desc").getValue());
//            	MigoUtilMethod.printString(" type= "+child.attribute("type").getValue());
//            	MigoUtilMethod.printString(" = "+child.attribute("color").getValue());
//            	MigoUtilMethod.printString(" = "+child.attribute("font").getValue());
//            	MigoUtilMethod.printString(" = "+child.attribute("font_size").getValue());
//            	MigoUtilMethod.printString(" = "+child.attribute("height").getValue());
//            	MigoUtilMethod.printString(" ntype= "+child.attribute("ntype").getValue());
//            	MigoUtilMethod.printString(" menuName= "+menuName);
//            	MigoUtilMethod.printString(" lov= "+child.attribute("lov").getValue());
//            	MigoUtilMethod.printString("-------------------------------\n");
	            //取得Tag中所有的屬性資訊
	            String childId = child.attribute("id").getValue();
	            String childTitle = child.attribute("title").getValue();
	            
	            String childLov = child.attribute("lov")==null?"":
	            	child.attribute("lov").getValue();
	            
//	            System.out.println("------");
//	            System.out.println("childId = " + childId);
//	            System.out.println("title = " + childTitle);
//	            System.out.println("lov = " + child.attribute("lov").getValue());
	            
	            HashMap<String,String> dataMap = new HashMap<String,String>();
	            dataMap.put("id",		childId);
	            dataMap.put("obid",		child.attribute("obid").getValue());
	            dataMap.put("title",	childTitle);
	            dataMap.put("desc",		child.attribute("desc").getValue());
	            dataMap.put("type",		child.attribute("type").getValue());
	            dataMap.put("lov",		childLov);
	            dataMap.put("color",	child.attribute("color").getValue());
	            dataMap.put("font",		child.attribute("font").getValue());
	            dataMap.put("font_size",child.attribute("font_size").getValue());
	            dataMap.put("height",	child.attribute("height").getValue());
	            dataMap.put("ntype",	child.attribute("ntype").getValue());
	            dataMap.put("menu",		menuName);
	            
	            list.add(dataMap);
	            
	            if("Menu".equals(childName)) {
	            	//判斷有沒有小孩
	                if(child.elements().size() > 0) {
	                    getAllItemData(child, list, childTitle);
	                }
	            }
            }
        }
        return list;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ReadXmlFiles rxf = new ReadXmlFiles();
			rxf.preLoadXmlData();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
