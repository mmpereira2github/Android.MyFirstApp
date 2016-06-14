package br.com.syncinfo.calendar.model.events;

/**
 * Created by mmartins on 07/06/2016.
 */
public class UpdateEvent<T> {
    public final T oldData;
    public final T newData;
    public UpdateEvent(T oldData, T newData) {
        this.oldData = oldData;
        this.newData = newData;
    }
}
