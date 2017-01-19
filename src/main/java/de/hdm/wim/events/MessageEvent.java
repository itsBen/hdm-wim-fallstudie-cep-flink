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

    /**
     * Instantiates a new Message event.
     *
     * @param tokens    the tokens
     * @param sender    the sender
     * @param timestamp the timestamp
     * @param messageId the message id
     */
    public MessageEvent(List<String> tokens, Participant sender, LocalDateTime timestamp, int messageId) {
        this._tokens = tokens;
        this._sender = sender;
        this._timestamp = timestamp;
        this._messageId = messageId;
    }

    /**
     * Instantiates a new Message event.
     */
    public MessageEvent(){}

    /**
     * Gets tokens.
     *
     * @return the tokens
     */
    public List<String> getTokens() {
        return _tokens;
    }

    /**
     * Sets tokens.
     *
     * @param _tokens the tokens
     */
    public void setTokens(List<String> _tokens) {
        this._tokens = _tokens;
    }

    /**
     * Add token.
     *
     * @param token the token
     */
    public void addToken(String token) {
        this._tokens.add(token);
    }

    /**
     * Gets sender.
     *
     * @return the sender
     */
    public Participant getSender() {
        return _sender;
    }

    /**
     * Sets sender.
     *
     * @param sender the sender
     */
    public void setSender(Participant sender) {
        this._sender = sender;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public LocalDateTime getTimestamp() {
        return _timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this._timestamp = timestamp;
    }

    /**
     * Gets message id.
     *
     * @return the message id
     */
    public int getMessageId() {
        return _messageId;
    }

    /**
     * Sets message id.
     *
     * @param _messageId the message id
     */
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

    /**
     * Can equals boolean.
     *
     * @param obj the obj
     * @return the boolean
     */
    public boolean canEquals(Object obj) {
        return obj instanceof MessageEvent;
    }
}