class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 0};
        int len = sequence.length + 1;

        int sum = 0;
        for(int i=0, j=0; i< sequence.length; i++){
            if(sequence[i] > k) break;

            if(i>0){
                sum -= sequence[i-1];
            }

            while(sum<k && j < sequence.length){
                sum += sequence[j++];
            }

            if(sum == k && j-i < len){
                answer[0] = i;
                answer[1] = j - 1;
                len = j - i;
            }
        }

        return answer;
    }
}