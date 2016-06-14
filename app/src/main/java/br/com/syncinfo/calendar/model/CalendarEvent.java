package br.com.syncinfo.calendar.model;

/**
 * Created by mmartins on 19/05/2016.
 */
public abstract class CalendarEvent implements Comparable<CalendarEvent>{

    public static interface Visitor {
        void setVazio(HollowCalendarEvent horarioAgenda);
    }

    private final Period period;

    @Override
    public String toString() {
        return period.toString();
    }

    public CalendarEvent(Period period) {
        this.period = period;
    }

    public Period getPeriod() {
        return this.period;
    }

    public boolean isLesser(CalendarEvent another) {
        return period.getStart().compareTo(another.period.getStart()) < 0;
    }

    @Override
    public int compareTo(CalendarEvent another) {
        return period.getStart().compareTo(another.period.getStart());
    }
}
