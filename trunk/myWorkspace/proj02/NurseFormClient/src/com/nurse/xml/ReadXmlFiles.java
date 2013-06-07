/**
 * 
 */
package com.nurse.xml;

import java.io.File;
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
				if(f.getName().equals("NISEV001.xml")) { //先測一支檔案
					tmpFile = f;
					break;
				}
			}
		}
		System.out.println("FileName==>" + tmpFile.getName());
		
		Document document = this.getDocumentFromFile(tmpFile);
		
		//Element docSingle = this.getElementFromType(document.getRootElement(), "single");
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
//        String rootString = "<Menu id=\"" + rootElement.attribute("id").getValue() +
//        		"\" title=\"root\" desc=\"root\" type=\"string\" lov=\"\" font=\"新細明體\" " +
//        		"font_size=\"14\" color=\"black\" height=\"30\" obid=\"root\" ntype=\"\">";
//        StringBuffer sb = new StringBuffer(rootString);
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
//                sb.append(child.asXML());
            }
        }
//        sb.append("</Menu>\n");
        
        return newMenuNode;
//        return (getDocumentFromXML(sb.toString())).getRootElement();
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
