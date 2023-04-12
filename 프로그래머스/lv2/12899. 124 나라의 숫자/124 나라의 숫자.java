import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        Stack<String> stack = new Stack<>();
        do{
            int tmp = n%3;
            switch (tmp){
                case 1:
                    stack.push("1");
                    break;
                case 2:
                    stack.push("2");
                    break;
                case 0:
                    stack.push("4");
            }
            n = (n-1)/3;

        }while(n>0);
        while(!stack.empty()){
            answer += stack.pop();
        }
        return answer;
    }
}