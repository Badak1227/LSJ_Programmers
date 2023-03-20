import java.util.Arrays;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board[0].length;
        int[][] safe = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(safe[i], 0);
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    //윗줄
                    if(i != 0){
                        safe[i-1][j] = 1;
                        if(j != 0){
                            safe[i-1][j-1] = 1;
                        }
                        if(j != n-1){
                            safe[i-1][j+1] = 1;
                        }
                    }
                    //가운데줄
                    safe[i][j] = 1;
                    if(j != 0){
                        safe[i][j-1] = 1;
                    }
                    if(j != n-1){
                        safe[i][j+1] = 1;
                    }
                    //아랫줄
                    if(i != n-1){
                        safe[i+1][j] = 1;
                        if(j != 0){
                            safe[i+1][j-1] = 1;
                        }
                        if(j != n-1){
                            safe[i+1][j+1] = 1;
                        }
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(safe[i][j] == 0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}