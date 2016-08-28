package Data;

import java.util.Calendar;

public class GameCalendar {

	public static int day, month, year, hour, minute;
	
	public GameCalendar(){
		
		day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		month = Calendar.getInstance().get(Calendar.MONTH);
		year = Calendar.getInstance().get(Calendar.YEAR);
		
		hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		minute = Calendar.getInstance().get(Calendar.MINUTE);
	}
	
	public void updateTime(){
		
		minute++;
		
		if(minute >= 60){
			
			minute = 0;
			hour++;
		}
		
		if(hour >= 24){
			
			hour = 0;
			day++;
		}
		
		if(month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11){
			
			if(day >= 32) {
				
				day = 1;
				month++;
			}
		}
		
		else if(month == 1) {
			
			if(day >= 29){
				
				day = 1;
				month++;
			}
		}
		
		else{
			
			if(day >= 31){
				
				day = 1;
				month++;
			}
		}
		
		if(month >= 12){
			
			month = 0;
			year++;
		}
	}
	
	public static String getSeason() {
		if(month == 11 || month < 2) {return "Winter";}
		else if(month >= 2 && month < 5) {return "Spring";}
		else if(month >= 5 && month < 8) {return "Summer";}
		else {return "Fall";}
	}
	
	public static String getDate() {return Integer.toString(month + 1) + "/" + Integer.toString(day) + "/" + Integer.toString(year);}
	public static String getTime() {
		
		String time = "";
		
		time += Integer.toString((hour % 12) + 1) + ":";
		if(minute < 10) {time += "0";}
		time += Integer.toString(minute);
		if(hour >= 11 && hour <= 22) {time += "PM";}
		else{time += "AM";}
		
		return time;
	}
}
