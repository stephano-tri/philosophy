import java.util.*;

public class Main {

    // not worked way because it allows 100,000 elements..
   /* static class Solution {
        HashSet<String> permInts = new HashSet<String>();

        public String solution(int[] numbers) {
            String answer = "";

            boolean[] visited = new boolean[numbers.length];

            perm(numbers , "" , 0 , numbers.length, visited);

            ArrayList<String> ints = new ArrayList<>(permInts);

            ints.sort(Collections.reverseOrder());

            return ints.get(0);
        }

        public void perm(int[] numbers, String curr ,int cnt, int cond,boolean[] visited){
            if(cnt == cond) {
                permInts.add(curr);
                return;
            }

            for(int i = 0 ; i < numbers.length ; i++) {
                if(visited[i]) continue;

                visited[i] = true;
                String latestCurr = curr + numbers[i];
                perm(numbers, latestCurr, cnt + 1, cond, visited);
                visited[i] = false;
            }
        }
    }*/

    static class Solution {
        public String solution(int[] numbers) {
            String[] nums = new String[numbers.length];

            for(int i = 0 ; i < numbers.length; i ++){
                nums[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(nums, (t1, t2) -> (t2 + t1).compareTo(t1+ t2) );

            if(nums[0].equals("0")) return "0";
            return String.join("",nums);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[] {6,10,2});
    }
}
