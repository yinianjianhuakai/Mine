package sdkdemo.demo.com.view;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import sdkdemo.demo.com.myapplicatione.R;

/**
 * Created by  sjx  on 2020/9/29
 */
public class MoveFrameLayout extends FrameLayout {

    private              Context mContext;
    private              View    mView;
    private static final int     TAG_START_MOVE       = 1;
    private static final int     TAG_MOVING           = 2;
    private static final int     TAG_END_HIDE         = 3;
    private static final long    DURATION_MILLIS      = 1000;
    private static final long    DURATION_STAY_MILLIS = 300;
    private static final int     STROKE_WIDTH         = 3;

    private RectF mStartRectF;
    private RectF mEndRectF;
    private long  mLastMillis;

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TAG_START_MOVE:
                    mHandler.sendEmptyMessage(TAG_MOVING);
                    break;
                case TAG_MOVING:
                    long currentDuration = System.currentTimeMillis() - mLastMillis;
                    if (currentDuration > DURATION_MILLIS) {
                        setViewResultParams(mEndRectF);
                        mHandler.sendEmptyMessageDelayed(TAG_END_HIDE, DURATION_STAY_MILLIS);
                        return;
                    }

                    float widthDuration = (mEndRectF.right - mEndRectF.left - (mStartRectF.right - mStartRectF.left)) / DURATION_MILLIS;
                    float heightDuration = (mEndRectF.bottom - mEndRectF.top - (mStartRectF.bottom - mStartRectF.top)) / DURATION_MILLIS;
                    float dWidth = widthDuration * currentDuration;
                    float dHeight = heightDuration * currentDuration;

                    float distanceX = mEndRectF.left - mStartRectF.left;
                    float distanceY = mEndRectF.top - mStartRectF.top;
                    float ax = acceleration(distanceX, DURATION_MILLIS, currentDuration);
                    float ay = acceleration(distanceY, DURATION_MILLIS, currentDuration);
                    RectF tempRectF = new RectF();
                    tempRectF.left = mStartRectF.left + ax;
                    tempRectF.top = mStartRectF.top + ay;
                    tempRectF.right = mStartRectF.right + ax;
                    tempRectF.bottom = mStartRectF.bottom + ay;
                    move(dWidth, dHeight, ax, ay);
                    break;
                case TAG_END_HIDE:
                    mView.setVisibility(GONE);
                    break;
            }
        }
    };

    public MoveFrameLayout(Context context) {
        super(context);
        init(context);
    }

    public MoveFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MoveFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context mContext) {
        this.mContext = mContext;
        mView = new View(mContext);
        mView.setBackgroundResource(R.drawable.shape_corner_blue);
        addView(mView);
        mView.setVisibility(GONE);
    }

    public void animation(View startView, View endView) {
        if (mHandler.hasMessages(TAG_START_MOVE) || mHandler.hasMessages(TAG_MOVING) || mHandler.hasMessages(TAG_END_HIDE)) {
            return;
        }
        mStartRectF = new RectF(startView.getLeft(), startView.getTop(), startView.getRight(), startView.getBottom());
        mEndRectF = new RectF(endView.getLeft(), endView.getTop(), endView.getRight(), endView.getBottom());
        setViewResultParams(mStartRectF);
        mLastMillis = System.currentTimeMillis();
        mHandler.sendEmptyMessageDelayed(TAG_START_MOVE, DURATION_STAY_MILLIS);
    }

    private void setViewResultParams(RectF rectF) {
        FrameLayout.LayoutParams params = (LayoutParams) mView.getLayoutParams();
        float                    width  = rectF.right - rectF.left;
        float                    height = rectF.bottom - rectF.top;
        params.width = (int) (width + STROKE_WIDTH * 2);
        params.height = (int) (height + STROKE_WIDTH * 2);
        params.leftMargin = (int) (rectF.left - STROKE_WIDTH);
        params.topMargin = (int) (rectF.top - STROKE_WIDTH);
        mView.setLayoutParams(params);
        mView.setVisibility(VISIBLE);
    }

    private void move(float dWidth, float dHeight, float ax, float ay) {
        FrameLayout.LayoutParams params = (LayoutParams) mView.getLayoutParams();
        float                    width  = mStartRectF.right - mStartRectF.left;
        float                    height = mStartRectF.bottom - mStartRectF.top;

        params.width = (int) (width + STROKE_WIDTH * 2 + dWidth);
        params.height = (int) (height + STROKE_WIDTH * 2 + dHeight);
        params.leftMargin = (int) (mStartRectF.left - STROKE_WIDTH + ax);
        params.topMargin = (int) (mStartRectF.top - STROKE_WIDTH + ay);
        mView.setLayoutParams(params);
        mView.setVisibility(VISIBLE);
        mHandler.sendEmptyMessage(TAG_MOVING);
    }

    private float acceleration(float distance, float durationMillis, float currentMillis) {
        float a = distance / durationMillis / durationMillis;
        return a * currentMillis * currentMillis;
    }
}
