package sdkdemo.demo.com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by  sjx  on 2020/8/4
 */
public class DateUtils {
    public static String getFormatTime(long timeStamp) {
        if (timeStamp == 0) {
            return "0";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
        return sdf.format(new Date(timeStamp));
    }
}
