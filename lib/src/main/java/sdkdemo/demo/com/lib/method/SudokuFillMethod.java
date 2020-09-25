package sdkdemo.demo.com.lib.method;

import java.util.Stack;

/**
 * Created by  sjx  on 2020/9/24
 */
public class SudokuFillMethod {

    public void solution() {
        /*char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};*/

        /*char[][] board = {
                {'2', '.', '.', '.', '4', '.', '.', '.', '.'},
                {'.', '.', '.', '8', '6', '5', '.', '.', '.'},
                {'.', '1', '.', '2', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '9', '.', '.', '.'},
                {'.', '.', '.', '.', '5', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};*/

        char[][] board = {
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};

        System.out.println("-------------- solveSudoku --------------");

        solveSudoku(board);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col]);
                if (col != board[0].length - 1){
                    System.out.print(" , ");
                }
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        // 三个布尔数组 表明 行, 列, 还有 3*3 的方格的数字是否被使用过
        boolean[][]   rowUsed = new boolean[9][10];
        boolean[][]   colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];
        // 初始化
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int num = board[row][col] - '0';
                if (1 <= num && num <= 9) {
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row / 3][col / 3][num] = true;
                }
            }
        }
        // 递归尝试填充数组
        recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, 0, 0);
    }

    private boolean recusiveSolveSudoku(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed, int row, int col) {
        // 边界校验, 如果已经填充完成, 返回true, 表示一切结束
        if (col == board[0].length) {
            col = 0;
            row++;
            if (row == board.length) {
                return true;
            }
        }
        // 是空则尝试填充, 否则跳过继续尝试填充下一个位置
        if (board[row][col] == '.') {
            // 尝试填充1~9
            for (int num = 1; num <= 9; num++) {
                boolean canUsed = !(rowUsed[row][num] || colUsed[col][num] || boxUsed[row / 3][col / 3][num]);
                if (canUsed) {
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row / 3][col / 3][num] = true;

                    board[row][col] = (char) ('0' + num);
                    System.out.println("赋值操作...");
                    if (recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, row, col + 1)) {
                        return true;
                    }
                    System.out.println("--------------------------------why------------------------");
                    board[row][col] = '.';

                    rowUsed[row][num] = false;
                    colUsed[col][num] = false;
                    boxUsed[row / 3][col / 3][num] = false;
                }
            }
            System.out.println("--------------------------------for------------------------");
        } else {
            return recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, row, col + 1);
        }
        System.out.println("--------------------------------false------------------------");
        return false;
    }

}
