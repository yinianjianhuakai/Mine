package sdkdemo.demo.com.lib.method;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by  sjx  on 2020/10/28
 */
public class CustomLinkedBlockingQueue {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition     notEmpty      = reentrantLock.newCondition();

    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    LinkedBlockingQueue<String> queue;

    public CustomLinkedBlockingQueue(LinkedBlockingQueue<String> queue) {
        this.queue = queue;
        looper();
    }

    public void sendMsg(Object obj) {
        if (queue != null) {
            if (obj instanceof String) {
                queue.add((String) obj);
            } else if (obj instanceof List) {
                queue.addAll((Collection<? extends String>) obj);
            }
            signal();
        }
    }

    private void looper() {
        executorService.execute(new Runnable() {
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
        });
    }

    private String getTask() {
        String task = queue.poll();
        if (task == null) {
            try {
                reentrantLock.lock();
                notEmpty.await();
                task = queue.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
        return task;
    }

    private void signal() {
        try {
            reentrantLock.lock();
            notEmpty.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void shutDown() {
        signal();
        executorService.shutdown();
    }
}

