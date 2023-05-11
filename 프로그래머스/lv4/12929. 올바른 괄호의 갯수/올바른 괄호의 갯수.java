import java.util.*;

class Solution {
    static int result = 0;
    static void test(Stack<Character> stack, int level, int height, int left, int right){
        
        if(level == height){
            result++;
            return;
        };

        if(left < height/2){
            stack.add('(');
            test(stack, level+1, height, left + 1, right);
            stack.pop();
        }

        if(!stack.isEmpty() && right < height/2){
            stack.pop();
            test(stack, level+1, height, left, right + 1);
            stack.add('(');
        }

    }
    public int solution(int n) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        test(stack, 0, n*2, 0, 0);


        return answer = result;
    }
}