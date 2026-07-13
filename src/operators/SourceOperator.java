package operators;

import Source.Source;

import java.util.LinkedList;

public class SourceOperator extends Operator {
    Source s;

    public SourceOperator(Source s){
        this.s = s;
        this.upstream = null;
    }
    public void run() {
        try {
            while(true) {
                String data = s.getData();
                buffer.put(data);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
