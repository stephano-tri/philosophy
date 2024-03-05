import java.util.Arrays;

public class Main {

    static class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            Arrays.sort(citations);
            for(int i = 0 ; i < citations.length ; i++){
                int h = citations.length - i;
                if(citations[i] >= h){
                    answer = h;
                    break;
                }
            }
            System.out.println(answer);
            return answer;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        sol.solution(new int[] {3,0,1,6,5} );

    }
}
