package br.com.syncinfo.calendar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mmartins on 23/05/2016.
 */
public class CalendarDay implements Iterable<CalendarEvent> {
    final Calendar calendar;
    private final Day day;
    private final Period allowedIntervalForEvents;

    final List<CalendarEvent> events = new ArrayList();

    public CalendarDay(Calendar calendar, Day day) {
        this.calendar = calendar;
        this.day = day;
        EventBookingConfig config = CalendarModel.getEventBookingConfigForDay(calendar.getId(), day);
        this.allowedIntervalForEvents = config.getAllowedPeriods().get(0);
    }

    public void addEvent(CalendarEvent event) {
        int location = 0;
        for (CalendarEvent horarioExistente: events) {
            if (horarioExistente.getPeriod().equals(event.getPeriod())) {
                events.set(location, event);
            }
            if (event.isLesser(horarioExistente)) {
                events.add(location, event);
                return;
            }

            location++;
        }

        events.add(location, event);
    }

    public Day getDay() { return this.day; }

    public Period getAllowedIntervalForEvents() {
        return this.allowedIntervalForEvents;
    }

    @Override
    public Iterator<CalendarEvent> iterator() {
        return events.iterator();
    }
}
