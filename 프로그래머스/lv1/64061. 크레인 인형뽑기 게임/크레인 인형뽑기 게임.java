import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int boardSize = board.length;
        int movesLen = moves.length;
        ArrayList<Integer> basket = new ArrayList<>();
        int index = 0;

        for(int i=0; i<movesLen;i++){
            int col = moves[i] - 1;

            for(int j=0; j<boardSize; j++){
                int row = j;

                if(board[row][col] != 0){
                    if(index == 0){
                        basket.add(board[row][col]);
                        board[row][col] = 0;
                        index++;
                    }
                    else{
                        if(basket.get(index-1) == board[row][col]){
                            basket.remove(index-1);
                            board[row][col] = 0;
                            answer += 2;
                            index--;
                        }
                        else{
                            basket.add(board[row][col]);
                            board[row][col] = 0;
                            index++;
                        }
                    }
                    break;
                }
            }
        }

        return answer;
    }
}