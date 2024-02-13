import java.util.*;

public class Solution {
    final String[] WORDS = {"A", "E", "I", "O", "U"};
    final int MAX_DEPTH = 5;

    public int solution(String word) {
        int answer = 0;
        ArrayList<String> wordList = new ArrayList<String>();

        // init first dfs
        dfs("" , wordList);

        return wordList.indexOf(word);
    }

    private void dfs(String word, List<String> visited){
        if(word.length() > MAX_DEPTH) return;

        if(!visited.contains(word)) visited.add(word);

        for(String elem : WORDS) {
            dfs(word + elem , visited);
        }
    }
}
