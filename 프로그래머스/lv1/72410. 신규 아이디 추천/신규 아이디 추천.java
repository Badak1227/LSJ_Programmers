class Solution {
    public String solution(String new_id) {
        String answer = new_id;

        //lv1
        answer = answer.toLowerCase();

        //lv2
        answer = answer.replaceAll("[^a-z0-9-._]", "");

        //lv3
        answer = answer.replaceAll("\\.+", ".");

        //lv4
        answer = answer.replaceAll("^\\.|\\.$", "");
        
        //lv5
        if(answer.equals("")){
            answer += 'a';
        }


        //lv6
        if(answer.length()>15){
            answer = answer.charAt(14) == '.' ? answer.substring(0, 14) : answer.substring(0, 15);
        }

        //lv7
        while(answer.length()<3){
            answer += answer.charAt(answer.length()-1);
        }

        return answer;
    }
}