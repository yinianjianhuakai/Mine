package sdkdemo.demo.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import sdkdemo.demo.com.myapplicatione.R;
import sdkdemo.demo.com.view.TimeSurfaceView;

/**
 * Created by  sjx  on 2020/8/6
 */
public class TimeSurfaceActivity extends Activity {

    private TimeSurfaceView mTimeSurfaceView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_time_surface_activity);

        mTimeSurfaceView = findViewById(R.id.time_surface_id);
    }

    protected void onDestroy() {
        mTimeSurfaceView.release();
        super.onDestroy();
    }
}
