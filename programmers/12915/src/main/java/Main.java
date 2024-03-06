import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static class Solution {
        public String[] solution(String[] strings, int n) {
            String[] answer = {};

            Arrays.sort(strings, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.charAt(n) - '0' < o2.charAt(n) - '0'){
                        return -1;
                    }
                    else if(o1.charAt(n) - '0' == o2.charAt(n) - '0'){
                        return o1.compareTo(o2);
                    }
                    else {
                        return 1;
                    }
                }
            });

            return strings;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{"sun", "bed", "car"}, 1)));
    }
}
