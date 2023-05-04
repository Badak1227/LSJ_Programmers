class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int stationIdx = 0;
        int position = 1;
        int wide = 2*w+1;
        int emptySize = 0;

        while(true){
            // 기지국이 설치 되어 있는 경우
            if(stationIdx < stations.length){
                emptySize = stations[stationIdx] - w - position;

                if(emptySize > 0){
                    answer += emptySize / wide;
                    if(emptySize % wide != 0) answer++;
                }

                position = stations[stationIdx] + w + 1;

                stationIdx++;
            }
            // 기지국이 설치 되어 있지 않은 경우
            else{
                emptySize = n + 1 - position;

                if(emptySize > 0){
                    answer += emptySize / wide;
                    if(emptySize % wide != 0) answer++;
                }

                break;
            }
        }

        return answer; 
    }
}