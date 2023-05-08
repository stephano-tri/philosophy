import java.util.*;
import java.io.*;

/**
 * @description 미로 찾기 (2178)
 * https://www.acmicpc.net/problem/2178
 */

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int N,M;
    static int[] moveX = {0, 0, 1, -1};
    static int[] moveY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N; i++){
            String tmpStr = br.readLine();
            char[] tmpCharArr = tmpStr.toCharArray();

            for(int j = 0; j < tmpCharArr.length ; j++) {
                graph[i][j] = Character.getNumericValue(tmpCharArr[j]);
            }
        }
        visited[0][0] = true;
        bfsInit(0,0);

        System.out.println(graph[N-1][M-1]);
    }

    public static void bfsInit(int x, int y){
        Queue<Cordinate> queue = new LinkedList();
        visited[x][y] = true;

        queue.add(new Cordinate(x,y));

        while(!queue.isEmpty()){
            Cordinate curNode = queue.poll();

            for(int i = 0; i < 4; i++){
                int nextXCord = curNode.getX() + moveX[i];
                int nextYCord = curNode.getY() + moveY[i];

                if(nextXCord < 0 || nextYCord < 0 || nextXCord >= N || nextYCord >= M){
                    continue;
                }
                if(visited[nextXCord][nextYCord] || graph[nextXCord][nextYCord] == 0){
                    continue;
                }

                queue.add(new Cordinate(nextXCord, nextYCord));
                graph[nextXCord][nextYCord] = graph[curNode.getX()][curNode.getY()] + 1;
                visited[nextXCord][nextYCord] = true;
            }

        }
    }
}

class Cordinate {
    private int x;
    private int y;

    public Cordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
}

