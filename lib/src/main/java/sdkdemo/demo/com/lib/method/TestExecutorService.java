package sdkdemo.demo.com.lib.method;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by  sjx  on 2020/10/30
 */
public class TestExecutorService {
    ExecutorService service = Executors.newSingleThreadExecutor();

    public void sendMsg(List<String> list) {
        if (list != null) {
            for (String l : list) {
                handleMsg(l);
            }
        }
    }

    private void handleMsg(final String msg) {
        service.execute(new Runnable() {
            public void run() {
                System.out.println("msg : " + msg);
            }
        });
    }

    public void shutdown() {
        service.shutdown();
    }
}
