package br.com.syncinfo.calendar.model;

import android.support.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by mmartins on 08/06/2016.
 */
public class Day implements Comparable<Day> {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    private final java.util.Calendar cal;

    public Day(@NonNull java.util.Calendar cal) {
        setTime(this.cal = cal, 0, 0, 0, 0);
    }

    public Day(int y, int m, int d) {
        this.cal = java.util.Calendar.getInstance();
        this.cal.set(java.util.Calendar.YEAR, y);
        this.cal.set(java.util.Calendar.MONTH, m);
        this.cal.set(java.util.Calendar.DAY_OF_MONTH, d);
        setTime(this.cal, 0, 0, 0, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Day)) return false;

        Day day = (Day) o;

        if (this.cal != null) {
            if (o != null) {
                return this.cal.getTimeInMillis() == day.cal.getTimeInMillis();
            }

            return false;
        } else {
            return o == null;
        }
    }

    @Override
    public int hashCode() {
        return cal != null ? cal.hashCode() : 0;
    }

    private void setTime(java.util.Calendar cal, int h, int m, int s, int ms) {
        cal.set(java.util.Calendar.HOUR_OF_DAY, h);
        cal.set(java.util.Calendar.MINUTE, m);
        cal.set(java.util.Calendar.SECOND, s);
        cal.set(java.util.Calendar.MILLISECOND, ms);
    }

    public int getYear() { return this.cal.get(java.util.Calendar.YEAR); }
    public int getMonth() { return this.cal.get(java.util.Calendar.MONTH); }
    public int getDay() { return this.cal.get(java.util.Calendar.DAY_OF_MONTH); }

    public Period fromTo(int hs, int ms, int he, int me) {
        java.util.Calendar from = (java.util.Calendar) cal.clone();
        setTime(from, hs, ms, 0, 0);
        java.util.Calendar to = (java.util.Calendar) cal.clone();
        setTime(to, he, me, 0, 0);
        return new Period(new Time(from, java.util.Calendar.MINUTE), new Time(to, java.util.Calendar.MINUTE));
    }

    @Override
    public int compareTo(@NonNull Day another) {
        return (int) ((int) this.cal.getTimeInMillis() - another.cal.getTimeInMillis());
    }

    @Override
    public String toString() {
        return toString(SIMPLE_DATE_FORMAT);
    }

    public String toString(@NonNull DateFormat df) {
        return df.format(this.cal.getTime());
    }

    public boolean isLesser(@NonNull java.util.Calendar cal) {
        return this.cal.getTimeInMillis() < cal.getTimeInMillis();
    }
}
