package de.hdm.wim.cep.patterns;

import de.hdm.wim.events.MessageEvent;
import org.apache.flink.cep.CEP;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * Created by Ben on 19.01.2017.
 */
public class SenderPattern {

    /**
     * Run.
     *
     * @param env           the env
     * @param senderStream the message stream
     */
    public void run(StreamExecutionEnvironment env, DataStream<MessageEvent> senderStream ) {

        Pattern<MessageEvent, ?> senderPattern = Pattern
                .<MessageEvent>begin("first")
                .where(evt -> evt.getSender().getFirstName()== "Mike");

        // Create a pattern stream from our project pattern
        PatternStream<MessageEvent> senderPatternStream = CEP.pattern(
                senderStream,
                senderPattern);

//            // Generate ProjectEvents for each matched project pattern
//            DataStream<String>senderStream = senderPatternStream.select(
//                    (Map<String, MessageEvent> pattern) -> {
//                        SenderEvent senderEvent = (SenderEvent) pattern.get("first");
//
//                        System.out.print("senderStream");
//
//                        return senderEvent.getSender().getFirstName();
//                    }
//            );

        // Generate ProjectEvents for each matched project pattern
        DataStream<MessageEvent> result = senderPatternStream.select(
                pattern -> {
                    return pattern.get("first");
                }
        );

        // print to stdout
        result.print();
    }
}
