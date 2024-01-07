import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        int[] input= {1, 2, 3, 4, 1, 6, 7,8};
        int[] input2= {1, 1, 1, 4, 5, 1, 1, 1};
        Solution res = new Solution();
        System.out.println("Minimum moves is "+res.minMoves(input));
        System.out.println("Minimum moves is "+res.minMoves(input2));
    }

    //Using 3 set to keep position that cannot put into the queen
    HashSet<Integer> columnSet = new HashSet<>();
    HashSet<Integer> posDiag = new HashSet<>();//R+C
    HashSet<Integer> nagDiag = new HashSet<>();//R-C<=0

    List<int[]> solutions = new ArrayList<>();

    public void queens(int[] board, int row) {
        if (row == board.length) {//check whether queen already been put
            solutions.add(board.clone());
            return;
        }
        for (int col = 0; col < board.length; col++) {//check all column where can put queen
            if (isValid(col, row)) {
                board[row] = col;
                columnSet.add(col);
                posDiag.add(col + row);
                nagDiag.add(col - row);
                queens(board, row + 1);
                //backtracking
                columnSet.remove(col);
                posDiag.remove(col + row);
                nagDiag.remove(col - row);
            }
        }
    }

    public boolean isValid(int col, int row) {//chcek whether queen will be attacked on this position
        if(columnSet.contains(col)) return false;
        if(posDiag.contains(col+row))return false;
        if(nagDiag.contains(col-row)) return false;
        return true;
    }

    public int minMoves(int[] board) {
        queens(new int[8], 0);
        int minMoves = Integer.MAX_VALUE;//setup initial int
        for (int[] solution : solutions) {
            int moves = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i] != solution[i]) {
                    moves++;
                }
            }
            minMoves = Math.min(minMoves, moves);
        }
        return minMoves;
    }


}



