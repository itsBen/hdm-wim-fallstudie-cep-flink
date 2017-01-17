package de.hdm.wim.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 16.01.2017.
 */
public class Chat {

    private static LocalDateTime chatStart;
    private static LocalDateTime chatEnd;

    private List<Participant> participants = new ArrayList<Participant>();
    public List<Message> messages = new ArrayList<Message>();

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
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Add message.
     *
     * @param message the message
     */
    public void addMessage(Message message) {
        this.messages.add(message);
    }
}
