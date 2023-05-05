class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int left = 1;
        
        int wide = 2 * w + 1;
        
        for(int i: stations){
            if(i - w - left > 0){
                answer += (i - w - left) / wide;
                if((i - w - left) % wide != 0) answer++;
            }
            left = i + w + 1;
        }

        if(n - left + 1 > 0){
            answer += (n - left + 1) / wide;
            if((n - left + 1)%wide != 0) answer++;
        }

        return answer;
    }
}