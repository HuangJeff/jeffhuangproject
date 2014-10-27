/**
 * 
 */
package com.nurse.util;

/**
 * @author test
 * 儲存系統上的各種資訊
 */
public class SystemObject {
	private static SystemObject ins = null;
	
	
	public static SystemObject getInstance() {
		if(ins == null) {
			ins = new SystemObject();
		}
		return ins;
	}
	
	/**
	 * 建構子。<br>初始化各數值
	 */
	private SystemObject() {
		this.cleanAllData();
	}
	
	/**
	 * 清除數值(還原預設值)
	 */
	public void cleanAllData() {
		
	}
	
	/**
	 * 移除數值
	 */
	public void removeAllData() {
		
	}
	
}
