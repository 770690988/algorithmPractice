import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> heightNameMap = new HashMap<>(heights.length);

        for (int i = 0; i < heights.length; i++) {
            heightNameMap.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        List<String> data = new ArrayList<>(heights.length);
        for (int i = heights.length-1 ; i >= 0 ; i--) {
            data.add(heightNameMap.get(heights[i]));
        }
        return data.toArray(new String[0]);
    }
}
