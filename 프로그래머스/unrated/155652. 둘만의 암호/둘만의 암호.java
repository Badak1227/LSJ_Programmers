import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        int sLen = s.length();
        int skipLen = skip.length();
        String answer = "";

        char[] sLetter = s.toCharArray();
        for(int i=0; i<sLetter.length; i++){
            char tmp = sLetter[i];
            for(int j = 0; j<index; j++){
                tmp = tmp == 'z' ? 'a' : (char) (tmp + 1);
                if(skip.contains(String.valueOf(tmp))){
                    j--;
                }
            }
            answer += tmp;
        }

        return  answer;
    }
}