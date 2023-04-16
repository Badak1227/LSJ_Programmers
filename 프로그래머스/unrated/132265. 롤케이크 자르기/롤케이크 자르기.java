import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for(int j : topping){
            list.add(j);
        };

        HashMap<Integer, Integer> p1 = new HashMap<>();
        HashMap<Integer, Integer> p2 = new HashMap<>();

        for(int i=0; i< topping.length; i++){
            if(p2.get(topping[i])==null){
                p2.put(topping[i], 1);
            }
            else{
                p2.replace(topping[i], p2.get(topping[i]) + 1);
            }
        }

        for(int i=0; i< topping.length; i++){
            if(p1.get(topping[i])==null){
                p1.put(topping[i], 1);
                p2.replace(topping[i], p2.get(topping[i]) - 1);
                if(p2.get(topping[i]) == 0){
                    p2.remove(topping[i]);
                }
            }
            else{
                p2.replace(topping[i], p2.get(topping[i]) - 1);
                if(p2.get(topping[i]) == 0){
                    p2.remove(topping[i]);
                }
            }

            if(p1.size() == p2.size()){
                answer++;
            }
        }
        
        return answer;
    }
}