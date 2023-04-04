import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int RT = 0, CF = 0, JM = 0, AN = 0;
        
        HashMap<Character, Integer> ch2 = new HashMap<>();
        ch2.put('R', 1);
        ch2.put('T', -1);
        ch2.put('C', 1);
        ch2.put('F', -1);
        ch2.put('J', 1);
        ch2.put('M', -1);
        ch2.put('A', 1);
        ch2.put('N', -1);

        for(int i=0; i<choices.length; i++){
            choices[i] -= 4;
        }

        for(int i = 0; i<survey.length; i++){
            switch (survey[i].charAt(0)){
                case 'R': case 'T':
                    RT += choices[i]*ch2.get(survey[i].charAt(0));
                    break;
                case 'C': case 'F':
                    CF += choices[i]*ch2.get(survey[i].charAt(0));
                    break;
                case 'J': case 'M':
                    JM += choices[i]*ch2.get(survey[i].charAt(0));
                    break;
                case 'A': case 'N':
                    AN += choices[i]*ch2.get(survey[i].charAt(0));
                    break;
            }
        }

        answer += RT <= 0 ? "R" : "T";
        answer += CF <= 0 ? "C" : "F";
        answer += JM <= 0 ? "J" : "M";
        answer += AN <= 0 ? "A" : "N";
        return answer;
    }
}