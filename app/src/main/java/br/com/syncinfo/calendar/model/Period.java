package br.com.syncinfo.calendar.model;

/**
 * Created by mmartins on 08/06/2016.
 */
public class Period {
    private final Time start;
    private final Time end;

    public Period(Time start, Time end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Period)) return false;

        Period interval = (Period) o;

        if (!start.equals(interval.start)) return false;
        return end.equals(interval.end);
    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }

    public Time getStart() {
        return start;
    }

    public Time getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return start + "-" + end;
    }
}
