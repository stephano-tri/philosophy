import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null) {
            sb = new StringBuilder();
            int input = Integer.parseInt(str);
            for (int i = 0; i < (int) Math.pow(3, input); i++) {
                sb.append('-');
            }

            solve(0, (int) Math.pow(3, input));
            System.out.println(sb);
        }
    }

    public static void solve(int start, int size) {
        if(size == 1) return;

        int targetLength = size / 3;

        for(int i = start + targetLength ; i < start + targetLength * 2 ; i++){
            sb.setCharAt(i , ' ');
        }

        solve(start, targetLength);
        solve(start + targetLength * 2 , targetLength);
    }
}
