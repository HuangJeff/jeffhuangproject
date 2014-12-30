/**
 * 
 */
package com.my.ajax;

/**
 * 讓前端呼叫用
 * @author asus1
 */
public class MyTestAjax {

	/**
	 * 
	 */
	public MyTestAjax() {
		//System.out.println("Constructor init.");
	}
	
	/**
	 * 給UI端呼叫測試使用
	 * @param name
	 * @param age
	 * @return
	 */
	public static String getATypeData(String name, int age) {
		String result = "A Type Data。name:" + name + " age:" + age;
		//System.out.println("getATypeData name=" + name + " age=" + age);
		return result;
	}
	
	/**
	 * 給UI端呼叫測試使用
	 * @param name
	 * @param age
	 * @return
	 */
	public String getBTypeData(String name, int age) {
		String result = "B Type Data。name:" + name + " age:" + age;
		//System.out.println("getBTypeData name=" + name + " age=" + age);
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}
