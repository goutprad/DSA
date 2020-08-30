package com.general.programs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FixingMalformedDate {
	public static void main(String[] args) throws ParseException {
		System.out.println(fixMalformedDate("18/05/1995")); // 18/05/1995
		System.out.println(fixMalformedDate("23/13/2015")); // 23/01/2016
		System.out.println(fixMalformedDate("40/06/2011")); // 10/07/2011
		System.out.println(fixMalformedDate("45/08/2012")); // 14/09/2012
		System.out.println(fixMalformedDate("50/02/2016")); // 21/03/2016
		System.out.println(fixMalformedDate("50/02/2015")); // 21/04/2015
	}

	public static String fixMalformedDate(String date) throws ParseException {
		Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		DateFormat reqFormat = new SimpleDateFormat("dd/MM/yyyy");
		String reqDate = reqFormat.format(dt);
		return reqDate;
	}
}
