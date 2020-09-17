package sdkdemo.demo.com.bean;

import androidx.annotation.Nullable;

/**
 * Created by  sjx  on 2020/8/7
 */
public class StringBitmapParameter {

    /**
     * Created by Dpuntu on 2017/3/8.
     */

    @Nullable
    private String text;
    private int size = 24;
    private boolean bold = false;
    private boolean isCenter = false;

    /**
     * @param text 字段
     */
    public StringBitmapParameter(String text) {
        this.text = text;
    }


    public StringBitmapParameter(@Nullable String text, int size) {
        this.text = text;
        this.size = size;
    }

    public StringBitmapParameter(@Nullable String text, int size, boolean bold) {
        this.text = text;
        this.size = size;
        this.bold = bold;
    }

    public StringBitmapParameter(@Nullable String text, int size, boolean bold, boolean isCenter) {
        this.text = text;
        this.size = size;
        this.bold = bold;
        this.isCenter = isCenter;
    }

    @Nullable
    public String getText() {
        return text;
    }

    public void setText(@Nullable String text) {
        this.text = text;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public boolean isCenter() {
        return isCenter;
    }

    public void setCenter(boolean center) {
        isCenter = center;
    }

    @Override
    public String toString() {
        return "StringBitmapParameter{" +
                "text='" + text + '\'' +
                ", size=" + size +
                ", bold=" + bold +
                ", isCenter=" + isCenter +
                '}';
    }
}
