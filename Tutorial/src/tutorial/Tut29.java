package tutorial;

//date and time in java
//java stores time from 1 jan 1970

import java.util.Date;
import java.util.Calendar;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Tut29 {

	@SuppressWarnings({ "deprecation" }) // this is java annotation we will talk about this later tutorials
	public static void main(String[] args) {
		Date date = new Date();
		// since this class is going to deprecated they are now replaced with calendar
		// class
		System.out.println(date.getDay());
		datetim();
		timetutorial();
	}

	public static void datetim() {
		// refer to the documentation for more
		Calendar rig = Calendar.getInstance();

		System.out.println("Date : " + rig.get(Calendar.DATE) + "\nHour : " + rig.get(Calendar.HOUR));
	}

	public static void timetutorial() {
		LocalDateTime lt = LocalDateTime.now();
		System.out.println("Date and time : ");
		System.out.println(lt);
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/LL/yyyy hh:mm:ss a");
		System.out.println(lt.format(dt));
	}

}
