package com.commons;
import java.util.Calendar;

public class MyDate {
	public static String getDate() {
		Calendar cal = Calendar.getInstance();
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH)+1;
		int dd = cal.get(Calendar.DATE);
		int hh = cal.get(Calendar.HOUR_OF_DAY);
		int ms = cal.get(Calendar.MINUTE);
		int ss = cal.get(Calendar.SECOND);
		String result = String.format("%4d-%02d-%02d %02d:%02d:%02d",yy,mm,dd,hh,ms,ss);
		return result;
	}
}