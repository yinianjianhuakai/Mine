package sdkdemo.demo.com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import org.jetbrains.annotations.Nullable;
import sdkdemo.demo.com.BaseApplication;
import sdkdemo.demo.com.utils.DateUtils;
import sdkdemo.demo.com.utils.DeviceInfoUtil;

/**
 * Created by  sjx  on 2020/8/4
 */
public class TimerView extends View {

    private Paint mPaint;
    private Path  mPath;

    private int width;
    private int height;
    private int centerX;
    private int centerY;

    private static final int  ACTION_REFRESH_TIME = 0x1001;
    private static final long TIME_DELAY          = 20;

    private Handler mHandler = new Handler(BaseApplication.getContext().getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ACTION_REFRESH_TIME:
                    invalidate();
                    break;
            }
        }
    };

    public TimerView(Context context) {
        super(context);
        init(context);
    }

    public TimerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TimerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPath = new Path();

        width = DeviceInfoUtil.getScreenWidth();
        height = DeviceInfoUtil.getScreenHeight();
        int statusBarHeight = DeviceInfoUtil.getStatusBarHeight(getContext());
        height = height - statusBarHeight;
        int halfWidth  = width / 2;
        int halfHeight = height / 2;
        centerX = halfWidth;
        centerY = halfHeight;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        rotateCircle(canvas);
        initTimerDis(canvas);
        refreshTime(canvas);
    }

    private void rotateCircle(Canvas canvas) {
        String[] array  = getTime();
        int      mini   = Integer.parseInt(array[1]);
        int      second = Integer.parseInt(array[2]);
        int      millis = Integer.parseInt(array[3]);

        mPaint.setColor(Color.LTGRAY);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);
        float lastY = 0;
        float lastX = 0;

        float totalAngel = 3600;
        totalAngel = totalAngel - 360 * (mini % 10);
//        totalAngel = totalAngel - second * (360 / 60);
        totalAngel = (float) (totalAngel - (second+(millis / 1000.0)) * (360 / 60));

        for (int i = 0; i < totalAngel; i = i + 1) {
            if (i == 0) {
                mPath.moveTo(centerX, centerY);
            } else {
//                float tempCenterX = (float) (centerX / 5.0 * 4 * i / totalAngel);
                float tempCenterX = (float) (centerX / 6.0 * 5 * (10 - mini % 10 - second / 60.0) / 10 * i / totalAngel);
                Log.i("Test", "tempCenterX : " + tempCenterX);
                float tempY       = (float) (centerY - tempCenterX * Math.cos(i * Math.PI / 180));
                float tempX       = (float) (centerX + tempCenterX * Math.sin(i * Math.PI / 180));
                lastY = tempY;
                lastX = tempX;
                mPath.lineTo(tempX, tempY);
            }
        }
        canvas.drawPath(mPath, mPaint);
        mPath.reset();

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(lastX, lastY, 5, mPaint);
    }

    private void refreshTime(Canvas canvas) {

        String[] array       = getTime();
        int      hour        = Integer.parseInt(array[0]) % 12;
        int      mini        = Integer.parseInt(array[1]);
        int      second      = Integer.parseInt(array[2]);
        int      millis      = Integer.parseInt(array[3]);
        float    hourAngel   = (float) (360 / 12 * hour + 360 / 12 * (mini / 60.0));
        float    miniAngel   = (float) (360 / 60 * mini + 360 / 60 * (second / 60.0));
        float    secondAngel = 360 / 60 * second;
        float    millisAngel = secondAngel + (float) (360.0 / 60 / 1000 * millis);
//        secondAngel = millisAngel;
//        Log.i("Test", "secondAngel : " + secondAngel + "  millisAngel : " + millisAngel);

        float hourY = (float) (centerY - centerX / 3 * 2 * Math.cos(hourAngel * Math.PI / 180));
        float hourX = (float) (centerX + centerX / 3 * 2 * Math.sin(hourAngel * Math.PI / 180));

        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(8);
        mPath.moveTo(centerX, centerY);
        mPath.lineTo(hourX, hourY);
        canvas.drawPath(mPath, mPaint);
        mPath.reset();


        float miniY = (float) (centerY - centerX / 5 * 4 * Math.cos(miniAngel * Math.PI / 180));
        float miniX = (float) (centerX + centerX / 5 * 4 * Math.sin(miniAngel * Math.PI / 180));

        mPaint.setColor(Color.parseColor("#5C1CB0"));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPath.moveTo(centerX, centerY);
        mPath.lineTo(miniX, miniY);
        canvas.drawPath(mPath, mPaint);
        mPath.reset();


        float y = (float) (centerY - centerX * Math.cos(secondAngel * Math.PI / 180));
        float x = (float) (centerX + centerX * Math.sin(secondAngel * Math.PI / 180));

        float sy = (float) (centerY - centerX / 8 * Math.cos((180 + secondAngel) * Math.PI / 180));
        float sx = (float) (centerX + centerX / 8 * Math.sin((180 + secondAngel) * Math.PI / 180));

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPath.moveTo(sx, sy);
        mPath.lineTo(x, y);
        canvas.drawPath(mPath, mPaint);
        mPath.reset();

        if (!mHandler.hasMessages(ACTION_REFRESH_TIME)) {
            mHandler.sendEmptyMessageDelayed(ACTION_REFRESH_TIME, TIME_DELAY);
        }
    }

    private void initTimerDis(Canvas canvas) {
        int sourceBR = centerX - 40;
        int sourceSR = sourceBR - 20;

        int tempBR = sourceBR + 10;
        int tempSR = sourceSR - 10;

        int bR;
        int sR;
        mPaint.setStyle(Paint.Style.STROKE);

        for (int i = 0; i <= 59; i++) {
            int angle = 360 / 60 * i;

            if ((i + 1) % 5 == 1) {
                if ((i % 15 == 0)){
                    mPaint.setColor(Color.RED);
                }else{
                    mPaint.setColor(Color.BLACK);
                }
                bR = tempBR;
                sR = tempSR;
                mPaint.setStrokeWidth(12);
            } else {
                bR = sourceBR;
                sR = sourceSR;
                mPaint.setStrokeWidth(5);
                mPaint.setColor(Color.BLUE);
            }

            float y = (float) (centerY - bR * Math.cos(angle * Math.PI / 180));
            float x = (float) (centerX + bR * Math.sin(angle * Math.PI / 180));

            float sy = (float) (centerY - sR * Math.cos(angle * Math.PI / 180));
            float sx = (float) (centerX + sR * Math.sin(angle * Math.PI / 180));

//            Log.i("Test", "cos : " + Math.cos(angle) + "  sin : " + Math.sin(angle));
//            Log.i("Test", "sx : " + sx + ", sy : " + sy + ", x : " + x + ", y : " + y + "  --> angle : " + angle + "  br : " + bR + " centerX : " + centerX + " centerY : " + centerY);

            mPath.moveTo(sx, sy);
            mPath.lineTo(x, y);
            canvas.drawPath(mPath, mPaint);
            mPath.reset();
        }

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(centerX, centerY, 20, mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(centerX, centerY, 8, mPaint);
    }

    private String[] getTime() {
        String timeStr = DateUtils.getFormatTime(System.currentTimeMillis());
//        Log.i("Test", "timeStr : " + timeStr);
        String[] array = timeStr.split(":");
        return array;
    }


    public void release() {
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
            mHandler = null;
        }
    }
}
