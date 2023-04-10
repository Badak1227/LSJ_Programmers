
import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] nums = new int[1000001];
        Arrays.fill(nums, 1000001);

        int index = x;
        nums[index] = 0;
        while(index<=y){
            if(index*2<=y){
                nums[index*2] = nums[index*2] < nums[index] + 1 ? nums[index*2] : nums[index] + 1;
            }
            if(index*3<=y){
                nums[index*3] = nums[index*3] < nums[index] + 1 ? nums[index*3] : nums[index] + 1;
            }
            if(index+n<=y){
                nums[index+n] = nums[index+n] < nums[index] + 1 ? nums[index+n] : nums[index] + 1;
            }
            index++;
        }

        answer = nums[y];
        return answer == 1000001 ? -1: answer;
    }
}