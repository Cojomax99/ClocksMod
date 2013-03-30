package cojo.clocks.time;

import java.util.Calendar;

public class TimeManager {

	public TimeManager() {
		
	}
	
	public String getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		sb.append("/");
		sb.append(calendar.get(Calendar.MONTH));
		sb.append("/");
		sb.append(calendar.get(Calendar.YEAR));
		
		return sb.toString();
	}

}
