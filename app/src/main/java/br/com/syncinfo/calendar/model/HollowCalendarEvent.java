package br.com.syncinfo.calendar.model;

/**
 * Created by mmartins on 23/05/2016.
 */
public class HollowCalendarEvent extends CalendarEvent {

    public HollowCalendarEvent(Period period) {
        super(period);
    }

    @Override
    public String toString() {
        return super.toString() + " VAZIO";
    }
}
