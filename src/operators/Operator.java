package operators;



import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public abstract class Operator implements Runnable {
    BlockingQueue<String> buffer;

    Operator upstream;

    Operator(){
        buffer = new ArrayBlockingQueue<String>(10);
    }

    public Operator getUpstream() {
        return upstream;
    }
}
