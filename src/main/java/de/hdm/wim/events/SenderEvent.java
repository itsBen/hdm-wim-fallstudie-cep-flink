package de.hdm.wim.events;

import de.hdm.wim.classes.Participant;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Ben on 18.01.2017.
 */
public class SenderEvent extends MessageEvent {

    public SenderEvent(List<String> tokens, Participant sender, LocalDateTime timestamp, int messageId) {
        super(tokens, sender, timestamp, messageId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SenderEvent) {
            SenderEvent senderEvent = (SenderEvent) obj;
            return senderEvent.canEquals(this) && super.equals(senderEvent) && this.getSender() == senderEvent.getSender();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 41 * super.hashCode() + Double.hashCode(getSender().getFirstName().length());
    }

    @Override
    public boolean canEquals(Object obj) {
        return obj instanceof SenderEvent;
    }

    @Override
    public String toString() {
        return String.format(
                "SenderEvent ID: " + getMessageId()
                        + ", Sender: " + getSender().getFirstName()
        );
    }
}
