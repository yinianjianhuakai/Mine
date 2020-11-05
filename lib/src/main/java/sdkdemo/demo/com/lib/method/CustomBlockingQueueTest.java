package sdkdemo.demo.com.lib.method;

import java.util.Random;

/**
 * Created by  sjx  on 2020/10/16
 */
public class CustomBlockingQueueTest {
    CustomBlockingQueue task = new CustomBlockingQueue();
    CustomWorker        worker;

    public void execute(String str) {
        if (worker == null) {
            worker = new CustomWorker(task);
            worker.t.start();
        }
        task.offer(str);
    }

    public void doTask() {
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    long millis = new Random().nextInt(3000);
                    execute(String.valueOf(i) + " : " + millis);
                    try {
                        Thread.sleep(millis);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void doTask1() {
        final CustomThreadExecutor executor = new CustomThreadExecutor();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    final int  finalI = i;
                    final long millis = new Random().nextInt(3000);
                    executor.executor(new Runnable() {
                        public void run() {
                            System.out.println(Thread.currentThread().getName() + " : " + finalI + "  :  " + millis);
                        }
                    });
                    try {
                        Thread.sleep(millis);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
