package sdkdemo.demo.com.view;

import android.content.Context;
import android.graphics.*;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.Nullable;
import sdkdemo.demo.com.myapplicatione.R;
import sdkdemo.demo.com.utils.DeviceInfoUtil;

/**
 * Created by  sjx  on 2020/7/23
 */
public class TestView extends View {

    private Paint  mPaint;
    private Path   mPath;
    private Bitmap bitmap;
    private Matrix matrix;

    public TestView(Context context) {
        super(context);
        init(context);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPath = new Path();
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.aa);
        matrix = new Matrix();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        int width           = DeviceInfoUtil.getScreenWidth();
        int height          = DeviceInfoUtil.getScreenHeight();
        int statusBarHeight = DeviceInfoUtil.getStatusBarHeight(getContext());
        height = height - statusBarHeight;
        int halfWidth  = width / 2;
        int halfHeight = height / 2;
        int areaPx     = width / 3;         //点击区域  areaPx * areaPx
        int tempPx     = areaPx / 2;

        mPaint.setStrokeWidth(2);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(tempPx, tempPx, width - tempPx, height - tempPx, 90, 360, true, mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(halfWidth - tempPx, 0, halfWidth + tempPx, areaPx, mPaint);

        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(45);
        canvas.drawText("       4    8", halfWidth - tempPx, tempPx, mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, halfHeight - tempPx, areaPx, halfHeight + tempPx, mPaint);

        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(45);
        canvas.drawText("Start Click", 30, halfHeight, mPaint);
        canvas.drawText("     1    5", 30, halfHeight + 55, mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
        canvas.drawCircle(tempPx, halfHeight, tempPx - 10, mPaint);

        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(halfWidth - tempPx, height - areaPx, halfWidth + tempPx, height, mPaint);

        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(45);
        canvas.drawText("       2    6", halfWidth - tempPx, height - tempPx + 22, mPaint);

        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(width - areaPx, halfHeight - tempPx, width, halfHeight + tempPx, mPaint);

        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(45);
        canvas.drawText("   3    7", width - tempPx - 60, halfHeight, mPaint);


        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(6);
        canvas.drawPath(mPath, mPaint);

        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(6);

//        canvas.drawArc(halfWidth - tempPx, halfHeight - tempPx, halfWidth + tempPx, halfHeight + tempPx,
//                180, 270, false, mPaint);
//        Path tempPath = new Path();
//        tempPath.moveTo(halfWidth - tempPx - 40, halfHeight);
//        tempPath.lineTo(halfWidth - tempPx + 40, halfHeight);
//        tempPath.lineTo(halfWidth - tempPx, halfHeight + 60);
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setColor(Color.RED);
//        canvas.drawPath(tempPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("Test", "onTouchEvent...");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(), event.getY());
//                invalidate();
                Log.i("Test", "ACTION_MOVE...");
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
    }
}
