package de.hdm.wim.cep.patterns;

import org.apache.flink.cep.CEP;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * Created by Ben on 20.01.2017.
 */
public class RelationToDatePattern {
    /**
     * Run.
     *
     * @param env         the env
     * @param tokenStream the message stream
     */
    public void run(StreamExecutionEnvironment env, DataStream<String> tokenStream ) {

        Pattern<String, ?> relationToDatePattern = Pattern
                .<String>begin("first")
                .where(tkn -> tkn.equals("next"))
                .followedBy("date");

        // Create a pattern stream from our project pattern
        PatternStream<String>relationToDatePatternStream = CEP.pattern(
                //messageStream.keyBy("_messageId"),
                tokenStream,
                relationToDatePattern);

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
        DataStream<String> result = relationToDatePatternStream.select(
                pattern -> {
                    return pattern.get("first");
                }
        );

        // print to stdout
        result.print();
    }
}
