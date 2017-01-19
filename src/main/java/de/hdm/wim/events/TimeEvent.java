package de.hdm.wim.events;

import de.hdm.wim.classes.Participant;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by Ben on 17.01.2017.
 */
public class TimeEvent extends MessageEvent {

    private LocalTime _time;

    /**
     * Instantiates a new Time event.
     *
     * @param tokens    the tokens
     * @param sender    the sender
     * @param timestamp the timestamp
     * @param time      the time
     * @param messageId the message id
     */
    public TimeEvent(List<String> tokens, Participant sender, LocalDateTime timestamp, LocalTime time, int messageId) {

        super(tokens, sender, timestamp, messageId);
        this._time = time;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public LocalTime getTime() {
        return _time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(LocalTime time) {
        this._time = time;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TimeEvent) {
            TimeEvent timeEvent = (TimeEvent) obj;
            return timeEvent.canEquals(this) && super.equals(timeEvent) && _time == timeEvent._time;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 41 * super.hashCode() + Double.hashCode(_time.getHour());
    }

    @Override
    public boolean canEquals(Object obj) {
        return obj instanceof TimeEvent;
    }

    @Override
    public String toString() {
        return "TimeEvent(" + getMessageId() + ", " + _time + ")";
    }
}
