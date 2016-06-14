package br.com.syncinfo.calendar.model;

import java.util.*;

/**
 * Created by mmartins on 10/06/2016.
 */
public class EventBookingConfig {
    private Day validFrom;
    private Day invalidFrom;
    private List<Period> allowedPeriods = new ArrayList<>();

    public EventBookingConfig() {
        this.validFrom = new Day(java.util.Calendar.getInstance());
        this.invalidFrom = new Day(4000, 12, 31);
        allowedPeriods.add(new Period(new Time(90, 30), new Time(16, 30)));
    }

    public List<Period> getAllowedPeriods() {
        return allowedPeriods;
    }

    public Day getInvalidFrom() {
        return invalidFrom;
    }

    public Day getValidFrom() {
        return validFrom;
    }
}
