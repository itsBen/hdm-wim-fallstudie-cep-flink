package de.hdm.wim.source;


/**
 * Created by Ben on 15.01.2017.
 */

/*

public class test {



    public static void main(String[] args) throws Exception {


        final StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();


        DataStream<SpeechToken> tokens = env.addSource(new SpeechToken());

        //Read from a socket stream at map it to StockPrice objects
        DataStream<StockPrice> socketStockStream = env
                .socketTextStream("localhost", 9999)
                .map(new MapFunction<String, StockPrice>() {
                    private String[] tokens;

                    @Override
                    public StockPrice map(String value) throws Exception {
                        tokens = value.split(",");
                        return new StockPrice(tokens[0],
                                Double.parseDouble(tokens[1]));
                    }
                });

        //Generate other stock streams
        DataStream<StockPrice> SPX_stream = env.addSource(new StockSource("SPX", 10));
        DataStream<StockPrice> FTSE_stream = env.addSource(new StockSource("FTSE", 20));
        DataStream<StockPrice> DJI_stream = env.addSource(new StockSource("DJI", 30));
        DataStream<StockPrice> BUX_stream = env.addSource(new StockSource("BUX", 40));

        //Merge all stock streams together
        DataStream<StockPrice> stockStream = socketStockStream
                .merge(SPX_stream, FTSE_stream, DJI_stream, BUX_stream);

        stockStream.print();

        env.execute("Stock stream");


    }

    private static final ArrayList<String> SYMBOLS = new ArrayList<String>(
            Arrays.asList("SPX", "FTSE", "DJI", "DJT", "BUX", "DAX", "GOOG"));

    public static class StockPrice implements Serializable {

        public String symbol;
        public Double price;

        public StockPrice() {
        }

        public StockPrice(String symbol, Double price) {
            this.symbol = symbol;
            this.price = price;
        }

        @Override
        public String toString() {
            return "StockPrice{" +
                    "symbol='" + symbol + '\'' +
                    ", count=" + price +
                    '}';
        }
    }

    public final static class StockSource implements SourceFunction<StockPrice> {

        private Double price;
        private String symbol;
        private Integer sigma;

        public StockSource(String symbol, Integer sigma) {
            this.symbol = symbol;
            this.sigma = sigma;
        }

        @Override
        public void invoke(Collector<StockPrice> collector) throws Exception {
            price = DEFAULT_PRICE;
            Random random = new Random();

            while (true) {
                price = price + random.nextGaussian() * sigma;
                collector.collect(new StockPrice(symbol, price));
                Thread.sleep(random.nextInt(200));
            }
        }
    }

}

public class test {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Tuple2<String, Integer>> dataStream = env
                .socketTextStream("localhost", 6123)
                .flatMap(new Splitter())
                .keyBy(0)
                .timeWindow(Time.seconds(30))
                .sum(1);

        dataStream.print();

        env.execute("Window WordCount");
    }

    public static class Splitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String sentence, Collector<Tuple2<String, Integer>> out) throws Exception {
            for (String word: sentence.split(" ")) {
                out.collect(new Tuple2<String, Integer>(word, 1));
            }
        }
    }

}
*/


/**
 * This example shows an implementation of WordCount with data from a text
 * socket. To run the example make sure that the service providing the text data
 * is already up and running.
 * <p>
 * To start an example socket text stream on your local machine run netcat from
 * a command line: <code>nc -lk 9999</code>, where the parameter specifies the
 * port number.
 * </p>
 * <p>
 * Usage:
 * <code>SocketTextStreamWordCount &lt;hostname&gt; &lt;port&gt; &lt;result path&gt;</code>
 * </p>
 * <p>
 * This example shows how to:
 * <ul>
 * <li>use StreamExecutionEnvironment.socketTextStream
 * <li>write a simple Flink program,
 * <li>write and use user-defined functions.
 * </ul>
 *
 * @see <a href="www.openbsd.org/cgi-bin/man.cgi?query=nc">netcat</a>
 */
/*
public class test {
    public static void main(String[] args) throws Exception {

        if (!parseParameters(args)) {
            return;
        }

        // set up the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment
                .getExecutionEnvironment();

        // get input data
        DataStream<String> text = env.socketTextStream("localhost", 6123, '\n', 0);

        DataStream<Tuple2<String, Integer>> counts =
                // split up the lines in pairs (2-tuples) containing: (word,1)
                text.flatMap(new Tokenizer())
                        // group by the tuple field "0" and sum up tuple field "1"
                        .keyBy(0)
                        .sum(1);

        if (fileOutput) {
            counts.writeAsText("C:/", FileSystem.WriteMode.OVERWRITE);
        } else {
            counts.print();
        }

        // execute program
        env.execute("WordCount from SocketTextStream Example");
    }

    // *************************************************************************
    // UTIL METHODS
    // *************************************************************************

    private static boolean fileOutput = true;
    private static String hostName;
    private static int port;
    private static String outputPath;

    private static boolean parseParameters(String[] args) {

        // parse input arguments
        if (args.length == 3) {
            fileOutput = true;
            hostName = args[0];
            port = Integer.valueOf(args[1]);
            outputPath = args[2];
        } else if (args.length == 2) {
            hostName = args[0];
            port = Integer.valueOf(args[1]);
        } else {
            System.err.println("Usage: SocketTextStreamWordCount <hostname> <port> [<output path>]");
            return false;
        }
        return true;
    }



    // *************************************************************************
    // USER FUNCTIONS
    // *************************************************************************

    /**
     * Implements the string tokenizer that splits sentences into words as a
     * user-defined FlatMapFunction. The function takes a line (String) and
     * splits it into multiple pairs in the form of "(word,1)" ({@code Tuple2<String,
     * Integer>}).
     *
    public static final class Tokenizer implements FlatMapFunction<String, Tuple2<String, Integer>> {
        private static final long serialVersionUID = 1L;

        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> out)
                throws Exception {
            // normalize and split the line
            String[] tokens = value.toLowerCase().split("\\W+");

            // emit the pairs
            for (String token : tokens) {
                if (token.length() > 0) {
                    out.collect(new Tuple2<String, Integer>(token, 1));
                }
            }
        }
    }

}*/

