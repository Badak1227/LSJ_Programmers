class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int index = 0;
        int num = 1;
        int layer = 0;
        while(n>0){
            for(int i=0; i<n; i++){
                index += layer++;
                answer[index] = num++;
            }
            n--;
            for(int i=0; i<n; i++){
                index += 1;
                answer[index] = num++;
            }
            n--;
            for(int i=n-1; i>=0; i--){
                index -= layer--;
                answer[index] = num++;
            }
            n--;
        }
        return answer;
    }
}