package sdkdemo.demo.com.utils;

import android.os.Environment;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by  sjx  on 2020/8/27
 */
public class FileNetEvent {
    private static FileNetEvent   instance;
    private        BufferedWriter mWriter;

    private FileNetEvent() {
        init();
    }

    public static FileNetEvent getInstance() {
        if (instance == null) {
            synchronized (FileNetEvent.class) {
                if (instance == null) {
                    instance = new FileNetEvent();
                }
            }
        }
        return instance;
    }

    private void init() {
        if (mWriter == null) {
            String path     = Environment.getExternalStorageDirectory().getPath() + "/audioBook/";
            File   pathFile = new File(path);
            File   file     = new File(path + "info.txt");
            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }
            try {
                mWriter = new BufferedWriter(new FileWriter(file, true));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void writeLine(String line) {
        init();
        try {
            mWriter.write(line);
            mWriter.newLine();
            mWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String createJson(String name, String value) {
        JSONObject json = new JSONObject();
        try {
            json.put(name, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public void onClose() {
        if (mWriter != null) {
            try {
                mWriter.close();
                mWriter = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
