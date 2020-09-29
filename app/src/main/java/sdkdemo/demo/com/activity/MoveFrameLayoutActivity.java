package sdkdemo.demo.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import sdkdemo.demo.com.myapplicatione.R;
import sdkdemo.demo.com.view.MoveFrameLayout;

/**
 * Created by  sjx  on 2020/9/28
 */
public class MoveFrameLayoutActivity extends Activity implements View.OnClickListener {

    MoveFrameLayout frame_layout;
    View            oneView;
    View            twoView;
    boolean flag = true;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_move_frame_acitivity);
        frame_layout = findViewById(R.id.frame_layout);
        oneView = findViewById(R.id.one_id);
        twoView = findViewById(R.id.two_id);
        findViewById(R.id.animation_move_id).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (flag){
            flag = !flag;
            frame_layout.animation(oneView, twoView);
        }else{
            flag = !flag;
            frame_layout.animation(twoView, oneView);
        }
    }
}
