package operators;

import Sink.Sink;

public class SinkOperator extends Operator {
    Sink s;
    public SinkOperator(Sink s, Operator upstream){
        this.s= s;
        this.upstream = upstream;
    }

    public void run(){
        try{
            while(true) {
                String data = upstream.buffer.take();
                s.push(data);
            }
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
