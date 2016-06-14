package br.com.syncinfo.calendar.view.android;

import android.app.DatePickerDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import br.com.syncinfo.calendar.controller.DayEventsBrowsingUC;
import br.com.syncinfo.calendar.model.Day;
import br.com.syncinfo.calendar.model.CalendarDay;
import br.com.syncinfo.clinicapp.R;
import br.com.syncinfo.calendar.view.DayEventsBrowsingView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A placeholder fragment containing a simple view.
 */
public class DayEventsBrowsingViewFragment extends Fragment implements DayEventsBrowsingView {

    public DayEventsBrowsingViewFragment() {
    }

    /**
     * Dia da agenda a ser mostrado
     */
    private TextView diaDaAgendaView = null;
    /**
     * List of appointments in the agenda
     */
    private ListView horariosDoDiaDaAgendaView = null;

    private Day printedDay = null;
    private final DayEventsBrowsingUC useCase = new DayEventsBrowsingUC(this, null, null);

    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        /**
         * Altera a data da agenda a ser mostrada
         * @param view
         * @param selectedYear
         * @param selectedMonth
         * @param selectedDay
         */
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            useCase.onDayChange(new Day(selectedYear, selectedMonth, selectedDay));
        }
    };

    // Create a message handling object as an anonymous class.
    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            System.out.printf("Position=%d\n", position);
        }
    };

    private TextView.OnClickListener onDiaDaAgendaIsClicked = new TextView.OnClickListener() {
        public void onClick(View v) {
            DatePickerDialog selecaoDiaDialog = new DatePickerDialog(DayEventsBrowsingViewFragment.this.getContext(), datePickerListener,
                    printedDay.getYear(), printedDay.getMonth(), printedDay.getDay());
            selecaoDiaDialog.show();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_day_events, container, false);
        /**
         * Get the TextView where the day of the Calendar is printed and set the listener to
         * allow user change the day.
         */
        diaDaAgendaView = (TextView) result.findViewById(R.id.diaDaAgenda);
        diaDaAgendaView.setOnClickListener(this.onDiaDaAgendaIsClicked);
        /**
         * Get the ListView of all appointments of the day set
         */
        horariosDoDiaDaAgendaView = (ListView) result.findViewById(R.id.calendarDay);
        horariosDoDiaDaAgendaView.setOnItemClickListener(mMessageClickedHandler);

        useCase.onDayChange(new Day(Calendar.getInstance()));
        return result;
    }

    @Override
    public void reset(CalendarDay calendarDay) {
        printedDay = calendarDay.getDay();
        diaDaAgendaView.setText(this.printedDay.toString(SIMPLE_DATE_FORMAT));
        horariosDoDiaDaAgendaView.setAdapter(new CalendarEventBrowsingAdapter(getContext(), calendarDay));
    }

    @Override
    public void setAllowedActions(DayEventsBrowsingView.Action... actions) {

    }
}
