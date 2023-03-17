class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int count = 0;
        double[][] line = new double[6][2];
        
        for(int i=0; i<3; i++){
            for(int j = i+1; j<4; j++){
                line[count][0] = dots[i][0] - dots[j][0];
                line[count][1] = dots[i][1] - dots[j][1];
                System.out.println(line[count][0] + " " + line[count][1]);
                count++;
            }
        }

        for(int i=0; i<3; i++){
            if(line[i][1]/line[i][0] == line[5-i][1]/line[5-i][0]){
            return answer = 1;
            }
        }
        
        return answer = 0;
    }
}