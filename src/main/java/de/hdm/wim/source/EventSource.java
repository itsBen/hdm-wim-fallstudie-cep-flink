package de.hdm.wim.source;

import de.hdm.wim.classes.Chat;
import de.hdm.wim.classes.Message;
import de.hdm.wim.classes.Participant;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ben on 15.01.2017.
 */
public class EventSource implements SourceFunction<List<List<String>>> {

    private volatile boolean isRunning = true;

    @Override
    public void run(SourceContext<List<List<String>>> sourceContext) throws Exception {

        // set up 2 participants
        final Participant participant1 = new Participant("Mike", "Turbo");
        final Participant participant2 = new Participant("Sheila", "Pure");

        // define tokens
        List<String> tokens0 = Arrays.asList("Hey");
        List<String> tokens1 = Arrays.asList("Hello");
        List<String> tokens2 = Arrays.asList("lets", "talk", "about", "current",  "activities", "concerning", "HighNet", "project");
        List<String> tokens3 = Arrays.asList("ok", "shall", "we", "look", "at", "tasks", "leading","to", "milestone", "ahead" );
        List<String> tokens4 = Arrays.asList("sure", "we", "working", "on", "network","issues", "for", "diagnosis", "module", "item 3", "task", "list", "blabla", "we", "will", "come up", "with", "something", "viable", "shortly");
        List<String> tokens5 = Arrays.asList("that", "sounds", "great", "what", "about", "expenses", "do", "you", "think", "you", "will", "be", "able", "to", "stay", "whithin", "limits", "we", "aggreed", "upon", "last week");
        List<String> tokens6 = Arrays.asList("that", "should", "be", "no", "problem", "i", "will", "leave", "detailed", "report", "on", "google", "drive");
        List<String> tokens7 = Arrays.asList("ok", "thanks", "lets", "make", "appointment", "for", "our", "next", "meeting");
        List<String> tokens8 = Arrays.asList("let", "me", "check", "my", "calendar", "how", "about", "next", "thursday", "at", "16", "hours", "your", "time");
        List<String> tokens9 = Arrays.asList("perfect", "see", "you", "then", "bye");
        List<String> tokens10 = Arrays.asList("have", "a", "nice", "day", "bye");
        List<String> tokens11 = Arrays.asList("expenses", "previous", "monday");
        List<String> tokens12 = Arrays.asList("Let", "us", "make", "an", "appointment", "for", "next", "Monday", "at", "09", "am");
        List<String> tokens13 = Arrays.asList("Let's", "plan", "a", "meeting", "at", "16:00", "on", "next", "monday");
        List<String> tokens14 = Arrays.asList("expenses", "blaaa", "at", "1pm");

        // set up chat
        Chat chat = new Chat();
        chat.addParticipant(participant1);
        chat.addParticipant(participant2);

        chat.addMessage(new Message(tokens0, participant1, LocalDateTime.now()));
        chat.addMessage(new Message(tokens1, participant2, LocalDateTime.now()));
        chat.addMessage(new Message(tokens2, participant1, LocalDateTime.now()));
        chat.addMessage(new Message(tokens3, participant2, LocalDateTime.now()));
        chat.addMessage(new Message(tokens4, participant1, LocalDateTime.now()));
        chat.addMessage(new Message(tokens5, participant2, LocalDateTime.now()));
        chat.addMessage(new Message(tokens6, participant1, LocalDateTime.now()));
        chat.addMessage(new Message(tokens7, participant2, LocalDateTime.now()));
        chat.addMessage(new Message(tokens8, participant1, LocalDateTime.now()));
        chat.addMessage(new Message(tokens9, participant2, LocalDateTime.now()));
        chat.addMessage(new Message(tokens10, participant1, LocalDateTime.now()));
        chat.addMessage(new Message(tokens11, participant2, LocalDateTime.now()));
        chat.addMessage(new Message(tokens12, participant1, LocalDateTime.now()));
        chat.addMessage(new Message(tokens13, participant2, LocalDateTime.now()));
        chat.addMessage(new Message(tokens14, participant1, LocalDateTime.now()));


        List<List<String>> tokenss = Arrays.asList(
                tokens0,
                tokens1,
                tokens2,
                tokens3,
                tokens4,
                tokens5,
                tokens6,
                tokens7,
                tokens8,
                tokens9,
                tokens10,
                tokens11,
                tokens12,
                tokens13,
                tokens14
        );


        int count = 0;
        while (isRunning && count < 100) {
            sourceContext.collect(tokenss);
            count++;
        }
    }

    @Override
    public void cancel() {
        isRunning = false;
    }
}
