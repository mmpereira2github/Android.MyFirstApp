package br.com.syncinfo.calendar.model;

import java.text.SimpleDateFormat;

/**
 * Created by mmartins on 08/06/2016.
 */
public class Time implements Comparable<Time> {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT_HH = new SimpleDateFormat("HH");
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT_MM = new SimpleDateFormat("HH:mm");
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT_SS = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT_MS = new SimpleDateFormat("HH:mm:ss.SSS");

    private final java.util.Calendar cal;
    private final int precision;
    private final SimpleDateFormat simpleDateFormat;

    public Time(int hour, int minutes) {
        this.cal = java.util.Calendar.getInstance();
        this.cal.setTimeInMillis(0);
        this.cal.set(java.util.Calendar.HOUR_OF_DAY, hour);
        this.cal.set(java.util.Calendar.MINUTE, minutes);
        this.precision = java.util.Calendar.MINUTE;
        this.simpleDateFormat = SIMPLE_DATE_FORMAT_MM;
    }

    public Time(java.util.Calendar cal, int precision) {
        this.cal = (java.util.Calendar) cal.clone();
        this.precision = precision;
        normalize(cal, precision);
        switch(precision) {
            case java.util.Calendar.HOUR:
            case java.util.Calendar.HOUR_OF_DAY:
                this.simpleDateFormat = SIMPLE_DATE_FORMAT_HH;
                break;
            case java.util.Calendar.MINUTE:
                this.simpleDateFormat = SIMPLE_DATE_FORMAT_MM;
                break;
            case java.util.Calendar.SECOND:
                this.simpleDateFormat = SIMPLE_DATE_FORMAT_SS;
                break;
            default:
                this.simpleDateFormat = SIMPLE_DATE_FORMAT_MS;
                break;
        }
    }

    public boolean isLesser(Time t2) {
        return this.cal.getTimeInMillis() < t2.cal.getTimeInMillis();
    }

    public boolean isGreater(Time t2) {
        return this.cal.getTimeInMillis() > t2.cal.getTimeInMillis();
    }

    private void normalize(java.util.Calendar cal, int precision) {
        switch(precision) {
            case java.util.Calendar.HOUR_OF_DAY:
                cal.set(java.util.Calendar.MINUTE, 0);
            case java.util.Calendar.MINUTE:
                cal.set(java.util.Calendar.SECOND, 0);
            case java.util.Calendar.SECOND:
                cal.set(java.util.Calendar.MILLISECOND, 0);
                break;
            default:
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time)) return false;

        Time time = (Time) o;

        if (precision != time.precision) return false;
        if (cal.getTimeInMillis() == time.cal.getTimeInMillis()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = cal.hashCode();
        result = 31 * result + precision;
        return result;
    }

    @Override
    public int compareTo(Time another) {
        return (int)(this.cal.getTimeInMillis() - another.cal.getTimeInMillis());
    }

    @Override
    public String toString() {
        return this.simpleDateFormat.format(this.cal.getTime());
    }
}
