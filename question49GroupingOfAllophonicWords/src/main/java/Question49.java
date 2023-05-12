import java.util.*;

/**
 * @Author puka
 * @Description TODO
 * @Date 2023/5/12 11:46
 */
public class Question49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Solution().groupAnagrams(strs);
        System.out.println(Arrays.toString(lists.toArray()));
    }

}


class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> valueListMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String out = countValue(strs[i]);
            List<String> list = valueListMap.getOrDefault(out, new ArrayList<String>());
            list.add(strs[i]);
            valueListMap.put(out,list);
        }
        valueListMap.values().stream().toList();
        return new ArrayList<List<String>>(valueListMap.values());
    }

    public String countValue(String str){
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}

//class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<String, List<String>>();
//        for (String str : strs) {
//            char[] array = str.toCharArray();
//            Arrays.sort(array);
//            String key = new String(array);
//            List<String> list = map.getOrDefault(key, new ArrayList<String>());
//            list.add(str);
//            map.put(key, list);
//        }
//        return new ArrayList<List<String>>(map.values());
//    }
//}