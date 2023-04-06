class Solution {
    public int solution(String s) {
        int answer = 1;

        int count = 0;
        char x = s.charAt(0);
        for(int i=0; i<s.length();i++){
            count += s.charAt(i) == x ? 1 : -1;
            if(count == 0 && i +1 < s.length()){
                x = s.charAt(i+1);
                answer ++;
            }
        }
        return answer;
    }
}