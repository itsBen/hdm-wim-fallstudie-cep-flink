package de.hdm.wim.classes;

import de.hdm.wim.events.MessageEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 16.01.2017.
 */
public class Chat {

    private LocalDateTime chatStart;
    private LocalDateTime chatEnd;

    private List<Participant> participants = new ArrayList<Participant>();
    public List<MessageEvent> messages = new ArrayList<MessageEvent>();

    /**
     * Gets chat start.
     *
     * @return the chat start
     */
    public LocalDateTime getChatStart() {
        return chatStart;
    }

    /**
     * Sets chat start.
     *
     * @param chatStart the chat start
     */
    public void setChatStart(LocalDateTime chatStart) {
        this.chatStart = chatStart;
    }

    /**
     * Gets chat end.
     *
     * @return the chat end
     */
    public LocalDateTime getChatEnd() {
        return chatEnd;
    }

    /**
     * Sets chat end.
     *
     * @param chatEnd the chat end
     */
    public void setChatEnd(LocalDateTime chatEnd) {
        this.chatEnd = chatEnd;
    }

    /**
     * Gets participants.
     *
     * @return the participants
     */
    public List<Participant> getParticipants() {
        return participants;
    }

    /**
     * Add participants.
     *
     * @param participant the participant
     */
    public void addParticipant(Participant participant){
        this.participants.add(participant);
    }

    /**
     * Gets messages.
     *
     * @return the messages
     */
    public List<MessageEvent> getMessages() {
        return messages;
    }

    /**
     * Add message.
     *
     * @param message the message
     */
    public void addMessage(MessageEvent message) {
        this.messages.add(message);
    }
}
