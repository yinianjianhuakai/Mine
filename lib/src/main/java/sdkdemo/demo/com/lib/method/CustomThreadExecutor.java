package sdkdemo.demo.com.lib.method;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by  sjx  on 2020/10/15
 */
public class CustomThreadExecutor {
    BlockingQueue<Runnable> queue = new LinkedBlockingQueue();
    Worker worker;

    public void executor(Runnable runnable){
        if (queue.isEmpty()){
            queue.offer(runnable);
        }
        if (worker == null){
            worker = new Worker();
            worker.t.start();
        }
    }

    private class Worker implements Runnable{

        Thread t = new Thread(this);

        public Worker(){
            Thread.currentThread().setName("pool-Thread-");
            System.out.println(Thread.currentThread().getName());
        }

        @Override
        public void run() {
            Runnable task;
            while ((task = getTask()) != null){
                task.run();
            }
        }
    }

    private Runnable getTask(){
        try {
            Runnable runnable = queue.take();
            return runnable;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
