package sdkdemo.demo.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import sdkdemo.demo.com.myapplicatione.R;

/**
 * Created by  sjx  on 2020/11/19
 */
public class ProgressBarActivity extends Activity {

    Button      but1;
    Button      but2;
    ProgressBar pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_progress_bar_activity);
        pro = (ProgressBar) findViewById(R.id.progressbar1);
        SeekBar mSeekBar = findViewById(R.id.seek_bar);
        but1 = (Button) findViewById(R.id.but1);
        but2 = (Button) findViewById(R.id.but2);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro.incrementProgressBy(-10);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro.incrementProgressBy(10);
            }
        });

        pro.setOnDragListener(new View.OnDragListener() {
            public boolean onDrag(View v, DragEvent event) {
                Log.i("Test", "DragEvent " + event.getX());
                return false;
            }
        });
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Test", "progress : " + progress + " fromUser : " + fromUser);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
