package de.hdm.wim.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 16.01.2017.
 */
public class Message {

    /**
     * The Message.
     */
    public String message;
    /**
     * The Tokens.
     */
    public List<String> tokens = new ArrayList<String>();
    /**
     * The Sender.
     */
    public Participant sender;
    /**
     * The Timestamp.
     */
    public LocalDateTime timestamp;

    /**
     * Instantiates a new Message.
     *
     * @param tokens    the tokens
     * @param sender    the sender
     * @param timestamp the timestamp
     */
    public Message(List<String> tokens, Participant sender, LocalDateTime timestamp) {
        this.tokens = tokens;
        this.sender = sender;
        this.timestamp = timestamp;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets tokens.
     *
     * @return the tokens
     */
    public List<String> getTokens() {
        return tokens;
    }

    /**
     * Sets tokens.
     *
     * @param tokens the tokens
     */
    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }

    /**
     * Add token.
     *
     * @param token the token
     */
    public void addToken(String token) {
        this.tokens.add(token);
    }

    /**
     * Gets sender.
     *
     * @return the sender
     */
    public Participant getSender() {
        return sender;
    }

    /**
     * Sets sender.
     *
     * @param sender the sender
     */
    public void setSender(Participant sender) {
        this.sender = sender;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
