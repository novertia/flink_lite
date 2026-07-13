package main;

import Sink.PrintSink;
import Sink.Sink;
import Source.Source;

import Source.QueueSource;
import datastream.DataStream;

public class App {

    public static void main(String[] args) {
         Source source = new QueueSource();
         Sink sink = new PrintSink();
         DataStream stream = new DataStream();
         stream.addSource(source).addSink(sink);
         stream.execute();
         stream.addShutDownDataStreamHook();
         try {
             source.insertData("Hi Y all");
             source.insertData("This is my life");
         }
         catch (InterruptedException ignored){

         }
    }

}
