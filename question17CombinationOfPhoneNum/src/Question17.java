import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Question17 {
    public static void main(String[] args) {
        String data = "2";
        Solution out = new Solution();
        System.out.println(out.letterCombinations(data));
    }
}

/**
 * question
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 1:无
 * 2:abc
 * 3:def
 * 4:ghi
 * 5:jkl
 * 6:mno
 * 7:pqrs
 * 8:tuv
 * 9:wxyz
 */

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        HashMap<Character,String> combinations = new HashMap<Character,String>(){{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
        }};
        int size = 1;
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String single = combinations.get(digits.charAt(i));
            size *= single.length();
            strList.add(single);
        }
        String[] dataOut = new String[size];
        for (int i = 0; i < size; i++) {
            dataOut[i] = "";
        }
        for (int times = 0; times < strList.size(); times++){
            int repeat = 1;
            for (int time = times+1; time < strList.size(); time++){
                repeat *= strList.get(time).length();
            }
            for (int i = 0; i < size; i++) {
                dataOut[i] = dataOut[i] + strList.get(times).charAt(i/repeat% strList.get(times).length());
            }
        }
        return Arrays.stream(dataOut).toList();
    }
}
