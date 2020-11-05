package sdkdemo.demo.com.lib.method;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  sjx  on 2020/10/30
 */
public class TestThreadInterruptMethod {
    public void doMethod() {
        execute();
    }

    private void execute() {
        TestThreadInterrupt queue = new TestThreadInterrupt();
//        while (true) {
        queue.sendMsg("Start : " + Thread.currentThread().getName());

        sleep(1 * 1000);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("execute -- > " + i);
            if (i==2){
                queue.shutDown();
//                queue.shutDown();
            }
        }
        queue.sendMsg(list);

        sleep(2 * 1000);
        queue.sendMsg("END ...");

        sleep(2 * 1000);
        queue.sendMsg("Result End ...... ");

        sleep(3 * 1000);
//        queue.shutDown();
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
