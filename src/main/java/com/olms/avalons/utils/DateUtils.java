package com.olms.avalons.utils;

import static java.util.Calendar.AM; 
import static java.util.Calendar.AM_PM;
import static java.util.Calendar.DATE;
import static java.util.Calendar.HOUR;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.YEAR;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

	public static final String DISPLAY_DATE_FORMAT_1 = "MMMMM dd, yyyy";
	public static final String DISPLAY_DATE_FORMAT_3 = "MMM dd, yyyy";
	public static final String DISPLAY_DATE_FORMAT_4 = "MMM d, h:mm a";

	public static final String TIME_FORMAT = "hh:mm a";

	public static final String DATE_TIME_FORMAT = DISPLAY_DATE_FORMAT_1 + " " + TIME_FORMAT;

	public static Date timestampToDate(final Timestamp timestamp) {

		if (timestamp == null) {
			return null;
		}

		return new Date(timestamp.getTime());
	}

	/**
	 * Gets current time in timestamp format.
	 * 
	 * @return current timestamp.
	 */

	public static Timestamp currentTimestamp() {

		return toTimestamp(Calendar.getInstance());
	}

	/**
	 * Generates timestamp from the given calendar.
	 *
	 * @param calendar calendar.
	 * @return timestamp.
	 */
	public static Timestamp toTimestamp(final Calendar calendar) {

		if (calendar == null) {
			return null;
		}

		return new Timestamp(calendar.getTimeInMillis());
	}

	/**
	 * Generates timestamp from the given date.
	 *
	 * @param date date.
	 * @return timestamp.
	 */
	public static Timestamp toTimestamp(final java.util.Date date) {

		if (date == null) {
			return null;
		}

		return new Timestamp(date.getTime());
	}

	/**
	 * Gets the simple date format for the display date3 format.
	 *
	 * @return simple date format.
	 */
	public static SimpleDateFormat getDisplayDate3() {

		return getDateFormat(DISPLAY_DATE_FORMAT_3);
	}

	public static SimpleDateFormat getDisplayDateTime() {

		return getDateFormat(DATE_TIME_FORMAT);
	}

	/**
	 * Gets the simple date format for the display date3 format.
	 *
	 * @return simple date format.
	 */
	public static SimpleDateFormat getDisplayDate4() {

		return getDateFormat(DISPLAY_DATE_FORMAT_4);
	}

	/**
	 * Gets the simple date format for the given date format.
	 *
	 * @return simple date format.
	 */
	public static SimpleDateFormat getDateFormat(final String dateFormat) {

		return new SimpleDateFormat(dateFormat);
	}

	/**
	 * Formats the given timestamp to the given date format.
	 *
	 * @param timestamp  timestamp.
	 * @param dateFormat date format.
	 * @return formatted date.
	 */
	public static String format(final Timestamp timestamp, final SimpleDateFormat dateFormat) {

		if (timestamp == null) {
			return null;
		}

		return dateFormat.format(timestamp);
	}

	/**
	 * Formats the given date to the given date format.
	 *
	 * @param date       date.
	 * @param dateFormat date format.
	 * @return formatted date.
	 */
	public static String format(final Date date, final SimpleDateFormat dateFormat) {

		if (date == null) {
			return null;
		}

		return dateFormat.format(date);
	}

	public static Calendar addMonths(final int monthsToAdd) {

		Calendar now = Calendar.getInstance();
		now.add(Calendar.MONTH, monthsToAdd);

		now.set(HOUR, 0);
		now.set(MINUTE, 0);
		now.set(SECOND, 0);
		now.set(MILLISECOND, 0);

		now.set(AM_PM, AM);

		return now;
	}

	/**
	 * Generates calendar with the given information.
	 *
	 * @param year   year.
	 * @param month  month.
	 * @param date   date.
	 * @param hour   hour.
	 * @param minute minute.
	 * @param ampm   am or pm.
	 * @return timestamp.
	 */
	public static Calendar generateCalendar(final int year, final int month, final int date, final int hour,
			final int minute, final int second, final int ampm) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR, year);
		calendar.set(MONTH, month);
		calendar.set(DATE, date);
		calendar.set(HOUR, hour);
		calendar.set(MINUTE, minute);
		calendar.set(SECOND, second);
		calendar.set(MILLISECOND, 0);
		calendar.set(AM_PM, ampm);

		return calendar;
	}
}
