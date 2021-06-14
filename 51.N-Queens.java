class Solution {
  //Time: n!
  //Space: n^2
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
          return result;
        }
        //build board
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++){
          for (int j = 0; j < n; j++){
            board[i][j] = '.';
          }
        }
        dfsHelper(board, 0, result);
        return result;
    }

    private void dfsHelper(char[][] board, int row, List<List<String>> result){
      if (row == board.length){
        List<String> validResult = resultBuilder(board);
        result.add(validResult);
        return;
      }
      for (int col = 0; col < board.length; col ++) {
        if (isValid(board, row, col)){
          board[row][col] = 'Q';
          dfsHelper(board, row + 1, result);
          board[row][col] = '.';
        }
      }
    }

    private boolean isValid(char[][] board, int x, int y){
      for (int row = 0; row < x; row++){
        for (int col = 0; col < board[0].length; col++){
          //attack
          if ((y == col || Math.abs(x - row) == Math.abs(y - col)) && board[row][col] == 'Q'){
            return false;
          }
        }
      }
      return true;
    }

    private List<String> resultBuilder(char[][] board){
      List<String> result = new ArrayList<>();
      for (int i = 0; i < board.length; i++){
        result.add(new String(board[i]));
      }
      return result;
    }
}
