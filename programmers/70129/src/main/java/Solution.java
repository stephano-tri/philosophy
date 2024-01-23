import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> zCnt = new ArrayList<Integer>();

    public int[] solution(String s) {
        while(!s.equals("1")){
            s = removeZero(s);
            System.out.println(s);
        }
        // sum all zCnt's element using stream()
        int zSum = zCnt.stream().mapToInt(Integer::intValue).sum();
        int zLength = zCnt.size();

        return new int[]{zLength,zSum};
    }

    public String removeZero(String s){
        StringBuilder result = new StringBuilder();
        int zeroCounter = 0;
        for(char elem : s.toCharArray()){
            if(elem != '0'){
                result.append(elem);
            }
            else {
                zeroCounter++;
            }
        }
        zCnt.add(zeroCounter);
        String targetLength = String.valueOf(result.toString().length());
        //convert decimal to binary string
        return Integer.toBinaryString(Integer.parseInt(targetLength));
    }
}