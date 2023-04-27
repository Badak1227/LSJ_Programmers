import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        m = m.replace("C#", "I");
        m = m.replace("D#", "J");
        m = m.replace("F#", "K");
        m = m.replace("G#", "N");
        m = m.replace("A#", "L");
        
        ArrayList<String> name = new ArrayList<>();
        HashMap<String, Integer> playTime = new HashMap<>();
        HashMap<String, String> code = new HashMap<>();

        for(int i=0; i< musicinfos.length; i++){
            String[] tmp = musicinfos[i].split(",");

            tmp[3] = tmp[3].replace("C#", "I");
            tmp[3] = tmp[3].replace("D#", "J");
            tmp[3] = tmp[3].replace("F#", "K");
            tmp[3] = tmp[3].replace("G#", "N");
            tmp[3] = tmp[3].replace("A#", "L");
            
            
            //Name
            name.add(tmp[2]);

            // NAME: PLAYTIME
            LocalTime start = LocalTime.parse(tmp[0], DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime end = LocalTime.parse(tmp[1], DateTimeFormatter.ofPattern("HH:mm"));
            playTime.put(tmp[2], (int) ChronoUnit.MINUTES.between(start, end));

            // NAME: CODE
            int pTime = playTime.get(tmp[2]);
            while(tmp[3].length() < pTime){
                tmp[3] += tmp[3];
            }
            code.put(tmp[2], tmp[3].substring(0, pTime));
        }

        for(String i : name){
            if(code.get(i).contains(m)){
                if(!answer.equals("(None)")){
                    answer = playTime.get(answer) < playTime.get(i) ? i : answer;
                }
                else{
                    answer = i;
                }
            }
        }

        return answer;
    }
}