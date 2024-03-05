import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("Zbcdefg");
    }


    public static class Solution {
        public String solution(String s) {
            StringBuilder answer = new StringBuilder();

            char[] tmpChar = s.toCharArray();
            Arrays.sort(tmpChar);

            for(int i = 0 ; i < tmpChar.length ; i++){
                answer.append(tmpChar[tmpChar.length - 1 - i]);
            }

            System.out.println(answer);
            return answer.toString();
        }
    }
}
