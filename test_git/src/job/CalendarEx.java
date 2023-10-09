package job;

import java.util.Calendar;

public class CalendarEx { 

	public static void createCalendar(int year,int month) {
		Calendar cal=Calendar.getInstance();
		cal.set(year, month-1, 1);//month는 0 ~ 11월 이렇게 12달이 나오기 때문에 8월을 원하면 7이 입력되야한다.
		
		int maxDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);//그 달의 마지막 일을 찾아준다.
		int startDay=cal.get(Calendar.DAY_OF_WEEK);//시작요일 찾아줌
		System.out.println("2");
		System.out.println("  일   월   화   수   목  금   토");
		for(int i=1;i<startDay;i++) {
			System.out.print("    ");
		}
		for(int i=1;i<=maxDay;i++) { 
			System.out.printf("%4d",i);
			if(startDay%7==0) {//토요일마다 줄바꿈
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
