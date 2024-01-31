import java.util.ArrayList;
import java.util.List;

class Solution {
    //declare doubled array and initialize it with [0,0].
    //then, fill the array with the given number.
    //finally, return the array.

    List<List<Integer>> trace = new ArrayList<List<Integer>>();

    public List<Integer> move(int from, int to){
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(from);
        ret.add(to);
        return ret;
    }

    public void hanoi(int n, int from, int by, int to){
        if(n == 1){
            return;
        }
        hanoi(n-1, from, to, by);
        trace.add(move(from,to));
        hanoi(n-1, by, from, to);
    }

    public int[][] solution(int n) {
        //convert List<List<Integer>> to int[][]
        hanoi(n + 1,1,2,3);
        int[][] answer = new int[trace.size()][2];
        for(int i = 0 ; i < trace.size() ; i++){
            answer[i][0] = trace.get(i).get(0);
            answer[i][1] = trace.get(i).get(1);
        }

        return answer;
    }
}