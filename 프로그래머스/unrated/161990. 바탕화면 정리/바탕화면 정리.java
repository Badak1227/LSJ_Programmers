class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int row = wallpaper.length, col = wallpaper[0].length();
        int rowMin = row, rowMax = 0, colMin = col, colMax = 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    rowMin = (i<rowMin) ? i : rowMin;
                    rowMax = ((i + 1) > rowMax) ? i + 1 : rowMax;
                    colMin = (j<colMin) ? j : colMin;
                    colMax = ((j + 1) > colMax) ? j + 1 : colMax;
                }
            }
        }
        
        answer[0] = rowMin;
        answer[1] = colMin;
        answer[2] = rowMax;
        answer[3] = colMax;
        
        return answer;
    }
}