import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int id_len = id_list.length;
        int report_len = report.length;
        int[] answer = new int[id_len];

        //id이름과 index 매칭
        HashMap<String, Integer> id = new HashMap<>();
        for(int i=0; i<id_len; i++){
            id.put(id_list[i], i);
        }

        //신고 중복 제거
        List<String> report_recruit= new ArrayList<>(new HashSet<>(Arrays.asList(report)));

        //키: 신고받은사람, 벨류: 신고한사람
        HashMap<String, ArrayList<String>> reported = new HashMap<String, ArrayList<String>>();
        for(int i=0; i<id_len; i++){
            reported.put(id_list[i], new ArrayList<String>());
        }

        //신고받은사람 - 신고한 사람 매칭
        for(int i=0; i< report_recruit.size(); i++){
            String[] member = report_recruit.get(i).split(" ");
            reported.get(member[1]).add(member[0]);
        }
        
        //신고접수 성공한 횟수 입력
        for(int i=0; i<id_len; i++){
            List<String> reporter = reported.get(id_list[i]);
            if(reporter.size() >= k){
                for(int j=0; j<reporter.size(); j++){
                    answer[id.get(reporter.get(j))]++;
                }
            }
        }
        return answer;
    }
}