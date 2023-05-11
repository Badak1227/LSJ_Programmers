import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = Arrays.toString(numbers).replaceAll("[ \\[ \\] ]", "").split(",");

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String tmp1 = o1 + o2;
                String tmp2 = o2 + o1;

                return tmp2.compareTo(tmp1);
            }
        });

        for(String i: nums){
            answer += i;
        }

        if(answer.charAt(0) == '0') return "0";

        return answer;
    }
}