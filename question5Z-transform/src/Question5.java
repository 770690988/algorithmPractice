import java.util.ArrayList;
import java.util.List;

public class Question5 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Solution out = new Solution();
        System.out.println(out.convert3(s,numRows));
    }
}

/**
 * question:
 * 将一个给定字符串 s 根据给定的行数 numRows ，PAHNAPLSIIGYIR、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 */
class Solution {
    //方法1 用代码真正直接实现，太麻烦！效率太低！感觉自己蠢到爆炸！
    public String convert(String s, int numRows) {
        Integer lenth = s.length();
        Integer numLines = 0;
        Integer cycleNum = 0;
        Integer roundNum = 0;
        StringBuilder outBuffer = new StringBuilder();
        if (numRows >= 2){
            roundNum = numRows+(numRows-2);
            cycleNum = lenth/roundNum + 1;
            numLines = cycleNum * (numRows-1);
        }
        else {
            return s;
        }
        System.out.println("需要的字符数组为"+numRows+"行,"+numLines+"列;");
        char[][] charList = new char[numRows][numLines];
        for (int cycle = 0,temp = 0; cycle < cycleNum; cycle++,temp++) {
            //先完成下这一笔
            for (int i = 0; i < numRows; i++){
                if (cycle*roundNum+i >= s.length()) break;
                charList[i][temp] = s.charAt(cycle*roundNum+i);
            }
            //完成右上折叠的这一笔
            for (int i = numRows-1; i > 1; i--){
                temp++;
                if ((cycle+1)*roundNum - i + 1 >= s.length()) break;
                charList[i-1][temp] = s.charAt((cycle+1)*roundNum - i + 1);
            }
        }
        for (int row = 0; row < numRows; row++){
            for (int line = 0; line < numLines; line++){
                if (charList[row][line] == '\u0000'){
                    System.out.print(' ');
                }else{
                    System.out.print(charList[row][line]);
                    outBuffer.append(charList[row][line]);
                }
            }
            System.out.println();
        }
        return outBuffer.toString();
    }

    //运用多个的buffer来收集相应的char只要按照顺序放就可以了
    public String convert2(String s, int numRows){
        if (numRows < 2) return s;
        int position = 0;//用来表示在String的哪个位置上
        List<StringBuilder> stringRows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            stringRows.add(new StringBuilder());
        }
        while(position < s.length()){
            int index = position % (numRows+numRows-2);
            if (index >= numRows){
                index = 2*numRows - index - 2;
            }
            System.out.println(index);
            stringRows.get(index).append(s.charAt(position));
            position++;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringRowSingle : stringRows) {
            res.append(stringRowSingle);
        }
        return res.toString();
    }

    //相同于方法2 但是不同之处在于存放的位置不是通过计算，而是通过扫描来存放
    public String convert3(String s, int numRows){
        if (numRows < 2) return s;
        int position = 0;//用来表示在String的哪个位置上
        List<StringBuilder> stringRows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            stringRows.add(new StringBuilder());
        }
        int index = 0,flag = -1;
        while(position < s.length()){
//            System.out.println("index is "+index);
            stringRows.get(index).append(s.charAt(position));
            if (index == 0 || index == numRows - 1){
                flag = -flag;
            }
            index = index + flag;
            position++;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringRowSingle : stringRows) {
            res.append(stringRowSingle);
        }
        return res.toString();
    }

}