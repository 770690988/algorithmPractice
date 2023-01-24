public class Question36 {
    public static void main(String[] args) {
        char[][] board = {
                 {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };
        Solution out = new Solution();
        System.out.println(out.isValidSudoku(board));
    }
}

/**
 * question
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][][] isRight = new int[3][3][9];
        int[][] row = new int[9][9];
        int[][] line = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char valueStr = board[i][j];
                if (valueStr != '.'){
                    int value = valueStr - '0' - 1;
                    isRight[i/3][j/3][value]++;
                    row[i][value]++;
                    line[j][value]++;
                    if (isRight[i/3][j/3][value] >= 2 || row[i][value] >= 2 || line[j][value] >= 2){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
