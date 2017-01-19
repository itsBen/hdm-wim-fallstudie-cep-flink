package de.hdm.wim.events;

import de.hdm.wim.classes.Participant;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Ben on 17.01.2017.
 */
public class TopicEvent extends MessageEvent {

    private String _topic;

    /**
     * Instantiates a new Topic event.
     *
     * @param tokens    the tokens
     * @param sender    the sender
     * @param timestamp the timestamp
     * @param topic     the topic
     * @param messageId the message id
     */
    public TopicEvent(List<String> tokens, Participant sender, LocalDateTime timestamp, String topic, int messageId) {

        super(tokens, sender, timestamp, messageId);
        this._topic = topic;
    }

    /**
     * Gets topic.
     *
     * @return the topic
     */
    public String getTopic() {
        return _topic;
    }

    /**
     * Sets topic.
     *
     * @param topic the topic
     */
    public void setTopic(String topic) {
        this._topic = topic;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TopicEvent) {
            TopicEvent topicEvent = (TopicEvent) obj;
            return topicEvent.canEquals(this) && super.equals(topicEvent) && _topic == topicEvent._topic;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 41 * super.hashCode() + Double.hashCode(_topic.length());
    }

    @Override
    public boolean canEquals(Object obj) {
        return obj instanceof TopicEvent;
    }

    @Override
    public String toString() {
        return "TopicEvent(" + getMessageId() + ", " + _topic + ")";
    }
}