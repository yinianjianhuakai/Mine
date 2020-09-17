package sdkdemo.demo.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import sdkdemo.demo.com.myapplicatione.R;
import sdkdemo.demo.com.view.TimerView;

/**
 * Created by  sjx  on 2020/8/4
 */
public class TimeActivity extends Activity {

    private TimerView mTimerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_time_activity);

        mTimerView = findViewById(R.id.time_id);
    }

    protected void onDestroy() {
        if (mTimerView != null) {
            mTimerView.release();
        }
        super.onDestroy();
    }
}
