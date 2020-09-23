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
//        boolean flag = isValid1(s);
//        System.out.println("flag : " + flag);

        System.out.println(generateParenthesis(2));
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

//    public List<String> generateParenthesis(int n) {
//        List<String>  list  = new ArrayList<>();
//        Stack<String> stack = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            stack.push("(");
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//
//            }
//        }
//
//        return list;
//    }

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n <= 0){
            return res;
        }
        getParenthesis("",n,n);
        return res;
    }

    private void getParenthesis(String str,int left, int right) {
        if(left == 0 && right == 0 ){
            res.add(str);
            return;
        }
        if(left == right){
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str+"(",left-1,right);
        }else if(left < right){
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if(left > 0){
                getParenthesis(str+"(",left-1,right);
            }
            getParenthesis(str+")",left,right-1);
        }
    }
}
