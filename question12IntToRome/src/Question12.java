import java.util.*;

public class Question12 {
    public static void main(String[] args) {
        int data = 520;
        Solution out = new Solution();
        System.out.println(out.intToRoman(data));
    }
}

/**
 * question 给你一个整数，将其转为罗马数字。
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
class Solution {
    public String intToRoman(int num) {
        StringBuilder out = new StringBuilder();
        LinkedHashMap<Integer,String> dataList = new LinkedHashMap<>(14,0.75f,true);
        dataList.put(1000,"M");
        dataList.put(900,"CM");
        dataList.put(500,"D");
        dataList.put(400,"CD");
        dataList.put(100,"C");
        dataList.put(90,"XC");
        dataList.put(50,"L");
        dataList.put(40,"XL");
        dataList.put(10,"X");
        dataList.put(9,"IX");
        dataList.put(5,"V");
        dataList.put(4,"IV");
        dataList.put(1,"I");
        Iterator<Map.Entry<Integer, String>> iterator = dataList.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            while(next.getKey()<=num){
                out.append(next.getValue());
                num -= next.getKey();
            }
        }
        return out.toString();
    }
}