package br.com.syncinfo.calendar.controller;

import br.com.syncinfo.calendar.model.CalendarModel;
import br.com.syncinfo.calendar.model.Day;
import br.com.syncinfo.calendar.model.CalendarDay;
import br.com.syncinfo.calendar.model.dao.CalendarDAO;
import br.com.syncinfo.calendar.view.DayEventsBrowsingView;

import java.util.Calendar;

/**
 * Created by mmartins on 06/06/2016.
 */
public class DayEventsBrowsingUC {
    private final DayEventsBrowsingView view;
    private final CalendarDAO calendarDAO = new CalendarDAO();
    private String agendaId;
    private CalendarDay calendarDay = null;

    /**
     * Use the day provided to retrieve all appointments of this day. If day is null, then use the
     * current day. The view is notified with the list of appointments.
     */
    public DayEventsBrowsingUC(DayEventsBrowsingView view, Long agendaId, Day day) {
        this.agendaId = "";
        this.view = view;
        if (day != null) {
            onDayChange(day);
        }
    }

    public void onDayChange(Day day) {
        if (this.calendarDay != null) {
            if (calendarDay.getDay().equals(day)) {
                return;
            }
        }

        this.calendarDay = CalendarModel.getCalendarDay(this.agendaId, day);
        if (this.calendarDay.getDay().isLesser(Calendar.getInstance())) {
            view.setAllowedActions(null);
        }
        view.reset(calendarDay);
    }
}
