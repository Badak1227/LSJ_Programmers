class Solution {
    public int[] solution(String[] park, String[] routes) {
        int H = park.length - 1, W = park[0].length() - 1;
        int[] pos = {0, 0};

        for(int i=0; i<=H; i++){
            for(int j=0; j<=W; j++){
                if(park[i].charAt(j) == 'S'){
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }

        for(int i=0; i< routes.length; i++){
            int moves = Character.getNumericValue(routes[i].charAt(2));
            switch (routes[i].charAt(0)){
                case 'E':
                    if(pos[1] + moves > W){
                        break;
                    }
                    for(int j=1; j <= moves; j++){
                        if(park[pos[0]].charAt(pos[1] + j) == 'X'){
                            pos[1] -= moves;
                            break;
                        }
                    }
                    pos[1] += moves;
                    break;

                case 'W':
                    if(pos[1] - moves < 0){
                        break;
                    }
                    for(int j=1; j <= moves; j++){
                        if(park[pos[0]].charAt(pos[1] - j) == 'X'){
                            pos[1] += moves;
                            break;
                        }
                    }
                    pos[1] -= moves;
                    break;

                case 'S':
                    if(pos[0] + moves > H){
                        break;
                    }
                    for(int j=1; j <= moves; j++){
                        if(park[pos[0] + j].charAt(pos[1]) == 'X'){
                            pos[0] -= moves;
                            break;
                        }
                    }
                    pos[0] += moves;
                    break;

                case 'N':
                    if(pos[0] - moves < 0){
                        break;
                    }
                    for(int j=1; j <= moves; j++){
                        if(park[pos[0] - j].charAt(pos[1]) == 'X'){
                            pos[0] += moves;
                            break;
                        }
                    }
                    pos[0] -= moves;
                    break;

            }
        }

        return pos;
    }
}