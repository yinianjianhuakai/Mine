package sdkdemo.demo.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.sjx.handlereventbus.eventbus.OnRxEventListener;
import com.sjx.handlereventbus.eventbus.RxBus;
import com.sjx.handlereventbus.eventbus.RxData;
import sdkdemo.demo.com.activity.*;
import sdkdemo.demo.com.myapplicatione.R;
import sdkdemo.demo.com.test.TestEventBusOnObject;
import sdkdemo.demo.com.utils.CameraPermission;

import java.util.Random;

public class MainActivity extends Activity implements OnRxEventListener {

    TestEventBusOnObject test;
    Handler mHandler = new Handler();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log("----onCreate----");
        RxBus.getInstance().register(this);

        test = new TestEventBusOnObject();
        test.removeElement();
        findViewById(R.id.send_tv).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RxData event = new RxData();
                event.setEventCode(11);
                event.setObj1("message -> " +new Random().nextInt(100));
//                event.setTarget(TestEventBusOnObject.class);
                RxBus.getInstance().send(event);
            }
        });

        findViewById(R.id.canvas_id).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        findViewById(R.id.camera_id).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "CameraPermission : " + CameraPermission.cameraIsCanUse(), Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.toast_id).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        Log.i("Test", "thread name : " + Thread.currentThread().getName());
                        Looper.prepare();
                        Toast.makeText(MainActivity.this, "12312131", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }
                }).start();
            }
        });

        findViewById(R.id.time_id).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimeActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        findViewById(R.id.time_surface_id).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimeSurfaceActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        findViewById(R.id.animation_move_id).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnimationMoveActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        findViewById(R.id.frame_move_id).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MoveFrameLayoutActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        findViewById(R.id.draw_bitmap_id).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrawBitmapActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        findViewById(R.id.too_inner_id).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TooInnerActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        findViewById(R.id.web_view_id).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomWebViewActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    public void onRxEvent(RxData event) {
        log("onEvent  code : " + event.getEventCode() + "  msg : " + event.getObj1() + "  target : "+event.getTargetName());
    }

    protected void onStart() {
        super.onStart();
        log("----onStart----");
    }

    protected void onResume() {
        super.onResume();
        log("----onResume----");
    }

    protected void onPause() {
        super.onPause();
        log("----onPause----");
    }

    protected void onStop() {
        super.onStop();
        log("----onStop----");
    }

    protected void onDestroy() {
        super.onDestroy();
        log("----onDestroy----");
        RxBus.getInstance().unRegister(this);
        test.clear();
    }

    protected void onRestart() {
        super.onRestart();
        log("----onRestart----");
    }

    private void log(String log){
        Log.i("TAG", log);
    }

}
