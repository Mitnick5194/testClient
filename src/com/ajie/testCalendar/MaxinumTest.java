package com.ajie.testCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author niezhenjie
 * 
 */
public class MaxinumTest {

	public static void main(String[] args) throws ParseException {
		String dStr = "2018-02-10";
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fmt.parse(dStr);
		System.out.println(date);

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 特别注意 这里返回的是一年中所有的月份中一个月最多的天数值是多少 这里总是返回31
		int maxMon = cal.getMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(maxMon);
		// 下面的方法就是返回指定的月份中最后一天的值
		int maxMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(maxMonth);
	}

}
