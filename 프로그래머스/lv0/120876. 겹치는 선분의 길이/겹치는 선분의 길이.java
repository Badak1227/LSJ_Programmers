import java.util.Arrays;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;

        int[] dots = new int[201];
        Arrays.fill(dots, 0);
        for(int i=0; i<3; i++){
            int linedots = lines[i][1] - lines[i][0];
            int linestart = lines[i][0] + 100;
            for(int j=0; j<linedots; j++){
                dots[linestart++]++;
            }
        }
        for(int i=0; i<dots.length; i++){
            if(dots[i]>1){
                answer++;
            }
        }

        return answer;
    }
}