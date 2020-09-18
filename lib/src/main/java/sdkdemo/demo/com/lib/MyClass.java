package sdkdemo.demo.com.lib;

import sdkdemo.demo.com.lib.method.*;
import sdkdemo.demo.com.lib.music.NetRequest;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;

public class MyClass {
    public static void main(String[] args) {
//        System.out.println(strStr("a", ""));
//        System.out.println(String.valueOf(divide(100, -11)));
//        System.out.println("size : " + ("a,,".split(",").length));
//        splitStr();
//        conitnue();


//        new NetRequest().getRequestJson();
//        String fileName = getEndWithStr("http://aod.cos.tx.xmcdn.com/group71/M08/41/E8/wKgO2V4ESSmRNjMtAESgaWE64-c029.mp3");
//        System.out.println("fileName : " + fileName);
//        String str= "wKgO2V4ESSmRNjMtAESgaWE64-c029.mp3";
//        int index = str.lastIndexOf(".");
//
//        System.out.println(str.substring(0, index));

//        s();
//        new RegularTriangle().getCurtNum();
//        new TriangleArea().solution();
//        new TriangleAreaPoint().solution();
//        new SectionCharacterGame().solution();
//        new MaxAreaMethod().solution();
//        new FourNumSum().solution();
//        new ThreeNumNearSum().solution();
//        new ThreeNumSum().solution();
//        new LetterCombinations().solution();
//        new DeleteLinkLastNode().solution();
        new BracketsValidMethod().solution();
    }

    private static void s(){
        String str = "https://m.ting22.com/ting/1751-%s.html";
        str = String.format(str, "110");
        System.out.println(str);

        int lastIndexOf = str.lastIndexOf("-")+1;
        str = str.substring(lastIndexOf, str.lastIndexOf("."));
        System.out.println(str);
    }

    private  static  String getEndWithStr(String urlStr){
        if (urlStr != null){
            int lastIndex = urlStr.lastIndexOf("/") + 1;
            return urlStr.substring(lastIndex, urlStr.length());
        }else{
            return "";
        }
    }

    private static void conitnue() {
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                continue;
            }
            System.out.println("i : " + i);
        }
    }

    private static void splitStr() {
        String str = "a\n";
        str = str.replaceAll("\n", "\n\r");

        String[] array = str.split("\n");
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].contains("\r")) {
                array[i] = array[i].replaceAll("\r", "");
            }
            System.out.println("--- " + array[i]);
        }
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0) {
            if (haystack.length() == 0 && needle.length() == 0 || haystack.length() > 0 && needle.length() == 0) {
                return 0;
            }
            return -1;
        }

        if (haystack.contains(needle)) {
            for (int i = 0; i < haystack.length(); i++) {
                char strChar    = haystack.charAt(i);
                char needleChar = needle.charAt(0);
                if (strChar == needleChar) {
                    int    needleCount = needle.length();
                    String subStr      = haystack.substring(i, i + needleCount);
                    if (needle.equals(subStr)) {
                        return i;
                    }
                }
            }
        } else {
            return -1;
        }

        return -1;
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new RuntimeException();
        }
        if (dividend < divisor && divisor > 0) {
            return 0;
        }

        int tempDivisor = divisor;
        int count       = 1;
        int ret         = 0;

        while (dividend >= divisor) {
            ret += count;
            dividend = dividend - tempDivisor;
            if (dividend >= tempDivisor + tempDivisor) {
                count += count;
                tempDivisor += tempDivisor;
            } else {
                count = 1;
                tempDivisor = divisor;
            }
        }

        return ret;
    }
}
