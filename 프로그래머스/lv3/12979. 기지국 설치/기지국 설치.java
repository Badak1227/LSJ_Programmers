class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int stationIdx = 0;
        int position = 1;
        
        while(position <= n){        
            // 기지국이 설치 되어 있는 경우
            if(stationIdx < stations.length && position >= stations[stationIdx]-w){
                position =  stations[stationIdx]+w+1;
                stationIdx++;
            // 기지국이 설치 되어 있지 않은 경우 
            }else{            
                answer++;
                position += 2*w+1;
            }            
        }
        
        return answer;       
    }
}