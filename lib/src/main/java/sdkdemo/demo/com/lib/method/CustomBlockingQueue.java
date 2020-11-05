package sdkdemo.demo.com.lib.method;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by  sjx  on 2020/10/16
 */
public class CustomBlockingQueue {
    private List<String>  mList;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition     notEmpty      = reentrantLock.newCondition();

    public CustomBlockingQueue() {
        mList = new ArrayList<>();
        System.out.println(Thread.currentThread().getName());
    }

    public void offer(String str) {
        mList.add(str);
        if (mList.size() == 1) {
            reentrantLock.lock();
            try {
                notEmpty.signal();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public String take(int index) {
        while (mList.size() == 0) {
            reentrantLock.lock();
            try {
                notEmpty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
        return mList.get(index);
    }

    public void remove() {
        mList.remove(0);
    }

}
