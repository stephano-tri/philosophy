import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        String[] arr = br.readLine().split(" ");

        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for(int i = 0 ; i < arr.length; i++){
            arrList.add(Integer.parseInt(arr[i]));
        }

        int [] dp = new int[arrList.size()];

        int LIS = 0;
        dp[LIS++] = arrList.get(0);

        for(int i = 1 ; i< arrList.size(); i++){
            if(dp[LIS-1] < arrList.get(i)){
                dp[LIS++] = arrList.get(i);
            }
            else {
                int targetIdx = Arrays.binarySearch(dp, 0, LIS, arrList.get(i));
                if(targetIdx < 0) {
                    targetIdx = -targetIdx-1;
                }
                dp[targetIdx] = arrList.get(i);
            }
        }
        System.out.println(LIS);
//        System.out.println(Arrays.toString(dp));
    }
}
