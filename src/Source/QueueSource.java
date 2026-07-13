package Source;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueSource implements Source {
    BlockingQueue<String> stringQueue;
    public QueueSource(){
        stringQueue = new ArrayBlockingQueue<String>(10);
    }
    public String getData() throws InterruptedException {
        return stringQueue.take();
    }

    public void insertData(String data) throws InterruptedException{
        stringQueue.put(data);
    }

}
