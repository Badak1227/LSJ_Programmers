import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayTime = LocalDate.parse(today, format);
        System.out.println(todayTime);

        HashMap<String, Integer> termsMap = new HashMap<>();
        for(int i=0; i < terms.length; i++){
            String[] tmpTerms = terms[i].split(" ");
            termsMap.put(tmpTerms[0], Integer.parseInt(tmpTerms[1]));
        }

        List<Integer> remove = new ArrayList<>();
        for(int i=0; i < privacies.length; i++){
            String[] tmpTerms = privacies[i].split(" ");

            String alphabet = tmpTerms[1];
            LocalDate privateTime = LocalDate.parse(tmpTerms[0], format);
            privateTime = privateTime.plusMonths(termsMap.get(alphabet)).minusDays(1);
            System.out.println(privateTime);

            if(todayTime.isAfter(privateTime)){
                remove.add(i + 1);
            }
        }

        int[] answer = new int[remove.size()];
        for(int i=0; i < answer.length; i++){
            answer[i] = remove.get(i).intValue();
        }

        return answer;
    }
}