import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        Trie menu = new Trie();

        ArrayList<String> sets = new ArrayList<>();

        for(String i : orders){
            PowerSet.powerset(i, course, sets);
        }

        for(String i : sets){
            menu.insert(i);
        }

        ArrayList<String> result = new ArrayList<>();

        Trie.search(menu, "", 0, result);

        return answer = result.toArray(new String[0]);
    }
}

class Trie{
    Trie(){
        this.freq = 0;
    }
    Map<Character, Trie> next = new HashMap<>();
    int freq = 0;
    static int[] max = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    void insert(String orders){
        Trie tmp = this;

        int deep = 0;

        for(int i=0; i<orders.length(); i++){

            if(tmp.next.get(orders.charAt(i)) != null){
                tmp = tmp.next.get(orders.charAt(i));
            }
            else {
                tmp.next.put(orders.charAt(i), new Trie());
                tmp = tmp.next.get(orders.charAt(i));
            }
            deep = i+1;
        }
        tmp.freq++;

        max[deep] = max[deep] < tmp.freq ? tmp.freq : max[deep];
    }

    static void search(Trie root, String str, int deep, ArrayList<String> result){
        Trie cur = root;

        if(root.freq == max[deep] && root.freq > 1){
            result.add(str);
        }

        for(char i = 'A'; i<='Z'; i++){
            if(cur.next.get(i) != null){
                str += i;
                search(cur.next.get(i), str, deep + 1, result);
                str = str.substring(0, str.length()-1);
            }
        }
    }
}

class PowerSet{
    static void powerset(String str, int[] course, ArrayList<String> sets){

        for(int size : course){
            String tmp = "";
            set(size, 0, tmp, str, sets);
        }
    }

    static void set(int size, int index, String tmp, String str, ArrayList<String> sets){
        if(size == 0){
            char[] arr = tmp.toCharArray();
            Arrays.sort(arr);
            sets.add(new String(arr));
            return;
        }

        for(int i=index; i<str.length(); i++){
            tmp += str.charAt(i);
            set(size - 1, i+1, tmp, str, sets);
            tmp = tmp.substring(0, tmp.length()-1);
        }
    }
}