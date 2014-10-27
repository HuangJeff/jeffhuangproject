/**
 * 
 */
package com.nurse.util;

/**
 * @author test
 * �x�s�n�J�̪��Ҧ��ӤH��T
 */
public class UserObject {
	
	private static UserObject ins = null;
	
	/**
	 * �إ� UserObject ����
	 * @return UserObject
	 */
	public static UserObject getInstance() {
		if(ins == null) {
			ins = new UserObject();
		}
		return ins;
	}
	
	/**
	 * �غc�l�C<br>��l�ƦU�ƭ�
	 */
	private UserObject() {
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
