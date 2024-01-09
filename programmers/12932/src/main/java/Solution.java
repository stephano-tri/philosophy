import java.lang.*;
import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(long n) {
        String target = Long.toString(n);
        StringBuilder builderStream = new StringBuilder();
        builderStream.append(target);
        builderStream.reverse();
        String reversedTarget = builderStream.toString();
        long targetIdx = reversedTarget.toCharArray().length;

        int[] answer = new int[(int) targetIdx];

        for(int i = 0 ; i < targetIdx ; i++){
            answer[i] = Character.getNumericValue(reversedTarget.toCharArray()[i]);
        }

        return answer;
    }
}