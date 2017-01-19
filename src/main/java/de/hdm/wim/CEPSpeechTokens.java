package de.hdm.wim;

import de.hdm.wim.events.MessageEvent;
import de.hdm.wim.patterns.SenderPattern;
import de.hdm.wim.patterns.TestPattern;
import de.hdm.wim.source.MessageEventSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * Created by Ben on 16.01.2017.
 */
public class CEPSpeechTokens {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {

            final StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();
            env.setParallelism(1); // set Parallelism to 1 Task, to get chat order right

            MessageEventSource evtSrc = new MessageEventSource();

            // create a DataStream of MessageEvent from our source
            DataStream<MessageEvent> messageStream = env
                    .addSource(evtSrc);


            TestPattern testPattern = new TestPattern();
            testPattern.run(env,messageStream);

            SenderPattern senderPattern = new SenderPattern();
            senderPattern.run(env,messageStream);


            /*
            // Warning pattern: Two consecutive temperature events whose temperature is higher than the given threshold
            // appearing within a time interval of 10 seconds
            Pattern<MessageEvent, ?> projectPattern = Pattern.<MessageEvent>begin("first")
                    .subtype( ProjectEvent.class )
                    .where( evt -> evt.getTokens().contains("concerning") );
                            //.stream()
                            //.anyMatch( token -> token.equals("concerning") )
                    //);
//                            .anyMatch( token -> (token.equals("concerning") || token.equals("regarding") ) && token.equals("project") ));

            // Create a pattern stream from our project pattern
            PatternStream<MessageEvent> projectPatternStream = CEP.pattern(
                    messageStream.keyBy("_messageId"),
                    projectPattern);

            // Generate ProjectEvents for each matched project pattern
            DataStream<ProjectEvent> projectStream = projectPatternStream.select(
                    (Map<String, MessageEvent> pattern) -> {
                        ProjectEvent projectEvent = (ProjectEvent) pattern.get("first");

                        return projectEvent;
                    }
            );

            // print to stdout
            //projectStream.print();


*/
            // print message stream
            messageStream.print();


            env.execute("CEP chat stream job");
        }
}