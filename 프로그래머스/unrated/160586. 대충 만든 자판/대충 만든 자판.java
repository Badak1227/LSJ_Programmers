import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int targetsLen = targets.length;
        int keyLen = keymap.length;
        int[] answer = new int[targetsLen];
        Arrays.fill(answer, 0);

        HashMap<Character, Integer> keyMap = new HashMap<>();
        for(int i=0; i<keyLen; i++){
            for(int j=0; j<keymap[i].length(); j++){
                char key = keymap[i].charAt(j);
                if(keyMap.get(key) == null){
                    keyMap.put(key, j+1);
                    continue;
                }
                if(keyMap.get(key) > j+1){
                    keyMap.put(key, j+1);
                }
            }
        }

        for(int i=0; i<targetsLen; i++){
            for(int j=0; j<targets[i].length(); j++){
                if(keyMap.get(targets[i].charAt(j)) == null){
                    answer[i] = -1;
                    break;
                }
                answer[i] += keyMap.get(targets[i].charAt(j));
            }
        }
        
        return answer;
    }
}