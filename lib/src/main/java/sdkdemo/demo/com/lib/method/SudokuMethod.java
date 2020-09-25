package sdkdemo.demo.com.lib.method;

import java.util.ArrayList;
import java.util.List;

/**
 * 数独
 * Created by  sjx  on 2020/9/24
 */
public class SudokuMethod {

    public void solution() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        /*char[][] board = {
                {'7', '.', '.', '.', '4', '.', '.', '.', '.'},
                {'.', '.', '.', '8', '6', '5', '.', '.', '.'},
                {'.', '1', '.', '2', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '9', '.', '.', '.'},
                {'.', '.', '.', '.', '5', '.', '5', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};*/

        System.out.println("isValidSudoku : " + isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null)
            return false;

        List<Character>[] rowList    = new ArrayList[9];
        List<Character>[] columnList = new ArrayList[9];
        List<Character>   tempList   = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            rowList[i] = new ArrayList<>(9);
            columnList[i] = new ArrayList<>(9);
        }

        for (int i = 0; i < board.length; i++) {
            tempList.clear();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.')
                    continue;

                //竖列
                List<Character> inner = columnList[j];
                if (inner.contains(board[i][j])) {
                    return false;
                }
                inner.add(board[i][j]);

                //9 * 9的数字方格内  ->  3 * 3
                int             index     = i / 3 * 3 + j / 3;
                List<Character> innerList = rowList[index];
                if (innerList.contains(board[i][j])) {
                    return false;
                }
                innerList.add(board[i][j]);

                //横列
                if (tempList.contains(board[i][j])) {
                    return false;
                }
                tempList.add(board[i][j]);
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        List<Character>[] rowList    = new ArrayList[9];
        List<Character>[] columnList = new ArrayList[9];
        List<Character>[] palaceList = new ArrayList[9];

        for (int i = 0; i < 9; i++) {
            rowList[i] = new ArrayList<>(9);
            columnList[i] = new ArrayList<>(9);
            palaceList[i] = new ArrayList<>(9);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                //竖列
                List<Character> columnInner = columnList[j];
                columnInner.add(board[i][j]);

                //9 * 9的数字方格内  ->  3 * 3
                int             index     = i / 3 * 3 + j / 3;
                List<Character> innerList = palaceList[index];
                innerList.add(board[i][j]);

                //横列
                List<Character> rowInner = rowList[j];
                rowInner.add(board[i][j]);
            }
        }

    }

    private List<Character> prepare(){
        List<Character> list = new ArrayList<>();
        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5');
        list.add('6');
        list.add('7');
        list.add('8');
        list.add('9');
        return list;
    }
}
