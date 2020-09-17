package sdkdemo.demo.com.utils;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.sjx.handlereventbus.eventbus.RxBus;
import com.sjx.handlereventbus.eventbus.RxData;
import sdkdemo.demo.com.activity.CustomWebViewActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by  sjx  on 2020/8/26
 */
public class NetMusicInputStream {

    public void request(String str, String fileName) {
        try {
            URL               url           = new URL(str);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(5000);
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
            urlConnection.setRequestProperty("Charset", "UTF-8");
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            InputStream inputStream = urlConnection.getInputStream();
            write2Base(inputStream, fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write2Base(InputStream inputStream, String fileName) {
        try {
            Log.i("Test", "write2Base start....");
            File pathFile = new File(getPath());
            File file     = new File(getLocalPath(fileName));
            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }
            Log.i("Test", "create files.... exists : " + pathFile.exists());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            int              len              = 0;
            byte[]           buf              = new byte[1024 * 1024 * 2];
            while ((len = inputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, len);
                Log.i("Test", "write buffer................");
            }

            inputStream.close();
            fileOutputStream.close();
            Log.i("Test", "write to file finished....");
            if (file.exists()) {
                if (file.length() > 1024 * 1024) {
                    sendFinished(fileName);
                } else {
                    sendError(fileName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getEndWithStr(String urlStr) {
        if (!TextUtils.isEmpty(urlStr)) {
            int lastIndex = urlStr.lastIndexOf("/");
            return urlStr.substring(lastIndex, urlStr.length());
        } else {
            return "";
        }
    }

    private void sendFinished(String fileName) {
        RxData event = new RxData();
        event.setEventCode(321);
        event.setObj1(fileName);
        event.setTargetName(CustomWebViewActivity.class.getName());
        RxBus.getInstance().send(event);
    }

    private void sendError(String fileName) {
        RxData event = new RxData();
        event.setEventCode(322);
        event.setObj1(fileName);
        event.setTargetName(CustomWebViewActivity.class.getName());
        RxBus.getInstance().send(event);
    }

    private String getLocalPath(String mp3) {
        return getPath() + mp3;
    }

    private String getPath() {
        String pathStr = Environment.getExternalStorageDirectory().getPath() + "/audioBook/";
        Log.i("Test", "pathStr : " + pathStr);
        return pathStr;
    }
}
