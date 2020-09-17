package sdkdemo.demo.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import sdkdemo.demo.com.myapplicatione.R;

/**
 * Created by  sjx  on 2020/7/23
 */
public class TestActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_test_activity);
    }
}
