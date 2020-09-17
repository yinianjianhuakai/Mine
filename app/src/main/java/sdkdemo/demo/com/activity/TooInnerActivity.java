package sdkdemo.demo.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import sdkdemo.demo.com.myapplicatione.R;
import sdkdemo.demo.com.utils.NetRequest;

/**
 * Created by  sjx  on 2020/8/25
 */
public class TooInnerActivity extends Activity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_too_inner_activity);
        findViewById(R.id.requestNet).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.requestNet:
                request();
                break;
        }
    }

    private void request() {
        new Thread(){
            public void run() {
                new NetRequest().getRequestJson();
            }
        }.start();
    }
}
