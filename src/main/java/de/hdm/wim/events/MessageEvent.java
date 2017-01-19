package de.hdm.wim.events;

import de.hdm.wim.classes.Participant;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 15.01.2017.
 */
public class MessageEvent {

    private int _messageId;
    private List<String> _tokens = new ArrayList<String>();
    private Participant _sender;
    private LocalDateTime _timestamp;

    public MessageEvent(List<String> tokens, Participant sender, LocalDateTime timestamp, int messageId) {
        this._tokens = tokens;
        this._sender = sender;
        this._timestamp = timestamp;
        this._messageId = messageId;
    }

    public MessageEvent(){}

    public List<String> getTokens() {
        return _tokens;
    }

    public void setTokens(List<String> _tokens) {
        this._tokens = _tokens;
    }

    public void addToken(String token) {
        this._tokens.add(token);
    }

    public Participant getSender() {
        return _sender;
    }

    public void setSender(Participant sender) {
        this._sender = sender;
    }

    public LocalDateTime getTimestamp() {
        return _timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this._timestamp = timestamp;
    }

    public int getMessageId() {
        return _messageId;
    }

    public void setMessageId(int _messageId) {
        this._messageId = _messageId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent) obj;
            return messageEvent.canEquals(this) && _messageId == messageEvent._messageId;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return _messageId;
    }

    @Override
    public String toString() {
        return String.format(
                "MessageEvent ID: " + getMessageId()
                        + ", Sender: " + getSender().getFirstName()
                        + ", Tokens: " + getTokens()
        );
    }

    public boolean canEquals(Object obj) {
        return obj instanceof MessageEvent;
    }
}