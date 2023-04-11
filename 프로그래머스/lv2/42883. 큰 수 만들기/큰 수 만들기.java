class Solution {
    public String solution(String number, int k) {
        String answer = "";

        int index = 0;
        while(index < number.length()){
            while(k>0){
                try{
                    if(answer.charAt(answer.length()-1) < number.charAt(index)){
                        answer = answer.substring(0, answer.length()-1);
                        k--;
                    }
                    else {
                        answer += number.charAt(index);
                        break;
                    }
                }
                catch (StringIndexOutOfBoundsException e){
                    answer += number.charAt(index);
                    break;
                }
            }
            if(k==0){
                answer += number.substring(index);
                break;
            }
            index++;
        }
        if(k>0){
            answer = answer.substring(0, index - k);
        }
        return answer;
    }
}