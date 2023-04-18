import java.util.*;

class Solution {
    public static String solution(String p) {
        String answer = "";
        Stack<Character> pare = new Stack<>();

        answer = div(p);

        return answer;
    }

    static String div(String p){
        if(p.equals("")) return "";

        String p1 = new String("");
        String p2 = new String("");

        int status = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                status++;
            }
            else{
                status--;
            }

            if(status == 0) {
                p1 = p.substring(0, i + 1);
                p2 = p.substring(i + 1);
                break;
            }
        }

        if(balanced(p1)){
            p2 = div(p2);
            p = p1 + p2;
        }
        else{
            p2 = div(p2);

            p1 = p1.substring(1, p1.length()-1);
            p1 = p1.replace("(", "a");
            p1 = p1.replace(")", "(");
            p1 = p1.replace("a", ")");
            p = "(" + p2 + ")" + p1;
        }

        return p;
    }

    static boolean balanced(String p){
        Stack<Character> par = new Stack<>();
        boolean result = true;

        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                par.push('(');
            }
            else {
                if(par.isEmpty()){
                    return false;
                }
                else if(par.peek() == '('){
                    par.pop();
                }
                else{
                    return false;
                }
            }
        }

        return  par.isEmpty() ? result : false;
    }
}