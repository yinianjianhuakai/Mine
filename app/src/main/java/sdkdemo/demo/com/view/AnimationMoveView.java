package sdkdemo.demo.com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import sdkdemo.demo.com.utils.DeviceInfoUtil;

/**
 * Created by  sjx  on 2020/9/15
 */
public class AnimationMoveView extends View {

    private Paint mPaint;
    private int   width;
    private int   height;

    private static final int LEFT_WIDTH  = 300;
    private static final int LEFT_HEIGHT = 250;

    private static final int MIDDLE_WIDTH  = 200;
    private static final int MIDDLE_HEIGHT = 500;

    private static final int RIGHT_WIDTH  = 300;
    private static final int RIGHT_HEIGHT = 60;

    private static final int MIDDLE_MARGIN = 100;

    private static final int ANIMATION_STOKE = 3;

    private static final int TAG_LEFT   = 1;
    private static final int TAG_MIDDLE = 2;
    private static final int TAG_RIGHT  = 3;

    private RectF mMiddleRectF;
    private RectF mLeftRectF;
    private RectF mRightRectF;
    private RectF animationRectF = null;
    private int   mCurrentTag    = 1;

    private static final int ACTION_DRAW_FIRST         = 0x1002;
    private static final int ACTION_DRAW               = 0x1001;
    private static final int ACTION_DRAW_RIGHT         = 0x1003;
    private static final int ACTION_DRAW_RIGHT_TO_LEFT = 0x1004;

    private static final long ACTION_DRAW_ANIMATION_DELAY = 10;
    private static final long ACTION_ON_RECT_DELAY        = 1000;

    private static final long DURATION_MOVE_MILLIS = 1000;
    private static final long PAUSE_STAY_MILLIS = 1000; //暂停多久

    private long    startTime;
    private boolean isFirstDraw = true;

    private Canvas mCanvas;

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ACTION_DRAW_FIRST:
                    startTime = System.currentTimeMillis();
                    AnimationMoveView.this.invalidate();
                    break;
                case ACTION_DRAW:
                    if (buildLeft2MiddleRectF())
                        AnimationMoveView.this.invalidate();
                    else {
                        mCurrentTag = -1;
                        drawResultAnimationRectF(mMiddleRectF);
                        delayChangeTag(TAG_MIDDLE);
                        mHandler.sendEmptyMessageDelayed(ACTION_DRAW_RIGHT, PAUSE_STAY_MILLIS);
                        startTime = System.currentTimeMillis() + PAUSE_STAY_MILLIS;
                    }
                    break;
                case ACTION_DRAW_RIGHT:
                    if (buildMiddle2RightRectF()) {
                        AnimationMoveView.this.invalidate();
                    } else {
                        mCurrentTag = -1;
                        drawResultAnimationRectF(mRightRectF);
                        delayChangeTag(TAG_RIGHT);
                        mHandler.sendEmptyMessageDelayed(ACTION_DRAW_RIGHT_TO_LEFT, PAUSE_STAY_MILLIS);
                        startTime = System.currentTimeMillis() + PAUSE_STAY_MILLIS;
                    }
                    break;
                case ACTION_DRAW_RIGHT_TO_LEFT:
                    if (buildRight2LeftRectF()) {
                        AnimationMoveView.this.invalidate();
                    } else {
                        mCurrentTag = -1;
                        drawResultAnimationRectF(mLeftRectF);
                        delayChangeTag(TAG_LEFT);
                        mHandler.sendEmptyMessageDelayed(ACTION_DRAW, PAUSE_STAY_MILLIS);
                        startTime = System.currentTimeMillis() + PAUSE_STAY_MILLIS;
                    }
                    break;
            }
        }
    };

    public AnimationMoveView(Context context) {
        super(context);
        init(context);
    }

    public AnimationMoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AnimationMoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);

        width = DeviceInfoUtil.getScreenWidth();
        height = DeviceInfoUtil.getScreenHeight();
        int statusBarHeight = DeviceInfoUtil.getStatusBarHeight(getContext());
        height = height - statusBarHeight;
        initBackgroundRectF();
        startTime = System.currentTimeMillis();
    }

    private void initBackgroundRectF() {
        //左边 宽 * 高  150 * 70
        mLeftRectF = new RectF(
                width / 2 - MIDDLE_WIDTH / 2 - MIDDLE_MARGIN - LEFT_WIDTH,
                height / 2 - LEFT_HEIGHT / 2,
                width / 2 - MIDDLE_WIDTH / 2 - MIDDLE_MARGIN,
                height / 2 + LEFT_HEIGHT / 2
        );

        //中间 宽 * 高  100 * 150   @link MIDDLE_WIDTH * @MIDDLE_HEIGHT
        mMiddleRectF = new RectF(
                width / 2 - MIDDLE_WIDTH / 2,
                height / 2 - MIDDLE_HEIGHT / 2,
                width / 2 + MIDDLE_WIDTH / 2,
                height / 2 + MIDDLE_HEIGHT / 2);

        //右边 宽 * 高  150 * 30
        mRightRectF = new RectF(
                width / 2 + MIDDLE_WIDTH / 2 + MIDDLE_MARGIN,
                height / 2 - RIGHT_HEIGHT / 2,
                width / 2 + MIDDLE_WIDTH / 2 + MIDDLE_MARGIN + RIGHT_WIDTH,
                height / 2 + RIGHT_HEIGHT / 2
        );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.mCanvas = canvas;
        onBackDraw(canvas);
        onDrawAnimation(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

        }
        return super.onTouchEvent(event);
    }

    private void onBackDraw(Canvas canvas) {
        mPaint.setColor(Color.parseColor("#777777"));
        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawRect(mLeftRectF, mPaint);
        canvas.drawRect(mMiddleRectF, mPaint);
        canvas.drawRect(mRightRectF, mPaint);
    }

    private void onDrawAnimation(Canvas canvas) {
        if (mLeftRectF == null || mMiddleRectF == null || mRightRectF == null) {
            initBackgroundRectF();
        }

        if (mCurrentTag == 1 && animationRectF == null) {
            animationRectF = new RectF(
                    mLeftRectF.left - ANIMATION_STOKE, mLeftRectF.top - ANIMATION_STOKE,
                    mLeftRectF.right + ANIMATION_STOKE, mLeftRectF.bottom + ANIMATION_STOKE);
        }

        onOnlyDrawAnimationRectF(canvas);

        if (isFirstDraw) {
            isFirstDraw = false;
            mHandler.sendEmptyMessageDelayed(ACTION_DRAW_FIRST, 1000);
        } else if (mCurrentTag == TAG_LEFT) {
            mHandler.sendEmptyMessageDelayed(ACTION_DRAW, ACTION_DRAW_ANIMATION_DELAY);
        } else if (mCurrentTag == TAG_MIDDLE) {
            mHandler.sendEmptyMessageDelayed(ACTION_DRAW_RIGHT, ACTION_DRAW_ANIMATION_DELAY);
        } else if (mCurrentTag == TAG_RIGHT) {
            mHandler.sendEmptyMessageDelayed(ACTION_DRAW_RIGHT_TO_LEFT, ACTION_DRAW_ANIMATION_DELAY);
        }
    }

    private void onOnlyDrawAnimationRectF(Canvas canvas) {
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(ANIMATION_STOKE);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(animationRectF, mPaint);
    }

    private boolean buildLeft2MiddleRectF() {
        return buildAnimationRectF(mLeftRectF, mMiddleRectF, TAG_MIDDLE);
    }

    private boolean buildMiddle2RightRectF() {
        return buildAnimationRectF(mMiddleRectF, mRightRectF, TAG_RIGHT);
    }

    private boolean buildRight2LeftRectF() {
        return buildAnimationRectF(mRightRectF, mLeftRectF, TAG_LEFT);
    }

    private boolean buildAnimationRectF(RectF startRectF, RectF endRectF, int tag) {
        float durationX      = endRectF.left - startRectF.left;
        float ax             = durationX / DURATION_MOVE_MILLIS;
        long  durationMillis = System.currentTimeMillis() - startTime;
        if ((durationMillis > DURATION_MOVE_MILLIS && durationMillis - DURATION_MOVE_MILLIS > 10)) {
            mHandler.removeCallbacksAndMessages(null);
            mCurrentTag = tag;
            return false;
        } else {
//            float durationAx = ax * durationMillis;
            float durationAx = accelerationOnX(durationX, DURATION_MOVE_MILLIS, durationMillis);

            float widthDuration = (float) (endRectF.right - endRectF.left - (startRectF.right - startRectF.left)) / DURATION_MOVE_MILLIS;
            float dWidth        = widthDuration * durationMillis;

            float dHeight = (float) ((endRectF.bottom - endRectF.top - (startRectF.bottom - startRectF.top)) / DURATION_MOVE_MILLIS * durationMillis) / 2;

            Log.i("Test", "durationAx : " + durationAx + "    dWidth : " + dWidth + "   dHeight : " + dHeight + "   durationMillis : " + durationMillis);

            animationRectF = new RectF(
                    startRectF.left - ANIMATION_STOKE + durationAx, startRectF.top - ANIMATION_STOKE - dHeight,
                    startRectF.right + ANIMATION_STOKE + durationAx + dWidth, startRectF.bottom + ANIMATION_STOKE + dHeight);
            return true;
        }

    }

    private float accelerationOnX(float distance, float durationMillis, float currentMillis) {
        /*float averageSpeed = distance / durationMillis;
        float currentLowSpeed = 0;
        float halfDistance = distance / 2;
        float halfDurationMillis = durationMillis / 2;
        float a = (halfDistance - currentLowSpeed * halfDurationMillis) / halfDurationMillis / halfDurationMillis;

        if (currentMillis < halfDurationMillis){
            return currentLowSpeed * currentMillis + a * currentMillis * currentMillis;
        }else{
            float hightSpeed = currentLowSpeed + a * halfDurationMillis;
            float lastMillis = currentMillis - halfDurationMillis;
            float b = (halfDistance - hightSpeed * halfDurationMillis)/ halfDurationMillis / halfDurationMillis;
            Log.i("Tests", " a : " + a + "   b : " + b);
            return halfDistance + (hightSpeed + b*lastMillis) * lastMillis;
        }*/

        float a = distance / durationMillis / durationMillis;
        return a * currentMillis * currentMillis;

    }

    private void drawResultAnimationRectF(RectF rectF) {
        animationRectF = new RectF(
                rectF.left - ANIMATION_STOKE, rectF.top - ANIMATION_STOKE,
                rectF.right + ANIMATION_STOKE, rectF.bottom + ANIMATION_STOKE);
        invalidate();
    }

    private void delayChangeTag(final int tag) {
        mHandler.postDelayed(new Runnable() {
            public void run() {
                mCurrentTag = tag;
            }
        }, 100);
    }
}
