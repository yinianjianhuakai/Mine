package sdkdemo.demo.com.utils;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by  sjx  on 2020/9/1
 */
public class NetFileNameUtils {
    private static final String FILE_INDEX = "FILE_INDEX";
    private static final String FILE_PATH  = "FILE_PATH";

    public static void reCheckFile() {
        String     pathStr = Environment.getExternalStorageDirectory().getPath() + "/audioBook/";
        File       file    = new File(pathStr);
        File[]     files   = file.listFiles();
        List<File> list    = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            File currentFile = files[i];
            if (currentFile.length() < 1024 * 10) {
                list.add(currentFile);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).delete();
        }
    }

    public static int getLastFileName() {
        String              pathStr    = Environment.getExternalStorageDirectory().getPath() + "/audioBook/";
        File                file       = new File(pathStr);
        File[]              files      = file.listFiles();
        Map<String, String> map        = getMaxValueMap(files);
        int                 value      = getInt(map.get(FILE_INDEX));
        String              resultPath = map.get(FILE_PATH);
        Log.i("Test", "Net file , value : " + value + "  resultPath : " + resultPath);
        if (resultPath != null) {
            File resultFile = new File(resultPath);
            if (resultFile.exists()) {
                if (resultFile.length() < 1024 * 1024) {
                    return value;
                } else {
                    return value + 1;
                }
            }
        }
        return -1;
    }

    private static Map<String, String> getMaxValueMap(File[] files) {
        int                 value       = -1;
        String              currentPath = null;
        Map<String, String> map         = new HashMap<>();
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                String name     = fileName.substring(0, fileName.lastIndexOf("."));
                int    temp     = getInt(name);
                if (value < temp) {
                    value = temp;
                    currentPath = files[i].getPath();
                }
            }
        }
        map.put(FILE_INDEX, String.valueOf(value));
        map.put(FILE_PATH, currentPath);
        return map;
    }

    private static int getInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static void print(File[] files) {
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                Log.i("Test", "print : " + files[i].getPath());
            }
        }
    }
}
