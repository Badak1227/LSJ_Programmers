import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        int sLen = s.length();
        int skipLen = skip.length();
        String answer = "";

        List<Character> alphabet = new ArrayList<>();
        for(int i=0; i<26; i++){
            alphabet.add((char)('a' + i));
        }

        List<Character> skipA = new ArrayList<>();
        for(int i=0; i< skipLen; i++) {
            skipA.add(skip.charAt(i));
        }

        for(int i=25; i >= 0; i--){
            if(skipA.contains(alphabet.get(i))){
                alphabet.remove(i);
            }
        }

        HashMap<Character, Integer> alphabetMap = new HashMap<>();
        for(int i=0; i< alphabet.size(); i++){
            alphabetMap.put(alphabet.get(i), i);
        }

        for(int i=0; i<sLen; i++){
            answer += alphabet.get((alphabetMap.get(s.charAt(i)) + index) % alphabet.size());
        }

        return  answer;
    }
}