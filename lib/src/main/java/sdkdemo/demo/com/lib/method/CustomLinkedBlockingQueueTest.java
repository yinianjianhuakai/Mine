package sdkdemo.demo.com.lib.method;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by  sjx  on 2020/10/28
 */
public class CustomLinkedBlockingQueueTest {

//    ExecutorService service = Executors.newSingleThreadExecutor();

    public void doMethod() {
        /*service.execute(new Runnable() {
            public void run() {
                execute();
            }
        });*/
        execute();
    }

    private void execute() {
        CustomLinkedBlockingQueue queue = new CustomLinkedBlockingQueue(new LinkedBlockingQueue<String>());
//        while (true) {
            queue.sendMsg("Start : " + Thread.currentThread().getName());

            sleep(1 * 1000);

            List<String> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                list.add("execute -- > " + i);
            }
            queue.sendMsg(list);

            sleep(2 * 1000);
            queue.sendMsg("END ...");

            sleep(2 * 1000);
            queue.sendMsg("Result End ...... ");

            sleep(3 * 1000);
            queue.shutDown();
//        service.shutdown();
//        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
            System.out.println("sleep " + millis / 1000 + " seconds...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
