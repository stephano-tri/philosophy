import java.util.*;
class Solution {
    int [][] snail_map;
    int [] dx = {1, 0, -1};
    int [] dy = {0, 1, -1};

    public void setSnailMap(int n){
        snail_map = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(snail_map[i], 0);
        }
    }

    public int[] getSnailMap(int n){
        int [] answer = new int[n * n];

        // print snail_map without 0
        for(int i = 0; i < snail_map.length; i++){
            for(int j = 0; j < snail_map[i].length; j++){
                if(snail_map[i][j] != 0){
                    answer[(i * n) + j] = snail_map[i][j];
                }
            }
        }

        // delete 0 in answer[]
        answer = Arrays.stream(answer).filter(i -> i != 0).toArray();

        return answer;
    }

    public int[] solution(int n) {
        //make snail map
        setSnailMap(n);

        //start point is (0,0)
        while(true) {
            int x = 0;
            int y = 0;
            int dir = 0;
            int num = 1;
            snail_map[x][y] = num;

            while (true) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || snail_map[nx][ny] != 0) {
                    dir = (dir + 1) % 3;
                    nx = x + dx[dir];
                    ny = y + dy[dir];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || snail_map[nx][ny] != 0) {
                        break;
                    }
                }

                num++;
                snail_map[nx][ny] = num;
                x = nx;
                y = ny;
            }

            if(num == n * (n + 1) / 2){
                break;
            }
        }

        int[] answer = getSnailMap(n);
        return answer;
    }

}