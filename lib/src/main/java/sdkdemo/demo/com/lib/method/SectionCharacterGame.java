package sdkdemo.demo.com.lib.method;

import java.util.Random;

/**
 * Created by  sjx  on 2020/9/9
 */
public class SectionCharacterGame {

    public void solution() {
//        stringGame("acacbcbc");
//        boolean flag = isMultiSameCharacter("aaaaaaaaaa");
//        System.out.println("flag : " + flag);

//        String str= "acacbcbce";
//        char c = 0;
//        for (int i=0;i<str.length();i++){
//            c =  (char) (c ^ str.charAt(i));
//        }
//        System.out.println(String.valueOf(c));

        int[] a = new int[]{1, 2, 3, 4, 5, 5, 6};
        int[] b = new int[]{1, 2, 3, 4, 5, 6};
        int aTemp = 0;
        int bTemp = 0;
        for (int i=0;i<a.length;i++){
            aTemp = aTemp ^ a[i];
        }
        for (int j=0;j<b.length;j++){
            bTemp = bTemp ^ b[j];
        }

        System.out.println(aTemp ^ bTemp);
    }

    public boolean stringGame(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        if (s.length() == 1) {
            return false;
        }

        if (isMultiSameCharacter(s)) {
            return true;
        }


        String randomStr = getRandomStr(s);
        String tempStr   = "";
        for (int i = 0; i < s.length(); i++) {
            String character = String.valueOf(s.charAt(i));
            if (!randomStr.contains(character)) {
                tempStr = tempStr + character;
            }
            if (tempStr.isEmpty()) {
                return false;
            }
        }

        return false;
    }

    private String getRandomStr(String s) {
        int  random = new Random().nextInt(s.length());
        char c      = s.charAt(random);
        System.out.println("random : " + random + "  c : " + c);
        return String.valueOf(c);
    }

    private boolean isMultiSameCharacter(String s) {
        String temp = null;
        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            if (temp == null || temp.length() == 0) {
                temp = String.valueOf(cc);
            }

            if (!temp.equals(String.valueOf(cc))) {
                return false;
            }
        }
        return true;
    }
}
