package sdkdemo.demo.com.lib.method;

/**
 * Created by  sjx  on 2020/10/16
 */
public class CustomWorker implements Runnable {

    public Thread t = new Thread(this);
    CustomBlockingQueue queue;

    public CustomWorker(CustomBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (queue.take(0) != null) {
            System.out.println(Thread.currentThread().getName() + "  result : " + queue.take(0));
            queue.remove();
        }
    }
}
