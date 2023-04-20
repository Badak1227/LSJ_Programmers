class Solution {
    static int[][] sumArr(int[][] arr){
        int arrSize = arr.length;

        int[][] sumArr = new int[arrSize][arrSize];

        for(int i=0;i<arrSize;i++){
            if(i==0){
                sumArr[0][i] = arr[0][i];
                continue;
            }
            sumArr[0][i] = sumArr[0][i-1] + arr[0][i];
        }
        for(int i=0;i<arrSize;i++){
            if(i==0){
                sumArr[i][0] = arr[i][0];
                continue;
            }
            sumArr[i][0] = sumArr[i-1][0] + arr[i][0];
        }
        for(int i=1;i<arrSize;i++){
            for(int j=1;j<arrSize;j++){
                sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] + arr[i][j];
            }
        }
        return sumArr;
    }
    
    static int[] process(int[][] sumArr, int[] start, int[] end, int[] answer){
        int size = (end[0] - start[0] + 1)*(end[1] - start[1] + 1);

        if(size == 0) return answer;

        int sum = 0;
        if(start[0] == 0 && start[1] ==0){
            sum = sumArr[end[0]][end[1]];
        }
        else if(start[0] == 0){
            sum = sumArr[end[0]][end[1]] - sumArr[end[0]][start[1] - 1];
        }
        else if(start[1] == 0){
            sum = sumArr[end[0]][end[1]] - sumArr[start[0] - 1][end[1]];
        }
        else{
            sum = sumArr[end[0]][end[1]] - sumArr[start[0] - 1][end[1]] - sumArr[end[0]][start[1] - 1] + sumArr[start[0] - 1][start[1] - 1];
        }

        if(sum == size){
            answer[1]++;
        }
        else if(sum == 0){
            answer[0]++;
        }
        else{
            answer = process(sumArr, new int[] {start[0], start[1]}, new int[] {start[0] + (end[0] - start[0] )/ 2, start[1] + (end[1] - start[1])/ 2}, answer);
            answer = process(sumArr, new int[] {start[0], start[1] + (end[1] - start[1])/ 2+ 1}, new int[] {start[0] + (end[0] - start[0])/ 2, end[1]}, answer);
            answer = process(sumArr, new int[] {start[0] + (end[0] - start[0])/ 2 + 1, start[1]}, new int[] {end[0], start[1] + (end[1] - start[1])/ 2 }, answer);
            answer = process(sumArr, new int[] {start[0] + (end[0] - start[0])/ 2 + 1, start[1] + (end[1] - start[1])/ 2 + 1}, new int[] {end[0], end[1]}, answer);
        }

        return answer;
    }

    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};

        int arrSize = arr.length;
        int[][] sumArr = sumArr(arr);
        int[] start = {0,0};
        int[] end = {arrSize -1, arrSize -1};
        answer = process(sumArr, start, end, answer);

        return answer;
    }
}