class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int equal = 0;
        
        //등차 등비 판단
        int tmp[] = new int[2];
        for(int i=0; i<2; i++){
            tmp[i] = common[i+1]-common[i];
        }
        if(tmp[0] == tmp[1]){
            equal = 0;
        }
        else{
            equal = 1;
        }
        
        if(equal == 0){
            answer = common[common.length -1] + tmp[0];
        }
        else{
            answer = common[common.length -1] * (common[1] / common[0]);
        }
        return answer;
    }
}