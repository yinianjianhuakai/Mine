package sdkdemo.demo.com.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.app.ActivityCompat;
import sdkdemo.demo.com.BaseApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Author: tony
 * Date: 2018/5/29 0029 18:21
 * Description:设备相关的工具类。如获取设备型号、设备名称等
 */
public class DeviceInfoUtil {

    public static HashMap<String, String> getRequestHeader() {
        HashMap<String, String> headParamMap = new HashMap();
        headParamMap.put("appname", getAppName());
        headParamMap.put("version", getVersionName());
        headParamMap.put("vcode", getVersionCode() + "");
        headParamMap.put("pversion", getHttpVersion() + "");
        headParamMap.put("imei", getIMEI());
        headParamMap.put("macaddr", getMacAddress());
        headParamMap.put("platform", getDeviceType() + "_" + getSdkVersion());
        headParamMap.put("model", Build.MANUFACTURER + "," + Build.MODEL);
        headParamMap.put("screensize", getScreenWidth() + "*" + getScreenHeight());
        headParamMap.put("vendor", getVendor());
        headParamMap.put("channel", getChannel());
        return headParamMap;
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return Build.MODEL;
    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    /**
     * 获取app名称
     */
    public static String getAppName() {
        try {
            PackageManager localPackageManager = BaseApplication.getContext().getPackageManager();
            ApplicationInfo localApplicationInfo = localPackageManager
                    .getApplicationInfo(BaseApplication.getContext().getPackageName(), PackageManager.GET_META_DATA);
            if (localApplicationInfo != null) {
                String umsAppkey = localApplicationInfo.metaData.getString("APP_NAME");
                if (umsAppkey != null) {
                    return umsAppkey;
                } else {
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 获取版本名称
     */
    public static String getVersionName() {
        String curversion = "1.0.0";
        try {
            PackageManager pm = BaseApplication.getContext().getPackageManager();
            PackageInfo    pi = pm.getPackageInfo(BaseApplication.getContext().getPackageName(), 0);
            curversion = pi.versionName;
            if (curversion == null || curversion.length() <= 0) {
                return "1.0.0";
            }
        } catch (Exception e) {
        }
        return curversion;
    }

    /**
     * 获取版本号
     */
    public static int getVersionCode() {
        int version_code = 0;
        try {
            PackageManager pm = BaseApplication.getContext().getPackageManager();
            PackageInfo    pi = pm.getPackageInfo(BaseApplication.getContext().getPackageName(), 0);
            version_code = pi.versionCode;
        } catch (Exception e) {
        }
        return version_code;
    }

    /**
     * 获取IMEI
     */
    public static String getIMEI() {
        if (checkPermissions(Manifest.permission.READ_PHONE_STATE)) {
            TelephonyManager tm = (TelephonyManager) BaseApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(BaseApplication.getContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return "";
            }
            String deviceId = tm.getDeviceId();
            if (TextUtils.isEmpty(deviceId)) {
                return getAndroidId();
            } else {
                return deviceId;
            }
        } else {
            return getAndroidId();
        }
    }

    /**
     * 获取设备Id
     */
    public static String getAndroidId() {
        return Settings.Secure.getString(BaseApplication.getContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    /**
     * 获取http版本
     */
    public static float getHttpVersion() {
        try {
            PackageManager localPackageManager = BaseApplication.getContext().getPackageManager();
            ApplicationInfo localApplicationInfo = localPackageManager
                    .getApplicationInfo(BaseApplication.getContext().getPackageName(), PackageManager.GET_META_DATA);
            if (localApplicationInfo != null) {
                float httpVersion = localApplicationInfo.metaData.getFloat("HTTP_VERSION");
                if (httpVersion != 0f) {
                    return httpVersion;
                } else {
                }
            }
        } catch (Exception localException) {
        }
        return 0f;
    }

    /***
     * 获取mac地址
     */
    public static String getMacAddress() {
        String macAddress = "";
        if (checkPermissions(Manifest.permission.ACCESS_WIFI_STATE)) {
            WifiManager wm       = (WifiManager) BaseApplication.getContext().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            WifiInfo    wifiInfo = wm.getConnectionInfo();
            if (wifiInfo != null) {
                macAddress = wifiInfo.getMacAddress();
            }
        }
        if (":::::".equals(macAddress)) {
            macAddress = "";
        }
        return macAddress;
    }

    /**
     * 获取设备类型 pad or phone
     */
    public static String getDeviceType() {
        try {
            PackageManager localPackageManager = BaseApplication.getContext().getPackageManager();
            ApplicationInfo localApplicationInfo = localPackageManager
                    .getApplicationInfo(BaseApplication.getContext().getPackageName(), PackageManager.GET_META_DATA);
            if (localApplicationInfo != null) {
                String deviceType = localApplicationInfo.metaData.getString("DEVICE_TYPE");
                if (deviceType != null) {
                    return deviceType;
                } else {
                    return "android_phone";
                }
            }
        } catch (Exception localException) {
        }
        return "android_phone";
    }

    /**
     * 获取sdk版本
     */
    public static String getSdkVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeight() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager  wm = (WindowManager) BaseApplication.getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager  wm = (WindowManager) BaseApplication.getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public static String getVendor() {
        try {
            PackageManager localPackageManager = BaseApplication.getContext()
                    .getPackageManager();
            ApplicationInfo localApplicationInfo = localPackageManager
                    .getApplicationInfo(BaseApplication.getContext().getPackageName(), PackageManager.GET_META_DATA);
            if (localApplicationInfo != null) {
                String vendor = localApplicationInfo.metaData
                        .getString("VENDOR");
                if (vendor != null) {
                    return vendor;
                }
            }
        } catch (Exception localException) {
        }
        return "";
    }

    /**
     * 读取渠道号
     */
    public static String getChannel() {
        ApplicationInfo appinfo   = BaseApplication.getContext().getApplicationInfo();
        String          sourceDir = appinfo.sourceDir;
        String          ret       = "";
        ZipFile         zipfile   = null;
        try {
            zipfile = new ZipFile(sourceDir);
            Enumeration<?> entries = zipfile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry     = ((ZipEntry) entries.nextElement());
                String   entryName = entry.getName();
                if (entryName.startsWith("META-INF/cztchannel")) {
                    ret = entryName;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zipfile != null) {
                try {
                    zipfile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!TextUtils.isEmpty(ret)) {
            String[] split = ret.split("_");
            if (split != null && split.length >= 2) {
                return ret.substring(split[0].length() + 1);
            } else {
                return "guanfang";
            }
        } else {
            return "guanfang";
        }
    }

    /**
     * 获取IP地址
     */
    public static String getNetIpAddress() {
        /*Call<ObjResponse> call = AccountApiServiceClass.getApiService().getNetIP(UrlHelper.get().getAppId());
        try {
            Response<ObjResponse> response = call.execute();
            if (response.isSuccessful() && response.body().getCode() == 0) {
                return response.body().getObj();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";*/
        return "";
    }

    public static String pingHost(String str, boolean isOnlyGetIP) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Process        p       = Runtime.getRuntime().exec("ping -c 1 -w 100 " + str);
            InputStream    input   = p.getInputStream();
            BufferedReader in      = new BufferedReader(new InputStreamReader(input));
            String         content = "";
            while ((content = in.readLine()) != null) {
                stringBuffer.append(content);
//                if (content.contains(str)) {
//                    break;
//                }
            }
        } catch (IOException e) {
        }
        String result = stringBuffer.toString();
        if (isOnlyGetIP && !TextUtils.isEmpty(result)) {
//            if (result.contains(str)) {
            return result.substring(result.indexOf("(") + 1, result.indexOf(")"));
//            }
        }
        return result;
    }

    /**
     * String str = "PING 52.01 fms.koolearn.com (42.62.3052.01.164) 56(84) bytes of data.64 bytes from 42.62.30.164: icmp_seq\u003d1 ttl\u003d49 time\u003d4.04 ms--- fms.koolearn.com ping statistics ---1 packets transmitted, 1 received, 0% packet loss, time 0msrtt min/avg/max/mdev \u003d 40/4.049/4.049/0.000 ms";
     * 获取ping 响应时间
     */
    public static String getPingTime(String str_ping) {
        if (str_ping == null) {
            return "";
        }
        Pattern p = Pattern.compile("[0-9]\\d*.\\d*/[0-9]\\d*.\\d*/[0-9]\\d*.\\d*/[0-9]\\d*.\\d*");
        Matcher m = p.matcher(str_ping);
//        while (m.find()) {
//            System.out.println(m.group());
//        }
        if (m.find()) {
            String strRes = m.group();
            String str[]  = strRes.split("/");
            if (str.length == 4) {
                return str[1];
            }
        }
        return "";
    }

    /**
     * 检查是否有权限
     *
     * @param permission 权限名称
     * @return false 没有权限;true 有权限
     */
    public static boolean checkPermissions(String permission) {
        try {
            PackageManager localPackageManager = BaseApplication.getContext().getPackageManager();
            return localPackageManager.checkPermission(permission,
                    BaseApplication.getContext().getPackageName()) == PackageManager.PERMISSION_GRANTED;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getDeviceSN() {

        String serialNumber = Build.SERIAL;

        return serialNumber;
    }

    //Get status bar height
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            result = context.getResources().getDimensionPixelOffset(resId);
        }
        return result;
    }
}
