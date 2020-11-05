package sdkdemo.demo.com.lib.method;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by  sjx  on 2020/10/30
 */
public class TestExecutorShutDown {

    public void doMethod(){
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            public void run() {
                System.out.println("ExecutorService execute...");
                /*try {
                    Thread.sleep(100 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        });

        service.execute(new Runnable() {
            public void run() {
                System.out.println("ExecutorService execute...222222");
                /*try {
                    Thread.sleep(100 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        });

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
