/**
 * 
 */
package com.nurse.util;

/**
 * @author jeff
 * 儲存登入者的所有個人資訊
 */
public class UserObject {
	
	private static UserObject ins = null;
	
	/**
	 * 建立 UserObject 物件
	 * @return UserObject
	 */
	public static UserObject getInstance() {
		if(ins == null) {
			ins = new UserObject();
		}
		return ins;
	}
	
	/**
	 * 建構子。<br>初始化各數值
	 */
	private UserObject() {
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
