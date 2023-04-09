import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};

        ArrayList<String> ranking = new ArrayList<>();
        HashMap<String, Integer> name = new HashMap<>();
        for(int i=0; i< players.length; i++){
            ranking.add(players[i]);
            name.put(players[i], i);
        }

        for(String i : callings){
            int index = name.get(i);
            Collections.swap(ranking, index-1, index);
            name.replace(ranking.get(index), index);
            name.replace(ranking.get(index-1), index-1);
        }

        return answer = ranking.toArray(new String[players.length]);
    }
}