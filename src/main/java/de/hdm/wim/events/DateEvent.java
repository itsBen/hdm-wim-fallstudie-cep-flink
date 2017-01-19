package de.hdm.wim.events;

import de.hdm.wim.classes.Participant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Ben on 17.01.2017.
 */
public class DateEvent extends MessageEvent {

    private LocalDate _date;

    public DateEvent(List<String> tokens, Participant sender, LocalDateTime timestamp, LocalDate date, int messageId) {
        super(tokens, sender, timestamp, messageId);
        this._date = date;
    }

    public LocalDate getDate() {
        return _date;
    }

    public void setDateTime(LocalDate date) {
        this._date = date;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DateEvent) {
            DateEvent dateEvent = (DateEvent) obj;
            return dateEvent.canEquals(this) && super.equals(dateEvent) && _date == dateEvent._date;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 41 * super.hashCode() + Double.hashCode(_date.getMonthValue());
    }

    @Override
    public boolean canEquals(Object obj) {
        return obj instanceof DateEvent;
    }

    @Override
    public String toString() {
        return "DateEvent(" + getMessageId() + ", " + _date + ")";
    }
}
