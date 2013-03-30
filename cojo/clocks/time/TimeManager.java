package cojo.clocks.time;

import java.util.Calendar;

public class TimeManager {

	public TimeManager() {
		
	}
	
	public String getCurrentTime24() {
		return getCurrentTime(24);
	}
	
	public String getCurrentTime12() {
		return getCurrentTime(12);
	}
	
	private String getCurrentTime(int mode) {
		Calendar calendar = Calendar.getInstance();
		
		StringBuilder sb = new StringBuilder();
		
		if (mode == 24)
			sb.append(calendar.get(Calendar.HOUR_OF_DAY));
		else
			if (mode == 12)
				sb.append(calendar.get(Calendar.HOUR_OF_DAY));
			else
				throw new IllegalArgumentException("Illegal Hour mode");
		sb.append(":");
		sb.append(calendar.get(Calendar.MINUTE));
		sb.append(":");
		sb.append(calendar.get(Calendar.SECOND));
		
		return sb.toString();
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
