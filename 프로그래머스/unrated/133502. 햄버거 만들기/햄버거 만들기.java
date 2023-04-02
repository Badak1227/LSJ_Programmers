import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        System.out.println();
        ArrayList<Integer> burger = new ArrayList<>();
        for(int i=0; i< ingredient.length; i++){
            burger.add(ingredient[i]);
        }
        int index = 0;

        while(burger.size() - index >=4){

            if(burger.get(index) != 1) {
                index++;
                continue;
            }
            if(burger.get(index + 1) != 2) {
                index++;
                continue;
            }
            if(burger.get(index + 2) != 3) {
                index++;
                continue;
            }
            if(burger.get(index + 3) != 1) {
                index++;
                continue;
            }
            answer++;
           
            for(int i=0; i<4; i++){
                burger.remove(index);
            }
            index -= index < 3 ? index : 3;
        }

        return  answer;
    }
}