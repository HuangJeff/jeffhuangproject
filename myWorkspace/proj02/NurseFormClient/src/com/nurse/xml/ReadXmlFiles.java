/**
 * 
 */
package com.nurse.xml;

import java.io.File;

import org.dom4j.io.SAXReader;

/**
 * @author test
 * �B�zXML File
 */
public class ReadXmlFiles {
	
	/**
	 * 
	 */
	public ReadXmlFiles() {
		
	}
	
	/**
	 * ���JXML��T
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
			//String[] sa = xmlFile.list(); //�ɦWArray
			//System.out.println("xmlFile.list()==>" + sa);
			for(File f : xmlFile.listFiles()) {
				if(f.getName().equals("NISEV004.xml")) { //�����@���ɮ�
					tmpFile = f;
					break;
				}
			}
		}
		System.out.println("FileName==>" + tmpFile.getName());
		SAXReader saxReader = new SAXReader();
		
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
