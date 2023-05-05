class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        //빈공간의 시작 위치
        int left = 1;
        //기지국 통신 너비
        int wide = 2 * w + 1;
        
        int empty = 0;
        
        for(int i: stations){
            //기지국 사이의 빈 공간 크기
            empty = i - w - left;
            
            if(empty > 0){
                answer += empty / wide;
                if(empty % wide != 0) answer++;
            }
            
            left = i + w + 1;
        }
        
        //마지막 기지국과 끝 까지의 빈 공간 크기
        empty = n - left + 1;
        if(empty > 0){
            answer += empty / wide;
            if(empty % wide != 0) answer++;
        }

        return answer;
    }
}