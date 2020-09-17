package sdkdemo.demo.com.lib.method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by  sjx  on 2020/9/14
 */
public class LetterCombinations {

    public void solution() {
        List<String> list = letterCombinations("2130");
        System.out.println("list : " + list);
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.isEmpty())
            return list;

        Map<Character, List<String>> map = map();

        List<Character> digitsList   = new ArrayList<>();
        int             digitsLength = digits.length();
        for (int i = 0; i < digitsLength; i++) {
            Character c = digits.charAt(i);
            if (c == '0' || c == '1') {
                continue;
            } else {
                digitsList.add(c);
            }
        }

        for (int i = 0; i < digitsList.size(); i++) {
            List<String> innerList = map.get(digitsList.get(i));
            build(list, innerList);
        }
        return list;
    }

    private void build(List<String> list, List<String> innerList) {
        if (list.size() == 0) {
            list.addAll(innerList);
            return;
        }
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String tempStr = list.get(i);
            for (int j = 0; j < innerList.size(); j++) {
                tempList.add(tempStr.concat(innerList.get(j)));
            }
        }
        list.clear();
        list.addAll(tempList);
    }


    private Map<Character, List<String>> map() {
        Map<Character, List<String>> map = new HashMap<>();

        List<String> zeroList = new ArrayList<>();
        map.put('0', zeroList);

        List<String> oneList = new ArrayList<>();
        map.put('1', oneList);

        List<String> twoList = new ArrayList<>();
        twoList.add("a");
        twoList.add("b");
        twoList.add("c");
        map.put('2', twoList);

        List<String> threeList = new ArrayList<>();
        threeList.add("d");
        threeList.add("e");
        threeList.add("f");
        map.put('3', threeList);

        List<String> fourList = new ArrayList<>();
        fourList.add("g");
        fourList.add("h");
        fourList.add("i");
        map.put('4', fourList);

        List<String> fiveList = new ArrayList<>();
        fiveList.add("j");
        fiveList.add("k");
        fiveList.add("l");
        map.put('5', fiveList);

        List<String> sixList = new ArrayList<>();
        sixList.add("m");
        sixList.add("n");
        sixList.add("o");
        map.put('6', sixList);

        List<String> sevenList = new ArrayList<>();
        sevenList.add("p");
        sevenList.add("q");
        sevenList.add("r");
        sevenList.add("s");
        map.put('7', sevenList);

        List<String> eightList = new ArrayList<>();
        eightList.add("t");
        eightList.add("u");
        eightList.add("v");
        map.put('8', eightList);

        List<String> nineList = new ArrayList<>();
        nineList.add("w");
        nineList.add("x");
        nineList.add("y");
        nineList.add("z");
        map.put('9', nineList);

        return map;
    }
}
