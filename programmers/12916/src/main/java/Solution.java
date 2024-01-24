import java.util.Locale;

class Solution {
    boolean solution(String s) {
        int pCnt = 0; int yCnt = 0;
        s = s.toLowerCase(Locale.ROOT);
        for(char elem : s.toCharArray()){
            if (elem == 'p') pCnt ++;
            else if(elem == 'y') yCnt ++;
        }
        return pCnt == yCnt;
    }
}