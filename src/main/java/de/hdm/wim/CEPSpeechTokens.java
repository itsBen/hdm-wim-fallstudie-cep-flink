package de.hdm.wim;

import de.hdm.wim.source.EventSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.LocalStreamEnvironment;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.List;

/**
 * Created by Ben on 16.01.2017.
 */
public class CEPSpeechTokens {

        public static void main(String[] args) throws Exception {


            final StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();

            final LocalStreamEnvironment env2 = LocalStreamEnvironment.createLocalEnvironment();




            EventSource evtSrc = new EventSource();


            DataStream<List<List<String>>> messageStream2 = env2
                    .addSource(evtSrc);


            DataStream<List<List<String>>> messageStream = env
                    .addSource(evtSrc);


            System.out.print("blubb");




            // print to stdout
            messageStream.print();
            messageStream2.print();

            env.execute("CEP monitoring job");

            env2.execute("CEP monitoring job2");

        }
}