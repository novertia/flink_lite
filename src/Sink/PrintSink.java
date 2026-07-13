package Sink;

public class PrintSink implements Sink {
    public void push(String data){
        System.out.println(data);
    }
}
