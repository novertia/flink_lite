package operators;

import Source.Source;

import java.util.function.Function;

public class MapOperator extends Operator {
    Function<String, String> func;

    public MapOperator(Function<String, String> func, Operator upstream){
        this.func = func;
        this.upstream = upstream;
    }
    public void run() {
        try {
            while(true) {
                String data = upstream.buffer.take();
                buffer.put(func.apply(data));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
