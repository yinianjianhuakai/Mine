package sdkdemo.demo.com.utils;

import android.graphics.*;
import android.text.TextUtils;
import android.util.Log;
import sdkdemo.demo.com.BaseApplication;
import sdkdemo.demo.com.bean.StringBitmapParameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  sjx  on 2020/8/7
 */
public class PrintBitmapUtils {

    private final static int   WIDTH        = 384;
    private final static float SMALL_TEXT   = 24;
    private final static float LARGE_TEXT   = 35;
    private final static int   START_RIGHT  = WIDTH;
    private final static int   START_LEFT   = 0;
    private final static int   START_CENTER = WIDTH / 2;

    private final static int TEXT_PADDING = 18;

    /**
     * 特殊需求：
     */
    public final static int IS_LARGE  = 10;
    public final static int IS_SMALL  = 11;
    public final static int IS_RIGHT  = 100;
    public final static int IS_LEFT   = 101;
    public final static int IS_CENTER = 102;


    private static float x = START_LEFT, y;

    public static List<Bitmap> reCheckBitmap(Bitmap bitmap) {

        int height    = 0;
        int width     = 0;
        int index     = 0;
        int maxSize   = 1024 << 10;
        int maxHeight = maxSize / 3;
        if (bitmap != null) {
            height = bitmap.getHeight();
            width = bitmap.getWidth();
        }
        if (height > maxHeight) {
            index = height / maxHeight;
        }
        Log.i("Test", "height : " + height + "  width : " + width + "  index : " + index);
        List<Bitmap> list = new ArrayList<>();
        if (index >= 0) {
            for (int i = 0; i <= index; i++) {

                Bitmap resultBitmap;
                if (height - (i + 1) * maxHeight > 0) {
                    resultBitmap = Bitmap.createBitmap(bitmap, 0, i * maxHeight, width, maxHeight, null, false);
                } else {
                    resultBitmap = Bitmap.createBitmap(bitmap, 0, i * maxHeight, width, height - i * maxHeight, null, false);
                }
                list.add(resultBitmap);
            }
        }
        return list;
    }

    public static List<StringBitmapParameter> createStrList(String content, int textSize, boolean bold, boolean isCenter) {
        String                      str   = content.replaceAll("\n", "\n\r");
        String[]                    array = str.split("\n");
        List<StringBitmapParameter> list  = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            Log.i("Test", array[i]);
            if (array[i] != null && array[i].contains("\r")) {
                array[i] = array[i].replaceAll("\r", "");
            }
            list.add(new StringBitmapParameter(array[i], textSize, bold, isCenter));
        }
        return list;
    }

    /**
     * 生成图片
     */
    public static Bitmap stringListToBitmap(List<StringBitmapParameter> AllString, int size) {
        if (AllString.size() == 0)
            return Bitmap.createBitmap(WIDTH, WIDTH / 4, Bitmap.Config.RGB_565);
        ArrayList<StringBitmapParameter> mBreakString = new ArrayList<>();

        Paint paint = new Paint();
        paint.setAntiAlias(false);
        paint.setTextSize(size);

        Typeface typeface = Typeface.createFromAsset(BaseApplication.getContext().getAssets(), "fonts/songti.TTF");// 仿宋打不出汉字
        Typeface font;
        if (isBold(AllString)) {
            font = Typeface.create(typeface, Typeface.BOLD);
        } else {
            font = Typeface.create(typeface, Typeface.NORMAL);
        }
        paint.setTypeface(font);

        for (StringBitmapParameter mParameter : AllString) {
            paint.setTextSize(mParameter.getSize());
            int ALineLength = paint.breakText(mParameter.getText(), true, WIDTH, null);//检测一行多少字
            int lenght      = mParameter.getText().length();
            if (ALineLength < lenght) {

                int    num          = lenght / ALineLength;
                String ALineString  = new String();
                String RemainString = new String();

                for (int j = 0; j < num; j++) {
                    ALineString = mParameter.getText().substring(j * ALineLength, (j + 1) * ALineLength);
                    mBreakString.add(new StringBitmapParameter(ALineString, mParameter.getSize()));
                }

                RemainString = mParameter.getText().substring(num * ALineLength, mParameter.getText().length());
                mBreakString.add(new StringBitmapParameter(RemainString, mParameter.getSize()));
            } else {
                mBreakString.add(mParameter);
            }
        }


        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int               FontHeight  = (int) Math.abs(fontMetrics.leading) + (int) Math.abs(fontMetrics.ascent) + (int) Math.abs(fontMetrics.descent);
        y = (int) Math.abs(fontMetrics.leading) + (int) Math.abs(fontMetrics.ascent);
        Log.i("Test", "Paint.FontMetrics y : " + y + "   FontHeight : " + FontHeight);
        int bNum = 0;
        for (StringBitmapParameter mParameter : mBreakString) {
            Log.i("Test", "mParameter : " + mParameter.toString());
            String bStr = mParameter.getText();
            if (bStr != null && bStr.contains("\n"))
                bNum++;
        }
        int height = (int) ((FontHeight + TEXT_PADDING) * (mBreakString.size())) + bNum * FontHeight;
        Log.i("Test", "height : " + height);
        Bitmap bitmap = Bitmap.createBitmap(WIDTH, height, Bitmap.Config.RGB_565);

        for (int i = 0; i < bitmap.getWidth(); i++) {
            for (int j = 0; j < bitmap.getHeight(); j++) {
                bitmap.setPixel(i, j, Color.WHITE);
            }
        }

        Canvas canvas = new Canvas(bitmap);

        for (StringBitmapParameter mParameter : mBreakString) {

            String str = mParameter.getText();

            paint.setTextSize(mParameter.getSize());

            if (TextUtils.isEmpty(str) || str.contains("\n")) {
                canvas.drawText(str, 0, y + FontHeight / 2, paint);
                y = y + FontHeight;
            } else {
                canvas.drawText(str, 0, y, paint);
                y = y + FontHeight + TEXT_PADDING;
            }
        }
//        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.restore();
        return bitmap;
    }

    private static boolean isBold(List<StringBitmapParameter> AllString) {
        boolean flag = false;
        if (AllString != null) {
            for (int i = 0; i < AllString.size(); i++) {
                flag = flag || AllString.get(i).isBold();
            }
        }
        return flag;
    }


    /**
     * 合并图片
     */
    public static Bitmap addBitmapInHead(Bitmap first, Bitmap second) {
        int    width      = Math.max(first.getWidth(), second.getWidth());
        int    startWidth = (width - first.getWidth()) / 2;
        int    height     = first.getHeight() + second.getHeight();
        Bitmap result     = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

        for (int i = 0; i < result.getWidth(); i++) {
            for (int j = 0; j < result.getHeight(); j++) {
                result.setPixel(i, j, Color.WHITE);
            }
        }
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(first, startWidth, 0, null);
        canvas.drawBitmap(second, 0, first.getHeight(), null);
        return result;
    }

    /***
     * 使用两个方法的原因是：
     * logo标志需要居中显示，如果直接使用同一个方法是可以显示的，但是不会居中
     */
    public static Bitmap addBitmapInFoot(Bitmap bitmap, Bitmap image) {
        int    width      = Math.max(bitmap.getWidth(), image.getWidth());
        int    startWidth = (width - image.getWidth()) / 2;
        int    height     = bitmap.getHeight() + image.getHeight();
        Bitmap result     = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

        for (int i = 0; i < result.getWidth(); i++) {
            for (int j = 0; j < result.getHeight(); j++) {
                result.setPixel(i, j, Color.WHITE);
            }
        }
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(bitmap, 0, 0, null);
        canvas.drawBitmap(image, startWidth, bitmap.getHeight(), null);
        return result;
    }

}
