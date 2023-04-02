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

        while(burger.size() > index){
            if(index >=3 && burger.get(index) == 1){
                if(burger.get(index-3) == 1 && burger.get(index-2) == 2 && burger.get(index-1) == 3){
                    for(int i=0; i<4; i++){
                        burger.remove(index--);
                    }
                    answer++;
                    continue;
                }
            }
            index++;
        }
        return  answer;
    }
}