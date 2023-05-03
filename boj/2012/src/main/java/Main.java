import java.util.*;

/**
 * @description 등수 매기기 (2012)
 * https://www.acmicpc.net/problem/2012
 */


public class Main {
    public static void main(String[] args) {
        Long complainScore = 0L;

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = scan.nextInt();
        }

        // to sort rank for calculate complain score
        Arrays.sort(rank);

        for (int i = 0; i < n; i++) {
            complainScore += Math.abs(rank[i] - (i + 1));
        }

        System.out.println(complainScore);
        scan.close();
    }
}
