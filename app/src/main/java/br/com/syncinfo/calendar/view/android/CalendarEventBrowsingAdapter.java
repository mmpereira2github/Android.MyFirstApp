package br.com.syncinfo.calendar.view.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import br.com.syncinfo.calendar.model.CalendarEvent;
import br.com.syncinfo.calendar.model.Period;
import br.com.syncinfo.calendar.model.CalendarDay;
import br.com.syncinfo.calendar.model.HollowCalendarEvent;
import br.com.syncinfo.clinicapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmartins on 02/06/2016.
 */
public class CalendarEventBrowsingAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private List<CalendarEvent> horarios = new ArrayList<>();

    private void normalizeEvent(Context context, Period lastPeriod, CalendarEvent event, Period allowedPeriods) {
        if (event == null) {
            horarios.add(new HollowCalendarEvent(allowedPeriods));
        }
        else {
            if (lastPeriod == null) {
                if (event.getPeriod().getStart().isGreater(allowedPeriods.getStart())) {
                    horarios.add(new HollowCalendarEvent(new Period(allowedPeriods.getStart(), event.getPeriod().getStart())));
                }
            }
            else if (lastPeriod.getEnd().isLesser(event.getPeriod().getStart())) {
                horarios.add(new HollowCalendarEvent(new Period(lastPeriod.getEnd(), event.getPeriod().getStart())));
            }
            horarios.add(event);
        }
    }

    public CalendarEventBrowsingAdapter(Context context, CalendarDay calendarDay) {
        this.mInflater = LayoutInflater.from(context);
        Period firstPeriod = null;
        if (calendarDay != null) {
            for (CalendarEvent horario : calendarDay) {
                normalizeEvent(context, firstPeriod, horario, calendarDay.getAllowedIntervalForEvents());
                firstPeriod = horario.getPeriod();
            }
        }

        normalizeEvent(context, firstPeriod, null, calendarDay.getAllowedIntervalForEvents());
    }

    @Override
    public int getCount() {
        return horarios.size();
    }

    @Override
    public Object getItem(int position) {
        return horarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label;
        if (convertView == null) {
            convertView = this.mInflater.inflate(R.layout.list_item_day_events, null);
            label = (TextView) convertView.findViewById(R.id.calendarEvent);
            convertView.setTag(label);
        }
        else {
            label = (TextView) convertView.getTag();
        }

        label.setText(horarios.get(position).toString());
        return convertView;
    }
}
