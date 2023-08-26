package kr.co.sist.test;

import java.util.Calendar;

public class CalendarEx {

	public static void createCalendar(int year,int month) {
		Calendar cal=Calendar.getInstance();
		cal.set(year, month-1, 1);
		
		int maxDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int startDay=cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("  일   월   화   수   목  금   토");
		for(int i=1;i<startDay;i++) {
			System.out.print("    ");
		}
		for(int i=1;i<=maxDay;i++) {
			System.out.printf("%4d",i);
			if(startDay%7==0) {
				System.out.println();
			}
			startDay++;
		}
		
	}
	
	public static void main(String[] args) {
		int year=2023;
		int month=8;
		System.out.println("     	 2023년 8월");
		createCalendar(year, month);
	}
}
