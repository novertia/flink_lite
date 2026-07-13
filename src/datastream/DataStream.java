package datastream;

import Sink.Sink;
import Source.Source;
import operators.Operator;
import operators.SinkOperator;
import operators.SourceOperator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DataStream {
    ExecutorService executorService;
    Operator head;
    Operator tail;
    public DataStream(){
        head=null;
        tail=null;
        executorService = Executors.newFixedThreadPool(3);
    }

    public DataStream addSource(Source s){
        tail = new SourceOperator(s);
        head= tail;
        return this;
    }

    public void addSink(Sink s){
        tail = new SinkOperator(s, tail);
    }

    public void execute(){
        Operator end = tail;
        while(end != null){
            executorService.execute(end);
            end = end.getUpstream();
        }
    }

    public void addShutDownDataStreamHook(){
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            executorService.shutdownNow(); // THIS is what interrupts the workers
            try {
                executorService.awaitTermination(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }));
    }
}
