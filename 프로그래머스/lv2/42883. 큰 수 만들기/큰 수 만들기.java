import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";

        Stack<Character> nums = new Stack<>();
        int i = 0;
        while(i < number.length()){
            char tmp = number.charAt(i);
            while(k>0 && !nums.empty() && nums.peek() < tmp){
                nums.pop();
                k--;
            }
            nums.push(tmp);
            i++;
        }

        for(int j=0; j<nums.size() - k; j++){
            answer += nums.get(j);
        }
        return answer;
    }
}