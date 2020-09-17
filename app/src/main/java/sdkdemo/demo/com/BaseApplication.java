package sdkdemo.demo.com;

import android.app.Application;
import android.content.Context;
import com.sjx.handlereventbus.eventbus.RxBus;

/**
 * Created by  sjx  on 2020/7/23
 */
public class BaseApplication extends Application {
    private static Context instance;
    public void onCreate() {
        super.onCreate();
        instance = this;
        RxBus.getInstance().init(this);
    }

    public static Context getContext(){
        return instance;
    }
}
