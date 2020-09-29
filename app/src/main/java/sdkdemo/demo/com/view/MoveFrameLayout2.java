package sdkdemo.demo.com.view;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * 不咋滴, 弃用吧
 * Created by  sjx  on 2020/9/29
 */
public class MoveFrameLayout2 extends FrameLayout {

    private Context                 mContext;
    private MoveFragmentInnerLayout mView;

    public MoveFrameLayout2(Context context) {
        super(context);
        init(context);
    }

    public MoveFrameLayout2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MoveFrameLayout2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context mContext) {
        this.mContext = mContext;
        mView = new MoveFragmentInnerLayout(mContext);
        addView(mView);
        mView.setVisibility(GONE);
    }

    public void animation(View startView, View endView) {
        RectF mStartRectF = new RectF(startView.getLeft(), startView.getTop(), startView.getRight(), startView.getBottom());
        RectF mEndRectF   = new RectF(endView.getLeft(), endView.getTop(), endView.getRight(), endView.getBottom());
        mView.setRectF(mStartRectF, mEndRectF);
    }


}
