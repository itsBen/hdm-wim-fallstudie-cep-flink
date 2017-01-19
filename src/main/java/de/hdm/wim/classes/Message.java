package de.hdm.wim.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 16.01.2017.
 */
public class Message {

    public String message;
    public List<String> tokens = new ArrayList<String>();
    public Participant sender;
    public LocalDateTime timestamp;

    public Message(List<String> tokens, Participant sender, LocalDateTime timestamp) {
        this.tokens = tokens;
        this.sender = sender;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }

    public void addToken(String token) {
        this.tokens.add(token);
    }

    public Participant getSender() {
        return sender;
    }

    public void setSender(Participant sender) {
        this.sender = sender;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
