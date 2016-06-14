package br.com.syncinfo.calendar.model.dao;

import android.support.annotation.NonNull;

import br.com.syncinfo.calendar.model.Calendar;
import br.com.syncinfo.calendar.model.Day;
import br.com.syncinfo.calendar.model.CalendarDay;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by mmartins on 06/06/2016.
 */
public class CalendarDAO {
    private static Map<String, Calendar> agendas = new Hashtable<>();
    private static Map<Day, CalendarDay> diasAgenda = new Hashtable<>();

    static {
        agendas.put("", new Calendar(0));
    }

    public void insertAgenda(Calendar calendar) {
        agendas.put(calendar.getId(), calendar);
    }

    public CalendarDay getDia(String agendaId, @NonNull Day dia) {
        Calendar calendar = agendas.get(agendaId);
        CalendarDay result = diasAgenda.get(dia);
        if (result == null) {
            result = new CalendarDay(calendar, dia);
        }

        return result;
    }
}
