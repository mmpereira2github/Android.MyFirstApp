package br.com.syncinfo.calendar.model;

import br.com.syncinfo.calendar.model.events.UpdateEvent;

import java.util.Observable;

/**
 * Created by mmartins on 07/06/2016.
 */
public class ValueHolder<T> extends Observable {
    private T value;

    public ValueHolder() {
        this(null);
    }

    public ValueHolder(T value) {
        this.value = value;
    }

    void set(T newValue) {
        if (this.value == null) {
            if (newValue != null) {
                this.setChanged();
                this.notifyObservers(new UpdateEvent<T>(null, newValue));
                this.value = newValue;
            }
        }
        else if (newValue == null) {
            this.notifyObservers(new UpdateEvent<T>(this.value, null));
            this.value = newValue;
        }
        else if (this.value.equals(newValue) == false) {
            this.notifyObservers(new UpdateEvent<T>(this.value, newValue));
            this.value = newValue;
        }
    }

    public T get() { return value; }
}
