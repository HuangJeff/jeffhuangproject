/**
 * 
 */
package com.nurse.util;

/**
 * @author test
 * �x�s�t�ΤW���U�ظ�T
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
	 * �غc�l�C<br>��l�ƦU�ƭ�
	 */
	private SystemObject() {
		this.cleanAllData();
	}
	
	/**
	 * �M���ƭ�(�٭�w�]��)
	 */
	public void cleanAllData() {
		
	}
	
	/**
	 * �����ƭ�
	 */
	public void removeAllData() {
		
	}
	
}
