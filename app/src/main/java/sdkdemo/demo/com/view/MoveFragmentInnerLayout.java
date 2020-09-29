package sdkdemo.demo.com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

/**
 * 不咋滴, 弃用吧
 * Created by  sjx  on 2020/9/29
 */
public class MoveFragmentInnerLayout extends View {

    private              Context mContext;
    private              Paint   mPaint;
    private              RectF   moveRectF;
    private              RectF   mStartRectF;
    private              RectF   mEndRectF;
    private              long    mLastMillis;
    private static final int     TAG_START_MOVE       = 1;
    private static final int     TAG_MOVING           = 2;
    private static final int     TAG_END_HIDE         = 3;
    private static final long    DURATION_MILLIS      = 1000;
    private static final long    DURATION_STAY_MILLIS = 300;
    private static final int     STROKE_WIDTH         = 3;
    private              int     mTag                 = 0;

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TAG_START_MOVE:
                    setVisibility(VISIBLE);
                    mTag = TAG_START_MOVE;
                    invalidate();
                    mHandler.sendEmptyMessageDelayed(TAG_MOVING, DURATION_STAY_MILLIS);
                    break;
                case TAG_MOVING:
                    long currentDuration = System.currentTimeMillis() - mLastMillis;
                    if (currentDuration > DURATION_MILLIS) {
                        mTag = TAG_END_HIDE;
                        drawResultAnimationRectF(mEndRectF);
                        invalidate();
                        mHandler.sendEmptyMessageDelayed(TAG_END_HIDE, DURATION_STAY_MILLIS);
                        return;
                    }
                    mTag = TAG_MOVING;
                    float widthDuration = (mEndRectF.right - mEndRectF.left - (mStartRectF.right - mStartRectF.left)) / DURATION_MILLIS;
                    float heightDuration = (mEndRectF.bottom - mEndRectF.top - (mStartRectF.bottom - mStartRectF.top)) / DURATION_MILLIS;
                    float dWidth = widthDuration * currentDuration;
                    float dHeight = heightDuration * currentDuration;

                    float distanceX = mEndRectF.left - mStartRectF.left;
                    float distanceY = mEndRectF.top - mStartRectF.top;
                    float ax = acceleration(distanceX, DURATION_MILLIS, currentDuration);
                    float ay = acceleration(distanceY, DURATION_MILLIS, currentDuration);

                    moveRectF.left = mStartRectF.left + ax;
                    moveRectF.top = mStartRectF.top + ay;
                    moveRectF.right = mStartRectF.right + ax + dWidth;
                    moveRectF.bottom = mStartRectF.bottom + ay + dHeight;
                    invalidate();

                    break;
                case TAG_END_HIDE:
                    setVisibility(GONE);
                    break;
            }
        }
    };

    public MoveFragmentInnerLayout(Context context) {
        super(context);
        init(context);
    }

    public MoveFragmentInnerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MoveFragmentInnerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context mContext) {
        this.mContext = mContext;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
        moveRectF = new RectF();
    }

    public void setRectF(RectF startRectF, RectF endRectF) {
        this.mStartRectF = startRectF;
        this.mEndRectF = endRectF;
        moveRectF = new RectF(startRectF);
        moveRectF.left = startRectF.left - STROKE_WIDTH;
        moveRectF.top = startRectF.top - STROKE_WIDTH;
        moveRectF.right = startRectF.right + STROKE_WIDTH;
        moveRectF.bottom = startRectF.bottom + STROKE_WIDTH;

        mLastMillis = System.currentTimeMillis();
        mHandler.sendEmptyMessage(TAG_START_MOVE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(moveRectF, mPaint);
        if (mTag == TAG_START_MOVE) {

        } else if (mTag == TAG_MOVING) {
            mHandler.sendEmptyMessage(TAG_MOVING);
        }
    }

    private void drawResultAnimationRectF(RectF rectF) {
        moveRectF.left = rectF.left - STROKE_WIDTH;
        moveRectF.top = rectF.top - STROKE_WIDTH;
        moveRectF.right = rectF.right + STROKE_WIDTH;
        moveRectF.bottom = rectF.bottom + STROKE_WIDTH;
    }

    private float acceleration(float distance, float durationMillis, float currentMillis) {
        float a = distance / durationMillis / durationMillis;
        return a * currentMillis * currentMillis;
    }
}
