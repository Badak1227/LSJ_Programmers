import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int main = 1;
        Stack<Integer> sContainer = new Stack<>();

        int index = 0;
        while(index < order.length){
            while(order[index] > main){
                sContainer.push(main);
                main++;
            }

            if(main == order[index]){
                main++;
                index++;
            }
            else if(sContainer.peek() == order[index]){
                sContainer.pop();
                index++;
            }
            else{
                break;
            }
        }

        return answer = index;
    }
}