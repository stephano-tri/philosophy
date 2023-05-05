public class Main {
    public static void main(String[] args) {
        BFS bfs = new BFS();
        BFS.bfs(new int[][]{
                                  {0,1,1,0,1},
                                  {1,0,1,0,0},
                                  {1,1,0,1,1},
                                  {0,0,1,0,1},
                                  {1,0,1,1,0},
        }, 0, true);

        DFS dfs = new DFS();
        DFS.dfs(new int[][]{
                {0,1,1,0,1},
                {1,0,1,0,0},
                {1,1,0,1,1},
                {0,0,1,0,1},
                {1,0,1,1,0},
        }, 0);

        System.out.println("You know it is LIFE");
    }
}
