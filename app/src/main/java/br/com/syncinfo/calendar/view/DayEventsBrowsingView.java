package br.com.syncinfo.calendar.view;

import br.com.syncinfo.calendar.model.CalendarDay;

/**
 * DayEventsBrowsingView represents a VIEW interface to show a list of events for a day and allow
 * user to change the day seen or ask for changing or adding events.
 *
 * Created by mmartins on 06/06/2016.
 */
public interface DayEventsBrowsingView {
    enum Action { CREATE_NEW_EVENT, CHANGE_EVENT_STATUS };

    void reset(CalendarDay calendarDay);

    void setAllowedActions(Action...actions);
}
