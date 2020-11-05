package sdkdemo.demo.com.lib.method;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by  sjx  on 2020/10/30
 */
public class TestThreadInterrupt implements Runnable {
    Thread                      t     = new Thread(this);
    LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public TestThreadInterrupt() {
        t.start();
    }

    @Override
    public void run() {
        String task;
        while ((task = getTask()) != null) {

            System.out.println("Looper : " + task);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMsg(Object obj) {
        if (queue != null) {
            if (obj instanceof String) {
                queue.add((String) obj);
            } else if (obj instanceof List) {
                queue.addAll((Collection<? extends String>) obj);
            }
        }
    }

    private String getTask() {
        String task = null;
        try {
            task = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return task;
    }

    public void shutDown() {
        t.interrupt();
    }
}
