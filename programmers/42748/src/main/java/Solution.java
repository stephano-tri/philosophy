import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public int getNthNumber(int[] arr, int[] command){
        int[] slicedArr = Arrays.copyOfRange(arr , command[0]-1 , command[1]);

        List<Integer> arrList = Arrays.stream(slicedArr)
                .boxed().sorted().collect(Collectors.toCollection(ArrayList::new));
        return arrList.get(command[2]-1);
    }
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for(int [] command : commands){
            answer.add(getNthNumber(array, command));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}