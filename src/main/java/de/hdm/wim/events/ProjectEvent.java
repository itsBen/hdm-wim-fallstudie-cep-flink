package de.hdm.wim.events;

import de.hdm.wim.classes.Participant;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Ben on 17.01.2017.
 */
public class ProjectEvent extends MessageEvent {

    private String _projectName;

    /**
     * Instantiates a new Project event.
     *
     * @param tokens      the tokens
     * @param sender      the sender
     * @param timestamp   the timestamp
     * @param projectName the project name
     * @param messageId   the message id
     */
    public ProjectEvent(List<String> tokens, Participant sender, LocalDateTime timestamp, String projectName, int messageId) {
        super(tokens, sender, timestamp, messageId);
        this._projectName = projectName;
    }

    /**
     * Gets project name.
     *
     * @return the project name
     */
    public String getProjectName() {
        return _projectName;
    }

    /**
     * Sets project name.
     *
     * @param projectName the project name
     */
    public void setProjectName(String projectName) {
        this._projectName = projectName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProjectEvent) {
            ProjectEvent projectEvent = (ProjectEvent) obj;
            return projectEvent.canEquals(this) && super.equals(projectEvent) && _projectName == projectEvent._projectName;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 41 * super.hashCode() + Double.hashCode(_projectName.length());
    }

    @Override
    public boolean canEquals(Object obj) {
        return obj instanceof ProjectEvent;
    }

    @Override
    public String toString() {
        return String.format(
                "ProjectEvent ID: " + getMessageId()
                        + ", Sender: " + getSender().getFirstName()
                        + ", ProjectName: " + _projectName
        );
    }
}
