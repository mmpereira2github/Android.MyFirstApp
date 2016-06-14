package br.com.syncinfo.calendar.model;

import br.com.syncinfo.calendar.model.dao.CalendarDAO;

/**
 * Created by mmartins on 10/06/2016.
 */
public class CalendarModel {
    private static CalendarDAO calendarDAO = new CalendarDAO();

    public static CalendarDay getCalendarDay(String agendaId, Day day) {
        return calendarDAO.getDia(agendaId, day);
    }

    public static EventBookingConfig getEventBookingConfigForDay(String agendaId, Day day) {
        return new EventBookingConfig();
    }
}
