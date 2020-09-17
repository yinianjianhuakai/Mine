package sdkdemo.demo.com.test;

public class TestLeekCode {

    public static void main(String args) {
        strStr("hello", "ll");
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0) {
            return -1;
        }

        if (haystack.contains(needle)) {
            for (int i = 0; i < haystack.length(); i++) {
                char strChar = haystack.charAt(i);
                char needleChar = needle.charAt(0);
                if (strChar == needleChar){
                    int needleCount = needle.length();
                    String subStr = haystack.substring(i,i+needleChar);
                    if (needle.equals(subStr)){
                        return i;
                    }
                }
            }
        }else{
            return -1;
        }

        return 0;
    }
}
