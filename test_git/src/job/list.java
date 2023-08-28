package job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class list {

	public static void main(String[] args) {
		
//		int a=0;
//		for(int i=0;i<10;i++) {
//			for(int j=0;j<10;j++) {
//				if(i==j) {
//					System.out.print(a);
//					a++;
//				}
//				else {
//					System.out.print(" ");
//				}
//			}
//			System.out.println();
//		}
	
		Map<String, String>map=new HashMap<>();
		map.put("1", "ㅎㅎ");
		map.put("2", "zz");
		map.put("3", "qq");
		map.put("2", "gg");
	
		System.out.println(map.size());
		
		System.out.println(map.get("1"));
		
		Set<String>set=map.keySet();
		
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			String key=iter.next();
			String value=map.get(key);
			System.out.println(key+" : "+value);
		}
		Date date=new Date();
		System.out.println(date);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println(sdf.format(date));
		System.out.println(date.getTime());
		long today= System.currentTimeMillis();
		System.out.println(today-date.getTime());
		Calendar cal=Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		
		cal.add(Calendar.HOUR, 6);
		System.out.println(cal.get(Calendar.HOUR));
		
		
		
		
//		JFrame frame=new JFrame();
//		
//		JPanel panel=new JPanel();
//		
//		frame.add(panel);
//		
//		
//		frame.setResizable(true);
//		
//		frame.setVisible(true);
//		frame.setSize(400,400);
//		
//		frame.setLocationRelativeTo(null);
//		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		
		
		
		
//		int num=0;
//		
//		for(int i =1;i<=20;i++) {
//			num=(int)(Math.random()*10)+1;
//			System.out.print(num);
//		}
		
		
		
	}
}


