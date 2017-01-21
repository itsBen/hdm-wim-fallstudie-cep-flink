package de.hdm.wim.helper;

import java.time.DayOfWeek;

/**
 * Created by Ben on 20.01.2017.
 */
public class DateHelper {

    /**
     * The Constant DATE_MONDAY.
     */
    public static final String DATE_MONDAY = "monday";

    /**
     * The Constant DATE_TUESDAY.
     */
    public static final String DATE_TUESDAY = "tuesday";

    /**
     * The Constant DATE_WEDNESDAY.
     */
    public static final String DATE_WEDNESDAY = "wednesday";

    /**
     * The Constant DATE_THURSDAY.
     */
    public static final String DATE_THURSDAY = "thursday";

    /**
     * The Constant DATE_FRIDAY.
     */
    public static final String DATE_FRIDAY= "friday";

    /**
     * The Constant DATE_SATURDAY.
     */
    public static final String DATE_SATURDAY = "saturday";

    /**
     * The Constant DATE_SUNDAY.
     */
    public static final String DATE_SUNDAY = "sunday";

    /**
     * Unify day of week with Java.Time.
     *
     * @param input the input
     * @return the day of week
     */
    public DayOfWeek unifyDayOfWeek(String input){

        DayOfWeek dow = null;

        switch(input.toLowerCase()) {
            case DATE_MONDAY:       dow = DayOfWeek.MONDAY;     break;
            case DATE_TUESDAY:      dow = DayOfWeek.TUESDAY;    break;
            case DATE_WEDNESDAY:    dow = DayOfWeek.WEDNESDAY;  break;
            case DATE_THURSDAY:     dow = DayOfWeek.THURSDAY;   break;
            case DATE_FRIDAY:       dow = DayOfWeek.FRIDAY;     break;
            case DATE_SATURDAY:     dow = DayOfWeek.SATURDAY;   break;
            case DATE_SUNDAY:       dow = DayOfWeek.SUNDAY;     break;
        }
        return dow;
    }





}
