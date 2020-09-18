package sdkdemo.demo.com.lib.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by  sjx  on 2020/9/17
 */
public class BracketsValidMethod {

    public void solution() {
        String s = "()[]{}";
//        String  s    = "([{}])";
//        String  s    = "[(])";
        boolean flag = isValid1(s);
        System.out.println("flag : " + flag);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }

    public boolean isValid3(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[]           c     = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                stack.push(')');
            } else if (c[i] == '[') {
                stack.push(']');
            } else if (c[i] == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c[i] != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        if (s.length() % 2 == 1) {
            return false;
        }

        while (!s.isEmpty() && (s.contains("()") || s.contains("[]") || s.contains("{}"))) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s.isEmpty();
    }

    public boolean isValid2(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        if (s.length() % 2 == 1) {
            return false;
        }

        List<Character> leftList  = new ArrayList<>();
        List<Character> rightList = new ArrayList<>();
        int             length    = s.length();
        int             middle    = length >> 1;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (i < middle) {
                leftList.add(c);
            } else {
                rightList.add(c);
            }
        }

        for (int i = 0; i < leftList.size(); i++) {
            boolean flag = true;
            if (inverseBrackets(leftList.get(i)) != rightList.get(rightList.size() - i - 1)) {
                flag = false;
            }
            return flag;
        }

        return false;
    }

    private char inverseBrackets(char c) {
        char tempChar = 0;
        switch (c) {
            case '(':
                tempChar = ')';
                break;
            case ')':
                tempChar = '(';
                break;
            case '[':
                tempChar = ']';
                break;
            case ']':
                tempChar = '[';
                break;
            case '{':
                tempChar = '}';
                break;
            case '}':
                tempChar = '{';
                break;

        }
        return tempChar;
    }
}
