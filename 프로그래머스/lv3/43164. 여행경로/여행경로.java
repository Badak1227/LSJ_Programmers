import java.util.*;

class Solution {
    
    static void findPath(String[] answer, int idx, ArrayList<String[]> path, String cur){
        answer[idx] = cur;

        for(int i=0; i<path.size() && answer[answer.length -1] == null; i++){
            String[] next = path.get(i);

            if(next[0].equals(cur)){
                path.remove(i);
                findPath(answer, idx+1, path, next[1]);
                path.add(i, next);
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];

        ArrayList<String[]> path = new ArrayList<>();

        for(String[] i: tickets){
            path.add(i);
        }

        path.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });



        for(String[] i: path){
            System.out.println(i[0] + " " + i[1]);
        }

        findPath(answer, 0, path, "ICN");

        return answer;
    }
}