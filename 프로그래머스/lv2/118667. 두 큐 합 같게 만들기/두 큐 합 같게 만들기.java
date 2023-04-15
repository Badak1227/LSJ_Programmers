import java.util.*;

class Solution {
    public long solution(int[] queue1, int[] queue2) {
        long answer = 0;
        long sum1 = 0, sum2 = 0, size = queue1.length;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=0; i<queue1.length; i++){
            sum1 += queue1[i];
            q1.add(queue1[i]);
        }
        for(int i=0; i<queue1.length; i++){
            sum2 += queue2[i];
            q2.add(queue2[i]);
        }

        while(sum1 != sum2){
            if(sum1 < sum2){
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.add(q2.poll());
                answer++;
            }
            else{
                sum2 += q1.peek();
                sum1 -= q1.peek();
                q2.add(q1.poll());
                answer++;
            }
            
            if(answer > size*4){
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}