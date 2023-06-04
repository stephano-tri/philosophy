import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int N,M;
    static int[] moveX = {0,0,1,-1};
    static int[] moveY = {1,-1,0,0};
    static int component = 0;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N; i++){
            String tmpStr = br.readLine();
            String[] tmpCharArr = tmpStr.split(" ");

            for(int j = 0; j < tmpCharArr.length ; j++) {
                graph[i][j] = Integer.parseInt(tmpCharArr[j]);
            }
        }

        while(true){
            for(int i = 0 ; i < N ; i++){
                Arrays.fill(visited[i], false);
            }

            component = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(graph[i][j] != 0 && !visited[i][j]){
                        bfs(new Coordinate(i,j));
                        component++;
                    }
                }
            }
            if(component > 1){
                break;
            }
            else if(component == 0){
                ans = 0;
                break;
            }

            graph = meltIceberg(graph);
            ans++;
        }

        System.out.println(ans);

    }

    public static void bfs(Coordinate startNode){
        visited[startNode.getX()][startNode.getY()] = true;
        Queue<Coordinate> queue = new LinkedList();
        queue.add(startNode);

        while(!queue.isEmpty()){
            Coordinate curNode = queue.poll();

            for(int i = 0; i < 4; i++){
                int nextXCord = curNode.getX() + moveX[i];
                int nextYCord = curNode.getY() + moveY[i];

                if(nextXCord < 0 || nextYCord < 0 || nextXCord >= N || nextYCord >= M){
                    continue;
                }
                if(visited[nextXCord][nextYCord] || graph[nextXCord][nextYCord] == 0){
                    continue;
                }

                queue.add(new Coordinate(nextXCord, nextYCord));
                visited[nextXCord][nextYCord] = true;
            }
        }

    }

    public static int[][] meltIceberg(int[][] icebergs){
        //make deep copy of icebergs
        int[][] newlyIcebergs = new int[N][M];
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < M ; j ++){
                newlyIcebergs[i][j] = icebergs[i][j];
            }
        }

        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < M ; j ++){
                if(icebergs[i][j] != 0){
                    for(int k = 0 ; k < 4; k++){
                        int nextX = i + moveX[k];
                        int nextY = j + moveY[k];
                        if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                            continue;
                        }

                        if(icebergs[nextX][nextY] == 0){
                            if(newlyIcebergs[i][j] != 0){
                                newlyIcebergs[i][j] -= 1;
                            }
                        }
                    }
                }
            }
        }

        return newlyIcebergs;
    }
}

class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
