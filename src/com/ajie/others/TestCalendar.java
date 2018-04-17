package com.ajie.others;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author niezhenjie
 * 
 */
public class TestCalendar {
	public static void main(String[] args) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, 1);
		Date time = cal.getTime();
		String format = fmt.format(time);
		System.out.println(format);
		
	}

}
