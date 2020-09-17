package sdkdemo.demo.com.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import sdkdemo.demo.com.bean.StringBitmapParameter;
import sdkdemo.demo.com.myapplicatione.R;
import sdkdemo.demo.com.utils.PrintBitmapUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  sjx  on 2020/8/10
 */
public class DrawBitmapActivity extends Activity {

    private LinearLayout mContentLayout;
    private ImageView    img_id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_draw_bitmap_activity);
        mContentLayout = findViewById(R.id.content_layout);
//        setLayout();
//        List<Bitmap> list = new ArrayList<>();
//        list.add(createBitmap());
//        addView(list);

        createBitmap();
    }

    /*private void setLayout() {
        Bitmap bitmap = createBitmap();
        int    height = 0;
        int    width  = 0;
        int    index  = 0;
        if (bitmap != null) {
            height = bitmap.getHeight();
            width = bitmap.getWidth();
        }
        if (height > 500) {
            index = height / 500;
        }
        Log.i("Test", "height : " + height + "  width : " + width + "  index : " + index);
        List<Bitmap> list = new ArrayList<>();
        if (index >= 0) {
            for (int i = 0; i <= index; i++) {

                Bitmap resultBitmap;
                if (height - (i + 1) * 500 > 0) {
                    resultBitmap = Bitmap.createBitmap(bitmap, 0, i * 500, width, 500, null, false);
                } else {
                    resultBitmap = Bitmap.createBitmap(bitmap, 0, i * 500, width, height - i * 500, null, false);
                }
                list.add(resultBitmap);
            }
        }
        addView(list);
    }*/

    private void createBitmap(){
        StringBuilder sb = new StringBuilder();
        sb.append("这是第1行 : 第一行内容1230987645").append("\n");
        sb.append("这是第2行 : 第2行内容1230987645").append("\n").append("\n");
        sb.append("这是第3行 : ").append("\n");
        sb.append("这是第4行 : 第4行内容1230987645").append("\n");
        sb.append("这是第5行 : ");


        Bitmap bitmap = PrintBitmapUtils.stringListToBitmap(PrintBitmapUtils.createStrList(sb.toString(), 30, true, true), 30);
        List<Bitmap> list = PrintBitmapUtils.reCheckBitmap(bitmap);

        addView(list);
    }

    private void addView(List<Bitmap> list){
        if (list.size() != 0) {
            mContentLayout.removeAllViews();
            for (int i = 0; i < list.size(); i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageBitmap(list.get(i));
                mContentLayout.addView(imageView);
            }
        }
    }

    /*private Bitmap createBitmap() {
        StringBuilder sb = new StringBuilder();
        sb.append("这是第1行 : 第一行内容1230987645").append("\n");
        sb.append("这是第2行 : 第2行内容1230987645").append("\n").append("\n");
        sb.append("这是第3行 : ").append("\n");
        sb.append("这是第4行 : 第4行内容1230987645").append("\n");
        sb.append("这是第5行 : ");
//        sb.append("这是第一行 : 第一行内容1230987645").append("\n");
//        sb.append("这是第2行 : 第2行内容1230987645").append("\n");
//        sb.append("这是第3行 : ").append("\n");
//        sb.append("这是第4行 : 第4行内容1230987645").append("\n");
//        sb.append("这是第5行 : ").append("\n").append("\n");

        String str = sb.toString().replaceAll("\n", "\n\r");

        String[]                    array = str.split("\n");
        List<StringBitmapParameter> list  = new ArrayList<>();
        Log.i("Test", "array size : " + array.length);
        for (int i = 0; i < array.length; i++) {
            Log.i("Test", array[i]);
            if (array[i] != null && array[i].contains("\r")) {
                array[i] = array[i].replaceAll("\r", "");
            }
            list.add(new StringBitmapParameter(array[i]));
        }

        Bitmap bitmap = PrintBitmapUtils.StringListToBitmap(this, list, 24);
        return bitmap;
    }*/
}
