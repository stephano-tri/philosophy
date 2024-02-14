import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");


        System.out.println(solve(input[0] , input[1]));
    }

    public static int solve(String src, String tgt) {
        int min = 50;

        for(int i = 0 ; i <= tgt.length() - src.length() ; i++){
            int cnt = 0;
            for(int j = 0 ; j < src.length() ; j ++){
                if (src.charAt(j) != tgt.charAt(i + j)) cnt++;
            }
            min = Math.min(cnt,min);
        }

        return min;
    }
}
