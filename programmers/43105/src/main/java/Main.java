import java.util.Arrays;

public class Main {
    static class Solution {
        int[][] mem = new int [501][501];

        public int getMax(int x , int y, int [][] triangle){
            if (triangle.length == y) return 0;
            if (mem[x][y] != -1) return mem[x][y];

            return mem[x][y] = triangle[y][x] +
                        Math.max(
                                getMax(x , y+1 ,triangle),
                                getMax(x + 1 , y+1 , triangle)
                        );
        }

        public int solution(int[][] triangle) {
            Solution sol = new Solution();
            for(int[] row : sol.mem){
                Arrays.fill(row, -1);
            }
            return getMax(0,0, triangle);
        }
    }
}
