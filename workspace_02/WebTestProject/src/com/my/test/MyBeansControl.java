/**
 * 
 */
package com.my.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.my.test.bean.MyBeans;

/**
 * @author asus1
 *
 */
public class MyBeansControl {
	
	/**
	 * 
	 */
	public MyBeansControl() {
		
	}
	
	public List<MyBeans> getBeansList() {
		List<MyBeans> rtnBeanList = new ArrayList<MyBeans>();
		Random random = new Random();
		Calendar cal = Calendar.getInstance();
		//DateFormat format = new SimpleDateFormat("yyyy-MM-dd 24H:mm:ss");
		Date date1 = cal.getTime();
		cal.add(Calendar.DATE, -12);
		Date date2 = cal.getTime();
		for(int i=0;i<5;i++) {
			MyBeans myBean = new MyBeans();
			myBean.setId(random.nextInt());
			myBean.setName("Name:" + random.nextInt(10));
			myBean.setDate1(date1);
			myBean.setDate1(date2);
			rtnBeanList.add(myBean);
		}
		return rtnBeanList;
	}
}
