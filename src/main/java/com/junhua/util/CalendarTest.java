package com.junhua.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CalendarTest {

	public static void main(String[] args) {
		test2();		
	}
	
	static void test1(){
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));

        if(calendar.getTime().before(new Date())){
        	calendar.add(Calendar.YEAR, 1);
        }
        
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        
        while (day == Calendar.SUNDAY || day == Calendar.SATURDAY) {
        	if(day == Calendar.SUNDAY){
        		day = Calendar.SATURDAY;
        	}else{
        		day--;
        	}
        }
        calendar.set(Calendar.DAY_OF_WEEK, day);
		System.out.println(formatter.format(calendar.getTime()));
	}
	
	static void test2(){
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		
		
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, 5);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		
		 int day = calendar.get(Calendar.DAY_OF_WEEK);
	        
	        while (day == Calendar.SUNDAY || day == Calendar.SATURDAY) {
	        	if(day == Calendar.SUNDAY){
	        		day = Calendar.SATURDAY;
	        	}else{
	        		day--;
	        	}
	        }
	        calendar.set(Calendar.DAY_OF_WEEK, day);
		System.out.println(formatter.format(calendar.getTime()));
	}
}
