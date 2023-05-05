public class DFS {
    public static void dfs(int[][] graph, int startNode){
        boolean[] visited = new boolean[graph.length];
        dfsRecursive(graph, startNode, visited);
    }

    public static void dfsRecursive(int[][] graph, int node, boolean[] visited){
        visited[node] = true;
        System.out.print(node + " ");

        for(int i = 0; i < graph[0].length ; i++){
            if(graph[node][i] == 1 && !visited[i]){
                dfsRecursive(graph, i, visited);
            }
        }

    }
}
